/**
 * This class demonstrates the tree class with comprehensive tests
 * for the countNodesWithOneChild method.
 * 
 * Common student errors this test suite catches:
 * 1. Forgetting to handle null/empty trees
 * 2. Counting leaf nodes (nodes with 0 children) instead of nodes with 1 child
 * 3. Counting nodes with 2 children
 * 4. Not properly checking both left and right children
 * 5. Off-by-one errors in counting
 * 6. Not handling edge cases like single-node trees
 * 7. Incorrect base case handling
 */
public class TreeDemo {
  private static int testsPassed = 0;
  private static int totalTests = 0;
  
  public static void main(String[] args) {
    System.out.println("Testing countNodesWithOneChild method...");
    System.out.println("This test suite is designed to catch common implementation errors.\n");
    
    // Test 1: Empty tree (catches null pointer exceptions)
    testEmptyTree();
    
    // Test 2: Single node tree (catches leaf node confusion)
    testSingleNode();
    
    // Test 3: Tree with only leaf nodes (catches counting nodes with 2 children)
    testOnlyLeafNodes();
    
    // Test 4: Linear tree (catches proper recursive counting)
    testLinearTree();
    
    // Test 5: Complete binary tree (catches counting full nodes)
    testCompleteBinaryTree();
    
    // Test 6: Tree with only left children (catches left-only logic)
    testOnlyLeftChildren();
    
    // Test 7: Tree with only right children (catches right-only logic)
    testOnlyRightChildren();
    
    // Test 8: Mixed tree (original example - catches general logic)
    testMixedTree();
    
    // Test 9: Tree where root has one child (catches root edge case)
    testRootWithOneChild();
    
    // Test 10: Complex tree with various scenarios
    testComplexTree();
    
    System.out.println("\n" + "=".repeat(50));
    System.out.println("Tests passed: " + testsPassed + "/" + totalTests);
    if (testsPassed == totalTests) {
      System.out.println("✅ All tests PASSED! Implementation appears correct.");
    } else {
      System.out.println("❌ Some tests FAILED! Check your implementation.");
    }
  }
  
  /**
   * Test 1: Empty tree should return 0
   * Catches: Null pointer exceptions, improper base case handling
   */
  private static void testEmptyTree() {
    totalTests++;
    try {
      BinaryTree emptyTree = new BinaryTree();
      int result = emptyTree.countNodesWithOneChild();
      if (result == 0) {
        System.out.println("✅ Test 1 - Empty tree: " + result + " (Expected: 0)");
        testsPassed++;
      } else {
        System.out.println("❌ Test 1 - Empty tree: " + result + " (Expected: 0)");
      }
    } catch (Exception e) {
      System.out.println("❌ Test 1 - Empty tree: Exception thrown - " + e.getMessage());
    }
  }
  
  /**
   * Test 2: Single node tree should return 0
   * Catches: Confusion between leaf nodes and nodes with one child
   */
  private static void testSingleNode() {
    totalTests++;
    try {
      BinaryTree singleNode = new BinaryTree("A");
      int result = singleNode.countNodesWithOneChild();
      if (result == 0) {
        System.out.println("✅ Test 2 - Single node: " + result + " (Expected: 0)");
        testsPassed++;
      } else {
        System.out.println("❌ Test 2 - Single node: " + result + " (Expected: 0) - Single nodes are leaves, not one-child nodes!");
      }
    } catch (Exception e) {
      System.out.println("❌ Test 2 - Single node: Exception thrown - " + e.getMessage());
    }
  }
  
  /**
   * Test 3: Tree with only leaf nodes (full binary tree) should return 0
   * Catches: Counting nodes with two children instead of one child
   */
  private static void testOnlyLeafNodes() {
    totalTests++;
    try {
      // Tree structure:     A
      //                   /   \
      //                  B     C
      BinaryTree leftChild = new BinaryTree("B");
      BinaryTree rightChild = new BinaryTree("C");
      BinaryTree root = new BinaryTree("A", leftChild, rightChild);
      
      int result = root.countNodesWithOneChild();
      if (result == 0) {
        System.out.println("✅ Test 3 - Only leaf nodes: " + result + " (Expected: 0)");
        testsPassed++;
      } else {
        System.out.println("❌ Test 3 - Only leaf nodes: " + result + " (Expected: 0) - Nodes with 2 children don't count!");
      }
    } catch (Exception e) {
      System.out.println("❌ Test 3 - Only leaf nodes: Exception thrown - " + e.getMessage());
    }
  }
  
  /**
   * Test 4: Linear tree where each node has exactly one child (except leaf)
   * Catches: Improper recursive counting, not traversing all nodes
   */
  private static void testLinearTree() {
    totalTests++;
    try {
      // Tree structure: A -> B -> C -> D (all right children)
      BinaryTree d = new BinaryTree("D");
      BinaryTree c = new BinaryTree("C", null, d);
      BinaryTree b = new BinaryTree("B", null, c);
      BinaryTree a = new BinaryTree("A", null, b);
      
      int result = a.countNodesWithOneChild();
      if (result == 3) {
        System.out.println("✅ Test 4 - Linear tree: " + result + " (Expected: 3)");
        testsPassed++;
      } else {
        System.out.println("❌ Test 4 - Linear tree: " + result + " (Expected: 3) - A, B, and C each have exactly one child!");
      }
    } catch (Exception e) {
      System.out.println("❌ Test 4 - Linear tree: Exception thrown - " + e.getMessage());
    }
  }
  
  /**
   * Test 5: Complete binary tree should return 0
   * Catches: Counting internal nodes instead of one-child nodes
   */
  private static void testCompleteBinaryTree() {
    totalTests++;
    try {
      // Tree structure:       A
      //                    /     \
      //                   B       C
      //                  / \     / \
      //                 D   E   F   G
      BinaryTree d = new BinaryTree("D");
      BinaryTree e = new BinaryTree("E");
      BinaryTree f = new BinaryTree("F");
      BinaryTree g = new BinaryTree("G");
      BinaryTree b = new BinaryTree("B", d, e);
      BinaryTree c = new BinaryTree("C", f, g);
      BinaryTree root = new BinaryTree("A", b, c);
      
      int result = root.countNodesWithOneChild();
      if (result == 0) {
        System.out.println("✅ Test 5 - Complete binary tree: " + result + " (Expected: 0)");
        testsPassed++;
      } else {
        System.out.println("❌ Test 5 - Complete binary tree: " + result + " (Expected: 0) - All internal nodes have 2 children!");
      }
    } catch (Exception e) {
      System.out.println("❌ Test 5 - Complete binary tree: Exception thrown - " + e.getMessage());
    }
  }
  
  /**
   * Test 6: Tree with only left children
   * Catches: Not properly checking left child conditions
   */
  private static void testOnlyLeftChildren() {
    totalTests++;
    try {
      // Tree structure: A
      //                /
      //               B
      //              /
      //             C
      BinaryTree c = new BinaryTree("C");
      BinaryTree b = new BinaryTree("B", c, null);
      BinaryTree a = new BinaryTree("A", b, null);
      
      int result = a.countNodesWithOneChild();
      if (result == 2) {
        System.out.println("✅ Test 6 - Only left children: " + result + " (Expected: 2)");
        testsPassed++;
      } else {
        System.out.println("❌ Test 6 - Only left children: " + result + " (Expected: 2) - A and B each have exactly one (left) child!");
      }
    } catch (Exception e) {
      System.out.println("❌ Test 6 - Only left children: Exception thrown - " + e.getMessage());
    }
  }
  
  /**
   * Test 7: Tree with only right children  
   * Catches: Not properly checking right child conditions
   */
  private static void testOnlyRightChildren() {
    totalTests++;
    try {
      // Tree structure:   A
      //                    \
      //                     B
      //                      \
      //                       C
      BinaryTree c = new BinaryTree("C");
      BinaryTree b = new BinaryTree("B", null, c);
      BinaryTree a = new BinaryTree("A", null, b);
      
      int result = a.countNodesWithOneChild();
      if (result == 2) {
        System.out.println("✅ Test 7 - Only right children: " + result + " (Expected: 2)");
        testsPassed++;
      } else {
        System.out.println("❌ Test 7 - Only right children: " + result + " (Expected: 2) - A and B each have exactly one (right) child!");
      }
    } catch (Exception e) {
      System.out.println("❌ Test 7 - Only right children: Exception thrown - " + e.getMessage());
    }
  }
  
  /**
   * Test 8: Original mixed tree example
   * Catches: General logic errors in complex trees
   */
  private static void testMixedTree() {
    totalTests++;
    try {
      BinaryTree t1 = new BinaryTree("William");
      BinaryTree t2 = new BinaryTree("Charles", t1, null);  // Charles has one child (left)
      BinaryTree t3 = new BinaryTree("Savannah");
      BinaryTree t4 = new BinaryTree("Peter", t3, null);    // Peter has one child (left)
      BinaryTree t5 = new BinaryTree("Mia");
      BinaryTree t6 = new BinaryTree("Zara", null, t5);     // Zara has one child (right)
      BinaryTree t7 = new BinaryTree("Anne", t4, t6);       // Anne has two children
      BinaryTree root = new BinaryTree("Elizabeth", t2, t7); // Elizabeth has two children

      int result = root.countNodesWithOneChild();
      if (result == 3) {
        System.out.println("✅ Test 8 - Mixed tree (original): " + result + " (Expected: 3)");
        testsPassed++;
      } else {
        System.out.println("❌ Test 8 - Mixed tree (original): " + result + " (Expected: 3) - Charles, Peter, and Zara each have one child!");
      }
    } catch (Exception e) {
      System.out.println("❌ Test 8 - Mixed tree: Exception thrown - " + e.getMessage());
    }
  }
  
  /**
   * Test 9: Tree where root has one child
   * Catches: Not counting the root node when it has one child
   */
  private static void testRootWithOneChild() {
    totalTests++;
    try {
      // Tree structure: A
      //                  \
      //                   B
      //                  / \
      //                 C   D
      BinaryTree c = new BinaryTree("C");
      BinaryTree d = new BinaryTree("D");
      BinaryTree b = new BinaryTree("B", c, d);
      BinaryTree root = new BinaryTree("A", null, b);
      
      int result = root.countNodesWithOneChild();
      if (result == 1) {
        System.out.println("✅ Test 9 - Root with one child: " + result + " (Expected: 1)");
        testsPassed++;
      } else {
        System.out.println("❌ Test 9 - Root with one child: " + result + " (Expected: 1) - Root A has exactly one child!");
      }
    } catch (Exception e) {
      System.out.println("❌ Test 9 - Root with one child: Exception thrown - " + e.getMessage());
    }
  }
  
  /**
   * Test 10: Complex tree with various one-child scenarios
   * Catches: Complex counting errors and edge cases
   */
  private static void testComplexTree() {
    totalTests++;
    try {
      // Tree structure:         A
      //                      /     \
      //                     B       C
      //                    /         \
      //                   D           E
      //                  / \         /
      //                 F   G       H
      //                    /
      //                   I
      BinaryTree i = new BinaryTree("I");
      BinaryTree f = new BinaryTree("F");
      BinaryTree g = new BinaryTree("G", i, null);  // G has one child (left)
      BinaryTree h = new BinaryTree("H");
      BinaryTree d = new BinaryTree("D", f, g);     // D has two children
      BinaryTree e = new BinaryTree("E", h, null);  // E has one child (left)
      BinaryTree b = new BinaryTree("B", d, null);  // B has one child (left)
      BinaryTree c = new BinaryTree("C", null, e);  // C has one child (right)
      BinaryTree root = new BinaryTree("A", b, c);  // A has two children
      
      int result = root.countNodesWithOneChild();
      if (result == 4) {
        System.out.println("✅ Test 10 - Complex tree: " + result + " (Expected: 4)");
        testsPassed++;
      } else {
        System.out.println("❌ Test 10 - Complex tree: " + result + " (Expected: 4) - B, C, E, and G each have exactly one child!");
      }
    } catch (Exception e) {
      System.out.println("❌ Test 10 - Complex tree: Exception thrown - " + e.getMessage());
    }
  }
}
