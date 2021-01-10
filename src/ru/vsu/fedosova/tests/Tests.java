package ru.vsu.fedosova.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.fedosova.Main;
import ru.vsu.fedosova.Point;
import ru.vsu.fedosova.Triangle;
import java.lang.Object;

import java.util.List;
import static ru.vsu.fedosova.Main.findTriangleWithMinP;


public class Tests {

    @Test
    public void test1()
    {
        List<Object> listPoints = Main.readCoordinatesFromFile("test1.txt");
        Triangle expectedTriangleMin = findTriangleWithMinP(listPoints);
        String expectedA = expectedTriangleMin.getA().getNamePoint();
        String expectedB = expectedTriangleMin.getB().getNamePoint();
        String expectedC = expectedTriangleMin.getC().getNamePoint();

        String actualA = "Point2";
        String actualB = "Point3";
        String actualC = "Point6";

        Assert.assertEquals(expectedA, actualA);
        Assert.assertEquals(expectedA, actualA);
        Assert.assertEquals(expectedB, actualB);
        Assert.assertEquals(expectedC, actualC);
    }

    @Test
    public void test2()
    {
        List<Object> listPoints = Main.readCoordinatesFromFile("test2.txt");
        Triangle expectedTriangleMin = findTriangleWithMinP(listPoints);
        String expectedA = expectedTriangleMin.getA().getNamePoint();
        String expectedB = expectedTriangleMin.getB().getNamePoint();
        String expectedC = expectedTriangleMin.getC().getNamePoint();

        String actualA = "Point1";
        String actualB = "Point4";
        String actualC = "Point5";

        Assert.assertEquals(expectedA, actualA);
        Assert.assertEquals(expectedA, actualA);
        Assert.assertEquals(expectedB, actualB);
        Assert.assertEquals(expectedC, actualC);
    }

    @Test
    public void test3()
    {
        List<Object> listPoints = Main.readCoordinatesFromFile("test2.txt");
        Triangle expectedTriangleMin = findTriangleWithMinP(listPoints);
        String expectedA = expectedTriangleMin.getA().getNamePoint();
        String expectedB = expectedTriangleMin.getB().getNamePoint();
        String expectedC = expectedTriangleMin.getC().getNamePoint();

        String actualA = "Point1";
        String actualB = "Point4";
        String actualC = "Point5";

        Assert.assertEquals(expectedA, actualA);
        Assert.assertEquals(expectedA, actualA);
        Assert.assertEquals(expectedB, actualB);
        Assert.assertEquals(expectedC, actualC);
    }

    @Test
    public void test4()
    {
        List<Object> listPoints = Main.readCoordinatesFromFile("test2.txt");
        Triangle expectedTriangleMin = findTriangleWithMinP(listPoints);
        String expectedA = expectedTriangleMin.getA().getNamePoint();
        String expectedB = expectedTriangleMin.getB().getNamePoint();
        String expectedC = expectedTriangleMin.getC().getNamePoint();

        String actualA = "Point4";
        String actualB = "Point5";
        String actualC = "Point6";

        Assert.assertEquals(expectedA, actualA);
        Assert.assertEquals(expectedA, actualA);
        Assert.assertEquals(expectedB, actualB);
        Assert.assertEquals(expectedC, actualC);
    }

    @Test
    public void test5()
    {
        List<Object> listPoints = Main.readCoordinatesFromFile("test2.txt");
        Triangle expectedTriangleMin = findTriangleWithMinP(listPoints);
        String expectedA = expectedTriangleMin.getA().getNamePoint();
        String expectedB = expectedTriangleMin.getB().getNamePoint();
        String expectedC = expectedTriangleMin.getC().getNamePoint();

        String actualA = "Point3";
        String actualB = "Point4";
        String actualC = "Point5";

        Assert.assertEquals(expectedA, actualA);
        Assert.assertEquals(expectedA, actualA);
        Assert.assertEquals(expectedB, actualB);
        Assert.assertEquals(expectedC, actualC);
    }
}