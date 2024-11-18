import java.util.Scanner;
import java.util.ArrayList;

public class Main {

  public static int partition(ArrayList<Integer> arr, int s, int e) {
    int pivot = arr.get(e);
    int i = s - 1;

    for (int j = s; j < e; j++) {
      if (arr.get(j) < pivot) {
        i++;
        // Swap elements
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
      }
    }
    // Swap the pivot to its correct position
    int temp = arr.get(i + 1);
    arr.set(i + 1, arr.get(e));
    arr.set(e, temp);

    return i + 1;
  }

  public static void quickSort(ArrayList<Integer> arr, int s, int e) {
    // base case
    if (s >= e) {
      return;
    }

    // rec case
    int mid = partition(arr, s, e);
    quickSort(arr, s, mid - 1);
    quickSort(arr, mid + 1, e);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    ArrayList<Integer> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      arr.add(sc.nextInt());
    }

    int s = 0, e = n - 1;
    quickSort(arr, s, e);

    for (int x : arr) {
      System.out.print(x + " ");
    }

    sc.close();
  }
}