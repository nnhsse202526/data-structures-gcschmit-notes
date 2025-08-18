/**
    Comprehensive testing of the LinkedListQueue.lastToFirst() method.
    Tests various edge cases and scenarios to catch common implementation errors.
*/
public class QueueTester
{
    private static int testCount = 0;
    private static int passedTests = 0;

    public static void main(String[] args)
    {
        System.out.println("=== LinkedListQueue lastToFirst() Comprehensive Tests ===\n");
        
        testEmptyQueue();
        testSingleElementQueue();
        testTwoElementQueue();
        testMultipleElementQueue();
        testMultipleLastToFirstCalls();
        testOperationsAfterLastToFirst();
        testCircularityDetection();
        testQueueIntegrity();
        testNullHandling();
        
        System.out.println("\n=== Test Summary ===");
        System.out.println("Tests passed: " + passedTests + "/" + testCount);
        if (passedTests == testCount) {
            System.out.println("All tests PASSED! ✓");
        } else {
            System.out.println("Some tests FAILED! ✗");
        }
    }

    /**
     * Test lastToFirst on an empty queue - should not crash
     */
    private static void testEmptyQueue()
    {
        System.out.println("Test 1: Empty Queue");
        LinkedListQueue q = new LinkedListQueue();
        
        try {
            q.lastToFirst();  // Should not crash
            boolean isEmpty = q.empty();
            
            if (isEmpty) {
                System.out.println("PASS: Empty queue remains empty after lastToFirst()");
                passedTests++;
            } else {
                System.out.println("FAIL: Empty queue is no longer empty after lastToFirst()");
            }
        } catch (Exception e) {
            System.out.println("FAIL: Exception thrown on empty queue: " + e.getMessage());
        }
        testCount++;
        System.out.println();
    }

    /**
     * Test lastToFirst on a single element queue - should remain unchanged
     */
    private static void testSingleElementQueue()
    {
        System.out.println("Test 2: Single Element Queue");
        LinkedListQueue q = new LinkedListQueue();
        q.add("Only");
        
        q.lastToFirst();
        
        String result = extractAllElements(q);
        String expected = "Only";
        
        if (result.equals(expected)) {
            System.out.println("PASS: Single element queue unchanged");
            passedTests++;
        } else {
            System.out.println("FAIL: Expected '" + expected + "', got '" + result + "'");
        }
        testCount++;
        System.out.println();
    }

    /**
     * Test lastToFirst on a two element queue
     */
    private static void testTwoElementQueue()
    {
        System.out.println("Test 3: Two Element Queue");
        LinkedListQueue q = new LinkedListQueue();
        q.add("First");
        q.add("Second");
        
        q.lastToFirst();
        
        String result = extractAllElements(q);
        String expected = "Second First";
        
        if (result.equals(expected)) {
            System.out.println("PASS: Two elements correctly swapped");
            passedTests++;
        } else {
            System.out.println("FAIL: Expected '" + expected + "', got '" + result + "'");
        }
        testCount++;
        System.out.println();
    }

    /**
     * Test lastToFirst on a queue with multiple elements (original test case)
     */
    private static void testMultipleElementQueue()
    {
        System.out.println("Test 4: Multiple Element Queue (Original Test)");
        LinkedListQueue q = new LinkedListQueue();
        q.add("Tom");
        q.add("Diana");
        q.add("Harry");
        q.lastToFirst();
        q.add("Sarah");
        q.add("John");

        String result = extractAllElements(q);
        String expected = "Harry Tom Diana Sarah John";
        
        if (result.equals(expected)) {
            System.out.println("PASS: Multiple element queue correctly reordered");
            passedTests++;
        } else {
            System.out.println("FAIL: Expected '" + expected + "', got '" + result + "'");
        }
        testCount++;
        System.out.println();
    }

    /**
     * Test multiple consecutive calls to lastToFirst
     */
    private static void testMultipleLastToFirstCalls()
    {
        System.out.println("Test 5: Multiple Consecutive lastToFirst() Calls");
        LinkedListQueue q = new LinkedListQueue();
        q.add("A");
        q.add("B");
        q.add("C");
        q.add("D");
        
        // First call: D A B C
        q.lastToFirst();
        String result1 = peekAllElements(q);
        
        // Second call: C D A B
        q.lastToFirst();
        String result2 = peekAllElements(q);
        
        // Third call: B C D A
        q.lastToFirst();
        String result3 = extractAllElements(q);
        
        boolean test1 = result1.equals("D A B C");
        boolean test2 = result2.equals("C D A B");
        boolean test3 = result3.equals("B C D A");
        
        if (test1 && test2 && test3) {
            System.out.println("PASS: Multiple lastToFirst calls work correctly");
            System.out.println("  After 1st call: " + result1);
            System.out.println("  After 2nd call: " + result2);
            System.out.println("  After 3rd call: " + result3);
            passedTests++;
        } else {
            System.out.println("FAIL: Multiple lastToFirst calls failed");
            System.out.println("  After 1st call: " + result1 + " (expected: D A B C)");
            System.out.println("  After 2nd call: " + result2 + " (expected: C D A B)");
            System.out.println("  After 3rd call: " + result3 + " (expected: B C D A)");
        }
        testCount++;
        System.out.println();
    }

    /**
     * Test that normal queue operations work correctly after lastToFirst
     */
    private static void testOperationsAfterLastToFirst()
    {
        System.out.println("Test 6: Queue Operations After lastToFirst()");
        LinkedListQueue q = new LinkedListQueue();
        q.add("X");
        q.add("Y");
        q.add("Z");
        
        q.lastToFirst();  // Z X Y
        
        // Remove one element
        Object removed = q.remove();  // Should remove Z, leaving X Y
        
        // Add another element
        q.add("W");  // Should result in X Y W
        
        String result = extractAllElements(q);
        String expected = "X Y W";
        boolean removedCorrect = "Z".equals(removed);
        
        if (result.equals(expected) && removedCorrect) {
            System.out.println("PASS: Queue operations work correctly after lastToFirst");
            System.out.println("  Removed element: " + removed);
            System.out.println("  Final queue: " + result);
            passedTests++;
        } else {
            System.out.println("FAIL: Queue operations failed after lastToFirst");
            System.out.println("  Removed element: " + removed + " (expected: Z)");
            System.out.println("  Final queue: " + result + " (expected: " + expected + ")");
        }
        testCount++;
        System.out.println();
    }

    /**
     * Test for circular list detection - this catches a common error where
     * students might accidentally create a circular linked list
     */
    private static void testCircularityDetection()
    {
        System.out.println("Test 7: Circularity Detection");
        LinkedListQueue q = new LinkedListQueue();
        q.add("Alpha");
        q.add("Beta");
        q.add("Gamma");
        q.add("Delta");
        
        q.lastToFirst();
        
        // Try to extract more elements than should exist
        String result = extractAllElementsWithLimit(q, 10);
        String[] elements = result.trim().split("\\s+");
        
        if (elements.length == 4 && !result.contains("CIRCULAR")) {
            System.out.println("PASS: No circular list detected, correct number of elements");
            System.out.println("  Elements: " + result);
            passedTests++;
        } else {
            System.out.println("FAIL: Possible circular list or incorrect element count");
            System.out.println("  Elements found: " + elements.length);
            System.out.println("  Result: " + result);
        }
        testCount++;
        System.out.println();
    }

    /**
     * Test queue integrity - verifies head and tail pointers are correctly maintained
     */
    private static void testQueueIntegrity()
    {
        System.out.println("Test 8: Queue Integrity After lastToFirst()");
        LinkedListQueue q = new LinkedListQueue();
        q.add("Start");
        q.add("Middle");
        q.add("End");
        
        q.lastToFirst();  // Should be: End Start Middle
        
        // Test that we can still add and remove properly
        q.add("New");     // Should be: End Start Middle New
        Object first = q.remove();  // Should remove End
        Object second = q.remove(); // Should remove Start
        q.add("Another"); // Should be: Middle New Another
        
        String remaining = extractAllElements(q);
        String expected = "Middle New Another";
        boolean firstCorrect = "End".equals(first);
        boolean secondCorrect = "Start".equals(second);
        
        if (remaining.equals(expected) && firstCorrect && secondCorrect) {
            System.out.println("PASS: Queue integrity maintained after lastToFirst");
            System.out.println("  First removed: " + first);
            System.out.println("  Second removed: " + second);
            System.out.println("  Final queue: " + remaining);
            passedTests++;
        } else {
            System.out.println("FAIL: Queue integrity compromised");
            System.out.println("  First removed: " + first + " (expected: End)");
            System.out.println("  Second removed: " + second + " (expected: Start)");
            System.out.println("  Final queue: " + remaining + " (expected: " + expected + ")");
        }
        testCount++;
        System.out.println();
    }

    /**
     * Test handling of null values
     */
    private static void testNullHandling()
    {
        System.out.println("Test 9: Null Value Handling");
        LinkedListQueue q = new LinkedListQueue();
        q.add("First");
        q.add(null);
        q.add("Third");
        
        try {
            q.lastToFirst();  // Should move Third to front: Third First null
            
            Object removed = q.remove();  // Should remove Third (which is now first)
            
            String remaining = extractAllElements(q);
            // The exact result depends on implementation, but it should not crash
            
            System.out.println("PASS: Null values handled without crashing");
            System.out.println("  Removed element: " + removed);
            System.out.println("  Remaining queue: " + remaining);
            passedTests++;
        } catch (Exception e) {
            System.out.println("FAIL: Exception when handling null values: " + e.getMessage());
        }
        testCount++;
        System.out.println();
    }

    /**
     * Helper method to extract all elements from queue (destructive)
     */
    private static String extractAllElements(LinkedListQueue q)
    {
        StringBuilder result = new StringBuilder();
        while (!q.empty()) {
            if (result.length() > 0) result.append(" ");
            Object element = q.remove();
            result.append(element == null ? "null" : element.toString());
        }
        return result.toString();
    }

    /**
     * Helper method to peek at all elements without removing them
     */
    private static String peekAllElements(LinkedListQueue q)
    {
        // Create a copy to peek at elements
        LinkedListQueue copy = copyQueue(q);
        return extractAllElements(copy);
    }

    /**
     * Helper method to create a copy of the queue for non-destructive testing
     */
    private static LinkedListQueue copyQueue(LinkedListQueue original)
    {
        LinkedListQueue copy = new LinkedListQueue();
        LinkedListQueue temp = new LinkedListQueue();
        
        // Move elements to temp while copying to new queue
        while (!original.empty()) {
            Object element = original.remove();
            temp.add(element);
            copy.add(element);
        }
        
        // Restore original queue
        while (!temp.empty()) {
            original.add(temp.remove());
        }
        
        return copy;
    }

    /**
     * Helper method to extract elements with a limit to detect circular lists
     */
    private static String extractAllElementsWithLimit(LinkedListQueue q, int maxElements)
    {
        StringBuilder result = new StringBuilder();
        int count = 0;
        
        while (!q.empty() && count < maxElements) {
            if (result.length() > 0) result.append(" ");
            Object element = q.remove();
            result.append(element == null ? "null" : element.toString());
            count++;
        }
        
        if (!q.empty()) {
            result.append(" CIRCULAR_LIST_DETECTED");
        }
        
        return result.toString();
    }
}
