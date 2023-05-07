import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class loginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIdField =  new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIdLabel = new JLabel("ID: ");
    JLabel userPasswordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel("");

    HashMap<String,String> loginInfo = new HashMap<String,String>();

    loginPage(HashMap<String,String> loginInfoOriginal){
        loginInfo = loginInfoOriginal;

        userIdLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIdField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225,200,100,25);
        loginButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(userIdLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIdField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resetButton){
            userIdField.setText("");
            userPasswordField.setText("");
            messageLabel.setText("");

        }
        if(e.getSource() == loginButton){
            String userID = userIdField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if(loginInfo.containsKey(userID)){
                if(loginInfo.get(userID).equals(password)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("login successful");
                    frame.dispose();
                    welcomePage welcomePage = new welcomePage(userID);
                }
                else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("wrong password");
                }
            }
            else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("user is not found");
            }
        }
    }
}
