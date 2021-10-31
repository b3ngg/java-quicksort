public class Quicksort {
    /**
     * Optional entry function to prevent side effects (pure function) and simplify
     * the API.
     * 
     * @param input The Array to sort
     * @return Sorted copy of the array
     */
    public static int[] sort(int[] input) {
        if (input.length < 2)
            return input;

        int[] output = input.clone();
        qs(output, 0, output.length - 1);
        return output;
    }

    /**
     * Recursive function to divide the current partition and call the function
     * again on these partitions. The position for the division is calculated by the
     * partition function. Base case: The left and right indexes are equal, so there
     * is nothing more to divide.
     * 
     * @param array Target array
     * @param left  Beginning of the partition
     * @param right End of the partition
     * @see partition
     */
    public static void qs(int[] array, int left, int right) {
        if (left >= right)
            return;

        int partitionIndex = partition(array, left, right);

        qs(array, left, partitionIndex - 1);
        qs(array, partitionIndex + 1, right);
    }

    /**
     * Partition the array and return the partition index.
     * 
     * @param array Target array
     * @param left  Start index
     * @param right End index
     * @return The partition index
     */
    private static int partition(int[] array, int left, int right) {
        int pivotValue = array[right];
        int partitionIndex = left - 1;
        for (int i = left; i < right; i++) {
            if (array[i] >= pivotValue)
                continue;

            partitionIndex++;
            swap(array, partitionIndex, i);
        }

        swap(array, partitionIndex + 1, right);

        return partitionIndex + 1;
    }

    /**
     * Helper function to swap two integers in an array.
     * 
     * @param array Target array
     * @param a     Index of the first value
     * @param b     Index of the second value
     */
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
