// Problem Link - https://leetcode.com/problems/3sum/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans= new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length;){
            int start=i+1;
            int end=nums.length-1;
            while(start<end){
                int currentSum=nums[i]+nums[start]+nums[end];
                if(currentSum<0) start++;
                else if(currentSum>0) end--;
                else{
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end])));
                    do{
                        start++;
                    }
                    while(start<end && nums[start]==nums[start-1]);

                    do{
                        end--;
                    }
                    while(start<end && nums[end]==nums[end+1]);
                }
            }

            do{
                i++;
            }
            while(i<nums.length && nums[i]==nums[i-1]);
        }
        return ans;
    }
}