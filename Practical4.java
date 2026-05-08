import java.util.Scanner;
public class MergeSort {
    public static void merge(int arr[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int arr[], int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
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

        mergeSort(arr, 0, n - 1);

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
