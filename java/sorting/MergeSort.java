import java.util.*;

public class MergeSort {

    public static void main(String[] args) {
        int[] simpleTestCase = new int[] { 1, 2, 3, 10, 4, 4, 5, 6, 7, 8, 9, 4, 4, 4 };

        mergesort(simpleTestCase);
        System.out.println("Result: " + Arrays.toString(simpleTestCase));
    }

    public static void mergesort(int[] array) {
        if (array.length < 2)
            return;
        int mid = array.length / 2;
        int[] left_arr = Arrays.copyOfRange(array, 0, mid);
        int[] right_arr = Arrays.copyOfRange(array, mid, array.length);

        mergesort(left_arr);
        mergesort(right_arr);
        merge(left_arr, right_arr, array);
    }

    private static void merge(int[] left_arr, int[] right_arr, int[] array) {
        int i = 0;
        int left = 0;
        int right = 0;

        while (left < left_arr.length && right < right_arr.length) {
            if (left_arr[left] < right_arr[right]) {
                array[i++] = left_arr[left++];
            } else {
                array[i++] = right_arr[right++];
            }
        }

        while (left < left_arr.length) {
            array[i++] = left_arr[left++];
        }

        while (right < right_arr.length) {
            array[i++] = right_arr[right++];
        }
    }<<<<<<<HEAD}=======
}>>>>>>>d0093dd...

Add mergesort
implementation
