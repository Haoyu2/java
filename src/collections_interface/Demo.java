package collections_interface;

public class Demo {
    static Iterable<Integer>[] iterables = new Iterable[]{
//            new ArrayList(){1,2,3},
    };

    public static void print_iter(Iterable<Integer>[] arr){
        for (Iterable<Integer> l : arr){
            for (int i : l) System.out.print(i + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {

//        System.out.println(ArrayList);

//        Iterable[] list = new iterables[0];
    }
}
