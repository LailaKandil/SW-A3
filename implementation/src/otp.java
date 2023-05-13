import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;

public class otp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email = "toffeeotp1@gmail.com";
        String password = "gmlirtzncsyawopu";
        System.out.print("Enter your email: ");
        String recipientEmail = scanner.nextLine();
        String otp = generateOTP();

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

            System.out.println("OTP sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static String generateOTP() {
        return String.format("%06d", (int) (Math.random() * 1000000));
    }
}
