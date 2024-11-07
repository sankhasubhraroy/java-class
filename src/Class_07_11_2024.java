import java.util.Arrays;

public class Class_07_11_2024 {
    public static void main(String[] args) {
        int[] arr1 = {99, 88, 77, 66, 44, 22};
        System.out.println("Before bubble sort: " + Arrays.toString(arr1));
        int operationsInBubble = bubbleSort(arr1);
        System.out.println("After bubble sort: " + Arrays.toString(arr1) + " no of operations" + "->" + operationsInBubble);

        int[] arr2 = {12, 23, 7, 45, 9, 6};
        System.out.println("Before insertion sort: " + Arrays.toString(arr2));
        int operationsInInsertion = insertionSort(arr2);
        System.out.println("After insertion sort: " + Arrays.toString(arr2) + " no of operations" + "->" + operationsInInsertion);

        int[] arr3 = {12, 23, 7, 45, 9, 6};
        System.out.println("Before selection sort: " + Arrays.toString(arr3));
        int operationsInSelection = selectionSort(arr3);
        System.out.println("After selection sort: " + Arrays.toString(arr3) + " no of operations" + "->" + operationsInSelection);
    }

    // Bubble Sort
    public static int bubbleSort(int[] arr) {
        int n = arr.length;
        int operatorCount = 0;  // To count the number of operation

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                operatorCount++;    // Comparison operator

                if (arr[j] > arr[j + 1]) {
                    // Swap the values
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    operatorCount += 3; // Swap involves 3 assignments
                }
            }
        }

        return operatorCount;
    }

    // Insertion Sort
    public static int insertionSort(int[] arr) {
        int n = arr.length;
        int operatorCount = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            operatorCount++;   // Assignment operator for key

            while (j >= 0 && arr[j] > key) {
                operatorCount++;    // Comparison operator
                arr[j + 1] = arr[j];
                operatorCount++;    // Assignment operator for shift
                j--;
            }
            operatorCount++;    // Final comparison when while condition fails
            arr[j + 1] = key;
            operatorCount++;   // Assignment operator for insertion
        }

        return operatorCount;
    }

    // Selection Sort
    public static int selectionSort(int[] arr) {
        int n = arr.length;
        int operatorCount = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            operatorCount++;    //  Assignment operator

            for (int j = i + 1; j < n; j++) {
                operatorCount++;    // Comparison operator
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    operatorCount++;    // Assignment operator
                }
            }

            // Swapping if new minimum index is found
            if (minIndex != 1) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                operatorCount += 3;   // swap involves 3 assignments
            }
        }

        return operatorCount;
    }
}
