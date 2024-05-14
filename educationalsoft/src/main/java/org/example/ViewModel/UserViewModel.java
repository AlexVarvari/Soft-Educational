package org.example.ViewModel;

import org.example.Model.Repository.UserRepository;
import org.example.Model.User;
import org.example.ViewModel.Commands.*;

import java.util.List; // Corrected import
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UserViewModel {
    private UserRepository userRepository;
    public List<User> users; // Correctly typed as List from java.util
    public PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public ICommand addcommand;
    public ICommand refreshTable;
    public ICommand deleteCommand;
    public ICommand makeAdminCommand;
    public ICommand updateCommand;


    public UserViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
        addcommand = new AddCommand(userRepository, this);
        refreshTable = new RefreshTable(userRepository, this);
        deleteCommand = new DeleteCommand(userRepository, this);
        makeAdminCommand = new MakeAdminCommand(userRepository, this);
        updateCommand = new UpdateCommand(userRepository, this);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }
}