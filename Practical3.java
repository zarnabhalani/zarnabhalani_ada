import java.util.Scanner;
public class InsertionSort 
    public static void insertionSort(int arr[], int n) {
        int key, j;
        for (int i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * 1000);
        }

        System.out.println("\nArray before sorting:");
        for (int i = 0; i < Math.min(n, 20); i++) {
            System.out.print(arr[i] + " ");
        }

        long startTime = System.nanoTime();

        insertionSort(arr, n);

        long endTime = System.nanoTime();

        System.out.println("\n\nArray after sorting:");
        for (int i = 0; i < Math.min(n, 20); i++) {
            System.out.print(arr[i] + " ");
        }

        long executionTime = endTime - startTime;

        System.out.println("\n\nExecution Time: " + executionTime + " nanoseconds");

        sc.close();
    }
}
