package recursion;

public class Recursion {
    public static int find(int[] arr, int target) {
        return find(arr, target, 0);
    }

    public static int find(int[] arr, int target, int i) {
        if (i == arr.length) return -1;
        if (arr[i] == target) return i;
        return find(arr, target, i + 1);
    }

    public static int binary_search(int[] arr, int target) {
        return binary_search(arr, target, 0, arr.length);
    }

    public static int binary_search(int[] arr, int target, int i, int j) {

        if (i >= j) return -1;
        int mid = (i + j) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] < target) i = mid + 1;
        else j = mid - 1;
        return binary_search(arr, target, i, j);
    }


    public static int bisect_right(int[] arr, int target) {
        return bisect_right(arr, target, 0, arr.length);
    }

    public static int bisect_right(int[] arr, int target, int i, int j) {

        if (i == j) return i;
        int mid = (i + j) / 2;
        if (arr[mid] <= target) i = mid + 1;
        else j = mid;
        return bisect_right(arr, target, i, j);
    }


    public static void main(String[] args) {
        System.out.println(find(new int[]{1, 2, 3}, 3));
        System.out.println(find(new int[]{1, 2, 3}, 4));

        System.out.println(binary_search(new int[]{1, 2, 2, 3}, 4));
        System.out.println(binary_search(new int[]{1, 2, 2, 3}, 2));
        System.out.println(binary_search(new int[]{1, 2, 2, 3}, 0));

        System.out.println(bisect_right(new int[]{1, 2, 2, 3}, 4));
        System.out.println(bisect_right(new int[]{1, 2, 2, 3}, 2));
        System.out.println(bisect_right(new int[]{1, 2, 2, 3}, 0));
        Recursion recursion = new Recursion();
        System.out.println(recursion.toString());
    }
}
