package com.wqhzt.travel.service;

import com.wqhzt.travel.dao.RouteDao;
import com.wqhzt.travel.entity.Route;
import com.wqhzt.travel.vo.PageVo;

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

    //查询路线列表
    public PageVo<Route> viewRoutesByCidRname(String cid,String rname,Integer pageNow){
        PageVo<Route> vo = null;
        try {
            //获得总记录数
            int counts = dao.selectCountsByCidRname(cid,rname);

            //计算总页数
            int myPages = (int)(counts%12==0?counts/12:Math.ceil(counts/12.0));

            //计算起始值
            int begin = (pageNow-1)*12;

            //查询数据
            List<Route> routeList = dao.selectRoutesByCidRname(cid,rname,begin);

            //封装vo
            vo = new PageVo<>(cid,rname,pageNow,myPages,routeList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vo;
    }

    //通过路线编号查找路线
    public Route viewRouteByRid(int rid){
        try {
            return dao.selectOneByRid(rid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int viewCountsByCidRname(String cid,String rname){

        try {
            return dao.selectCountsByCidRname(cid,rname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
