public class BigInt {
    public static int[] newBigInt(String s, int digitsPerIndex) {
        // Precondition: digitsPerIndex should be >= 1
        // Precondition: s should be all numerals, no spaces, negative signs, decimal pts.
        // Postcondition: "123456789" => {789, 456, 123}
        int lengthOfArray = (s.length() - 1) / digitsPerIndex + 1;
        int index = 0;
        int[] ans = new int[lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++) {
            index = s.length() - digitsPerIndex; // FIX TYPO
            if (index < 0) index = 0;
            ans[i] = Integer.parseInt(s.substring(index));
            s = s.substring(0, index);
        }
        return ans;
    }

    public static String bigIntToString(int[] bigInt) {
        String result = "" + bigInt[bigInt.length - 1];     // Starting form the last element

        for (int i = bigInt.length - 2; i >= 0; i--) {
            String chunk = "" + bigInt[i];  // Converting the current chunk of the string

            while (chunk.length() < 3) {
                chunk = "0" + chunk;
            }

            result += chunk;
        }

        return result;
    }

    public static int[] fixOverflow(int[] bigInt, int maxChunkValue) {
        int carry = 0;

        for (int i = 0; i < bigInt.length; i++) {
            bigInt[i] += carry;

            if (bigInt[i] >= maxChunkValue) {
                carry = bigInt[i] / maxChunkValue;
                bigInt[i] %= maxChunkValue;
            } else {
                carry = 0;  // Reset carry if there is no overflow
            }
        }

        if (carry > 0) {
            int[] newBigInt = new int[bigInt.length + 1];
            System.arraycopy(bigInt, 0, newBigInt, 0, bigInt.length);
            newBigInt[bigInt.length] = carry;
            return newBigInt;
        }

        return bigInt;
    }

    public static int[] add(int[] bigInt1, int[] bigInt2, int maxChunkValue) {
        int maxLength = Math.max(bigInt1.length, bigInt2.length);
        int[] sum = new int[maxLength];

        for (int i = 0; i < maxLength; i++) {
            if (i < bigInt1.length) sum[i] += bigInt1[i];
            if (i < bigInt2.length) sum[i] += bigInt2[i];
        }

        return fixOverflow(sum, maxChunkValue);     // Handled overflow
    }

    public static void main(String[] args) {
        String bigNumber = "2534563221312353253463231213124235344654654232143143876872364238472532453463453";
        int digitsPerIndex = 3;

        // Converting the string to bigInt
        int[] bigInt = newBigInt(bigNumber, digitsPerIndex);
        String backToString = bigIntToString(bigInt);

        System.out.println("Original number: " + bigNumber);
        System.out.println("BigInt to String: " + backToString);

        // Checking if the original string and result string are equal
        if (bigNumber.equals(backToString)) {
            System.out.println("Test passed: BigInt correctly converts to string");
        } else {
            System.out.println("Test failed: Output does not match the original string");
        }
    }
}