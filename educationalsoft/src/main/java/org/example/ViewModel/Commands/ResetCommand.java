package org.example.ViewModel.Commands;

import org.example.ViewModel.LoginPageViewModel;

public class ResetCommand implements ICommand {
    private final LoginPageViewModel viewModel;

    public ResetCommand(LoginPageViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        this.viewModel.setUsername("");
        this.viewModel.setPassword("");
        System.out.println("Fields reset");
    }
}