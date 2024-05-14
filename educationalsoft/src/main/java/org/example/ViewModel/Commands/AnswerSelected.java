package org.example.ViewModel.Commands;

import org.example.Model.QuizModel;
import org.example.ViewModel.QuizFrameViewModel;

import javax.swing.*;
import java.awt.*;

public class AnswerSelected implements ICommandQuiz{
    private QuizFrameViewModel viewModel;
    private QuizModel model;
    public AnswerSelected(QuizFrameViewModel vm){
        this.viewModel = vm;
        this.model = new QuizModel();
    }
    @Override
    public void execute(char selectedAnswer) {
        char correctAnswer = model.getAnswer(this.viewModel.getCurrentQuestionIndex());
        boolean isAnswerCorrect = false;

        for (int i = 0; i < model.getOptions(this.viewModel.getCurrentQuestionIndex()).length; i++) {
            if (selectedAnswer == correctAnswer) {
                isAnswerCorrect = true;
                if (selectedAnswer == 'A' + i) {
                    highlightAnswerButton(i, new Color(25, 255, 0)); // Highlight correct answer in green
                } else {
                    highlightAnswerButton(i, UIManager.getColor("Button.background")); // Keep others neutral
                }
            } else {
                if ('A' + i == correctAnswer) {
                    highlightAnswerButton(i, new Color(25, 255, 0)); // Correct answer in green
                } else if (selectedAnswer == 'A' + i) {
                    highlightAnswerButton(i, new Color(255, 0, 0)); // Selected incorrect answer in red
                } else {
                    highlightAnswerButton(i, UIManager.getColor("Button.background")); // Keep others neutral
                }
            }
        }

        this.viewModel.setCurrentQuestionIndex(this.viewModel.getCurrentQuestionIndex() + 1);
        if (isAnswerCorrect) {
            this.viewModel.setCorrectAnswers(this.viewModel.getCorrectAnswers() + 1);
        }
        enableOptionButtons(false);
        Timer timer = new Timer(1000, e -> nextQuestion());
        timer.setRepeats(false); // Make sure the timer only runs once
        timer.start();
    }

    public void highlightAnswerButton(int buttonIndex, Color color) {
        if (buttonIndex >= 0 && buttonIndex < this.viewModel.view.optionButtons.length) {
            this.viewModel.view.optionButtons[buttonIndex].setBackground(color);
        }
    }

    public void enableOptionButtons(boolean enable) {
        for (JButton button : this.viewModel.view.optionButtons) {
            button.setEnabled(enable);
        }
    }
    public void nextQuestion() {
        if (this.viewModel.getCurrentQuestionIndex() < model.getTotalQuestions()) {
            displayQuestionAndOptions(model.getQuestion(this.viewModel.getCurrentQuestionIndex()), model.getOptions(this.viewModel.getCurrentQuestionIndex()));
            setQuestionNumber(this.viewModel.getCurrentQuestionIndex() + 1, model.getTotalQuestions());
            enableOptionButtons(true);
        } else {
            displayResult("Your score: " + this.viewModel.getCorrectAnswers() + "/" + model.getTotalQuestions());
        }
    }

    public void displayResult(String result) {
        this.viewModel.view.textArea.setText(result);
        for (JButton button : this.viewModel.view.optionButtons) {
            button.setVisible(false);
        }
    }

    public void setQuestionNumber(int questionNumber, int total) {
        this.viewModel.view.textField.setText("Question " + questionNumber + "/" + total);
    }

    public void displayQuestionAndOptions(String question, String[] options) {
        this.viewModel.view.textArea.setText(question); // Display the question in the text area.
        for (int i = 0; i < options.length; i++) {
            this.viewModel.view.optionButtons[i].setText(options[i]); // Set the text for each button.
            this.viewModel.view.optionButtons[i].setVisible(true); // Make sure the button is visible.
            this.viewModel.view.optionButtons[i].setBackground(UIManager.getColor("Button.background")); // Reset background color.
        }
        // If there are fewer options than buttons, hide the remaining buttons.
        for (int i = options.length; i < this.viewModel.view.optionButtons.length; i++) {
            this.viewModel.view.optionButtons[i].setVisible(false);
        }
        enableOptionButtons(true); // Ensure all visible buttons are enabled.
    }
}
