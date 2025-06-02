
// Problem Link - https://leetcode.com/problems/valid-parentheses/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        boolean result=true;
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(c=='(' || c=='{' || c=='[') st.push(c);
            else if(c==')' && !st.isEmpty() && st.peek()=='(') st.pop();
            else if(c=='}' && !st.isEmpty() && st.peek()=='{') st.pop();
            else if(c==']' && !st.isEmpty() && st.peek()=='[') st.pop();
            else{
                result=false;
                break;
            }
        }
        return st.isEmpty() && result;
    }
}