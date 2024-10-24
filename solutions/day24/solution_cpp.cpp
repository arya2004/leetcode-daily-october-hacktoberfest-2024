#include <iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
};

/*
You are given the roots of two binary trees root1 and root2.
We define a flip operation as choosing any node and swapping the left and right child subtrees.

A binary tree X is flip equivalent to a binary tree Y if and only if
we can make X equal to Y after performing some number of flip operations.

Return true if the two trees are flip equivalent, or false otherwise.

Example 1:
Input: root1 = [1,2,3,4,5,6,null,null,null,7,8]
       root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
Output: true
Explanation: We flipped at nodes with values 1, 3, and 5.

Example 2:
Input: root1 = [], root2 = []
Output: true

Example 3:
Input: root1 = [], root2 = [1]
Output: false

Constraints:
- The number of nodes in each tree is in the range [0, 100].
- Each tree will have unique node values in the range [0, 99].
*/

class Solution {
public:
    bool flipEquiv(TreeNode* root1, TreeNode* root2) {
        // if both are null then the trees are equal
        if (!root1 && !root2) {
            return true;
        }
        
        // if only one is null then the trees are not equal
        if (!root1 || !root2) {
            return false;
        }
        
        // if the values are not equal then the trees are not equal
        if (root1->val != root2->val) {
            return false;
        }
        
        // case 1: check if the left and right subtrees are equal
        bool isSame = (flipEquiv(root1->left, root2->left) && flipEquiv(root1->right, root2->right));

        // case 2: check if the left and right subtrees are equal when flipped
        bool isFlip = (flipEquiv(root1->left, root2->right) && flipEquiv(root1->right, root2->left));

        // check if trees are equal in at least one case
        return isSame || isFlip;
    }
};
