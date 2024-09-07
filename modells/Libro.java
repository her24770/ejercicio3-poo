package modells;

/**
 * Libro es la clase en la que se creara cada libro y se almacenara la informacion de cada uno
 * @author Josue Hernandez 
 */

public class Libro {
    private String isbn;
    private String titulo; 
    private String autor;
    private String fechaPublicacion;
    private String genero;
    private int idSucursal;
    private int disponibles;

    /**
     * Constructor personalizado
     * @param isbn identificador del libro
     * @param titulo El titulo del libro
     * @param autor El autor del libro
     * @param fechaPublicacion La fecha en la que se publico el libro
     * @param genero El genero al que pertenece el libro
     * @param idSucursal El identificador de la sucursal en la que se encuentra el libro
     * @param disponibles El numero de libros que hay disponibles de este mismo
     */
    public Libro(String isbn, String titulo, String autor, String fechaPublicacion, String genero, int idSucursal,
            int disponibles) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.genero = genero;
        this.idSucursal = idSucursal;
        this.disponibles = disponibles;
    }

    //Constructor Predeterminado
    public Libro() {
    }

    /**
     * @return El ismb del libro
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn el isbn del libro
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return El titulo del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo El titulo del libro
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return El Autor del Libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autorEl Autor del Libro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return La Fecha de publicacion del libro
     */
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * @param fechaPublicacion La Fecha de publicacion del libro
     */
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * @return El Genero al que pertenece el contenido del libro
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero El Genero al que pertenece el contenido del libro
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return El id del Sucursal en el que se encuentra el libro
     */
    public int getIdSucursal() {
        return idSucursal;
    }

    /**
     * @param idSucursal El id del Sucursal en el que se encuentra el libro
     */
    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    /**
     * @return El numero de libros que hay disponibles de este mismo
     */
    public int getDisponibles() {
        return disponibles;
    }

    /**
     * @param disponibles El numero de libros que hay disponibles de este mismo
     */
    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    /**
     * Devuelve los valores del objeto
     */
    public String toString() {
        return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", fechaPublicacion="
                + fechaPublicacion + ", genero=" + genero + ", idSucursal=" + idSucursal + ", disponibles="
                + disponibles + "]";
    }
    
}