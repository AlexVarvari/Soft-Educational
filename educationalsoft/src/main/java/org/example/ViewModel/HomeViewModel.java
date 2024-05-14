package org.example.ViewModel;

import org.example.ViewModel.Commands.ICommand;
import org.example.ViewModel.Commands.OpenCanvas;
import org.example.ViewModel.Commands.OpenLogin;

public class HomeViewModel {
    public ICommand openLogin;
    public ICommand openCanvas;
    public HomeViewModel(){
        openLogin = new OpenLogin();
        openCanvas = new OpenCanvas();
    }
}
