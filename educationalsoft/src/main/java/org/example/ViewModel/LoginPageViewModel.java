package org.example.ViewModel;

import org.example.Model.Repository.Repository;
import org.example.Model.UserRole;
import org.example.ViewModel.Commands.ICommand;
import org.example.ViewModel.Commands.LoginCommand;
import org.example.ViewModel.Commands.ResetCommand;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginPageViewModel {
    public Repository repository;
    private PropertyChangeSupport support;

    private String username = "";
    private String password = "";
    private String message;
    private boolean loginSuccessful = false;
    private UserRole userRole; // The user role after authentication
    public ICommand login;
    public ICommand reset;

    public LoginPageViewModel(Repository repository) {
        this.repository = repository;
        this.support = new PropertyChangeSupport(this);
        support.firePropertyChange("loginSuccessful", !loginSuccessful, loginSuccessful);
        this.login = new LoginCommand(this);
        this.reset = new ResetCommand(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isLoginSuccessful() {
        return loginSuccessful;
    }

    public void setLoginSuccessful(boolean loginSuccessful) {
        this.loginSuccessful = loginSuccessful;
    }

    public UserRole getUserRole() {
        return userRole;  // Getter for userRole
    }



    public void setUserRole(UserRole role) {
        this.userRole = role;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
