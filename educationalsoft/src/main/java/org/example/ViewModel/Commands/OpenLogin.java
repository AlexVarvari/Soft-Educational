package org.example.ViewModel.Commands;

import org.example.Model.Repository.Repository;
import org.example.View.LoginPageView;
import org.example.ViewModel.LoginPageViewModel;

public class OpenLogin implements ICommand{

    public OpenLogin(){

    }
    @Override
    public void execute() {
        LoginPageView login = new LoginPageView(new LoginPageViewModel(new Repository()));
    }
}
