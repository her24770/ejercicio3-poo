package controllers;

import modells.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * El controlador con los metodos necesarios para listar y agregar los libros al CSV
 * @author Josue Hernandez  
 */

public class LibroController {

    /**
    * Lee el archivo CSV y convierte las filas en un objeto, el libro
    * @return List<Libro> Una lista de objetos Libro obtenidos del archivo CSV.
    */
    public List<Libro> listLibros(){
         List<Libro> libros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("libros.csv"))) {
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
                String isbn = valores[0].trim();
                String titulo = valores[1].trim();
                String autor = valores[2].trim();
                String fechaPublicacion = valores[3].trim();
                String genero = valores[4].trim();
                int idSucursal = Integer.parseInt(valores[5].trim());
                int disponibles = Integer.parseInt(valores[6].trim());
                //guardar en csv
                Libro libro = new Libro(isbn, titulo, autor, fechaPublicacion, genero, idSucursal, disponibles);
                libros.add(libro);
            }
        } catch (IOException e) {
            
        }
        return libros;
    }

    /**
     * /**
     * Agrega un nuevo libro y su informacion a libros.csv
     * @param newLibro El objeto que se va a agregar al CSV
     */
    public void addLibro(Libro newLibro){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("libros.csv", true))) {
            // Crear cadnea String
            String newLine = newLibro.getIsbn() + "," + 
                             newLibro.getTitulo() + "," + 
                             newLibro.getAutor() + "," + 
                             newLibro.getFechaPublicacion() + "," + 
                             newLibro.getGenero() + "," + 
                             newLibro.getIdSucursal() + "," + 
                             newLibro.getDisponibles();
            
            // Escribir la nueva línea al archivo CSV con linea de salot
            bw.write(newLine);
            bw.newLine();  
        } catch (IOException e) {
           
        }
    }

    public void updateLibro(Libro updateLibro, int filaAEditar){
        // Leer todas las filas del archivo CSV
            List<String[]> rows = new ArrayList<>();
    
            try (BufferedReader br = new BufferedReader(new FileReader("libros.csv"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // Dividir cada línea por comas
                    String[] data = line.split(",");
                    rows.add(data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (rows.size() > filaAEditar) {
                // Nueva fila que queremos poner en su lugar
                String[] nuevaFila = {updateLibro.getIsbn(),
                                        updateLibro.getTitulo(),
                                        updateLibro.getAutor(),
                                        updateLibro.getFechaPublicacion(),
                                        updateLibro.getGenero(),
                                        Integer.toString(updateLibro.getIdSucursal()),
                                        Integer.toString(updateLibro.getDisponibles()),
                                        };
                rows.set(filaAEditar, nuevaFila);  // Reemplazar la fila existente con la nueva fila
            }
    
            // Guardar los cambios escribiendo el archivo CSV de nuevo
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("libros.csv"))) {
                for (String[] row : rows) {
                    bw.write(String.join(",", row));
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    
       }
}
