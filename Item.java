public class Item implements Comparable<Item>{
    String name;
    ItemCondition condition;
    double weight;
    int quantity;



    public Item(String name, ItemCondition condition, double weight, int quantity) {
        this.name = name;
        this.condition = condition;
        this.weight = weight;
        this.quantity = quantity;
    }

    public void print(){
        System.out.println("Name: " + name + ", Condition: " + condition + ", Weight: " + weight + ", Quantity: " + quantity);
    }

    @Override
    public int compareTo(Item old){
        return name.compareTo(old.name);
    }
}
