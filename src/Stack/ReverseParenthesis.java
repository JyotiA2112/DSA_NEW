package Stack;


import java.util.Stack;

class ReverseParenthesis {
    public static String reverseParentheses(String s) {

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == ')')
            {
                String dummy = "";
                char popped = stack.pop();
                while(popped != '(')
                {
                    dummy = dummy+String.valueOf(popped);
                    popped = stack.pop();
                    if(stack.isEmpty())
                    {
                        return dummy;
                    }
                }
                System.out.println(dummy+". dummy");
                for(char chDummy : dummy.toCharArray())
                {
                    stack.push(chDummy);
                }
            }
            else{
                stack.push(ch);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String res = reverseParentheses("(ed(et(oc))el)");
    }
}
