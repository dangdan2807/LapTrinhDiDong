package com.example.lab_07_b.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.lab_07_b.Entity.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAllUser();

    @Query("SELECT * FROM user WHERE id = :id")
    User getUserById(int id);

    @Insert
    void insertUser(User user);

    @Query("DELETE FROM user WHERE id = :id")
    void deleteUser(int id);

    @Query("DELETE FROM user")
    void deleteAllUser();
}
