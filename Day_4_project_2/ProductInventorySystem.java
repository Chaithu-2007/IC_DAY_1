
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductInventorySystem {

    static Scanner sc = new Scanner(System.in);

    static HashMap<Integer, Integer> inventory = new HashMap<>();
    static HashMap<Integer, String> productNames = new HashMap<>();
    static HashMap<Integer, String> productCategories = new HashMap<>();
    static HashMap<Integer, Double> productPrices = new HashMap<>();

    static HashSet<String> categories = new HashSet<>();
    static LinkedHashSet<String> recentProducts = new LinkedHashSet<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println("       PRODUCT INVENTORY SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product Quantity");
            System.out.println("5. Sell Product");
            System.out.println("6. Remove Product");
            System.out.println("7. Add Product Category");
            System.out.println("8. Display Unique Categories");
            System.out.println("9. Display Sorted Categories");
            System.out.println("10. Recently Added Products");
            System.out.println("11. Generate Inventory Report");
            System.out.println("12. Exit");
            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;

                case 2:
                    displayProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    updateQuantity();
                    break;

                case 5:
                    sellProduct();
                    break;

                case 6:
                    removeProduct();
                    break;

                case 7:
                    addCategory();
                    break;

                case 8:
                    displayCategories();
                    break;

                case 9:
                    displaySortedCategories();
                    break;

                case 10:
                    recentlyAddedProducts();
                    break;

                case 11:
                    generateReport();
                    break;

                case 12:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 12);

        sc.close();
    }

    static void addProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        if (inventory.containsKey(id)) {
            System.out.println("Product ID already exists!");
            return;
        }

        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Product Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Product Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Available Quantity: ");
        int quantity = sc.nextInt();

        if (price < 0 || quantity < 0) {
            System.out.println("Price and quantity cannot be negative!");
            return;
        }

        inventory.put(id, quantity);
        productNames.put(id, name);
        productCategories.put(id, category);
        productPrices.put(id, price);

        categories.add(category);
        recentProducts.add(name);

        System.out.println("Product Added Successfully!");
    }

    static void displayProducts() {

        if (inventory.isEmpty()) {
            System.out.println("No products available!");
            return;
        }

        System.out.println("\n---------- PRODUCT INVENTORY ----------");
        System.out.printf("%-10s %-18s %-18s %-12s %-10s%n",
                "ID", "Product", "Category", "Price", "Quantity");

        for (Map.Entry<Integer, Integer> entry : inventory.entrySet()) {

            int id = entry.getKey();

            System.out.printf("%-10d %-18s %-18s %-12.2f %-10d%n",
                    id,
                    productNames.get(id),
                    productCategories.get(id),
                    productPrices.get(id),
                    entry.getValue());
        }

        System.out.println("Total Products: " + inventory.size());
    }

    static void searchProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        if (inventory.containsKey(id)) {
            System.out.println("Product ID: " + id);
            System.out.println("Product Name: " + productNames.get(id));
            System.out.println("Category: " + productCategories.get(id));
            System.out.println("Price: " + productPrices.get(id));
            System.out.println("Quantity: " + inventory.get(id));
        } else {
            System.out.println("Product not found!");
        }
    }

    static void updateQuantity() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        if (!inventory.containsKey(id)) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter Quantity to Add: ");
        int quantity = sc.nextInt();

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero!");
            return;
        }

        int currentQuantity = inventory.get(id);

        inventory.put(id, currentQuantity + quantity);

        System.out.println("Stock Updated Successfully!");
        System.out.println("Available Quantity: " + inventory.get(id));
    }

    static void sellProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        if (!inventory.containsKey(id)) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter Quantity Sold: ");
        int quantity = sc.nextInt();

        int availableQuantity = inventory.get(id);

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero!");
        } else if (quantity > availableQuantity) {
            System.out.println("Insufficient Stock!");
        } else {
            inventory.put(id, availableQuantity - quantity);

            System.out.println("Sale Completed Successfully!");
            System.out.println("Product ID: " + id);
            System.out.println("Remaining Quantity: " + inventory.get(id));
        }
    }

    static void removeProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        if (inventory.containsKey(id)) {

            String name = productNames.get(id);
            String category = productCategories.get(id);

            inventory.remove(id);
            productNames.remove(id);
            productCategories.remove(id);
            productPrices.remove(id);

            boolean categoryUsed = productCategories.containsValue(category);

            if (!categoryUsed) {
                categories.remove(category);
            }

            boolean nameUsed = productNames.containsValue(name);

            if (!nameUsed) {
                recentProducts.remove(name);
            }

            System.out.println("Product Removed Successfully!");

        } else {
            System.out.println("Product not found!");
        }
    }

    static void addCategory() {

        sc.nextLine();

        System.out.print("Enter Product Category: ");
        String category = sc.nextLine();

        if (categories.add(category)) {
            System.out.println("Category Added Successfully!");
        } else {
            System.out.println("Category Already Exists!");
        }
    }

    static void displayCategories() {

        System.out.println("\n--------- PRODUCT CATEGORIES ---------");

        if (categories.isEmpty()) {
            System.out.println("No categories available!");
            return;
        }

        for (String category : categories) {
            System.out.println(category);
        }

        System.out.println("Total Unique Categories: " + categories.size());
    }

    static void displaySortedCategories() {

        if (categories.isEmpty()) {
            System.out.println("No categories available!");
            return;
        }

        TreeSet<String> sortedCategories = new TreeSet<>(categories);

        System.out.println("\n--------- SORTED CATEGORIES ---------");

        System.out.println("Ascending Order: " + sortedCategories);
        System.out.println("First Category: " + sortedCategories.first());
        System.out.println("Last Category: " + sortedCategories.last());
        System.out.println("Descending Order: "
                + sortedCategories.descendingSet());
    }

    static void recentlyAddedProducts() {

        System.out.println("\n--------- RECENTLY ADDED PRODUCTS ---------");
        System.out.println("1. Display Products");
        System.out.println("2. Search Product");
        System.out.println("3. Remove Product");
        System.out.print("Enter Choice: ");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println(recentProducts);
                break;

            case 2:
                sc.nextLine();

                System.out.print("Enter Product Name: ");
                String name = sc.nextLine();

                System.out.println(recentProducts.contains(name)
                        ? "Product was viewed!"
                        : "Product not found!");
                break;

            case 3:
                sc.nextLine();

                System.out.print("Enter Product Name: ");
                String product = sc.nextLine();

                if (recentProducts.remove(product)) {
                    System.out.println("Product Removed Successfully!");
                } else {
                    System.out.println("Product not found!");
                }
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }

    static void generateReport() {

        if (inventory.isEmpty()) {
            System.out.println("No products available!");
            return;
        }

        int totalUnits = 0;
        int highestQuantity = -1;
        int highestProductId = -1;

        System.out.println("\n--------- INVENTORY REPORT ---------");

        for (Map.Entry<Integer, Integer> entry : inventory.entrySet()) {

            int id = entry.getKey();
            int quantity = entry.getValue();

            System.out.println(productNames.get(id)
                    + " - Quantity: " + quantity);

            totalUnits += quantity;

            if (quantity < 5) {
                System.out.println("Low Stock: " + productNames.get(id));
            }

            if (quantity > highestQuantity) {
                highestQuantity = quantity;
                highestProductId = id;
            }
        }

        System.out.println("\nTotal Product Units: " + totalUnits);

        System.out.println("Product with Highest Quantity: "
                + productNames.get(highestProductId));

        System.out.println("Highest Available Quantity: "
                + highestQuantity);

        System.out.println("Unique Categories: " + categories);
        System.out.println("Total Unique Categories: " + categories.size());
    }
}
