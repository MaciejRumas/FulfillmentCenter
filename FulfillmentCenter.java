import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FulfillmentCenter {
    String warehouseName;
    List<Item> items = new ArrayList<>();
    double weightLimit;

    public FulfillmentCenter(String warehouseName, double weightLimit) {
        this.warehouseName = warehouseName;
        this.weightLimit = weightLimit;
    }

    public void addProduct(Item newItem) {

        for (Item i : this.items) {
            if (i.compareTo(newItem) == 0) {
                if (newItem.quantity * i.weight > this.freeSpace()) {
                    System.err.println("There is not enough space in the warehouse");
                } else {
                    i.quantity += newItem.quantity;
                }
                return;
            }
        }
       if(newItem.quantity*newItem.weight <= this.freeSpace()){
           this.items.add(newItem);
       }
       else{
           System.err.println("There is not enough space in the warehouse");
       }

    }

    public void getProduct(Item itemToGet) {
        boolean found = false;
        boolean remove = false;
        for (Item i : this.items) {
            if (i.compareTo(itemToGet) == 0) {
                found = true;

                 if (i.quantity < itemToGet.quantity) {
                    System.err.println("There's not enough items to get");
                } else {
                    i.quantity -= itemToGet.quantity;
                    if(i.quantity == 0){
                        remove = true;
                    }
                }
            }
        }
        if (!found) {
            System.err.println("There is no such item");
        }
        
        if(remove){
            removeProduct(itemToGet);
            System.out.println("Product has been removed");
    }

    public void removeProduct(Item itemToRemove) {
        for (Item i : this.items) {
            if (i.compareTo(itemToRemove) == 0) {
                items.remove(i);
                return;
            }
        }
        System.err.println("There is no such item");
    }

    public Item search(String name){
        for(Item i:this.items){
            if(i.name.equals(name)){
                return i;
            }
        }
        System.err.println("Product of that name does not exist");
        return null;
    }

    public List<Item> searchPartial(String namePart){
        List<Item> foundItems = new ArrayList<>();
        for(Item i:this.items){
            if(i.name.contains(namePart)){
                foundItems.add(i);
            }
        }
        return foundItems;
    }

    public int countByCondition(ItemCondition condition) {
        int sum = 0;
        for (Item i : this.items) {
            if (i.condition == condition) {
                sum += i.quantity;
            }
        }
        return sum;
    }

    public void summary() {
        System.out.println("Summary of items in " + this.warehouseName);
        for (Item i : this.items) {
            i.print();
        }
    }

    public FulfillmentCenter sortByName() {
        Collections.sort(this.items);
        return this;
    }

    public FulfillmentCenter sortByAmount(){
        Collections.sort(this.items, new AmountComparator());
        return this;
    }

    public Item max(){
      return Collections.max(this.items, new AmountComparator());
    }

    public double freeSpace(){
        double freeSpace = this.weightLimit;
        for(Item i : this.items){
            freeSpace -= (i.weight*i.quantity);
        }
        return freeSpace;
    }
}
