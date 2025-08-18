/**
    A tester program for a revised version of the LinkedList class.
*/
public class SizeTester
{   
    public static void main(String[] args)
    {
        // Test 1: Empty list
        LinkedList list = new LinkedList();
        System.out.println("Test 1: Empty list size: " + list.size());
        System.out.println("Expected: 0");

        // Test 2: Add elements
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        System.out.println("Test 2: After 3 adds: " + list.size());
        System.out.println("Expected: 3");

        // Test 3: Remove one
        list.removeFirst();
        System.out.println("Test 3: After 1 remove: " + list.size());
        System.out.println("Expected: 2");

        // Test 4: Remove all
        list.removeFirst();
        list.removeFirst();
        System.out.println("Test 4: After removing all: " + list.size());
        System.out.println("Expected: 0");

        // Test 5: Add and remove repeatedly
        list.addFirst("X");
        list.removeFirst();
        list.addFirst("Y");
        System.out.println("Test 5: Add/remove/add: " + list.size());
        System.out.println("Expected: 1");

        // Test 6: Iterator add/remove
        list.addFirst("Z"); // Now: Z Y
        ListIterator it = list.listIterator();
        it.next(); // Z
        it.add("W"); // Z W Y
        System.out.println("Test 6: After iterator add: " + list.size());
        System.out.println("Expected: 3");
        it.next(); // W
        it.remove(); // Remove W, list: Z Y
        System.out.println("Test 6b: After iterator remove: " + list.size());
        System.out.println("Expected: 2");

        // Test 7: Add many, then remove many
        for (int i = 0; i < 10; i++) list.addFirst(i);
        System.out.println("Test 7: After adding 10: " + list.size());
        System.out.println("Expected: 12");
        for (int i = 0; i < 12; i++) list.removeFirst();
        System.out.println("Test 7b: After removing all: " + list.size());
        System.out.println("Expected: 0");

        // Test 8: Original scenario from starter
        LinkedList names = new LinkedList();
        names.addFirst("Tom");
        names.addFirst("Romeo");
        names.addFirst("Harry");
        names.addFirst("Dick");

        ListIterator iterator = names.listIterator();
        iterator.next();
        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.remove();
        iterator.add("Juliet");
        iterator.next();
        iterator.set("Emily");

        names.removeFirst();

        iterator = names.listIterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
        System.out.println();
        System.out.println("Expected: Juliet Emily");
        System.out.println("Test 8: " + names.size());
        System.out.println("Expected: 2");
    }
}
