package sistema_factura.midle;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import io.github.cdimascio.dotenv.Dotenv;



public class Send_email {

    private static final Dotenv dov = Dotenv.load();

    public static void EmailSend(String to, String subject, String body) {

        String host = "smtp.gmail.com";
        String from = dov.get("GMAIL"); 
        String password = dov.get("PASSCODE");

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "tru");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");

        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            
            Transport.send(message);
            System.out.println("Correo enviado exitosamente");
        } catch (MessagingException e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }
    }
}
