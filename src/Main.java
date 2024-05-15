import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass,Person> myHashTable = new MyHashTable<>();
        Random random = new Random();
        for (int i=0;i<10000;i++){
            String age = "AGE" + random.nextInt(10000);
            Person person = new Person("Person" + i);
            myHashTable.put(new MyTestingClass(age),person);
        }
        System.out.println("Bucket sizes");
        for(int i =0;i<myHashTable.getM();i++){
            int c = 0;
            MyHashTable.HashNode<MyTestingClass,Person> node = myHashTable.getChainarray()[i];
            while(node!=null){
                c++;
                node=node.next;
            }
            System.out.println("Bucket "+i+": "+c);

        }
    }



}