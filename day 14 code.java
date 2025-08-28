import java.util.*;

public class CountKDistinctSubstrings {

    // Function to count substrings with at most K distinct characters
    public static int atMostKDistinct(String s, int k) {
        int n = s.length();
        int left = 0, count = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // Shrink window if more than k distinct chars
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }
            // Count substrings ending at right
            count += (right - left + 1);
        }
        return count;
    }

    // Function to count substrings with exactly K distinct characters
    public static int exactlyKDistinct(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    public static void main(String[] args) {
        String s = "pqpqs";
        int k = 2;

        int result = exactlyKDistinct(s, k);
        System.out.println("Number of substrings with exactly " + k + " distinct characters: " + result);
    }
}
