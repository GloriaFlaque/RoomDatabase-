package com.gloria.clase9;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class UserStudentAdapter extends RecyclerView.Adapter<UserStudentAdapter.UserViewHolder>{

    private List<UserStudent> userEntities;

    public UserStudentAdapter(List<UserStudent> userEntitiesData) {
        userEntities = userEntitiesData;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_recycler, viewGroup, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        if(userEntities!=null){
            UserStudent actual = userEntities.get(i);
            userViewHolder.nameItemView.setText(actual.getName());
            userViewHolder.imageView.setImageResource(actual.getImage());
        }else{
            userViewHolder.nameItemView.setText("No se a podido descargar");
        }
    }

    @Override
    public int getItemCount() {
        if (userEntities != null)
            return userEntities.size();
        else return 0;
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameItemView;
        private final ImageView imageView;

        private UserViewHolder(View itemView) {
            super(itemView);
            nameItemView = itemView.findViewById(R.id.person_name);
            imageView = itemView.findViewById(R.id.person_photo);
        }
    }
}