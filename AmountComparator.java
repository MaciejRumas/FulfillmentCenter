import java.util.Comparator;

public class AmountComparator implements Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2){
        int quantity = item1.quantity - item2.quantity;
        if(quantity == 0){
            return item1.compareTo(item2);
        }
        return quantity;
    }
}