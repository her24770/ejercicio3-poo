import java.util.List;
import java.util.Scanner;
import java.io.File;

import controllers.LibroController;
import modells.Libro;

public class Main {
    public static void main(String[] args) {
        //Controllers
        LibroController libroC = new LibroController();
        //Array List
        List<Libro> libros=libroC.listLibros();
        List<String> listaGenerosLibros = List.of("Fantasia", "Novela", "ficcion", "Poesia","Geografia", "Didatico","Infantil","Biografias");
        Scanner sc = new Scanner(System.in);

        System.out.println("------Bienvenido----");
        
        Boolean repeatMenu=true;

        String nombreArchivo = "libros.csv";
         
        List<String> archivosCSV= List.of("libros.csv");
        for(String archivoCSV:archivosCSV){
            File archivo = new File(archivoCSV);
            Boolean archivoExiste = archivo.exists() && archivo.isFile();
            if (!archivoExiste){
                System.out.println("El archivo '" + nombreArchivo + "' no existe!!");
                repeatMenu=false;
            }
        }

        while (repeatMenu) {
            System.out.print("\n------MENU---"+
                                "\n1. Agregar nuevo Libro"+
                                "\n2. Agregar nuevo miembro"+
                                "\n3. Agregar Sucursal"+
                                "\n4. Prestamo del libro"+
                                "\n5. Devolución de un libro"+
                                "\n6. Estadisticas"+
                                "\n7. Salir"+
                                "\nIngrese su opcion : "
                                );
            String otpionMenu = sc.nextLine();
            switch (otpionMenu) {
                case "1":
                    Libro newLibro = new Libro();
                    System.out.println("\n---- NUEVO LIBRO ----");
                    System.out.print("Ingrese el isbn del libro : ");
                    String isbnNewLibro = sc.nextLine();
                    Boolean existLibro = true;
                    while(existLibro){
                        existLibro=false;
                        for(Libro libro:libros){
                            if(libro.getIsbn().equals(isbnNewLibro)){
                                existLibro=true;
                            }
                        }
                        if (existLibro) {
                            System.out.print("Ya existe este ISBN elija otro :");
                            isbnNewLibro=sc.nextLine();
                        }else{
                            newLibro.setIsbn(isbnNewLibro);
                        }
                    }
                    
                    System.out.print("Ingrese el titulo : ");
                    newLibro.setTitulo(sc.nextLine());
                    System.out.print("Ingrese el autor : ");
                    newLibro.setAutor(sc.nextLine());
                    System.out.print("Ingrese la fecha de publicacion : ");
                    newLibro.setFechaPublicacion(sc.nextLine());
                    System.out.println("Seleccione el genero : ");
                    for(int i =1;i<listaGenerosLibros.size();i++){
                        System.out.println("   "+i+". "+listaGenerosLibros.get(i-1));
                    }
                    System.out.print("   Eleccion : ");
                    newLibro.setGenero(listaGenerosLibros.get(Integer.parseInt(sc.nextLine())-1));
                    System.out.print("Ingrese la sucursal del libro : ");
                    //listar las sucursales
                    newLibro.setIdSucursal(Integer.parseInt(sc.nextLine()));
                    System.out.println("Ingrese cuantas copias hay disponibles : ");
                    newLibro.setDisponibles(Integer.parseInt(sc.nextLine()));
                    libroC.addLibro(newLibro);
                    libros=libroC.listLibros();
                    break;

                case "2":

                    break;

                case "3":
                    
                    break;

                case "4":
                    
                    break;

                case "5":
                    
                    break;

                case "6":
                    Boolean repeatMenuEstaditicas=true;
                    while (repeatMenuEstaditicas){
                        System.out.print("\n----- ESTADISTICAS ------"+
                                        "\n1. Cantidad de libros prestados"+
                                        "\n2. Generos mas solicitados"+
                                        "\n3. Lirbo mas prestado"+
                                        "\n4. Salir"+
                                        "\nIngrese su opcion : ");
                        String optionMenuEstadisticas = sc.nextLine();
                        switch (optionMenuEstadisticas) {
                            case "1":
                                
                                break;

                            case "2":
                                
                                break;

                            case "3":
                                
                                break;

                            case "4":
                                System.out.println("");
                                repeatMenuEstaditicas=false;
                                break;
                        
                            default:
                                System.out.println("\nOpcion invalida...");
                                break;
                        }
                    }
                    break;

                case "7":
                    System.out.println("\nSaliendo...");
                    repeatMenu=false;
                    break;
            
                default:
                    System.out.println("\nOpcion invalida...");
                    break;
            }
        }
        sc.close();
    }
}