package org.example.Model.Shapes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;
@XmlRootElement(name = "cube")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cube extends Shapes{
    @XmlElement
    public int x, y, size, shift;
    @XmlJavaTypeAdapter(PointAdapter.class)
    public Point[] cubeOnePoints;
    @XmlJavaTypeAdapter(PointAdapter.class)
    public Point[] cubeTwoPoints;
    public Cube() {
        super(); // Call to the no-arg constructor of Shapes
    }
    public Cube(int x, int y, int size, int shift, Color color) {
        super("Cube", color);
        this.x = x;
        this.y = y;
        this.size = size;
        this.shift = shift;
        cubeOnePoints = getCubeOnePoints();
        cubeTwoPoints = getCubeTwoPoints();
    }

    private Point[] getCubeOnePoints() {
        Point[] points = new Point[4];
        points[0] = new Point(x, y);
        points[1] = new Point(x + size, y);
        points[2] = new Point(x + size, y + size);
        points[3] = new Point(x, y + size);
        return points;
    }

    private Point[] getCubeTwoPoints() {
        int newX = x + shift;
        int newY = y + shift;
        Point[] points = new Point[4];
        points[0] = new Point(newX, newY);
        points[1] = new Point(newX + size, newY);
        points[2] = new Point(newX + size, newY + size);
        points[3] = new Point(newX, newY + size);
        return points;
    }

    public void drawCube(Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, size, size);
        g.drawRect(x + shift, y + shift, size, size);
        // draw connecting lines
        for (int i = 0; i < 4; i++) {
            g.drawLine(cubeOnePoints[i].x, cubeOnePoints[i].y, cubeTwoPoints[i].x, cubeTwoPoints[i].y);
        }
    }
}