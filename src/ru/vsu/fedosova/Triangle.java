package ru.vsu.fedosova;

public class Triangle
{
    private Point A;
    private Point B;
    private Point C;
    private double P;

    public Triangle (Point A, Point B, Point C, double P)
    {
        this.A = A;
        this.B = B;
        this.C = C;
        this.P = P;
    }

    public Point getA()
    {
        return A;
    }

    public Point getB()
    {
        return B;
    }

    public Point getC()
    {
        return C;
    }

    public double getP()
    {
        return P;
    }

    public void setA(Point A)
    {
        this.A = A;
    }

    public void setB(Point B)
    {
        this.B = B;
    }

    public void setC(Point C)
    {
        this.C = C;
    }

    public void setP(double P)
    {
        this.P = P;
    }
}
