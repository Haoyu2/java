package divideandconquer;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestPair {

    public static Point2D[] brute(Point2D[] points) {
        Point2D[] res = new Point2D[2];
        double delta = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double cur = Math.abs(points[i].distanceTo(points[j]));
                if ( cur < delta) {
                    res[0] = points[i];
                    res[1] = points[j];
                    delta = cur;
                }
            }
        }
        return res;
    }

    public static Point2D[] get(Point2D[] points) {

        Arrays.sort(points, (p1, p2) -> Double.compare(p1.x(), p2.x()));

        Point2D[] res = new Point2D[2];
        double[] dises = new double[points.length];
        Arrays.fill(dises, Double.MAX_VALUE);
        for (int l = 1; l < points.length; l += l) {
            for (int i = 0; i < points.length - l; i += l + l) {
                combine_each_side(points, i, Math.min(i + l + l - 1, points.length), i + l, dises, res);
            }
        }
        return res;
    }

    private static void combine_each_side(Point2D[] points, int lo, int hi, int mid, double[] dises, Point2D[] res) {

        double delta = Math.min(dises[lo], dises[mid]);
        double vert = points[mid].x();

        List<Point2D> ps_combine = new ArrayList<>();
        for (Point2D point : points) {
            if (Math.abs(point.x() - vert) < delta) ps_combine.add(point);
        }

        Collections.sort(ps_combine, (p1, p2) -> Double.compare(p1.y(), p2.y()));
        for (int i = 0; i < ps_combine.size(); i++) {
            for (int j = i + 1; j < Math.min(i+8, ps_combine.size()); j++) {
                double cur_dis = ps_combine.get(i).distanceSquaredTo(ps_combine.get(j));
                if (cur_dis < delta){
                    delta = cur_dis;
                    res[0] = ps_combine.get(i);
                    res[1] = ps_combine.get(j);
                }
            }
        }
        dises[lo] = delta;
    }

    public static Point2D[] points(int num) {
        Point2D[] points = new Point2D[num];
        for (int i = 0; i < num; i++) {
            points[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
        }
        return points;
    }


    public static void main(String[] args) {
        Point2D[] points = points(StdRandom.uniform(20, 100));
        System.out.println(Arrays.toString(points));
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setScale(-.05, 1.1);

        while (true) {
            if (StdDraw.isKeyPressed(KeyEvent.VK_N))
                // Press "n" to create new points
                points = points(StdRandom.uniform(20, 100));
            StdDraw.clear();

            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.setPenRadius(0.02);
            Point2D[] closet_pair = get(points);
            for(Point2D point : closet_pair) point.draw();

            StdDraw.setPenRadius(0.005);
            StdDraw.line(closet_pair[0].x(), closet_pair[0].y(), closet_pair[1].x(), closet_pair[1].y());
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.setPenRadius(0.015);
            Point2D[] closestb = brute(points);
            for (Point2D point2D : closestb) point2D.draw();


            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(0.01);
//            System.out.println(Arrays.toString(points));
            for (Point2D point : points) point.draw();

            StdDraw.setPenColor(StdDraw.BLUE);
            Font font = new Font("Arial", Font.BOLD, 30);
            StdDraw.setFont(font);
            StdDraw.setPenRadius(0.05);
            StdDraw.text(0.5, 1.05, "N:" + points.length + "  Dis:"
                    + closet_pair[0].distanceTo(closet_pair[1]));


            StdDraw.show();
            StdDraw.pause(40);

        }

    }
}
