package org.example.ViewModel.Commands;

import org.example.ViewModel.CanvasViewModel;

public class TetraedruItem implements ICommand{
    private CanvasViewModel canvasViewModel;
    public TetraedruItem(CanvasViewModel vm){
        this.canvasViewModel = vm;
    }
    @Override
    public void execute() {
        this.canvasViewModel.setCreionClicked(true);
        this.canvasViewModel.setRadieraClicked(false);
        this.canvasViewModel.setCubClicked(false);
        this.canvasViewModel.setParalelipipedClicked(false);
        this.canvasViewModel.setPrismClicked(false);
        this.canvasViewModel.setTetrahedronClicked(true); // Set Tetrahedron clicked flag
        System.out.println("Tetrahedron was clicked");
    }
}
