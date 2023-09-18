/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.sql.Connection;
import java.sql.Date;
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
public class Horario {
    int idHorario;
    int idCursoProfesor;
    String idSalon;
    LocalTime HoraInicio;
    LocalTime HoraFin;

    public Horario() {
    }

    public Horario(int idHorario, int idCursoProfesor, String idSalon, LocalTime HoraInicio, LocalTime HoraFin) {
        this.idHorario = idHorario;
        this.idCursoProfesor = idCursoProfesor;
        this.idSalon = idSalon;
        this.HoraInicio = HoraInicio;
        this.HoraFin = HoraFin;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdCursoProfesor() {
        return idCursoProfesor;
    }

    public void setIdCursoProfesor(int idCursoProfesor) {
        this.idCursoProfesor = idCursoProfesor;
    }

    public String getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(String idSalon) {
        this.idSalon = idSalon;
    }

    public LocalTime getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(LocalTime HoraInicio) {
        this.HoraInicio = HoraInicio;
    }

    public LocalTime getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(LocalTime HoraFin) {
        this.HoraFin = HoraFin;
    }
    
    
    ArrayList<Horario> ListarHorarios(Connection conexion){
        
        PreparedStatement ps1;
        ResultSet rs;
        Horario horario;
        ArrayList<Horario> horarios = new ArrayList<>();
        String sql = "SELECT * FROM Horario ";
        try {
                ps1 = conexion.prepareStatement(sql);
                rs = ps1.executeQuery();

                while (rs.next()) {
                          horario = new Horario();
                          horario.setIdHorario(rs.getInt("idHorario"));
                          horario.setIdCursoProfesor(rs.getInt("idCursoProfesor"));
                          horario.setIdSalon(rs.getString("idSalon"));
                          horario.setHoraInicio((LocalTime)rs.getObject("horaInicio"));
                          horario.setHoraFin((LocalTime)rs.getObject("HoraFin"));
                    horarios.add(horario);
                }
         }catch (SQLException e) {
            System.out.println("no se encontraron servicios " + e);
        }
        return horarios;      
    }
    
    public int obtenerIDMayorHorario(Connection conexion){
         PreparedStatement ps1 = null;
        ResultSet rs = null;
        String sql = "SELECT Max(idHorario) FROM Horario;";
        try {
            ps1 = conexion.prepareStatement(sql);
            rs = ps1.executeQuery();
            rs.first();
            return rs.getInt("Max(idHorario)");
        } catch (SQLException e) {
            System.out.println("error leyendo id idFactura max Factura" + e);
            return 0;
        }
    }
    
    public void  guardarHorario(ArrayList<Horario> horarios1, Connection conexion, Horario horarios) {
        PreparedStatement ps1;
        String consulta = "INSERT INTO Horario (idHorario, duracionPeriodo, fechaCreacion)"
                + " VALUES (?,?,?);";
        int idHorario = obtenerIDMayorHorario(conexion)+1;
        try {
                 
                LocalDate todaysDate = LocalDate.now();
                ps1 = conexion.prepareStatement(consulta);
                ps1.setInt(1, idHorario);
                ps1.setString(2, String.valueOf(ConfiguracionesGenerales.duracionPeriodo));
                ps1.setDate(3, Date.valueOf(todaysDate));
                if (ps1.executeUpdate() == 1) {
                    System.out.println("Horario Guardado");
                    guardarHorarios(horarios1, conexion,idHorario);
                }
            
        } catch (SQLException e) {
            System.out.println("error registrando venta" + e);
           
        }
    }
    
    public void guardarHorarios(ArrayList<Horario> horarios, Connection conexion, int  idHorario){
        PreparedStatement ps1;
        float total = 0 ;
        String consulta = "INSERT INTO HorarioAsignado (idHorario, idCursoProfesor, idSalon, horaInicio, HoraFin)"
                + " VALUES (?,?,?,?,?);";
        try {
            for (int i = 0; i < horarios.size(); i++) {
                Horario horario= horarios.get(i);
                ps1 = conexion.prepareStatement(consulta);
                ps1.setInt(1, idHorario);
                ps1.setInt(2,horario.getIdCursoProfesor());
                ps1.setString(3, horario.getIdSalon());
                ps1.setString(4, String.valueOf(horario.getHoraInicio()));                
                ps1.setString(5, String.valueOf(horario.getHoraFin()));                                
                if (ps1.executeUpdate() == 1) {
                   
                    System.out.println("horario guardado completo");
                }
            }
        } catch (SQLException e) {
            System.out.println("error registrando venta" + e);
            
        }
    
    }
}
