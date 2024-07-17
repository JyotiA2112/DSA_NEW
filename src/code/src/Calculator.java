import java.util.Stack;

public class Calculator {

    public int calculate(String s) {
        Stack<Character> stack = new Stack<Character>();
        int result = 0;

        for(int i=0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == '*' || c == '/')
            {
                int first = stack.pop();
                int other = s.charAt(i+1);
                if(c == '*')
                {
                   stack.add((char) (first*other));
                }
                else
                {
                    stack.add((char) (first/other));

                }

            }
            else
            {
                stack.add(c);

            }

        }

        while(!stack.isEmpty())
        {
            int first = stack.pop();
            char operand = stack.pop();
            int last = stack.pop();


        }

        return 0;
    }
}