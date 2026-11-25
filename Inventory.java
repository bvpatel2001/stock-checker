public class Inventory {

    public boolean updateQuantity(String[] names,
                                  int[] quantities,
                                  int count,
                                  String name,
                                  int newQuantity) {

        if (newQuantity < 0) {
            return false;
        }

        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                quantities[i] = newQuantity;
                return true;
            }
        }

        return false;
    }
}