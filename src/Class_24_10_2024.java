import java.util.Arrays;

public class Class_24_10_2024 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {2, 3, 4};
        a = foo(b, a);
        b = foo(a, b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        goal1();
        goal2();
        goal3();
        goal4();
        goal5();
    }

    public static int[] foo(int[] a, int[] b) {
        int[] c = a;
        a = b;
        b = c;

        for (int i = 0; i < a.length; i++) {
            a[i]++;
        }
        for (int i = 0; i < b.length; i++) {
            b[i] *= b[i];
        }
        return c;
    }

    /**
     * Question 4 -> {2.2.5,5,8,8,...}
     * The value starts at 2
     * For every second index (i.e., when i is odd),we increment the value by 3
     * This will result in repeating numbers and alternating between increasing by 3
     */
    public static void goal1() {
        int[] a = new int[100];
        int value = 2;

        for (int i = 0; i < a.length; i++) {
            a[i] = value;

            if (i % 2 == 1) {
                value += 3;
            }
        }

        System.out.println(Arrays.toString(a));
    }

    /**
     * Question 6 -> {1,2,3,2,3,4,3,4,5,4,5,6,...}
     * i /3 gives us the starting number for each group
     * i % 3 determines how much we should add to the base number to get the next value in the group
     * + 1 adjust the starting point since our sequence starts at 1, not 0
     */
    public static void goal2() {
        int[] a = new int[100];

        for (int i = 0; i < a.length; i++) {
            a[i] = (i / 3) + (i % 3) + 1;
        }

        System.out.println(Arrays.toString(a));
    }

    /**
     * Question 7 -> {0,1,0,3,0,5,...}
     * i % 2 == 0: if the index is even assign 0
     * For odd indices, assign the value of i, which corresponds to the next odd number
     */
    public static void goal3() {
        int[] a = new int[100];

        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                a[i] = 0;   // Even index is 0
            } else {
                a[i] = i;   // Odd index
            }
        }

        System.out.println(Arrays.toString(a));
    }

    /**
     * Question 8 -> {0,-2,4,2,0,-2,4,2,...}
     * i % 4 == 0: when i is divisible by 4, the value is 0
     * i % 4 == 1: when i % 4 is 1, the value is -2
     * i % 4 == 2: when i % 4 is 2, the value is 4
     * i % 4 == 3: when i % 4 is 3, the value is 2
     */
    public static void goal4() {
        int[] a = new int[100];

        for (int i = 0; i < a.length; i++) {
            if (i % 4 == 0) {
                a[i] = 0;
            } else if (i % 4 == 1) {
                a[i] = -2;
            } else if (i % 4 == 2) {
                a[i] = 4;
            } else {
                a[i] = 2;
            }
        }

        System.out.println(Arrays.toString(a));
    }

    /**
     * Question 9 -> {0,1,0,-1,0,1,0,-1,...}
     * i % 4 == 0 or i % 4 == 2: The value is 0 at these indices
     * i % 4 == 1: The value is 1 at the first index of each cycle
     * i % 4 == 3: The value is -1 at the 3rd index of each cycle
     */
    public static void goal5() {
        int[] a = new int[100];

        for (int i = 0; i < a.length; i++) {
            if (i % 4 == 0 || i % 4 == 2) {
                a[i] = 0;
            } else if (i % 4 == 1) {
                a[i] = 1;
            } else {
                a[i] = -1;
            }
        }

        System.out.println(Arrays.toString(a));
    }
}
