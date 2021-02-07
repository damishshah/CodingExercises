public class SimpleBinarySearch {

    public static void main(String[] args) {
        int[] simpleTestCase = new int[] { 1, 2, 3, 4, 4, 4, 4, 4, 5, 6, 7, 8, 9, 10 };

        int target = 7;
        int resultIndex = simpleBinarySearch(simpleTestCase, target);
        System.out.println("Result: " + resultIndex);
    }

    public static int simpleBinarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

}
