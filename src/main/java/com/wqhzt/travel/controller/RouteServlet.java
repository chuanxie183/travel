package com.wqhzt.travel.controller;

import com.google.gson.Gson;
import com.wqhzt.travel.entity.Route;
import com.wqhzt.travel.entity.RouteImg;
import com.wqhzt.travel.service.CategoryService;
import com.wqhzt.travel.service.RouteImgService;
import com.wqhzt.travel.service.RouteService;
import com.wqhzt.travel.vo.PageVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author hzt
 * @Date 2021/2/12 22:34
 */
@WebServlet( name = "RouteServlet",urlPatterns = "/route")
public class RouteServlet extends BasicServlet {
    private RouteService routeService = new RouteService();
    private CategoryService categoryService = new CategoryService();
    private RouteImgService routeImgService =new RouteImgService();

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


    //查看路线列表
    public void viewRouteListByCidRname(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //从请求参数中获取当前页
        String page = request.getParameter("pageNow");
        int pageNow = 1;
        if(page!=null){
            pageNow = Integer.parseInt(page);
        }

        //从请求参数中获取查询条件 cid rname
        String cid = request.getParameter("cid");
        if(cid!=null && !cid.equals("")){
            String cname = categoryService.viewCname(cid);
            request.setAttribute("cname",cname);
        }
        System.out.println(cid);
        String rname = request.getParameter("rname");
        if(rname==null){
            rname=""; //默认查询所有的路线信息
        }

        //获取总记录数
        int counts = routeService.viewCountsByCidRname(cid, rname);
        request.setAttribute("counts",counts);

        //查询所有的路线信息
        PageVo<Route> vo = routeService.viewRoutesByCidRname(cid, rname, pageNow);
        request.setAttribute("vo",vo);

        //查询人气路线
        List<Route> routesCount = routeService.viewCounts();
        request.setAttribute("routesCount",routesCount);

        //跳转页面
        request.getRequestDispatcher("route_list.jsp").forward(request,response);

    }


    //跳转详情页
    public void selectOneRouteByRid(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //从请求参数中获取rid
        String ridStr = request.getParameter("rid");
        int rid = Integer.parseInt(ridStr);

        //查询route路线
        Route route = routeService.viewRouteByRid(rid);
        request.setAttribute("route",route);

        //查询图片
        List<RouteImg> routeImgs = routeImgService.viewBigPicByRid(rid);

        //routeImgs就是图片集合
        //通过json数据传递旅游路线类别的集合
        Gson gson = new Gson();
        String routeImgsJson = gson.toJson(routeImgs);

        /*//将json数据响应到客户端
        response.getWriter().write(routeImgsJson);*/

        //只有在route_list界面才有cid
        String cid = request.getParameter("cid");
        if(cid!=null){
            String cname = categoryService.viewCname(cid);
            request.setAttribute("cid",cid);
            request.setAttribute("cname",cname);
        }

        //获得请求参数，当前页
        String pageNow = request.getParameter("pageNow");
        request.setAttribute("pageNow",pageNow);

        //获得请求参数，搜索条件
        String rname = request.getParameter("rname");
        request.setAttribute("rname",rname);

        request.setAttribute("routeImgs",routeImgs);

        //跳转至详情页
        request.getRequestDispatcher("route_detail.jsp").forward(request,response);
    }







}
