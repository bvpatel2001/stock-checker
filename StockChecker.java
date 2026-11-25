import java.util.Scanner;

public class StockChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Inventory inventory = new Inventory();

        String[] names = new String[100];
        int[] quantities = new int[100];
        int count = 0;
        int choice = 0;

        while (choice != 6) {
            System.out.println("\nWelcome to Stock Checker!");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Check Low Stock");
            System.out.println("4. Update Quantity");
            System.out.println("5. Remove Product");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if (!input.hasNextInt()) {
                System.out.println("Please enter a number.");
                input.nextLine();
                continue;
            }

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                if (count == 100) {
                    System.out.println("Inventory is full.");
                    continue;
                }

                System.out.print("Enter product name: ");
                String name = input.nextLine();

                System.out.print("Enter quantity: ");

                if (!input.hasNextInt()) {
                    System.out.println("Invalid quantity.");
                    input.nextLine();
                    continue;
                }

                int quantity = input.nextInt();
                input.nextLine();

                if (quantity < 0) {
                    System.out.println("Invalid quantity.");
                }
                else {
                    names[count] = name;
                    quantities[count] = quantity;
                    count++;
                    System.out.println("Product added.");
                }
            }
            else if (choice == 2) {
                if (count == 0) {
                    System.out.println("No products available.");
                }
                else {
                    for (int i = 0; i < count; i++) {
                        System.out.println(names[i] + ": " + quantities[i]);
                    }
                }
            }
            else if (choice == 3) {
                boolean found = false;

                for (int i = 0; i < count; i++) {
                    if (quantities[i] < 5) {
                        System.out.println(names[i] + ": " + quantities[i]);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No low stock products.");
                }
            }
            else if (choice == 4) {
                System.out.print("Enter product name: ");
                String name = input.nextLine();

                System.out.print("Enter new quantity: ");

                if (!input.hasNextInt()) {
                    System.out.println("Invalid quantity.");
                    input.nextLine();
                    continue;
                }

                int newQuantity = input.nextInt();
                input.nextLine();

                if (inventory.updateQuantity(names, quantities, count, name, newQuantity)) {
                    System.out.println("Quantity updated.");
                }
                else {
                    System.out.println("Product not found or invalid quantity.");
                }
            }
            else if (choice == 5) {
                System.out.print("Enter product name: ");
                String name = input.nextLine();

                if (inventory.removeProduct(names, quantities, count, name)) {
                    count--;
                    System.out.println("Product removed.");
                }
                else {
                    System.out.println("Product not found.");
                }
            }
            else if (choice == 6) {
                System.out.println("Goodbye!");
            }
            else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}