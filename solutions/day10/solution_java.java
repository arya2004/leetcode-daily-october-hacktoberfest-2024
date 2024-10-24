class Solution {
    public int maxWidthRamp(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        for (int i = n - 1; i >= 0; i --) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                ans = Math.max(ans, i - stack.pop());
            }
        }
        return ans;
    }
}