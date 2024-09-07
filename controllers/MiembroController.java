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
 * El controlador con los metodos necesarios para listar y agregar los miembros al CSV
 * @author Juan Daniel Ordoñez
 */

public class MiembroController {

    /**
    * Lee el archivo CSV y convierte las filas en un objeto, el nuevo miembro
    * @return List<Miembro> Una lista de objetos Miembro que se sacaron del CSV
    */
    public List<Miembro> listMiembros(){
        List<Miembro> miembros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("miembros.csv"))) {
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
                String telefono = valores[2].trim();
                int edad = Integer.parseInt(valores[3].trim());
                //guardar en csv
                Miembro miembro = new Miembro(id, nombre, telefono, edad);
                miembros.add(miembro);
            }
        } catch (IOException e) {
            
        }
        return miembros;
    }

    /**
     * Agrega un nuevo objeto miembro y sus datos al CSV
     * @param newMiembro El nuevo miembro que se va a agregar a miembros.csv
     */
    public void addMiembro(Miembro newMiembro){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("miembros.csv", true))) {
            // Crear cadnea String
            String newLine = newMiembro.getId() + "," + 
                             newMiembro.getNombre() + "," + 
                             newMiembro.getTelefono() + "," + 
                             newMiembro.getEdad();
            
            // Escribir la nueva línea al archivo CSV con linea de salot
            bw.write(newLine);
            bw.newLine();  
        } catch (IOException e) {
            
        }
    }
}
