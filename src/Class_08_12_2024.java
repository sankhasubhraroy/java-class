import java.util.Arrays;

public class Class_08_12_2024 {
    public static void main(String[] args) {
        String str = "          Thanks!      ";
        System.out.println(str + " -> " + trim(str));

        String intStr = "12213";
        System.out.println(intStr + " -> " + isInt(intStr));

        String operator = "=";
        System.out.println(operator + " -> " + isOperator(operator));

        String token = "23";
        System.out.println(token + " -> " + Arrays.toString(tokenize(token)));
    }

//    public static String trim(String input) {
//        if (input == null) return null;
//
//        return input.replaceAll("^\\s+", "");
//    }

    public static String trim(String input) {
        char[] chars = input.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        // Finding the first no-space character from the beginning of the string
        while (start <= end && chars[start] == ' ') {
            start++;
        }

        // Finding the first no-space character from the end of the string
        while (end >= start && chars[end] == ' ') {
            end--;
        }

        // If there are no-space characters
        if (start > end) {
            return "";
        }

        // Creating the original string
        return input.substring(start, end + 1);
    }

//    public static boolean isInt(String input) {
//        if (input == null || input.isEmpty()) return false;
//
//        return input.matches("\\d+");
//    }

    public static boolean isInt(String input) {
        if (input == null || input.isEmpty()) return false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // Checking if the current character is not a digit
            if (c < '0' || c > '9') {
                return false;
            }
        }

        // If all the characters are digits
        return true;
    }

    public static boolean isOperator(String input) {
        String[] operators = {",", "+", "-", "*", "/", "%", "=", "+=", "-=", "*=/=", "%=", "==", "<", ">", "<=", ">=", "(", ")", "[", "]", "{", "}",};


        for (int i = 0; i < operators.length; i++) {
            if (input.equals(operators[i])) {
                return true;
            }
        }

        return false;
    }

    public static String[] tokenize(String s) {
        String[] tokenList = new String[100];   // Static array to hold tokens
        int index = 0;                          // Tracking the current position in the tokenList array
        String current = "";                    // Building the current token

        while (s.length() > 0) {
            char letter = s.charAt(0);          // Get the first character
            s = s.substring(1);       // Removing the first character form the string

            if (current.isEmpty() && letter != ' ') {
                current = String.valueOf(letter);
            } else if (letter == ' ') {
                if (!current.isEmpty()) {
                    tokenList[index++] = current;
                    current = "";
                }
            } else if (isInt(current + letter)) {
                current += letter;
            } else if (isInt(current) && !isInt(String.valueOf(letter))) {
                tokenList[index++] = current;
                current = String.valueOf(letter);
            } else if (isOperator((current + letter))) {
                current += letter;
            } else {
                if (!current.isEmpty()) {
                    tokenList[index++] = current;
                }
                current = String.valueOf(letter);
            }
        }

        if (!current.isEmpty()) {
            tokenList[index++] = current;
        }

        String[] result = new String[index];
        for (int i = 0; i < index; i++) {
            result[i] = tokenList[i];
        }

        return result;
    }
}
