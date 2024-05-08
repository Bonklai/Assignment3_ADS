public class BST<K extends Comparable<K>, V> {
    public BST(){
        root = null;
    }
    private Node root;
    private class Node{
        private K key;
        private V val;
        private Node left,right;
        private Node(K key , V val){
            this.key=key;
            this.val=val;
        }
    }

    public void put(K key , V val){
        root = put(root,key,val);
    }
    private Node put(Node node,K key, V val){
        if(node==null){
            return new Node(key,val);
        }
        int compare = key.compareTo(node.key);
        if(compare<0){
            node.left = put(node.left,key,val);

        }
        else if(compare>0){
            node.right = put(node.right , key,val);
        }else{
            node.val = val;
        }
        return  node;
    }
    public V get(K key){}
    public void delete(K key){}
    public Iterable<K> iterator(){}
}
