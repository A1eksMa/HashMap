public class Node<K,V> {
    private int hash;
    private K key;
    private V value;
    private Node<K,V> next;
        
    public Node(K key, V value) {
//        this.hash = key.hashCode();
        this.hash = key!=null? key.hashCode():0;
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public int getHash() {
        return hash;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Node<K,V> getNext() {
        return next;
    }    

    public void setNext(Node<K,V> n) {
        this.next = n;
    }

}