import java.sql.SQLOutput;

public class Expand2DArray {
    public static int[][] expand(int[][] arr) {
        // We have to get the original array dimensions
        int rows = arr.length;
        int cols = arr[0].length;

        // Creating a new array with expanded size
        int[][] expandedArr = new int[rows * 2][cols * 2];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value = arr[i][j];

                // Expanding each value into 4 cell
                expandedArr[i * 2][j * 2] = value;
                expandedArr[i * 2][j * 2 + 1] = value;
                expandedArr[i * 2 + 1][j * 2] = value;
                expandedArr[i * 2 + 1][j * 2 + 1] = value;
            }
        }

        return expandedArr;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {4, 5, 6, 7}, {8, 9, 10, 11}};
        int[][] expandedArr = expand(arr);

        for (int i = 0; i < expandedArr.length; i++) {
            int[] row = expandedArr[i];
            for (int j = 0; j < row.length; j++) {
                int val = row[j];
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
