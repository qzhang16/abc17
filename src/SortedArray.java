import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {
    // write code here
    public static int[] getIntegers(int size) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[size];
        for (int i =0; i < size; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.toString(a);
        return a;
    }

    public static void printArray(int[] a) {
        for ( int i=0; i < a.length; i++) {
            System.out.format("Element %d contents %d\n", i, a[i]);
        }
    }

    public static int[] sortIntegers(int[] a) {
        int[] array = Arrays.copyOf(a, a.length);
        Arrays.sort(array);

        int maxIndex = array.length -1;
        int halfLength = array.length / 2;
        for(int i=0; i< halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex -i];
            array[maxIndex - i] = temp;
        }

        return array;


    }
}
