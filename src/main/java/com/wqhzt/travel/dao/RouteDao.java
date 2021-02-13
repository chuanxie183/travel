package com.wqhzt.travel.dao;

import com.wqhzt.travel.entity.Route;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author hzt
 * @Date 2021/2/12 21:40
 */
public class RouteDao extends BasicDao<Route>{

    //最新旅游
    public List selectAllByRdate () throws SQLException {
        String sql = "select * from tab_route left join tab_route_img on tab_route.rid=tab_route_img.rgid order by tab_route.rdate desc  limit 0,? ";
        List<Route> list = getBeanList(sql, Route.class, 4);
        return list;
    }


    //人气旅游
    public List selectAllByCount() throws SQLException {
        String sql = "select * from tab_route left join tab_route_img on tab_route.rid=tab_route_img.rgid order by tab_route.count desc limit 0,? ";
        List<Route> list = getBeanList(sql, Route.class, 4);
        return list;
    }


    //主题旅游
    public List selectAllByisThemeTour() throws SQLException {
        String sql ="select * from tab_route left join tab_route_img  on tab_route.rid = tab_route_img.rgid where tab_route.isThemeTour = 1 limit 0,?";
        List<Route> list = getBeanList(sql, Route.class, 4);
        return list;
    }

    //国内游
    public List selectAllChinaByCid () throws SQLException {
        String sql = "select * from tab_route left join tab_route_img on tab_route.rid = tab_route_img.rgid where tab_route.cid=5 limit 0,?";
        List<Route> list = getBeanList(sql,Route.class,6);
        return list;
    }

    //境外游
    public List selectAllOutChinaByCid () throws SQLException {
        String sql = "select * from tab_route left join tab_route_img on tab_route.rid = tab_route_img.rgid where tab_route.cid=4 limit 0,?";
        List<Route> list = getBeanList(sql,Route.class,6);
        return list;
    }


}
