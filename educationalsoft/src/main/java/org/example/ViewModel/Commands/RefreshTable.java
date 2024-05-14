package org.example.ViewModel.Commands;

import org.example.Model.Repository.UserRepository;
import org.example.ViewModel.UserViewModel;

public class RefreshTable implements ICommand{
    private UserRepository userRepository;
    private final UserViewModel viewModel;

    public RefreshTable(UserRepository userRepository, UserViewModel viewModel) {
        this.userRepository = userRepository;
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        this.viewModel.users = userRepository.userList();
        if (this.viewModel.users == null || this.viewModel.users.isEmpty()) {
            System.out.println("No users found or error loading users."); // For debugging
        } else {
           System.out.println("Loaded " + this.viewModel.users.size() + " users."); // For debugging
       }
        this.viewModel.changes.firePropertyChange("users", null, this.viewModel.users);
    }
}
