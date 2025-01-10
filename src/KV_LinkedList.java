import java.util.Iterator;
import java.util.Collection;
import java.util.NoSuchElementException;

public class KV_LinkedList<K, V> implements Iterable<KV_Node<K, V>> {
    private int size;
    private KV_Node<K, V> head;

    public KV_LinkedList() {
        this.size = 0;
        this.head = null;
    }

    public int size() {
        return size;
    }    

    @Override
    public Iterator<KV_Node<K, V>> iterator() {
        return new Iterator<KV_Node<K, V>>() {
            private KV_Node<K, V> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public KV_Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                KV_Node<K, V> current_node = current;
                KV_Node<K, V> next_node = current.getNext();
                current = next_node;
                return current_node;
            }
        };
    }

    public boolean add(KV_Node<K, V> e) {
        if (head == null) {
            head = e;
        } else {
            KV_Node<K, V> current = head;

            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(e);
        }
        size++;
        return true;
    }

    public boolean addAll(Collection<? extends KV_Node<K, V>> c) {
        boolean modified = false;
        int cnt = 0;
        for (KV_Node<K, V> e: c) {
            if (add(e)) {
                modified = true;
            }
            cnt++;
        }
        size +=cnt;
        return modified;
    }

    public void clear() {
        KV_Node<K, V> current = head;
        while (current != null) {
            KV_Node<K, V> next = current.getNext();
            current.setNext(null);
            current = next;
        }
        head = null;
        size = 0;
    }
    
/**
    public boolean contains(Object o) {
        Node<K, V> current = head;
        while (current != null) {
            if (o == null || current.getClass() != o.getClass()) return false;
            if (Object.equals(current.getKey(), ((Node<?, ?>) o).getKey())) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
**/

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean equals(Object o) {
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
    public Object[] toArray() {
    }

    public <T> T[] toArray(T[] a) {
    }

    public default Stream<E> stream() {
    }
    
    public default Spliterator<E> spliterator() {
    }
    
    public default boolean removeIf(Predicate<? super E> filter) {
        return default boolean;
    }
    
    public default Stream<E> parallelStream() {
        return default Stream<E>;            
    }


    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }
        if (o == null) {
            if (head.getKey() == null) {
                head = head.getNext();
                size--;
                return true;
            } else {
                return false;
            }
        } else {
            Node<K, V> tmp = head;
            while (tmp.getNext() != null) {
                if (tmp.getNext().getKey().equals(o)) {
                    tmp.setNext(tmp.getNext().getNext());
                    size--;
                    return true;
                }
                tmp = tmp.getNext();
            }
        }
        return false;
    }

    Здесь методы
    
    public void add(Node<K, V> newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node<K, V> current = head;

            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public boolean remove(Node<K, V> node) {
        if (node == null) {
            return false;
        }

        if (node == head) {
            head = node.getNext();
            size--;
            return true;
        }

        Node<K, V> current = head;
        while (current != null && current.getNext() != null) {
            if (current.getNext() == node) {
                current.setNext(node.getNext());
                size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }  
    */

}
