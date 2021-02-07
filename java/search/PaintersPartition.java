import java.util.*;

public class PaintersPartition {

    /*
     * We have to paint n boards of length {A1, A2, .. An}. There are k painters
     * available and each takes 1 unit time to paint 1 unit of board. The problem is
     * to find the minimum time to get this job done under the constraints that any
     * painter will only paint continuous sections of boards, say board {2, 3, 4} or
     * only board {1} or nothing but not board {2, 4, 5}.
     */
    public static void main(String[] args) {
        int[] testCase = new int[] { 10, 20, 30, 40 };
        int k = 2;
        int result = binarysearch(testCase, k);
        System.out.println("Result: " + result);
    }

    public static int binarysearch(int[] array, int k) {
        int start = Arrays.stream(array).max().getAsInt();
        int sum = Arrays.stream(array).sum();
        int end = sum;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int testK = minPaintersForTime(array, mid);

            System.out.println("mid: " + mid + ", testK: " + testK);

            if (testK <= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static int minPaintersForTime(int[] array, int time) {
        int result = 0;
        int currentSum = 0;
        for (int i = 0; i < array.length; i++) {
            currentSum += array[i];
            if (currentSum > time) {
                result++;
                currentSum = array[i];
            }
        }
        if (currentSum != Arrays.stream(array).sum()) {
            result++;
        }
        return result;
    }

}
