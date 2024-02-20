import java.util.Arrays;

public class ArrayProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8};

        System.out.println(Arrays.toString(productExceptSelf(array)));
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] contains the product of all the elements to the left of i
        // For the element at index '0', there are no elements to the left, so answer[0] would be 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            // answer[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] gives the product of all elements to the left of index 'i'
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R represents the product of all the elements to the right
        // For the element at index 'length - 1', there are no elements to the right, so the R would be 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // For the index 'i', R would contain the
            // product of all elements to the right. We update R accordingly
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
    }
}
