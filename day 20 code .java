import java.util.Stack;

public class SortStackRecursion {

    // Function to insert an element in the sorted order
    public static void sortedInsert(Stack<Integer> stack, int element) {
        // Base case: stack is empty or top element <= element
        if (stack.isEmpty() || element >= stack.peek()) {
            stack.push(element);
            return;
        }

        // Otherwise, pop the top and recurse
        int temp = stack.pop();
        sortedInsert(stack, element);

        // Push back the stored element
        stack.push(temp);
    }

    // Function to sort stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Remove the top element
            int temp = stack.pop();

            // Sort remaining stack recursively
            sortStack(stack);

            // Insert the popped element in the correct position
            sortedInsert(stack, temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
