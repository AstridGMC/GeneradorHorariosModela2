/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.AUXILIARES;

import Backend.Asignacion;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class AsignacionIndicee {
    ArrayList<Asignacion> asignaciones;
    int indice;

    public AsignacionIndicee(ArrayList<Asignacion> asignaciones, int indice) {
        this.asignaciones = asignaciones;
        this.indice = indice;
    }
    
    public ArrayList<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(ArrayList<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
}
