package com.example.final_example;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {OrderAnimal.class},version = 1,exportSchema = false)
public abstract class AnimalDatabase extends RoomDatabase {

    private static AnimalDatabase animalDatabase;
    public static synchronized  AnimalDatabase getInstanceAnimal(Context context){
        if (animalDatabase == null)
            animalDatabase = Room.databaseBuilder(context,AnimalDatabase.class,"database.db").build();
        return animalDatabase;
    }

    public abstract OrderAnimalDAO getDAOAnimal();


}
