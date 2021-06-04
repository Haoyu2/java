package array_demo;

public class Primitive_Object_Array_demo {
    public static void main(String[] args) {
        /*
        * Primitive array creation,
        * the elements are of primitive datatype.
        * so it does not have any methods,
        * so arr[0].compareTo(arr[1]) is syntactically wrong
        *
        * */
        int[] arr_primitive_types = new int[]{1, 2, 3};
        //arr_primitive_types[0].compareTo(arr_primitive_types[1]); // syntactically wrong

        /*
        * Object type array,
        * the elements are of object data type,
        * thus they enjoy all the methods that come with them.
        *  for example,
        *    arr_object_type[0].compareTo(arr_object_type[1]); // no problem
        *
        * */
        Integer[] arr_object_type = new Integer[]{1,2,3};
        arr_object_type[0].compareTo(arr_object_type[1]); // no problem

    }
}
