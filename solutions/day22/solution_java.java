import java.util.*;

/**
 * LeetCode 2583 - Kth Largest Sum in a Binary Tree
 *
 * Time Complexity: O(n log k) where n is number of nodes
 * Space Complexity: O(m) where m is number of levels
 *
 * Approach:
 * - Use BFS to traverse level by level
 * - Calculate sum for each level
 * - Use min heap to find kth largest level sum
 */

// Definition for a binary tree node (provided by LeetCode)
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;

        // Min heap to store top k largest sums
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        // BFS queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long levelSum = 0;

            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                // Add children to queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Add level sum to min heap
            minHeap.offer(levelSum);

            // Maintain only k largest elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // If fewer than k levels, return -1
        if (minHeap.size() < k) {
            return -1;
        }

        // The smallest in min heap of size k is the kth largest
        return minHeap.peek();
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Example from LeetCode
        // Tree: [5,8,9,2,1,3,7,4,6]
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(9);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(1);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(7);
        root1.left.left.left = new TreeNode(4);
        root1.left.left.right = new TreeNode(6);

        System.out.println("Test 1 - k=2: " + solution.kthLargestLevelSum(root1, 2)); // Expected: 13

        // Test case 2: Simple tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        System.out.println("Test 2 - k=1: " + solution.kthLargestLevelSum(root2, 1)); // Expected: 5
        System.out.println("Test 2 - k=3: " + solution.kthLargestLevelSum(root2, 3)); // Expected: -1 (only 2 levels)

        // Test case 3: Single node
        TreeNode root3 = new TreeNode(10);
        System.out.println("Test 3 - k=1: " + solution.kthLargestLevelSum(root3, 1)); // Expected: 10
        System.out.println("Test 3 - k=2: " + solution.kthLargestLevelSum(root3, 2)); // Expected: -1
    }
}