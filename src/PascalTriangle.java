public class PascalTriangle {
    public static int[][] pascalTriangle(int n) {
        // Initializing a 2D array to store the pascal's Triangle
        int[][] triangle = new int[n][];

        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;
            triangle[i][i] = 1;

            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }

        return triangle;
    }

    public static void printPascal(int[][] triangle) {
        for (int i = 0; i < triangle.length; i++) {
            for (int space = 0; space < triangle.length - i - 1; space++) {
                System.out.print(" ");
            }   // formatting

            int[] row = triangle[i];
            for (int j = 0; j < row.length; j++) {
                int value = row[j];
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] triangle = pascalTriangle(n);
        printPascal(triangle);
    }
}
