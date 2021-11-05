import java.util.Random;

public class Utils {
    public static int[] randomIntArray(int len){
        Random rd = new Random(); // creating Random object
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt((int) 100); // storing random integers in an array
        }
        return arr;
    }

}
