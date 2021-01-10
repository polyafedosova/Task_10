package ru.vsu.fedosova;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Object> listPoints = readCoordinatesFromFile(readFile());

        if (listPoints == Collections.emptyList()) {
            System.out.println("Error! You entered the coordinates incorrectly");
        } else {
            Triangle triangleMinP = findTriangleWithMinP(listPoints);
            if (triangleMinP.getP() == 0) {
                System.out.println("Error! There is no triangle for the entered vertices");
            } else {
                writeFile(triangleMinP);
            }
        }
    }

    private static String readFile() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the full path to the file containing the coordinates");
        String pathInputFile = scanner1.nextLine();
        File inputFile = new File(pathInputFile);
        try
        {
            scanner1 = new Scanner(inputFile);
        } catch (FileNotFoundException fileNotFoundException)
        {
            System.out.println("File not found");
        }
        return pathInputFile;
    }

    public static List<Object> readCoordinatesFromFile(String fileName)
    {
        try {
            return toListWithPoints(readLinesFromFile(fileName));
        } catch (FileNotFoundException e)
        {
            return null;
        }
    }

    public static String[] readLinesFromFile(String fileName) throws FileNotFoundException
    {
        List<String> lines;
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8"))
        {
            lines = new ArrayList<>();
            while (scanner.hasNext())
            {
                lines.add(scanner.nextLine());
            }
        }
        return lines.toArray(new String[0]);
    }

    public static List<Object> toListWithPoints(String[] lines)
    {
        List<Object> listPoints = new ArrayList<>();
        for (int r = 0; r < lines.length; r++)
        {
            String namePoint = "Point" + (1 + r);
            double[] coordinates = toDoubleArray(lines[r]);
            if (checkCoordinates(coordinates) == false) {
                return Collections.emptyList();
            }
            Point point = new Point(namePoint, coordinates[0], coordinates[1]);
            listPoints.add(point);
        }
        return listPoints;
    }

    public static double[] toDoubleArray(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("(\\s|[,;])+");
        List<Double> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextDouble());
        }
        Double[] arr = list.toArray(new Double[0]);

        return toPrimitive(arr);
    }

    public static double[] toPrimitive(Double[] arr) {
        if (arr == null) {
            return null;
        }
        double[] result = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static Triangle findTriangleWithMinP(List<Object> listPoints)
    {
        Triangle triangle = new Triangle(new Point("A", 0, 0), new Point("B", 0, 0), new Point("C", 0, 0), 0);
        for (int i = 0; i < listPoints.size() - 2; i++) {
            for (int j = i + 1; j < listPoints.size() - 1; j++) {
                for (int k = j + 1; k < listPoints.size(); k++) {
                    Point pointA = (Point) listPoints.get(i);
                    Point pointB = (Point) listPoints.get(j);
                    Point pointC = (Point) listPoints.get(k);
                    double P = calcP(pointA, pointB, pointC);
                    if (i == 0 || P < triangle.getP()) {
                        triangle.setA(pointA);
                        triangle.setB(pointB);
                        triangle.setC(pointC);
                        triangle.setP(P);
                    }
                }
            }
        }
        return triangle;
    }

    public static double calcP(Point pointA, Point pointB, Point pointC)
    {
        return Math.sqrt(Math.pow((pointB.getX() - pointA.getX()), 2) + Math.pow((pointB.getY() - pointA.getY()), 2)) +
            Math.sqrt(Math.pow((pointC.getX() - pointA.getX()), 2) + Math.pow((pointC.getY() - pointA.getY()), 2)) +
            Math.sqrt(Math.pow((pointC.getX() - pointB.getX()), 2) + Math.pow((pointC.getY() - pointB.getY()), 2));
    }

    public static void writeFile(Triangle triangleMinP)
    {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter the full path to the file where you want to save the tops of triangle");
        String pathOutputFile = scanner2.nextLine();
        File outputFile = new File(pathOutputFile);
        try
        {
            scanner2 = new Scanner(outputFile);
            writeArrayToFile(pathOutputFile, triangleMinP.getA(), triangleMinP.getB(), triangleMinP.getC());
        } catch (FileNotFoundException fileNotFoundException)
        {
            System.out.println("File not found");
        }
    }

    public static void writeArrayToFile(String fileName, Point pointA, Point pointB, Point pointC)
            throws FileNotFoundException
    {
        try (PrintWriter out = new PrintWriter(fileName))
        {
            out.println("A: " + pointA.getNamePoint() + " (" + pointA.getX() + "; " + pointA.getY() + ")");
            out.println("B: " + pointB.getNamePoint() + " (" + pointB.getX() + "; " + pointB.getY() + ")");
            out.println("C: " + pointC.getNamePoint() + " (" + pointC.getX() + "; " + pointC.getY() + ")");
        }
    }

    public static boolean checkCoordinates(double[] coordinates) {
        if (coordinates.length != 2) {
            return false;
        } else return true;
    }

}
