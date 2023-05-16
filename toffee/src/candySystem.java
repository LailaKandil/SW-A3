import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class candySystem {
    Scanner scanner = new Scanner(System.in);
    Catalog ctlg = new Catalog();
    shoppingCart cart = new shoppingCart();
    ArrayList<customerInfo> customers = new ArrayList<customerInfo>();
    ArrayList<adminInfo> admins = new ArrayList<adminInfo>();
    customerInfo customer;
    Order order ;


    private ArrayList<adminInfo> readAdminDataFromFile() {
        ArrayList<adminInfo> admins = new ArrayList<>();
        try {
            File file = new File("adminInfo.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            adminInfo admin = new adminInfo();
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(": ");
                switch (data[0]) {
                    case "Username":
                        admin.setUsername(data[1]);
                        break;
                    case "Password":
                        admin.setPassword(data[1]);
                        break;
                    case "Email":
                        admin.setEmail(data[1]);
                        break;
                    case "Phone Number":
                        admin.setPhoneNum(data[1]);
                        break;
                    case "":
                        admins.add(admin);
                        admin = new adminInfo();
                        break;
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return admins;
    }

    public void registerAdmin() {

        System.out.println("Enter registration details:");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNum = scanner.nextLine();

        // Creating a CustomerInfo object
        adminInfo admin = new adminInfo(password, email, phoneNum, username);

        admin.saveAdminDataToFile();

    }

    public boolean loginAdmin() {

        System.out.println("Enter login details:");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean loginSuccessful = validateLoginAdmin(username, password);
        if (loginSuccessful) {
            System.out.println("Login successful. Welcome, " + username + "!");
            return true;
        } else {
            return false;
        }

    }

    private boolean validateLoginAdmin(String username, String password) {
        admins = readAdminDataFromFile();
        for(adminInfo admin:admins){
            if(admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<customerInfo> readCustomerDataFromFile() {
        ArrayList<customerInfo> customers = new ArrayList<>();
        try {
            File file = new File("customerInfo.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            customerInfo customer = new customerInfo();
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(": ");
                switch (data[0]) {
                    case "Username":
                        customer.setUsername(data[1]);
                        break;
                    case "Password":
                        customer.setPassword(data[1]);
                        break;
                    case "Email":
                        customer.setEmail(data[1]);
                        break;
                    case "Phone Number":
                        customer.setPhoneNum(data[1]);
                        break;
                    case "Status":
                        customer.setStatus(Boolean.parseBoolean(data[1]));
                        break;
                    case "Address":
                        String[] addressData = data[1].split(", ");
                        Address address = new Address(addressData[0], addressData[1], addressData[2], addressData[3], addressData[4], addressData[5], addressData[6]);
                        customer.setAddress(address);
                        break;
                    case "":
                        customers.add(customer);
                        customer = new customerInfo();
                        break;
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void registerCustomer() {
        // Creating a Scanner object for customerinput

        // Prompting the customerfor input and creating a new Address object
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
        boolean status = false;

        // Prompting the customerfor address details
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

        // Creating a CustomerInfo object
        customerInfo customer = new customerInfo(password, address, email, phoneNum, status, username);

        customer.saveCustomerDataToFile();

    }

    public boolean loginCustomer() {

        System.out.println("Enter login details:");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean loginSuccessful = validateLoginCustomer(username, password);
        if (loginSuccessful) {
            cart.clearCart();
            cart.retrieveCartItems(username);
            System.out.println("Login successful. Welcome, " + username + "!");
            return true;
        } else {
            return false;
        }

    }

    private boolean validateLoginCustomer(String username, String password) {
        customers = readCustomerDataFromFile();
        for(customerInfo cstmr:customers){
            if(cstmr.getUsername().equals(username) && cstmr.getPassword().equals(password)) {
                customer = cstmr;
                return true;
            }
        }
        return false;
    }

    public void addItem() {

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter item description: ");
        String description = scanner.nextLine();

        System.out.print("Enter item category: ");
        String category = scanner.nextLine();

        System.out.print("Enter item price: ");
        String priceString = scanner.nextLine();
        float price = Float.parseFloat(priceString);

        System.out.print("Enter item discount: ");
        String discountString = scanner.nextLine();
        float discount = Float.parseFloat(discountString);

        System.out.print("Is the item available? (true/false): ");
        boolean available = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Enter item quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Item newItem = new Item(name, description, category, price, discount, available, quantity);
        ctlg.addToCatalog(newItem);

    }

    public void printCatalog() {
        // Print array with headers
        ArrayList<Item> items = ctlg.retrieveItemsFromFile();
        for (Item item : items) {
            System.out.println("Name: " + item.getName());
            System.out.println("Description: " + item.getDescription());
            System.out.println("Category: " + item.getCategory());
            System.out.println("Price: " + item.getPrice());
            System.out.println("Discount: " + item.getDiscount());
            System.out.println("Availability: " + item.isAvailable());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("------------------------------------------------");
        }
    }

    public void printCart() {
        // Print array with headers
        cart.displayCart();
    }

    public void updateCatalogByAdmin() {

        ArrayList<Item> items = ctlg.retrieveItemsFromFile();

        System.out.println("\nPlease enter the name of the item you want to update:");
        String itemName = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(itemName)) {
                found = true;
                System.out.println("Enter the updated information for the item (leave blank for no change):");

                System.out.print("Name (" + items.get(i).getName() + "): ");
                String name = scanner.nextLine();
                if (!name.equals("")) {
                    items.get(i).setName(name);
                }

                System.out.print("Description (" + items.get(i).getDescription() + "): ");
                String description = scanner.nextLine();
                if (!description.equals("")) {
                    items.get(i).setDescription(description);
                }

                System.out.print("Category (" + items.get(i).getCategory() + "): ");
                String category = scanner.nextLine();
                if (!category.equals("")) {
                    items.get(i).setCategory(category);
                }

                System.out.print("Price (" + items.get(i).getPrice() + "): ");
                String priceString = scanner.nextLine();
                float price = Float.parseFloat(priceString);
                if (price != 0.0) {
                    items.get(i).setPrice(price);
                }

                System.out.print("Discount (" + items.get(i).getDiscount() + "): ");
                String discountString = scanner.nextLine();
                float discount = Float.parseFloat(discountString);
                if (discount != 0.0) {
                    items.get(i).setDiscount(discount);
                }

                System.out.print("Availability (" + items.get(i).isAvailable() + "): ");
                boolean available = scanner.nextBoolean();
                scanner.nextLine(); // consume the newline character
                items.get(i).setAvailable(available);

                System.out.print("Quantity (" + items.get(i).getQuantity() + "): ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // consume the newline character
                if (quantity != 0.0) {
                    items.get(i).setQuantity(quantity);
                }

                // Save the updated item to file
                ctlg.updateCatalog(items);

                break;
            }
        }

        if (!found) {
            System.out.println("Item not found.");
        }

    }

    private int itemQuantity;
    public void addItemToCart() {

        System.out.println("\nPlease enter the name of the item you want to add:");
        String itemName = scanner.nextLine();

        System.out.println("\nPlease enter the quantity:");
        itemQuantity = scanner.nextInt();
        scanner.nextLine();

        cart.addToCart(itemQuantity, itemName);
    }

    public void saveItemsToSystem(){
        cart.saveCartToFile(customer.getUsername());
    }
    public void removeItemFromCart(){
        System.out.println("\nPlease enter the name of the item you want to remove:");
        String itemName = scanner.nextLine();

        cart.removeFromCart(itemName, itemQuantity);

    }

    public void clearShoppingCart() {
        cart.clearCart();
    }

    public void makeAnOrder() {
        if (cart.isCartEmpty()){
            System.out.println("Cart is empty!\nplease add some items.\n");
        }
        order = new Order(cart, cart.getTotal(), customer.getUsername());
        order.confirmOrder();
        order.setAddressAndEmail();
        order.saveOrderHistory();
    }

    public void viewOrderHistory(){
        order = new Order();
        order.getOrderHistory(customer.getUsername());
    }

    public boolean payCash(){
        paymentManager payment = new paymentManager(0.03F,order.customer.getAddress());
        System.out.println("Enter your cash to pay for the order: ");
        float cash = scanner.nextFloat();
        scanner.nextLine();

        Payment pay = new Cash(order.totalPrice,cash);
        if(payment.payOrder(pay)){
            return true;
        }
        return false;
    }

    public boolean payCredit(){
        paymentManager payment = new paymentManager(0.05F,order.customer.getAddress());
        System.out.println("Enter your credit card information");
        System.out.println("Card number: ");
        String cardNum = scanner.nextLine();
        System.out.println("Card type (like visa): ");
        String cardType = scanner.nextLine();

        OTP otp = new OTP(order.customer.getEmail());
        otp.sendOTP();
        System.out.println("Enter the OTP sent: ");
        String writtenOTP = scanner.nextLine();

        if(writtenOTP.equals(otp.getChkOTP())){
            System.out.println("Verified successfully!");
            Payment pay = new Credit(cardNum, cardType, LocalDateTime.now(), order.totalPrice);
            if(payment.payOrder(pay)){
                return true;
            }
        }
        return false;

    }
}