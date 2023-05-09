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

        // Display available categories
        catalog.displayCategories();

        // Prompt the customer to choose a category
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a category to view available candies: ");
        String chosenCategory = scanner.nextLine();

        // Display the candies in the chosen category
        catalog.displayCandies(chosenCategory);

        scanner.close();
    }
}
