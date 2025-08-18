/**
    Testing the LinkedListQueue.firstToLast() method
    
    This test suite checks for common implementation errors:
    1. NullPointerException on empty queue
    2. Incorrect handling of single-element queue
    3. Not properly updating head and tail pointers
    4. Breaking the linked list structure
    5. Changing queue size inadvertently
*/
public class QueueTester
{
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void main(String[] args)
    {
        System.out.println("Testing firstToLast() method:");
        System.out.println("==============================");
        
        // Test 1: Empty queue - common error: NullPointerException
        testEmptyQueue();
        
        // Test 2: Single element queue - should do nothing
        testSingleElement();
        
        // Test 3: Two element queue - basic functionality
        testTwoElements();
        
        // Test 4: Multiple elements - core functionality
        testMultipleElements();
        
        // Test 5: Queue size preservation
        testQueueSizePreservation();
        
        // Test 6: Queue operations after firstToLast
        testQueueOperationsAfter();
        
        // Test 7: Boundary conditions
        testBoundaryConditions();
        
        System.out.println("\n==============================");
        System.out.println("Tests passed: " + testsPassed + "/" + totalTests);
        
        if (testsPassed == totalTests) {
            System.out.println("All tests PASSED! ✓");
        } else {
            System.out.println("Some tests FAILED. Check implementation for common errors:");
            System.out.println("- Null pointer handling for empty queue");
            System.out.println("- Proper head/tail pointer updates");
            System.out.println("- Preserving queue size");
            System.out.println("- Maintaining linked list integrity");
        }
    }
    
    /**
     * Test firstToLast on an empty queue
     * Common student error: Not checking for null pointers
     */
    public static void testEmptyQueue()
    {
        System.out.println("\nTest 1: Empty queue (null pointer check)");
        totalTests++;
        
        LinkedListQueue q = new LinkedListQueue();
        
        try {
            q.firstToLast();
            
            // Verify queue is still empty and functional
            if (q.empty()) {
                System.out.println("✓ Empty queue handled correctly");
                testsPassed++;
            } else {
                System.out.println("✗ ERROR: Empty queue should remain empty");
            }
        } catch (Exception e) {
            System.out.println("✗ ERROR: Exception on empty queue - " + e.getClass().getSimpleName());
            System.out.println("  Hint: Check for null pointers before accessing head/tail");
        }
    }
    
    /**
     * Test firstToLast on a single element queue
     * Common student error: Not handling head == tail case
     */
    public static void testSingleElement()
    {
        System.out.println("\nTest 2: Single element queue (head == tail case)");
        totalTests++;
        
        LinkedListQueue q = new LinkedListQueue();
        q.add("Only");
        
        q.firstToLast();
        
        if (!q.empty() && "Only".equals(q.remove()) && q.empty()) {
            System.out.println("✓ Single element queue unchanged correctly");
            testsPassed++;
        } else {
            System.out.println("✗ ERROR: Single element queue not handled correctly");
            System.out.println("  Hint: When head == tail, no operation should be performed");
        }
    }
    
    /**
     * Test firstToLast on a two element queue
     * Tests basic functionality and pointer updates
     */
    public static void testTwoElements()
    {
        System.out.println("\nTest 3: Two element queue (basic functionality)");
        totalTests++;
        
        LinkedListQueue q = new LinkedListQueue();
        q.add("First");
        q.add("Second");
        
        q.firstToLast();
        
        String first = (String) q.remove();
        String second = (String) q.remove();
        
        if ("Second".equals(first) && "First".equals(second) && q.empty()) {
            System.out.println("✓ Two elements correctly swapped");
            testsPassed++;
        } else {
            System.out.println("✗ ERROR: Expected 'Second First', got '" + first + " " + second + "'");
            System.out.println("  Hint: Move head to after tail, update head to head.next");
        }
    }
    
    /**
     * Test firstToLast on multiple elements
     * Original test case - core functionality
     */
    public static void testMultipleElements()
    {
        System.out.println("\nTest 4: Multiple elements (core functionality)");
        totalTests++;
        
        LinkedListQueue q = new LinkedListQueue();
        q.add("Tom");
        q.add("Diana");
        q.add("Harry");
        
        q.firstToLast();
        
        String result = "";
        String[] expected = {"Diana", "Harry", "Tom"};
        boolean correct = true;
        
        for (int i = 0; i < expected.length; i++) {
            if (q.empty()) {
                correct = false;
                break;
            }
            String actual = (String) q.remove();
            result += actual + " ";
            if (!expected[i].equals(actual)) {
                correct = false;
            }
        }
        
        if (correct && q.empty()) {
            System.out.println("✓ Multiple elements handled correctly");
            testsPassed++;
        } else {
            System.out.println("✗ ERROR: Expected 'Diana Harry Tom', got '" + result.trim() + "'");
            System.out.println("  Hint: First element should move to end, preserving order of others");
        }
    }
    
    /**
     * Test that queue size is preserved
     * Common student error: Accidentally removing or duplicating elements
     */
    public static void testQueueSizePreservation()
    {
        System.out.println("\nTest 5: Queue size preservation");
        totalTests++;
        
        LinkedListQueue q = new LinkedListQueue();
        String[] elements = {"A", "B", "C", "D", "E"};
        
        // Add elements and count original size
        for (String element : elements) {
            q.add(element);
        }
        
        q.firstToLast();
        
        // Count elements after firstToLast
        int count = 0;
        while (!q.empty()) {
            q.remove();
            count++;
        }
        
        if (count == elements.length) {
            System.out.println("✓ Queue size preserved (" + count + " elements)");
            testsPassed++;
        } else {
            System.out.println("✗ ERROR: Expected " + elements.length + " elements, found " + count);
            System.out.println("  Hint: firstToLast should move elements, not add or remove them");
        }
    }
    
    /**
     * Test that normal queue operations work after firstToLast
     * Common student error: Breaking the linked list structure
     */
    public static void testQueueOperationsAfter()
    {
        System.out.println("\nTest 6: Queue operations after firstToLast");
        totalTests++;
        
        LinkedListQueue q = new LinkedListQueue();
        q.add("X");
        q.add("Y");
        q.add("Z");
        
        q.firstToLast(); // X Y Z -> Y Z X
        
        // Test that we can still add and remove
        q.add("W");      // Should be: Y Z X W
        
        String removed = (String) q.remove(); // Should remove Y
        
        if ("Y".equals(removed)) {
            // Continue removing to verify structure
            String[] remaining = new String[3];
            int i = 0;
            while (!q.empty() && i < 3) {
                remaining[i] = (String) q.remove();
                i++;
            }
            
            if (i == 3 && "Z".equals(remaining[0]) && "X".equals(remaining[1]) && "W".equals(remaining[2])) {
                System.out.println("✓ Queue operations work correctly after firstToLast");
                testsPassed++;
            } else {
                System.out.println("✗ ERROR: Queue structure corrupted after firstToLast");
                System.out.println("  Expected remaining: Z X W");
                System.out.println("  Actual remaining: " + String.join(" ", remaining));
            }
        } else {
            System.out.println("✗ ERROR: Expected to remove Y, but got " + removed);
            System.out.println("  Hint: Check that head pointer is updated correctly");
        }
    }
    
    /**
     * Test boundary conditions and edge cases
     */
    public static void testBoundaryConditions()
    {
        System.out.println("\nTest 7: Boundary conditions");
        totalTests++;
        
        boolean allPassed = true;
        
        // Test: firstToLast followed by immediate operations
        try {
            LinkedListQueue q = new LinkedListQueue();
            q.add("Test");
            q.firstToLast();
            q.add("After");
            
            String first = (String) q.remove();
            String second = (String) q.remove();
            
            if (!"Test".equals(first) || !"After".equals(second)) {
                allPassed = false;
                System.out.println("  ✗ Single element + add after firstToLast failed");
            }
        } catch (Exception e) {
            allPassed = false;
            System.out.println("  ✗ Exception in boundary test: " + e.getMessage());
        }
        
        if (allPassed) {
            System.out.println("✓ Boundary conditions handled correctly");
            testsPassed++;
        } else {
            System.out.println("✗ Some boundary conditions failed");
            System.out.println("  Hint: Ensure tail pointer is properly updated");
        }
    }
}
