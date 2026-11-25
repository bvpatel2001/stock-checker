public class InventoryTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        String[] names = {"Milk", "Bread", "Juice"};
        int[] quantities = {10, 5, 8};

        boolean result;

        result = inventory.updateQuantity(
            names, quantities, 3, "Milk", 20);

        if (result && quantities[0] == 20) {
            System.out.println("Test 1: PASS");
        } else {
            throw new AssertionError("Test 1: FAIL");
        }

        result = inventory.updateQuantity(
            names, quantities, 3, "Milk", -5);

        if (!result && quantities[0] == 20) {
            System.out.println("Test 2: PASS");
        } else {
            throw new AssertionError("Test 2: FAIL");
        }

        result = inventory.updateQuantity(
            names, quantities, 3, "Water", 10);

        if (!result && quantities[0] == 20) {
            System.out.println("Test 3: PASS");
        } else {
            throw new AssertionError("Test 3: FAIL");
        }

        result = inventory.removeProduct(
            names, quantities, 3, "Bread");

        if (result && names[1].equals("Juice")
                && quantities[1] == 8
                && names[2] == null) {
            System.out.println("Test 4: PASS");
        } else {
            throw new AssertionError("Test 4: FAIL");
        }

        result = inventory.removeProduct(
            names, quantities, 2, "Water");

        if (!result && names[0].equals("Milk")
                && names[1].equals("Juice")) {
            System.out.println("Test 5: PASS");
        } else {
            throw new AssertionError("Test 5: FAIL");
        }

        System.out.println("All tests passed!");
    }
}