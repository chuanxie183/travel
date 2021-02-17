package com.wqhzt.travel.dao;

import com.wqhzt.travel.entity.RouteImg;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author hzt
 * @Date 2021/2/17 16:41
 */
public class RouteImgDao extends BasicDao<RouteImg>{
    //通过路线编号查找图片
        public List<RouteImg> selectPicByRid(int rid) throws SQLException {
           String sql = "select bigPic from tab_route_img where rid = ?";
            List<RouteImg> list = this.getBeanList(sql, RouteImg.class, rid);
            return list;
        }

}
