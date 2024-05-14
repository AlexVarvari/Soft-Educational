package org.example.Model.Shapes;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;

@XmlRootElement(name = "shapes")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Cube.class, Parallelepiped.class})
public abstract class Shapes {
    @XmlElement(name = "shapeName")
    private String shapeName;

    @XmlJavaTypeAdapter(ColorAdapter.class)
    protected Color color;

    // Constructor
    public Shapes(String shapeName, Color color) {
        this.shapeName = shapeName;
        this.color = color;
    }
    public Shapes(){}

    // Abstract method for drawing the shape

    // Getters and setters if necessary
    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}