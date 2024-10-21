public class Class_10_10_2024 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        System.out.println(arrayToString1D(arr1));

        int[][] arr2 = {{1, 2, 3}, {3, 4, 5, 6}, {7, 8, 9, 9, 9}};
        System.out.println(arrayToString2D((arr2)));

        int[][] board = {{-1, 0, 1}, {0, -1, 1}, {0, 0, -1}};
        System.out.println(checkWinner(board));

        int[][] arr3 = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
        System.out.println(totalSum(arr3));

        int[][] arr4 = {{4, 1, 9, 36}, {2, 5, 3, 5}, {4, 10, 11, 12}, {12, 5, 23, 9}};
        System.out.println(majorDiagonalSum(arr4));

        int[][] arr5 = {{4, 1, 9, 35}, {2, 5, 3, 5}, {4, 10, 11, 12}, {12, 5, 23, 9}};
        System.out.println(minorDiagonalSum(arr5));

        int[] arr6 = {5, 2, -8, -1, 3};
        System.out.println(min(arr6));

        int[][] arr7 = {{3, 5, 1}, {7, -2, 6}, {-9, 4, 0}};
        System.out.println(min2D(arr7));

        int[][] arr8 = {{5, 3, 7}, {-9, -7, 2}, {-5, 4, 6}};
        System.out.println(min2DDirect(arr8));

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

        System.out.println("Pattern A");
        printPatternA();

        System.out.println("Pattern B");
        printPatternB();

        System.out.println("Pattern C");
        printPatternC();

        int n = 9;
        int[][] triangle = pascalTriangle(n);
        printPascal(triangle);
    }

    public static String arrayToString1D(int[] arr) {
        String result = "{";

        // Looping through the array
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
            if (i < arr.length - 1) {
                result += ", ";   // Adding a comma and space between every Index
            }
        }

        result += "}";

        return result;
    }

    public static String arrayToString2D(int[][] arr) {
        String result = "{";

        // Looping through the 2D array
        for (int i = 0; i < arr.length; i++) {
            result += "{";     // Indent and start each row with an opening brace

            // Looping through each row
            for (int j = 0; j < arr[i].length; j++) {
                result += arr[i][j];    // Concatenating the elements
                if (j < arr[i].length - 1) {
                    result += ", ";     // Adding a comma and space between each element
                }
            }

            result += "}";

            // Adding a comma in every new line, except the last row
            if (i < arr.length - 1) {
                result += ",\n";
            }
        }

        result += "}";

        return result;
    }

    public static String checkWinner(int[][] board) {
        // Checking the rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == 1) return "X wins";
                if (board[i][0] == -1) return "O wins";
            }
        }

        // Checking the columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == 1) return "X wins";
                if (board[0][i] == -1) return "O wins";
            }
        }

        // Checking diagonally
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == 1) return "X wins";
            if (board[0][0] == -1) return "O wins";
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] == 1) return "X wins";
            if (board[0][2] == -1) return "O wins";
        }

        return "No winner";
    }

    public static int totalSum(int[][] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }

        return sum;
    }

    public static int majorDiagonalSum(int[][] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }

        return sum;
    }

    public static int minorDiagonalSum(int[][] arr) {
        int sum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            sum += arr[i][n - 1 - i];
        }

        return sum;
    }

    public static int min(int[] a) {
        if (a == null || a.length == 0) {
            return Integer.MIN_VALUE;   // The smallest possible int value
        }

        int minValue = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] < minValue) {
                minValue = a[i];
            }
        }

        return minValue;
    }

    public static int min2D(int[][] a) {
        if (a == null || a.length == 0) {
            return Integer.MIN_VALUE;
        }

        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            int[] row = a[i];
            int rowMin = min(row);
            if (rowMin < minValue) {
                minValue = rowMin;
            }
        }

        return minValue;
    }

    public static int min2DDirect(int[][] a) {
        if (a == null || a.length == 0) {
            return Integer.MIN_VALUE;
        }

        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == null || a[i].length == 0) continue;

            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] < minValue) {
                    minValue = a[i][j];
                }
            }
        }

        return minValue;
    }

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

    // Pattern A: Increasing Numbers
    public static void printPatternA() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();   // adding a new line
        }
    }

    public static void printPatternB() {
        for (int i = 5; i >= 1; i--) {
            for (int k = 5; k > i; k--) {   // adding a triangle of white space
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();   // adding a new line
        }
    }

    public static void printPatternC() {
        for (int i = 5; i >= 1; i--) {
            for (int j = 5; j >= i; j--) {
                System.out.print(i);
            }
            System.out.println();   // adding a new line
        }
    }

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
}
