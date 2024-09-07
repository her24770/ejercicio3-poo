package modells;

/**
 * Clase que almacena los datos de cada Sucursal
 * @author Josue Hernandez 
 */

public class Sucursal {
    private int id;
    private String nombre;
    private String direccion;

    /**
     * Constructor personalizado
     * @param id Identificador de la Sucursal
     * @param nombre El nombre de la sucursal
     * @param direccion La direccion de la sucursal
     */
    public Sucursal(int id, String nombre, String direccion){
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     * Constructor Predeterminado
     */
    public Sucursal(){
    }

    //Metodos

    /**
     * @param id Identificador de la sucursal
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * @return Identificador de la sucursal
     */
    public int getId(){
        return id;
    }

    /**
     * @param nombre Nombre de la Sucursal
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * @return Nombre de la Sucursal
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * @param direccion Direccion de la sucursal
     */
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    /**
     * @return Direccion de la Sucursal
     */
    public String getDireccion(){
        return direccion;
    }

    /**
     * Devuelve los valores del objeto
     */
    public String toString(){
        return nombre +
        ", " + direccion;
    }
}