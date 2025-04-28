package sistema_factura.Models;


import java.math.BigDecimal;
import java.time.LocalDate;

public class Producto {

    private int idProducto;
    private String nombreProducto;
    private BigDecimal precioProducto;
    private int stockProducto;
    private String descripcionProducto;
    private String categoriaProducto;
    private LocalDate fechaRegistro;
    private Estado estado;
    private Integer idCategoriaProducto;

    public enum Estado {
        Activo,
        Inactivo
    }

    public Producto() {
        this.fechaRegistro = LocalDate.now(); 
    }

    public Producto(int idProducto, String nombreProducto, BigDecimal precioProducto, int stockProducto,
                    String descripcionProducto, String categoriaProducto, LocalDate fechaRegistro,
                    Estado estado, Integer idCategoriaProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.stockProducto = stockProducto;
        this.descripcionProducto = descripcionProducto;
        this.categoriaProducto = categoriaProducto;
        this.fechaRegistro = (fechaRegistro != null) ? fechaRegistro : LocalDate.now();
        this.estado = estado;
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Integer getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(Integer idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    
}
