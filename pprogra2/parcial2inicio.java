/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pprogra2;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author loren
 */
public class parcial2inicio {
    static Scanner general = new Scanner (System.in);
    
    
    public static void ConsultaPorNiv(){
    System.out.println("Por favor, ingrese el Niv para buscar sus datos  : ");
String NIV = general.next();

        String url = "jdbc:mysql://localhost:3306/pprogra2bd?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","Lorenti1706");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "SELECT * FROM tb_comision where niv = '"+NIV+"' ";
          
            ResultSet resultado = sentencia.executeQuery(sql);
            
            int nivdb =0;
            
            while(resultado.next()){
                
                nivdb = resultado.getInt(1);
                //System.out.println("\nNiv ="+resultado.getString(2));
            }
            
            if(nivdb == 0){
                System.out.println("El niv ingresado no existe");
                ConsultaPorNiv();
            }else{
               Buscandoniv(nivdb);
            }
               
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}//***********************consulta por niv
    
    
    public static void Buscandoniv(int niv){
    
        String url = "jdbc:mysql://localhost:3306/pprogra2bd?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","Lorenti1706");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "SELECT * FROM tb_comision where niv = " +niv;
          
            ResultSet resultado = sentencia.executeQuery(sql);
       
            while(resultado.next()){
                System.out.println("\nNiv   ="+resultado.getInt(1));
                System.out.println("Nombre  = "+resultado.getString(2));
                System.out.println("Comision de Enero   ="+resultado.getInt(3));
                System.out.println("Comision de Febrero ="+resultado.getInt(4));
                System.out.println("Comision de Marzo   ="+resultado.getInt(5));
                System.out.println("Comision de Abril   ="+resultado.getInt(6));
                System.out.println("Comision de Mayo    ="+resultado.getInt(7));
                System.out.println("Comision de Junio ="+resultado.getInt(8));
                System.out.println("\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}//**********buscando niv
    
    public static void listadeSumas(){
         

        String url = "jdbc:mysql://localhost:3306/pprogra2bd?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","Lorenti1706");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "Select Niv, nombre, (enero+febrero+marzo+abril+mayo+junio) from tb_comision;";
             
          
            ResultSet resultado = sentencia.executeQuery(sql);
       
            while(resultado.next()){
                 System.out.println("\nNiv ="+resultado.getInt(1));
                System.out.println("Nombre = "+resultado.getString(2));
                System.out.println("Total ventas ="+resultado.getInt(3));
              
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}//************fin total ventas
    
    
    
    
    public static void ConsultaEliminarNiv(){
    
System.out.println("Por favor, ingrese el Niv a eliminar: ");
String niv = general.next();

        String url = "jdbc:mysql://localhost:3306/pprogra2bd?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","Lorenti1706");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "SELECT * FROM tb_comision where niv = '"+niv+"' ";
          
            ResultSet resultado = sentencia.executeQuery(sql);
            
            int nivdb =0;
            
            while(resultado.next()){
                
                nivdb = resultado.getInt(1);
                //System.out.println("\nNiv ="+resultado.getString(2));
            }
            
            if(nivdb == 0){
                System.out.println("El niv ingresado no existe");
                ConsultaEliminarNiv();
            }else{
                   int op;

System.out.println("Esta seguro de Eliminar el Niv?");
          System.out.println("1.Si ");
          System.out.println("2.No ");
        
        System.out.println("Introcudir una opcion");
        op=general.nextInt();
    switch(op){
    
    
        case 1:
           
            EliminarNiv(nivdb);
         break;
      
          case 2:
          
         break;        
         
          default:System.out.println("No es una opcion valida, Introdusca una opcion valida");
    
    }           
            }//fin del else
                          
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
} //fin de eliminarNiv
    
    
    public static void EliminarNiv(int niv){
   
    
    
     String url = "jdbc:mysql://localhost:3306/pprogra2bd?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","Lorenti1706");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "delete from tb_comision  where niv = '"+niv+"' ";
             
          
            sentencia.executeUpdate(sql);
                      
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}//********************fin eliminar por niv
    
    
    
    
    
    
    public static void ActualizarNombreNiv(){


System.out.println("Por favor, ingrese el Niv: ");
String niv = general.next();

        String url = "jdbc:mysql://localhost:3306/pprogra2bd?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","Lorenti1706");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "SELECT * FROM tb_comision where niv = '"+niv+"' ";
          
            ResultSet resultado = sentencia.executeQuery(sql);
            
            int nivdb =0;
            
            while(resultado.next()){
                
                nivdb = resultado.getInt(1);
                //System.out.println("\nNiv ="+resultado.getString(2));
            }
            
            if(nivdb == 0){
                System.out.println("El niv ingresado no existe");
                ActualizarNombreNiv();
            }else{
                ConsultaActualizar(nivdb);
            }
               
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
} //**********************/ActualizarNombreNiv
    
    
    
    
    public static void ConsultaActualizar(int niv){
    System.out.println("Por favor ingrese el nuevo nombre: ");
    String nuevonombre = general.next();
    
     String url = "jdbc:mysql://localhost:3306/pprogra2bd?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","Lorenti1706");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "update tb_comision set nombre = '"+nuevonombre+"' where niv = '"+niv+"' ";
             
          
            sentencia.executeUpdate(sql);
                      
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}//fin de Actualizar Nombre
    
    
    
    
    public static void main(String[] args) {
        int op;
    System.out.println(" Ingrese una Opcion ");
          
        System.out.println("1. Buscar por niv");
        System.out.println("2. Vendedores con su total de ventas");
        System.out.println("3. Eliminar Por Niv");
        System.out.println("4. Actualizar nombre por niv");
        op=general.nextInt();
   switch(op){
       
       case 1:
           
          ConsultaPorNiv();
           break;
           
       case 2:
           listadeSumas();
           break;
           
            case 3:
           ConsultaEliminarNiv();
           break;
           
            case 4:
           ActualizarNombreNiv();
           break;
           
       default:System.out.println("No es una opcion valida, introduzca una opcion valida");
       
   }
    }
    
    
}//fin de Progra Principal
