package org.example.ViewModel.Commands;

import org.example.ViewModel.CanvasViewModel;

public class TrunchiItem implements ICommand{
    private CanvasViewModel canvasViewModel;
    public TrunchiItem(CanvasViewModel vm){
        this.canvasViewModel = vm;
    }
    @Override
    public void execute() {
        this.canvasViewModel.setCreionClicked(true);
        this.canvasViewModel.setRadieraClicked(false);
        this.canvasViewModel.setCubClicked(false);
        this.canvasViewModel.setParalelipipedClicked(false);
        this.canvasViewModel.setPrismClicked(false);
        this.canvasViewModel.setPyramidTrunkClicked(true); // Set Tetrahedron clicked flag
        System.out.println("Pyramid Trunk was clicked");
    }
}
