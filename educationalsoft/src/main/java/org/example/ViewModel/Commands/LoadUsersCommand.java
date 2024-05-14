package org.example.ViewModel.Commands;

import org.example.Model.Repository.UserRepository;
import org.example.Model.User;

import javax.swing.*;
import java.util.List;

public class LoadUsersCommand implements ICommand {
    private UserRepository userRepository;
    private DefaultListModel<User> userListModel;

    public LoadUsersCommand(UserRepository userRepository, DefaultListModel<User> userListModel) {
        this.userRepository = userRepository;
        this.userListModel = userListModel;
    }

    @Override
    public void execute() {
        // This runs on the Swing event dispatch thread to ensure thread safety.
        SwingUtilities.invokeLater(() -> {
            List<User> users = userRepository.userList();
            userListModel.clear(); // Clear the model before loading new data
            for (User user : users) {
                userListModel.addElement(user); // Add each user to the model
            }
        });
    }
}
