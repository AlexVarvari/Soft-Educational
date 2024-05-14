package org.example.Model.Shapes;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.awt.Point;

public class PointAdapter extends XmlAdapter<String, Point> {
    @Override
    public Point unmarshal(String v) throws Exception {
        String[] coords = v.split(",");
        return new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
    }

    @Override
    public String marshal(Point v) throws Exception {
        return v.x + "," + v.y;
    }
}