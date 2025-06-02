// Problem Link - https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

class Solution {

    private static int performOperation(int a,int b,char op){
        int res=0;
        switch (op){
            case '+':
                res=b+a; break;
            case '-':
                res=b-a; break;
            case '*':
                res=b*a; break;
            case '/':
                res=b/a; break;
        }
        return res;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].length()>1 || Character.isDigit(tokens[i].charAt(0) )) {
                st.push(Integer.parseInt(tokens[i]));
            }
            else{
                int first=st.pop();
                int second=st.pop();
                st.push(performOperation(first,second,tokens[i].charAt(0) ));

            }
        }
        return st.pop();
    }
}