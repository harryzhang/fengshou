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
            <li><a target="_self" href="index.html">首 页</a></li>
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
    <div class="container policy-container mt20">
        <div class="policy-form" id="appCtrl" v-loack>
            <div class="title">【丰收经纪—中国人寿】老司机全球驾乘意外险</div>
            <el-steps :active="stepIndex" finish-status="success" simple style="margin-top: 20px">
                <el-step title="告知" ></el-step>
                <el-step title="填写保单" ></el-step>
                <el-step title="保单确认" ></el-step>
                <el-step title="在线缴费" ></el-step>
            </el-steps>
            

            <p style="padding: 20px 0 0 0" class="cRed"><i class="el-icon-warning"></i> 请于2018年02月17日24时前完成支付，否则订单将取消</p>

            <h3>产品信息</h3>
            
            <ul class="policy-list">
                <li><span class="cGray">保险名称：</span>爱健康百万医疗保险</li>
                <li><span class="cGray">保险金额：</span>300万</li>
                <li><span class="cGray">保险期间：</span>2018年02月18日0时—2019年2月18日24时</li>
                <li><span class="cGray">保费金额：</span> <span class="cGold">300万人民币</span></li>
                <li style="text-indent: -5em;padding-left: 5em;">
                    <span class="cGray">保障范围：</span>
                    一般医疗保险金 300万，免赔额1万（300万，免赔额1万）；<br>
                    恶性肿瘤医疗保险金（300万）；<br>
                    恶性肿瘤住院津贴保险金（3.6万）；<br>
                    附加阳光就医陪同服务。<br>
                </li>
            </ul>

            <h3>投保人信息</h3>

            <ul class="policy-list">
                <li><span class="cGray">投保人姓名：</span>   李四</li>
                <li><span class="cGray">身份证号码：</span>   512501197203035172</li>
                <li><span class="cGray">手机号码：</span>    17877777777</li>
                <li><span class="cGray">电子邮箱：</span>    dsaf@qq.com</li>
                <li><span class="cGray">居住城市：</span>    广东深圳市</li>
            </ul>

            <h3>被保险人信息</h3>
            <ul class="policy-list">
                <li><span class="cGray">被保险人是您：</span>  本人</li>
                <li><span class="cGray">被保险人姓名：</span>  换什么</li>
                <li><span class="cGray">身份证号码：</span>   512501197203035172</li>
                <li><span class="cGray">手机号码：</span>    17877777777</li>
                <li><span class="cGray">有无社保：</span>    有</li>
            </ul>

            <h3>受益人信息</h3>
            <ul class="policy-list">
                <li><span class="cGray">受益人：</span>  法人</li>
            </ul>

            <div class="payment">
                <ul>
                    <li> <span class="cGray">保险金额：</span> <span class="cRed">￥200.00</span></li>
                    <li style="border-bottom: 1px solid #ccc"> <span class="cGray">优　　惠：</span> <span class="cRed">￥0.00</span></li>
                    <li> <span class="cGray">合　　计：</span> <span class="cRed">￥200.00</span></li>
                </ul>
                <p style="padding: 10px 0" class="cRed"><i class="el-icon-warning"></i> 请于2018年02月17日24时前完成支付，否则订单将取消</p>
                <div class="agreement">
                    <el-checkbox v-model="check">
                        我已阅读并同意
                    </el-checkbox>
                    <a href="" class="cRed">《客户告知书》</a>

                    <el-button @click="onSubmit" type="primary">立即支付</el-button>
                </div>
            </div>
        </div>
    </div>
    <footer class="footer">
        <div class="container">
            <h3 class="footer-title">专业服务</h3>
            <ul class="guide-list clearfix">
                <li>
                    <i class="i1"></i>
                    <h3>7 x 24小时客服</h3>
                    <p>随时随地有保障</p>
                </li>
                <li>
                    <i class="i2"></i>
                    <h3>专业理赔服</h3>
                    <p>快速理赔不用等</p>
                </li>
                <li>
                    <i class="i3"></i>
                    <h3>保监会授权</h3>
                    <p>合法权威值得信赖</p>
                </li>
                <li>
                    <i class="i4"></i>
                    <h3>轻松投保</h3>
                    <p>多终端服务 轻松快捷</p>
                </li>
            </ul>
            <div class="service-container clearfix">
                <div class="aboutus-list">
                    <ul class="clearfix">
                        <li><a href="article_detail.html?id=3432">平台动态</a></li>
                        <li><a href="article_detail.html?id=3432">关于我们</a></li>
                        <li><a href="article_detail.html?id=124234">帮助中心</a></li>
                        <li><a href="article_detail.html?id=124234">媒体报道</a></li>
                        <li><a href="article_detail.html?id=124234">安全保障</a></li>
                        <li><a href="article_detail.html?id=124234">新手必读</a></li>
                        <li><a href="article_detail.html?id=124234">平台公告</a></li>
                        <li><a href="article_detail.html?id=124234">联系我们</a></li>
                        <li><a href="article_detail.html?id=124234">投研学堂</a></li>
                    </ul>
                </div>
                <ul class="service-qr left">
                    <li>
                        <img src="images/qr_code.png" alt="" width="94" height="94">
                        <p>关注公众号，活动早知道</p>
                    </li>
                    <li>
                        <a href="" target="_blank"><img src="images/qr_code.png" alt="" width="94" height="94"></a>
                        <p>下载APP，随时享收</p>
                    </li>
                </ul>
                <div class="service-list left">
                    <p class="telphone">400-666-8888</p>
                    <p>客服工作时间 08:30-20:30</p>
                    <a href="" class="udesk">一对一专属客服服务</a>
                    <p>service@163.com</p>
                    <p>深圳市福田区深南中路NEO大厦A座24层</p>
                    <div class="border-left"></div>
                </div>
            </div>
        </div>
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
    <script src="js/city-data.js"></script>
    <script>
        var vm = new Vue({
            el: '#appCtrl',
            data: function(){
                return {
                    check:true,
                    stepIndex:2
                }
            },

            methods:{
                onSubmit: function(){
                    if(!this.check){
                        this.$message.error('必须同意协议')
                        return;
                    }
                    location.href = 'payment.html';
                }
            }
        })
    </script>

</body>

</html>