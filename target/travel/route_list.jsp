<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>旅游-路线列表</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/search.css">
    <script src="js/jquery-3.3.1.js"></script>
</head>
<body>
<!--引入头部-->
<div id="header"></div>
    <div class="page_one">
        <div class="contant">
            <div class="crumbs">
                <img src="images/search.png" alt="">
                <p>旅行><span>${cname}</span></p>
            </div>
            <div class="xinxi clearfix">
                <div class="left">
                    <div class="header">
                        <span>商品信息</span>
                        <span class="jg">价格</span>
                    </div>
                    <ul>
                        <c:forEach items="${vo.list}" var="route">

                            <script>
                                console.log(1)
                            </script>
                            <li>
                                <div class="img"><img src="${route.rimage}" alt=""></div>
                                <div class="text1">
                                    <p>${route.rname}</p>
                                    <br/>
                                    <p>${route.routeIntroduce}</p>
                                </div>
                                <div class="price">
                                    <p class="price_num">
                                        <span>&yen;</span>
                                        <span>${route.price}</span>
                                        <span>起</span>
                                    </p>
                                    <p><a href="${path}/route?method=selectOneRouteByRid&rid=${route.rid}&cid=${vo.query1}&rname=${vo.query2}&pageNow=${vo.pageNow}">查看详情</a></p>
                                </div>
                            </li>

                        </c:forEach>

                    </ul>


           <%--  分页  --%>
                    <div class="page_num_inf">
                        <i></i> 共
                        <span>${vo.myPages}</span>页<span>${counts}</span>条
                    </div>
                    <c:if test="${vo.list.size() != 0}">
                    <div class="pageNum">
                        <ul>
                            <%--<li><a href="">首页</a></li>--%>

                                <%-- 若在第一页，则不可以点击上一页  --%>
                            <c:if test="${vo.pageNow == 1}">
                                <li class="threeword"><a href="JavaScript:void(0)">上一页</a></li>
                            </c:if>

                            <%-- 若不在第一页，则可以点击上一页 --%>
                            <c:if test="${vo.pageNow != 1}">
                                <li class="threeword"><a href="${path}/route?method=viewRouteListByCidRname&cid=${vo.query1}&rname=${vo.query2}&pageNow=${vo.pageNow-1}">上一页</a></li>
                            </c:if>

                            <c:forEach begin="1" end="${vo.myPages}" var="page">
                                <%--若当前页码pageNow正好是page ,则显示被点击的状态  --%>
                                <c:if test="${vo.pageNow == page}">
                                    <li><a href="JavaScript:void(0)">${page}</a></li>
                                </c:if>

                                <%--若当前页码pageNow不是page ，则显示可以点击的状态  --%>
                                <c:if test="${vo.pageNow != page}">
                                    <li><a href="${path}/route?method=viewRouteListByCidRname&cid=${vo.query1}&rname=${vo.query2}&pageNow=${page}">${page}</a></li>
                                </c:if>

                            </c:forEach>

                            <%-- 若在最后一页，则不可点击下一页 --%>
                            <c:if test="${vo.pageNow == vo.myPages}">
                                <li class="threeword"><a href="javascript:void(0);">下一页</a></li>
                            </c:if>

                            <%-- 若不在最后一页 ，则可以点击下一页 --%>
                            <c:if test="${vo.pageNow != vo.myPages}">
                                <li class="threeword"><a href="${path}/route?method=viewRouteListByCidRname&cid=${vo.query1}&rname=${vo.query2}&pageNow=${vo.pageNow+1}">下一页</a></li>
                            </c:if>


                           <%-- <li class="threeword"><a href="javascript:;">末页</a></li>--%>
                        </ul>
                    </div>
                </div>
                    </c:if>


                <div class="right">
                    <div class="top">
                        <div class="hot">HOT</div>
                        <span>热门推荐</span>
                    </div>
                    <ul>
                        <c:forEach items="${requestScope.routesCount}" var="route">
                            <li>
                                <div class="left"><img src="${route.rimage}" alt=""></div>
                                <div class="right">
                                    <p>${route.rname}</p>
                                    <p>网付价<span>&yen;<span>${route.price}</span>起</span>
                                    </p>
                                </div>
                            </li>
                        </c:forEach>




                    </ul>
                </div>
            </div>
        </div>
    </div>

    <!--引入头部-->
    <div id="footer"></div>
    <!--导入布局js，共享header和footer-->
    <script type="text/javascript" src="js/include.js"></script>
</body>

</html>