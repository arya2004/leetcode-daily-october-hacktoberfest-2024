class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];

        for(int j = 0; j< n; j++){
               lis[j] = 1;
               lds[j] = 1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j< i; j++){
                if(nums[j] < nums[i]){
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
        }

        for(int i = n - 1; i >= 0; i--){
            for(int j = i + 1; j< n; j++){
                if(nums[j] < nums[i]){
                    lds[i] = Math.max(lds[i], 1 + lds[j]);
                }
            }
        }

        int res = n;

        for(int i = 1;i < n - 1; i++ ){
            if(Math.min(lis[i], lds[i]) > 1){
                res = Math.min(res, n - lis[i] - lds[i] + 1);
            }
        }



        return res;

    }
}
