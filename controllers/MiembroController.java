package controllers;

import modells.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MiembroController {
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
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return miembros;
    }

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
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
}
