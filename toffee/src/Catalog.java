import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Catalog {
    // private ArrayList<item> items = retrieveItemsFromFile();

    protected ArrayList<Item> retrieveItemsFromFile() {
        ArrayList<Item> items = new ArrayList<>();

        try {
            FileReader file = new FileReader("items.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.equals("")) {
                    continue;
                }

                String[] tokens = line.split(": ");

                if (tokens.length != 2) {
                    continue;
                }

                String heading = tokens[0];
                String value = tokens[1];

                switch (heading) {
                    case "Name":
                        Item newItem = new Item();
                        newItem.setName(value);
                        items.add(newItem);
                        break;

                    case "Description":
                        items.get(items.size() - 1).setDescription(value);
                        break;

                    case "Category":
                        items.get(items.size() - 1).setCategory(value);
                        break;

                    case "Price":
                        items.get(items.size() - 1).setPrice(Float.parseFloat(value));
                        break;

                    case "Discount":
                        items.get(items.size() - 1).setDiscount(Float.parseFloat(value));
                        break;

                    case "Availability":
                        items.get(items.size() - 1).setAvailable(Boolean.parseBoolean(value));
                        break;

                    case "Quantity":
                        items.get(items.size() - 1).setQuantity(Integer.parseInt(value));
                        break;

                    default:
                        break;
                }
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return items;
    }

    public void updateCatalog(ArrayList<Item> items) {
        try {
            FileWriter fileWriter = new FileWriter("items.txt", false);
            for (int j = 0; j < items.size(); j++) {
                fileWriter.write("Name: " + items.get(j).getName() + "\n");
                fileWriter.write("Description: " + items.get(j).getDescription() + "\n");
                fileWriter.write("Category: " + items.get(j).getCategory() + "\n");
                fileWriter.write("Price: " + items.get(j).getPrice() + "\n");
                fileWriter.write("Discount: " + items.get(j).getDiscount() + "\n");
                fileWriter.write("Availability: " + items.get(j).isAvailable() + "\n");
                fileWriter.write("Quantity: " + items.get(j).getQuantity() + "\n\n");
            }
            fileWriter.close();
            System.out.println("Item updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addToCatalog(Item item) {
        try {
            FileWriter fileWriter = new FileWriter("items.txt", true);
            fileWriter.write("Name: " + item.getName() + "\n");
            fileWriter.write("Description: " + item.getDescription() + "\n");
            fileWriter.write("Category: " + item.getCategory() + "\n");
            fileWriter.write("Price: " + item.getPrice() + "\n");
            fileWriter.write("Discount: " + item.getDiscount() + "\n");
            fileWriter.write("Availability: " + item.isAvailable() + "\n");
            fileWriter.write("Quantity: " + item.getQuantity() + "\n\n");

            fileWriter.close();
            System.out.println("Item added successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // public voi
    public Catalog() {
    }
}
