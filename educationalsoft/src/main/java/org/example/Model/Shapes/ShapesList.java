package org.example.Model.Shapes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "shapesList")
public class ShapesList {
    private List<Shapes> shapes;

    @XmlElement(name = "shape")
    public List<Shapes> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shapes> shapes) {
        this.shapes = shapes;
    }
}