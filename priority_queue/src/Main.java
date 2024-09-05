// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

// Test that sorting in ascending order works.
        Random r = new Random();
        int[] ints = new int[10];
        for (int i = 0; i < 10; i++)
            ints[i] = r.nextInt(100);
        int[] input = Arrays.copyOf(ints, ints.length);
        PriorityQueueSorter.sort (ints, PriorityQueueSorter.ASCENDING_ORDER);
        boolean sorted = true;
        for (int i = 0; i < ints.length-1; i++)
            if (ints[i] > ints[i+1]) {
                sorted = false;
                break;
            }
        if (sorted)
            System.out.println("Array is sorted.");
        else {
            System.out.println("Error: array not sorted in ascending order.");
            System.out.println("Input: " + Arrays.toString(input));
            System.out.println("Output: " + Arrays.toString(ints));
        }
        /////////////////////////////
        Random r = new Random();
        int[] ints = new int[10];
        for (int i = 0; i < 10; i++)
            ints[i] = r.nextInt(100);
        int[] input = Arrays.copyOf(ints, ints.length);
        PriorityQueueSorter.sort (ints, PriorityQueueSorter.DESCENDING_ORDER);
        boolean sorted = true;
        for (int i = 0; i < ints.length-1; i++)
            if (ints[i] < ints[i+1]) {
                sorted = false;
                break;
            }
        if (sorted)
            System.out.println("Array is sorted.");
        else {
            System.out.println("Error: array not sorted in ascending order.");
            System.out.println("Input: " + Arrays.toString(input));
            System.out.println("Output: " + Arrays.toString(ints));
        }
    }
}