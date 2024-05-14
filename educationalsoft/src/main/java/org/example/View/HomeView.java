package org.example.View;


import org.example.Model.Repository.Repository;
import org.example.Model.Repository.UserRepository;
import org.example.ViewModel.HomeViewModel;
import org.example.ViewModel.UserViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeView extends JFrame{
    private JLabel loginLabel;
    private HomeViewModel homeViewModel;
    public HomeView() {
        super("Home");
        homeViewModel = new HomeViewModel();
        initComponents();
    }

    private void initComponents() {
        JLabel openCanvasLabel = new JLabel("Open Canvas", SwingConstants.CENTER);
        openCanvasLabel.setBackground(Color.BLUE);
        openCanvasLabel.setForeground(Color.BLUE);
        openCanvasLabel.setFont(new Font("Arial", Font.BOLD, 12));

        loginLabel = new JLabel("Login", SwingConstants.CENTER);
        loginLabel.setBackground(Color.BLACK);
        loginLabel.setForeground(Color.BLUE);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 12));

        openCanvasLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                homeViewModel.openCanvas.execute();
            }
        });
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                homeViewModel.openLogin.execute();
            }
        });

        JPanel canvasPanel = new JPanel(new GridLayout(2, 1));
        canvasPanel.setBackground(Color.WHITE);
        canvasPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        canvasPanel.add(openCanvasLabel);
        canvasPanel.add(loginLabel);

        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(Color.WHITE);

        panel1.add(canvasPanel, BorderLayout.CENTER);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, panel2);
        splitPane.setDividerLocation(200);
        getContentPane().add(splitPane);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

public static void main(String[] args) {
    Repository repository = new Repository(); // Assuming Repository has a parameterless constructor
    UserRepository userRepository = new UserRepository(repository); // Pass the repository here

    UserViewModel userViewModel = new UserViewModel(userRepository);
    javax.swing.SwingUtilities.invokeLater(() -> {
        HomeView view = new HomeView();
        view.setVisible(true);
    });
}
}