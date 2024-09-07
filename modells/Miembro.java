package modells;

/**
 * Clase que almacena los datos de cada miembro
 * @author Juan Daniel Ordoñez 
 */


public class Miembro {
    public int id;
    public String nombre;
    public String telefono;
    public int edad;

    /**
     * Constructor personalizado
     * @param id Identificador del miembro
     * @param nombre Nombre del miembro
     * @param numero de Telefono del miembro
     * @param edad La edad del miembro
     */
    public Miembro(int id, String nombre, String telefono, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
    }

    //Constructor Predeterminado
    public Miembro(){
    }

    //Metodos

    /**
     * @param id El identificador del Miembro
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * @return El identificador del Miembro
     */
    public int getId(){
        return id;
    }

    /**
     * @param nombre El nombre del miembro
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * @return El nombre del miembro
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * @param telefono Numero de telefono del miembro
     */
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    /**
     * @return Numero de telefono del miembro
     */
    public String getTelefono(){
        return telefono;
    }

    /**
     * @param edad La edad del miembro
     */
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    /**
     * @return La edad del miembro 
     */
    public int getEdad(){
        return edad;
    }

    /**
     * Devuelve los valores del objeto
     */
    public String toString(){
        return "\nIdentificador: " + id +
        "\nNombre: " + nombre +
        "\nNo. Telefono: " + telefono + 
        "\nEdad: " + edad + "\n";
    }
}
