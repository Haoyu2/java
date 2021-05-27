package lambda;

import java.util.Comparator;

public class Demo {
    public static void main(String[] args) {
    /*
    * A comparator interface is used to order the objects of user-defined classes.
    * A comparator object is capable of comparing two objects of two different classes.
    *
    * Using lambda expression to instantiate an interface
    *
    * And a lambda expression can only implements an interface with a single abstract method
    *
    *
    * */
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        stringComparator.compare("AB", "CD");
        Comparator<String> stringComparatorLambda = (String o1, String o2) -> o1.compareTo(o2);
    }
}
