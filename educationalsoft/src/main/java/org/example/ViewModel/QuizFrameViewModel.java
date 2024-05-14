package org.example.ViewModel;

import org.example.View.QuizFrame;
import org.example.ViewModel.Commands.AnswerSelected;
import org.example.ViewModel.Commands.ICommandQuiz;

public class QuizFrameViewModel {
    public QuizFrame view;
    private int currentQuestionIndex = 0;
    private int correctAnswers = 0;
    public ICommandQuiz answerSelect;
    public QuizFrameViewModel(QuizFrame quiz){
        this.view = quiz;
        answerSelect = new AnswerSelected(this);
        answerSelect.nextQuestion();
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }
}
