
import java.util.Scanner;

public class StockChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] names = new String[100];
        int[] quantities = new int[100];
        int count = 0;
        int choice = 0;

        while (choice != 4) {
            System.out.println("\nWelcome to Stock Checker!");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Check Low Stock");
            System.out.println("4. Exit");
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
                    System.out.println("Product list is full.");
                    continue;
                }

                System.out.print("Enter product name: ");
                String name = input.nextLine();

                if (name.trim().isEmpty()) {
                    System.out.println("Product name cannot be empty.");
                    continue;
                }

                System.out.print("Enter quantity: ");
                if (!input.hasNextInt()) {
                    System.out.println("Please enter a valid quantity.");
                    input.nextLine();
                    continue;
                }

                int quantity = input.nextInt();
                input.nextLine();

                if (quantity < 0) {
                    System.out.println("Quantity cannot be negative.");
                    continue;
                }

                names[count] = name;
                quantities[count] = quantity;
                count++;

                System.out.println("Product added!");
            }
            else if (choice == 2) {
                if (count == 0) {
                    System.out.println("No products added yet.");
                } else {
                    for (int i = 0; i < count; i++) {
                        System.out.println(names[i] + " - " +
                                           quantities[i]);
                    }
                }
            }
            else if (choice == 3) {
                System.out.println("Low Stock Products:");
                boolean found = false;

                for (int i = 0; i < count; i++) {
                    if (quantities[i] < 5) {
                        System.out.println(names[i] + " - " +
                                           quantities[i]);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No low stock products.");
                }
            }
            else if (choice == 4) {
                System.out.println("Goodbye!");
            }
            else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}
