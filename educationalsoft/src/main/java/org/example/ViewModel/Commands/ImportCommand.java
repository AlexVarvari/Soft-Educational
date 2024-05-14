package org.example.ViewModel.Commands;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.example.Model.Shapes.Cube;
import org.example.Model.Shapes.Parallelepiped;
import org.example.Model.Shapes.Shapes;
import org.example.Model.Shapes.ShapesList;
import org.example.ViewModel.CanvasViewModel;

import java.awt.*;
import java.io.File;

public class ImportCommand implements ICommand{
    private CanvasViewModel vm;
    public ImportCommand(CanvasViewModel viewModel){
        this.vm = viewModel;
    }
    @Override
    public void execute() {
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(ShapesList.class, Cube.class, Parallelepiped.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            ShapesList shapeList = (ShapesList) jaxbUnmarshaller.unmarshal(new File("C:\\Users\\User\\Desktop\\PSExport\\shapes.xml"));
            this.vm.view.contentPane.setBackground(Color.WHITE);
            for (Shapes shape : shapeList.getShapes()) {
                if (shape instanceof Cube) {
                    ((Cube) shape).drawCube(this.vm.view.getGraphics());
                }
                else if (shape instanceof Parallelepiped){
                    ((Parallelepiped) shape).drawParallelepiped(this.vm.view.getGraphics());
                }
            }
        }catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
