package org.example.ViewModel.Commands;

import org.example.Model.ProfilList;
import org.example.Model.Repository.UserRepository;
import org.example.Model.User;
import org.example.Model.UserRole;
import org.example.ViewModel.UserViewModel;

import javax.swing.*;

public class UpdateCommand implements ICommand{
    private UserRepository userRepository;
    private final UserViewModel viewModel;

    public UpdateCommand(UserRepository userRepository, UserViewModel viewModel) {
        this.userRepository = userRepository;
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        String userIDInput = JOptionPane.showInputDialog("Enter User ID:");
        if (userIDInput != null && !userIDInput.isEmpty()) {
            try {
                int userID = Integer.parseInt(userIDInput);
                String username = JOptionPane.showInputDialog("Enter Username:");
                String password = JOptionPane.showInputDialog("Enter Password:");
                String ageInput = JOptionPane.showInputDialog("Enter Age:");
                int age = Integer.parseInt(ageInput);
                String profilInput = JOptionPane.showInputDialog("Enter Profile id:\n" +
                        "MatematicaInformatica -> 1\n" +
                        "StiinteAleNaturii -> 2\n" +
                        "Filologie -> 3\n" +
                        "Arhitectura -> 4\n" +
                        "DesenPlastic -> 5");
                int profilID = Integer.parseInt(profilInput);
                if(profilID > 5 || profilID < 0){
                    JOptionPane.showMessageDialog(null, "Failed to add user.");
                    return;
                }

                ProfilList profil = ProfilList.values()[profilID - 1];
                UserRole role = UserRole.USER;

                if (!username.isEmpty() && !password.isEmpty()) {
                    User user = new User(userID, username, password, age, profil, role);
                    boolean success = userRepository.updateUser(userID, user);
                    if (success) {
                        JOptionPane.showMessageDialog(null, "User updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add user.");
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for User ID or Age or Profile.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "User ID is required.");
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
