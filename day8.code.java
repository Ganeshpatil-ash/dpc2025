public class ReverseWords {
    public static String reverseWords(String s) {
        // Step 1: Trim leading/trailing spaces
        s = s.trim();

        // Step 2: Split by one or more spaces
        String[] words = s.split("\\s+");

        // Step 3: Reverse words
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) result.append(" ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));      // "blue is sky the"
        System.out.println(reverseWords("  hello world  "));      // "world hello"
        System.out.println(reverseWords("a good   example"));     // "example good a"
        System.out.println(reverseWords("    "));                 // ""
        System.out.println(reverseWords("word"));                 // "word"
    }
}
