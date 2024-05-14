package org.example.ViewModel.Commands;

import org.example.ViewModel.CanvasViewModel;

import java.awt.*;

public class BlankItemClick implements ICommand{
    private CanvasViewModel canvasViewModel;
    public BlankItemClick(CanvasViewModel vm){
        this.canvasViewModel = vm;
    }
    @Override
    public void execute() {
        this.canvasViewModel.setRadieraClicked(false);
        this.canvasViewModel.setCreionClicked(false);
        this.canvasViewModel.setCubClicked(false);
        this.canvasViewModel.setParalelipipedClicked(false);
        this.canvasViewModel.setPrismClicked(false);
        this.canvasViewModel.view.contentPane.setBackground(Color.WHITE);
        this.canvasViewModel.view.contentPane.repaint();
        System.out.println("Clear was clicked");
    }
}
