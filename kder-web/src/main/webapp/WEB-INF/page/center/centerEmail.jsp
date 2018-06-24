<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="css/base.css" />
    <link rel="stylesheet" href="css/element.css" />
    <link rel="stylesheet" href="css/main.css" />
</head>
<body>
    <div class="top-bar">
        <div class="container clearfix">
            <p class="left">
                <a href="article_detail.html?typeid=1001">保单验证</a> |
                <a href="article_detail.html?typeid=1002">信息披露</a> |
                <a href="article_detail.html?typeid=1003">关于我们</a> |
                <a href="article_detail.html?typeid=1004">联系我们</a>
            </p>
            <p class="right">
            <a href="login.html">登陆</a> |
            <a href="register.html">注册</a>
            </p>
        </div>
    </div>
    <div class="top-header">
        <div class="container clearfix">
            <a href="index.html" class="logo">
                <img src="images/logo.png" alt="" width="177" height="47" />
            </a>
            <ul class="header-nav">
                <li><a class="on" target="_self" href="index.html">首 页</a></li>
                <li><a target="_self" href="products_list.html">全部保险产品</a></li>
                <li><a target="_self" href="claims.html">保险理赔</a></li>
                <li><a target="_self" href="">企业团险</a></li>
                <li><a target="_self" href="center_orders.html">我的保单</a></li>
            </ul>
            <div class="header-rnav right">
<a href="private_custom.html">
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
            <img src="images/user_avator.jpg" height="90" width="90" alt="" />
            <p>Hi，12345678900</p>
        </div>
        <dl>
            <dt>
                <i class="i1"></i>
                我的账户
            </dt>
            <dd><a href="center_settings.html">账户及密码</a></dd>
            <dd><a href="center_contacts.html">常用联系人</a></dd>
        </dl>
        <dl>
            <dt>
                <i class="i2"></i>
                订单管理
            </dt>
            <dd><a href="center_orders.html?type=1">已完成订单</a></dd>
            <dd><a href="center_orders.html?type=2">未完成订单</a></dd>
            <dd><a href="center_orders.html?type=3">可续保订单</a></dd>
        </dl>
        <dl>
            <dt>
                <i class="i3"></i>
                我的钱包
            </dt>
            <dd><a href="">我的积分</a></dd>
        </dl>
    </div>
    <div class="center-content">
        <div class="inner-content">
            <div class="center-title clearfix">
                <span>绑定邮箱</span>
            </div>

            <div class="mail-content" id="appCtrl" v-loack>
                <el-steps :active="stepIndex" finish-status="success" simple style="margin-top: 20px">
                    <el-step title="输入邮箱" ></el-step>
                    <el-step title="验证邮箱" ></el-step>
                    <el-step title="绑定成功" ></el-step>
                </el-steps>
                
                <div v-if="stepIndex===0" style="margin:80px auto 40px;width:400px;min-height:300px">
                    <el-form 
                    label-position="right"
                    label-width="120px" 
                    ref="form"
                    :rules="rules"
                    :model="form">
                          <el-form-item label="邮箱：" prop="email">
                            　　<el-input v-model.trim="form.email" placeholder="请输入邮箱地址"></el-input>
                          </el-form-item>
                          <el-form-item label="　　">
                            　　<el-button @click="onSubmit" type="primary" style="width:100%">下一步</el-button>
                          </el-form-item>
                    </el-form>            
                </div>

                <div v-else-if="stepIndex===1" style="margin:80px auto 40px;width:400px;min-height:300px">
                    <el-form 
                    label-position="right"
                    label-width="120px" 
                    ref="form"
                    :rules="rules"
                    :model="form">
                          <el-form-item label="邮箱验证码：" prop="identity">
                            　　<el-input v-model.trim="form.identity" placeholder="请输入邮箱验证码"></el-input>
                          </el-form-item>
                          <el-form-item label="　　">
                            　　<el-button @click="onSubmit" type="primary" style="width:100%">确定</el-button>
                            <p><a href="javascript:;" @click="stepIndex=1" class="cGray">返回修改邮箱</a></p>
                          </el-form-item>
                    </el-form>            
                </div>

                <div v-else-if="stepIndex===2" style="margin:80px auto 40px;width:400px;min-height:300px">
                    <div style="text-align:center">
                        <i class="el-icon-success" style="font-size:50px;color:#A17E41"></i>
                        <p class="cGray" style="padding-top:18px">恭喜您，邮箱绑定成功</p>
                    </div>
                </div>

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
    <script src="js/jquery.js"></script>
    <script src="js/vue.js"></script>
    <script src="js/element.js"></script>
    <script>
        var vm = new Vue({
            el: '#appCtrl',
            data: function(){
                return {
                    stepIndex:0,
                    form:{
                        email:''
                    },
                    rules:{
                        email:[
                            { required: true, message: '请输入邮箱地址', trigger: 'blur' },
                            { validator:function(rule, value, callback){
                                if(!/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test(value)){
                                    callback(new Error('邮箱格式有误'));
                                }else{
                                    callback()
                                }
                            }, trigger: 'blur'}
                        ],
                        identity:[
                            { required: true, message: '请输入邮箱验证码', trigger: 'blur' },
                            { validator:function(rule, value, callback){
                                if(value.length<4){
                                    callback(new Error('邮箱格式有误'));
                                }else{
                                    callback()
                                }
                            }, trigger: 'blur'}
                        ]
                    }
                }
            },

            methods:{
                onSubmit: function(){
                    var that = this;
                    this.$refs.form.validate(function(valid){
                        if(valid){
                            if(that.stepIndex==0){
                                that.stepIndex = 1;
                                alert('提交表单00000')
                            }else if(that.stepIndex==1){
                                that.stepIndex = 2;
                                alert('提交表单11111')
                            }else if(that.stepIndex==2){
                                alert('提交表单22222')
                            }
                        }else{
                            return false;
                        }
                    }) 
                }
            }
        })
    </script>
</body>

</html>