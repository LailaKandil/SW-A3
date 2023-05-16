import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.util.*;
import java.io.IOException;

public class customerInfo extends adminInfo {
    private Address address;

    private boolean status;

    public customerInfo() {
    }

    public customerInfo(String password, Address address, String email, String phoneNum, boolean status,
                        String username) {
        this.password = password;
        this.address = address;
        this.email = email;
        this.phoneNum = phoneNum;
        this.status = status;
        this.username = username;
    }

    public String getAddress() {
        return address.getGovernorate()+", "+address.getDistrict()+", "+address.getStreet()+", "+address.getBuildingNumber()+", "
                +address.getFloor()+", "+address.getFlat()+", "+address.getLandMark();
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    protected void saveCustomerDataToFile() {
        // Save registration data to a text file
        try {
            FileWriter fileWriter = new FileWriter("customerInfo.txt", true);
            fileWriter.write("Username: " + username + "\n");
            fileWriter.write("Password: " + password + "\n");
            fileWriter.write("Email: " + email + "\n");
            fileWriter.write("Phone Number: " + phoneNum + "\n");
            fileWriter.write("Status: " + status + "\n");
            fileWriter.write("Address: " + address.getGovernorate() + ", "
                    + address.getDistrict() + ", " + address.getStreet() + ", "
                    + address.getBuildingNumber() + ", " + address.getFloor() + ", "
                    +
                    address.getFlat() + ", " + address.getLandMark() + "\n\n");
            fileWriter.close();
            System.out.println("Registration data saved to file successfully.");
            // Catalog.main(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
