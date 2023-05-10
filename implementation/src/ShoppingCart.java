import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ShoppingCart {
    private static final String ITEMS_FILE = "items.txt";
    private static final String ORDER_FILE = "order.txt";

    public void addToCart(String candy) {
        String item = candy;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDER_FILE, true))) {
            writer.write(item);
            writer.newLine();
            System.out.println("Item added to cart: " + item);
        } catch (IOException e) {
            System.out.println("Failed to add item to cart.");
        }
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        System.out.println("Welcome to the Shopping Cart!");

//        // Read items from the items file
//        List<String> lines = new ArrayList<>();
//        try {
//            lines = Files.readAllLines(Paths.get(ITEMS_FILE));
//        } catch (IOException e) {
//            System.out.println("Failed to read items from file: " + ITEMS_FILE);
//        }
//
//        // Display available items
//        System.out.println("Available Items:");
//        for (String line : lines) {
//            System.out.println("- " + line);
//        }

        // Prompt the customer to choose an item
        //hena rakz henaaaaaaaaaaaa 
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Choose an item to add to the cart (candy): ");
//        String chosenItem = scanner.nextLine();
//
//        // Add the chosen item to the cart
//        shoppingCart.addToCart(chosenItem);

        //Scanner.close();
    }
}
