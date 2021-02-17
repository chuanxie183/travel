<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 头部 start -->
    <header id="header">
        <div class="top_banner">
            <img src="images/top_banner.jpg" alt="">
        </div>
        <div class="shortcut">
            <!-- 未登录状态  -->


            <div class="login">

                <%-- 未登录状态  --%>
            	<c:if test="${sessionScope.user==null}">
                    <div class="login_out">
                        <a href="login.jsp">登录</a>
                        <a href="register.jsp">注册</a>
                    </div>
                </c:if>
                <!-- 登录状态  -->
                <c:if test="${sessionScope.user!=null}">
                    <span>欢迎${sessionScope.user.username}<a href="${path}/user?method=logout">登出</a></span>
                </c:if>

                <a href="myfavorite.jsp" class="collection">我的收藏</a>
            </div>
        </div>
        <div class="header_wrap">
            <div class="topbar">
                <div class="logo">
                    <a href="/"><img src="" alt=""></a>
                </div>

                <%-- 当前若是路线列表展示，则头部页面有表单显示 --%>
                <c:if test="${vo==null}">

                <div class="search">
                    <input name="rname" type="text" placeholder="请输入路线名称" id="searchName" class="search_input" autocomplete="off" value="${vo.query2}">
                    <%--<a href="${path}/route?method=viewRouteListByCidRname&cid=${vo.query1}&rname="+$(#searchName).val() class="search-button">搜索</a>--%>
                    <input type="button" onclick="query()" class="search-button" value="查询"/>

                    <script>
                        function query(){
                            window.location.href="${path}/route?method=viewRouteListByCidRname&rname="+$("#searchName").val();
                        }
                    </script>
                </div>


                </c:if>



                <div class="hottel">
                    <div class="hot_pic">
                        <img src="images/hot_tel.jpg" alt="">
                    </div>
                    <div class="hot_tel">
                        <p class="hot_time">客服热线(9:00-6:00)</p>
                        <p class="hot_num">400-618-9090</p>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- 头部 end -->
     <!-- 首页导航 -->
    <div class="navitem">
        <ul class="nav" id="categorys">
            <%--<li class="nav-active"><a href="${path}/route?method=index">首页</a></li>--%>
                <%-- 动态在数据库中查询旅游路线分类的展示  --%>

        </ul>
    </div>

<script>

    var data = "";
    data +="<li><a href='${path}/route?method=index'>"+"首页"+"</a></li>";
    $.ajax({
        type:"get",
        url:"${path}/category?method=viewAllCategory",
        dataType:"json",
        success:function(categoryList){

            for (var i in categoryList) {  //i是集合的下标
                //console.log("i = "+i)
                data += "<li><a href='${path}/route?method=viewRouteListByCidRname&cid="+categoryList[i].cid+"'>"+categoryList[i].cname+"</a></li>";
            }
            $("#categorys").html(data);
        }
    });

</script>
    