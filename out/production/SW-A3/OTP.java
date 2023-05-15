import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class OTP {

    String reciverEmain;
    protected static String chkOTP;

    public String getChkOTP(){
        return chkOTP;
    }

    public OTP(String email) {
        this.reciverEmain = email;
    }

    protected void sendOTP(){
        String email = "toffeeotp1@gmail.com";
        String password = "gmlirtzncsyawopu";
        String recipientEmail = reciverEmain;
        String otp = generateOTP(); // Replace with your OTP generation logic

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(email, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("OTP Verification");
            message.setText("Your OTP is: " + otp);

            Transport.send(message);

            System.out.println("OTP sent successfully! Check your email.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    private static String generateOTP() {
        // Implement your OTP generation logic here
        // For simplicity, let's assume a 6-digit OTP
        chkOTP = String.format("%06d", (int) (Math.random() * 1000000));
        return chkOTP;
    }

}
