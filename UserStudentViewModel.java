package com.gloria.clase9;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class UserStudentViewModel extends AndroidViewModel {
    private UserStudentRepository mRepository;

    private LiveData<List<UserStudent>> mAllUsers;

    public UserStudentViewModel (Application application) {
        super(application);
        mRepository = new UserStudentRepository(application);
        mAllUsers = mRepository.getAllUsers();
    }

    LiveData<List<UserStudent>> getAllWords() { return mAllUsers; }

    public void insert(UserStudent userStudent) { mRepository.insert(userStudent); }
}

