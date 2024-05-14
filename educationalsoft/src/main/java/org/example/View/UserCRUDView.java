package org.example.View;

import org.example.Model.Repository.Repository;
import org.example.Model.Repository.UserRepository;
import org.example.Model.User;
import org.example.ViewModel.UserViewModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List; // Corrected import

public class UserCRUDView extends JFrame {
    private UserViewModel userViewModel;

    private JTable userTable;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton makeAdminButton;
    private JButton refreshTable;
    private JScrollPane scrollPane;

    public UserCRUDView() {
        this.userViewModel = new UserViewModel(new UserRepository(new Repository()));
        setTitle("User CRUD Operations");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        initializeUI();
        setupBindings();
        // Now that everything is set up, let's load the data
        //userViewModel.refreshUserList(); // Ensure this is here
    }


    private void initializeUI() {
        // Initialize the JTable with columns corresponding to user attributes
        userTable = new JTable(new DefaultTableModel(new Object[]{"User ID", "Username", "Password", "Age", "Profile", "Role"}, 0));
        scrollPane = new JScrollPane(userTable);
        add(scrollPane, BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");
        makeAdminButton = new JButton("Make Admin");
        refreshTable = new JButton("Show Users");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(makeAdminButton);
        buttonPanel.add(refreshTable);

        add(buttonPanel, BorderLayout.NORTH);
    }

    private void setupBindings() {
        // Setup the table update when the userViewModel changes
        userViewModel.addPropertyChangeListener(evt -> {
            if ("users".equals(evt.getPropertyName())) {
                updateUserTable((List<User>) evt.getNewValue());
            }
        });

        addButton.addActionListener(e -> userViewModel.addcommand.execute());
        deleteButton.addActionListener(e -> userViewModel.deleteCommand.execute());
        refreshTable.addActionListener(e -> userViewModel.refreshTable.execute());
        makeAdminButton.addActionListener(e -> userViewModel.makeAdminCommand.execute());

        updateButton.addActionListener(e -> userViewModel.updateCommand.execute());
    }

//    public void onMakeUserAdmin() {
//        int userID = Integer.parseInt(JOptionPane.showInputDialog("Enter User ID to make ADMIN:"));
//        userViewModel.makeUserAdmin(userID);
//    }


    private void updateUserTable(List<User> users) {
        DefaultTableModel model = (DefaultTableModel) userTable.getModel();
        model.setRowCount(0); // Clear existing rows
        for (User user : users) {
            model.addRow(new Object[]{
                    user.getUserID(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getAge(),
                    user.getProfil().toString(), // Assuming ProfilList has a proper toString()
                    user.getRole().toString() // Assuming UserRole has a proper toString()
            });
        }
    }

    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public String displayInputDialog(String message) {
        return JOptionPane.showInputDialog(this, message);
    }

    public void showView() {
        setVisible(true);
    }

    public static void main(String[] args) {
        Repository repository = new Repository(); // Assuming Repository has a parameterless constructor
        UserRepository userRepository = new UserRepository(repository); // Pass the repository here

        UserViewModel userViewModel = new UserViewModel(userRepository);
        javax.swing.SwingUtilities.invokeLater(() -> {
            UserCRUDView view = new UserCRUDView();
            view.setVisible(true);
        });
    }
}
