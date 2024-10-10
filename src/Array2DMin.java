public class Array2DMin {
    public static int min(int[][] a) {
        if (a == null || a.length == 0) {
            return Integer.MIN_VALUE;
        }

        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            int[] row = a[i];
            int rowMin = ArrayMin.min(row);
            if (rowMin < minValue) {
                minValue = rowMin;
            }
        }

        return minValue;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {3, 5, 1},
                {7, -2, 6},
                {-9, 4, 0}
        };

        System.out.println(min(arr));
    }
}
