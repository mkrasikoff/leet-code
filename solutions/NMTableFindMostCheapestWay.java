public class NMTableFindMostCheapestWay {

    public static void main(String[] args) {
        // table size
        int N = 5;
        int M = 5;

        // N * M table with food
        int[][] table = {
                {1, 1, 1, 1, 1},
                {3, 100, 100, 100, 100},
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 1},
                {1, 1, 1, 1, 1}
        };

        System.out.println(calculateMinFoodWeight(N, M, table));
    }

    /**
     * Time complexity - O(N * M)
     * Space complexity - O(N * M)
     *
     * @param N - rows number
     * @param M - columns number
     * @param table - table with numbers and N * M size
     * @return
     */
    public static int calculateMinFoodWeight(int N, int M, int[][] table) {
        int[][] minFoodWeightTable = new int[N][M];

        minFoodWeightTable[0][0] = table[0][0];

        // init first row
        for (int i = 1; i < M; i++) {
            minFoodWeightTable[0][i] = minFoodWeightTable[0][i - 1] + table[0][i];
        }

        // init first column
        for (int i = 1; i < N; i++) {
            minFoodWeightTable[i][0] = minFoodWeightTable[i - 1][0] + table[i][0];
        }

        // make min food way
        for (int row = 1; row < N; row++) {
            for (int col = 1; col < M; col++) {
                int minFoodFromTop = minFoodWeightTable[row - 1][col];
                int minFoodFromLeft = minFoodWeightTable[row][col - 1];

                minFoodWeightTable[row][col] = Math.min(minFoodFromTop, minFoodFromLeft) + table[row][col];
            }
        }

        return minFoodWeightTable[N - 1][M - 1];
    }
}
