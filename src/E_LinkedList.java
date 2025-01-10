import java.util.Iterator;
import java.util.Collection;
import java.util.NoSuchElementException;

public class E_LinkedList<E> implements Iterable<E> {
    private class E_Node<N> {
        private N n;
        private E_Node<N> next;
            
        public E_Node(N n) {
            this.n = n;
            this.next = null;
        }
    
        public N getElement() {
            return n;
        }
    
        public E_Node<N> getNext() {
            return next;
        }    
    
        public void setNext(E_Node<N> next_n) {
            this.next = next_n;
        }
    }
    
    private int size;
    private E_Node<E> head;

    public E_LinkedList() {
        this.size = 0;
        this.head = null;
    }

    public int size() {
        return size;
    }    

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private E_Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E_Node<E> current_node = current;
                E_Node<E> next_node = current.getNext();
                current = next_node;
                return current_node.getElement();
            }
        };
    }
  
    public boolean add(E e) {
        E_Node<E> e_node = new E_Node<>(e);
       
        if (head == null) {
            head = e_node;
        } else {
            E_Node<E> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(e_node);
        }    
        size++;
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e: c) {
            if (add(e)) {
                modified = true;
                size ++;
            }
        }
        return modified;
    }

    public void clear() {
        E_Node<E> current = head;
        while (current != null) {
            E_Node<E> next = current.getNext();
            current.setNext(null);
            current = next;
        }
        head = null;
        size = 0;
    }

    public boolean contains(Object o) {
        for (E e: this) {
            if (o.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object o: c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return head == null;
    }
    
}