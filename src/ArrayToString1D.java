public class ArrayToString1D {
    public static String arrayToString(int[] arr) {
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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(arrayToString(arr));
    }
}
