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
    <title>公益善谷新春祈福大行动</title>
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
            width: 55%;
            height: 8px;
            margin: 4px 3px;
            float: left;
            background: #cfcfcf;
            -webkit-border-radius: 4px;
        }
        .list-plan>div:first-child>div{
            background-color: #e14b1d;
            width: 0;
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
        #detail>div{
            font-size: 16px;
            margin: 5px 10px 15px;
            color: #5a5451;
            letter-spacing: 1px;
            line-height: 1.7em;
        }
        #detail>div.title{
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
        table{
            width: 100%;
            border-right:1px solid #000;
            border-bottom:1px solid #000;
        }
        table td{
            border-left: 1px solid #000;
            border-top: 1px solid #000;
            padding: 5px;
        }
    </style>
</head>
<body>
<header>
    <img src="web/img/desc-1-1.jpg">
    <div id="title">延续父亲的希望</div>
</header>
<section>
    <div class="list-plan clear">
        <div><div id='projectNum'></div></div>
        <div><span class="orange">${project1.pariseNum } 元</span>/${project1.needNum } 元</div>
    </div>
    <div id="msg" class="clear">
        <div>
            <div>目标金额</div>
            <div>${project1.needNum } 元</div>
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
        <div class="title">公益善谷新春祈福公益众筹活动项目《延续父亲的希望》</div>
        <div class="title">1.你在帮谁？</div>
        <p>他是李建中，更合镇新圩社区岳塘村人，2010年因一场意外车祸导致肢体重残，2012年领取壹级肢残残疾证（编号44062419721216461141）现李建中肢体瘫痪无知觉。丧失劳动能力，日常生活全靠妻子照料。</p>
        <img src="web/img/desc-1-2.jpg">
        <div class="title">2.突如其来的变故，让本就困难重重的家庭，举步维艰。</div>
        <p>李建中夫妇为尽快还清购房债务，勤奋工作，妻子在家种养，丈夫外出打工。2010年11月8日，李建中在赶往高要迴龙镇兴达陶瓷厂上班路上途中发生车祸。李建中被送往佛山市中医院救治。为了筹集治疗费，经过亲戚朋友东拼西凑，村中宗亲为李建中筹集治疗费组织爱心捐款近四十万元。</p>
        <p>人说久病床前无孝子，但这个家庭不仅仅是久病床前有孝子，更是久病床前有贤妻！如今，现身残钱空的李建中在家中养病，妻子守侯料理，全家生活开支靠李建中的每月600元残疾补助和500元的低保。大儿子李锦涛目前在高明区技术职业学校就读，五岁幼子李锦森即将步入小学。对于这样的普通家庭来说，每月的1100元补助，实在难以支撑这个家庭日常开支、父亲的医药费及两儿子每年的上万的学杂生活费用。这让本就困难重重的家庭，更犹如泰山压顶，举步维艰。</p>
        <img src="web/img/desc-1-3.jpg">
        <p>李建中家庭合照</p>
        <div class="title">3.“希望爸爸快点好起来...”</div>
        <p>“2016年有什么心愿？”</p>
        <p>“希望爸爸快点好起来...”</p>
        <p>上天不会同时封锁一个人所有的出路，它总会留下一个希望的火种。李建中虽然不能行走，但身边的家人就是他唯一活下去的希望。当问到李建中的儿子有什么新年愿望的时候，他只回答了一句“希望爸爸快点好起来...”，简短又深刻的几个字，让我想起了一句歌词：“我会一直把你搀扶，就像当初，你带着我走出人生第一步...”</p>
        <p> 爱心没有区域界限，希望我们的爱心项目能够一点一滴汇入这个家庭帮助他们渡过难关，希望还他们每一个人以往阳光的笑容，希望李建中战胜一切苦难。愿天下所有父母平安度过每一春秋！</p>
        <img src="web/img/desc-1-4.jpg">
        <div class="title" style="text-align: center">资助费用</div>
        <table><tbody><tr class="firstRow"><td width="121" valign="top" style="word-break: break-all;">&nbsp; &nbsp; &nbsp; &nbsp; 姓名</td><td width="121" valign="top" style="word-break: break-all;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;内容</td><td width="121" valign="top" style="word-break: break-all;">&nbsp; &nbsp; &nbsp; &nbsp; 费用</td></tr><tr><td width="121" valign="top" style="word-break: break-all;"><p>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</p><p>&nbsp; &nbsp; &nbsp; 李锦添</p></td><td width="121" valign="top" style="word-break: break-all;">包括学费、住宿费、交通费、日常生活费</td><td width="121" valign="top" style="word-break: break-all;"><p><br></p><p>4000元/年</p></td></tr><tr><td width="121" valign="top" style="word-break: break-all;"><p><br></p><p>&nbsp; &nbsp; &nbsp; &nbsp;<span style="line-height: inherit;">李锦森</span></p><p><br></p></td><td width="121" valign="top" style="word-break: break-all;">包括学费、生活费、校车费</td><td width="121" valign="top" style="word-break: break-all;"><p><br></p><p><span style="line-height: inherit;">4027元/年</span><br></p></td></tr><tr><td width="121" valign="top" style="word-break: break-all;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;合计：</td><td width="121" valign="top"><br></td><td width="121" valign="top" style="word-break: break-all;">8027元/年</td></tr></tbody></table>
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
            $afterShare = $('#after-share'),
            r           = [10,20,30],
            imgNo       = r[Math.floor(Math.random()* r.length)],
            num=Math.floor(parseInt('${project1.pariseNum }')/parseInt('${project1.needNum }')*100);
        num = num > 100 ? 100 : num;
        $('#projectNum').css('width',num+'%');
        //$afterJoin.find('img').attr('src','img/afterJoin'+imgNo+'.png');
        $header.height($header.width() * (47/100) + 'px')
        
        if(${state== false}){
        	$joinBtn.html('已祈福');
        }else{
        	$joinBtn.one('click', function(){
                var $this = $(this);
                $this.addClass('btnCarton');
                setTimeout(function(){
    				$.post('userAction!pray.action?userId=${user.userId}&&projectId=${project1.projectId}',function(data){
    					
    					if(data.status==0){
    						//location.reload();
    						$this.html('已祈福');
    		                $afterJoin.fadeIn(500,function(){
    		                    var _this=$(this);
    		                    setTimeout(function(){
    		                        $this.removeClass('btnCarton');
    		                        _this.fadeOut(500,function(){
    location.reload();
    });
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
    	//	 alert(location.href);
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
             debug: false,
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
                 title: '公益善谷新春祈福大行动', // 分享标题
                 desc: '高明新公益团队    本土化  新公益  心传播', // 分享描述
                 link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx97c624858e7a37d8&redirect_uri=http%3a%2f%2fdev.ydcycloud.net%2Fxingongyi%2FuserAction!toIndex.action&response_type=code&scope=snsapi_userinfo&state=STATE&connect_redirect=1#wechat_redirect', // 分享链接
                 imgUrl: 'http://dev.ydcycloud.net/wing/XGY/img/share-icon.jpg', // 分享图标
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
                 title: '公益善谷新春祈福大行动', // 分享标题
                 link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx97c624858e7a37d8&redirect_uri=http%3a%2f%2fdev.ydcycloud.net%2Fxingongyi%2FuserAction!toIndex.action&response_type=code&scope=snsapi_userinfo&state=STATE&connect_redirect=1#wechat_redirect', // 分享链接
                 imgUrl: 'http://dev.ydcycloud.net/wing/XGY/img/share-icon.jpg', // 分享图标
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
