package org.example.Model.Shapes;

import java.awt.*;

public class PyramidTrunk {
    private int x, y, width, height, shiftX, shiftY, upperWidth;
    private Point[] lowerPyramidPoints;
    private Point[] upperPyramidPoints;
    private Color color;

    public PyramidTrunk(int x, int y, int width, int height, int shiftX, int shiftY, int upperWidth, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shiftX = shiftX;
        this.shiftY = shiftY;
        this.upperWidth = upperWidth;
        this.color = color;
        lowerPyramidPoints = getPyramidPoints(x, y, width, height);
        upperPyramidPoints = getPyramidPoints(x + (width - upperWidth) / 2, y - height, upperWidth, height);
    }

    private Point[] getPyramidPoints(int x, int y, int width, int height) {
        Point[] points = new Point[5];
        // Vertices of the base square
        points[0] = new Point(x, y);
        points[1] = new Point(x + width, y);
        points[2] = new Point(x + width, y + height);
        points[3] = new Point(x, y + height);
        // Apex of the pyramid
        points[4] = new Point(x + width / 2, y - height);
        return points;
    }

    public void drawPyramidTrunk(Graphics g) {
        g.setColor(color);
        // Draw lower pyramid
        drawPyramid(g, lowerPyramidPoints);
        // Draw upper pyramid
        drawPyramid(g, upperPyramidPoints);
        // Draw connecting lines between corresponding vertices of upper and lower pyramids
        for (int i = 0; i < 4; i++) {
            g.drawLine(lowerPyramidPoints[i].x, lowerPyramidPoints[i].y, upperPyramidPoints[i].x, upperPyramidPoints[i].y);
        }
    }

    private void drawPyramid(Graphics g, Point[] points) {
        // Draw the base square
        g.drawLine(points[0].x, points[0].y, points[1].x, points[1].y);
        g.drawLine(points[1].x, points[1].y, points[2].x, points[2].y);
        g.drawLine(points[2].x, points[2].y, points[3].x, points[3].y);
        g.drawLine(points[3].x, points[3].y, points[0].x, points[0].y);
        // Draw the edges from each vertex of the base square to the apex
        for (int i = 0; i < 4; i++) {
            g.drawLine(points[i].x, points[i].y, points[4].x, points[4].y);
        }
    }
}
