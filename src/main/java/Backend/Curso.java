/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Curso {
    int idCurso;
    String nombreCurso;
    String carrera;
    int tipoSemestre;
    int semestre;
    LocalTime horaGenerada;
    Salon salonAsignado;
    boolean horarioAsignado=false;

    public Curso(String nombreCurso, int idCurso, String carrera) {
        this.nombreCurso = nombreCurso;
        this.idCurso = idCurso;
        this.carrera = carrera;
    }

   public  Curso() {
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public LocalTime getHoraGenerada() {
        return horaGenerada;
    }

    public void setHoraGenerada(LocalTime horaGenerada) {
        this.horaGenerada = horaGenerada;
    }

    public Salon getSalonAsignado() {
        return salonAsignado;
    }

    public void setSalonAsignado(Salon salonAsignado) {
        this.salonAsignado = salonAsignado;
    }

    public int getTipoSemestre() {
        return tipoSemestre;
    }

    public void setTipoSemestre(int tipoSemestre) {
        this.tipoSemestre = tipoSemestre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public boolean isHorarioAsignado() {
        return horarioAsignado;
    }

    public void setHorarioAsignado(boolean horarioAsignado) {
        this.horarioAsignado = horarioAsignado;
    }
       
    
    
    
    public ArrayList<CursoProfesor> ObtenerCursosAuxiliaresProfesor(int idProfesor,Connection conexion ){
        ArrayList<CursoProfesor> cursosAux= new ArrayList();
        PreparedStatement ps1;
        ResultSet rs;
        CursoProfesor cprofesor;
        String sql = "SELECT * FROM Profesor JOIN CursoProfesor ON Profesor.idProfesor = CursoProfesor.idProfesor JOIN Cursos  ON CursoProfesor.idCurso =  Cursos.idCurso  WHERE Profesor.idProfesor = "
                +idProfesor+"  AND CursoProfesor.tipoPrioridad= 'Auxiliar'";
        try {
            ps1 = conexion.prepareStatement(sql);
            rs = ps1.executeQuery();

            while (rs.next()) {
                cprofesor = new CursoProfesor();
                cprofesor.setIdCurso(rs.getInt("idCurso"));
                cprofesor.setIdProfesor(rs.getInt("idProfesor"));
                cprofesor.setTipoPrioridad(rs.getString("tipoPrioridad"));
                cprofesor.setIdProfesor(rs.getInt("idProfesor"));
                cprofesor.setNombreCurso(rs.getString("Cursos.nombre"));
                cursosAux.add(cprofesor);
            }
        } catch (SQLException e) {
            System.out.println("no se encontraron servicios " + e);
        }
        return cursosAux;
    }
    
     public ArrayList<CursoProfesor> ObtenerCursosPrimariosProfesor(int idProfesor, Connection conexion){
        ArrayList<CursoProfesor> cursosPrimarios= new ArrayList();
        PreparedStatement ps1;
        ResultSet rs;
        CursoProfesor cprofesor;
        String sql = "SELECT * FROM Profesor JOIN CursoProfesor ON Profesor.idProfesor = CursoProfesor.idProfesor JOIN Cursos  ON CursoProfesor.idCurso =  Cursos.idCurso  WHERE Profesor.idProfesor = "
                +idProfesor+"  AND CursoProfesor.tipoPrioridad= 'Primario'";
        try {
            ps1 = conexion.prepareStatement(sql);
            rs = ps1.executeQuery();

            while (rs.next()) {
                cprofesor = new CursoProfesor();
                cprofesor.setIdCurso(rs.getInt("idCurso"));
                cprofesor.setIdProfesor(rs.getInt("idProfesor"));
                cprofesor.setTipoPrioridad(rs.getString("tipoPrioridad"));
                cprofesor.setNombreCurso(rs.getString("Cursos.nombre"));
                cursosPrimarios.add(cprofesor);
            }
        } catch (SQLException e) {
            System.out.println("no se encontraron servicios " + e);
        }
        return cursosPrimarios;
    }
     
      public ArrayList<CursoProfesor> ObtenerCursosSecundariosProfesor(int idProfesor,Connection conexion){
        ArrayList<CursoProfesor> cursosSecundarios= new ArrayList();
        PreparedStatement ps1;
        ResultSet rs;
        CursoProfesor cprofesor;
        String sql = "SELECT * FROM Profesor JOIN CursoProfesor ON Profesor.idProfesor = CursoProfesor.idProfesor JOIN Cursos  ON CursoProfesor.idCurso = Cursos.idCurso WHERE Profesor.idProfesor = "
                +idProfesor+"  AND CursoProfesor.tipoPrioridad= 'Secundario'";
        try {
            ps1 = conexion.prepareStatement(sql);
            rs = ps1.executeQuery();
            while (rs.next()) {
                cprofesor = new CursoProfesor();
                cprofesor.setIdCurso(rs.getInt("idCurso"));
                cprofesor.setIdProfesor(rs.getInt("idProfesor"));
                cprofesor.setTipoPrioridad(rs.getString("tipoPrioridad"));
                cprofesor.setNombreCurso(rs.getString("Cursos.nombre"));
                cursosSecundarios.add(cprofesor);
            }
        } catch (SQLException e) {
            System.out.println("no se encontraron servicios " + e);
        }
        return cursosSecundarios;
    }
      
      public ArrayList<Curso> ListarCursos(Connection conexion){
         PreparedStatement ps1;
        ResultSet rs;
        Curso curso;
        ArrayList<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM Cursos ";
        try {
            ps1 = conexion.prepareStatement(sql);
            rs = ps1.executeQuery();

            while (rs.next()) {
                curso = new Curso();
                curso.setIdCurso(rs.getInt("idCurso"));
                curso.setCarrera(rs.getString("carrera"));
                curso.setNombreCurso(rs.getString("nombre"));
                curso.setTipoSemestre(rs.getInt("tipoSemestre"));
                curso.setSemestre(rs.getInt("semestre"));
                //curso.setSalonAsignado(new Salon(rs.getInt("idSalon"), rs.getInt("idSalon"), rs.getDouble("idSalon"),rs.getString("idSalon")));
                cursos.add(curso);
            }
        }catch (SQLException e) {
            System.out.println("no se encontraron servicios " + e);
        }
        return cursos;
      }
    
      
      
}
