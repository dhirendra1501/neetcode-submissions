class Solution {
    public int maxProduct(int[] nums) {
        int n= nums.length;
        int prefix=1;
        int sufix=1;
        int maxP=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prefix==0) prefix=1;
            if(sufix==0) sufix=1;
            prefix *= nums[i];
            sufix *= nums[n-i-1];
            maxP= Math.max(maxP,Math.max(prefix,sufix));
        }
        return maxP;
    }
}
