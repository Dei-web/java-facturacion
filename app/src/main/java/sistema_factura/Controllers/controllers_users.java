package sistema_factura.Controllers;

import sistema_factura.Database.ConfigDB;
import sistema_factura.Models.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
import sistema_factura.Models.Cliente;
import sistema_factura.Models.provedor;

public class controllers_users {

    ConfigDB config = new ConfigDB();
    private Connection connection = config.getConnection();

    // Users crud operations  <>
    public boolean Inser_User(Users user) {
       
        String sql = "INSERT INTO usuario (dni_usuario, privilegio, nombre_usuario, correo_usuario, contraseña_usuario) " +
        "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getDniUsuario());
            preparedStatement.setString(2, user.getPrivilegio());
            preparedStatement.setString(3, user.getNombreUsuario());
            preparedStatement.setString(4, user.getCorreoUsuario());
            String hashedPassword = BCrypt.hashpw(user.getContraseñaUsuario(), BCrypt.gensalt());
            preparedStatement.setString(5, hashedPassword);
            int rowsAffected = preparedStatement.executeUpdate();
           
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar el usuario: " + e.getMessage());
            return false;

        }
        
    }

    public boolean Update_User(Users user) {
        String sql = "UPDATE usuario SET dni_usuario = ?, privilegio = ?, nombre_usuario = ?, correo_usuario = ?, contraseña_usuario = ? WHERE id_usuario = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getDniUsuario());
            preparedStatement.setString(2, user.getPrivilegio());
            preparedStatement.setString(3, user.getNombreUsuario());
            preparedStatement.setString(4, user.getCorreoUsuario());
            String hashedPassword = BCrypt.hashpw(user.getContraseñaUsuario(), BCrypt.gensalt());
            preparedStatement.setString(5, hashedPassword);
            preparedStatement.setInt(6, user.getIdUsuario());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
            return false;
        }
    }
    public boolean Delete_User(int id) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
            return false;
        }
    }

    public Users getUserByDni(String dni) {
        String sql = "SELECT * FROM usuario WHERE dni_usuario = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, dni);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Users user = new Users();
                user.setIdUsuario(resultSet.getInt("id_usuario"));
                user.setDniUsuario(resultSet.getString("dni_usuario"));
                user.setPrivilegio(resultSet.getString("privilegio"));
                user.setNombreUsuario(resultSet.getString("nombre_usuario"));
                user.setCorreoUsuario(resultSet.getString("correo_usuario"));
                user.setContraseñaUsuario(resultSet.getString("contraseña_usuario"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el usuario: " + e.getMessage());
        }
        return null;
    }
   
    
    // Users crud operations <>

    // Client crud operations <>

    public boolean Inser_Client(Cliente client) {
        String sql = "INSERT INTO cliente (nombre_cliente, apellido_cliente, dni_cliente, telefono_cliente, direccion_cliente, estado) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, client.getNombre());
            preparedStatement.setString(2, client.getApellido());
            preparedStatement.setString(3, client.getDni());
            preparedStatement.setString(4, client.getTelefono());
            preparedStatement.setString(5, client.getDireccion());
            preparedStatement.setString(6, client.getEstado());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar el cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean Update_Client(Cliente client) {
        String sql = "UPDATE cliente SET nombre_cliente = ?, apellido_cliente = ?, dni_cliente = ?, telefono_cliente = ?, direccion_cliente = ?, estado = ? WHERE id_cliente = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, client.getNombre());
            preparedStatement.setString(2, client.getApellido());
            preparedStatement.setString(3, client.getDni());
            preparedStatement.setString(4, client.getTelefono());
            preparedStatement.setString(5, client.getDireccion());
            preparedStatement.setString(6, client.getEstado());
            preparedStatement.setInt(7, client.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean Delete_Client(int id) {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
            return false;
        }
    }
    
    public Cliente getClientByDni(String dni) {
        String sql = "SELECT * FROM cliente WHERE dni_cliente = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, dni);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Cliente client = new Cliente();
                client.setId(resultSet.getInt("id_cliente"));
                client.setNombre(resultSet.getString("nombre_cliente"));
                client.setApellido(resultSet.getString("apellido_cliente"));
                client.setDni(resultSet.getString("dni_cliente"));
                client.setTelefono(resultSet.getString("telefono_cliente"));
                client.setDireccion(resultSet.getString("direccion_cliente"));
                client.setEstado(resultSet.getString("estado"));
                return client;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el cliente: " + e.getMessage());
        }
        return null;
    }

    // Client crud operations <>
    // Provedor crud operations <>


    public boolean Insert_provedor(provedor prov) {
        String sql = "INSERT INTO proveedor (pais_proveedor, ciudad_proveedor, tipo_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor, correo_proveedor, fecha_registro, condiciones_pago, estado) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, prov.getPaisProveedor());
            preparedStatement.setString(2, prov.getCiudadProveedor());
            preparedStatement.setString(3, prov.getTipoProveedor().name());
            preparedStatement.setString(4, prov.getDireccionProveedor());
            preparedStatement.setString(5, prov.getNombreProveedor());
            preparedStatement.setString(6, prov.getTelefonoProveedor());
            preparedStatement.setString(7, prov.getCorreoProveedor());
            preparedStatement.setDate(8, java.sql.Date.valueOf(prov.getFechaRegistro()));
            preparedStatement.setString(9, prov.getCondicionesPago());
            preparedStatement.setString(10, prov.getEstado().name());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar el proveedor: " + e.getMessage());
            return false;
        }
        
    }


    public boolean Update_provedor(provedor prov) {
        String sql = "UPDATE proveedor SET pais_proveedor = ?, ciudad_proveedor = ?, tipo_proveedor = ?, direccion_proveedor = ?, nombre_proveedor = ?, telefono_proveedor = ?, correo_proveedor = ?, fecha_registro = ?, condiciones_pago = ?, estado = ? WHERE id_proveedor = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, prov.getPaisProveedor());
            preparedStatement.setString(2, prov.getCiudadProveedor());
            preparedStatement.setString(3, prov.getTipoProveedor().name());
            preparedStatement.setString(4, prov.getDireccionProveedor());
            preparedStatement.setString(5, prov.getNombreProveedor());
            preparedStatement.setString(6, prov.getTelefonoProveedor());
            preparedStatement.setString(7, prov.getCorreoProveedor());
            preparedStatement.setDate(8, java.sql.Date.valueOf(prov.getFechaRegistro()));
            preparedStatement.setString(9, prov.getCondicionesPago());
            preparedStatement.setString(10, prov.getEstado().name());
            preparedStatement.setInt(11, prov.getIdProveedor());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el proveedor: " + e.getMessage());
            return false;
        }
    }
    public boolean Delete_provedor(int id) {
        String sql = "DELETE FROM proveedor WHERE id_proveedor = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el proveedor: " + e.getMessage());
            return false;
        }
    }



    public provedor getProvedorById(int id) {
        String sql = "SELECT * FROM proveedor WHERE id_proveedor = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                provedor prov = new provedor();
                prov.setIdProveedor(resultSet.getInt("id_proveedor"));
                prov.setPaisProveedor(resultSet.getString("pais_proveedor"));
                prov.setCiudadProveedor(resultSet.getString("ciudad_proveedor"));
                prov.setTipoProveedor(provedor.TipoProveedor.valueOf(resultSet.getString("tipo_proveedor")));
                prov.setDireccionProveedor(resultSet.getString("direccion_proveedor"));
                prov.setNombreProveedor(resultSet.getString("nombre_proveedor"));
                prov.setTelefonoProveedor(resultSet.getString("telefono_proveedor"));
                prov.setCorreoProveedor(resultSet.getString("correo_proveedor"));
                prov.setFechaRegistro(resultSet.getDate("fecha_registro").toLocalDate());
                prov.setCondicionesPago(resultSet.getString("condiciones_pago"));
                prov.setEstado(provedor.Estado.valueOf(resultSet.getString("estado")));
                return prov;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el proveedor: " + e.getMessage());
        }
        return null;
    }



    // Provedor crud operations <>

}
