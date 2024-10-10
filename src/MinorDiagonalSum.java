public class MinorDiagonalSum {
    public static int minorDiagonalSum(int[][] arr) {
        int sum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            sum += arr[i][n - 1 - i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {4, 1, 9, 35},
                {2, 5, 3, 5},
                {4, 10, 11, 12},
                {12, 5, 23, 9}
        };

        System.out.println(minorDiagonalSum(arr));
    }
}
