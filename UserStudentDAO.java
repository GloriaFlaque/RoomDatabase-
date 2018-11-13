package com.gloria.clase9;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserStudentDAO {

    @Insert
    void insert(UserStudent userStudent);

    @Insert
    void insertAll(List<UserStudent> userStudent);

    @Query("DELETE FROM Users")
    void deleteAll();

    @Query("SELECT * from Users ORDER BY id ASC")
    LiveData<List<UserStudent>> getAllUsers();
}
