package com.wqhzt.travel.dao;

import com.wqhzt.travel.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author hzt
 * @Date 2021/1/24 20:21
 */
public class BasicDao<T> {
    QueryRunner runner = new QueryRunner();

    //增删改
    public int update(String sql,Object...params) throws SQLException {
        return runner.update(DataSourceUtils.getConnection(),sql, params);
    }


    //查询单行单列的值
    public Object getSingleValue(String sql,Object...params) throws SQLException {
        return runner.query(DataSourceUtils.getConnection(), sql, new ScalarHandler<>(), params);
    }

    //查询列表
    public List<T> getBeanList(String sql,Class<T> clazz,Object...params) throws SQLException {
        return runner.query(DataSourceUtils.getConnection(), sql, new BeanListHandler<T>(clazz),
                params);
    }

    //查询单个对象
    public T getBean(String sql,Class<T> clazz,Object...params) throws SQLException {
        return runner.query(DataSourceUtils.getConnection(),sql,new BeanHandler<>(clazz),params);
    }

}
