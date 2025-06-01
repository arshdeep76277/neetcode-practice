// Problem Link - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int start=0,end=numbers.length-1;
        while(start<end){
            int currentSum=numbers[start]+numbers[end];
            if(currentSum<target) start++;
            else if(currentSum>target) end--;
            else break;
        }
        return new int[]{start+1,end+1};
    }
}