<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
    <meta charset="UTF-8">
    <title>我的保单</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no,minimal-ui">
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="full-screen" content="yes">
    <meta name="browsermode" content="application">
    <meta name="x5-orientation" content="portrait">
    <meta name="x5-fullscreen" content="true">
    <meta name="x5-page-mode" content="app">
    <link rel="stylesheet" href="<c:url value='/mint/lib/style.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/mbase.css'/>" />
    <link rel="stylesheet" href="<c:url value='/css/mmain.css'/>" />
</head>

<body>
    <div id="appCtrl" v-locak>

        <mt-header title="我的保单">
            <a href="javascript:;" @click="history.go(-1)" slot="left">
                <mt-button icon="back"></mt-button>
            </a>
        </mt-header>
		
		<mt-tab v-model="params.orderStatus" v-show="!keywords" @click="onTab">
            <mt-tab-item :id="5">已完成订单</mt-tab-item>
            <mt-tab-item :id="1">未完成订单</mt-tab-item>
            <mt-tab-item :id="4">可续保订单</mt-tab-item>
        </mt-tab>
		
		<div class="claims-list"
            v-infinite-scroll="fetchData"
            infinite-scroll-disabled="loading"
            infinite-scroll-distance="10">
			
            <div class="item" v-for="el in dataList">
                <div class="title">
                    <h2>{{el.productName}}</h2>
                    <p class="cGray">{{el.createTime}}</p>
                </div>
                <ul>
                    <li>
                        <span>被保人：</span>
                        <span class="cGray">{{el.userName}}</span>
                    </li>
                    <li>
                        <span>保障金额：</span>
                        <span class="cGray">{{el.orderAmt}}</span>
                    </li>
                    <li>
                        <span>生效时间：</span>
                        <span class="cGray">{{el.startTime}}</span>
                    </li>
                </ul>
				<!--
                <div class="meta" v-if="el.status==0">
                    <mt-button type="primary" size="small" plain>
                        <a href="">去支付</a>
                    </mt-button>
                </div>

                <div class="meta" v-if="el.status==1">
                    <mt-button type="primary" size="small" plain>
                        <a href="">评价</a>
                    </mt-button>
                </div>

                <div class="meta" v-if="el.status==2">
                    <mt-button type="primary" size="small" plain>
                        <a href="">申请发票</a>
                    </mt-button>
                    <mt-button type="primary" size="small" plain>
                        <a href="">评价</a>
                    </mt-button>
                </div>
				-->
                <img v-if="el.orderStatus==5" src="<c:url value='/images/order_status_0.png'/>" width="75" height="75" alt="">
                <img v-else-if="el.orderStatus==1" src="<c:url value='/images/order_status_1.png'/>" width="75" height="75" alt="">
                <img v-else-if="el.orderStatus==4" src="<c:url value='/images/order_status_2.png'/>" width="75" height="75" alt="">
            </div>
        </div>
		
		<div class="spinner-wrapper cGray">
			<mt-spinner v-show="loading===true" type="fading-circle"></mt-spinner>
			<p v-show="loading===-1">没有更多了~</p>
			<div class="empty" v-show="loading===-2">
				<p class="cGray">暂无数据</p>
			</div>
		</div>   
	</div>
    <script src="<c:url value='/js/zepto.min.js'/>"></script>
    <script src="<c:url value='/js/vue.js'/>"></script>
    <script src="<c:url value='/mint/lib/index.js'/>"></script>
    
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
        
    </script>
	
	<script>
    var vm = new Vue({
        el: '#appCtrl',

        data: function(){
        	return {
                keywords:'',
                timeout:null,

                params:{
                    currentPage:0,
                    pageSize:10,
                    orderStatus: tabActiveName
                },

                loading: false,

                dataList:[]
            }
        },

        watch:{
            keywords: function(value){
                if(value){
                    this.timeout && clearTimeout(this.timeout);
                    this.timeout = setTimeout(function(){
                        vm.params.currentPage = 0;
                        //清空列表数据
                        vm.dataList = [];
                        vm.loading = false;
                        vm.fetchData(value);
                    },300);                   
                }else{
                    this.onTab();
                }
            }
        },

        methods:{
            onTab: function(){
                this.params.currentPage = 0;
                //清空列表数据
                this.dataList = [];
                this.loading = false;
                this.fetchData();
            },

            fetchData:function(keywords){
                if(this.loading)return;
                ++this.params.currentPage;

                //后台用keywords判断是否有值，区分点击tab，还是搜索。
                this.params.keywords = keywords || false;

                console.log(this.params)

                this.loading = true;

                $.ajax({
                    url:'http://www.fengshou-ins.com/kder-api/setting/mypolicyList.do',
                    data: this.params,
                    dataType:'json',
                    success: function(res){
                        // setTimeout(function(){//setTimeout 模拟异步ajax demo 
                            vm.loading = false;
                            vm.dataList = vm.dataList.concat(res.data.datas);//数组合并
                            if(res.data.total>=vm.params.pageSize){
                                vm.loading = false;
                            }else if(res.data.total==0&&vm.params.currentPage==1){
                                vm.loading = -2;//无数据
                            }else{
                                vm.loading = -1;//没有更多了
                            }
                        // },1000);
                    }
                });
            }
        },

        mounted: function(){

        }
    })   
    </script>
	
</body>

</html>