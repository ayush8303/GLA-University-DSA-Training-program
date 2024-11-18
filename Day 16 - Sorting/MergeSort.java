import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {
  public static void merge(ArrayList<Integer> arr, int s, int e) {
    int mid = (s + e) / 2;
    int i = s; // starting index of left half
    int j = mid + 1; // starting index of right half

    ArrayList<Integer> temp = new ArrayList<>();
    while (i <= mid && j <= e) {
      if (arr.get(i) <= arr.get(j)) {
        temp.add(arr.get(i));
        i++;
      } else {
        temp.add(arr.get(j));
        j++;
      }
    }

    // copy remaining elements from left half
    while (i <= mid) {
      temp.add(arr.get(i));
      i++;
    }

    // copy remaining elements from right half
    while (j <= e) {
      temp.add(arr.get(j));
      j++;
    }

    // copy temp back into original array
    int k = 0;
    for (int idx = s; idx <= e; idx++) {
      arr.set(idx, temp.get(k));
      k++;
    }
  }

  public static void mergeSort(ArrayList<Integer> arr, int s, int e) {
    // base case
    if (s >= e) {
      return;
    }
    int mid = (s + e) / 2;

    // left half [s....mid]
    mergeSort(arr, s, mid);

    // right half [mid+1....e]
    mergeSort(arr, mid + 1, e);

    // merge
    merge(arr, s, e);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    ArrayList<Integer> arr = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      arr.add(scanner.nextInt());
    }

    int s = 0, e = n - 1;
    mergeSort(arr, s, e);

    for (int x : arr) {
      System.out.print(x + " ");
    }
    System.out.println();

    scanner.close();
  }
}
