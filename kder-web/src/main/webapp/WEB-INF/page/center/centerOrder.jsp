<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>我的保单</title>
    <link rel="stylesheet" href="<c:url value='/css/base.css'/>" />
    <link rel="stylesheet" href="<c:url value='/css/element.css'/>" />
    <link rel="stylesheet" href="<c:url value='/css/main.css'/>" />
    
</head>
<body>
    <div class="top-bar">
        <div class="container clearfix">
            <p class="left">
                <a href="http://test.51dfs.cn/article_detail.html?typeid=1001">保单验证</a> |
                <a href="http://test.51dfs.cn/html/1/93/94/index.html?topNgId=5">信息披露</a> |
                <a href="http://test.51dfs.cn/article_detail.html?typeid=1003">关于我们</a> |
                <a href="http://test.51dfs.cn/article_detail.html?typeid=1004">联系我们</a>
            </p>
            <p class="right">
            <a href="login.html">退出</a>
            </p>
        </div>
    </div>
    <div class="top-header">
        <div class="container clearfix">
            <a href="index.html" class="logo">
                <img src="http://test.51dfs.cn/templets/1/fengshou//images/logo.png" alt="" width="177" height="47" />
            </a>
            <ul class="header-nav">
                <li><a target="_self" href="http://test.51dfs.cn/">首 页</a></li>
                <li><a target="_self" href="http://test.51dfs.cn/ins/view/index.do">全部保险产品</a></li>
                <li><a target="_self" href="http://test.51dfs.cn/claims.html">保险理赔</a></li>
                <li><a target="_self" href="">企业团险</a></li>
                <li><a class="on" target="_self" href="http://test.51dfs.cn/kder-api/setting/mypolicy.do">我的保单</a></li>
            </ul>
            <div class="header-rnav right">
<a href="http://test.51dfs.cn/private_custom.html">
                <i class="i1"></i>
                定制
            </a>
                <a href="">
                    <i class="i2"></i>
                    公众号
                </a>
            </div>
        </div>
    </div>    
<div class="container mt20 clearfix">
    <div class="side-nav">
        <div class="user-info">
            <img src="http://test.51dfs.cn/templets/1/fengshou//images/user_avator.jpg" height="90" width="90" alt="" />
            <p>Hi，${sysUserDo.peoplePhone}</p>
        </div>
        <dl>
            <dt>
                <i class="i1"></i>
                我的账户
            </dt>
            <dd><a href="http://test.51dfs.cn/kder-api/setting/toSetting.do">账户及密码</a></dd>
            <!-- 
            <dd><a href="center_contacts.html">常用联系人</a></dd>
             -->
        </dl>
        <dl>
            <dt>
                <i class="i2"></i>
                订单管理
            </dt>
            <dd 
            	<c:choose>
            		<c:when test="${orderStatus eq '5'}">
            		   class="on"
            		</c:when>
            	</c:choose>
            ><a href="http://test.51dfs.cn/kder-api/setting/mypolicy.do?orderStatus=5">已完成订单</a></dd>
            <dd
            	<c:choose>
            		<c:when test="${orderStatus eq '1'}">
            		   class="on"
            		</c:when>
            	</c:choose>
            ><a href="http://test.51dfs.cn/kder-api/setting/mypolicy.do?orderStatus=1">未完成订单</a></dd>
            <dd
            	<c:choose>
            		<c:when test="${orderStatus eq '1'}">
            		   class="on"
            		</c:when>
            	</c:choose>
            ><a href="http://test.51dfs.cn/kder-api/setting/mypolicy.do?orderStatus=4">可续保订单</a></dd>
        </dl>
        <!-- 
        <dl>
            <dt>
                <i class="i3"></i>
                我的钱包
            </dt>
            <dd><a href="">我的积分</a></dd>
        </dl>
         -->
    </div>
    <div class="center-content">
        <div class="inner-content">

            <div class="orders-content" id="appCtrl" v-loack style="min-height:500px">
                <el-tabs v-model="tabActiveName" @tab-click="tabHandleClick">
                    <el-tab-pane label="已完成订单" :name="5"></el-tab-pane>
                    <el-tab-pane label="未完成订单" :name="1"></el-tab-pane>
                    <el-tab-pane label="可续保订单" :name="4"></el-tab-pane>
                </el-tabs>
                		<c:choose>
                		<c:when test="${!empty ordPage}">
                        <table>
                            <thead>
                                <tr class="main">
                                    <th>保险产品</th>
                                    <th>被保险人</th>
                                    <th>金额</th>
                                    <th>操作</th>
                                </tr>   
                            </thead>
                           
                            <c:forEach items="${ordPage.datas}" var="order">
                            <tbody>
                                <tr class="meta">
                                    <td colspan="3">
                                        投保时间：<fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd" />
                                        保单号：${order.orderNo}
                                    </td>
                                    <td>
                                        <a class="cGray" href="">查看详情 &gt;</a>
                                    </td>
                                </tr>
                                <tr class="info">
                                    <td>
                                        <h3>${order.productName}</h3>
                                        <p>起：<fmt:formatDate value="${order.startTime}" pattern="yyyy-MM-dd" /></p>
                                        <p>止：<fmt:formatDate value="${order.endTime}" pattern="yyyy-MM-dd" /></p>
                                    </td>
                                    <td>${order.userName}</td>
                                    <td>${order.orderAmt}元</td>
                                    <!-- 
                                    <td>
                                        <el-button size="mini">评论</el-button>
                                    </td>
                                     -->
                                </tr>
                            </tbody>
                            </c:forEach>
                        </table>
                        </c:when>
						<c:otherwise>                        
                        <div class="empty-order">
                            <i></i>
                            <span class="cGray">暂无相关订单，去<a href="http://test.51dfs.cn/" class="cBlue">首页</a>逛逛吧~</span>
                        </div>
                        </c:otherwise>
                        </c:choose>
                <el-pagination
                  style="padding: 28px;text-align: right;"
                  :background="true"
                  prev-text="上一页"
                  next-text="下一页"
                  layout="prev, pager, next"
                  :page-size="pageSize"
                  :total="total"
                  :current-page="currentPage"
                  @current-change="currentChange">
                </el-pagination>

            </div>

        </div>
    </div>
</div>

    <footer class="footer">
        <div class="copyright">
            <div class="footer-with-logo">
                    <span class="footer-with-logo-icp"><a rel="nofollow" title="ICP备案查询" href="http://www.miitbeian.gov.cn/publish/query/indexFirst.action" target="_blank"></a></span>
                    <span class="footer-with-logo-netservice"><a rel="nofollow" title="工商网监" href="" target="_blank"></a></span>
                    <!-- <span class="footer-with-logo-vsafe"><a title="安全联盟行业验证" href="" target="_blank"></a></span>  -->
            </div>
            <p>
                <a rel="nofollow" href="http://www.iachina.cn/" target="_blank">中国保险行业协会</a> |
                <a rel="nofollow" href="https://iask.sina.com.cn/search?searchWord=%E4%BF%9D%E9%99%A9&record=1" target="_blank">新浪爱问保险</a> |
                <a rel="nofollow" href="https://insurance.cngold.org/" target="_blank">金投保险</a> |
                <a rel="nofollow" href="" target="_blank">腾讯保险</a> |
                <a rel="nofollow" href="http://www.rmic.cn/" target="_blank">中国保险网</a>
            </p>
            <p>Copyright ©2013-2018 深圳市康达尔（集团）股份有限公司 粤ICP备08029152号</p>
        </div>
    </footer>
    <script src="<c:url value='/js/jquery.js'/>"></script>
    <script src="<c:url value='/js/vue.js'/>"></script>
    <script src="<c:url value='/js/element.js'/>"></script>
    <script>
    var parseURL = function(url) {
            var a = document.createElement('a');
            a.href = url || window.location.href;
            return {
                source: url,
                protocol: a.protocol.replace(':', ''),
                host: a.hostname,
                port: a.port,
                query: a.search,
                params: (function() {
                    var ret = {},
                        seg = a.search.replace(/^\?/, '').split('&'),
                        len = seg.length,
                        i = 0,
                        s;
                    for (; i < len; i++) {
                        if (!seg[i]) {
                            continue;
                        }
                        s = seg[i].split('=');
                        ret[s[0]] = s[1];
                    }
                    return ret;
                })(),
                file: (a.pathname.match(/\/([^\/?#]+)$/i) || [, ''])[1],
                hash: a.hash.replace('#', ''),
                path: a.pathname.replace(/^([^\/])/, '/$1'),
                relative: (a.href.match(/tps?:\/\/[^\/]+(.+)/) || [, ''])[1],
                segments: a.pathname.replace(/^\//, '').split('/')
            };
        };   

        var tabActiveName = parseInt(parseURL().params.orderStatus) || 1;
        var vm = new Vue({
            el: '#appCtrl',
            data: function(){
                return {
                    tabActiveName: tabActiveName,
                    currentPage:parseInt(parseURL().params.currentPage) || 1,
                    pageSize: ${ordPage.rows},
                    total:${ordPage.totalPage}
                }
            },

            methods:{
                currentChange:function(pageIndex){
                    location.href = 'http://test.51dfs.cn/kder-api/setting/mypolicy.do?currentPage='+pageIndex+'&orderStatus=' + this.tabActiveName;
                },
                tabHandleClick: function(){
                    location.href = 'http://test.51dfs.cn/kder-api/setting/mypolicy.do?currentPage=1&orderStatus=' + this.tabActiveName;
                }
            },


        })
    </script>
</body>

</html>