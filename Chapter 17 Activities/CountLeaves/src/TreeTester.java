public class TreeTester
{
    public static void main(String[] args)
    {
        System.out.println("=== Testing leafCount method ===\n");
        
        // Test 1: Empty tree (edge case)
        System.out.println("Test 1: Empty tree");
        Tree emptyTree = new Tree();
        System.out.println("Leaf count: " + emptyTree.leafCount());
        System.out.println("Expected: 0");
        System.out.println("Passed: " + (emptyTree.leafCount() == 0) + "\n");
        
        // Test 2: Single node tree (edge case)
        System.out.println("Test 2: Single node tree");
        Tree singleNode = new Tree("Root");
        System.out.println("Leaf count: " + singleNode.leafCount());
        System.out.println("Expected: 1");
        System.out.println("Passed: " + (singleNode.leafCount() == 1) + "\n");
        
        // Test 3: Tree with only root and direct children (all children are leaves)
        System.out.println("Test 3: Root with multiple children (all leaves)");
        Tree t3 = new Tree("Root");
        t3.addSubtree(new Tree("Child1"));
        t3.addSubtree(new Tree("Child2"));
        t3.addSubtree(new Tree("Child3"));
        System.out.println("Leaf count: " + t3.leafCount());
        System.out.println("Expected: 3");
        System.out.println("Passed: " + (t3.leafCount() == 3) + "\n");
        
        // Test 4: Original test case (mixed structure)
        System.out.println("Test 4: Original test case");
        Tree t1 = new Tree("Anne");
        Tree t2 = new Tree("Peter");
        t1.addSubtree(t2);
        Tree t3_orig = new Tree("Zara");
        t1.addSubtree(t3_orig);
        Tree t4 = new Tree("Savannah");
        t2.addSubtree(t4);
        System.out.println("Size: " + t1.size());
        System.out.println("Expected: 4");
        System.out.println("Leaf count: " + t1.leafCount());
        System.out.println("Expected: 2");
        System.out.println("Passed: " + (t1.leafCount() == 2) + "\n");
        
        // Test 5: Linear tree (chain structure)
        System.out.println("Test 5: Linear tree (chain)");
        Tree chain = new Tree("Root");
        Tree current = chain;
        for (int i = 1; i <= 4; i++) {
            Tree next = new Tree("Node" + i);
            current.addSubtree(next);
            current = next;
        }
        System.out.println("Leaf count: " + chain.leafCount());
        System.out.println("Expected: 1");
        System.out.println("Passed: " + (chain.leafCount() == 1) + "\n");
        
        // Test 6: Deeper tree with multiple levels
        System.out.println("Test 6: Deeper tree structure");
        Tree deep = new Tree("Root");
        Tree level1_1 = new Tree("L1-1");
        Tree level1_2 = new Tree("L1-2");
        deep.addSubtree(level1_1);
        deep.addSubtree(level1_2);
        
        // Add children to level1_1
        level1_1.addSubtree(new Tree("L2-1"));
        level1_1.addSubtree(new Tree("L2-2"));
        
        // Add children to level1_2  
        Tree level2_3 = new Tree("L2-3");
        level1_2.addSubtree(level2_3);
        level2_3.addSubtree(new Tree("L3-1"));
        level2_3.addSubtree(new Tree("L3-2"));
        
        System.out.println("Leaf count: " + deep.leafCount());
        System.out.println("Expected: 4 (L2-1, L2-2, L3-1, L3-2)");
        System.out.println("Passed: " + (deep.leafCount() == 4) + "\n");
        
        // Test 7: Tree with one child having many children
        System.out.println("Test 7: Unbalanced tree");
        Tree unbalanced = new Tree("Root");
        Tree branch = new Tree("Branch");
        unbalanced.addSubtree(branch);
        unbalanced.addSubtree(new Tree("Leaf1"));
        
        // Add many children to branch
        for (int i = 1; i <= 5; i++) {
            branch.addSubtree(new Tree("BranchLeaf" + i));
        }
        
        System.out.println("Leaf count: " + unbalanced.leafCount());
        System.out.println("Expected: 6 (1 direct leaf + 5 branch leaves)");
        System.out.println("Passed: " + (unbalanced.leafCount() == 6) + "\n");
        
        // Test 8: Complex tree to catch off-by-one errors
        System.out.println("Test 8: Complex tree structure");
        Tree complex = new Tree("Root");
        Tree a = new Tree("A");
        Tree b = new Tree("B"); 
        Tree c = new Tree("C");
        complex.addSubtree(a);
        complex.addSubtree(b);
        complex.addSubtree(c);
        
        a.addSubtree(new Tree("A1"));
        a.addSubtree(new Tree("A2"));
        
        Tree b1 = new Tree("B1");
        b.addSubtree(b1);
        b1.addSubtree(new Tree("B1-1"));
        
        // C has no children, so it's a leaf
        
        System.out.println("Leaf count: " + complex.leafCount());
        System.out.println("Expected: 4 (A1, A2, B1-1, C)");
        System.out.println("Passed: " + (complex.leafCount() == 4) + "\n");
        
        System.out.println("=== All tests completed ===");
    }
}
