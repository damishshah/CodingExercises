import java.util.Arrays;

public class HeapSort {
    public static void main(String args[])
    {
        int simpleTestCase[] = { 13, 11, 12, 12, 1, 13, 5, 6, 7 };

        heapsort(simpleTestCase);
 
        System.out.println("Result: " + Arrays.toString(simpleTestCase));
    }

    public static void heapsort(int array[])
    {
        int heapsize = array.length;
 
        // "heapsize/2 - 1" is used here because all leaf nodes in the tree
        //  are already trivial heaps of size 1, so we can skip them when
        //  heapifying.
        for (int i = heapsize / 2 - 1; i >= 0; i--)
            heapify(array, heapsize, i);
 
        for (int i = heapsize - 1; i > 0; i--) {
            int swap = array[0];
            array[0] = array[i];
            array[i] = swap;
 
            heapify(array, i, 0);
        }
    }
 
    private static void heapify(int array[], int heapsize, int currentRoot)
    {
        int largest = currentRoot;
        int leftChild = 2 * currentRoot + 1;
        int rightChild = 2 * currentRoot + 2;
 
        if (leftChild < heapsize && array[leftChild] > array[largest])
            largest = leftChild;
 
        if (rightChild < heapsize && array[rightChild] > array[largest])
            largest = rightChild;
 
        if (largest != currentRoot) {
            int swap = array[currentRoot];
            array[currentRoot] = array[largest];
            array[largest] = swap;
 
            heapify(array, heapsize, largest);
        }
    }
}