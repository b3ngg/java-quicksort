
import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class QuicksortTest {
    int[][] testArrays = { { 2, 1, 3 }, { 5, 9, 2, 4, 7 }, { -2, 1000, 400, 20 }, { -1, -6, -8, -20 }, { 9, 6, 4, 2 },
            { 2, 5, 5, 2, 9, 9, 1, 1, 0, 0, 2 }, };

    @Test
    public void testOnTestArrays() {
        for (int[] testArray : testArrays) {
            int[] buildInSorted = Arrays.stream(testArray).sorted().toArray();
            int[] quickSorted = Quicksort.sort(testArray);
            assertArrayEquals(buildInSorted, quickSorted);
        }
    }

    @Test
    public void testOnRandomArrays() {
        for (int i = 0; i < 10; i++) {
            int[] testArray = generateRandomArray();
            int[] buildInSorted = Arrays.stream(testArray).sorted().toArray();
            int[] quickSorted = Quicksort.sort(testArray);
            assertArrayEquals(buildInSorted, quickSorted);
        }

    }

    private static int[] generateRandomArray() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < getRandomInRange(3, 100); i++) {
            list.add(getRandomInRange(-100, 100));
        }

        int[] array = list.stream().mapToInt(i -> i).toArray();
        return array;
    }

    private static int getRandomInRange(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
