package org.example.ViewModel.Commands;

import org.example.ViewModel.CanvasViewModel;

public class RadieraItem implements ICommand{
    private CanvasViewModel canvasViewModel;
    public RadieraItem(CanvasViewModel vm){
        this.canvasViewModel = vm;
    }
    @Override
    public void execute() {
        this.canvasViewModel.setRadieraClicked(true);
        this.canvasViewModel.setCreionClicked(false);
        this.canvasViewModel.setCubClicked(false);
        this.canvasViewModel.setParalelipipedClicked(false);
        this.canvasViewModel.setPrismClicked(false);
        System.out.println("Eraser was clicked");
    }
}
