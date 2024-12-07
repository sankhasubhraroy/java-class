import java.lang.reflect.Array;
import java.util.Arrays;

public class Class_24_11_2024 {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] addResult = add(a, b);

        System.out.println("The addition of two matrices are: ");
        printMatrices(addResult);

        int[][] c = {{1, 2, 3}, {4, 5, 6}};
        int[][] d = {{7, 8}, {9, 10}, {11, 12}};
        int[][] multResult = mult(c, d);

        System.out.println("The multiplication of two matrices are: ");
        printMatrices(multResult);

        int[] arr = {3, 2, 5, 6, 1, 4};

        System.out.println("The result of first bubble sort is: ");
        printArray(singleBubble(arr));

        System.out.println("The result of second bubble sort is: ");
        printArray(singleBubble(singleBubble(arr)));

        System.out.println("The result of first selection sort is: ");
        printArray(singleSelection(arr));

        System.out.println("The result of second selection sort is: ");
        printArray(singleSelection(singleSelection(arr)));
    }

    public static int[][] add(int[][] a, int[][] b) {
        // Checking if both dimensions match
        if (a.length != b.length || a[0].length != b[0].length) return null;

        // Initializing result matrix
        int[][] result = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        return result;
    }

    public static int[][] mult(int[][] a, int[][] b) {
        // Checking if the matrices are able to multiply
        if (a[0].length != b.length) return null;

        // Initializing result matrix
        int[][] result = new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    public static int[] singleBubble(int[] arr) {
        // Creating a result array
        int[] result = new int[arr.length];

        // Cloning the original into result
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i];
        }

        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] > result[i + 1]) {
                // Swapping the elements
                int temp = result[i];
                result[i] = result[i + 1];
                result[i + 1] = temp;
            }
        }

        return result;
    }

    public static int[] singleSelection(int[] arr) {
        // Creating a result array
        int[] result = new int[arr.length];

        // Cloning the original into result
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i];
        }

        int minIndex = 0;

        for (int i = 1; i < result.length; i++) {
            if (result[i] < result[minIndex]) {
                minIndex = i;
            }
        }

        // Swap the smallest index with first element
        int temp = result[0];
        result[0] = result[minIndex];
        result[minIndex] = temp;

        return result;
    }

    private static void printMatrices(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
