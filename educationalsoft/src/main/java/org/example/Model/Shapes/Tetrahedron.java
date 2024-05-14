package org.example.Model.Shapes;

import java.awt.*;

public class Tetrahedron {
    private int x, y, width, height, shiftX, shiftY;
    private Point[] tetrahedronPoints;
    private Color color;

    public Tetrahedron(int x, int y, int width, int height, int shiftX, int shiftY, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shiftX = shiftX;
        this.shiftY = shiftY;
        this.color = color;
        tetrahedronPoints = getTetrahedronPoints();
    }

    public Tetrahedron(int x, int y, int width, int height, Color red) {
    }

    private Point[] getTetrahedronPoints() {
        Point[] points = new Point[4];
        // Vertices of the base triangle
        points[0] = new Point(x, y + height);
        points[1] = new Point(x + width, y + height);
        points[2] = new Point(x + width / 2 + shiftX, y + shiftY);
        // Apex of the tetrahedron
        points[3] = new Point(x + width / 2, y - height);
        return points;
    }

    public void drawTetrahedron(Graphics g) {
        g.setColor(color);
        // Draw the base triangle
        g.drawLine(tetrahedronPoints[0].x, tetrahedronPoints[0].y, tetrahedronPoints[1].x, tetrahedronPoints[1].y);
        g.drawLine(tetrahedronPoints[1].x, tetrahedronPoints[1].y, tetrahedronPoints[2].x, tetrahedronPoints[2].y);
        g.drawLine(tetrahedronPoints[2].x, tetrahedronPoints[2].y, tetrahedronPoints[0].x, tetrahedronPoints[0].y);
        // Draw the edges from the base vertices to the apex
        g.drawLine(tetrahedronPoints[0].x, tetrahedronPoints[0].y, tetrahedronPoints[3].x, tetrahedronPoints[3].y);
        g.drawLine(tetrahedronPoints[1].x, tetrahedronPoints[1].y, tetrahedronPoints[3].x, tetrahedronPoints[3].y);
        g.drawLine(tetrahedronPoints[2].x, tetrahedronPoints[2].y, tetrahedronPoints[3].x, tetrahedronPoints[3].y);
    }
}
