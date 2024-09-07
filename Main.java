import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import controllers.*;
import modells.*;

public class Main {
    public static void main(String[] args) {
        //Controllers
        LibroController libroC = new LibroController();
        MiembroController miembroC = new MiembroController();
        SucursalController sucursalC = new SucursalController();
        PrestamoController prestamoC = new PrestamoController();
        //Array List
        List<Libro> libros=libroC.listLibros();
        List<String> listaGenerosLibros = List.of("Fantasia", "Novela", "ficcion", "Poesia","Geografia", "Didatico","Infantil","Biografias");
        List<Miembro> miembros = miembroC.listMiembros();
        List<Sucursal> sucursales = sucursalC.listSucursales();
        List<Prestamo> prestamos = prestamoC.listPrestamos();
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println("------Bienvenido----");
        
        Boolean repeatMenu=true;
         
        List<String> archivosCSV= List.of("libros.csv", "miembros.csv","prestamos.csv","sucursales.csv");
        for(String archivoCSV:archivosCSV){
            File archivo = new File(archivoCSV);
            Boolean archivoExiste = archivo.exists() && archivo.isFile();
            if (!archivoExiste){
                System.out.println("El archivo de"+ archivoCSV +"no existe!!");
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
                    for(int i=0;i<sucursales.size();i++){
                        System.out.println("    "+(i+1)+". "+sucursales.get(i).toString());
                    }
                    System.out.print("Seleccione la sucursal : ");
                    newLibro.setIdSucursal(sucursales.get(Integer.parseInt(sc.nextLine())-1).getId());
                    System.out.println("Ingrese cuantas copias hay disponibles : ");
                    newLibro.setDisponibles(Integer.parseInt(sc.nextLine()));
                    libroC.addLibro(newLibro);
                    libros=libroC.listLibros();
                    break;

                case "2":

                    // Creacion de un nuevo miembro dentro de la lista
                    Miembro newMiembro = new Miembro();
                    System.out.println("\n---- NUEVO MIEMBRO ----");

                    //Busca el ultimo id ingresado para crear el del nuevo miembro
                    newMiembro.setId(miembros.getLast().getId()+1);
                    

                    //Se establecen el resto de los valores
                    System.out.print("Ingrese el nombre del nuevo miembro : ");
                    newMiembro.setNombre(sc.nextLine());
                    System.out.print("Ingrese el telefono : ");
                    newMiembro.setTelefono(sc.nextLine());
                    System.out.print("Ingrese la edad : ");
                    newMiembro.setEdad(Integer.parseInt(sc.nextLine()));

                    miembroC.addMiembro(newMiembro);
                    miembros = miembroC.listMiembros();

                    break;

                case "3":
                    Sucursal newSucursal = new Sucursal();
                    System.out.println("\n---- NUEVA SUCURSAL ----");
                    Boolean nombreExists = true;
                    while(nombreExists){
                        System.out.print("Ingrese el nombre de la sucursal: ");
                        String intentoNombre = sc.nextLine();
    
                        nombreExists = false; 
                        for(Sucursal sucursal : sucursales){
                            if (sucursal.getNombre().equals(intentoNombre)){
                                nombreExists = true;
                            }
                        }
                        if (nombreExists){
                            System.out.print(">>>Ya existe esa sucursal\n");
                        }
                        else{
                            newSucursal.setNombre(intentoNombre);
                            newSucursal.setId(sucursales.getLast().getId()+1);
                        }
                    }
                    System.out.print("Ingrese la direccion: ");
                    newSucursal.setDireccion(sc.nextLine());
                    sucursalC.addSucursal(newSucursal);
                    sucursales = sucursalC.listSucursales();
                    break;

                case "4":
                    Prestamo newPrestamo = new Prestamo();
                    System.out.println("\n---- NUEVO PRESTAMO ----");

                    Boolean miembroExists = false;
                    System.out.print("Ingrese el id del miembro: ");
                    int intentoMiembro = Integer.parseInt(sc.nextLine());
                    while(!miembroExists){
                        for(Miembro miembro : miembros){
                            if (miembro.getId() == intentoMiembro){
                                miembroExists = true;
                            }
                        }
                        if (miembroExists) {
                            newPrestamo.setIdMiembro(intentoMiembro);
                        }else{
                            System.out.print("No existe, ingrese otro: ");
                            intentoMiembro = Integer.parseInt(sc.nextLine());
                        }
                    }    
                    Date fechai = new Date(); 
                    Calendar dias = Calendar.getInstance();
                    dias.setTime(fechai);
                    newPrestamo.setFechaPrestamo(fechai);
                    dias.add(Calendar.DAY_OF_MONTH, 7);
                    Date fechaf = dias.getTime();
                    newPrestamo.setFechaDevolucion(fechaf);
                   

                    Boolean libroExists = false;
                    System.out.print("Ingrese el ISBN del libro que quiere prestar: ");
                    String intentoLibro = sc.nextLine();
                    Libro libroPrestamo = null;
                    while(!libroExists){
                        
                        for (Libro libro : libros){
                            if (libro.getIsbn().equals(intentoLibro) ){
                                libroExists = true;
                                libroPrestamo = libro;
                            }
                        }
                        if (libroExists) {
                            System.out.print(">>>libro encontrado");
                            if(libroPrestamo.getDisponibles() > 0){
                                newPrestamo.setISBNLibro(libroPrestamo.getIsbn());
                                newPrestamo.setIdSucursal(libroPrestamo.getIdSucursal());
                                newPrestamo.setActivo(true);
                            }
                            else{
                                System.out.println(">>>No contamos con copias del libro por el momento\n");
                            }
                        }
                        else{
                            System.out.print("No existe, ingrese otro: ");
                            intentoLibro = sc.nextLine();
                        }
                    }
                    
                    prestamoC.addPrestamo(newPrestamo);
                    prestamos = prestamoC.listPrestamos();
                    break;

                case "5":
                    System.out.println("-- LISTA DE PRESTAMOS --");
                    List<Prestamo> presatmosActivos=new ArrayList<>(); 
                    Prestamo prestamoFind = new Prestamo();
                    for( int i =0; i<prestamos.size(); i++){
                        if(prestamos.get(i).getActivo()==true){
                            presatmosActivos.add(prestamos.get(i));
                            System.out.println("    "+(i+1)+". "+prestamos.get(i).toString());
                        }
                    }
                    System.out.println("Ingrese el numero prestamo que desea cambiar de estado");
                    int indexPrestamo = Integer.parseInt(sc.nextLine());
                    if (1>indexPrestamo || indexPrestamo>prestamos.size()) {
                        System.out.println("Este prestamo no existe");
                    }else{
                        prestamoFind = prestamos.get(indexPrestamo-1);
                        for(Prestamo prestamo: prestamos){
                            if(prestamo.equals(prestamoFind)){
                                prestamo.setActivo(false);
                            }
                        }
                        //update csv
                        prestamoC.updatePrestamo(prestamoFind, indexPrestamo);
                        prestamos=prestamoC.listPrestamos();
                    }
                    
                    break;

                case "6":
                    Boolean repeatMenuEstaditicas=true;
                    while (repeatMenuEstaditicas){
                        System.out.print("\n----- ESTADISTICAS ------"+
                                        "\n1. Cantidad de libros prestados"+
                                        "\n2. Generos mas solicitados"+
                                        "\n3. Libro mas prestado"+
                                        "\n4. Salir"+
                                        "\n\nIngrese su opcion : ");
                        String optionMenuEstadisticas = sc.nextLine();
                        switch (optionMenuEstadisticas) {
                            case "1":

                                Boolean inicioVacio = true;
                                Date inicioRango = null;
                                while(inicioVacio){
                                    System.out.print("Ingrese la fecha de inicio (DD-MM-YYYY): "); 
                                    try{
                                        inicioRango = formato.parse(sc.nextLine());
                                        inicioVacio = false;
                                    } catch(ParseException e ){
                                        System.out.println("Error al ingresar fecha, recuerda utilizar el formato descrito");
                                    }
                                }

                                Date finRango = null;
                                Boolean finVacio = true;
                                while(finVacio){
                                    System.out.print("Ingrese la fecha de fin (DD-MM-YYYY): "); 
                                    try{
                                        finRango = formato.parse(sc.nextLine());
                                        finVacio = false;
                                    } catch(ParseException e ){
                                        System.out.println("Error al ingresar fecha, recuerda utilizar el formato descrito");
                                    }
                                }

                                int librosPrestados = 0;
                                for(Prestamo prestamos_index : prestamos){
                                    if(prestamos_index.getFechaPrestamo().after(inicioRango) && prestamos_index.getFechaPrestamo().before(finRango)){
                                        librosPrestados++;
                                    }
                                }

                                System.out.println("\n<<Entre esas fechas se prestaron " + librosPrestados + " libros>>");
                                break;

                            case "2":
                                
                                ArrayList<String> generos = new ArrayList<>();
                                String libroPedido = null; 
                                for (Prestamo prestamo_index : prestamos){
                                    libroPedido = prestamo_index.getISBNLibro();

                                    for (Libro libro : libros){
                                        if(libroPedido.equals(libro.getIsbn())){

                                            generos.add(libro.getGenero());
                                        }
                                    }
                                }
                               
                                //Convertir lista de generos a mapa
                                Map<String, Integer> conteoGenero = new HashMap<>();
                                for (String genero_index : generos){
                                    conteoGenero.put(genero_index, conteoGenero.getOrDefault(genero_index, 0) + 1);
                                }

                                //Ordenar la lista
                                List<Map.Entry<String, Integer>> ordenamiento = new ArrayList<>(conteoGenero.entrySet());
                                ordenamiento.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

                                //Obtener los tres generos mas pedidos
                                List<String> top3Generos = new ArrayList<>();
                                    for(int top = 0; top < 3 && top < ordenamiento.size(); top++){
                                        top3Generos.add(ordenamiento.get(top).getKey());
                                    }

                                    System.out.println("Los tres generos mas pedidos son: " + top3Generos + "\n");
                                
                                break;

                            case "3":
                            ArrayList<String> isbnPlural = new ArrayList<>();
                            for (Prestamo prestamo_index : prestamos){
                                isbnPlural.add(prestamo_index.getISBNLibro());
                            }

                            //Convertir lista de generos a mapa
                            Map<String, Integer> conteoISBN = new HashMap<>();
                            for (String isbn : isbnPlural){
                                conteoISBN.put(isbn, conteoISBN.getOrDefault(isbn, 0) + 1);
                            }

                            //Ordenar la lista
                            List<Map.Entry<String, Integer>> ordenamiento2 = new ArrayList<>(conteoISBN.entrySet());
                            ordenamiento2.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

                            //Obtener libro mas pedido
                            String topLibro = ordenamiento2.get(0).getKey();
                            String tituloTopLibro = null;
                                for(Libro libro: libros){
                                    if(libro.getIsbn().equals(topLibro)){
                                        tituloTopLibro = libro.getTitulo();
                                    }
                                }

                                System.out.println("El libro mas pedido es: " + tituloTopLibro + "\n");


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