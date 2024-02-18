import java.util.*;

public class ArrayTopKFrequentElements {

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 2, 3};

        System.out.println(topKFrequent(array, 2));
    }

    /**
     * Time Complexity - O(n * logk) where logk - insertion to min heap
     * Space Complexity - O(n + k)
     *
     * @param nums
     * @param k
     * @return k most frequent elements from nums array
     */
    public static int[] topKFrequent(int[] nums, int k) {
        // Build hash map: element and how often it appears
        Map<Integer, Integer> count = new HashMap<>();

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // Create a min heap to keep the least frequent elements on top
        PriorityQueue<Integer> heap =
                new PriorityQueue<>(Comparator.comparingInt(count::get));

        // Keep k top frequent elements in the heap
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll(); // Remove the least frequent element
            }
        }

        // Convert heap to array
        int[] top = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll(); // Extract the elements from the heap
        }
        return top; // Return the top k frequent elements
    }
}
