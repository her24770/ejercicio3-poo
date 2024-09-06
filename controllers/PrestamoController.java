package controllers;

import modells.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class PrestamoController {
    public List<Prestamo> listPrestamos(){
        List<Prestamo> prestamos = new ArrayList<>();

       try (BufferedReader br = new BufferedReader(new FileReader("prestamos.csv"))) {
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
               SimpleDateFormat formato = new SimpleDateFormat("dd-MM-YYY");
               int idMiembro = Integer.parseInt(valores[0].trim());
               Date fechaPrestamo = formato.parse(valores[1].trim());
               Date fechaDevolucion =  formato.parse(valores[2].trim());
               int idSucursal = Integer.parseInt(valores[3].trim());
               String ISBNPrestamo = valores[4].trim();
               Boolean activo = Boolean.parseBoolean(valores[5].trim());
               //guardar en csv
               Prestamo prestamo = new Prestamo(idMiembro, fechaPrestamo, fechaDevolucion, idSucursal, ISBNPrestamo, activo);
               prestamos.add(prestamo);
           }
       } catch (IOException e) {
           System.err.println("Error al leer el archivo CSV: " + e.getMessage());
       } catch (ParseException e) {
            System.err.println("Error al leer la fechas: " + e.getMessage());
    }
       return prestamos;
   }

   
   public void addPrestamo(Prestamo newPrestamo){
       try (BufferedWriter bw = new BufferedWriter(new FileWriter("prestamos.csv", true))) {
           // Crear cadnea String
           String newLine = newPrestamo.getIdMiembro() + "," + 
                            newPrestamo.getFechaPrestamo() + "," + 
                            newPrestamo.getFechaDevolucion() + "," + 
                            newPrestamo.getIdSucursal() + "," + 
                            newPrestamo.getISBNLibro() + "," + 
                            newPrestamo.getActivo();
           
           // Escribir la nueva línea al archivo CSV con linea de salot
           bw.write(newLine);
           bw.newLine();  
       } catch (IOException e) {
           System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
       }
   }
    
}
