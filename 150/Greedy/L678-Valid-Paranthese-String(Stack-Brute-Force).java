import java.util.Stack;
class Solution {
    public boolean checkValidString(String s) {
        Stack<Character> stack=new Stack<>();
        return check(s,0,stack);
    }

    public boolean check(String s,int i,Stack<Character> stack) {
        if(stack.isEmpty()&&i==s.length())
            return true;

        if(i==s.length())
            return false;

        boolean flag=false;

        if(s.charAt(i)=='(') {
            stack.push('(');
            flag=check(s,i+1,stack);
            stack.pop();
        }

        if(s.charAt(i)==')') {
            if(stack.isEmpty())
                return false;

            stack.pop();
            flag=check(s,i+1,stack);
            stack.push('(');
        }

        if(s.charAt(i)=='*') {
            stack.push('(');
            flag=flag||check(s,i+1,stack);
            stack.pop();

            if(!stack.isEmpty()) {
                stack.pop();
                flag=flag||check(s,i+1,stack);
                stack.push('(');
            }

            flag=flag||check(s,i+1,stack);
        }

        return flag;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        String str="(*)";
        boolean result=s.checkValidString(str);
        System.out.println(result);
    }
}