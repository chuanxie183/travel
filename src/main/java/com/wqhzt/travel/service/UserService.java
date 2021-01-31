package com.wqhzt.travel.service;

import com.wqhzt.travel.dao.UserDao;
import com.wqhzt.travel.entity.User;

import java.sql.SQLException;

/**
 * @Description 用户模块的业务逻辑
 * @Author hzt
 * @Date 2021/1/29 15:16
 */
public class UserService {
    private UserDao dao = new UserDao();

    //注册
    public boolean regist(User user){
        try {
            return dao.insert(user)>0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //激活
    public boolean active(String code){
        try {
            return dao.updateStatus(code)>0 ? true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //校验用户名是否存在
    public boolean validate(String username){
        try {
            Long one = dao.selectOne(username);
            return one >0 ? true : false ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //登录
    public User login(String username, String password){
        try {
            User user = dao.selectOne(username, password);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
