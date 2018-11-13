package com.gloria.clase9;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class UserStudentRepository {
    private UserStudentDAO mUserDao;
    private LiveData<List<UserStudent>> mAllUsers;

    UserStudentRepository(Application application) {
        UserStudentRoomDatabase db = UserStudentRoomDatabase.getDatabase(application);
        mUserDao = db.userdao();
        mAllUsers = mUserDao.getAllUsers();
    }
    LiveData<List<UserStudent>> getAllUsers() {
        return mAllUsers;
    }
    public void insert (UserStudent userStudent) {
        new insertAsyncTask(mUserDao).execute(userStudent);
    }
    private static class insertAsyncTask extends AsyncTask<UserStudent, Void, Void> {

        private UserStudentDAO mAsyncTaskDao;

        insertAsyncTask(UserStudentDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final UserStudent... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
