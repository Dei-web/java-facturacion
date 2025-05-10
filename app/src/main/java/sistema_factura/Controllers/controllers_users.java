package sistema_factura.Controllers;

import sistema_factura.Database.ConfigDB;
import sistema_factura.Models.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.checkerframework.checker.units.qual.C;
import org.mindrot.jbcrypt.BCrypt;
import sistema_factura.Models.Cliente;
import sistema_factura.Models.provedor;
import sistema_factura.Models.Producto;
import sistema_factura.Models.Categoria;

public class controllers_users {

    ConfigDB config = new ConfigDB();
    private Connection connection = config.getConnection();


//login method

    public boolean login(String nombreUsuario, String contraseñaUsuario) {
        String sql = "SELECT contraseña_usuario FROM usuario WHERE nombre_usuario = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nombreUsuario);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String hashedPassword = resultSet.getString("contraseña_usuario");
                return BCrypt.checkpw(contraseñaUsuario, hashedPassword);
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar el usuario: " + e.getMessage());
        }
        return false;
    }


    public static boolean verifyPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }


    //login method


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
    // Producto crud operations <>



    public boolean Insert_Producto(Producto producto) {
        String sql = "INSERT INTO producto (nombre_producto, precio_producto, stock_producto, descripcion_producto, categoria_producto, fecha_registro, estado, id_categoria_producto) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, producto.getNombreProducto());
            preparedStatement.setBigDecimal(2, producto.getPrecioProducto());
            preparedStatement.setInt(3, producto.getStockProducto());
            preparedStatement.setString(4, producto.getDescripcionProducto());
            preparedStatement.setString(5, producto.getCategoriaProducto());
            preparedStatement.setDate(6, java.sql.Date.valueOf(producto.getFechaRegistro()));
            preparedStatement.setString(7, producto.getEstado().name());
            preparedStatement.setInt(8, producto.getIdCategoriaProducto());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar el producto: " + e.getMessage());
            return false;
        }
    }

    public boolean Update_Producto(Producto producto) {
        String sql = "UPDATE producto SET nombre_producto = ?, precio_producto = ?, stock_producto = ?, descripcion_producto = ?, categoria_producto = ?, fecha_registro = ?, estado = ?, id_categoria_producto = ? WHERE id_producto = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, producto.getNombreProducto());
            preparedStatement.setBigDecimal(2, producto.getPrecioProducto());
            preparedStatement.setInt(3, producto.getStockProducto());
            preparedStatement.setString(4, producto.getDescripcionProducto());
            preparedStatement.setString(5, producto.getCategoriaProducto());
            preparedStatement.setDate(6, java.sql.Date.valueOf(producto.getFechaRegistro()));
            preparedStatement.setString(7, producto.getEstado().name());
            preparedStatement.setInt(8, producto.getIdCategoriaProducto());
            preparedStatement.setInt(9, producto.getIdProducto());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
            return false;
        }
    }

    public boolean Delete_Producto(int id) {
        String sql = "DELETE FROM producto WHERE id_producto = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
            return false;
        }
    }

    public Producto getProductoById(int id) {
        String sql = "SELECT * FROM producto WHERE id_producto = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(resultSet.getInt("id_producto"));
                producto.setNombreProducto(resultSet.getString("nombre_producto"));
                producto.setPrecioProducto(resultSet.getBigDecimal("precio_producto"));
                producto.setStockProducto(resultSet.getInt("stock_producto"));
                producto.setDescripcionProducto(resultSet.getString("descripcion_producto"));
                producto.setCategoriaProducto(resultSet.getString("categoria_producto"));
                producto.setFechaRegistro(resultSet.getDate("fecha_registro").toLocalDate());
                producto.setEstado(Producto.Estado.valueOf(resultSet.getString("estado")));
                return producto;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el producto: " + e.getMessage());
        }
        return null;
    }



    // Producto crud operations <>
    
    // Category crud operations <>

    public boolean create_categoria(Categoria categoria) {
        String sqString = "INSERT INTO categoria (nombre_categoria, descripcion, estado, fecha_registro) " +
                "VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqString)) {
            preparedStatement.setString(1, categoria.getNombreCategoria());
            preparedStatement.setString(2, categoria.getDescripcion());
            preparedStatement.setString(3, categoria.getEstado().name());
            preparedStatement.setDate(4, java.sql.Date.valueOf(categoria.getFechaRegistro()));
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar la categoria: " + e.getMessage());
            return false;
        }
    }

    public boolean update_categoria(Categoria categoria) {
        String sql = "UPDATE categoria SET nombre_categoria = ?, descripcion = ?, estado = ?, fecha_registro = ? WHERE id_categoria = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, categoria.getNombreCategoria());
            preparedStatement.setString(2, categoria.getDescripcion());
            preparedStatement.setString(3, categoria.getEstado().name());
            preparedStatement.setDate(4, java.sql.Date.valueOf(categoria.getFechaRegistro()));
            preparedStatement.setInt(5, categoria.getIdCategoria());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar la categoria: " + e.getMessage());
            return false;
        }
    }
    
    public boolean delete_categoria(int id) {
        String sql = "DELETE FROM categoria WHERE id_categoria = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar la categoria: " + e.getMessage());
            return false;
        }
    }

    public Categoria getCategoriaById(int id) {
        String sql = "SELECT * FROM categoria WHERE id_categoria = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(resultSet.getInt("id_categoria"));
                categoria.setNombreCategoria(resultSet.getString("nombre_categoria"));
                categoria.setDescripcion(resultSet.getString("descripcion"));
                categoria.setEstado(Categoria.Estado.valueOf(resultSet.getString("estado")));
                categoria.setFechaRegistro(resultSet.getDate("fecha_registro").toLocalDate());
                return categoria;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la categoria: " + e.getMessage());
        }
        return null;
    }





    // Category crud operations <>

}
