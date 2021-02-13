package com.wqhzt.travel.service;

import com.wqhzt.travel.dao.RouteDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author hzt
 * @Date 2021/2/12 22:08
 */
public class RouteService {

    private RouteDao dao = new RouteDao();

    //最新旅游
    public List viewNews(){
        try {
            return dao.selectAllByRdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //人气旅游
    public List viewCounts(){
        try {
            return dao.selectAllByCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //主题旅游
    public List viewThemes(){
        try {
            return dao.selectAllByisThemeTour();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //国内游
    public List viewChinaRoute(){
        try {
            return dao.selectAllChinaByCid();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    //境外游
    public List viewOutChinaRoute(){
        try {
            return dao.selectAllOutChinaByCid();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




}
