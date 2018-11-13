package com.gloria.clase9;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Class")
public class ClassObject {

    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "id")
    String id;
    @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "imageclass")
    int imageclass;
    @ColumnInfo(name = "nameofteacher")
    String nameofteacher;
    @ColumnInfo(name = "numberofstudents")
    int numberofstudents;
    @ColumnInfo(name = "course")
    int course;

    public ClassObject(@NonNull String id, String name, int imageclass, String nameofteacher, int numberofstudents, int course) {
        this.id = id;
        this.name = name;
        this.imageclass = imageclass;
        this.nameofteacher = nameofteacher;
        this.numberofstudents = numberofstudents;
        this.course = course;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImageclass() {
        return imageclass;
    }

    public String getNameofteacher() {
        return nameofteacher;
    }

    public int getNumberofstudents() {
        return numberofstudents;
    }

    public int getCourse() {
        return course;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageclass(int imageclass) {
        this.imageclass = imageclass;
    }

    public void setNameofteacher(String nameofteacher) {
        this.nameofteacher = nameofteacher;
    }

    public void setNumberofstudents(int numberofstudents) {
        this.numberofstudents = numberofstudents;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
