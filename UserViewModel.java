package com.gloria.clase9;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private  Repository mRepository;
    private LiveData<List<Student>> mAllStudents;
    public UserViewModel(@NonNull Application application) {
        super(application);
        mRepository = new Repository(application);
        mAllStudents = mRepository.getAllStudents();
    }
    LiveData<List<Student>> getAllStudents() {
        return mAllStudents;
    }
    public void insert(Student word){
        mRepository.insert(word);
    }
}
