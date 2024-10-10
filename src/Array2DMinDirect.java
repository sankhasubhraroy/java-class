public class Array2DMinDirect {

    public static int min2(int[][] a) {
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

    public static void main(String[] args) {
        int[][] arr = {
                {5, 3, 7},
                {-9, -7, 2},
                {-5, 4, 6}
        };

        System.out.println(min2(arr));
    }
}
