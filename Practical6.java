import java.util.Scanner;
public class LinearSearch {
    public static int linearSearch(int arr[], int n, int key) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * 100);
        }

        System.out.println("\nArray elements:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.print("\n\nEnter element to search: ");
        int key = sc.nextInt();

        int result = linearSearch(arr, n, key);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }

        sc.close();
    }
}
import java.util.Arrays;
import java.util.Scanner;
public class BinarySearch {
    public static int binarySearch(int arr[], int key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            else if (arr[mid] < key) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * 100);
        }

        Arrays.sort(arr);

        System.out.println("\nSorted Array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.print("\n\nEnter element to search: ");
        int key = sc.nextInt();

        int result = binarySearch(arr, key);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }

        sc.close();
    }
}
