import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------Bienvenido----");
        
        Boolean repeatMenu=true;
        while (repeatMenu) {
            System.out.print("\n------MENU---"+
                                "\n1. Agregar nuevo Libro"+
                                "\n2. Agregar nuevo miembro"+
                                "\n3. Agregar Sucursal"+
                                "\n4. Agregar Sucursal"+
                                "\n5. Prestamo del libro"+
                                "\n6. Devolución de un libro"+
                                "\n7. Estadisticas"+
                                "\n8. Salir"+
                                "\nIngrese su opcion : "
                                );
            String otpionMenu = sc.nextLine();
            switch (otpionMenu) {
                case "1":
                    
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
                    
                    break;

                case "7":
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

                case "8":
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