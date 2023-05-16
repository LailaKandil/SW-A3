import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        candySystem cSys = new candySystem();
        int choice;

        System.out.println("Welcome to the App!");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("\nRegistration");
                System.out.println("Are you a\n1. Admin\n2. Customer");
                int userType = scanner.nextInt();
                scanner.nextLine();

                if (userType == 1) {
                    cSys.registerAdmin();
                } else if (userType == 2) {
                    cSys.registerCustomer();
                } else {
                    System.out.println("Invalid user type. Please try again.");
                }
            } else if (choice == 2) {
                System.out.println("\nLogin");
                System.out.println("Are you a\n1. Admin\n2. Customer");
                int userType = scanner.nextInt();
                scanner.nextLine();

                if (userType == 1) {
                    if (cSys.loginAdmin()) {
                        while (true) {
                            System.out.println("\nPlease choose an option:");
                            System.out.println("1. Add item");
                            System.out.println("2. Display items");
                            System.out.println("3. Update item");
                            System.out.println("0. Logout");

                            choice = scanner.nextInt();
                            scanner.nextLine();

                            if (choice == 1) {
                                cSys.addItem();
                            } else if (choice == 2) {
                                cSys.printCatalog();
                            } else if (choice == 3) {
                                cSys.printCatalog();
                                cSys.updateCatalogByAdmin();
                            } else if (choice == 0) {
                                break;
                            } else {
                                System.out.println("Invalid choice. Please try again.");
                            }

                        }
                    } else {
                        System.out.println("\nInvalid username or password.\nTry again.");
                    }

                } else if (userType == 2) {
                    if (cSys.loginCustomer()) {
                        while (true) {
                            System.out.println("\nPlease choose an option:");
                            System.out.println("1. Display items");
                            System.out.println("2. Add item to cart");
                            System.out.println("3. Remove item from cart");
                            System.out.println("4. Display cart");
                            System.out.println("5. Clear shopping cart");
                            System.out.println("6. Make an order");
                            System.out.println("7. View order history");
                            System.out.println("0. Logout");

                            choice = scanner.nextInt();
                            scanner.nextLine();

                            if (choice == 1) {
                                cSys.printCatalog();
                            } else if (choice == 2) {
                                cSys.addItemToCart();
                            } else if (choice == 3) {
                                cSys.removeItemFromCart();
                            } else if (choice == 4) {
                                cSys.printCart();
                            } else if (choice == 5) {
                                cSys.clearShoppingCart();
                            } else if (choice == 6) {
                                while(true){
                                    System.out.println("\nPlease choose an option:");
                                    System.out.println("1. Confirm order");
                                    System.out.println("2. Dis-confirm order");
                                    choice = scanner.nextInt();
                                    scanner.nextLine();
                                    if (choice == 1) {
                                        cSys.makeAnOrder();
                                        while (true){
                                            System.out.println("\nPlease choose an option:");
                                            System.out.println("1. Pay cash upon delivery");
                                            System.out.println("2. Pay by credit card");
                                            System.out.println("0. Cancel payment");
                                            choice = scanner.nextInt();
                                            scanner.nextLine();
                                            if (choice==1){
                                                if(cSys.payCash()){
                                                    break;
                                                }
                                            } else if (choice==2) {
                                                if(cSys.payCredit()){
                                                    break;
                                                }
                                            } else if (choice==0) {
                                                System.out.println("Payment canceled!");
                                                break;
                                            }
                                        }
                                        break;
                                    } else if (choice == 2) {
                                        break;
                                    }
                                }
                            } else if (choice == 7) {
                                cSys.viewOrderHistory();
                            } else if (choice == 0) {
                                cSys.saveItemsToSystem();
                                break;
                            } else {
                                System.out.println("Invalid choice. Please try again.");
                            }

                        }
                    } else {
                        System.out.println("\nInvalid username or password.\nTry again.");
                    }
                } else {
                    System.out.println("Invalid user type. Please try again.");
                }

            } else if (choice == 0) {
                // Exit the program
                System.out.println("Goodbye!");
                scanner.close();
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

    }

}
