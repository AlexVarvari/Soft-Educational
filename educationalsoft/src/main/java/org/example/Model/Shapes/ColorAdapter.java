package org.example.Model.Shapes;

import java.awt.Color;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ColorAdapter extends XmlAdapter<String, Color> {
    @Override
    public Color unmarshal(String value) {
        return new Color(Integer.parseInt(value.substring(1), 16));
    }

    @Override
    public String marshal(Color value) {
        return "#" + Integer.toHexString(value.getRGB()).substring(2).toUpperCase();
    }
}