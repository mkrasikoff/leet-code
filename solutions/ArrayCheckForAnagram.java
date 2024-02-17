import java.util.HashMap;
import java.util.Map;

public class ArrayCheckForAnagram {

    public static void main(String[] args) {

        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("anagram", "bagaram"));
    }

    /**
     * Method to check are two strings anagram or not
     *
     * Time Complexity - O(n)
     * Space Complexity - O(n) or O(1) if we think about only 26 possible symbols from English
     *
     * @param first
     * @param second
     * @return
     */
    public static boolean isAnagram(String first, String second) {
        if (first.length() != second.length()) {
            return false; // Anagrams must be the same length
        }

        Map<Character, Integer> countMap = new HashMap<>();

        // Count characters in the first string
        for (char c : first.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // Subtract the count for characters in the second string
        for (char c : second.toCharArray()) {
            if (!countMap.containsKey(c) || countMap.get(c) == 0) {
                return false; // Character count does not match
            }
            countMap.put(c, countMap.get(c) - 1);
        }

        // If all counts are zero, then it is an anagram
        for (int count : countMap.values()) {
            if (count != 0) {
                return false; // Character count does not match
            }
        }

        return true; // All character counts match
    }
}
