/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class solution_java {
    int max;
    public int[] treeQueries(TreeNode root, int[] queries)
     {
        int left[]=new int[100001];
        int right[]=new int[100001];
        max=0;
        leftquery(root,left,0);
        max=0;
        rightquery(root,right,0);
        for(int i=0;i<queries.length;i++)
        {
            queries[i]=Math.max(left[queries[i]],right[queries[i]]);
        }

        return queries;

    }
    private void leftquery(TreeNode root,int left[],int d)
    {
        if(root==null) return;
        left[root.val]=max;
        max=Math.max(max,d);
        leftquery(root.left,left,d+1);
        leftquery(root.right,left,d+1);
    }
    private void rightquery(TreeNode root,int right[],int d)
    {
        if(root==null) return;
        right[root.val]=max;
        max=Math.max(max,d);
        rightquery(root.right,right,d+1);
        rightquery(root.left,right,d+1);
    }
}