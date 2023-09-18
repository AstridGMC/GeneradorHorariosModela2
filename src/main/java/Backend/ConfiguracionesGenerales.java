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
public class ConfiguracionesGenerales {
    //duracion en minutos
    static int duracionPeriodo=40;
    static LocalTime HoraInicio;
    static  LocalTime HoraFin;
    static int  idConf;
    
    public void llenarConfiguraciones(Connection conexion){
         PreparedStatement ps1;
         ResultSet rs;
         String sql = "SELECT * FROM ConfiguracionesGenerales  ;";
         
        try {
            ps1 = conexion.prepareStatement(sql);
            rs = ps1.executeQuery();

            while (rs.next()) {
                duracionPeriodo=rs.getInt("DuracionPeriodo");
                HoraInicio=LocalTime.parse(rs.getString("HoraInicio"));
                HoraFin=LocalTime.parse(rs.getString("HoraFin"));
                idConf =rs.getInt("idConf");
                                
            }
        }catch (SQLException e) {
            System.out.println("no se encontraron servicios " + e);
        }         
    }
    
    
}
