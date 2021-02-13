package com.wqhzt.travel.dao;

import com.wqhzt.travel.entity.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author hzt
 * @Date 2021/2/13 16:56
 */
public class CategoryDao extends BasicDao<Category>{

    //查询所有旅游路线类别
    public List<Category> selectAllCategory() throws SQLException {
        return  this.getBeanList("select * from tab_category ", Category.class);

    }

    //通过商品类别的编号查询商品类别的名称
    public String selectOneCategory(int cid) throws SQLException {
        Object value = this.getSingleValue("select cname from tab_category where cid = ?", cid);
        return value.toString();
    }


}
