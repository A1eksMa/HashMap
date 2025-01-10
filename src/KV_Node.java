public class KV_Node<K,V> {
    private int hash;
    private K key;
    private V value;
    private KV_Node<K,V> next;
        
    public KV_Node(K key, V value) {
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

    public KV_Node<K,V> getNext() {
        return next;
    }    

    public void setNext(KV_Node<K,V> n) {
        this.next = n;
    }

}
