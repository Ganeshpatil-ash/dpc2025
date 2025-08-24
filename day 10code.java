import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            // Step 1: Sort the word
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Step 2: Add word to hashmap
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }

        // Step 3: Return grouped anagrams
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);

        System.out.println(result);
    }
}
