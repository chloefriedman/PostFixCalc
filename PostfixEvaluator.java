import java.nio.charset.MalformedInputException;
import java.util.Scanner;
import java.util.Stack;

/** STUDENT FILE: Complete evaluate. Leave all other project files unchanged. */
public class PostfixEvaluator {
    /**
     * Evaluates a space-separated postfix expression using integer arithmetic.
     * Supported operators: +, -, *, / (integer division).
     *
     * @throws PostFixException for blank, malformed, or invalid expressions
     * @throws ArithmeticException for division by zero
     */
    @SuppressWarnings("resource")
    public static int evaluate(String expression) {
        if(expression == null || expression.trim().isEmpty())
        {
            throw new PostFixException("Malformed Equation");
        }
        BoundedStackInterface<Integer> stack = new ArrayStack<>(100);
        Scanner tokens = new Scanner(expression);

        String a = tokens.nextLine();
        String[] items = a.split("\\s+");
        tokens.close();
        if(items.length < 3)
         {
            throw new PostFixException("Malformed equation");
         }
        if(items[0].equals("/") || items[0].equals("*") || items[0].equals("+") || items[0].equals("-"))
        {
            throw new PostFixException("Malformed equation");
        }
        if(items[1].equals("/") || items[1].equals("*") || items[1].equals("+") || items[1].equals("-"))
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
                        stack.push(num1 * num2);
                   }
                   else if(current.equals("/"))
                   {
                        if(num2 == 0)
                        {
                            throw new ArithmeticException("Can't divide by 0");
                        }
                        else
                        {
                            stack.push(num1/num2);
                        }
                   }

               }
               catch(PostFixException e)
               {
                    throw new PostFixException("Malformed equation");
               }
            }
          
        }
        if(stack.isEmpty())
        {
            throw new PostFixException("Malformed equations");
        }
      
        int answer = stack.top();
        stack.pop();
        if(!(stack.isEmpty()))
        {
            throw new PostFixException("Malformed equations");
        }
        return answer;


    }
}
