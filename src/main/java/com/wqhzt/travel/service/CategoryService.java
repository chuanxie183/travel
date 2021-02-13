package com.wqhzt.travel.service;

import com.wqhzt.travel.dao.CategoryDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author hzt
 * @Date 2021/2/13 17:08
 */
public class CategoryService {
    private CategoryDao dao = new CategoryDao();

    //查询所有旅游路线类别
    public List viewAllCategory(){
        try {
            return dao.selectAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //根据路线类别id查询类别名称
    public String viewCname(int cid){
        try {
            return dao.selectOneCategory(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
