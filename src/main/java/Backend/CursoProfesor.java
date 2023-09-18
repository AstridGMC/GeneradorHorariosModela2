/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 *
 * @author astridmc
 */
public class CursoProfesor {
    int idCurso;
    int idProfesor;
    String tipoPrioridad;
    int idCursoProfesor;
    int idCursoSeccion;
    String nombreCurso;
    boolean asignado;

    public CursoProfesor(int idCurso, int idProfesor, String tipoPrioridad, int idCursoProfesor, String nombreCurso) {
        this.idCurso = idCurso;
        this.idProfesor = idProfesor;
        this.tipoPrioridad = tipoPrioridad;
        this.idCursoProfesor = idCursoProfesor;
        this.nombreCurso= nombreCurso;
    }

    public CursoProfesor() {
    }
    
    

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getTipoPrioridad() {
        return tipoPrioridad;
    }

    public void setTipoPrioridad(String tipoPrioridad) {
        this.tipoPrioridad = tipoPrioridad;
    }

    public int getIdCursoProfesor() {
        return idCursoProfesor;
    }

    public void setIdCursoProfesor(int idCursoProfesor) {
        this.idCursoProfesor = idCursoProfesor;
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

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }
    
    
}
