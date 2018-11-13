package com.gloria.clase9.DatabaseClass;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gloria.clase9.ClassAdapter;
import com.gloria.clase9.ClassObject;
import com.gloria.clase9.ClassRepository;
import com.gloria.clase9.R;

import java.util.List;

public class RecyclerActivityDatabase extends AppCompatActivity {

    public RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.my_recycler_view);


        ClassRepository classRepository = new ClassRepository(getApplication());
        classRepository.getAllClass().observe(this, new Observer<List<ClassObject>>() {
            @Override
            public void onChanged(@Nullable List<ClassObject> classStudents) {
                ClassAdapter adapter = new ClassAdapter(classStudents);
                recyclerView.setAdapter(adapter);
            }
        });

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }
}