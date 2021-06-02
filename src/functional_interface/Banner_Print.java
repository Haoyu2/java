package functional_interface;


public class Banner_Print implements PPrint{
    @Override
    public void print(String msg) {
        System.out.println("This is a seperate Implemation\n" + msg);
    }
}
