package com.gloria.clase9;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class ClassRepository {
    private ClassDAO mClassDao;
    private LiveData<List<ClassObject>> mAllClass;

    public ClassRepository(Application application) {
        ClassRoomDatabase db = ClassRoomDatabase.getDatabase(application);
        mClassDao = db.classdao();
        mAllClass = mClassDao.getAllClass();
    }
    public LiveData<List<ClassObject>> getAllClass() {
        return mAllClass;
    }
    public void insert (ClassObject classStudent) {
        new insertAsyncTask(mClassDao).execute(classStudent);
    }
    private static class insertAsyncTask extends AsyncTask<ClassObject, Void, Void> {

        private ClassDAO mAsyncTaskDao;

        insertAsyncTask(ClassDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ClassObject... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
