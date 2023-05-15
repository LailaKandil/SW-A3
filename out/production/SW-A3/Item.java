public class Item {
    private String name;
    private String description;
    private String category;
    private float price;
    private float discount;
    private boolean available;
    private int quantity;

    protected Item(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    public float getDiscount() {
        return discount;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item(String name, String description, String category, float price, float discount, boolean available,
                int quantity) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.discount = discount;
        this.available = available;
        this.quantity = quantity;
    }

    public Item() {
    }

}
