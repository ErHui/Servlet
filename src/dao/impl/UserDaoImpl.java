package dao.impl;

import dao.UserDao;
import entity.User;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {


    @Override
    public User getUser(String user, String pw) {
        //获取数据库连接
        ConnectionUtil connectionUtil = new ConnectionUtil();
        Connection conn = connectionUtil.getConn();
        //sql语句
        String sql = "select * from login where user = ? and pw = ?";

        try {
            //创建一个ps,执行sql语句
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,pw);

            //创建一个rs，保存查询的数据
            ResultSet rs = ps.executeQuery();
            //遍历循环输出数据

            User usr = new User();
            while(rs.next()){

                String username = rs.getString("user");
                String password = rs.getString("pw");

                System.out.println(user);
                System.out.println(pw);
                //将数据返回给User中，返回给servlet

                usr.setUser(username);
                usr.setPw(password);

            }
            return usr;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertInfo(String user, String pw){
        //获取数据库连接
        ConnectionUtil connectionUtil = new ConnectionUtil();
        Connection conn = connectionUtil.getConn();
        //sql语句
        String sql = "insert into login(user,pw) values (?,?)";
        //执行sql语句
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,pw);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String user,String pw,int id){
        //获取连接
        ConnectionUtil connectionUtil = new ConnectionUtil();
        Connection conn = connectionUtil.getConn();
        //sql语句
        String sql = "update login set user = ?,pw = ? where id = ?";
        //ps
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //设置参数
            ps.setString(1,user);
            ps.setString(2,pw);
            ps.setInt(3,id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id){
        //获取连接
        ConnectionUtil connectionUtil1 = new ConnectionUtil();
        Connection conn = connectionUtil1.getConn();
        //sql语句
        String sql = "delete from login where id = ?";
        //ps
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
      UserDaoImpl ud = new UserDaoImpl();
//      User user = ud.getUser("admin","admin");
//      System.out.println(user);
//      ud.insertInfo("123","123");
//      ud.update("12","1234",3);
        ud.delete(1);
    }
}
