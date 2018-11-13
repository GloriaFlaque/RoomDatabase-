package com.gloria.clase9;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

public abstract class WorkRoomDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    private static WorkRoomDatabase INSTANCE;
    static WorkRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WorkRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WorkRoomDatabase.class, "student_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
