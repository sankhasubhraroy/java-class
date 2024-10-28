import java.util.Arrays;

public class Class_26_10_2024 {
    public static void main(String[] args) {
        foo1();
        foo2();
        foo3();
    }

    public static void foo1() {
        int[] a = new int[10];
        int b = 1;
        int c = 2;

        for (int i = 0; i < a.length; i++) {
            b++;
            a[i] = b + c;
            c += a[i];
        }

        System.out.println(Arrays.toString(a));
    }

    public static void foo2() {
        int count = 0;
        int a = 6;
        count = count + 1;

        while (a != 1) {
            System.out.print(a + " ");
            count++;
            if (a % 2 == 0) {
                a /= 2;
                count++;
            } else {
                a = 3 * a + 1;
                count++;
            }
        }

        System.out.println(a);
        count++;

        System.out.println(count);
    }

    public static void foo3() {
        int count = 0;
        int[][] a = new int[4][];
        count = count + 1;

        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                a[i] = new int[a.length - i];
                count++;
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j] = a.length - i;
                    count++;
                }
            } else {
                a[i] = a[i - 1];
                count++;
            }
        }

        System.out.println(count);
    }
}
