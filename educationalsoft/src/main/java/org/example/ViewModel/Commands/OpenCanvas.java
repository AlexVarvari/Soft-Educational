package org.example.ViewModel.Commands;

import org.example.View.CanvasView;

public class OpenCanvas implements ICommand{
    public OpenCanvas(){

    }
    @Override
    public void execute() {
        CanvasView canvas = new CanvasView();
    }
}
