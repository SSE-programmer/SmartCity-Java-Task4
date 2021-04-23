import java.awt.*;
import java.util.ArrayList;

public class FindingAreas {
    private static double areaOfATriangle(Point a, Point b, Point c) {
        double area = Math.abs((a.getX() - c.getX()) * (b.getY() - a.getY()) -
                (a.getX() - b.getX()) * (c.getY() - a.getY())) * 0.5;

        return area;
    }

    private static double findMaxArea(ArrayList<ArrayList<Point>> combinationsOfPoints) {
        double[] results = new double[combinationsOfPoints.size()];

        int index = 0;
        double max = 0.0;

        for (int i = 0; i < results.length; i++) {
            results[i] = areaOfATriangle(
                    combinationsOfPoints.get(i).get(0),
                    combinationsOfPoints.get(i).get(1),
                    combinationsOfPoints.get(i).get(2));

            if (results[i] > max) {
                max = results[i];
                index = i;
            }
        }

        System.out.println("\nСледующие точки образуют треугольник максимальной площади (" + max + "):");
        for (int i = 0; i < 3; i++) {
            System.out.print("[" + combinationsOfPoints.get(index).get(i).getX() + ", " +
                    combinationsOfPoints.get(index).get(i).getY() + "]\t");
        }

        System.out.println("\nИх индекс в таблице комбинаций: " + (index + 1));

        return max;
    }

    /*Не искал алгоритм для решения, реализовал одну из первых своих идей*/
    /*Уверен, есть алгоримы гораздо эффективнее :D */
    public static void main(String[] args) {
        SetOfPoints setOfPoints = new SetOfPoints();

        for (int i = 0; i < 10; i++)
        {
            setOfPoints.addRandomPoint(500, 500);
        }

        setOfPoints.removeDublicatePoints();
        setOfPoints.printSetOfPoints();
        setOfPoints.calculateСombinations();

        findMaxArea(setOfPoints.getCombinationsOfPoints());
    }
}
