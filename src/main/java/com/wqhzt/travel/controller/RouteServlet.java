package com.wqhzt.travel.controller;

import com.wqhzt.travel.entity.Route;
import com.wqhzt.travel.service.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description TODO
 * @Author hzt
 * @Date 2021/2/12 22:34
 */
@WebServlet( name = "RouteServlet",urlPatterns = "/route")
public class RouteServlet extends BasicServlet {
    private RouteService routeService = new RouteService();

    //展示首页
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询最新路线
        List<Route> routesNew = routeService.viewNews();
        request.setAttribute("routesNew",routesNew);

        //查询人气路线
        List<Route> routesCount = routeService.viewCounts();
        request.setAttribute("routesCount",routesCount);

        //查询主题路线
        List<Route> routesTheme = routeService.viewThemes();
        request.setAttribute("routesTheme",routesTheme);

        //查询国内旅游路线
        List<Route> routesChina = routeService.viewChinaRoute();
        request.setAttribute("routesChina",routesChina);

        //查询境外旅游路线
        List<Route> routesOutChina = routeService.viewOutChinaRoute();
        request.setAttribute("routesOutChina",routesOutChina);

        //跳转至首页
        request.getRequestDispatcher("index.jsp").forward(request,response);


    }

    //实现商品详情页展示 ：通过商品编号查询商品信息




}
