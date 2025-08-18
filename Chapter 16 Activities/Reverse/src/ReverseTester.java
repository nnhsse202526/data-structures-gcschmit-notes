/**
    A comprehensive test program to reverse the entries in a linked list.
    Tests various edge cases to catch common implementation errors.
*/
public class ReverseTester
{   
    public static void main(String[] args)
    { 
        System.out.println("=== LinkedList Reverse Method Tests ===\n");
        
        // Test 1: Empty list
        testEmptyList();
        
        // Test 2: Single element list
        testSingleElement();
        
        // Test 3: Two element list
        testTwoElements();
        
        // Test 4: Multiple elements (original test)
        testMultipleElements();
        
        // Test 5: Large list
        testLargeList();
        
        // Test 6: Double reverse (should return to original)
        testDoubleReverse();
        
        // Test 7: Test after operations
        testAfterOperations();
        
        System.out.println("\n=== All tests completed ===");
    }
    
    /**
     * Test reversing an empty list - should not crash
     */
    private static void testEmptyList()
    {
        System.out.println("Test 1: Empty list");
        LinkedList list = new LinkedList();
        
        try {
            list.reverse();
            System.out.println("✓ Empty list reverse completed without error");
        } catch (Exception e) {
            System.out.println("✗ ERROR: Empty list reverse threw exception: " + e.getMessage());
        }
        
        // Verify list is still empty
        ListIterator iter = list.listIterator();
        if (!iter.hasNext()) {
            System.out.println("✓ Empty list remains empty after reverse");
        } else {
            System.out.println("✗ ERROR: Empty list is no longer empty after reverse");
        }
        System.out.println();
    }
    
    /**
     * Test reversing a single element list
     */
    private static void testSingleElement()
    {
        System.out.println("Test 2: Single element list");
        LinkedList list = new LinkedList();
        list.addFirst("Solo");
        
        list.reverse();
        
        String result = printList(list);
        String expected = "Solo";
        
        if (result.equals(expected)) {
            System.out.println("✓ Single element: " + result);
        } else {
            System.out.println("✗ ERROR - Expected: " + expected + ", Got: " + result);
        }
        System.out.println();
    }
    
    /**
     * Test reversing a two element list - catches pointer errors
     */
    private static void testTwoElements()
    {
        System.out.println("Test 3: Two element list");
        LinkedList list = new LinkedList();
        list.addFirst("Second");
        list.addFirst("First");
        
        list.reverse();
        
        String result = printList(list);
        String expected = "Second First";
        
        if (result.equals(expected)) {
            System.out.println("✓ Two elements: " + result);
        } else {
            System.out.println("✗ ERROR - Expected: " + expected + ", Got: " + result);
        }
        System.out.println();
    }
    
    /**
     * Test reversing multiple elements (original test case)
     */
    private static void testMultipleElements()
    {
        System.out.println("Test 4: Multiple elements");
        LinkedList list = new LinkedList();
        list.addFirst("Tom");
        list.addFirst("Romeo");
        list.addFirst("Harry");
        list.addFirst("Dick");
        
        list.reverse();
        
        String result = printList(list);
        String expected = "Tom Romeo Harry Dick";
        
        if (result.equals(expected)) {
            System.out.println("✓ Multiple elements: " + result);
        } else {
            System.out.println("✗ ERROR - Expected: " + expected + ", Got: " + result);
        }
        System.out.println();
    }
    
    /**
     * Test reversing a larger list to catch performance/logic issues
     */
    private static void testLargeList()
    {
        System.out.println("Test 5: Large list (10 elements)");
        LinkedList list = new LinkedList();
        
        // Add numbers 0-9
        for (int i = 0; i < 10; i++) {
            list.addFirst(String.valueOf(i));
        }
        
        list.reverse();
        
        String result = printList(list);
        String expected = "0 1 2 3 4 5 6 7 8 9";
        
        if (result.equals(expected)) {
            System.out.println("✓ Large list: " + result);
        } else {
            System.out.println("✗ ERROR - Expected: " + expected + ", Got: " + result);
        }
        System.out.println();
    }
    
    /**
     * Test double reverse - should return to original order
     */
    private static void testDoubleReverse()
    {
        System.out.println("Test 6: Double reverse");
        LinkedList list = new LinkedList();
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        
        // Store original order
        String original = printList(list);
        
        // Reverse twice
        list.reverse();
        list.reverse();
        
        String result = printList(list);
        
        if (result.equals(original)) {
            System.out.println("✓ Double reverse returns to original: " + result);
        } else {
            System.out.println("✗ ERROR - Original: " + original + ", After double reverse: " + result);
        }
        System.out.println();
    }
    
    /**
     * Test reverse after other operations to ensure it works correctly
     */
    private static void testAfterOperations()
    {
        System.out.println("Test 7: Reverse after other operations");
        LinkedList list = new LinkedList();
        list.addFirst("Third");
        list.addFirst("Second");
        list.addFirst("First");
        
        // Remove first element
        list.removeFirst();
        
        list.reverse();
        
        String result = printList(list);
        String expected = "Third Second";
        
        if (result.equals(expected)) {
            System.out.println("✓ Reverse after removeFirst: " + result);
        } else {
            System.out.println("✗ ERROR - Expected: " + expected + ", Got: " + result);
        }
        System.out.println();
    }
    
    /**
     * Helper method to print list contents as a string
     */
    private static String printList(LinkedList list)
    {
        StringBuilder sb = new StringBuilder();
        ListIterator iter = list.listIterator();
        boolean first = true;
        
        while (iter.hasNext()) {
            if (!first) {
                sb.append(" ");
            }
            sb.append(iter.next());
            first = false;
        }
        
        return sb.toString();
    }
}
