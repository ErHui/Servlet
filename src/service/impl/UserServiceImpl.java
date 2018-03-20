package service.impl;

import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService{

    @Override
    public boolean login(String user, String pw) {
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.login(user,pw);
    }

    @Override
    public String reg(String user, String pw) {
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.reg(user,pw);
    }

    @Override
    public List<User>  getAll() {
        UserDaoImpl userDao = new UserDaoImpl();
       return userDao. getAll();
    }

}
