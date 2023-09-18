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
public class ConfiguracionGeneral {
   
    int idConf;
    int duracionPeriodo;
    LocalTime horaInicio;
    LocalTime HoraFin;

    public ConfiguracionGeneral(int idConf, int duracionPeriodo, LocalTime horaInicio, LocalTime HoraFin) {
        this.idConf = idConf;
        this.duracionPeriodo = duracionPeriodo;
        this.horaInicio = horaInicio;
        this.HoraFin = HoraFin;
    }

    public ConfiguracionGeneral() {
    }

    
        
    public int getIdConf() {
        return idConf;
    }

    public void setIdConf(int idConf) {
        this.idConf = idConf;
    }

    public int getDuracionPeriodo() {
        return duracionPeriodo;
    }

    public void setDuracionPeriodo(int duracionPeriodo) {
        this.duracionPeriodo = duracionPeriodo;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(LocalTime HoraFin) {
        this.HoraFin = HoraFin;
    }
    
    
    ConfiguracionGeneral ListarSalones(Connection conexion){
        
        PreparedStatement ps1;
        ResultSet rs;
        ConfiguracionGeneral conf = new ConfiguracionGeneral();
        String sql = "SELECT  TOP 1 * FROM ConfiguracionGeneral  ORDER BY idConf DESC;";
            try {
                ps1 = conexion.prepareStatement(sql);
                rs = ps1.executeQuery();

                while (rs.next()) {
                          conf.setIdConf(rs.getInt("idConf"));
                          conf.setDuracionPeriodo(rs.getInt("DuracionPeriodo"));
                          conf.setHoraInicio((LocalTime)rs.getObject("HoraInicio"));
                          conf.setHoraFin((LocalTime)rs.getObject("HoraFin"));
                }
         }catch (SQLException e) {
            System.out.println("no se encontraron servicios " + e);
        }
        return conf;      
    }
    
}
