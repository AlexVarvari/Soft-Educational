package org.example.ViewModel.Commands;

import org.example.Model.Repository.Repository;
import org.example.View.HomeView;
import org.example.ViewModel.CanvasViewModel;

public class HomeItem implements ICommand{
    private CanvasViewModel canvasViewModel;
    public HomeItem(CanvasViewModel vm){
        this.canvasViewModel = vm;
    }
    @Override
    public void execute() {
        this.canvasViewModel.view.setVisible(false); // Hide the canvas window
        HomeView homeView = new HomeView();
        homeView.setVisible(true); // Show the home screen
    }
}
