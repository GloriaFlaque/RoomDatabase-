package com.gloria.clase9;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class Repository {
    private UserDao mUserDao;
    private LiveData<List<Student>> mAllStudents;
    Repository(Application application){
        WorkRoomDatabase db = WorkRoomDatabase.getDatabase(application);
        mUserDao = db.userDao();
        mAllStudents = mUserDao.getAllStudents();
    }
    LiveData<List<Student>> getAllStudents(){
        return mAllStudents;
    }
    public  void  insert(Student student){
        new insertAsyncTask(mUserDao).execute(student);
    }
    private static class insertAsyncTask extends AsyncTask<Student, Void, Void> {

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }



        @Override
        protected Void doInBackground(Student... students) {
            mAsyncTaskDao.insert(students[0]);
            return null;
        }
    }
}
