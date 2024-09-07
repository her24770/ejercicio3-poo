package controllers;

import modells.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Date;

/**
 * El controlador de la clase prestamos que maneja la edicion de sus datos, la adicion de prestamos al CSV
 * y su lectura en la pantalla
 */

public class PrestamoController {

    /**
     * Lee el archivo CSV y convierte las filas en un objeto, los prestamos de libro
     * @return List<Prestamo> lista de préstamos
     */
    public List<Prestamo> listPrestamos(){
        List<Prestamo> prestamos = new ArrayList<>();

        //Formatea las fechas con zonas horarias
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("EEE MMM dd HH:mm:ss ")
                .optionalStart()
                .appendZoneText(TextStyle.SHORT)
                .optionalEnd()
                .appendPattern(" yyyy")
                .toFormatter(Locale.ENGLISH);

        
        try (BufferedReader br = new BufferedReader(new FileReader("prestamos.csv"))) {
           String linea;
           boolean esPrimeraLinea = true;

           //Lee el archivo CSV
           while ((linea = br.readLine()) != null) {
               // Saltar la primera línea que contiene encabezados
               if (esPrimeraLinea) {
                   esPrimeraLinea = false;
                   continue;
               }
               // Dividir la linea por atibutos en List
               String[] valores = linea.split(",");
               // Definir el valor de cada atributo
               int idMiembro = Integer.parseInt(valores[0].trim());



               ZonedDateTime zonedDateTimeI = ZonedDateTime.parse(valores[1].trim(), formatter);   
               ZonedDateTime zonedDateTimeF = ZonedDateTime.parse(valores[2].trim(), formatter);
               Date fechaPrestamo =  Date.from(zonedDateTimeI.toInstant());
               Date fechaDevolucion =  Date.from(zonedDateTimeF.toInstant());


               int idSucursal = Integer.parseInt(valores[3].trim());
               String ISBNPrestamo = valores[4].trim();
               Boolean activo = Boolean.parseBoolean(valores[5].trim());
               //guardar en csv
               Prestamo prestamo = new Prestamo(idMiembro, fechaPrestamo, fechaDevolucion, idSucursal, ISBNPrestamo, activo);
               prestamos.add(prestamo);
           }
       } catch (IOException e) {
           
        }
        catch (Exception e) {
            
        }
       return prestamos;
   }

   /**
    * Agrega un nuevo Prestamo y su informacion a prestamos.csv
    * @param newPrestamo El objeto Prestamo que se agregara
    */
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
           
       }
   }

   /**
    * Metodo para actualizar un prestamo que se encuentre dentro del CSV
    * @param updatePrestamo El Prestamo que tiene los valores nuevos
    */
   public void updatePrestamo(Prestamo updatePrestamo, int filaAEditar){
    // Leer todas las filas del archivo CSV
        List<String[]> rows = new ArrayList<>();

        //Lee las lineas del CSV
        try (BufferedReader br = new BufferedReader(new FileReader("prestamos.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Dividir cada línea por comas
                String[] data = line.split(",");
                rows.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Verificacion para ver si existe la fila que se quiere actualizar
        if (rows.size() > filaAEditar) {
            // Nueva fila que queremos poner en su lugar
            String datei = ""+updatePrestamo.getFechaPrestamo();
            String datef = ""+updatePrestamo.getFechaDevolucion();
            String[] nuevaFila = {Integer.toString(updatePrestamo.getIdMiembro()),
                                                    datei,
                                                    datef,
                                                    Integer.toString(updatePrestamo.getIdSucursal()),
                                                    updatePrestamo.getISBNLibro(),
                                                    String.valueOf(updatePrestamo.getActivo())};
            rows.set(filaAEditar, nuevaFila);  // Reemplazar la fila existente con la nueva fila
        }

        // Guardar los cambios escribiendo el archivo CSV de nuevo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("prestamos.csv"))) {
            for (String[] row : rows) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

   }
    
}
