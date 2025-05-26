import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.lang.Math;

// Imports not needed when submitting challenges
class Solution {

    public static int findUnion(HashMap<Integer, Integer> mp, int currentNumber) {
        int ans=0;
        if (mp.containsKey(currentNumber - 1) && mp.get(currentNumber - 1) < currentNumber) {
            int start = mp.get(currentNumber - 1);  // finding index / starting of currentNumber-1 node
            mp.put(start, currentNumber);   
            mp.put(currentNumber, start);
            int l = Math.abs(currentNumber - start)+1;
            if(start!=currentNumber-1)   // if the previous node is not root node remove it
                mp.remove(currentNumber - 1);
            ans = ans > l ? ans : l;
        }

        if (mp.containsKey(currentNumber + 1) && mp.get(currentNumber + 1) > currentNumber) {
            
            boolean removeCurrent = false;
            int end = mp.get(currentNumber + 1);
            int start = mp.getOrDefault(currentNumber, currentNumber);
            if (mp.containsKey(currentNumber))
                removeCurrent = true;
            mp.put(end, start);
            mp.put(start, end);
            if (removeCurrent)
                mp.remove(currentNumber);
            if(end!=currentNumber+1) mp.remove(currentNumber+1);  // if end node is not leaf node remove it
            int l = Math.abs(end - start)+1;
            ans = ans > l ? ans : l;
        }
        return ans;
       
    }


    //My Attempt -> Not good
    public int longestConsecutive(int[] nums) {
        int result=nums.length!=0 ? 1:0;

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(nums[i])) continue; // leaf node in graph
            else if (mp.containsKey(nums[i] + 1) || mp.containsKey(nums[i] - 1)) {
                result=Math.max(findUnion(mp, nums[i]),result);
            } else {
                mp.put(nums[i], nums[i]);  // node with starting and ending pointing to itself
            }
        }

        return result;
    }


    //Leetcode solution
     public int longestConsecutiveLeetcode(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int n : nums) {
                set.add(n);
            }
            int ans = 0;
            for(int n : set) {
                if(!set.contains(n - 1)) {  
                    int m = n + 1;
                    while(set.contains(m)) {
                        m++;
                    }
                    ans = Math.max(ans, m - n);
                }
            }
            return ans;
        }
}