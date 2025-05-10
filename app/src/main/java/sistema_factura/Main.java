package sistema_factura;

import sistema_factura.Database.ConfigDB;
import sistema_factura.Utils.*;
import sistema_factura.midle.Send_email;

public record Main() {
    public static void main(String[] args) {
        
        String emailDestino = "bryanalgarin23@gmail.com";
        String codigo = VerificacionUtil.generarCodigo();
        String asunto = "Código de Verificación";
        String cuerpo = "Tu código de verificación es: " + codigo;

        Send_email.EmailSend(emailDestino, asunto, cuerpo);

    }
}
