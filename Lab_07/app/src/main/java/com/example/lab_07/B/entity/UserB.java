package com.example.lab_07.B.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserB {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    public UserB(int id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    public UserB(@NonNull String name) {
        this.name = name;
    }

    public UserB(int id) {
        this.id = id;
    }

    public UserB() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
