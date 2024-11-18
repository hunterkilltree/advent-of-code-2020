import java.util.Arrays;

public class MergeSortImplement {
  
  public static void main(String[] args) {
    int[] arr = { 4, 1, 2, 3, 5, 0 };

    mergeSort(arr, 0, arr.length - 1);

    System.out.println(Arrays.toString(arr));

  }

  private static void mergeSort(int[] arr, int l, int r) {
    if (l < r) {
      int mid = l + (r - l) / 2;
      // Sort first and second halves
      mergeSort(arr, l, mid);
      mergeSort(arr, mid + 1, r);
      merge(arr, l, mid, r);
    }
  }

  private static void merge(int[] arr, int l, int mid, int r) {
    // Size of twos subarrays to be merged
    int n1 = mid - l + 1;
    int n2 = r - mid;

    // Create temp arrays
    int[] L = new int[n1];
    int[] R = new int[n2];

    // Copy data to temp arrays
    for (int i = 0; i < n1; i++) {
      L[i] = arr[l + i];
    }
    for (int i = 0; i < n2; i++) {
      R[i] = arr[mid + 1 + i];
    }
    // Merge the temp arrays

    // Initial indexes of first and second subarrays
    int i = 0, j = 0;
    // Initial index of merged subarray array
    int k = l;
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
}
