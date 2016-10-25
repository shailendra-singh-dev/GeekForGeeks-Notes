package arrays;

import java.util.Arrays;

public class QuickSort {

  public static void quickSort(int[] array, int low, int high) {
    if (low >= high || high > array.length || array.length == 0) {
      return;
    }

    int i = low;
    int j = high;
    int piot = (high - low) / 2;

    while (i <= j) {
      while (array[i] < array[piot])
        i++;

      while (array[j] > array[piot])
        j--;

      if (i <= j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
        j--;
      }

      if (j > low) {
        quickSort(array, low, j);
      }
      if (j < high) {
        quickSort(array, j, high);
      }
    }
  }


}
