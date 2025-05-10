package sistema_factura.Models;

import java.time.LocalDate;

public class Categoria {

    private int idCategoria;
    private String nombreCategoria;
    private String descripcion;
    private Estado estado; 
    private LocalDate fechaRegistro;

    public enum Estado {
        Activo,
        Inactivo
    }

    public Categoria() {
    }

    
    public Categoria(int idCategoria, String nombreCategoria, String descripcion, Estado estado, LocalDate fechaRegistro) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
        this.estado = (estado != null) ? estado : Estado.Inactivo;
        this.fechaRegistro = (fechaRegistro != null) ? fechaRegistro : LocalDate.now();
    }

    

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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
