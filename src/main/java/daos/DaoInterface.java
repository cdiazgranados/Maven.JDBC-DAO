package daos;

import java.util.List;

public interface DaoInterface<T>{
    public T getCarById(int id);
    public List<T> findAll();
    public Boolean update(T dto);
    public Boolean create(T dto);
    public Boolean delete(int id);

//    User getUser();
//    Set<User> getAllUsers();
//    User getUserByUserNameAndPassword();
//    boolean insertUser();
//    boolean updateUser();
//    boolean deleteUser();
}
