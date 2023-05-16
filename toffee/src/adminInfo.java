import java.io.*;
import java.util.ArrayList;

public class adminInfo {
    protected String username;
    protected String password;
    protected String email;
    protected String phoneNum;

    public adminInfo() {
    }

    public adminInfo(String password, String email, String phoneNum,
            String username) {
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;
        this.username = username;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    protected void saveAdminDataToFile() {
        // Save registration data to a text file
        try {
            FileWriter fileWriter = new FileWriter("adminInfo.txt", true);
            fileWriter.write("Username: " + username + "\n");
            fileWriter.write("Password: " + password + "\n");
            fileWriter.write("Email: " + email + "\n");
            fileWriter.write("Phone Number: " + phoneNum + "\n\n");
            fileWriter.close();
            System.out.println("Registration data saved to file successfully.");
            // Catalog.main(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
