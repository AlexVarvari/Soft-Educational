package org.example.Model.Repository;

import org.example.Model.User;
import org.example.Model.ProfilList;
import org.example.Model.UserRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository userRepository;
    private Repository repository;

    @BeforeEach
    void setUp() {

        repository = new Repository();
        userRepository = new UserRepository(repository);


    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testAddUser() {
        User user = new User(999, "testUser", "testPass", 25, ProfilList.MatematicaInformatica, UserRole.USER);
        assertTrue(userRepository.addUser(user), "User should be added successfully");

    }

    @Test
    void testDeleteUser() {
        int userIdToDelete = 999;
        assertTrue(userRepository.deleteUser(userIdToDelete), "User should be deleted successfully");

    }

    @Test
    void testUpdateUser() {
        User updatedUser = new User(999, "updatedUser", "updatedPass", 30, ProfilList.MatematicaInformatica, UserRole.USER);
        assertTrue(userRepository.updateUser(999, updatedUser), "User should be updated successfully");

    }

    @Test
    void testUserList() {
        assertNotNull(userRepository.userList(), "User list should not be null");

    }


}
