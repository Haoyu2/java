package functional_interface;

import java.util.Comparator;

public class Lambda {
    public static void main(String[] args) {
    /*
    * A comparator interface is used to order the objects of user-defined classes.
    * A comparator object is capable of comparing two objects of two different classes.
    *
    * Using interfacedemo.lambda expression to instantiate an interface
    *
    * And a interfacedemo.lambda expression can only implements an interface with a single abstract method
    *
    *
    * */
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(stringComparator.compare("AB", "CD"));
        Comparator<String> stringComparatorLambda = (String o1, String o2) -> o1.compareTo(o2);
        System.out.println(stringComparatorLambda.compare("AB", "CD"));


    }
}
