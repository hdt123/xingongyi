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
    <title>新年快乐</title>
    <link rel="stylesheet" type="text/css" href="web/css/common.css">
    <style>
        body{
        }
        header{
            width: 100%;
            background: url("web/img/img-4.png") no-repeat;
            background-size: cover;
            height: 130px;
            overflow: hidden;
        }
        header img{
            position: absolute;
            z-index: 1;
            display: block;
        }
        header>img:first-child{
            width: 200px;
            right: 0;
            top: -5px;
        }
        header>img:nth-child(2){
            width: 74px;
            left: 8px;
            top: 10px;
        }
        header>img:nth-child(3){
            width: 65%;
            left: -11px;
            top: -15px;
        }
        section{
            margin: 0 8px;
        }
        #total-people{
            color: #D26A6A;
            font-size: 16px;
            text-align: right;
            font-weight: bold;
        }
        #title{
            color: #b30000;
            font-size: 16px;
            margin: 6px 9px;
            font-weight: bold;
        }
        #list>a{
            float: left;
            width: 100%;
            border-bottom: 1px solid #ebebeb;
            padding: 15px 0 5px;
            text-decoration: none;
        }
        #list>a>img{
            margin: 3px 20px 3px 3px;
            width: 95px;
            height: 72px;
            float: left;
            -webkit-border-radius: 5px;
        }
        #list>a>.list-title{
            margin: 6px 0 3px 6px;
            color: #9d9d9d;
            font-size: 14px;
        }
        #list>a>.list-desc{
            margin: 6px 0 3px 6px;
            color: #9d9d9d;
            font-size: 14px;
        }
        .list-plan{
            float: left;
            width: 100%;
        }
        .list-plan>div:first-child{
            width: 60%;
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
            float: left;
            margin-left: 3%;
            color: #9d9d9d;
            letter-spacing: -1px;
            width: 35%;
            text-align: center;
        }
        footer{
            background: url("web/img/img-5.png") no-repeat;
            background-size: 100%;
            z-index: 1;
            position: absolute;
            bottom: 0;
            height: 22px;
            width: 100%;
        }
    </style>
</head>
<body>
<header>
    <img src="web/img/img-1.png">
    <img src="web/img/img-2.png">
    <img src="web/img/img-3.png">
</header>
<section>
    <div id="total-people">参与祈福人数：${sum }</div>
    <div id="title">爱心项目</div>
    <div id="list" class="clear">
        <a class="clear" href="web/desc.jsp">
            <img src="web/img/1.jpg"/>
            <div class="list-title">相信阅读的力量</div>
            <div class="list-desc">建发35周年为乡村孩子众筹图书角，你捐多少建发配捐多少。</div>
            <div class="list-plan">
                <div><div></div></div>
                <div>${project1.pariseNum }人 / ${project1.needNum }人</div>
            </div>
        </a>
        <a class="clear" href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx97c624858e7a37d8&redirect_uri=http%3a%2f%2fdev.ydcycloud.net%2Fwing%2FXGY%2Fdesc.php&response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect">
            <img src="web/img/4.jpg"/>
            <div class="list-title">格桑花之爱</div>
            <div class="list-desc">为30名日喀则先天性髋关节脱位儿童筹款，实施矫正手术。</div>
            <div class="list-plan clear">
                    <div><div style="width: 100%"></div></div>
                    <div>${project2.pariseNum }人 / ${project2.needNum }人</div>
            </div>
        </a>
        <a class="clear" href="desc.jsp">
            <img src="web/img/5.jpg"/>
            <div class="list-title">为失聪女孩寻找声音</div>
            <div class="list-desc">帮一个因医疗事故而导致失聪的女孩重新找回世界声音的愿望</div>
            <div class="list-plan clear">
                <div><div style="width: 10%"></div></div>
                <div>${project3.pariseNum }人 / ${project3.needNum }人</div>
            </div>
        </a>
    </div>
</section>
<footer></footer>
<script src="web/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		 alert(location.href); 
     	});
    </script>
<script>
    $(function(){
            var img=$('#list').find('img');
            img.height(img.width()*(73/100)+'px');
    })
</script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
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
            debug: false,
            appId: '${appId}',
            timestamp: '${timestampindex}',
            nonceStr: '${nonceStrindex}',
            signature: '${signatureindex}',
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
			var titles ="";
			if('${user.points}!=0')
				titles = "${user.nickName}获得了${user.points}分,关注883公众号回复优惠券可领取丰厚奖品！";
			else
				titles="${user.nickName}参与了“883寻找骰魔大行动”有奖活动，关注883公众号回复优惠券可领取丰厚奖品！";
            wx.onMenuShareAppMessage({
                title: '883寻找骰魔大行动', // 分享标题
                desc: titles, // 分享描述
                link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2660c6aa6bd67ff1&redirect_uri=http%3A%2F%2Fdev.ydcycloud.net%2Fdice%2FdiceAction_diceGame.action&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect', // 分享链接
                imgUrl: 'http://dev.ydcycloud.net/wing/dice/img/883.png', // 分享图标
                type: '', // 分享类型,music、video或link，不填默认为link
                dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
                success: function () {
                    // 用户确认分享后执行的回调函数
					$.post('../diceAction_changeShareState.action',
					{userId:"${user.userId}"},
					function(){
						
					});
                },
                cancel: function () {
                    // 用户取消分享后执行的回调函数
                }
            });

            wx.onMenuShareTimeline({
                title: titles, // 分享标题
                link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2660c6aa6bd67ff1&redirect_uri=http%3A%2F%2Fdev.ydcycloud.net%2Fdice%2FdiceAction_diceGame.action&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect', // 分享链接
                imgUrl: 'http://dev.ydcycloud.net/wing/dice/img/883.png', // 分享图标
                success: function () {
                     // 用户确认分享后执行的回调函数
					$.post('../diceAction_changeShareState.action',
					{userId:"${user.userId}"},
					function(){
						
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