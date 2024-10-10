public class ArrayMin {
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

    public static void main(String[] args) {
        int[] arr = {5, 2, -8, -1, 3};
//      int[] arr = {};
        System.out.println(min(arr));
    }
}
