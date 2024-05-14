package org.example.ViewModel.Commands;

import org.example.ViewModel.CanvasViewModel;

import java.awt.*;
import java.awt.event.MouseEvent;

public class HandleMouseMoved implements ICommandMouse{
    private CanvasViewModel canvasViewModel;
    public HandleMouseMoved(CanvasViewModel vm){
        this.canvasViewModel = vm;
    }

    @Override
    public void execute(MouseEvent e) {
        if(canvasViewModel.isCreionClicked()){
            Graphics g = this.canvasViewModel.view.getGraphics();
            g.setColor(Color.RED);
            g.fillOval(e.getX(), e.getY(), 5, 5);
        }
        else{
            Graphics g = this.canvasViewModel.view.getGraphics();
            g.setColor(Color.WHITE);
            g.fillOval(e.getX(), e.getY(), 5, 5);
        }
    }
}
