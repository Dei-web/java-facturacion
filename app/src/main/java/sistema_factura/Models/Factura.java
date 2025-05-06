package sistema_factura.Models;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Factura {

    private int idFactura;
    private LocalDateTime fechaRegistro;
    private Integer idCliente;
    private Integer idUsuarioVendedor;
    private BigDecimal totalVenta;
    private String estado; // Se puede usar un Enum si prefieres

    // Constructor vacío
    public Factura() {
    }

    // Constructor con parámetros
    public Factura(int idFactura, LocalDateTime fechaRegistro, Integer idCliente, Integer idUsuarioVendedor, BigDecimal totalVenta, String estado) {
        this.idFactura = idFactura;
        this.fechaRegistro = fechaRegistro;
        this.idCliente = idCliente;
        this.idUsuarioVendedor = idUsuarioVendedor;
        this.totalVenta = totalVenta;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdUsuarioVendedor() {
        return idUsuarioVendedor;
    }

    public void setIdUsuarioVendedor(Integer idUsuarioVendedor) {
        this.idUsuarioVendedor = idUsuarioVendedor;
    }

    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
