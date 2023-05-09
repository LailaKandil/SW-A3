import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        // Creating a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompting the user for login credentials
        System.out.println("Enter login details:");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Validate login credentials
        boolean loginSuccessful = validateLogin(username, password);

        // Check if login was successful
        if (loginSuccessful) {
            System.out.println("Login successful. Welcome, " + username + "!");
            Catalog.main(args);
        }
        while(!loginSuccessful) {
            System.out.println("Invalid login credentials.");
            System.out.println("1. Register an account");
            System.out.println("2. Try again");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (option == 1) {
                // Registration process
                System.out.println("Registration");
                // Implement your registration logic here
                registration.main(args);
            }
            // Otherwise, continue with the login loop
            else if (option == 2) {
                login.main(args);
            }
            else
                break;
        }

        // Closing the scanner
        scanner.close();
    }

    public static boolean validateLogin(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("userInfo.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    if (key.equals("Username") && value.equals(username)) {
                        line = reader.readLine();
                        parts = line.split(": ");
                        if (parts.length == 2 && parts[0].trim().equals("Password")) {
                            String storedPassword = parts[1].trim();
                            return storedPassword.equals(password);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
