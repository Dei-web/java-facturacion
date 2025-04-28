package sistema_factura.Models;

import java.time.LocalDate;

public class provedor {

    private int idProveedor;
    private String paisProveedor;
    private String ciudadProveedor;
    private TipoProveedor tipoProveedor;
    private String direccionProveedor;
    private String nombreProveedor;
    private String telefonoProveedor;
    private String correoProveedor;
    private LocalDate fechaRegistro;
    private String condicionesPago;
    private Estado estado;

    public enum TipoProveedor {
        Nacional,
        Internacional
    }

    public enum Estado {
        Activo,
        Inactivo
    }

    public provedor(int idProveedor, String paisProveedor, String ciudadProveedor, TipoProveedor tipoProveedor,
            String direccionProveedor, String nombreProveedor, String telefonoProveedor, String correoProveedor,
            LocalDate fechaRegistro, String condicionesPago, Estado estado) {
        this.idProveedor = idProveedor;
        this.paisProveedor = paisProveedor;
        this.ciudadProveedor = ciudadProveedor;
        this.tipoProveedor = tipoProveedor;
        this.direccionProveedor = direccionProveedor;
        this.nombreProveedor = nombreProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.correoProveedor = correoProveedor;
        this.fechaRegistro = (fechaRegistro != null) ? fechaRegistro : LocalDate.now();
        this.condicionesPago = condicionesPago;
        this.estado = (estado != null) ? estado : Estado.Inactivo;
    }

    public provedor() {

    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getPaisProveedor() {
        return paisProveedor;
    }

    public void setPaisProveedor(String paisProveedor) {
        this.paisProveedor = paisProveedor;
    }

    public String getCiudadProveedor() {
        return ciudadProveedor;
    }

    public void setCiudadProveedor(String ciudadProveedor) {
        this.ciudadProveedor = ciudadProveedor;
    }

    public TipoProveedor getTipoProveedor() {
        return tipoProveedor;
    }

    public void setTipoProveedor(TipoProveedor tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getCorreoProveedor() {
        return correoProveedor;
    }

    public void setCorreoProveedor(String correoProveedor) {
        this.correoProveedor = correoProveedor;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCondicionesPago() {
        return condicionesPago;
    }

    public void setCondicionesPago(String condicionesPago) {
        this.condicionesPago = condicionesPago;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    
    
}
