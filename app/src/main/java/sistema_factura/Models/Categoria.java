package sistema_factura.Models;

import java.time.LocalDate;

public class Categoria {

    private int idCategoria;
    private String nombreCategoria;
    private String descripcion;
    private String estado; // Podrías usar un Enum si quieres limitarlo a "Activo" y "Inactivo"
    private LocalDate fechaRegistro;

    // Constructor vacío
    public Categoria() {
    }

    // Constructor con parámetros
    public Categoria(int idCategoria, String nombreCategoria, String descripcion, String estado, LocalDate fechaRegistro) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y Setters

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
