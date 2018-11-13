package com.gloria.clase9;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;


import java.util.ArrayList;
import java.util.List;

@Database(entities = {UserStudent.class}, version = 1)
public abstract class UserStudentRoomDatabase extends RoomDatabase {

    public abstract UserStudentDAO userdao();
    private static UserStudentRoomDatabase INSTANCE;

    static UserStudentRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UserStudentRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserStudentRoomDatabase.class, "user_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(callBackData)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    static Callback callBackData = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            (new UserAsyncTask(INSTANCE)).execute();
        }
    };

    private static class UserAsyncTask extends AsyncTask<Void,Void,Void> {
        public UserStudentDAO userDao;

        public UserAsyncTask(UserStudentRoomDatabase userStudentRoomDatabase) {
            userDao = userStudentRoomDatabase.userdao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            UserStudent gogeta = new UserStudent("1","Cereza",R.drawable.cereza);
            UserStudent gotenks = new UserStudent("2","Cereza",R.drawable.cereza);
            UserStudent vegito = new UserStudent("3","Cereza",R.drawable.cereza);
            UserStudent buu = new UserStudent("4","Cereza",R.drawable.cereza);
            UserStudent frieza = new UserStudent("5","Cereza",R.drawable.cereza);
            UserStudent cell = new UserStudent("6","Cereza",R.drawable.cereza);
            List<UserStudent> data = new ArrayList<>();
            data.add(gogeta);
            data.add(gotenks);
            data.add(vegito);
            data.add(buu);
            data.add(frieza);
            data.add(cell);
            userDao.deleteAll();
            userDao.insertAll(data);
            return null;
        }
    }
}