public class Main {
    public static void main(String[] args) {
       // Creating a Scanner object for user input
        //otp.main(args);
       Scanner scanner = new Scanner(System.in);

       System.out.println("Welcome to the App!");
       while (true) {
           System.out.println("\nPlease choose an option:");
           System.out.println("1. Register");
           System.out.println("2. Login");
           System.out.println("0. Exit");

           int choice = scanner.nextInt();
           scanner.nextLine(); // Consume the newline character

           if (choice == 1) {
               // Registration process
               System.out.println("Registration");
               // Implement your registration logic here
               registration.main(args);
           } else if (choice == 2) {
               // Login process
               System.out.println("Login");
               // Implement your login logic here
               login.main(args);
           } else if (choice == 0) {
               // Exit the program
               System.out.println("Goodbye!");
               break;
           } else {
               System.out.println("Invalid choice. Please try again.");
           }
       }

       // Closing the scanner
       scanner.close();
   }
}
