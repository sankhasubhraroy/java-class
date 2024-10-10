public class MajorDiagonalSum {
    public static int majorDiagonalSum(int[][] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {4, 1, 9, 36},
                {2, 5, 3, 5},
                {4, 10, 11, 12},
                {12, 5, 23, 9}
        };

        System.out.println(majorDiagonalSum(arr));
    }
}
