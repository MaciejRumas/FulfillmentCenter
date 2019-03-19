import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Item eggs = new Item("eggs",ItemCondition.NEW,1,10);
        Item eggs2 = new Item("eggs",ItemCondition.NEW,1,15);
        Item eggs3 = new Item("eggs",ItemCondition.NEW,1,15);
        Item milk = new Item("milk",ItemCondition.USED,3,5);
        Item cheese = new Item("cheese",ItemCondition.REFURBISHED,5,7);
        Item juice = new Item("juice",ItemCondition.NEW,2,20);
        Item salad = new Item("salad",ItemCondition.NEW,5,30);

        FulfillmentCenter newCenter = new FulfillmentCenter("Warehouse_1",300);

        newCenter.addProduct(eggs);
        newCenter.summary();
        newCenter.addProduct(eggs2);
        newCenter.addProduct(milk);
        newCenter.addProduct(cheese);
        newCenter.addProduct(juice);
        newCenter.addProduct(salad);

        System.out.println("Free space " + newCenter.freeSpace());
        //newCenter.removeProduct(milk);
        newCenter.summary();
        newCenter.getProduct(eggs3);
        System.out.println("Search for milk");
        newCenter.search("milk").print();
        System.out.println("Item's that contain 'e'");
        List<Item> list = new ArrayList<>();
        list = newCenter.searchPartial("e");
        for(Item i:list){
            i.print();
        }

        System.out.println("Quantity of new items: "+newCenter.countByCondition(ItemCondition.NEW));
        System.out.println("Sort by amount");
        newCenter.sortByAmount();
        newCenter.summary();
        System.out.println("Sort by name");
        newCenter.sortByName();
        newCenter.summary();
        System.out.println("Max element: ");
        newCenter.max().print();

        FulfillmentCenterContainer newContainer = new FulfillmentCenterContainer();
        newContainer.addCenter(newCenter);
        newContainer.summary();
        newContainer.addCenter("Warehouse_2",200);
        newContainer.addCenter("Warehouse_3",20);

        List<FulfillmentCenter> list2 = new ArrayList<>();
        list2 = newContainer.findEmpty();
        for(FulfillmentCenter i:list2){
            i.summary();
        }

        newContainer.removeCenter ("Warehouse_2");


    }
}
