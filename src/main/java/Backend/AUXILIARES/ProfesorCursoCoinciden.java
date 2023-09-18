/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.AUXILIARES;

import Backend.Profesor;

/**
 *
 * @author astridmc
 */
public class ProfesorCursoCoinciden {
    Profesor profesor;
    int idCurso;
    int indice;
    String tipo;

    public ProfesorCursoCoinciden() {
    }

    public ProfesorCursoCoinciden(Profesor profesor, int idCurso, int indice, String tipo) {
        this.profesor = profesor;
        this.idCurso = idCurso;
        this.indice = indice;
        this.tipo = tipo;
    }
    
    
}
