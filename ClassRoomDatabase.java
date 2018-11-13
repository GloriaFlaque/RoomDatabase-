package com.gloria.clase9;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;


import java.util.ArrayList;
import java.util.List;

@Database(entities = {ClassObject.class}, version = 1)
public abstract class ClassRoomDatabase extends RoomDatabase {

    public abstract ClassDAO classdao();
    private static ClassRoomDatabase INSTANCE;

    static ClassRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ClassRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ClassRoomDatabase.class, "database")
                            .fallbackToDestructiveMigration()
                            .addCallback(callBackData)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    static Callback callBackData = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            (new UserAsyncTask(INSTANCE)).execute();
        }
    };

    private static class UserAsyncTask extends AsyncTask<Void,Void,Void> {
        public ClassDAO classDao;

        public UserAsyncTask(ClassRoomDatabase userStudentRoomDatabase) {
            classDao = userStudentRoomDatabase.classdao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ClassObject adat = new ClassObject("1","Desarrollo de interfaces",R.drawable.cereza,"David",25,2);
            ClassObject dint = new ClassObject("2","Iniciativa emprendedora",R.drawable.aguacate,"Meritxel",25,2);
            ClassObject eiem = new ClassObject("3","Acceso a datos",R.drawable.cereza,"Jaime",25,2);
            ClassObject fctr = new ClassObject("4","Ingles tecnico para grado superior",R.drawable.fresas,"Cristina",25,2);
            ClassObject itgs = new ClassObject("5","Sistema de gestion empresarial",R.drawable.kiwi,"Laura",25,2);
            ClassObject pspr = new ClassObject("6","Programacion de servicios",R.drawable.manzana, "Pedro",25,2);
            ClassObject pmdm = new ClassObject("7","Proyecto final",R.drawable.pomelo,"Juaquin",25,2);
            ClassObject pdam = new ClassObject("8","IOS",R.drawable.manzana,"Carlos",25,2);
            ClassObject sgem = new ClassObject("9","Sistema de gestion empresarial",R.drawable.kiwi,"Pedro",25,2);
            List<ClassObject> data = new ArrayList<>();
            data.add(adat);
            data.add(dint);
            data.add(eiem);
            data.add(fctr);
            data.add(itgs);
            data.add(pspr);
            data.add(pmdm);
            data.add(pdam);
            data.add(sgem);
            classDao.deleteAll();
            classDao.insertAll(data);
            return null;
        }
    }
}

