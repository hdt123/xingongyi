<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <title>新年快乐</title>
    <link rel="stylesheet" type="text/css" href="web/css/common.css">
    <style>
        header{
            position: relative;
        }
        header>img{
            width: 100%;
        }
        header>div{
            color: #fff;
            font-size: 15px;
            position: absolute;
            bottom: 10px;
            left: 8px;
        }
        #title{
            font-weight: bold;
            font-size: 18px;
            letter-spacing: 1px;
        }
        section{
            padding: 11px 11px 106px;
        }
        .list-plan{
            margin: 8px 0;
        }
        .list-plan>div:first-child{
            width: 62%;
            height: 8px;
            margin: 4px 3px;
            float: left;
            background: #cfcfcf;
            -webkit-border-radius: 4px;
        }
        .list-plan>div:first-child>div{
            background-color: #e14b1d;
            width: 88%;
            height: 8px;
            -webkit-border-radius: 4px;
        }
        .list-plan>div:last-child{
            font-size: 14px;
            height: 16px;
            line-height: 16px;
            float: right;
            margin-left: 3%;
            color: #9d9d9d;
            letter-spacing: -1px;
        }
        #msg{
            color: #9d9d9d;
        }
        #msg>div{
            float: left;
            width: 33.3%;
            text-align: center;
            border-right: 1px solid #9d9d9d;
            box-sizing: border-box;
        }
        #msg>div:last-child{
            border: 0;
        }
        #msg>div>div{
            margin: 5px 0;
        }
        #detail{
            border-top: 2px solid #9d9d9d;
            border-bottom: 2px solid #9d9d9d;
            padding: 10px 0;
            margin: 20px 0;
        }
        #detail:before{
            content: '项目详情';
            background: #fff;
            position: absolute;
            margin-top: -22px;
            padding: 0 10px;
            height: 20px;
            font-size: 16px;
            line-height: 20px;
            color: #5a5451;
        }
        #detail>img{
            width: 100%;
            display: block;
        }
        #detail>p{
            font-size: 16px;
            margin: 5px 0 15px;
            color: #5a5451;
            letter-spacing: 1px;
            text-indent: 2.2em;
            line-height: 1.7em;
        }
        #detail>p.title{
            font-size: 1.4em;
            color: #5a5451;
            font-weight: bold;
        }
        footer{
            background: #ffffff;
            height: 106px;
            width: 100%;
            position: fixed;
            bottom: 0;
            z-index: 10;
        }
        #btn-list{
            padding:8px 11px;
        }
        #btn-list>div{
            width: 144px;
            height: 67px;
            background-size: 100%;
            color: #fff;
            font-weight: bold;
            text-align: center;
        }
        #join{
            background: url("web/img/img-6.png") no-repeat;
            font-size: 18px;
            line-height: 67px;
            text-indent:40px;
            float: left;
        }
        #share{
            background: url("web/img/img-7.png") no-repeat;
            font-size: 14px;
            float: right;
        }
        #share>div{
            margin: 2px 0;
        }
        #share>div:first-child{
            margin-top: 13px;
        }
        #foot{
            background: url("web/img/img-5.png") no-repeat;
            background-size: 100%;
            height: 22px;
            width: 100%;
        }
        aside{
            position: fixed;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            z-index: 100;
            background:rgba(255, 255, 255, 0.90);
            display: none;
        }
        aside>img{
            width: 100%;
            /*-webkit-transform: translateY(-1500px);*/
        }
        .carton{
            -webkit-animation:shareCarton 2s  linear;
        }
        .btnCarton{
            -webkit-animation: btn 0.1s linear;
        }
        @-webkit-keyframes shareCarton{
            from{
                -webkit-transform: translateY(-1500px);
            }
            to{
                -webkit-transform: translateY(0);
            }
         }
        @-webkit-keyframes btn{
            from{
                -webkit-transform: translateX(0) translateY(0);
            }
            to{
                -webkit-transform: translateX(2px) translateY(2px);
            }
        }
    </style>
</head>
<body>
<header>
    <img src="web/img/1.jpg">
    <div id="title">相信阅读的力量</div>
</header>
<section>
    <div class="list-plan clear">
        <div><div></div></div>
        <div><span class="orange">${project1.pariseNum }人</span>/${project1.needNum }人</div>
    </div>
    <div id="msg" class="clear">
        <div>
            <div>目标</div>
            <div>${project1.needNum }人</div>
        </div>
        <div>
            <div>祈福人数</div>
            <div><span class="orange">${project1.pariseNum }</span>人</div>
        </div>
        <div>
            <div>传播人数</div>
            <div><span class="orange">${project1.shareNum }</span>人</div>
        </div>

    </div>
    <div id="detail">
        <p class="title">建发35岁生日，想为乡村孩子众筹35万</p>
        <img src="web/img/2.jpg">
        <p>建发股份携手担当者行动，在腾讯乐捐平台共同发起众筹35万为206个班级捐建图书角，汇聚你我的力量为6800多名乡村孩子创造更美好的未来。</p>
        <img src="web/img/3.jpg">
        <p>朱永新教授一直认为：</p>
        <p>一个人的精神发育史就是他的阅读史。</p>
        <p>阅读可以改变人生的气象与品质，</p>
        <p>人的精神可以因阅读而蓬勃葱茏气象万千。</p>
    </div>
</section>
<footer>
    <div id="btn-list" class="clear">
        <div id="join">参与祈福</div>
        <div id="share">
            <div>传播</div>
            <div>我的爱心</div>
        </div>
    </div>
    <div id="foot"></div>
</footer>

<aside id="after-join"><img src="web/img/afterJoin.png"></aside>
<aside id="after-share"><img src="web/img/afterShare.png"></aside>

<script src="web/js/jquery-1.8.3.min.js"></script>
<script>
    $(function(){
        var $header     = $('header').find('img'),
            $joinBtn    = $('#join'),
            $shareBtn   = $('#share'),
            $afterJoin  = $('#after-join'),
            $afterShare = $('#after-share');
        $header.height($header.width() * (47/100) + 'px');
        
        if(${state== false}){
        	$joinBtn.html('已祈福');
        }else{
        	$joinBtn.one('click', function(){
                var $this = $(this);
                $this.addClass('btnCarton');
                setTimeout(function(){
    				$.post('userAction!pray.action?userId=${user.userId}&&projectId=${project1.projectId}',function(data){
    					
    					if(data.status==0){
    						location.reload();
    						$this.html('已祈福');
    		                $afterJoin.fadeIn(500,function(){
    		                    var _this=$(this);
    		                    setTimeout(function(){
    		                        $this.removeClass('btnCarton');
    		                        _this.fadeOut(500);
    		                    },3000);
    		                });
    					}
    					
    				});
                },100);
            });
        }

        

        $shareBtn.on('click', function(){
            var $this = $(this);
            $this.addClass('btnCarton');
            setTimeout(function () {
//                $afterShare.find('img').addClass('carton');
                $afterShare.fadeIn();
            },100);
        })
    })
</script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

    <script type="text/javascript">
    	$(function(){
    		 alert(location.href); 
     	});
    </script>

<script>
    /*
         * 注意：
         * 1. 所有的JS接口只能在公众号绑定的域名下调用，公众号开发者需要先登录微信公众平台进入“公众号设置”的“功能设置”里填写“JS接口安全域名”。
         * 2. 如果发现在 Android 不能分享自定义内容，请到官网下载最新的包覆盖安装，Android 自定义分享接口需升级至 6.0.2.58 版本及以上。
         * 3. 常见问题及完整 JS-SDK 文档地址：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html
         *
         * 开发中遇到问题详见文档“附录5-常见错误及解决办法”解决，如仍未能解决可通过以下渠道反馈：
         * 邮箱地址：weixin-open@qq.com
         * 邮件主题：【微信JS-SDK反馈】具体问题
         * 邮件内容说明：用简明的语言描述问题所在，并交代清楚遇到该问题的场景，可附上截屏图片，微信团队会尽快处理你的反馈。
         */
         wx.config({
             debug: true,
             appId: '${appId}',
             timestamp: '${timestamptoPray}',
             nonceStr: '${nonceStrtoPray}',
             signature: '${signaturetoPray}',
             jsApiList: [
                 // 所有要调用的 API 都要加到这个列表中
                 'hideOptionMenu',
                 'onMenuShareAppMessage',
                 'onMenuShareTimeline'
             ]
         });

         wx.ready(function () {
             // 在这里调用 API
             //wx.hideOptionMenu();
             wx.onMenuShareAppMessage({
                 title: '${user.nickName}邀您一起参与新春祈福行动', // 分享标题
                 desc: '新春祈福行动正式开始！', // 分享描述
                 link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx97c624858e7a37d8&redirect_uri=http%3a%2f%2fdev.ydcycloud.net%2Fxingongyi%2FuserAction!toIndex.action&response_type=code&scope=snsapi_userinfo&state=STATE&connect_redirect=1#wechat_redirect', // 分享链接
                 imgUrl: 'http://dev.ydcycloud.net/wing/dice/img/883.png', // 分享图标
                 type: '', // 分享类型,music、video或link，不填默认为link
                 dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
                 success: function () {
                     // 用户确认分享后执行的回调函数
 					$.post('userAction!share.action',
 					{userId:"${user.userId}",
 					projectId:"${projectId}"},
 					function(){
 						location.reload();
 					});
                 },
                 cancel: function () {
                     // 用户取消分享后执行的回调函数
                 }
             });

             wx.onMenuShareTimeline({
                 title: '${user.nickName}邀您一起参与新春祈福行动', // 分享标题
                 link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx97c624858e7a37d8&redirect_uri=http%3a%2f%2fdev.ydcycloud.net%2Fxingongyi%2FuserAction!toIndex.action&response_type=code&scope=snsapi_userinfo&state=STATE&connect_redirect=1#wechat_redirect', // 分享链接
                 imgUrl: 'http://dev.ydcycloud.net/wing/dice/img/883.png', // 分享图标
                 success: function () {
                      // 用户确认分享后执行的回调函数
 					$.post('userAction!share.action',
 					{userId:"${user.userId}",
 					projectId:"${projectId}"},
 					
 					function(){
 						location.reload();
 					});
                 },
                 cancel: function () {
                     // 用户取消分享后执行的回调函数
                 }
             });

         });
</script>
</body>
</html>