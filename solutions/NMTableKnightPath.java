public class NMTableKnightPath {

    public static void main(String[] args) {
        int N = 31;
        int M = 34;

        System.out.println(calculateKnightPaths(N, M));
    }

    /**
     * Time complexity - O(N * M)
     * Space complexity - O(N * M)
     *
     * @param rows - rows number
     * @param cols - columns number
     * @return
     */
    public static long calculateKnightPaths(int rows, int cols) {
        long[][] ways = new long[rows][cols];

        // knight starting position
        ways[0][0] = 1;

        // start going through table
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // 2 down and 1 right
                if (row + 2 < rows && col + 1 < cols) {
                    ways[row + 2][col + 1] += ways[row][col];
                }
                // 1 down and 2 right
                if (row + 1 < rows && col + 2 < cols) {
                    ways[row + 1][col + 2] += ways[row][col];
                }
            }
        }

        return ways[rows - 1][cols - 1];
    }
}
