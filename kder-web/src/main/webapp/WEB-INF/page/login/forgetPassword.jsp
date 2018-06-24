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
    <div class="register-container" id="regCtrl" v-loack>
        <el-form 
        ref="form" 
        :model="form" 
        :rules="rules"
        label-width="120px">
            <div class="form-title">忘记登陆密码</div>
            <el-form-item label="手机号" prop="phone">
                <el-input v-model.trim="form.phone" placeholder="请输入登陆手机号"></el-input>
            </el-form-item>
            <el-form-item label="图形验证码" prop="code">
                <el-input v-model.trim="form.code" placeholder="请输入图形验证码"></el-input>
                <img :src="imgSrc" style="cursor: pointer;" @click="updateTimestamp" height="38" width="96" alt="" />
            </el-form-item>
            <el-form-item label="手机验证" prop="indentify">
                <el-input v-model.trim="form.indentify" placeholder="请输入短信验证码"></el-input>
                <el-button :disabled="time<60&&time>0" type="primary" @click="onSendSubmit">
                    {{time<60&&time>0?time+'秒':(time==60?'免费获取':'重新获取')}}
                </el-button>
            </el-form-item>
            <el-form-item label="设置新密码" prop="psw">
                <el-input type="password" v-model.trim="form.psw" placeholder="字母、数字或者英文符号，最短6位，区分大小写"></el-input>
            </el-form-item>
            <el-form-item label="再次确认密码" prop="confirmPsw">
                <el-input v-model.trim="form.confirmPsw" placeholder="请输入确认密码"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button style="width: 350px" type="primary" @click="onSubmit">立即注册</el-button>
            </el-form-item>
        </el-form>
    </div>



    <footer class="footer" style="margin: 0;border: none;padding-top: 0;">
        <div class="copyright">
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
        var vmodel = new Vue({
            el:'#regCtrl',
            data:function(){
                var confirmPsw = function(rule, value, callback){
                    if(vmodel.form.psw!=value){
                        callback(new Error('两次输入密码不一致!'));
                    }else{
                        callback();
                    }
                };
                return {
                    time:60,
                    interval:null,
                    form: {
                          phone: '',
                          code: '',
                          indentify: '',
                          psw: '',
                          confirmPsw: ''
                    },

                    rules:{
                        phone:[
                            { required: true, message: '请输入手机号', trigger: 'blur' },
                            { validator:function(rule, value, callback){
                                if(!/^0?(13|14|15|16|17|18|19)[0-9]{9}$/.test(value)){
                                    callback(new Error('手机号码格式有误'));
                                }else{
                                    callback()
                                }
                            }, trigger: 'blur'}
                        ],

                        code:[
                            { required: true, message: '请输入图形验证码', trigger: 'blur' },
                            { min: 4, max: 4, message: '图形验证码错误', trigger: 'blur' }
                        ],

                        indentify:[
                            { required: true, message: '请输入短信验证码', trigger: 'blur' },
                            { min: 6, max: 6, message: '短信验证码错误', trigger: 'blur' }
                        ],

                        psw:[
                            { required: true, message: '请输入密码', trigger: 'blur' },
                            { min: 6, max: 20, message: '密码长度6~20个字符', trigger: 'blur' }
                        ],

                        confirmPsw:[
                            { required: true, message: '请输入确认密码', trigger: 'blur' },
                            { validator: confirmPsw, trigger:'blur'}
                        ]

                    },

                    timestamp: new Date().getTime()
                }
            },
            computed:{
                imgSrc: function(){
                    return 'http://www.thinkphp.cn/member/verify.html?_='+this.timestamp
                }
            },
            methods:{
                updateTimestamp:function(){
                    this.timestamp = new Date().getTime();
                },
                onSendSubmit: function(){
                    var that = this;
                    this.$refs.form.validateField('phone',function(msg){
                        !msg && that.$refs.form.validateField('code', function(msg){
                            if(!msg){
                                alert('这里编写发送短信')
                              /*  $.ajax({
                                    url:'',
                                    dataType:'json',
                                    data:{
                                        phone: that.form.phone,
                                        code: that.form.code
                                    },
                                    success:function(res){
                                        that.countdown();
                                    }
                                })*/
                                // 发送短信后倒计时
                                that.countdown();
                            }
                        })
                    })
                },
                
                countdown:function(){
                    var that = this;
                    if(this.time!==60||this.time<=0)return;
                    this.time = 59;
                    this.interval = setInterval(function(){
                        if(that.time>0&&that.time<=60){
                            that.time--;
                        }else{
                            clearTimeout(that.interval)
                        }
                    },1000)
                },

                onSubmit: function() {
                    var that = this;
                    this.$refs.form.validate(function(valid){
                        if(valid){
                            alert('提交表单')
                            that.$message.error('手机短信验证码错误');
                            location.href = '找回密码成功.html';
                        }else{
                            return false;
                        }
                    })
                },
            }
        })
    </script>
</body>

</html>