package ru.vsu.fedosova;

public class Point
{
    private String namePoint;
    private double x;
    private double y;

    public Point(String namePoint, double x, double y)
    {
        this.namePoint = namePoint;
        this.x = x;
        this.y = y;
    }

    public String getNamePoint()
    {
        return namePoint;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }
}
