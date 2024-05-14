package org.example.ViewModel.Commands;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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

import java.io.File;

public class ExportCommand implements ICommand{
    private CanvasViewModel vm;
    public ExportCommand(CanvasViewModel viewModel){
        this.vm = viewModel;
    }
    @Override
    public void execute() {
        try {
            ShapesList listWrapper = new ShapesList();
            listWrapper.setShapes(this.vm.shapes);

            JAXBContext context = JAXBContext.newInstance(ShapesList.class, Cube.class, Parallelepiped.class); // Add all classes that have JAXB annotations
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(listWrapper, new File("C:\\Users\\User\\Desktop\\PSExport\\shapes.xml"));

            System.out.println("export ok");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
