package algorithms.sort;

public class QuickSort {

    public static <T extends Comparable<T>> void of(T[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(array, start, end);
            of(array, start, pivotIndex - 1);
            of(array, pivotIndex + 1, end);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int start, int end) {
        T pivotValue = array[end];
        int pivotIndex = start;
        for (int i = start; i < end; i++) {
            if(array[i].compareTo(pivotValue) < 0) {
                swap(array, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(array, pivotIndex, end);
        return pivotIndex;
    }

    private static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index2];
        array[index2] = array[index1];
        array[index1] = temp;
    }
}
