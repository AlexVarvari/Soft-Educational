package org.example.Model.Repository;

import org.example.Model.ProfilList;
import org.example.Model.User;
import org.example.Model.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private Repository repository;

    public UserRepository(Repository repository) {
        this.repository = repository;
    }

    public boolean addUser(User user) {
        String commandSQL = "INSERT INTO usertable VALUES('" +
                user.getUserID() + "','" + user.getUsername() +
                "','" + user.getPassword() + "','" + user.getAge() +
                "','" + user.getProfil().ordinal() + "','" + user.getRole() + "')";
        return this.repository.executeSQL(commandSQL);
    }


    public boolean deleteUser(int userID) {
        String commandSQL = "DELETE FROM usertable WHERE userID = '" + userID + "'";
        return this.repository.executeSQL(commandSQL);
    }

    public boolean updateUser(int userID, User user) {
        String commandSQL = "UPDATE usertable SET Username = '" +
                user.getUsername() + "', Password = '" + user.getPassword() +
                "', Age = '" + user.getAge() + "', Profil = '" +
                user.getProfil().ordinal() + "', Role = '" + user.getRole() +
                "' WHERE userID = '" + userID + "'";
        return this.repository.executeSQL(commandSQL);
    }

    public boolean makeAdmin(int userID, User user){
        String commandSQL = "UPDATE usertable SET Role = '" + user.getRole() + "' WHERE userID = '" +userID + "'";
        return this.repository.executeSQL(commandSQL);
    }

    public List<User> userList() {
        String selectSQL = "SELECT * FROM usertable ORDER BY Username";
        ResultSet resultSet = this.repository.getResultSet(selectSQL);
        if (resultSet == null)
            return null;
        List<User> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                User user = this.convertToUser(resultSet);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public User searchUserByID(int userID) {
        String searchSQL = "SELECT * FROM usertable WHERE userID = " + userID;
        ResultSet resultSet = this.repository.getResultSet(searchSQL);
        if (resultSet == null)
            return null;
        try {
            if (resultSet.next())
                return this.convertToUser(resultSet);
            else
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private User convertToUser(ResultSet resultSet) throws SQLException {
        ProfilList profil = ProfilList.values()[resultSet.getInt("Profil")];
        UserRole role = UserRole.valueOf(resultSet.getString("Role"));
        int age = resultSet.getInt("Age");
        int id = resultSet.getInt("userID");
        return new User(id, resultSet.getString("Username"), resultSet.getString("Password"), age, profil, role);
    }
}
