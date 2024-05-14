package org.example.ViewModel.Commands;

import org.example.Model.UserRole;
import org.example.View.QuizFrame;
import org.example.View.UserCRUDView;
import org.example.ViewModel.LoginPageViewModel;

public class LoginCommand implements ICommand {
    private final LoginPageViewModel viewModel;

    public LoginCommand(LoginPageViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        System.out.println("Login command executed");
        if (this.viewModel.getUsername().isEmpty() || this.viewModel.getPassword().isEmpty()) {
            this.viewModel.setMessage("Please submit both username and password");
            return;
        }

        if (this.viewModel.repository.authenticateUser(this.viewModel.getUsername(), this.viewModel.getPassword())) {
            this.viewModel.setUserRole(this.viewModel.repository.getUserRole(this.viewModel.getUsername()));
            this.viewModel.setMessage("Login Successful. Welcome, " + (this.viewModel.getUserRole() == UserRole.ADMIN ? "Admin" : "User"));
            if (this.viewModel.getUserRole() == UserRole.ADMIN) {
                // This block handles admin-specific logic
                UserCRUDView view = new UserCRUDView();
                view.setVisible(true);
            } else if (this.viewModel.getUserRole() == UserRole.USER) {
                // This block is for when the authenticated user is a regular user
                QuizFrame frame = new QuizFrame();
                frame.setVisible(true);  // Make sure the QuizFrame is visible
            }
        } else {
            this.viewModel.setMessage("Invalid username or password");
            this.viewModel.setLoginSuccessful(false);
        }
    }
}