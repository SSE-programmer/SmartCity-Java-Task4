import java.awt.Point;
import java.util.*;

public class SetOfPoints {
    private ArrayList<Point> points = new ArrayList<Point>();

    private ArrayList<ArrayList<Point>> combinationsOfPoints = new ArrayList<ArrayList<Point>>();

    public ArrayList<Point> getPoints() {
        return points;
    }

    public ArrayList<ArrayList<Point>> getCombinationsOfPoints() {
        return combinationsOfPoints;
    }
    public void addPoint(int x, int y) {
        Point p = new Point(x, y);

        points.add(p);
    }

    public void addRandomPoint(int width, int height) {
        Random rand = new Random();
        Point p = new Point(rand.nextInt(width), rand.nextInt(height));

        points.add(p);
    }

    public void removeAllPoints() {
        points.clear();
    }

    public void removeDublicatePoints() {
        Set<Point> tmp = new LinkedHashSet<Point>();
        for (Point p : points) tmp.add(p);
        points.clear();
        for (Point p : tmp) points.add(p);
    }

    public void printSetOfPoints() {
        int index = 0;

        System.out.println("\nМножество точек:");
        for (Point p : points) {
            System.out.print(++index + ")\t");
            System.out.println(p.toString());
        }
    }

    private void fillCombinations(ArrayList<Point> arr, int len, int startPosition, Point[] result) {
        if (len == 0) {
            ArrayList<Point> combination = new ArrayList<Point>();

            for (int i = 0; i < result.length; i++)
            {
                combination.add(result[i]);
            }
            combinationsOfPoints.add(combination);
            return;
        }
        for (int i = startPosition; i <= arr.size() - len; i++) {
            result[result.length - len] = arr.get(i);
            fillCombinations(arr, len - 1, i + 1, result);
        }
    }

    /*Поиск всех комбинаций точек без повтора*/
    public void calculateСombinations() {
        combinationsOfPoints.clear();
        fillCombinations(points, 3, 0, new Point[3]);

        int index = 0;

        System.out.println("\nКомбинации точек без повторений:");
        for (ArrayList<Point> row : combinationsOfPoints) {
            System.out.print(++index + ") ");
            for (Point p : row) {
                System.out.print("[" + p.getX() + ", " + p.getY() + "]\t");
            }
            System.out.println();
        }
    }
}
