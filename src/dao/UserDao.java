package dao;

import entity.User;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    User getUser(String user,String pw);
}
