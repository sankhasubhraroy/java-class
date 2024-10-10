public class Main {
    public static void main(String[] args) {
        // This is the main() function.
        // You can run test code here.


        // When you're ready, uncomment this function to run the grader.
        gradeProject();
    }

    // 1. Remember to follow the formatting rule for negatives for all functions.
    // Do not assume your arguments follow the formatting rule.
    public static int[] newFraction(int num, int den) {
        if (den == 0) {
            return new int[]{num < 0 ? -1 : 1, 0};
        }
        if (den < 0) {
            num = -num;
            den = -den;
        }
        return new int[]{num, den};
    }

    // 2. Returns a nice looking String like "3/4" or "-2/5".
    // Your Fractions should look nice, but does not need to be simplified.
    public static String toString(int[] a) {
        return a[1] == 0 ? "undefined" : a[0] + "/" + a[1];
    }

    // 3. Returns the sum of the 2 arguments. No need to simplify.
    public static int[] add(int[] a, int[] b) {
        int numerator = a[0] * b[1] + b[0] * a[1];
        int denominator = a[1] * b[1];
        return newFraction(numerator, denominator);
    }

    // 4. Returns the absolute value of a Fraction.
    public static int[] abs(int[] a) {
        return newFraction(Math.abs(a[0]), a[1]);
    }

    // 5. Returns true if it's divide by 0 error.
    public static boolean isError(int[] a) {
        return a[1] == 0;
    }

    // 6. Returns true if the Fractions have the same value, false otherwise.
    // Ex, a = 2/4, b = 3/6, equals(a,b) => true.
    public static boolean equals(int[] a, int[] b) {
        return a[0] * b[1] == b[0] * a[1];
    }

    // 7. Return the smaller of the 2 Fractions.
    public static int[] min(int[] a, int[] b) {
        return equals(a, b) ? a : (a[0] * b[1] < b[0] * a[1] ? a : b);
    }

    // 8. Create the Fractions 1/2, 1/3, ... , 1/10, print them out, and return the sum.
    public static int[] task1() {
        int[] sum = new int[]{0, 1};
        for (int i = 2; i <= 10; i++) {
            int[] fraction = newFraction(1, i);
            sum = add(sum, fraction);
            System.out.println(toString(fraction));
        }
        return sum;
    }

    // 9. To simplify a Fraction, go through numbers >=2 (you decide where to stop),
    // and if it divides both numerator and denominator, divide it out of the
    // numerator and denominator. Consider what happens when you have 4/8 (gcd=4) = 1/2!
    public static int[] simplify(int[] a) {
        int gcd = gcd(Math.abs(a[0]), a[1]);
        return newFraction(a[0] / gcd, a[1] / gcd);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    // 10. Go back to your code and add simplification where appropriate.
    // Which functions did you simplify in?

    // 11. Returns an array of Fractions whose sum is the Fraction you are decomposing.
    // You may either include or exclude zero Fractions.
    // Ex, 5/12 can return {0/2, 0/3, 1/4, 1/6, 0/12} or {1/4, 1/6}, your choice.

    // How to create an array of 5 Fractions:
    // int[][] aof = new int[5][];
    // aof[0] = newFraction(1,2);
    // aof[1] = newFraction(2,3);
    // and so on....

    public static int[][] partialPartialFractionDecomposition() {
        // Defining a sample fraction 5/12
        int[] fraction = newFraction(5, 12);

        //  Now we have to find the factors of the denominator (12)
        // Possible factors (2,3,4,6,12)
        // Creating an array to hold the fractions generated from these factors

        int[][] result = new int[5][];

        result[0] = newFraction(0, 2);
        result[1] = newFraction(0, 3);
        result[2] = newFraction(0, 4);
        result[3] = newFraction(0, 6);
        result[4] = newFraction(0, 12);

        return result;
    }

    public static String space(int spaces, String text) {
        // text may overflow spaces
        while (text.length() < spaces) text += " ";
        return text;
    }

    public static String space(String text) {
        return space(20, text);
    }

    public static void gradeProject() {
        int score = 0;
        int number = 0;
        try {
            number++;
            int[] a = newFraction(3, 4), b = newFraction(2, -5);
            boolean correct = a[0] == 3 && a[1] == 4 && b[0] == -2 && b[1] == 5;
            if (correct) score++;
            System.out.println(space(number + ". newFraction():") + correct);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number++;
            int[] a = {3, 4}, b = {2, -5};
            boolean correct = toString(a).equals("3/4") && toString(b).equals("-2/5");
            if (correct) score++;
            System.out.println(space(number + ". toString():") + correct);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number++;
            int[] a = {1, 4}, b = {2, 5}, c = {3, -5};
            int[] ans1 = add(a, b), ans2 = add(a, c);
            boolean correct = ans1[0] == 13 && ans1[1] == 20 && ans2[0] == -7 && ans2[1] == 20;
            if (correct) score++;
            System.out.println(space(number + ". add():") + correct);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number++;
            int[] a = {3, 2}, b = {3, -4}, c = {-3, -5};
            int[] ans1 = abs(a), ans2 = abs(b), ans3 = abs(c);
            boolean correct = ans1[0] == 3 && ans1[1] == 2 && ans2[0] == 3 && ans2[1] == 4 && ans3[0] == 3 && ans3[1] == 5;
            if (correct) score++;
            System.out.println(space(number + ". abs():") + correct);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number++;
            int[] a = {-3, 0}, b = {3, -4};
            boolean correct = isError(a) && !isError(b);
            if (correct) score++;
            System.out.println(space(number + ". isError():") + correct);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number++;
            int[] a = {-3, 2}, b = {3, -2}, c = {-3, -5}, d = {6, 10}, e = {-6, -4}, f = {9, 6};
            boolean correct = equals(a, b) && equals(c, d) && equals(e, f) && !equals(b, c);
            if (correct) score++;
            System.out.println(space(number + ". equals():") + correct);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number++;
            int[] a = {3, 2}, b = {3, -4}, c = {-5, -2};
            int[] ans1 = min(a, b), ans2 = min(a, c);
            boolean correct = ans1[0] == -3 && ans1[1] == 4 && ans2[0] == 3 && ans2[1] == 2;
            if (correct) score++;
            System.out.println(space(number + ". min():") + correct);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number++;
            int[] a = task1();
            boolean correct = a[0] == 6999840 && a[1] == 3628800;
            if (correct) score++;
            System.out.println(space(number + ". task1():") + correct);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number++;
            int[] a = {15, 9}, b = {-21, -9}, c = {-8, -4};
            int[] ans1 = simplify(a), ans2 = simplify(b), ans3 = simplify(c);
            boolean correct = ans1[0] == 5 && ans1[1] == 3 && ans2[0] == 7 && ans2[1] == 3 && ans3[0] == 2 && ans3[1] == 1;
            if (correct) score++;
            System.out.println(space(number + ". simplify():") + correct);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }

        System.out.println("\nTotal: " + score + " / " + number + "\n");
    }
}