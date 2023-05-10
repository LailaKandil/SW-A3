import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Catalog {
    private Map<String, String[]> categories;

    public Catalog() {
        categories = new HashMap<>();
        loadItemsFromTextFile("items.txt");
    }

    public void displayCategories() {
        System.out.println("Available Categories:");
        for (String category : categories.keySet()) {
            System.out.println("- " + category);
        }
    }

    public void displayCandies(String category) {
        String[] candies = categories.get(category);
        if (candies != null) {
            System.out.println("Available Candies in " + category + ":");
            for (String candy : candies) {
                System.out.println("- " + candy);
            }
        } else {
            System.out.println("Invalid category!");
        }
    }

    private void loadItemsFromTextFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String category = parts[0];
                    String[] candies = parts[1].split(",");
                    categories.put(category, candies);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        System.out.println("Welcome to Candy Catalog!");

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            // Display available categories
            catalog.displayCategories();

            // Prompt the customer to choose a category
            System.out.print("Choose a category to view available candies: ");
            String chosenCategory = scanner.nextLine();

            // Display the candies in the chosen category
            catalog.displayCandies(chosenCategory);

            System.out.println("1 - Add items to the cart");
            System.out.println("2 - Show categories again");
            System.out.println("3 - Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 1) {
                ShoppingCart shoppingCart = new ShoppingCart();

                int addToCartChoice;
                do {
                    System.out.print("Choose an item to add to the cart (candy): ");
                    String chosenItem = scanner.nextLine();

                    // Add the chosen item to the cart
                    shoppingCart.addToCart(chosenItem);

                    System.out.print("Do you want to add more items? (1 - Yes, 2 - No): ");
                    addToCartChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                } while (addToCartChoice == 1);
            } else if (choice == 2) {
                // Continue to the next iteration of the loop to show the categories again
                continue;
            } else if (choice == 3) {
                // Exit the loop and end the program
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (true);

        scanner.close();
    }
}