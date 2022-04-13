package com.example.lab_07.B.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lab_07.B.DAO.UserBDao;
import com.example.lab_07.B.entity.UserB;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {UserB.class}, version = 1, exportSchema = false)
public abstract class UserBRoomDatabase extends RoomDatabase {
    public abstract UserBDao getUserBDao();

//    private static volatile UserBRoomDatabase INSTANCE;
//    private static final int NUMBER_OF_THREADS = 4;
//    static final ExecutorService databaseWriteExecutor =
//            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
//
//    static UserBRoomDatabase getDatabase(final Context context) {
//        if (INSTANCE == null) {
//            synchronized (UserBRoomDatabase.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
//                            UserBRoomDatabase.class, "user_database")
//                            .build();
//                }
//            }
//        }
//        return INSTANCE;
//    }
}
