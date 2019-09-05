package kk.techbytecare.roomdb.DB;

import java.util.List;

import io.reactivex.Flowable;
import kk.techbytecare.roomdb.Model.User;

public class UserRepository implements IUserDataSource {

    private IUserDataSource localDataSource;

    private static UserRepository instance;

    public UserRepository(IUserDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    public static UserRepository getInstance(IUserDataSource iUserDataSource)   {

        if (instance == null)   {

            instance = new UserRepository(iUserDataSource);
        }
        return instance;
    }

    @Override
    public Flowable<User> getUserById(int userId) {
        return localDataSource.getUserById(userId);
    }

    @Override
    public Flowable<List<User>> getAllUsers() {
        return localDataSource.getAllUsers();
    }

    @Override
    public void insertUser(User... users) {
        localDataSource.insertUser(users);
    }

    @Override
    public void updateUser(User... users) {
        localDataSource.updateUser(users);
    }

    @Override
    public void deleteUser(User... users) {
        localDataSource.deleteUser(users);
    }

    @Override
    public void deleteAllUsers() {
        localDataSource.deleteAllUsers();
    }

    @Override
    public Flowable<List<User>> getUserList(String search) {
        return localDataSource.getUserList(search);
    }
}
