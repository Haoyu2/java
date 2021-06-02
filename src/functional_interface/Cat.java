package functional_interface;

public class Cat implements Animal{
    @Override
    public void eat() {
        System.out.println("Cat eats cat food!");
    }

    @Override
    public void moving() {
        System.out.println("Cat jumps, runs and walking!");
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.eat();
        cat.moving();
    }
}
