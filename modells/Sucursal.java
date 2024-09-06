package modells;

public class Sucursal {
    private int id;
    private String nombre;
    private String direccion;

    //Metodos
    public Sucursal(int id, String nombre, String direccion){
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Sucursal(){
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

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getDireccion(){
        return direccion;
    }

    public String toString(){
        return nombre +
        ", " + direccion;
    }
}