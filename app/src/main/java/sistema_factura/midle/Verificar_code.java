package sistema_factura.midle;

import io.github.cdimascio.dotenv.Dotenv;
import redis.clients.jedis.Jedis;
import sistema_factura.Utils.VerificacionUtil;

public class Verificar_code {

    private static final Dotenv dotenv = Dotenv.load();

    private static final String REDIS_HOST = dotenv.get("REDIS_HOST");
    private static final int REDIS_PORT = 6379;



    public static void send_code(String correo , String Id_usuario){

        Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT);
        String code = VerificacionUtil.generarCodigo();
        String clave = "verificacion "+Id_usuario;
        jedis.setex(clave,300, code);
        jedis.close();
        String asunto = "Tu código de verificación";
        String cuerpo = "Tu código de verificación es: " + code + "\nEste código expirará en 5 minutos.";
        Send_email.EmailSend(correo, asunto, cuerpo);
        
    }

    public static String verificarCodigo(String usuarioId, String codigoIngresado) {
        Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT);
        String clave = "verificacion:" + usuarioId;
        String codigoGuardado = jedis.get(clave);

        if (codigoGuardado == null) {
            jedis.close();
            return "Código expirado o no existe.";
        }

        if (codigoGuardado.equals(codigoIngresado)) {
            jedis.del(clave); 
            jedis.close();
            return "Código verificado correctamente.";
        } else {
            jedis.close();
            return "Código incorrecto.";
        }
    }

}
