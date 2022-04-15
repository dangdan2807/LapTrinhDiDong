package com.example.lab_07_b.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.lab_07_b.DAO.UserDao;
import com.example.lab_07_b.Entity.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserRoomDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
