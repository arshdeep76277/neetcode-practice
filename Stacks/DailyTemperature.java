https://leetcode.com/problems/daily-temperatures/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair<Integer,Integer>> st=new Stack<Pair<Integer,Integer>>();
        int sz=temperatures.length;
        int[] ans=new int[sz];

        for(int i=sz-1;i>=0;i--){
            while(!st.isEmpty() && st.peek().getKey() <= temperatures[i]){
                st.pop();
            }
            if(!st.isEmpty()) ans[i]=st.peek().getValue()-i;
            else ans[i]=0;
            st.push(new Pair<Integer,Integer>(temperatures[i],i));
        }
        return ans;
    }
}