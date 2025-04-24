package sistema_factura.Models;

public class Users {
    private int idUsuario;
    private String dniUsuario;
    private String privilegio;
    private String nombreUsuario;
    private String correoUsuario;
    private String contraseñaUsuario;
    private java.sql.Date fechaRegistro;

 

    public Users() {
    }


    public Users(int idUsuario, String dniUsuario, String privilegio, String nombreUsuario, String correoUsuario, String contraseñaUsuario, java.sql.Date fechaRegistro) {
        this.idUsuario = idUsuario;
        this.dniUsuario = dniUsuario;
        this.privilegio = privilegio;
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
        this.fechaRegistro = fechaRegistro;
    }


    public int getIdUsuario() {
        return idUsuario;
    }


    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    public String getDniUsuario() {
        return dniUsuario;
    }


    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }


    public String getPrivilegio() {
        return privilegio;
    }


    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }


    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    public String getCorreoUsuario() {
        return correoUsuario;
    }


    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }


    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }


    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }


    public java.sql.Date getFechaRegistro() {
        return fechaRegistro;
    }


    public void setFechaRegistro(java.sql.Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    


}
