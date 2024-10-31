public class Class_31_10_2024 {
    public static int[] collate3(int[] a, int[] b, int[] c) {
        if (a == null || b == null || c == null) return null;

        int length = a.length;
        int[] result = new int[length * 3];

        for (int i = 0, j = 0; i < length; i++) {
            result[j++] = a[i];
            result[j++] = b[i];
            result[j++] = c[i];
        }

        return result;
    }

    public static void testCode1() {
        int[] a = {2, 5, 8};
        int[] b = {6, 7, 6};
        int[] c = {8, 2, 0};
        int[] ans = collate3(a, b, c);
        int[] correct = {2, 6, 8, 5, 7, 2, 8, 6, 0};
        boolean allElementsMatch = true;
        for (int i = 0; i < correct.length; i++)
            allElementsMatch &= ans[i] == correct[i];
        if (allElementsMatch) System.out.println("Part 1 works!!!");
        else System.out.println("Part 1 back to the drawing board");
    }

    public static int[] collate2(int[] a, int[] b) {
        if (a == null) return b;
        if (b == null) return a;

        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            result[k++] = a[i++];
            result[k++] = b[j++];
        }

        while (i < a.length) result[k++] = a[i++];

        while (j < b.length) result[k++] = b[j++];

        return result;
    }

    public static void testCode2() {
        // Test 1 -> a = {1,2,3,4,5}, b = {6,7,8}
        // Test 2 -> a = null, b = {1,2,3}
        // Test 3 -< a = {1,2,3}, b = null
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 7, 8};
        int[] ans = collate2(a, b);
        int[] correct = {1, 6, 2, 7, 3, 8, 4, 5};
        boolean allElementsMatch = true;
        for (int i = 0; i < correct.length; i++)
            allElementsMatch &= ans[i] == correct[i];
        if (allElementsMatch) System.out.println("Part 1 works!!!");
        else System.out.println("Part 1 back to the drawing board");

    }

    public static int[] merge(int[] a, int[] b) {
        if (a == null) return b;
        if (b == null) return a;

        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < a.length) result[k++] = a[i++];

        while (j < b.length) result[k++] = b[j++];

        return result;
    }

    public static void testCode3() {
        // Test 1 -> a = {1,3,4,8}, b = {2,5,6,7,8}
        // Test 2 -> a = null, b = {1,2,3}
        // Test 3 -> a = {1,2,3}, b = null

        int[] a = {1, 3, 4, 8};
        int[] b = {2, 5, 6, 7, 8};
        int[] ans = merge(a, b);
        int[] correct = {1, 2, 3, 4, 5, 6, 7, 8, 8};
        boolean allElementsMatch = true;
        for (int i = 0; i < correct.length; i++)
            allElementsMatch &= ans[i] == correct[i];
        if (allElementsMatch) System.out.println("Part 1 works!!!");
        else System.out.println("Part 1 back to the drawing board");
    }

    public static int smallestIndex1(int[] a) {
        if (a == null || a.length == 0) return -1;

        int smallestIndex = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < a[smallestIndex]) {
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    public static void testCode4a() {
        int[] a = {5, 1, 9, 2, 1};
        System.out.println("Expected index 1, got: " + smallestIndex1(a));
    }

    public static int smallestIndex(int[] a, int startIndex) {
        if (a == null || startIndex >= a.length) return -1;

        int smallestIndex = startIndex;

        for (int i = startIndex; i < a.length; i++) {
            if (a[i] < a[smallestIndex]) {
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    public static void testCode4c() {
        int[] a = {5, 1, 9, 2, 1};
        System.out.println("Expected index 4, got: " + smallestIndex(a, 2));
    }

    // Selection sort
    public static void sSort(int[] a) {
        if (a == null) return;

        for (int i = 0; i < a.length - 1; i++) {
            int minIdx = smallestIndex(a, i);
            int temp = a[i];
            a[i] = a[minIdx];
            a[minIdx] = temp;
        }
    }

    public static void testCode5a() {
        int[] a = {1, 3, 4, 8, 5, 7, 6, 2};
        sSort(a);

        System.out.println(java.util.Arrays.toString(a));
    }

    public static void selectionSort(int[] a) {
        if (a == null) return;

        for (int i = 0; i < a.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIdx];
            a[minIdx] = temp;
        }
    }

    public static void testCode5c() {
        int[] a = {1, 3, 4, 8, 5, 7, 6, 2};
        selectionSort(a);

        System.out.println(java.util.Arrays.toString(a));
    }

    public static void main(String[] args) {
        testCode1();
        testCode2();
        testCode3();
        testCode4a();
        testCode4c();
        testCode5a();
        testCode5c();
    }
}
