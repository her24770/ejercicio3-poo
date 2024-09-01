package modells;
import java.util.Date;

public class Prestamo {
    public int idMiembro;
    public Date fechaPrestamo;
    public Date fechaDevolucion;
    public int idSucursal;
    public String ISBNLibro;
    public Boolean activo;
    
    //Metodos

    public Prestamo(){
    }

    public void setIdMiembro(int idMiembro){
        this.idMiembro = idMiembro;
    }

    public int getIdMiembro(){
        return idMiembro;
    }

    public void setFechaPrestamo(Date fechaPrestamo){
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaPrestamo(){
        return fechaPrestamo;
    }

    public void setFechaDevolucion(Date fechaDevolucion){
        this.fechaDevolucion = fechaDevolucion;
    }

    public Date getFechaDevolucion(){
        return fechaDevolucion;
    }

    public void setIdSucursal(int idSucursal){
        this.idSucursal = idSucursal;
    }

    public int getIdSucursal(){
        return idSucursal;
    }

    public void setISBNLibro(String ISBNLibro){
        this.ISBNLibro = ISBNLibro;
    }

    public String getISBNLibro(){
        return ISBNLibro;
    }

    public void setActivo(Boolean activo){
        this.activo = activo;
    }

    public Boolean getActivo(){
        return activo;
    }

    public String toString(){
        return "\nId del Miembro: " + idMiembro +
        "\nInicio prestamo: " + fechaPrestamo +
        "\nFin prestamo : " + fechaDevolucion +
        "\nId de la Sucursal: " + idSucursal +
        "\nISBN: " + ISBNLibro +
        "\nPrestamo activo: " + activo + "\n"; 
    }

}
