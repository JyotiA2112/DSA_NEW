package code.Stack;


import java.util.Stack;

class StringSubSequence {
    public boolean isSubsequence(String s, String t) {
        Stack<Character> stack = new Stack<>();

        for(int i=s.length()-1; i>=0; i--){
            stack.push(s.charAt(i));
        }

        // while(!stack.isEmpty()){
        //     System.out.println(stack.pop());
        // }


        for(int i=0; i<t.length(); i--){
            if(!stack.isEmpty() && t.charAt(i) == stack.peek()){
                System.out.println(stack.pop());
            }
            else{
                if(stack.isEmpty()){
                    return true;
                }
            }



        }

        return false;
    }

    public static void main(String[] args) {
        StringSubSequence str = new StringSubSequence();
        str.isSubsequence("abc","ahbgdc");
    }
}
