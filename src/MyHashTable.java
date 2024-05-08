public class MyHashTable<K,V> {
    public class HashNode<K, V> {
        private K key;
        private V value;
        HashNode<K, V> next;

        public HashNode(K key, V value, MyHashTable<K, V>.HashNode<K, V> kvHashNode) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return "{" + key + "=" + value + "}";
        }
    }
    public HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;
    public MyHashTable(){
        this.size = 0;
        this.chainArray = new HashNode[M];
    }
    private int hash(K key){
        return (key.hashCode() &  0x7fffffff) % M;
    }
    public MyHashTable(int M){
        this.M = M;
        chainArray = (HashNode<K, V>[]) new HashNode[this.M];
        this.size = 0;
    }
    void put(K key, V value){
        int i = hash(key);
        for(HashNode<K,V> node = chainArray[i]; node!= null ; node=node.next){
            if(key.equals(node.key)){
                node.value = value;
                return;
            }
        }
        chainArray[i] = new HashNode<K,V>(key,value,chainArray[i]);
        size++;
    }
    V get(K key){
        int i = hash(key);
        for(HashNode<K,V> node = chainArray[i];node!=null; node=node.next){
            if(key.equals(node.key)){
                return node.value;
            }
        }
        return null;
    }
    void remove (K key){
        int index = hash(key);
        HashNode<K,V>prev = null;
        for(HashNode<K,V>node = chainArray[index]; node!=null;node=node.next){
            if(key.equals(node.key)){
                if(prev == null){
                    chainArray[index] = node.next;
                }else{
                    prev.next = node.next;
                }
                size--;

            }
            prev=node;
        }
    }
    int getM(){return M;}
    boolean contains(V val){
        for(int i=0;i<chainArray.length;i++){
            for(HashNode<K,V> node = chainArray[i];node!=null;node=node.next){
                if(val.equals(node.value)){
                    return true;
                }
            }
        }
        return false;
    }


}
