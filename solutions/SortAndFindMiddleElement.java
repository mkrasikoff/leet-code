public class SortAndFindMiddleElement {

    public static void main(String[] args) {
        System.out.println(findMiddleElement(6, 3, 18)); // expect 6
        System.out.println(findMiddleElement(1, 2, 3)); // expect 2
        System.out.println(findMiddleElement(0, 0, 1)); // expect 0

        System.out.println(sortAndFindMiddleElement(6, 3, 18)); // expect 6
        System.out.println(sortAndFindMiddleElement(1, 2, 3)); // expect 2
        System.out.println(sortAndFindMiddleElement(0, 0, 1)); // expect 0
    }

    /**
     * Time complexity - 0(1)
     * Space complexity - 0(1)
     *
     * @param a
     * @param b
     * @param c
     * @return middle element after comparing these numbers
     */
    public static int findMiddleElement(int a, int b, int c) {
        if ((a >= b && a <= c) || (a <= b && a >= c)) {
            return a;
        } else if ((b >= a && b <= c) || (b <= a && b >= c)) {
            return b;
        } else {
            return c;
        }
    }

    /**
     * Time complexity - 0(1)
     * Space complexity - 0(1)
     *
     * @param a
     * @param b
     * @param c
     * @return middle element after sorting and comparing these numbers
     */
    public static int sortAndFindMiddleElement(int a, int b, int c) {
        int temp;
        if (a > b) {
            temp = b;
            b = a;
            a = temp;
        }
        if (b > c) {
            temp = c;
            c = b;
            b = temp;
        }
        if (a > b) {
            temp = b;
            b = a;
            a = temp;
        }

        return b;
    }
}
