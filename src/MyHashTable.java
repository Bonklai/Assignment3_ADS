import java.util.Arrays;

public class MyHashTable<K,V> {
    private  class HashNode<K,V>{
        private K key;
        private V value;
        private HashNode<K,V> next;
        public HashNode(K key,V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }


    private HashNode<K,V>[] chainArray;
    private int M = 11;
    private int size;
    public MyHashTable(){
        chainArray = (HashNode<K, V>[]) new HashNode[M] ;
        size = 0;
    }
    public MyHashTable(int M){
        this.M = M;
        chainArray = (HashNode<K, V>[]) new HashNode[M];
        size = 0;
    }
    private  int hash(K key){
        String temp1 = key.toString();
        int tmep2 = 0;
        for (int i=0;i<temp1.length();i++){
            tmep2 = 31 * tmep2 + temp1.charAt(i);
        }
        return Math.abs(tmep2 % M);
    }
    public void put(K key , V value){
        int index = hash(key);
        HashNode<K,V> head = chainArray[index];
        while(head!=null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head=chainArray[index];
        HashNode<K,V> neNode = new HashNode<>(key, value);
        neNode.next = head;
        chainArray[index] = neNode;
    }
    public V get(K key){
        int index = hash(key);
        HashNode<K,V> head = chainArray[index];
        while(head!=null){
            if(head.key.equals(key)) return head.value;
            head = head.next;
        }
        return null;
    }
    public V remove(K key){
        int index = hash(key);
        HashNode<K,V> head = chainArray[index];
        HashNode<K,V> prev = null;
        while(head!=null){
            if(head.key.equals(key)){
                if(prev!=null) prev.next = head.next;
                else chainArray[index] = head.next;
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }
    public boolean contains(V value){
        for(int i=0;i<M;i++){
            HashNode<K,V> head = chainArray[i];
            while (head != null){
                if (head.value.equals(value)) return true;
                head = head.next;
            }
        }
        return  false;
    }
    public K getKey(V value){
        for(int i=0;i<M;i++){
            HashNode<K,V> head = chainArray[i];
            while (head!= null){
                if(head.value.equals(value)) return head.key;
                head = head.next;
            }
        }
        return null;
    }


}
