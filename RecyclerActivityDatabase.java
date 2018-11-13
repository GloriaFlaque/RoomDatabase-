package com.gloria.clase9;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class RecyclerActivityDatabase extends AppCompatActivity {

    public RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.my_recycler_view);


        UserStudentRepository userRepository = new UserStudentRepository(getApplication());
        userRepository.getAllUsers().observe(this, new Observer<List<UserStudent>>() {
            @Override
            public void onChanged(@Nullable List<UserStudent> userStudents) {
                UserStudentAdapter adapter = new UserStudentAdapter(userStudents);
                recyclerView.setAdapter(adapter);
            }
        });

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }
}