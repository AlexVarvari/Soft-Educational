package org.example.ViewModel.Commands;

import org.example.ViewModel.CanvasViewModel;

public class CreionItem implements ICommand{
    private CanvasViewModel canvasViewModel;
    public CreionItem(CanvasViewModel vm){
        this.canvasViewModel = vm;
    }
    @Override
    public void execute() {
        this.canvasViewModel.setCreionClicked(true);
        this.canvasViewModel.setRadieraClicked(false);
        this.canvasViewModel.setCubClicked(false);
        this.canvasViewModel.setParalelipipedClicked(false);
        this.canvasViewModel.setPrismClicked(false);
        System.out.println("Pencil was clicked");
    }
}
