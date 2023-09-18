/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import Backend.AUXILIARES.AsignacionIndicee;
import Frontend.Principal;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class GeneradorHorario {
    
    Asignacion asignacion = new Asignacion();
    Profesor profesor= new Profesor();
    Salon salon = new Salon();
    
    public ArrayList<Periodo> generarPeriodos(LocalTime horaInicio, LocalTime horaFin){
        ArrayList<Periodo>  periodos = new ArrayList();
        int duracionPeriodo=ConfiguracionesGenerales.duracionPeriodo;
        LocalTime horaExtremo= horaInicio;
        LocalTime horaMas= horaExtremo;
        //System.out.println(horaInicio+"hora inicio ---------"+horaFin+"horaFin");
        while(!horaExtremo.plusMinutes(duracionPeriodo).isAfter(horaFin)){
            horaMas= horaExtremo.plusMinutes(duracionPeriodo);
            Periodo periodo = new Periodo(horaExtremo, horaMas,false);
           // System.out.println("                hora original"+horaExtremo);            
           // System.out.println("                hora mas"+duracionPeriodo+"minutos "+horaMas);
            horaExtremo=horaMas;
            periodos.add(periodo);
        }
        for (int i = 0; i < periodos.size(); i++) {
            System.out.println(periodos.get(i).fin);
        }
         //System.out.println("-------------------------------"+periodos.size()+"-----------------------------------------");
        return periodos;
    }
    
    public ArrayList<Periodo> generarPeriodosProfesor(LocalTime horaInicio, LocalTime horaFin){
      
        LocalTime horaInicioConf= ConfiguracionesGenerales.HoraInicio;
        LocalTime horaFinCOnf= ConfiguracionesGenerales.HoraFin;
        ArrayList<Periodo> periodosHorario= generarPeriodos(horaInicioConf, horaFinCOnf);
         //System.out.println(horaInicio+"hora inicio original");

        int cont=0;// 14:30--------->14:10
        while(!periodosHorario.get(cont).inicio.equals(horaInicio)){
                if(periodosHorario.get(cont).inicio.isAfter(horaInicio)){
                    horaInicio= horaInicio.plusMinutes(5);
                }else{
                    cont++;
                }
        }        
       //System.out.println(horaInicio+"modificada");
        ArrayList<Periodo>  periodos = new ArrayList();
        int duracionPeriodo=ConfiguracionesGenerales.duracionPeriodo;
        LocalTime horaExtremo= horaInicio;
        LocalTime horaMas= horaExtremo;
        while(!horaExtremo.plusMinutes(duracionPeriodo).isAfter(horaFin)){
            horaMas= horaExtremo.plusMinutes(duracionPeriodo);
            Periodo periodo = new Periodo(horaExtremo, horaMas,false);
            horaExtremo=horaMas;
            periodos.add(periodo);
        }
        //System.out.println("-------------------------------"+periodos.size()+"-----------------------------------------\n\n\n\n\n");
        return periodos;
    }
    
    public ArrayList<Profesor> agregarPeriodosProfesores(Connection conexion){
         ArrayList<Profesor> profesoresInicio= profesor.ProfesoresListado(conexion);
         System.out.println("generando periodos profesor---------------------------------------");
        for (int i = 0; i < profesoresInicio.size(); i++) {
                System.out.println(profesoresInicio.get(i).getNombre());
                  profesoresInicio.get(i).setPeriodosProfesor(generarPeriodosProfesor(profesoresInicio.get(i).getHoraEntrada(), profesoresInicio.get(i).getHoraSalida()));
   
        }
        return profesoresInicio;
    }
    
    public void  GenerarHorarioS(String fecha, Connection conexion){
        ArrayList<Salon> salones = salon.ListarSalones(conexion);
        ArrayList<Asignacion> asignaciones= asignacion.listarAsignaciones(conexion, fecha);
        ArrayList<Profesor> profesores=agregarPeriodosProfesores(conexion);
        ArrayList<Periodo> periodos=generarPeriodos(ConfiguracionesGenerales.HoraInicio, ConfiguracionesGenerales.HoraFin);
        ArrayList<Horario> horarios= new ArrayList();
        //imprimirProfesores(profesores);
    //1=rbtnHorarioContratacion,2=rbtnSemActual,3=rbtnSemestreAlto,4=rbtnSemestreBajo
        if(Principal.configuracion==1){
            int contador=0;
            int contadorPeriodo=0;
            int contadorSalon=0;
            //Periodo periodo = periodos.get(contadorPeriodo);
                for (int i = 0; i < periodos.size(); i++) {
                    //System.out.println("----------------------"+periodos.get(i).inicio);
                  try{
                      int salonesNum = salones.size();
                        for (int j = 0;j<  salones.size(); j++) {
                           Horario horario = new Horario();
                           horario.setHoraInicio(periodos.get(i).inicio);
                            horario.setHoraFin(periodos.get(i).fin);
                            horario.setIdSalon(salones.get(j).getIdSalon());
                             ArrayList<Profesor> profesoresHorario =profesor.profesorHorario(profesores, periodos.get(i).inicio);
                             imprimirProfesores(profesoresHorario);
                             
                             
                             int contador2=0;
                            for (int k = 0; k < profesoresHorario.size(); k++) {
                                    if(profesoresHorario.get(k).retornarDisponibilidadHorarioProfesor(profesoresHorario.get(k), profesoresHorario.get(k).retornarIndiceHorarioProfesor(profesoresHorario.get(k), periodos.get(i).inicio))){
                                        System.out.println("profesor disponible "+periodos.get(i).inicio);
                                        
                                        
                                    }
                                
                            }
                      }
                        
                    }catch(Exception e){
                        
                    }
                    
                }
        }else if(Principal.configuracion==2){
                 for (int i = 0; i < asignaciones.size(); i++) {
                
                }
        }else if(Principal.configuracion==3){
            
        }else{
            
        }
        System.out.println(horarios);
    }
    
    
    public void imprimirProfesores( ArrayList<Profesor> profesores){
        for (int i = 0; i < profesores.size(); i++) {
            System.out.println("{"+profesores.get(i).getNombre()+"---"+"}");
            for (int j = 0; j < profesores.get(i).getPeriodosProfesor().size(); j++) {
                System.out.println("        "+profesores.get(i).getPeriodosProfesor().get(j).inicio+"----"+profesores.get(i).getPeriodosProfesor().get(j).fin);
                
            }
        }
    }
    
   
}
