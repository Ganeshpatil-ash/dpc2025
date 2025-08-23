import java.util.*;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Step 1: Sort the array
        Arrays.sort(strs);

        // Step 2: Compare first and last string
        String first = strs[0];
        String last = strs[strs.length - 1];
        int i = 0, n = Math.min(first.length(), last.length());

        while (i < n && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        // Step 3: Return prefix
        return first.substring(0, i);
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs));
    }
}
