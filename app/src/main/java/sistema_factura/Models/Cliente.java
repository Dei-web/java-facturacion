package sistema_factura.Models;

public class Cliente {
    private int id; // opcional, si querés usarlo para lectura
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String direccion;
    private String estado; // "Activo" o "Inactivo"

    // Constructor sin ID (para inserciones)
    public Cliente(String nombre, String apellido, String dni, String telefono, String direccion, String estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }

    // Constructor con ID (para lectura desde base de datos)
    public Cliente(int id, String nombre, String apellido, String dni, String telefono, String direccion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }


    // Constructor vacío (opcional, si necesitas crear un objeto sin inicializar)
    public Cliente() {
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEstado() {
        return estado;
    }

    // Setters (opcional, si vas a editar datos)
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
