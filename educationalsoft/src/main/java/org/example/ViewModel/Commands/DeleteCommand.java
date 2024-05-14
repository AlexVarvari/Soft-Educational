package org.example.ViewModel.Commands;

import org.example.Model.Repository.UserRepository;
import org.example.Model.User;
import org.example.Model.ProfilList;
import org.example.Model.UserRole;
import org.example.ViewModel.UserViewModel;

import javax.swing.*;

public class DeleteCommand implements ICommand {
    private UserRepository userRepository;
    private final UserViewModel viewModel;

    public DeleteCommand(UserRepository userRepository, UserViewModel viewModel) {
        this.userRepository = userRepository;
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        String userIDInput = JOptionPane.showInputDialog("Enter User ID to delete:");
        if (userIDInput != null && !userIDInput.isEmpty()) {
            try {
                int userID = Integer.parseInt(userIDInput);
                boolean success = userRepository.deleteUser(userID);
                if (success) {
                    JOptionPane.showMessageDialog(null, "User deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete user.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for User ID.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "User ID cannot be empty.");
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
