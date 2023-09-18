/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.time.LocalTime;

/**
 *
 * @author astridmc
 */
public class Periodo {
    LocalTime inicio;
    LocalTime fin;
    boolean ocupado=false;

    public Periodo(LocalTime inicio, LocalTime fin, boolean ocupado) {
        this.inicio = inicio;
        this.fin = fin;
        this.ocupado = ocupado;
    }
    
    
}
