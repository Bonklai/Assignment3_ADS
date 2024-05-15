import java.util.HashMap;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        MyHashTable<String,Integer> myHashTable = new MyHashTable<>();
        myHashTable.put("Daulet",19);
        System.out.println(myHashTable.hashCode());

    }



}