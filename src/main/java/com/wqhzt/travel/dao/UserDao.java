package com.wqhzt.travel.dao;

import com.wqhzt.travel.entity.User;

import java.sql.SQLException;

/**
 * @Description TODO
 * @Author hzt
 * @Date 2021/1/29 11:37
 */
public class UserDao extends BasicDao<User> {

    //插入用户
    public int insert(User user) throws SQLException {
        String sql = "insert into tab_user values(null,?,?,?,?,?,?,?,'0',?)";
        int i = this.update(sql, user.getUsername(), user.getPassword(), user.getName(),
                user.getBirthday(), user.getSex(), user.getTelephone(), user.getEmail(),
                user.getCode());
        return i;
    }

    //更新状态
    public int updateStatus(String code) throws SQLException {
        String sql = "update  tab_user set status = '1' where code = ?";
        int i = this.update(sql,  code);
        return i;
    }

    //通过用户名查询信息
    public Long selectOne(String username) throws SQLException {
        String sql = "select count(*) from tab_user where username = ?";
        Long value = (Long)this.getSingleValue(sql, username);
        return value;
    }

    //通过姓名和密码查询用户信息
    public User selectOne(String username ,String password) throws SQLException {
        String sql = "select * from tab_user where username = ? and password = ?";
        User user = this.getBean(sql,User.class,username,password);
        return user;
    }




}
