import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Class_17_11_2024 {
    public static void main(String[] args) {
        int n = 50;
        System.out.println("Prime numbers up to " + n + " are " + sieveOfEratosthenes(n));

        int[] arr = {23, 456, 8, 24, 56, 45, 23, 42, 34, 5, 6};
        int index = 6;

        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("After removal: " + Arrays.toString(removeElement(arr, index)));

        int num = 30;
        System.out.println("Prime numbers up to " + num + " are " + Arrays.toString(sieveOfEratosthenesAlternate(num)));
    }

    public static List<Integer> sieveOfEratosthenes(int n) {
        // Step A: Create a boolean array of size n+1 and initialize it to false
        boolean[] isComposite = new boolean[n + 1];

        // Step B: Apply the sieve of eratosthenes
        for (int i = 2; i <= n; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        // Step C: Collect prime numbers into a list
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!isComposite[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static int[] removeElement(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("Index out of bound");
        }

        int[] newArray = new int[arr.length - 1];

        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                newArray[j++] = arr[i];
            }
        }

        return newArray;
    }

    public static int[] sieveOfEratosthenesAlternate(int n) {
        // Step A: Create a boolean array and initialize it
        boolean[] isComposite = new boolean[n + 1];
        ArrayList<Integer> primes = new ArrayList<>();

        // Step B: Apply the sieve of eratosthenes
        for (int i = 2; i * i <= n; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        // Step C: Fill the primes with non-composite indices
        for (int i = 2; i <= n; i++) {
            if (!isComposite[i]) {
                primes.add(i);
            }
        }

        // Converting the arrayList to array
        return primes.stream().mapToInt(i -> i).toArray();
    }
}
