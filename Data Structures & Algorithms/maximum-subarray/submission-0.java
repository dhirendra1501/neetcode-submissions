class Solution {
    public int maxSubArray(int[] nums) {
        int maxiSum=nums[0];
        int sum=0;
        for(int num:nums){
            sum+=num;
            if(sum>maxiSum){
                maxiSum=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return maxiSum;
    }
}
