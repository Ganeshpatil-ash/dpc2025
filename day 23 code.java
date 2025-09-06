import java.util.*;

public class SlidingWindowMaximum {

    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>(); // stores indices

        for (int i = 0; i < nums.length; i++) {
            // Remove elements out of current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements (they are useless)
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // Add current element index
            dq.offerLast(i);

            // Add max to result (when we have at least k elements)
            if (i >= k - 1) {
                result.add(nums[dq.peekFirst()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        List<Integer> output = maxSlidingWindow(arr, k);
        System.out.println("Output: " + output);
    }
}
