import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class registration {
    public static void main(String[] args) {
        // Creating a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompting the user for input and creating a new Address object
        System.out.println("Enter registration details:");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNum = scanner.nextLine();
        System.out.print("Status: ");
        String status = scanner.nextLine();

        // Prompting the user for address details
        System.out.println("Enter address details:");
        System.out.print("Governorate: ");
        String governorate = scanner.nextLine();
        System.out.print("District: ");
        String district = scanner.nextLine();
        System.out.print("Street: ");
        String street = scanner.nextLine();
        System.out.print("Building Number: ");
        String buildingNumber = scanner.nextLine();
        System.out.print("Floor: ");
        String floor = scanner.nextLine();
        System.out.print("Flat: ");
        String flat = scanner.nextLine();
        System.out.print("Landmark: ");
        String landmark = scanner.nextLine();

        // Creating an Address object
        address address = new address(governorate, district, street, buildingNumber, floor, flat, landmark);

        // Creating a CustomerInfo object
        customerInfo customerInfo = new customerInfo(password, address, email, phoneNum, status, null, username);

        // Save registration data to a text file
        try {
            FileWriter fileWriter = new FileWriter("userInfo.txt",true);
            fileWriter.write("Username: " + customerInfo.getUsername() + "\n");
            fileWriter.write("Password: " + customerInfo.getPassword() + "\n");
            fileWriter.write("Email: " + customerInfo.getEmail() + "\n");
            fileWriter.write("Phone Number: " + customerInfo.getPhoneNum() + "\n");
            fileWriter.write("Status: " + customerInfo.getStatus() + "\n");
            fileWriter.write("Address: " + customerInfo.getAddress().getGovernorate() + ", "
                    + customerInfo.getAddress().getDistrict() + ", " + customerInfo.getAddress().getStreet() + ", "
                    + customerInfo.getAddress().getBuildingNumber() + ", " + customerInfo.getAddress().getFloor() + ", " +
                    customerInfo.getAddress().getFlat() + ", " + customerInfo.getAddress().getLandMark() + "\n");
            fileWriter.close();
            System.out.println("Registration data saved to file successfully.");
            Catalog.main(args);
        }catch (IOException e) {
            e.printStackTrace();
        }

        // Closing the scanner
        scanner.close();
    }
}
