import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList<K, V> implements Iterable<Node<K, V>> {
    private int size;
    private Node<K, V> head;


    public CustomLinkedList() {
        this.size = 0;
        this.head = null;
    }

    public void add(K k, V v) {
        Node<K, V> newNode = new Node<K, V>(k, v);

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

    public int size() {
        return size;
    }
    /*
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private Node<K, V> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                V value = current.value;
                current = current.next;
                return value;
            }
        }
    }
    */

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<Node<K, V>>() {
            private Node<K, V> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<K, V> current_node = current;
                Node<K, V> next_node = current.getNext();
                current = next_node;
                return current_node;
            }
        };
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
}