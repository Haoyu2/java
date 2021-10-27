package collections_interface;

import java.util.Arrays;
import java.util.Comparator;

public class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Student that) {
        return this.id - that.id;
    }

    public static class ReverseIDComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return -o1.compareTo(o2);
        }
    }

    public static class ByName implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.name.compareTo(o2.name);
        }
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student(1, "John"),
                new Student(3, "Mike"),
                new Student(2, "Alec"),
        };

        System.out.println(Arrays.toString(students));

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));



        Arrays.sort(students, new Student.ReverseIDComparator());
        System.out.println(Arrays.toString(students));
        Arrays.sort(students, new Student.ByName());
        System.out.println(Arrays.toString(students));



        /*
        *  In line comparator
        *  Reversing
        *  Before Java 8, sorting a array would involve creating an
        *  anonymous inner class for the Comparator used in the sort:
        * */
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(students));


        /*
        * With the introduction of Lambdas, we can now bypass the
        * anonymous inner class and achieve the same result with
        * simple, functional semantics:
        *
        * */
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        Arrays.sort(students, (s1, st2)-> -s1.id - st2.id);
        System.out.println(Arrays.toString(students));
        Arrays.sort(students, (s1, st2)-> s1.name.compareTo(st2.name));
        System.out.println(Arrays.toString(students));

        /*
        *   There is more to this, you can find more tutorial online
        *
        * */




    }
}
