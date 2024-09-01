package modells;

/**
 * Libro
 */
public class Libro {
    private String isbn;
    private String titulo; 
    private String autor;
    private String fechaPublicacion;
    private String genero;
    private int idSucursal;
    private int disponibles;

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

    public Libro() {
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getIdSucursal() {
        return idSucursal;
    }
    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }
    public int getDisponibles() {
        return disponibles;
    }
    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    @Override
    public String toString() {
        return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", fechaPublicacion="
                + fechaPublicacion + ", genero=" + genero + ", idSucursal=" + idSucursal + ", disponibles="
                + disponibles + "]";
    }
    
}