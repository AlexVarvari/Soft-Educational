package org.example.ViewModel.Commands;

import org.example.Model.Shapes.*;
import org.example.ViewModel.CanvasViewModel;

import java.awt.*;
import java.awt.event.MouseEvent;

public class HandleMouseClick implements ICommandMouse{
    private CanvasViewModel canvasViewModel;
    public HandleMouseClick(CanvasViewModel vm){
        this.canvasViewModel = vm;
    }

    @Override
    public void execute(MouseEvent e) {
        Graphics g = (this.canvasViewModel.view.getGraphics());
        if (this.canvasViewModel.isCubClicked()) {
            Cube cube = new Cube(e.getX(), e.getY(), 100, 50, this.canvasViewModel.getCurrentColor()); // Adjust the size and shift parameters as needed
            this.canvasViewModel.shapes.add(cube);
            cube.drawCube(g);
        } else if (this.canvasViewModel.isParalelipipedClicked()) {
            Parallelepiped parallelepiped = new Parallelepiped(e.getX(), e.getY(), 150, 100, 50, 100, -50, this.canvasViewModel.getCurrentColor());
            this.canvasViewModel.shapes.add(parallelepiped);
            parallelepiped.drawParallelepiped(g);
        } else if (this.canvasViewModel.isPrismClicked()) {
            Prism prism = new Prism(e.getX(), e.getY(), 100, 80, 120, 50, -50, this.canvasViewModel.getCurrentColor());
            this.canvasViewModel.shapes.add(prism);
            prism.drawPrism(g);
        } else if (this.canvasViewModel.isPyramidClicked()) {
            Pyramid pyramid = new Pyramid(e.getX(), e.getY(), 100, 100, 50, -50, this.canvasViewModel.getCurrentColor());
            this.canvasViewModel.shapes.add(pyramid);
            pyramid.drawPyramid(g);
        } else if (this.canvasViewModel.isPyramidTrunkClicked()) {
            PyramidTrunk pyramidTrunk = new PyramidTrunk(e.getX(), e.getY(), 150, 100, 100, 50, 80,this.canvasViewModel.getCurrentColor());
            pyramidTrunk.drawPyramidTrunk(g);
        } else if (this.canvasViewModel.isTetrahedronClicked()) {
            Tetrahedron tetrahedron = new Tetrahedron(e.getX(), e.getY(), 100, 50, this.canvasViewModel.getCurrentColor()); // Adjust the size and shift parameters as needed
            tetrahedron.drawTetrahedron(g);
        }
    }
}
