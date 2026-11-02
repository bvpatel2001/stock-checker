
import java.util.Scanner;

public class StockChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Stock Checker!");

        System.out.println("1. Add Product");
        System.out.println("2. View Products");
        System.out.println("3. Check Low Stock");
        System.out.println("4. Exit");

        System.out.print("Enter your choice: ");
        int choice = input.nextInt();

        System.out.println("You selected: " + choice);
    }
}
