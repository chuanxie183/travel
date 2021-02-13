package com.wqhzt.travel.controller;

import com.google.gson.Gson;
import com.wqhzt.travel.entity.Category;
import com.wqhzt.travel.service.CategoryService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description TODO
 * @Author hzt
 * @Date 2021/2/13 17:22
 */
@WebServlet(name = "CategoryServlet",urlPatterns = "/category")
public class CategoryServlet extends BasicServlet {

    private CategoryService categoryService = new CategoryService();

    //查询所有旅游路线的类别
    public void viewAllCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Category> categorys = categoryService.viewAllCategory();

        //通过json数据传递旅游路线类别的集合
        Gson gson = new Gson();
        String json = gson.toJson(categorys);

        //将json数据响应到客户端
        response.getWriter().write(json);

    }

}
