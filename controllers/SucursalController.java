package controllers;

import modells.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SucursalController {
    public List<Sucursal> listSucursales(){
        List<Sucursal> sucursales = new ArrayList<>();

       try (BufferedReader br = new BufferedReader(new FileReader("sucursales.csv"))) {
           String linea;
           boolean esPrimeraLinea = true;

           while ((linea = br.readLine()) != null) {
               // Saltar la primera línea que contiene encabezados
               if (esPrimeraLinea) {
                   esPrimeraLinea = false;
                   continue;
               }
               // Dividir la linea por atibutos en List
               String[] valores = linea.split(",");
               // Definir el valor de cada atributo
               int id = Integer.parseInt(valores[0].trim());
               String nombre = valores[1].trim();
               String direccion = valores[2].trim();
               //guardar en csv
               Sucursal sucursal = new Sucursal(id, nombre, direccion);
               sucursales.add(sucursal);
           }
       } catch (IOException e) {
           System.err.println("Error al leer el archivo CSV: " + e.getMessage());
       }
       return sucursales;
   }

   
   public void addSucursal(Sucursal newSucursal){
       try (BufferedWriter bw = new BufferedWriter(new FileWriter("sucursales.csv", true))) {
           // Crear cadena String
           String newLine = newSucursal.getId() + "," + 
                            newSucursal.getNombre() + "," + 
                            newSucursal.getDireccion();
           
           // Escribir la nueva línea al archivo CSV con linea de salto
           bw.write(newLine);
           bw.newLine();
             
       } catch (IOException e) {
           System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
       }
   }
    
}
