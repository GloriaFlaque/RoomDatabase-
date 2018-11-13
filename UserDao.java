package com.gloria.clase9;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(Student student);

    @Query("DELETE FROM student_table")
    void deleteAll();

    @Query("SELECT * from student_table ORDER BY word ASC")
    LiveData<List<Student>> getAllStudents();
}