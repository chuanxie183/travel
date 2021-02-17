package com.wqhzt.travel.service;

import com.wqhzt.travel.dao.RouteImgDao;
import com.wqhzt.travel.entity.RouteImg;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author hzt
 * @Date 2021/2/17 16:44
 */
public class RouteImgService {
    private RouteImgDao dao = new RouteImgDao();

    //根据路线编号查找图片集合
    public List<RouteImg> viewBigPicByRid(int rid){
        try {
            return dao.selectPicByRid(rid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
