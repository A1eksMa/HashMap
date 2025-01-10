import java.util.*;

class Main {
    public static void main(String[] args) {
        String one = "One";
        String two = "Two";
        String three = "Three";
        
        // Test E_LinkedList class
        E_LinkedList<String> e_linked_list = new E_LinkedList<>();
        
        // Test `.add()` method of E_LinkedList class
        e_linked_list.add(one);
        e_linked_list.add(two);
        e_linked_list.add(three);
        
        // Test `.iterator()` method of E_LinkedList class
        for (String e: e_linked_list) {
            System.out.println(e);
        }

        // Test `.clear()` method of E_LinkedList class
        e_linked_list.clear();

        // Test `.addAll()` method of E_LinkedList class
        ArrayList<String> arr = new ArrayList<>();
        arr.add("one");
        arr.add("two");
        arr.add("three");
        e_linked_list.addAll(arr);
        for (String e: e_linked_list) {
            System.out.println(e);
        }

        // Test `.contains()` method of E_LinkedList class
        String a = "One";
        String b = "one";
        System.out.println(e_linked_list.contains(a));
        System.out.println(e_linked_list.contains(b));

        // Test `.containsAll()` method of E_LinkedList class
        System.out.println(e_linked_list.containsAll(arr));
        
        
        // Test KV_LinkedList class
        KV_LinkedList<String, Integer> kv_list = new KV_LinkedList<>();

        

        /**
        list.add("One", 1);
        list.add("Two", 2);
        list.add("Three", 1);
        for (Node<String, Integer> node: list) {
            System.out.println(node.getKey());
        }
        **/
    }
}