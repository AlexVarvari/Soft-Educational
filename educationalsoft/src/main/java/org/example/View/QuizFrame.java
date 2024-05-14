package org.example.View;

import org.example.Model.QuizModel;
import org.example.Model.Repository.Repository;
import org.example.Model.Repository.UserRepository;
import org.example.ViewModel.QuizFrameViewModel;
import org.example.ViewModel.UserViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class QuizFrame extends JFrame implements  ActionListener {

    public JTextField textField = new JTextField();
    public JTextArea textArea = new JTextArea();
    public JButton[] optionButtons = new JButton[5];
    private JLabel questionsRemained = new JLabel();
    private QuizFrameViewModel quizFrameViewModel;

    public QuizFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 650);
        setLayout(null);
        initializeUIComponents();
        quizFrameViewModel = new QuizFrameViewModel(this);
        setVisible(true);
    }

    private void initializeUIComponents() {
        textField.setBounds(0, 0, 650, 50);
        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        add(textField);

        textArea.setBounds(0, 50, 650, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25, 25, 25));
        textArea.setForeground(new Color(25, 255, 0));
        textArea.setFont(new Font("Ink Free", Font.BOLD, 25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);
        add(textArea);

        int buttonHeight = 100;
        char[] optionsLetters = {'A', 'B', 'C', 'D', 'E'};
        for (int i = 0; i < optionButtons.length; i++) {
            JButton button = new JButton();
            button.setActionCommand(String.valueOf(optionsLetters[i]));
            button.setBounds(0, 100 + (i * buttonHeight), 650, buttonHeight);
            button.setFont(new Font("Ink Free", Font.BOLD, 24));
            button.setFocusable(false);
            button.addActionListener(this);
            optionButtons[i] = button;
            add(button);
        }

        questionsRemained.setBounds(535, 510, 100, 100);
        questionsRemained.setBackground(new Color(25, 25, 25));
        questionsRemained.setForeground(new Color(255, 0, 0));
        questionsRemained.setFont(new Font("Ink Free", Font.BOLD, 60));
        questionsRemained.setBorder(BorderFactory.createBevelBorder(1));
        questionsRemained.setOpaque(true);
        questionsRemained.setHorizontalAlignment(JTextField.CENTER);
        add(questionsRemained);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        char selectedAnswer = clickedButton.getActionCommand().charAt(0);
        quizFrameViewModel.answerSelect.execute(selectedAnswer);
    }

public static void main(String[] args) {
    Repository repository = new Repository(); // Assuming Repository has a parameterless constructor
    UserRepository userRepository = new UserRepository(repository); // Pass the repository here

    UserViewModel userViewModel = new UserViewModel(userRepository);
    javax.swing.SwingUtilities.invokeLater(() -> {
        QuizFrame view = new QuizFrame();
        view.setVisible(true);
    });
}
}