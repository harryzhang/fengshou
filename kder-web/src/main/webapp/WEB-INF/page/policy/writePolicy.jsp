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
                <a href="article_detail.html?typeid=1001">保单验证</a> |
                <a href="article_detail.html?typeid=1002">信息披露</a> |
                <a href="article_detail.html?typeid=1003">关于我们</a> |
                <a href="article_detail.html?typeid=1004">联系我们</a>
        </p>
        <p class="right">
            <a href="<c:url value='/login.do'/>">登陆</a> |
            <a href="<c:url value='/register.do'/>">注册</a>
        </p>
    </div>
</div>
<div class="top-header">
    <div class="container clearfix">
        <a href="<c:url value='/index.html'/>" class="logo">
            <img src="<c:url value='/images/logo.png'/>" alt="" width="177" height="47" />
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
    <div class="container policy-container mt20">
        <div class="policy-form" id="appCtrl" v-loack>
            <div class="title">【丰收经纪—中国人寿】老司机全球驾乘意外险</div>
            <el-steps :active="stepIndex" finish-status="success" simple style="margin-top: 20px">
                <el-step title="告知" ></el-step>
                <el-step title="填写保单" ></el-step>
                <el-step title="保单确认" ></el-step>
                <el-step title="在线缴费" ></el-step>
            </el-steps>
            <h2>投保人 <span>仅限本人亲自投保</span></h2>
            <el-form 
            label-position="left"
            label-width="120px" 
            ref="form"
            :rules="rules"
            :model="form">
                  <el-form-item label="从常用人中选择" v-if="contacts.length">
                    <el-radio-group v-model="radio">
                    　　<el-radio 
                        v-for="(el,index) in contacts"
                        :key="index" 
                        name="contact"
                        :label="index">{{el.name}}</el-radio>
                    </el-radio-group>
                  </el-form-item>
                  <el-form-item label="姓　　名" prop="name">
                  <el-input v-model.trim="form.name" placeholder="请输入联系人姓名"></el-input>
                  </el-form-item>
                    <el-form-item label="证件类型" prop="credType">
                        <el-select
                            style="width:100%"
                            v-model="form.credType"
                            placeholder="请选择证件类型">
                            <el-option
                              v-for="item in credOptions"
                              :key="item.value"
                              :label="item.label"
                              :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="证件号码" prop="idNo">
                        <el-input v-model.trim="form.idNo" placeholder="请输入证件号"></el-input>
                    </el-form-item>
                    <el-form-item label="手 机 号" prop="mobile">
                        <el-input type="text" v-model.trim="form.mobile" placeholder="请输入联系人手机号"></el-input>
                    </el-form-item>
                    <el-form-item label="地　　址" prop="area">
                        <el-cascader
                        placeholder="省/市/县"
                        style="width:100%"
                        :options="cityInfoOptions"
                        v-model="form.areaValue"
                        expand-trigger="click"
                        @change="areaHandleChange">
                      </el-cascader>
                    </el-form-item>
                  <h2 style="margin-bottom:20px">被保人</h2>
                    <el-form-item label="　　">
                        <el-checkbox v-model="form.same">被保险人与投保人为同一人</el-checkbox>
                    </el-form-item>
                    <div v-if="form.same===false">
                        <el-form-item label="被保险人姓名" :rules="[{ required: true, message: '请输入联系人姓名', trigger: 'blur' }]">
                            <el-input v-model.trim="form.protectName" placeholder="请输入被保人姓名"></el-input>
                        </el-form-item>
                        
                        <el-form-item label="被保险人是您" :rules="[{ required: true, message: '不能为空', trigger: 'blur' }]">
                            <el-select
                                style="width:100%"
                                v-model="form.relationshipType"
                                placeholder="请选择证件类型">
                                <el-option
                                  v-for="item in relationship"
                                  :key="item.value"
                                  :label="item.label"
                                  :value="item.value">
                                </el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="证件号码" :rules="[{ required: true, message: '请输入证件号', trigger: 'blur' }]">
                            <el-input v-model.trim="form.protectIdNo" placeholder="请输入被保人证件号"></el-input>
                        </el-form-item>
                        <el-form-item label="手 机 号" :rules="[
                            { required: true, message: '请输入手机号', trigger: 'blur' },
                            { validator:function(rule, value, callback){
                                if(!/^0?(13|14|15|16|17|18|19)[0-9]{9}$/.test(value)){
                                    callback(new Error('手机号码格式有误'));
                                }else{
                                    callback()
                                }
                            }, trigger: 'blur'}
                        ]">
                            <el-input type="text" v-model.trim="form.protectMobile" placeholder="请输入被保人手机号"></el-input>
                        </el-form-item>
                        <el-form-item label="有无社保" prop="[{ required: true, message: '不能为空', trigger: 'blur' }]">
                            <el-radio-group v-model="form.insuranceRadio">
                                　　<el-radio 
                                    v-for="(el,index) in insuranceOpts"
                                    :key="index" 
                                    :label="el.value">{{el.label}}</el-radio>
                            </el-radio-group>
                        </el-form-item>
                    </div>
                  <h2 style="margin-bottom:20px">保险信息</h2>
                    <el-form-item label="保障期限">
                          <el-select v-model="form.deadline" placeholder="请选择保障期限" style="width:180px">
                            <el-option
                              v-for="item in deadline"
                              :key="item.value"
                              :label="item.label"
                              :value="item.value">
                            </el-option>
                          </el-select>
                    </el-form-item>
                    <el-form-item label="保障期限">
                          <el-date-picker
                          style="width:180px"
                          v-model="form.date"
                          type="date"
                          :editable="false"
                          :clearable="false"
                          :picker-options="pickerOptions"
                          placeholder="选择日期">
                        </el-date-picker>
                        0时 至 {{endTime}}  24时止
                    </el-form-item>
                  <el-form-item label="　　">
                    　　<el-button @click="onSubmit" type="primary" style="width:180px">继 续</el-button>
                  </el-form-item>
            </el-form> 
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
    <script src="<c:url value='/js/jquery.js'/>"></script>
    <script src="<c:url value='/js/vue.js'/>"></script>
    <script src="<c:url value='/js/element.js'/>"></script>
    <script src="<c:url value='/js/city-data.js'/>"></script>
    <script>
        var vm = new Vue({
            el: '#appCtrl',
            data: function(){
                return {
                    cityInfoOptions:cityInfoOptions,
                    rules:{
                        name:[{ required: true, message: '请输入联系人姓名', trigger: 'blur' }],
                        credType:[{ required: true, message: '请选择证件类型', trigger: 'blur' }],
                        idNo:[{ required: true, message: '请输入证件号', trigger: 'blur' }],
                        mobile:[
                            { required: true, message: '请输入手机号', trigger: 'blur' },
                            { validator:function(rule, value, callback){
                                if(!/^0?(13|14|15|16|17|18|19)[0-9]{9}$/.test(value)){
                                    callback(new Error('手机号码格式有误'));
                                }else{
                                    callback()
                                }
                            }, trigger: 'blur'}
                        ],
                        area:[{ required: true, message: '必须选择地址', trigger: 'blur' }],
                    },
                    stepIndex:1,
                    radio:'',
                    contacts:[{
                        name:'张三',
                        credType:0,
                        idNo:'fdasfdsafsad',
                        mobile:'17700000000',
                        area:'北京/北京市/东城区'
                    },{
                        name:'李四',
                        credType:0,
                        idNo:'1435345',
                        mobile:'18644444444',
                        area:'西藏/昌都地区/江达县'
                    }],
                    form:{
                        name:'',
                        credType:'',
                        idNo:'',
                        mobile:'',
                        area:'',
                        areaValue:'',
                        same:true,
                        deadline:364,
                        policyholderMobile:'',
                        relationshipType:'',
                        insuranceRadio :1,
                        date: new Date(new Date().getTime() + 1*24*60*60*1000)//默认第二天
                    },
                    credOptions:[{
                        value:0,
                        label:'身份证'
                    },{
                        value:1,
                        label:'港澳通行证'
                    }],
                    deadline:[{
                        value:180,
                        label:'180天',
                    },{
                        value:364,
                        label:'364天',
                    },{
                        value:728,
                        label:'728天',
                    }],
                    pickerOptions:{
                        disabledDate(time) {
                            // 保障期限起始时间，第二天开始，31天以内
                            return (time.getTime() < (new Date().getTime())) || (time.getTime() >= new Date().getTime() + 31*24*60*60*1000)
                        }
                    },
                    relationship:[{
                        label:'父母',
                        value:0
                    },{
                        label:'配偶',
                        value:1
                    },{
                        label:'子女',
                        value:2
                    }],
                    insuranceOpts:[{
                        label:'有',
                        value:1
                    },{
                        label:'无',
                        value:0
                    }]
                }
            },

            computed:{
                endTime: function(){
                    var d = new Date(this.form.date.getTime()+this.form.deadline*24*60*60*1000);
                    var t = [d.getFullYear(), d.getMonth()+1, d.getDate()];
                    return t.join('-');
                }
            },

            watch:{
                radio: function(val){
                    if(''!==val){
                       var contact = this.contacts[val];
                       this.form.name = contact.name;
                       this.form.credType = contact.credType;
                       this.form.idNo = contact.idNo;
                       this.form.mobile = contact.mobile;
                       if(this.form.same){
                            this.form.policyholderMobile = this.form.mobile+'';
                        }
                       this.getArea(contact.area);
                    }
                },
                'form.same': function(val){
                    if(val){
                        this.form.policyholderMobile = this.form.mobile;
                    }else{
                        this.form.policyholderMobile = '';
                    }
                }
            },

            methods:{
                onSubmit: function(){
                    var that = this;
                    this.$refs.form.validate(function(valid){
                        if(valid){
                            alert('提交表单')
                            that.$message.error('手机短信验证码错误');
                            location.href = 'confirm_policy.html';
                        }else{
                            return false;
                        }
                    })
                },

                getArea: function(area){
                    var val = [],
                        that = this , area = area.split('/') || [];;
                    for(var i = 0 ; i < cityInfoOptions.length; i++){
                        if(cityInfoOptions[i].label == area[0]){
                            val.push(cityInfoOptions[i].value);
                            for(var j = 0, citys = cityInfoOptions[i].children; j < citys.length; j++){
                                if(citys[j].label == area[1]){
                                    val.push(citys[j].value)
                                    for(var z = 0, district = citys[j].children; z < district.length; z++ ){
                                        if(district[z].label == area[2]){
                                            val.push(district[z].value);
                                            this.form.area = area;
                                            this.form.areaValue = val;
                                            console.log(val)
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                    }
                },

                areaHandleChange: function(value,q){
                    
                    console.log(value)
                    console.log(q)
                }
            }
        })
    </script>

</body>

</html>