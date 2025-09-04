import java.util.Stack;

public class ReverseStack {

    // Function to insert element at the bottom of the stack
    static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        // Remove top element
        int top = stack.pop();
        // Recursive call
        insertAtBottom(stack, element);
        // Push back the top element
        stack.push(top);
    }

    // Function to reverse the stack using recursion
    static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        // Remove top element
        int top = stack.pop();
        // Recursive call to reverse remaining stack
        reverse(stack);
        // Insert the popped element at the bottom
        insertAtBottom(stack, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);
        
        reverse(stack);

        System.out.println("Reversed Stack: " + stack);
    }
}
