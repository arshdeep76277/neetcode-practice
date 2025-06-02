//https://leetcode.com/problems/generate-parentheses/

class Solution {

    private static void generate(List<String> ans,int st,int currentItem,int n,String currentString){
        
        // if string size is 2*n then evaluate
        if(currentItem>n*2){
            if(st==0) ans.add(currentString);
            return;
        }
        // stack size less than total n
        if(st<n) generate(ans,st+1,currentItem+1,n,currentString+'(');
        if(st>0) generate(ans,st-1,currentItem+1,n,currentString+')');
        return;
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        generate(ans,0,1,n,"");

        return ans;
    }
}