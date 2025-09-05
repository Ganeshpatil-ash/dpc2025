import java.util.*;

public class FirstElementToRepeatKTimes {

    public static int firstElementToRepeatKTimes(int[] arr, int k) {
        // HashMap to store frequency of each element
        Map<Integer, Integer> freq = new HashMap<>();

        // First pass: count frequencies
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Second pass: check the first element with frequency = k
        for (int num : arr) {
            if (freq.get(num) == k) {
                return num;
            }
        }

        return -1; // No element found
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1, 4};
        int k = 2;

        int result = firstElementToRepeatKTimes(arr, k);
        System.out.println("Output: " + result);
    }
}
