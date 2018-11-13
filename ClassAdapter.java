package com.gloria.clase9;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassViewHolder>{

    private List<ClassObject> classEntities;

    public ClassAdapter(List<ClassObject> userEntitiesData) {
        classEntities = userEntitiesData;
    }


    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_recycler, viewGroup, false);
        return new ClassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder classViewHolder, int i) {
        if(classEntities!=null){
            ClassObject actual = classEntities.get(i);
            classViewHolder.nameItemView.setText(actual.getName());
            classViewHolder.imageView.setImageResource(actual.getImageclass());
        }else{
            classViewHolder.nameItemView.setText("No se a podido descargar");
        }
    }

    @Override
    public int getItemCount() {
        if (classEntities != null)
            return classEntities.size();
        else return 0;
    }

    class ClassViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameItemView;
        private final ImageView imageView;

        private ClassViewHolder(View itemView) {
            super(itemView);
            nameItemView = itemView.findViewById(R.id.person_name);
            imageView = itemView.findViewById(R.id.person_photo);
        }
    }
}
