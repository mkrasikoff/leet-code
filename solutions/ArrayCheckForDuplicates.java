import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayCheckForDuplicates {

    public static void main(String[] args) {
        int nums[] = {1, 5, 9, 7, 4, 6, 2, 3, 3};

        System.out.println(containsDuplicateWithHashSet(nums));
        System.out.println(containsDuplicateWithSorting(nums));
    }

    /** HashSet effective solution
     *
     * Time Complexity - O(n)
     * Space Complexity - 0(n)
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicateWithHashSet(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // Duplicate found
            }
            seen.add(num);
        }
        return false; // No duplicates
    }

    /** Array sorting solution
     *
     * Time Complexity - O(n logn)
     * Space Complexity - O(1) because we used existing array, if we create new - 0(n)
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicateWithSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true; // Duplicate found
            }
        }
        return false; // No duplicates
    }
}
