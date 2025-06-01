// Problem Link - https://leetcode.com/problems/trapping-rain-water/

class Solution {
    public int trap(int[] height) {
        int l=0; int lmax=0;
        int r=height.length-1; int rmax=0;
        int currentStore=0;
        int ans=0;
        while(l<=r){
            if(lmax<=rmax){
                currentStore=Math.max(lmax,height[l])-height[l];
                lmax=Math.max(lmax,height[l]);
                l++;
            }else{
                currentStore=Math.max(rmax,height[r])-height[r];
                rmax=Math.max(rmax,height[r]);
                r--;
            }

            if(currentStore>0) ans+=currentStore;
        }
        return ans;

    }
}