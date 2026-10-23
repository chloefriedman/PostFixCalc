import java.util.Scanner;

/** STUDENT FILE: Complete evaluate. Leave all other project files unchanged. */
public class PostfixEvaluator {
    /**
     * Evaluates a space-separated postfix expression using integer arithmetic.
     * Supported operators: +, -, *, / (integer division).
     *
     * @throws PostFixException for blank, malformed, or invalid expressions
     * @throws ArithmeticException for division by zero
     */
    public static int evaluate(String expression) {
        BoundedStackInterface<Integer> stack = new ArrayStack<>(100);
        Scanner tokens = new Scanner(expression);
        String a = tokens.next();
        String[] items = a.split(" ");
        if(items[0].equals("/") || items[0].equals("*") || items[0].equals("+") || items[0].equals("-"))
        {
            throw new PostFixException("Malformed equation");
        }
        else if(items[1].equals("/") || items[1].equals("*") || items[1].equals("+") || items[1].equals("-"))
        {
            throw new PostFixException("Malformed equation");
         }
         if(items.length < 3)
         {
            throw new PostFixException("Malformed equation");
         }
        for(int i = 0; i < items.length; i++)
        {
            String current = items[i];
            if(!(current.equals("/") || current.equals("*") || current.equals("+") || current.equals("-")))
            {
                int num = Integer.parseInt(current);
                stack.push(num);
            }
            else
            {
               try
               {
                   int num2 = stack.top();
                   stack.pop();
                   int num1 = stack.top();
                   stack.pop();
                   if(current.equals("+"))
                   {
                        stack.push(num1+num2);
                   }
                   else if(current.equals("-"))
                   {
                        stack.push(num1 - num2);
                   }
                   else if(current.equals("*"))
                   {
                        
                   }
               }
               catch(StackUnderflowException e)
               {

               }
            }
          
        }

        // TODO 1: Process tokens one at a time.
        // TODO 2: If a token is an integer, push it onto the stack.
        // TODO 3: If it is +, -, *, or /, pop two operands.
        //         IMPORTANT: the first popped number is the RIGHT operand.
        // TODO 4: Calculate and push the result.
        // TODO 5: Reject unknown tokens and expressions with too few operands.
        // TODO 6: After processing, require EXACTLY one result on the stack.
        //         Catch stack underflow/overflow or check before operations.
        // Close the Scanner when you are finished.

        tokens.close();
        throw new UnsupportedOperationException("TODO: implement postfix evaluation");
    }
}
