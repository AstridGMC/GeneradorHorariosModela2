/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import Backend.AUXILIARES.AsignacionIndicee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author astridmc
 */
public class Asignacion {
    
    Date fechaAsignacion;
    int idCurso;
    int idCursoSeccion;
    String nombreCurso;
    String seccion;    
    String carrera;    
    int numeroAsignados;
    int tipoSemestre;
    int semestre;
    
    boolean horarioAsignado=false;
    

    public Asignacion() {
    }

    public Asignacion(Date fechaAsignacion, int idCurso, int idCursoSeccion, String nombreCurso, String seccion, String carrera, int numeroAsignados, int tipoSemestre, int semestre) {
        this.fechaAsignacion = fechaAsignacion;
        this.idCurso = idCurso;
        this.idCursoSeccion = idCursoSeccion;
        this.nombreCurso = nombreCurso;
        this.seccion = seccion;
        this.carrera = carrera;
        this.numeroAsignados = numeroAsignados;
        this.tipoSemestre = tipoSemestre;
        this.semestre = semestre;
        
    }

    

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdCursoSeccion() {
        return idCursoSeccion;
    }

    public void setIdCursoSeccion(int idCursoSeccion) {
        this.idCursoSeccion = idCursoSeccion;
    }


    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getNumeroAsignados() {
        return numeroAsignados;
    }

    public void setNumeroAsignados(int numeroAsignados) {
        this.numeroAsignados = numeroAsignados;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
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

    public boolean isAsignado() {
        return horarioAsignado;
    }

    public void setAsignado(boolean horarioAsignado) {
        this.horarioAsignado = horarioAsignado;
    }
    
    
    
        public ArrayList<Asignacion> listarAsignaciones(Connection conexion, String fecha){
         ArrayList<Asignacion> asignaciones = new ArrayList();
         PreparedStatement ps1;
         ResultSet rs;
         Asignacion asignacion;
         String sql = "SELECT * FROM Asignaciones  JOIN Cursos ON Asignaciones.idCurso= Cursos.idCurso JOIN CursoSeccion ON "
                 +"Asignaciones.idCursoSecc = CursoSeccion.idCursoSeccion  WHERE Asignaciones.FechaAsignacion= '"+fecha+"';";
         
        try {
            ps1 = conexion.prepareStatement(sql);
            rs = ps1.executeQuery();

            while (rs.next()) {
                asignacion = new Asignacion();
                asignacion.setIdCurso(rs.getInt("Cursos.idCurso"));
                asignacion.setFechaAsignacion(rs.getDate("FechaAsignacion"));
                asignacion.setNombreCurso(rs.getString("Cursos.nombre"));
                asignacion.setIdCursoSeccion(rs.getInt("idCursoSeccion"));
                asignacion.setSeccion(rs.getString("Seccion"));
                asignacion.setNumeroAsignados(rs.getInt("numeroAsignados"));
                asignacion.setCarrera(rs.getString("Cursos.carrera"));
                asignacion.setSemestre(rs.getInt("Cursos.semestre"));
                asignacion.setTipoSemestre(rs.getInt("Cursos.tipoSemestre"));
                //curso.setSalonAsignado(new Salon(rs.getInt("idSalon"), rs.getInt("idSalon"), rs.getDouble("idSalon"),rs.getString("idSalon")));
                asignaciones.add(asignacion);
                
            }
        }catch (SQLException e) {
            System.out.println("no se encontraron servicios " + e);
        }         
         return asignaciones;
    }   
    
 
    
    
    
    public ArrayList<String> listarFechasAsignacion(Connection conexion){
         ArrayList<String> fechas = new ArrayList();
         PreparedStatement ps1;
         ResultSet rs;
         String sql = "SELECT * FROM FechaAsignacion ;";
         
        try {
            ps1 = conexion.prepareStatement(sql);
            rs = ps1.executeQuery();

            while (rs.next()) {
                
                fechas.add(String.valueOf(rs.getDate("FechaAsignacion")));
                
            }
        }catch (SQLException e) {
            System.out.println("no se encontraron servicios " + e);
        }         
         return fechas;
    }    
    
    
    
    public AsignacionIndicee asignarHorario(int idCurso, ArrayList<Asignacion> asignaciones){
        for (int i = 0; i < asignaciones.size(); i++) {
            if(asignaciones.get(i).getIdCurso()== idCurso){
                if(!asignaciones.get(i).isAsignado()){
                    asignaciones.get(i).setAsignado(true);
                    return new AsignacionIndicee(asignaciones, i);
                }
            }
        }
        return null;
    }
}
