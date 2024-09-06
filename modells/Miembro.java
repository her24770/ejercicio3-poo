package modells;

public class Miembro {
    public int id;
    public String nombre;
    public String telefono;
    public int edad;

    public Miembro(int id, String nombre, String telefono, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
    }

    //Metodos

    public Miembro(){
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public int getEdad(){
        return edad;
    }

    public String toString(){
        return "\nIdentificador: " + id +
        "\nNombre: " + nombre +
        "\nNo. Telefono: " + telefono + 
        "\nEdad: " + edad + "\n";
    }
}
