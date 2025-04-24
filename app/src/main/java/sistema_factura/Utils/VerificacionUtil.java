package sistema_factura.Utils;

import java.util.Random;

public class VerificacionUtil {
        public static String generarCodigo() {
        Random random = new Random();
        int codigo = 100000 + random.nextInt(900000);
        return String.valueOf(codigo);
    }
}
