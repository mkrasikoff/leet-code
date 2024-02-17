import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class ArrayFindIndexesToCreateRequiredSum {

    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};

        System.out.println(Arrays.toString(findIndexesToCreateRequiredSum(nums, 18)));
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] findIndexesToCreateRequiredSum(int[] nums, int target) {
        // Create a HashMap to store numbers and their indices
        Map<Integer, Integer> numIndices = new HashMap<>();

        // Iterate through the array of numbers
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement of the current number
            int complement = target - nums[i];

            // Check if the complement is already in the HashMap
            if (numIndices.containsKey(complement)) {
                // If it is, return the indices of the two numbers that add up to the target
                return new int[] { numIndices.get(complement), i };
            }

            // If the complement is not in the HashMap, add the current number and its index
            numIndices.put(nums[i], i);
        }

        // If no solution is found, throw an exception
        throw new IllegalArgumentException("No two sum solution");
    }
}
