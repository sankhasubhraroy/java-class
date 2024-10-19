public class Class_19_10_2024 {
    public static boolean checkEqual(String a, String b) {
        return a.toUpperCase().equals(b.toUpperCase());
    }

    public static String isHello(String s) {
        if (s.toUpperCase().equals("HELLO")) {
            return "Hi!";
        } else {
            return "What did you say?";
        }
    }

    public static boolean checkUpperCase(String s) {
        return s.toUpperCase().equals(s);
    }

    public static int countVowels(String s) {
        int count = 0;
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < s.length(); i++) {
            String currentChar = s.substring(i, i + 1);
            if (vowels.indexOf(currentChar) != -1) {
                count++;
            }
        }

        return count;
    }

    public static int foo(String s) {
        int count = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            String current = s.substring(i, i + 1);
            String next = s.substring(i + 1, i + 2);

            // Check if the current character is the same as the next one
            if (current.equals(next)) {
                count++;
                // Skipping the next execution
                i++;
            }
        }

        return count;
    }

    public static String message(String name1, String name2) {
        return name1 + "'s dog (" + name2 + ") hates " + name1;
    }

    public static String extractName2(String msg) {
        // Find the index of ( and )
        int startIndex = msg.indexOf('(');
        int endIndex = msg.indexOf(')');

        // Extracting the substring between ( and )
        if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            return msg.substring(startIndex + 1, endIndex);
        } else {
            return "";
        }
    }

    public static int calculateName1Length(String msg, int name2Length) {
        String fixedPart = "'s dog () hates ";
        return (msg.length() - fixedPart.length() - name2Length) / 2;
    }

    public static void main(String[] args) {
        String s = "Abc";
        String t = "aBc";

        if (checkEqual(s, t)) System.out.println("Same");


        System.out.println(isHello("hello"));

        if (checkUpperCase("hello")) System.out.println("It is uppercase");
        else System.out.println("It is lowercase");

        String word = "AbiErTo";
        System.out.println("No of vowels is word: " + countVowels(word));

        String word1 = "AAA";
        System.out.println("No of consecutive letters in word1: " + foo(word1));

        String msg = message("James", "Miki");
        System.out.println(msg);

        String name2 = extractName2(msg);  // Question 13
        System.out.println(name2);

        int name1Length = calculateName1Length(msg, name2.length());    // Question 14
        System.out.println(name1Length);
    }
}
