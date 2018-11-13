package com.gloria.clase9;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class ClassViewModel extends AndroidViewModel {
    private ClassRepository mRepository;

    private LiveData<List<ClassObject>> mAllClass;

    public ClassViewModel (Application application) {
        super(application);
        mRepository = new ClassRepository(application);
        mAllClass = mRepository.getAllClass();
    }

    LiveData<List<ClassObject>> getAllClass() { return mAllClass; }

    public void insert(ClassObject classStudent) { mRepository.insert(classStudent); }
}
