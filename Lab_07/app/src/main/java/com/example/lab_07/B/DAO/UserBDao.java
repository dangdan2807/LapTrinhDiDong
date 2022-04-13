package com.example.lab_07.B.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.lab_07.B.entity.UserB;

import java.util.List;

@Dao
public interface UserBDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(UserB user);

    @Query("DELETE FROM user")
    void deleteAll();

//    @Query("Drop Table if exists user")
//    void resetDatabase();

    @Query("DELETE FROM user WHERE id = :id")
    void deleteUser(int id);

    @Query("SELECT * FROM user")
    List<UserB> getAllUser();

    @Query("SELECT * FROM user ORDER BY id DESC LIMIT 1")
    UserB getLastUser();
}
