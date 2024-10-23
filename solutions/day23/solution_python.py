#Cousins in Binary Tree II
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def replaceValueInTree(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: Optional[TreeNode]
        """
        if not root:
            return root
        
        self.dfs([root])
        root.val = 0
        return root

    def dfs(self, arr):
        if not arr:
            return
        
        total_sum = 0
        for node in arr:
            if node is None:
                continue
            if node.left is not None:
                total_sum += node.left.val
            if node.right is not None:
                total_sum += node.right.val

        child_arr = []
        
        for node in arr:
            cur_sum = 0
            if node.left is not None:
                cur_sum += node.left.val
            if node.right is not None:
                cur_sum += node.right.val
            
            if node.left is not None:
                node.left.val = total_sum - cur_sum
                child_arr.append(node.left)
            if node.right is not None:
                node.right.val = total_sum - cur_sum
                child_arr.append(node.right)

        self.dfs(child_arr)
