import java.nio.file.Files;
import java.util.Iterator;
import java.util.Stack;

import static java.nio.file.Files.find;

public class BST <K extends Comparable<K>,V>{
    private Node root;
    private int size;
    private int modcount;
    private K founkey;

    private class Node<K,V>{
        private K key;
        private V val;
        private Node<K, V> left;
        private Node<K,V> right;

        public Node(K key2, V val2){
            key = key2;
            val = val2;
        }
    }
    public BST(){
        root = null;
        size = 0;
        modcount = 0;
        founkey = null;

    }


    //additional methodss
    public boolean contains(K key){
        if(find(key,root) == null){
            return false;
        }
        return true;
    }

    private V find(K key, Node<K, V> n) {
        if (n == null)
            return null;
        int comp = ((Comparable<K>) key).compareTo(n.key);
        if (comp < 0)
            return find(key, n.left);
        else if (comp > 0)
            return find(key, n.right);
        else
            return (V) n.val;  //some recursive :)
    }
    private Node<K,V> put(Node<K,V> node,K key , V val){
        if (node == null){
            size++;
            return new Node<>(key,val);
        }
        int compare = key.compareTo(node.key);
        if(compare<0) node.left = put(node.left,key,val);
        else if (compare>0) node.right = put(node.right,key,val);
        else node.val = val;
        return node;
    }
    private Node<K, V> min(Node<K, V> node) {
        if (node.left == null) return node;
        else return min(node.left);
    }
    private Node<K, V> deleteMin(Node<K, V> node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }
    private Node<K,V> delete(Node<K,V> node , K key){
        if (node == null) return null;
        int compare = key.compareTo(node.key);
        if (compare<0) node.left = delete(node.left,key);
        else if (compare > 0) node.right = delete(node.right, key);
        else {
            if(node.left==null) return node.right;
            if(node.right ==null) return node.left;
            Node<K,V> t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left=t.left;
        }
        return node;
    }








// main methods
    public void put(K key,V val){
        root = put(root,key,val);
        modcount++;
    }



    public V get(K key){
        return (V) find(key,root);
    }

    public void delete(K key){
        root = delete(root,key);
    }

    public Iterable<K> iterator(){
        return (Iterable<K>) new BSTIterator();
    }


    private class BSTIterator implements Iterator<K> {
        private Stack<Node<K,V>> nodeStack = new Stack<>();
        private void pushLeft(Node<K,V> node){
            while(node!=null){
                nodeStack.push(node);
                node = node.left;
            }
        }
        @Override
        public boolean hasNext() {
            return nodeStack.isEmpty() == false;
        }

        @Override
        public K next() {
            Node<K,V> node = nodeStack.pop();
            pushLeft(node.right);
            return node.key;

        }
    }



}
