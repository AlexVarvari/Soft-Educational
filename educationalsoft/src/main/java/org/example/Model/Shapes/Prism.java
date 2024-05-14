package org.example.Model.Shapes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.awt.*;
@XmlRootElement(name = "prism")
@XmlAccessorType(XmlAccessType.FIELD)
public class Prism extends Shapes{
    private int x, y, width, height, depth, shiftX, shiftY;
    private Point[] prismPoints;

    public Prism(int x, int y, int width, int height, int depth, int shiftX, int shiftY, Color color) {
        super("Prism", color);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.shiftX = shiftX;
        this.shiftY = shiftY;
        this.color = color;
        prismPoints = getPrismPoints();
    }

    private Point[] getPrismPoints() {
        Point[] points = new Point[12];
        // Bottom face - triangle
        points[0] = new Point(x, y + height);
        points[1] = new Point(x + width, y + height);
        points[2] = new Point(x + width / 2 + shiftX, y + shiftY);
        // Top face - triangle
        points[3] = new Point(x + depth, y + height + depth);
        points[4] = new Point(x + width + depth, y + height + depth);
        points[5] = new Point(x + width / 2 + shiftX + depth, y + shiftY + depth);
        // Connecting lines
        points[6] = points[0];
        points[7] = points[3];
        points[8] = points[1];
        points[9] = points[4];
        points[10] = points[2];
        points[11] = points[5];
        return points;
    }

    public void drawPrism(Graphics g) {
        g.setColor(color);
        // Draw bottom face - triangle
        g.drawPolygon(new Polygon(new int[]{x, x + width, x + width / 2 + shiftX},
                new int[]{y + height, y + height, y + shiftY}, 3));
        // Draw top face - triangle
        g.drawPolygon(new Polygon(new int[]{x + depth, x + width + depth, x + width / 2 + shiftX + depth},
                new int[]{y + height + depth, y + height + depth, y + shiftY + depth}, 3));
        // Draw connecting lines
        g.drawLine(prismPoints[0].x, prismPoints[0].y, prismPoints[3].x, prismPoints[3].y);
        g.drawLine(prismPoints[1].x, prismPoints[1].y, prismPoints[4].x, prismPoints[4].y);
        g.drawLine(prismPoints[2].x, prismPoints[2].y, prismPoints[5].x, prismPoints[5].y);
    }

}
