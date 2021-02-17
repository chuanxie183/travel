package com.wqhzt.travel.dao;

import com.wqhzt.travel.entity.Route;
import com.wqhzt.travel.entity.RouteImg;

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
        String sql = "select * from tab_route order by rdate desc  limit 0,? ";
        List<Route> list = getBeanList(sql, Route.class, 4);
        return list;
    }


    //人气旅游
    public List selectAllByCount() throws SQLException {
        String sql = "select * from tab_route  order by count desc limit 0,? ";
        List<Route> list = getBeanList(sql, Route.class, 4);
        return list;
    }


    //主题旅游
    public List selectAllByisThemeTour() throws SQLException {
        String sql ="select * from tab_route where isThemeTour = 1 limit 0,?";
        List<Route> list = getBeanList(sql, Route.class, 4);
        return list;
    }

    //国内游
    public List selectAllChinaByCid () throws SQLException {
        String sql = "select * from tab_route where cid=5 limit 0,?";
        List<Route> list = getBeanList(sql,Route.class,6);
        return list;
    }

    //境外游
    public List selectAllOutChinaByCid () throws SQLException {
        String sql = "select * from tab_route where cid=4 limit 0,?";
        List<Route> list = getBeanList(sql,Route.class,6);
        return list;
    }

    /**
     *查询符合条件的所有路线列表总记录数
     * 条件一：路线类别的编号
     * 条件二：路线名称
     */
    public int selectCountsByCidRname(String cid ,String rname ) throws SQLException {
        Long counts = 0L;
        //直接进行表单条件搜索
        if(cid==null || cid.equals("")){
            String sql = "select count(*) from tab_route where rname like concat('%',?,'%')";
            counts = (Long)this.getSingleValue(sql,rname);
        }
        //点击  路线类别+条件搜索
        else if(cid!=null || !cid.equals("")){
            String sql = "select count(*) from tab_route where cid = ? and rname like concat('%',?,'%')";
            counts = (Long)this.getSingleValue(sql,cid,rname);
        }
        return counts.intValue();
    }

    //查询符合条件的所有商品列表
    public List<Route> selectRoutesByCidRname(String cid ,String rname,int begin ) throws SQLException {
        List<Route> routeList = null;
        //直接进行表单条件搜索
        if(cid==null || cid.equals("")){
            String sql = "select * from tab_route where rname like concat('%',?,'%') limit ?,12";
            routeList = this.getBeanList(sql,Route.class,rname,begin);
        }
        //点击  路线类别+条件搜索
        else if(cid!=null || !cid.equals("")){
            String sql = "select * from tab_route where cid = ? and rname like concat('%',?,'%') limit ?,12";
            routeList = this.getBeanList(sql,Route.class,cid,rname,begin);
        }
        return routeList;
    }


    //通过路线编号查找路线
    public Route selectOneByRid(int rid) throws SQLException {
        String sql = "select * from tab_route left join tab_route_img on tab_route.rid = tab_route_img.rid where tab_route.rid = ?";
        Route route = this.getBean(sql, Route.class, rid);
        return route;
    }

}
