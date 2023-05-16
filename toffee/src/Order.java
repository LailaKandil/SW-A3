import java.time.LocalDateTime;
import java.util.*;
import java.io.*;


public class Order {
    private int orderId;
    private shoppingCart cart;
    private ArrayList<Item> items;
    protected float totalPrice;
    protected customerInfo customer = new customerInfo();
    private LocalDateTime checkoutDateTime;

    public Order (){}
    public Order(shoppingCart cart, float totalPrice, String customerUsername) {
        this.cart = cart;
        this.items = cart.getCartItems();
        this.totalPrice = totalPrice;
        this.customer.setUsername(customerUsername);
        this.checkoutDateTime = LocalDateTime.now();
    }

    public void setOrderId(int id){
        this.orderId = id;
    }
    public int getOrderId() {
        return orderId;
    }

    public double getTotal(float taxPercentage) {
        if (cart == null)
            totalPrice = 0;
        else {
            totalPrice = cart.getTotal();
            totalPrice *= (1 + (taxPercentage/100));
        }
        return totalPrice;
    }

    public void setAddressAndEmail() {
        Scanner scanner = new Scanner(System.in);

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
        Address address = new Address(governorate, district, street, buildingNumber, floor, flat, landmark);
        this.customer.setAddress(address);

        System.out.print("Enter your email: ");
        String customerEmail = scanner.nextLine();
        this.customer.setEmail(customerEmail);
    }

    public void confirmOrder() {
//        System.out.println("Order ID: " + getOrderId());
        System.out.println("Customer Username: " + customer.getUsername());
//        System.out.println("Customer Address: " + customer.getAddress());
//        System.out.println("Customer Email: " + customer.getEmail());
        System.out.println("Checkout Date/Time: " + LocalDateTime.now());
        System.out.println("Items:");
        System.out.println("Item\t\tPrice\tQuantity\tTotal");
        for (Item item : items) {
            double itemTotal = item.getPrice() * item.getQuantity();
            System.out.printf("%-16s $%-8.2f %-8d $%-8.2f\n", item.getName(), item.getPrice(), item.getQuantity(),
                    itemTotal);
        }
        System.out.printf("Total: $%.2f\n", totalPrice);
    }

    public void saveOrderHistory() {
        try {
            FileWriter writer = new FileWriter("orderHistory.txt", true);

            // Writing order information to the file
            writer.write("Order ID: " + getOrderId() + "\n");
            writer.write("Customer Username: " + customer.getUsername() + "\n");
            writer.write("Customer Address: " + customer.getAddress() + "\n");
            writer.write("Customer Email: " + customer.getEmail() + "\n");
            writer.write("Checkout Date/Time: " + LocalDateTime.now() + "\n");
            writer.write("Items:\n");
            writer.write("Item\t\tPrice\tQuantity\tTotal\n");
            for (Item item : items) {
                double itemTotal = item.getPrice() * item.getQuantity();
                // Specify the Locale.US to format numbers in English
                writer.write(String.format(Locale.US, "%-16s $%.2f %-8d $%.2f\n", item.getName(), item.getPrice(), item.getQuantity(),
                        itemTotal));
            }
            // Specify the Locale.US to format numbers in English
            writer.write(String.format(Locale.US, "Total: $%.2f\n", totalPrice));
            writer.write("==============================================\n");

            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving order history.");
            e.printStackTrace();
        }
    }

    public void getOrderHistory(String customerUsername) {
        try {
            File file = new File("orderHistory.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Customer Username: " + customerUsername)) {
                    System.out.println("Order Information:");
                    System.out.println(line);
                    for (int i = 0; i < 6; i++) {
                        line = scanner.nextLine();
                        System.out.println(line);
                    }
                    System.out.println("Items:");
                    line = scanner.nextLine(); // Skip the header line
                    while (!line.contains("Total")) {
                        System.out.println(line);
                        line = scanner.nextLine();
                    }
                    System.out.println(line);
                    System.out.println("==============================================");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while retrieving order history.");
            e.printStackTrace();
        }
    }

}
