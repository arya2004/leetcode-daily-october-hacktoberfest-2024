class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> mp = new HashMap<>();

        int res = -1;

        for(int i = 0; i< nums.length;i++){
            int temp = (int) Math.sqrt(nums[i]);

            if(temp * temp == nums[i] && mp.containsKey(temp)){
                mp.put(nums[i], mp.get(temp) + 1);
                res = Math.max(res, mp.get(nums[i]));
            } else {
                mp.put(nums[i], 1);
            }
        }

        return res;
    }
}
