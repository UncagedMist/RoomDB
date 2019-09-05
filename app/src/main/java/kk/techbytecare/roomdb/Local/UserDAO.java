package kk.techbytecare.roomdb.Local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


import io.reactivex.Flowable;
import kk.techbytecare.roomdb.Model.User;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM users WHERE id =:userId")
    Flowable<User> getUserById(int userId);

    @Query("SELECT * FROM users")
    Flowable<List<User>> getAllUsers();

    @Insert
    void insertUser(User... users);

    @Update
    void updateUser(User... users);

    @Delete
    void deleteUser(User... users);

    @Query("DELETE FROM users")
    void deleteAllUsers();

    @Query("SELECT * FROM users WHERE name LIKE :search")
    Flowable<List<User>> getUserList(String search);
}
