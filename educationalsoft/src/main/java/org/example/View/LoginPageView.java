package org.example.View;

import org.example.Model.Repository.Repository;
import org.example.Model.Repository.UserRepository;
import org.example.Model.UserRole;
import org.example.ViewModel.LoginPageViewModel;
import org.example.View.UserCRUDView;
import org.example.ViewModel.UserViewModel;

import javax.naming.Context;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Hashtable;

public class LoginPageView extends JFrame{
    private JTextField usernameField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);
    private JButton loginButton = new JButton("Login");
    private JButton resetButton = new JButton("Reset");
    private JLabel messageLabel = new JLabel();

    private LoginPageViewModel viewModel;

    public LoginPageView(LoginPageViewModel viewModel) {
        this.viewModel = viewModel;
        initializeUI();
        setupBindings();

    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Use BorderLayout for main layout

        // Create a panel for input fields using BoxLayout for a vertical stack
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        // Create a sub-panel for the username field
        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        usernamePanel.add(new JLabel("Username:"));
        usernamePanel.add(usernameField);

        // Create a sub-panel for the password field
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.add(new JLabel("Password:"));
        passwordPanel.add(passwordField);

        // Add sub-panels to the input panel
        inputPanel.add(usernamePanel);
        inputPanel.add(passwordPanel);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        buttonPanel.add(loginButton);
        buttonPanel.add(resetButton);

        // Add inputPanel and buttonPanel to the main frame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add message label to the bottom
        add(messageLabel, BorderLayout.NORTH);

        pack(); // Pack the frame to respect preferred sizes
        setSize(300, 300);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private void setupBindings() {
        loginButton.addActionListener(e -> {
            viewModel.setUsername(usernameField.getText());
            viewModel.setPassword(new String(passwordField.getPassword()));
            viewModel.login.execute();
        });
        resetButton.addActionListener(e -> {
            viewModel.reset.execute();
            usernameField.setText("");
            passwordField.setText("");
        });
    }

    public static void main(String[] args) {
        Repository repository = new Repository();
        LoginPageViewModel viewModel = new LoginPageViewModel(repository);
        SwingUtilities.invokeLater(() -> new LoginPageView(viewModel));
    }
}
