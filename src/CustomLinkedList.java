import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList<Node <K, V>> implements Iterable<Node<K, V>> {
    private int size;
    private Node<K, V> head;


    public CustomLinkedList() {
        this.size = 0;
        this.head = null;
    }

    public void add(Node <K, V> node) {
        if (head == null) {
            head = node;
        } else {
            Node<K, V> current = head;

            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }
        size++;
    }

    public int size() {
        return size;
    }

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
            int oHashcode = o.hashCode();
            Node<K, V> current = head;
            for (int i = 0; i < size; i++) {
                if (current.getNext().getKey().hashCode() == oHashcode) {
                    if (current.getNext().getKey().equals(o)) {
                        current.setNext(current.getNext().getNext());
                        size--;
                        return true;
                    }
                    current = current.getNext();
                }
            }
        }
        return false;
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
}
