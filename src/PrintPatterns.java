public class PrintPatterns {
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

    public static void main(String[] args) {
        System.out.println("Pattern A");
        printPatternA();

        System.out.println("Pattern B");
        printPatternB();

        System.out.println("Pattern C");
        printPatternC();
    }
}
