public class Class_13_11_2024 {
    public static void main(String[] args) {
        System.out.println("The result of recursive function is: " + foo(4));
        System.out.println("The result of factorial function is: " + fac(5));
        System.out.println("The 7th Fibonacci number is: " + fib(7));
        System.out.println("The reverse of Hello is: " + reverse("Hello"));
        System.out.println("The pigLatin version of Hello is: " + pigLatin("Hello"));
        System.out.println("The number of pascal's triangle is: " + pascal(5, 2));
    }

    public static int foo(int x) {
        if (x == 0) {
            return 4;       // Base case
        } else {
            return -3 + foo(x - 1);     // Recursive step
        }
    }

    public static int fac(int n) {
        if (n <= 1) {
            return 1;   // Base case
        } else {
            return n * fac(n - 1);
        }
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;   // Base case
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static String reverse(String str) {
        if (str.length() <= 1) {
            return str;     // Base case
        } else {
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }

    public static String pigLatin(String word) {
        // Finding the first vowel
        int firstVowelIndex = findFirstVowel(word);

        // If there is no vowel, we can return word + "ay"
        if (firstVowelIndex == -1) {
            return word + "ay";
        }

        // Move the consonant cluster to the end and add "ay"
        String consonantCluster = word.substring(0, firstVowelIndex);
        String restOfWord = word.substring(firstVowelIndex);
        return restOfWord + consonantCluster + "ay";
    }

    // Helper function to find the first vowel in a word
    private static int findFirstVowel(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (isVowel(word.charAt(i))) {
                return i;
            }
        }
        return -1; // Return -1 if no vowel is found (though unusual in real words)
    }

    // Helper function to check if a character is a vowel
    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }


    public static int pascal(int row, int col) {
        if (col == 1 || col == row) {
            return 1;   // Base case (Edges of pascal's triangle is 1)
        } else {
            return pascal(row - 1, col - 1) + pascal(row - 1, col);
        }
    }
}
