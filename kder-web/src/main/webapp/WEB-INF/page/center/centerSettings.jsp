<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value='/css/base.css'/>" />
    <link rel="stylesheet" href="<c:url value='/css/element.css'/>" />
    <link rel="stylesheet" href="<c:url value='/css/main.css'/>" />
    
</head>
<body>
    <div class="top-bar">
        <div class="container clearfix">
            <p class="left">
                <a href="http://test.51dfs.cn/article_detail.html?typeid=1001">保单验证</a> |
                <a href="http://test.51dfs.cn/article_detail.html?typeid=1002">信息披露</a> |
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
                <li><a class="on" target="_self" href="http://test.51dfs.cn/index.html">首 页</a></li>
                <li><a target="_self" href="http://test.51dfs.cn/products_list.html">全部保险产品</a></li>
                <li><a target="_self" href="http://test.51dfs.cn/claims.html">保险理赔</a></li>
                <li><a target="_self" href="">企业团险</a></li>
                <li><a target="_self" href="http://test.51dfs.cn/kder-api/setting/mypolicy.do">我的保单</a></li>
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
            <dd class="on"><a href="center_settings.html">账户及密码</a></dd>
            <dd><a href="center_contacts.html">常用联系人</a></dd>
        </dl>
        <dl>
            <dt>
                <i class="i2"></i>
                订单管理
            </dt>
            <dd><a href="http://test.51dfs.cn/kder-api/setting/mypolicy.do?orderStatus=5">已完成订单</a></dd>
            <dd><a href="http://test.51dfs.cn/kder-api/setting/mypolicy.do?orderStatus=1">未完成订单</a></dd>
            <dd><a href="http://test.51dfs.cn/kder-api/setting/mypolicy.do?orderStatus=4">可续保订单</a></dd>
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
            <div class="center-title clearfix">
                <span>账户及密码</span>
            </div>
            <div class="account-content" id="appCtrl" v-loack style="min-height:300px">
                <table class="setting-list">
                    <tr>
                        <td class="title">
                            <i class="phone"></i>
                            手机号
                        </td>
                        <td>
                            <p class="cGray">${sysUserDo.peoplePhone}</p>
                        </td>
                        <td class="edit">
                            <p class="cGray">已绑定</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="title">
                            <i class="email"></i>
                            电子邮箱
                        </td>
                        <td>
                            <p class="cGray">${sysUserDo.peopleMail}</p>
                        </td>
                        <td class="edit">
                            <a href="center_email.html" class="cBlue">绑定</a>
                        </td>
                    </tr>
                    <tr>
                        <td class="title">
                            <i class="psw"></i>
                            密码
                        </td>
                        <td>
                            <p class="cGray">*******</p>
                        </td>
                        <td class="edit">
                            <a href="center_update_login_password.html" class="cBlue">修改</a>
                        </td>
                    </tr>
                </table>
            </div>

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
        var vm = new Vue({
            el: '#appCtrl',
            data: function(){
                return {}
            },

            methods:{
                onSubmit: function(){
   
                }
            }
        })
    </script>
</body>

</html>