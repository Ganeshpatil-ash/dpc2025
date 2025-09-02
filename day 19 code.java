import java.util.*;

public class PostfixEvaluation {
    public static int evaluatePostfix(String expr) {
        Stack<Integer> stack = new Stack<>();
        
        // Split by space (tokens are numbers or operators)
        String[] tokens = expr.split(" ");
        
        for (String token : tokens) {
            // If token is a number -> push to stack
            if (token.matches("-?\\d+")) {  // supports negative numbers too
                stack.push(Integer.parseInt(token));
            } else {
                // It's an operator -> pop two operands
                int b = stack.pop();
                int a = stack.pop();
                
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b); // integer division
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }
        return stack.pop(); // Final result
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter postfix expression: ");
        String expr = sc.nextLine();
        
        int result = evaluatePostfix(expr);
        System.out.println("Result: " + result);
    }
}
