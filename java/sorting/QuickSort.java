import java.util.*;

public class QuickSort {

   public static void main(String[] args) {
      int[] simpleTestCase = new int[] { 1, 2, 3, 10, 4, 4, 5, 6, 7, 8, 9, 4, 4, 4 };

      quicksort(simpleTestCase, 0, simpleTestCase.length - 1);
      System.out.println("Result: " + Arrays.toString(simpleTestCase));
   }

   public static void quicksort(int[] array, int start, int end) {
      if (start < end) {
         int pivot = partition(array, start, end);
         quicksort(array, start, pivot - 1);
         quicksort(array, pivot + 1, end);
      }
   }

   private static int partition(int[] array, int start, int end) {
      int pivot = start;
      int current = start + 1;
      for (int i = start + 1; i <= end; i++) {
         if (array[i] < array[pivot]) {
            swap(array, current, i);
            current++;
         }
      }
      swap(array, current - 1, pivot);
      return current - 1;
   }

   private static void swap(int[] array, int indexA, int indexB) {
      int swap = array[indexA];
      array[indexA] = array[indexB];
      array[indexB] = swap;
   }
}
