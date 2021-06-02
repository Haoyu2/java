package functional_interface;

public interface PPrint {
    public void print(String msg);

    public static void main(String[] args) {
        PPrint banner_print = msg ->
                System.out.println("====================\n"
                        + msg + "\n====================\n");
        banner_print.print("Hello World!");


        //without the lambda expression to impplement an interface in line
        // or to write a separate implementation
        PPrint banner_print1 = new PPrint() {
            @Override
            public void print(String msg) {
                System.out.println("====================\n"
                        + msg + "\n====================\n");
            }
        };
        banner_print1.print("Hello World!");

        Banner_Print banner_print2 = new Banner_Print();
        banner_print2.print("Hello World!");

    }
}
