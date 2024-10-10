public class ArrayToString2D {
    public static String arrayToString(int[][] arr) {
        String result = "{";

        // Looping through the 2D array
        for (int i = 0; i < arr.length; i++) {
            result += "{";     // Indent and start each row with a opening brace

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

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {3, 4, 5, 6},
                {7, 8, 9, 9, 9}
        };
        System.out.println(arrayToString((arr)));
    }
}
