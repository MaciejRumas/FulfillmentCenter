import java.util.TreeMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class FulfillmentCenterContainer {
    Map <String, FulfillmentCenter> warehouseMap = new TreeMap<>();

    public void addCenter(String name, double capacity){
        FulfillmentCenter newCenter = new FulfillmentCenter(name,capacity);
        warehouseMap.put(name, newCenter);
    }

    public void addCenter(FulfillmentCenter centerToAdd){
        warehouseMap.put(centerToAdd.warehouseName, centerToAdd);
    }

    public void removeCenter(String name){
        try{
        warehouseMap.remove(name);
        System.out.println("Center: "+ name + " removed successfully");
        }catch(Exception e){
            System.out.println("There is no such center");
        }
    }

    public List<FulfillmentCenter> findEmpty(){
        Set<Entry<String,FulfillmentCenter>> entrySet = warehouseMap.entrySet();
        List<FulfillmentCenter> centerList= new ArrayList<>();
        for(Entry<String,FulfillmentCenter> entry:entrySet){
            if(entry.getValue().items.isEmpty()){
                centerList.add(entry.getValue());
            }
        }
        return centerList;
    }

    public void summary(){
        System.out.println("FulfillmentCenterContainer summary:");
        Set<Entry<String,FulfillmentCenter>> entrySet = warehouseMap.entrySet();

        for(Entry<String,FulfillmentCenter> entry:entrySet){
            double percentage = (entry.getValue().weightLimit-entry.getValue().freeSpace())/entry.getValue().weightLimit*100;
            System.out.print("Warehouse name: " + entry.getKey() + ", total fulfillment: ");
            System.out.printf("%.2f", percentage);
            System.out.println("%");
            }
    }
}


