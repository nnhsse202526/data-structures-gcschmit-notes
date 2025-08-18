/**
    A comprehensive tester program for the contains method of the LinkedList class.
    This tests various edge cases and common implementation errors.
*/
public class ListTester
{
    private static int testCount = 0;
    private static int passCount = 0;

    public static void main(String[] args)
    {
        System.out.println("=== Testing LinkedList contains() method ===\n");
        
        testEmptyList();
        testSingleElement();
        testMultipleElements();
        testNullValues();
        testDuplicateElements();
        testFirstAndLastElements();
        testCaseSensitivity();
        testDifferentDataTypes();
        
        System.out.println("\n=== Test Summary ===");
        System.out.println("Tests passed: " + passCount + "/" + testCount);
        if (passCount == testCount) {
            System.out.println("All tests PASSED! ✓");
        } else {
            System.out.println("Some tests FAILED! ✗");
        }
    }
    
    private static void testEmptyList() {
        System.out.println("--- Testing Empty List ---");
        LinkedList list = new LinkedList();
        
        // Test 1: Empty list should not contain any element
        runTest("Empty list contains 'test'", list.contains("test"), false);
        runTest("Empty list contains null", list.contains(null), false);
        runTest("Empty list contains empty string", list.contains(""), false);
        System.out.println();
    }
    
    private static void testSingleElement() {
        System.out.println("--- Testing Single Element ---");
        LinkedList list = new LinkedList();
        list.addFirst("Hello");
        
        // Test 2: Single element list
        runTest("Single element list contains existing element", list.contains("Hello"), true);
        runTest("Single element list contains non-existing element", list.contains("World"), false);
        runTest("Single element list contains null", list.contains(null), false);
        System.out.println();
    }
    
    private static void testMultipleElements() {
        System.out.println("--- Testing Multiple Elements ---");
        LinkedList list = new LinkedList();
        list.addFirst("Tom");     // Order after additions: Dick, Harry, Romeo, Tom
        list.addFirst("Romeo");
        list.addFirst("Harry");
        list.addFirst("Dick");
        
        // Test 3: Multiple elements - existing elements
        runTest("Contains first element (Dick)", list.contains("Dick"), true);
        runTest("Contains middle element (Harry)", list.contains("Harry"), true);
        runTest("Contains middle element (Romeo)", list.contains("Romeo"), true);
        runTest("Contains last element (Tom)", list.contains("Tom"), true);
        
        // Test 4: Multiple elements - non-existing elements
        runTest("Does not contain 'Zack'", list.contains("Zack"), false);
        runTest("Does not contain 'DICK' (wrong case)", list.contains("DICK"), false);
        runTest("Does not contain partial match 'Ha'", list.contains("Ha"), false);
        System.out.println();
    }
    
    private static void testNullValues() {
        System.out.println("--- Testing Null Values ---");
        LinkedList list = new LinkedList();
        list.addFirst("NotNull");
        list.addFirst(null);
        list.addFirst("AlsoNotNull");
        
        // Test 5: Null handling
        runTest("List with null element contains null", list.contains(null), false); // Should be false per implementation
        runTest("List with null element contains existing string", list.contains("NotNull"), true);
        runTest("List with null element contains non-existing string", list.contains("Missing"), false);
        System.out.println();
    }
    
    private static void testDuplicateElements() {
        System.out.println("--- Testing Duplicate Elements ---");
        LinkedList list = new LinkedList();
        list.addFirst("Duplicate");
        list.addFirst("Other");
        list.addFirst("Duplicate");  // Now we have: Duplicate, Other, Duplicate
        
        // Test 6: Duplicate elements
        runTest("Contains element that appears multiple times", list.contains("Duplicate"), true);
        runTest("Contains unique element", list.contains("Other"), true);
        runTest("Does not contain non-existing element", list.contains("NotThere"), false);
        System.out.println();
    }
    
    private static void testFirstAndLastElements() {
        System.out.println("--- Testing First and Last Elements Specifically ---");
        LinkedList list = new LinkedList();
        list.addFirst("Last");    // This will be last in the list
        list.addFirst("Middle1");
        list.addFirst("Middle2");
        list.addFirst("First");   // This will be first in the list
        
        // Test 7: Edge positions (common source of off-by-one errors)
        runTest("Contains first element", list.contains("First"), true);
        runTest("Contains last element", list.contains("Last"), true);
        runTest("Contains middle elements", list.contains("Middle1"), true);
        runTest("Contains middle elements", list.contains("Middle2"), true);
        System.out.println();
    }
    
    private static void testCaseSensitivity() {
        System.out.println("--- Testing Case Sensitivity ---");
        LinkedList list = new LinkedList();
        list.addFirst("CaseSensitive");
        
        // Test 8: Case sensitivity
        runTest("Exact case match", list.contains("CaseSensitive"), true);
        runTest("Wrong case should not match", list.contains("casesensitive"), false);
        runTest("Wrong case should not match", list.contains("CASESENSITIVE"), false);
        runTest("Wrong case should not match", list.contains("Casesensitive"), false);
        System.out.println();
    }
    
    private static void testDifferentDataTypes() {
        System.out.println("--- Testing Different Data Types ---");
        LinkedList list = new LinkedList();
        list.addFirst("String");
        list.addFirst(Integer.valueOf(42));
        list.addFirst(Double.valueOf(3.14));
        
        // Test 9: Different data types
        runTest("Contains string", list.contains("String"), true);
        runTest("Contains integer", list.contains(Integer.valueOf(42)), true);
        runTest("Contains double", list.contains(Double.valueOf(3.14)), true);
        runTest("String '42' does not equal Integer 42", list.contains("42"), false);
        runTest("Does not contain non-existing integer", list.contains(Integer.valueOf(99)), false);
        System.out.println();
    }
    
    private static void runTest(String description, boolean actual, boolean expected) {
        testCount++;
        if (actual == expected) {
            System.out.println("✓ PASS: " + description + " (Expected: " + expected + ", Got: " + actual + ")");
            passCount++;
        } else {
            System.out.println("✗ FAIL: " + description + " (Expected: " + expected + ", Got: " + actual + ")");
        }
    }
}
