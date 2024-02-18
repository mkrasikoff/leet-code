import java.util.*;

public class ArrayGroupAnagrams {

    public static void main(String[] args) {
        String[] strings = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(groupAnagrams(strings));
    }

    /**
     * Time Complexity - O(n * k * logk) n - number of strings, k - maximum string length
     * Sorting takes O(k * logk) n times
     *
     * Space Complexity - O(n*k)
     *
     * @param strings - an array of anagram or random strings
     * @return the anagrams grouped together
     */
    public static List<List<String>> groupAnagrams(String[] strings) {
        // HashMap to keep track of sorted string and its anagrams
        Map<String, List<String>> map = new HashMap<>();

        // Iterate over each string in the input array
        for (String s : strings) {
            // Convert the string to a character array and sort it
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            // Use the sorted string as a key for the map
            String sorted = new String(chars);

            // If the sorted string is not already a key in the map, add it
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            // Add the original string to the list corresponding to the sorted key
            map.get(sorted).add(s);
        }

        // Return the values of the hashmap as a list of lists
        return new ArrayList<>(map.values());
    }
}
