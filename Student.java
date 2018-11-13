package com.gloria.clase9;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
@Entity(tableName = "student_table")
public class Student {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    public Student(@NonNull String word) {
        this.mWord = word;
    }

    public String getWord(){
        return this.mWord;
    }
}
