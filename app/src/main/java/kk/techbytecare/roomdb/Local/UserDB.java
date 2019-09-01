package kk.techbytecare.roomdb.Local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import kk.techbytecare.roomdb.Model.User;

@Database(entities = User.class, version = 1, exportSchema = false)
public abstract class UserDB extends RoomDatabase {

    private static final String DB_NAME = "DB-Users";

    public abstract UserDAO userDAO();

    private static UserDB instance;

    public static UserDB getInstance(Context context)   {

        if (instance == null)   {
            instance = Room.databaseBuilder(context,UserDB.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

}
