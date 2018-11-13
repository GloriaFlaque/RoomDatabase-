package com.gloria.clase9;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ClassDAO {

    @Insert
    void insert(ClassObject classStudent);

    @Insert
    void insertAll(List<ClassObject> classStudent);

    @Query("DELETE FROM Class")
    void deleteAll();

    @Query("SELECT * from Class ORDER BY id ASC")
    LiveData<List<ClassObject>> getAllClass();
}

