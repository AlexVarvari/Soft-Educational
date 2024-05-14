package org.example.ViewModel.Commands;

import org.example.Model.Repository.UserRepository;
import org.example.Model.User;
import org.example.Model.UserRole;
import org.example.ViewModel.UserViewModel;

import javax.swing.*;

public class MakeAdminCommand implements ICommand {
    private UserRepository userRepository;
    private final UserViewModel viewModel;

    public MakeAdminCommand(UserRepository userRepository, UserViewModel viewModel) {
        this.userRepository = userRepository;
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        String userIDInput = JOptionPane.showInputDialog("Enter User ID to make admin:");
        int userID = Integer.parseInt(userIDInput);
        User existingUser = userRepository.searchUserByID(userID);
        if (existingUser != null) {
            existingUser.setRole(UserRole.ADMIN);
            if (userRepository.makeAdmin(userID, existingUser)) {
                System.out.println("User was made an ADMIN.");
            } else {
                System.out.println("Failed to update user.");
            }
        } else {
            System.out.println("User with ID " + userID + " not found.");
        }
        viewModel.users = userRepository.userList();
        if ( viewModel.users == null ||  viewModel.users.isEmpty()) {
            System.out.println("No users found or error loading users."); // For debugging
        } else {
            System.out.println("Loaded " +  viewModel.users.size() + " users."); // For debugging
        }

        this.viewModel.changes.firePropertyChange("users", null, this.viewModel.users);
    }
}
