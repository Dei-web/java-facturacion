package sistema_factura.midle;
import java.util.HashMap;

public class Verificate {


    public static boolean verificarCodigo(HashMap<String, String> mapa, String correo, String codigoRecibido) {
        if (mapa.containsKey(correo)) {
            String codigoGuardado = mapa.get(correo);
            return codigoGuardado.equals(codigoRecibido);
        }
        return false;
    }
    

    public static boolean isValidDNI(String dni) {
        
        if (dni.length() != 8) {
            return false;
        }

        
        for (char c : dni.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        
        return true;
    }

    public static boolean isValidEmail(String email) {
        
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
    public static boolean isValidPhoneNumber(String phoneNumber) {
        
        String phoneRegex = "^\\d{9}$"; // 9 dígitos
        return phoneNumber.matches(phoneRegex);
    }
    public static boolean isValidName(String name) {
        
        String nameRegex = "^[a-zA-Z\\s]+$";
        return name.matches(nameRegex);
    }
    public static boolean isValidAddress(String address) {
        
        return !address.trim().isEmpty();
    }
    public static boolean isValidPassword(String password) {
        
        return password.length() >= 8;
    }
    public static boolean isValidUsername(String username) {
        
        return username.length() >= 3;
    }
    public static boolean isValidPrivilege(String privilege) {
        
        return !privilege.trim().isEmpty();
    }
    public static boolean isValidDate(String date) {
        
        return !date.trim().isEmpty();
    }
    public static boolean isValidId(int id) {
        
        return id > 0;
    }
    
}
