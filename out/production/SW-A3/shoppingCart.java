import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.io.*;


public class shoppingCart {
    private Catalog ctlg = new Catalog();
    private ArrayList<Item> catalogItems = ctlg.retrieveItemsFromFile();
    private ArrayList<Item> cartItems = new ArrayList<Item>();
    private float total = 0; // initialize total to 0

    protected float getTotal(){
        return total;
    }

    protected void clearCartItems(){
        cartItems.clear();
    }

    protected boolean isCartEmpty(){
        if(cartItems.isEmpty()){
            return true;
        }
        return false;
    }

    protected ArrayList<Item> getCartItems(){
        return cartItems;
    }

    protected void addToCart(int quantity, String itemName) {
        for (Item item : catalogItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                if (item.getQuantity() >= quantity) {
                    double itemTotal = item.getPrice() * quantity; // calculate total based on quantity being added
                    total += itemTotal; // add itemTotal to total
                    Item addedItem = new Item(item.getName(), item.getPrice(), quantity);
                    cartItems.add(addedItem);
                    updateQuantity(item, item.getQuantity() - quantity);
                    System.out.println(quantity + " " + itemName + " added to cart successfully!");
//                    saveCartToFile(username);
                } else {
                    System.out.println("Insufficient quantity!");
                }
                return;
            }
        }
        System.out.println(itemName + " not found!");
    }

    protected void removeFromCart(String itemName, int quantity){
        for(Item item : cartItems){
            if(item.getName().equals(itemName)){
                double itemTotal = item.getPrice() * quantity; // calculate total based on quantity being removed
                total -= itemTotal; // subtract itemTotal from total
                cartItems.remove(item);
                updateQuantity(item, item.getQuantity()+quantity);
                System.out.println(itemName + " removed from cart successfully!");
                break;
            }
        }
    }

    private void updateQuantity(Item item, int quantity) {
        for (Item catalogItem : catalogItems) {
            if (item.getName().equalsIgnoreCase(catalogItem.getName())) {
                catalogItem.setQuantity(quantity);
                break;
            }
        }
        ctlg.updateCatalog(catalogItems);
    }

    protected void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Item\t\tPrice\tQuantity\tTotal");
            total = 0;
            for (Item item : cartItems) {
                double itemTotal = item.getPrice() * item.getQuantity();
                total += itemTotal;
                System.out.printf("%-16s $%-8.2f %-8d $%-8.2f\n", item.getName(), item.getPrice(), item.getQuantity(),
                        itemTotal);
            }
            System.out.printf("Total: $%.2f\n", total);
        }
    }

    protected void clearCart() {
        cartItems.clear();
        total = 0; // set total back to 0
        System.out.println("Cart cleared.");
    }

    public void saveCartToFile(String customerUsername) {
        try {
            FileWriter writer = new FileWriter("shoppingCart.txt",true);
            writer.write("Customer Username: " + customerUsername + "\n");
            writer.write("Items:\n");
            writer.write("Item\t\tPrice\tQuantity\tTotal\n");
            for (Item item : cartItems) {
                double itemTotal = item.getPrice() * item.getQuantity();
                writer.write(String.format(Locale.US, "%s\t\t$%.2f\t\t%d\t\t$%.2f\n", item.getName(), item.getPrice(), item.getQuantity(), itemTotal));
            }
            writer.write(String.format(Locale.US, "Total:\t\t$%.2f\n", total));
            writer.close();
            System.out.println("Shopping cart saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving shopping cart.");
            e.printStackTrace();
        }
    }

    protected void retrieveCartItems(String customerUsername) {
//        ArrayList<Item> cartItems = new ArrayList<Item>();
        try {
            File file = new File("shoppingCart.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Customer Username: " + customerUsername)) {
                    // Load the saved cart items into the ArrayList
                    for (int i = 0; i < 2; i++) {
                        scanner.nextLine(); // Skip the next two lines
                    }
                    while (scanner.hasNextLine()) {
                        line = scanner.nextLine();
                        if (line.equals("==============================================")) {
                            break;
                        } else {
                            String[] itemInfo = line.split("\t\t");
//                            for (String i: itemInfo){
//                                System.out.println(i);
//                            }
                            if (itemInfo.length < 3) {
                                continue;
                            }
                            String itemName = itemInfo[0];
                            float itemPrice = Float.parseFloat(itemInfo[1].substring(1));
                            int itemQuantity = Integer.parseInt(itemInfo[2].trim());
                            Item item = new Item(itemName, itemPrice, itemQuantity);
                            cartItems.add(item);
                            break;
                        }

                    }
                    // Remove the saved cart items from the file
                    List<String> fileContent = new ArrayList<>(Files.readAllLines(file.toPath()));
                    for (int i = 0; i < fileContent.size(); i++) {
                        if (fileContent.get(i).contains("Customer Username: " + customerUsername)) {
                            fileContent.subList(i, i+6).clear();
                            break;
                        }
                    }
                    Files.write(file.toPath(), fileContent, StandardCharsets.UTF_8);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while retrieving shopping cart items.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occurred while removing saved shopping cart items.");
            e.printStackTrace();
        }
//        return cartItems;
    }

}
