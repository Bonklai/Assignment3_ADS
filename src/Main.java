import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //testing
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random random = new Random();
        for(int i =0;i<15000;i++){
            String id = "id" + random.nextInt(15000);
            Student student = new Student("Student"+i,random.nextInt(150));
            table.put(new MyTestingClass(id),student);
        }


        int[] bucketLengths = new int[table.getM()];
        for(int i=0;i< table.getM();i++){
            int bucketLength = 0;
            for(MyHashTable<MyTestingClass, Student>.HashNode<MyTestingClass, Student> node = table.chainArray[i]; node!=null; node=node.next ){
                bucketLength++;
            }
            bucketLengths[i] = bucketLength;
            System.out.println("Nucket "+i+"has "+bucketLength+" el");
        }
    }


}