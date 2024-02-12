public class NMTableFindMostExpensiveWay {

    public static void main(String[] args) {
        int N = 5;
        int M = 5;

        int[][] table = {
                {9, 9, 9, 9, 9},
                {3, 0, 0, 0, 0},
                {9, 9, 9, 9, 9},
                {6, 6, 6, 6, 8},
                {9, 9, 9, 9, 9}
        };

        printCalculatedMaxPriceWeightAndWay(N, M, table);
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
    public static int printCalculatedMaxPriceWeightAndWay(int N, int M, int[][] table) {

        // Results
        int[][] maxSum = new int[N][M]; // table to store maxSum
        String[][] way = new String[N][M]; // table to store way

        // start values
        maxSum[0][0] = table[0][0];
        way[0][0] = "";

        // fill first row
        for (int j = 1; j < M; j++) {
            maxSum[0][j] = maxSum[0][j - 1] + table[0][j];
            way[0][j] = way[0][j - 1] + "R";
        }

        // fill first column
        for (int i = 1; i < N; i++) {
            maxSum[i][0] = maxSum[i - 1][0] + table[i][0];
            way[i][0] = way[i - 1][0] + "D";
        }

        // fill other table
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (maxSum[i - 1][j] > maxSum[i][j - 1]) {
                    maxSum[i][j] = maxSum[i - 1][j] + table[i][j];
                    way[i][j] = way[i - 1][j] + "D";
                } else {
                    maxSum[i][j] = maxSum[i][j - 1] + table[i][j];
                    way[i][j] = way[i][j - 1] + "R";
                }
            }
        }

        // print result
        System.out.println(maxSum[N - 1][M - 1]);
        System.out.println(way[N - 1][M - 1]);

        return maxSum[N - 1][M - 1];
    }
}
