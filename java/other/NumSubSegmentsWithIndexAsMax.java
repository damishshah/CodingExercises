import java.util.*;

public class NumSubSegmentsWithIndexAsMax {
    public static int query(int N, int[] arr, int index) {
        int[] nge = nge(N, arr);
        System.out.println(Arrays.toString(nge));
        int[] pge = pge(N, arr);
        System.out.println(Arrays.toString(pge));
        return nge[index] - pge[index] - 1;
    }

    private static int[] nge(int N, int[] arr) {
        int[] result = new int[N];
        Stack<Integer> s = new Stack<>();

        s.push(0);
        for (int i = 1; i < N; i++) {
            while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
                result[s.pop()] = i;
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            int index = s.pop();
            result[index] = N;
        }

        return result;
    }

    private static int[] pge(int N, int[] arr) {
        int[] result = new int[N];
        Stack<Integer> s = new Stack<>();

        s.push(0);
        for (int i = N - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
                result[s.pop()] = i;
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            int index = s.pop();
            result[index] = -1;
        }

        return result;
    }

    public static void main(String []args){
        System.out.println(query(4, new int[]{4, 2, 1, 3}, 0));
        System.out.println(query(5, new int[]{4, 2, 3, 5, 1}, 2));
    }
}