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
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Salon {
    String idSalon;
    int capacidad;
    double porcentajeSoreCarga;
    String cursoDef;

    public Salon(String idSalon, int capacidad, double porcentajeSoreCarga, String cursoDef) {
        this.idSalon = idSalon;
        this.capacidad = capacidad;
        this.porcentajeSoreCarga = porcentajeSoreCarga;
        this.cursoDef = cursoDef;
    }

    public Salon() {
    }
    
    public String getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(String idSalon) {
        this.idSalon = idSalon;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getPorcentajeSoreCarga() {
        return porcentajeSoreCarga;
    }

    public void setPorcentajeSoreCarga(double porcentajeSoreCarga) {
        this.porcentajeSoreCarga = porcentajeSoreCarga;
    }

    public String getCursoDef() {
        return cursoDef;
    }

    public void setCursoDef(String cursoDef) {
        this.cursoDef = cursoDef;
    }
    
    public ArrayList<Salon> ListarSalones(Connection conexion){
        
        PreparedStatement ps1;
        ResultSet rs;
        Salon salon;
        ArrayList<Salon> salones = new ArrayList<>();
        String sql = "SELECT * FROM Salon ";
        try {
                ps1 = conexion.prepareStatement(sql);
                rs = ps1.executeQuery();

                while (rs.next()) {
                          salon = new Salon();
                          salon.setIdSalon(rs.getString("idSalon"));
                          salon.setCapacidad(rs.getInt("capacidad"));
                          salon.setPorcentajeSoreCarga(rs.getInt("PorcentajeSobrecarga"));
                          salon.setCursoDef(rs.getString("CursoDef"));
                    salones.add(salon);
                }
         }catch (SQLException e) {
            System.out.println("no se encontraron servicios " + e);
        }
        return salones;      
    }
}
