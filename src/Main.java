import java.util.HashMap;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        MyHashTable<String,Integer> myHashTable = new MyHashTable<>();
        myHashTable.put("Daulet",19);
        myHashTable.put("Baha",20);
        myHashTable.put("Lalala",200);
        System.out.println(myHashTable.get("Lalala"));
        System.out.println(myHashTable.contains(19));
        System.out.println(myHashTable.remove("Daulet"));
        System.out.println(myHashTable.get("Daulet"));

    }



}