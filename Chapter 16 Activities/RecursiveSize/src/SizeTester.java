/**
    A comprehensive tester program for the LinkedList class size method.
    Tests various scenarios to catch common implementation errors.
*/
public class SizeTester
{   
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void main(String[] args)
    { 
        System.out.println("Testing LinkedList size() method...\n");
        
        // Test 1: Empty list
        testEmptyList();
        
        // Test 2: Single element list
        testSingleElement();
        
        // Test 3: Multiple elements added with addFirst
        testMultipleElements();
        
        // Test 4: List after removals
        testAfterRemovals();
        
        // Test 5: Complex operations with iterator
        testComplexOperations();
        
        // Test 6: Edge case - all elements removed
        testAllElementsRemoved();
        
        // Test 7: Adding and removing alternately
        testAlternatingAddRemove();
        
        // Test 8: Large list to test recursion depth
        testLargeList();
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Tests passed: " + testsPassed + "/" + totalTests);
        if (testsPassed == totalTests) {
            System.out.println("All tests PASSED! ✓");
        } else {
            System.out.println("Some tests FAILED! ✗");
        }
    }
    
    private static void testEmptyList() {
        System.out.println("Test 1: Empty list");
        LinkedList list = new LinkedList();
        testSize(list, 0, "Empty list should have size 0");
    }
    
    private static void testSingleElement() {
        System.out.println("Test 2: Single element");
        LinkedList list = new LinkedList();
        list.addFirst("A");
        testSize(list, 1, "Single element list should have size 1");
    }
    
    private static void testMultipleElements() {
        System.out.println("Test 3: Multiple elements");
        LinkedList list = new LinkedList();
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        testSize(list, 3, "Three element list should have size 3");
        
        list.addFirst("D");
        list.addFirst("E");
        testSize(list, 5, "Five element list should have size 5");
    }
    
    private static void testAfterRemovals() {
        System.out.println("Test 4: After removals");
        LinkedList list = new LinkedList();
        list.addFirst("D");
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        
        list.removeFirst(); // Remove A
        testSize(list, 3, "After removing first element, size should be 3");
        
        list.removeFirst(); // Remove B
        list.removeFirst(); // Remove C
        testSize(list, 1, "After removing two more elements, size should be 1");
    }
    
    private static void testComplexOperations() {
        System.out.println("Test 5: Complex iterator operations");
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
        
        testSize(names, 2, "After complex operations, size should be 2");
        
        // Verify the actual content matches expected
        iterator = names.listIterator();
        String result = "";
        while (iterator.hasNext()) {
            result += iterator.next() + " ";
        }
        System.out.println("  Content: " + result.trim());
        System.out.println("  Expected: Juliet Emily");
    }
    
    private static void testAllElementsRemoved() {
        System.out.println("Test 6: All elements removed");
        LinkedList list = new LinkedList();
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        testSize(list, 0, "After removing all elements, size should be 0");
    }
    
    private static void testAlternatingAddRemove() {
        System.out.println("Test 7: Alternating add/remove");
        LinkedList list = new LinkedList();
        
        // Add some elements
        list.addFirst("A");
        list.addFirst("B");
        testSize(list, 2, "After adding 2 elements, size should be 2");
        
        // Remove one, add one
        list.removeFirst();
        list.addFirst("C");
        testSize(list, 2, "After remove then add, size should still be 2");
        
        // Add more
        list.addFirst("D");
        list.addFirst("E");
        testSize(list, 4, "After adding 2 more, size should be 4");
    }
    
    private static void testLargeList() {
        System.out.println("Test 8: Large list (recursion depth test)");
        LinkedList list = new LinkedList();
        int size = 100;
        
        // Add many elements
        for (int i = 0; i < size; i++) {
            list.addFirst("Element" + i);
        }
        testSize(list, size, "Large list should have size " + size);
        
        // Remove half
        for (int i = 0; i < size / 2; i++) {
            list.removeFirst();
        }
        testSize(list, size / 2, "After removing half, size should be " + (size / 2));
    }
    
    private static void testSize(LinkedList list, int expected, String description) {
        totalTests++;
        try {
            int actual = list.size();
            if (actual == expected) {
                System.out.println("  ✓ PASS: " + description + " (got " + actual + ")");
                testsPassed++;
            } else {
                System.out.println("  ✗ FAIL: " + description);
                System.out.println("    Expected: " + expected + ", Got: " + actual);
            }
        } catch (Exception e) {
            System.out.println("  ✗ ERROR: " + description);
            System.out.println("    Exception: " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        System.out.println();
    }
}
