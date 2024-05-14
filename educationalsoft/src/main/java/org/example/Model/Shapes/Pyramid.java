package org.example.Model.Shapes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.awt.*;
@XmlRootElement(name = "pyramid")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pyramid extends Shapes{
    private int x, y, width, height, shiftX, shiftY;
    private Point[] pyramidPoints;

    public Pyramid(int x, int y, int width, int height, int shiftX, int shiftY, Color color) {
        super("Prism", color);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shiftX = shiftX;
        this.shiftY = shiftY;
        pyramidPoints = getPyramidPoints();
    }

    private Point[] getPyramidPoints() {
        Point[] points = new Point[5];
        // Bottom face - square
        points[0] = new Point(x, y);
        points[1] = new Point(x + width, y);
        points[2] = new Point(x + width, y + height);
        points[3] = new Point(x, y + height);
        // Top point
        points[4] = new Point(x + width / 2, y + shiftY);
        return points;
    }

    public void drawPyramid(Graphics g) {
        g.setColor(color);
        // Draw bottom face - square
        g.drawRect(x, y, width, height);
        // Draw connecting lines
        g.drawLine(pyramidPoints[0].x, pyramidPoints[0].y, pyramidPoints[4].x, pyramidPoints[4].y);
        g.drawLine(pyramidPoints[1].x, pyramidPoints[1].y, pyramidPoints[4].x, pyramidPoints[4].y);
        g.drawLine(pyramidPoints[2].x, pyramidPoints[2].y, pyramidPoints[4].x, pyramidPoints[4].y);
        g.drawLine(pyramidPoints[3].x, pyramidPoints[3].y, pyramidPoints[4].x, pyramidPoints[4].y);
    }
}
