package aoa;

import array_demo.All_Subsequences;
import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DoublingTest {
    public static Integer[] array(int n){
        Random rand = new Random(); // creating Random object
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt();
        }
        return a;
    }
    public static int[] toArray(Integer[] list){
        int[] res = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            res[i] = list[i];
        }
        return res;
    }

    public static double[] toArray(List<Double> list){
        double[] res = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }



    public static double linearTest(){
        List<Double> xs = new ArrayList<>(), ys = new ArrayList<>();
        double duration = 0.0;
        for (int n = 10; true; n += n) {
            Stopwatch timer = new Stopwatch();
            LinearTime.average(array(n));
            duration = timer.elapsedTime();
            if (duration >= 0.1) {
                xs.add( Math.log(n));
                ys.add(Math.log(duration));
                System.out.println("n:\t" + n + "\ttime:\t" + duration);
                if (duration > 10) break;
            }
        }

        LinearRegression linearRegression = new LinearRegression(toArray(xs), toArray(ys));
        return linearRegression.slope();
    }
    public static double linearArithmeticTest(){
        List<Double> xs = new ArrayList<>(), ys = new ArrayList<>();
        double duration = 0.0;
        for (int n = 10; true; n += n) {
            Stopwatch timer = new Stopwatch();
            Merge.sort(array(n));
            duration = timer.elapsedTime();
            if (duration >= 0.1) {
                xs.add( Math.log(n));
                ys.add(Math.log(duration));
                System.out.println("n:\t" + n + "\ttime:\t" + duration);
                if (duration > 10) break;
            }
        }

        LinearRegression linearRegression = new LinearRegression(toArray(xs), toArray(ys));
        return linearRegression.slope();
    }

    public static double quadranticTest(){
        List<Double> xs = new ArrayList<>(), ys = new ArrayList<>();
        double duration = 0.0;
        for (int n = 10; true; n += n) {
            Stopwatch timer = new Stopwatch();
            Selection.sort(array(n));
            duration = timer.elapsedTime();
            if (duration >= 0.1) {
                xs.add( Math.log(n));
                ys.add(Math.log(duration));
                System.out.println("n:\t" + n + "\ttime:\t" + duration);
                if (duration > 10) break;
            }
        }

        LinearRegression linearRegression = new LinearRegression(toArray(xs), toArray(ys));
        return linearRegression.slope();
    }


    public static double cubicTest(){
        List<Double> xs = new ArrayList<>(), ys = new ArrayList<>();
        double duration = 0.0;
        for (int n = 10; true; n += n) {
            Stopwatch timer = new Stopwatch();
            ThreeSum.count(toArray(array(n)));
            duration = timer.elapsedTime();
            if (duration >= 0.1) {
                xs.add( Math.log(n));
                ys.add(Math.log(duration));
                System.out.println("n:\t" + n + "\ttime:\t" + duration);
                if (duration > 10) break;
            }
        }

        LinearRegression linearRegression = new LinearRegression(toArray(xs), toArray(ys));
        return linearRegression.slope();
    }

    public static double quadraticArithmeticTest(){
        List<Double> xs = new ArrayList<>(), ys = new ArrayList<>();
        double duration = 0.0;
        for (int n = 10; true; n += n) {
            Stopwatch timer = new Stopwatch();
            ThreeSumFast.count(toArray(array(n)));
            duration = timer.elapsedTime();
            if (duration >= 0.1) {
                xs.add( Math.log(n));
                ys.add(Math.log(duration));
                System.out.println("n:\t" + n + "\ttime:\t" + duration);
                if (duration > 10) break;
            }
        }

        LinearRegression linearRegression = new LinearRegression(toArray(xs), toArray(ys));
        return linearRegression.slope();
    }

    public static double exponentialTest(){
        List<Double> xs = new ArrayList<>(), ys = new ArrayList<>();
        double duration = 0.0;
        for (int n = 2; true; n += n) {
            Stopwatch timer = new Stopwatch();
//            All_Subsequences.all(toArray(array(n)));
            ExponentialTime.cascading(toArray(array(n)));
            duration = timer.elapsedTime();
            System.out.println("n:\t" + n + "\ttime:\t" + duration);
            if (duration >= 0.1) {
                xs.add( Math.log(n));
                ys.add(Math.log(duration));
                System.out.println("n:\t" + n + "\ttime:\t" + duration);
                if (duration > 10) break;
            }
        }

        LinearRegression linearRegression = new LinearRegression(toArray(xs), toArray(ys));
        return linearRegression.slope();
    }


    public static void main(String[] args) {
//        System.out.println(Arrays.toString(array(10)));
//        System.out.println(linearTest());
//        System.out.println(linearArithmeticTest());
        System.out.println(quadranticTest());
//        System.out.println(cubicTest());
//        System.out.println(quadraticArithmeticTest());
//        System.out.println(exponentialTest());
    }
}
