public class InventoryTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        String[] names = {"Milk", "Bread"};
        int[] quantities = {10, 5};

        boolean result;

        result = inventory.updateQuantity(
            names, quantities, 2, "Milk", 20);

        if (result && quantities[0] == 20) {
            System.out.println("Test 1: PASS");
        } else {
            throw new AssertionError("Test 1: FAIL");
        }

        result = inventory.updateQuantity(
            names, quantities, 2, "Milk", -5);

        if (!result && quantities[0] == 20) {
            System.out.println("Test 2: PASS");
        } else {
            throw new AssertionError("Test 2: FAIL");
        }

        result = inventory.updateQuantity(
            names, quantities, 2, "Juice", 10);

        if (!result && quantities[0] == 20
                    && quantities[1] == 5) {
            System.out.println("Test 3: PASS");
        } else {
            throw new AssertionError("Test 3: FAIL");
        }

        System.out.println("All tests passed!");
    }
}