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

    public boolean removeProduct(String[] names,
                                 int[] quantities,
                                 int count,
                                 String name) {

        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(name)) {

                for (int j = i; j < count - 1; j++) {
                    names[j] = names[j + 1];
                    quantities[j] = quantities[j + 1];
                }

                names[count - 1] = null;
                quantities[count - 1] = 0;

                return true;
            }
        }

        return false;
    }
}