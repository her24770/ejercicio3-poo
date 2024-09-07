package modells;
import java.util.Date;
/**
 * Clase que almacena los datos de cada prestamo
 * @author Gabriel Hidalgo 
 */
public class Prestamo {
    public int idMiembro;
    public Date fechaPrestamo;
    public Date fechaDevolucion;
    public int idSucursal;
    public String ISBNLibro;
    public Boolean activo;

    /**
     * Constructor personalizado
     * @param idMiembro identificador del miembro que aprobó el prestamo
     * @param fechaPrestamo fecha en que inició el prestamo
     * @param fechaDevolucion fecha en que deberá devolverse el libro
     * @param idSucursal identificador de la sucursal donde se encuentra el libro
     * @param ISBNLibro Identificador ISBN del libro
     * @param activo determina si aun debe devolverse o no el libro
     */
    public Prestamo(int idMiembro, Date fechaPrestamo, Date fechaDevolucion, int idSucursal, String ISBNLibro, Boolean activo){
        this.idMiembro = idMiembro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.idSucursal = idSucursal;
        this.ISBNLibro = ISBNLibro;
        this.activo = activo;
    }

    /**
     * constructor predeterminado
     */
    public Prestamo(){
    }

    //Metodos

    /**
     * @param idMiembro identificador del miembro
     */
    public void setIdMiembro(int idMiembro){
        this.idMiembro = idMiembro;
    }

    /**
     * @return identificador del miembro
     */
    public int getIdMiembro(){
        return idMiembro;
    }

    /**
     * @param fechaPrestamo fecha de inicio del prestamo
     */
    public void setFechaPrestamo(Date fechaPrestamo){
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * @return fecha de inicio del prestamo
     */
    public Date getFechaPrestamo(){
        return fechaPrestamo;
    }

    /**
     * @param fechaDevolucion fecha en que debe devolverse el libro
     */
    public void setFechaDevolucion(Date fechaDevolucion){
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * @return fecha en que debe devolverse el libro
     */
    public Date getFechaDevolucion(){
        return fechaDevolucion;
    }

    /**
     * @param idSucursal identificador de la sucursal en que se encuentra el libro prestado
     */
    public void setIdSucursal(int idSucursal){
        this.idSucursal = idSucursal;
    }

    /**
     * @return identificador de la sucursal donde se encuentra el libro
     */
    public int getIdSucursal(){
        return idSucursal;
    }

    /**
     * @param ISBNLibro identificador del libro prestado
     */
    public void setISBNLibro(String ISBNLibro){
        this.ISBNLibro = ISBNLibro;
    }

    /**
     * @return identificador del libro prestado
     */
    public String getISBNLibro(){
        return ISBNLibro;
    }

    /**
     * @param activo estado de prestamo
     */
    public void setActivo(Boolean activo){
        this.activo = activo;
    }

    /**
     * @return el estado de si se devolvió el libro o no
     */
    public Boolean getActivo(){
        return activo;
    }

    /**
     * Devuelve los valores del objeto
     */
    public String toString(){
        return "Prestamo del libro ("+ISBNLibro+") realizado por " + idMiembro + " del "+fechaPrestamo+" al "+ fechaDevolucion + " en la sucursal "+ idSucursal +" \n";
    }

}
