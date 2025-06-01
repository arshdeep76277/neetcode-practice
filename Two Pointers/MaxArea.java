// Problem Link - https://leetcode.com/problems/container-with-most-water/description/

class Solution {
    public int maxArea(int[] height) {
        int ans=0;
        int start=0;
        int end=height.length-1;
        while(start<end){
            ans=Math.max(Math.min(height[start],height[end])*(end-start), ans);
            if(height[start] < height[end]){
                start++;
            }
            else end--;
        }
        return ans;

    }
}