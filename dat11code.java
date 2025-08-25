import java.util.*;

public class StringPermutations {
    
    // Main function to generate permutations
    public static List<String> permute(String s) {
        Set<String> result = new HashSet<>();  // Use Set to avoid duplicates
        char[] chars = s.toCharArray();
        backtrack(chars, 0, result);

        // Convert Set to List before returning
        return new ArrayList<>(result);
    }

    // Backtracking function
    private static void backtrack(char[] chars, int index, Set<String> result) {
        if (index == chars.length) {
            result.add(new String(chars)); // Add permutation
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);                  // Swap
            backtrack(chars, index + 1, result);    // Recurse
            swap(chars, index, i);                  // Backtrack (undo swap)
        }
    }

    // Swap helper
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    // Driver code
    public static void main(String[] args) {
        String s = "abc";
        List<String> permutations = permute(s);

        System.out.println("Permutations of " + s + ":");
        System.out.println(permutations);
    }
}
