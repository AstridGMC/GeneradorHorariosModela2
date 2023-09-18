/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import Backend.AUXILIARES.ProfesorCursoCoinciden;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Profesor {
    int idProfesor;
    String nombre;
    LocalTime horaEntrada;
    LocalTime horaSalida;
    ArrayList<CursoProfesor> cursosPrimarios;
    ArrayList<CursoProfesor> cursosSecundarios;
    ArrayList<CursoProfesor> cursosAuxiliares;
    
    ArrayList<Periodo> periodosProfesor;
    boolean descanso;

    public Profesor(int idProfesor, String nombre, LocalTime horaEntrada, LocalTime horaSalida, ArrayList<CursoProfesor> cursosPrimarios, ArrayList<CursoProfesor> cursosSecundarios, ArrayList<CursoProfesor> cursosAuxiliares, boolean descanso) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.cursosPrimarios = cursosPrimarios;
        this.cursosSecundarios = cursosSecundarios;
        this.cursosAuxiliares = cursosAuxiliares;
        this.descanso= descanso;
    }

    public Profesor() {
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public ArrayList<CursoProfesor> getCursosPrimarios() {
        return cursosPrimarios;
    }

    public void setCursosPrimarios(ArrayList<CursoProfesor> cursosPrimarios) {
        this.cursosPrimarios = cursosPrimarios;
    }

    public ArrayList<CursoProfesor> getCursosSecundarios() {
        return cursosSecundarios;
    }

    public void setCursosSecundarios(ArrayList<CursoProfesor> cursosSecundarios) {
        this.cursosSecundarios = cursosSecundarios;
    }

    public ArrayList<CursoProfesor> getCursosAuxiliares() {
        
        return cursosAuxiliares;
    }

    public void setCursosAuxiliares(ArrayList<CursoProfesor> cursosAuxiliares) {
        this.cursosAuxiliares = cursosAuxiliares;
    }

    public boolean isDescanso() {
        return descanso;
    }

    public void setDescanso(boolean descanso) {
        this.descanso = descanso;
    }

    public ArrayList<Periodo> getPeriodosProfesor() {
        return periodosProfesor;
    }

    public void setPeriodosProfesor(ArrayList<Periodo> periodosProfesor) {
        this.periodosProfesor = periodosProfesor;
    }
    
    
    
    public  ArrayList<Profesor> ProfesoresListado(Connection conexion){
        PreparedStatement ps1;
        ResultSet rs;
        Profesor profesor;
        ArrayList<Profesor> profesores = new ArrayList<>();
            String sql = "SELECT * FROM Profesor";
            //String sql1 = "SELECT * FROM Profesores JOIN CursoProfesor ON Profesores.idProfesor = CursoProfesor.idProfesor";
        try {
            ps1 = conexion.prepareStatement(sql);
            rs = ps1.executeQuery();

            while (rs.next()) {
                profesor = new Profesor();
                profesor.setNombre(rs.getString("nombre"));
                profesor.setIdProfesor(rs.getInt("idProfesor"));
                profesor.setHoraEntrada(LocalTime.parse(rs.getString("horaInicio")));
                profesor.setDescanso(rs.getBoolean("descanso"));
                profesor.setHoraSalida(LocalTime.parse(rs.getString("horaFin")));
                Curso curso = new Curso();
                profesor.setCursosAuxiliares(curso.ObtenerCursosAuxiliaresProfesor(idProfesor, conexion));
                profesor.setCursosPrimarios(curso.ObtenerCursosPrimariosProfesor(idProfesor,conexion));
                profesor.setCursosSecundarios(curso.ObtenerCursosSecundariosProfesor(idProfesor,conexion));

                profesores.add(profesor);
            }
        } catch (SQLException e) {
            System.out.println("no se encontraron servicios " + e);
        }
        
        return profesores;
    }
    
    
    
    public Profesor BuscarProfesor(Connection conexion, int idProfesor){
        PreparedStatement ps1;
        ResultSet rs;
        Profesor  profesor = new Profesor();
       
            String sql = "SELECT * FROM Profesor WHERE idProfesor = "+ idProfesor;
            //String sql1 = "SELECT * FROM Profesores JOIN CursoProfesor ON Profesores.idProfesor = CursoProfesor.idProfesor";
        try {
            ps1 = conexion.prepareStatement(sql);
            rs = ps1.executeQuery();

            while (rs.next()) {
               
                profesor.setNombre(rs.getString("nombre"));
                profesor.setIdProfesor(rs.getInt("idProfesor"));
                profesor.setHoraEntrada(LocalTime.parse(rs.getString("horaInicio")));
                profesor.setDescanso(rs.getBoolean("descanso"));
                profesor.setHoraSalida(LocalTime.parse(rs.getString("horaFin")));
                Curso curso = new Curso();
                profesor.setCursosAuxiliares(curso.ObtenerCursosAuxiliaresProfesor(profesor.getIdProfesor(), conexion));
                profesor.setCursosPrimarios(curso.ObtenerCursosPrimariosProfesor(profesor.getIdProfesor(),conexion));
                profesor.setCursosSecundarios(curso.ObtenerCursosSecundariosProfesor(profesor.getIdProfesor(),conexion));
            
            }
        } catch (SQLException e) {
            System.out.println("no se encontraron servicios " + e);
        }
        return profesor;
    }
    
    public  ArrayList<ProfesorCursoCoinciden> buscarCursoProfesor(ArrayList<Profesor> profesores, int idCurso){
        ArrayList<ProfesorCursoCoinciden> profesoresCoinciden= new ArrayList();
        for (int i = 0; i < profesores.size(); i++) {
            for (int j = 0; j < profesores.get(i).getCursosPrimarios().size(); j++) {
                CursoProfesor cursoProfe =profesores.get(i).getCursosPrimarios().get(j);
                if(cursoProfe.getIdCurso()==idCurso){
                    //Profesor , int idCurso, int indice, String tipo
                    ProfesorCursoCoinciden profCoin = new ProfesorCursoCoinciden(profesores.get(i), idCurso,j,"Primario");
                    profesoresCoinciden.add(profCoin);
                }
            }
            for (int j = 0; j < profesores.get(i).getCursosSecundarios().size(); j++) {
                CursoProfesor cursoProfe =profesores.get(i).getCursosSecundarios().get(j);
                if(cursoProfe.getIdCurso()== idCurso){
                    ProfesorCursoCoinciden profCoin = new ProfesorCursoCoinciden(profesores.get(i), idCurso,j,"Secundario");
                    profesoresCoinciden.add(profCoin);
                }
            }
            for (int j = 0; j < profesores.get(i).getCursosAuxiliares().size(); j++) {
                CursoProfesor cursoProfe =profesores.get(i).getCursosAuxiliares().get(j);
                if(cursoProfe.getIdCurso()== idCurso){
                    ProfesorCursoCoinciden profCoin = new ProfesorCursoCoinciden(profesores.get(i), idCurso,j,"Auxiliar");
                    profesoresCoinciden.add(profCoin);
                }
            }
            
        }
        return profesoresCoinciden;
    }
    
    
    public ArrayList<Profesor> profesorHorario(ArrayList<Profesor> profesoresList, LocalTime HoraInicio){
        ArrayList<Profesor> profesores = new ArrayList();
        for (int i = 0; i < profesoresList.size(); i++) {
            for (int j = 0; j < profesoresList.get(i).periodosProfesor.size(); j++) {
                if(profesoresList.get(i).periodosProfesor.get(j).inicio.equals(HoraInicio)){
                                   // System.out.println(profesoresList.get(i).periodosProfesor.get(j).inicio+"-------es igual?---------"+HoraInicio+"     i="+i+"    j="+j);

                    //System.out.println("si");
                    profesores.add(profesoresList.get(i));
                }
            }
        }
        return profesores;
    }
    
    public boolean HorarioLleno(){
        return false;
    }
    
     public int retornarIndiceHorarioProfesor(Profesor profesor, LocalTime horaInicio){
            for (int j = 0; j < profesor.getPeriodosProfesor().size(); j++) {
                if(profesor.getPeriodosProfesor().get(j).inicio.equals(horaInicio)){
                    return j;
                }else{
                    return -1;
                }
           
        }
            return -1;
    }
     
      public boolean retornarDisponibilidadHorarioProfesor(Profesor profesor,int indiceHorario){
            for (int j = 0; j < profesor.getPeriodosProfesor().size(); j++) {
                if(profesor.getPeriodosProfesor().get(j).ocupado){
                    return false;
                }else{
                    return true;
                }
           
        }
            return false;
    }
    
}
