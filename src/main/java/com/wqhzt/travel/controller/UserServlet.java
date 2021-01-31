package com.wqhzt.travel.controller;

import com.wqhzt.travel.entity.User;
import com.wqhzt.travel.service.UserService;
import com.wqhzt.travel.utils.CommonUtils;
import com.wqhzt.travel.utils.MD5Utils;
import com.wqhzt.travel.utils.MailUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @Description TODO
 * @Author hzt
 * @Date 2021/1/29 15:30
 */
@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BasicServlet{

    private UserService service = new UserService();

    //用户注册
    public void regist(final HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();

        User user = new User();

        /**
         * 注册转换器 目标String  ->Date
         * 第一个参数：定义转换规则
         * 第二个参数：将String转换成哪个目标类型
         */
        ConvertUtils.register(new Converter() {
            @Override
            public Object convert(Class clazz, Object o) {
                Date birthday = null;
                if(o instanceof String){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        birthday = sdf.parse(request.getParameter("birthday"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                return birthday;
            }
        }, Date.class);

        //通过BeanUtils工具类，给user对象赋值属性
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //给user对象设置激活码code
        String code = CommonUtils.getUUID().replaceAll("-","");
        user.setCode(code);

        //通过MD5处理密码
        user.setPassword(MD5Utils.md5(user.getPassword()));

        //执行用户注册
        boolean flag = service.regist(user);
        if(flag){
            //注册成功，发一封邮件
            //邮件的内容
            String emailMsg = "恭喜您注册成功，这是一封激活邮件，请点击<a href='http://localhost:8080/user?method=active&code="+code+"'>"+code+"</a>激活";
            try {
                MailUtils.sendMail(user.getEmail(),"注册邮件激活",emailMsg);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("register_ok.jsp").forward(request,response);

        }else{
            //注册失败
            request.setAttribute("msg","注册失败，请重新注册！");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }

    //用户激活
    public void active(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");
        boolean flag = service.active(code);
        if(flag){
            //激活成功
            response.sendRedirect("index.jsp");
        }else{
            //激活失败
            response.sendRedirect("error/404.jsp");
        }

    }

    //用户名校验
    public void validate(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        boolean flag = service.validate(username);

        //封装成json数据格式响应至客户端  json串：{"flag":flag}
        String str = "{\"flag\":"+flag+"}";
        response.getWriter().write(str);
    }

    //用户登录
    public void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //获得请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //通过MD5技术处理密码
        String code = request.getParameter("code");
        if(code==null){
            //不是自动登录
            password = MD5Utils.md5(password);
        }

        //登录
        User user = service.login(username, password);
        if(user!=null){
            //邮件已激活，可以登录
            if(user.getStatus()==1){

                //选择自动登录
                String free = request.getParameter("free");

                //选择自动登录：点击了free,则在Cookie中存储用户名和密码
                if(free!=null && "free".equals(free)){
                    Cookie usernameCookie = new Cookie("username", URLEncoder.encode(username,"UTF-8"));
                    Cookie passwordCookie = new Cookie("password",password);
                    usernameCookie.setMaxAge(7*24*60*60);
                    passwordCookie.setMaxAge(7*24*60*60);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                }

                //将当前查询到的用户信息，存储至会话中
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                //跳转至首页
             //   request.getRequestDispatcher(request.getContextPath()+"index.jsp").forward(request,response);

                response.sendRedirect("index.jsp");

            }else{
                request.setAttribute("msg","当前帐号未激活，请前往邮箱激活后再登陆。");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }else{
            request.setAttribute("msg","用户名与密码不匹配");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }


    }

    //登出
    public void logout (HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //销毁会话
        session.invalidate();

        //清除Coolie
        Cookie usernameCookie = new Cookie("username","");
        Cookie passwordCookie = new Cookie("password","");

        usernameCookie.setMaxAge(0);
        passwordCookie.setMaxAge(0);

        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);

        request.getRequestDispatcher(request.getContextPath()+"index.jsp").forward(request,response);
    }
























}
