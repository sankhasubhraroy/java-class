public class Class_18_10_2024 {
    public static void main(String[] args) {
        String str = "this is an example. example of some string manipulations. it's below";
        System.out.println("Number of space " + spaceCount(str));
        System.out.println("Number of vowels " + vowelCount(str));
        System.out.println("No of time (a) is there " + letterCount(str, "a"));
        System.out.println("(Before pa) " + beforeString(str, "pa"));
        System.out.println("(After pa) " + afterString(str, "pa"));
        System.out.println("Capitalizing it " + capFirstWord(str));
        System.out.println("4th occurrence of a is " + fourthIndexOf(str, "a"));
    }

    public static int spaceCount(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).compareTo(" ") == 0) {
                count++;
            }
        }

        return count;
    }

    public static int vowelCount(String s) {
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

    public static int letterCount(String s, String letter) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).compareTo(letter) == 0) {
                count++;
            }
        }

        return count;
    }

    public static String beforeString(String s, String substr) {
        int index = s.indexOf(substr);

        if (index != -1) {
            return s.substring(0, index);   // returning everything before substring
        }

        return s;
    }

    public static String afterString(String s, String substr) {
        int index = s.indexOf(substr);

        if (index != -1) {
            return s.substring(index + substr.length());
        }

        return "";
    }

    public static String capFirstWord(String s) {
        String result = "";
        int index = 0;

        while (index < s.length()) {
            int periodIndex = s.indexOf(".", index);
            if (periodIndex == -1) {
                periodIndex = s.length();
            }
            String sentence = s.substring(index, periodIndex).trim();

            if (sentence.length() > 0) {
                char firstChar = sentence.charAt(0);

                if (firstChar >= 'a' && firstChar <= 'z') {
                    firstChar = (char) (firstChar - 32);    // Capitalizing
                }
                result += firstChar + sentence.substring(1);
            }

            if (periodIndex < s.length()) {
                result += ". ";
            }

            index = periodIndex + 1;
        }

        return result.trim();
    }

    public static int fourthIndexOf(String s, String substr) {
        int count = 0;
        int index = -1;
        int start = 0;

        while (count < 4) {
            index = s.indexOf(substr, start);
            if (index == -1) {
                return -1;
            }
            count++;
            start = index + 1;
        }

        return index;
    }
}
