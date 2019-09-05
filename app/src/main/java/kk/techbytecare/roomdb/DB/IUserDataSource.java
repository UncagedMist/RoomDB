package kk.techbytecare.roomdb.DB;

import java.util.List;


import io.reactivex.Flowable;
import kk.techbytecare.roomdb.Model.User;

public interface IUserDataSource {

    Flowable<User> getUserById(int userId);

    Flowable<List<User>> getAllUsers();

    void insertUser(User... users);

    void updateUser(User... users);

    void deleteUser(User... users);

    void deleteAllUsers();

    Flowable<List<User>> getUserList(String search);

}
