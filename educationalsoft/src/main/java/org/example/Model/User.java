package org.example.Model;


public class User {

    protected int userID;
    protected String username;
    protected String password;
    protected int age;

    protected ProfilList profil;
    protected UserRole role;



    public User(){



    }

    public User(int userID, String username, String password, int age, ProfilList profil, UserRole role) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.age = age;
        this.profil = profil;
        this.role = role;
    }

    public User(String username, String password, int age, ProfilList profil) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.profil = profil;
    }

    public User(User user){
        this.userID = user.userID;
        this.username = user.username;
        this.password = user.password;
        this.age = user.age;
        this.profil = user.profil;
        this.role = user.role;

    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ProfilList getProfil() {
        return profil;
    }

    public void setProfil(ProfilList profil) {
        this.profil = profil;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", profil=" + profil +
                ", role=" + role +
                '}';
    }
}
