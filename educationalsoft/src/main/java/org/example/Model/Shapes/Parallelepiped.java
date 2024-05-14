package org.example.Model.Shapes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;
@XmlRootElement(name = "parallelepiped")
@XmlAccessorType(XmlAccessType.FIELD)
public class Parallelepiped extends Shapes{
    @XmlElement
    public int x, y, width, height, depth, shiftX, shiftY;
    @XmlJavaTypeAdapter(PointAdapter.class)
    public Point[] parallelepipedPoints;

    public Parallelepiped(){}
    public Parallelepiped(int x, int y, int width, int height, int depth, int shiftX, int shiftY, Color color) {
        super("Parallelepiped", color);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.shiftX = shiftX;
        this.shiftY = shiftY;
        parallelepipedPoints = getParallelepipedPoints();
    }

    private Point[] getParallelepipedPoints() {
        Point[] points = new Point[8];
        // First cube
        points[0] = new Point(x, y);
        points[1] = new Point(x + width, y);
        points[2] = new Point(x + width, y + height);
        points[3] = new Point(x, y + height);
        // Second cube
        points[4] = new Point(x + shiftX, y + shiftY);
        points[5] = new Point(x + width + shiftX, y + shiftY);
        points[6] = new Point(x + width + shiftX, y + height + shiftY);
        points[7] = new Point(x + shiftX, y + height + shiftY);
        return points;
    }

    public void drawParallelepiped(Graphics g) {
        g.setColor(color);
        // Draw first cube
        g.drawRect(x, y, width, height);
        // Draw second cube
        g.drawRect(x + shiftX, y + shiftY, width, height);
        // Draw connecting lines
        for (int i = 0; i < 4; i++) {
            g.drawLine(parallelepipedPoints[i].x, parallelepipedPoints[i].y,
                    parallelepipedPoints[i + 4].x, parallelepipedPoints[i + 4].y);
        }
    }
}
