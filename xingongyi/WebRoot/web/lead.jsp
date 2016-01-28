<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE html>
<html>
<head lang="en">
	<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <title>新年快乐</title>
    <link rel="stylesheet" type="text/css" href="web/css/common.css">
    <style>
        img{
            width: 100%;
            display: none;
        }
        #bg-body{
            position: absolute;
            z-index: -1;
        }
        .title-cartoon{
            -webkit-animation: cartoon 3s linear;
        }
        #fu{
            top: 0;
            position: absolute;
            z-index: 1;
            display: none;
        }
        #loading{
            width: 20%;
            position: absolute;
            left: 0;
            right: 0;
            top: 200px;
            margin: 0 auto;
            z-index: 10;
            text-align: center;
        }
        #loading>img{
            display: block;
        }
        #loading>div{

        }
    </style>
</head>
<body>
<div id="loading" >
    <img src="web/img/loading.gif">
    <div>loading</div>
</div>
<img id="bg-body" src="web/img/lead-bg.png">
<img id="bg" src="web/img/lead-bg3.png">
<img id="fu" src="web/img/lead-bg4.png">
  

<script src="web/js/jquery-1.8.3.min.js"></script>
<script>

    $(function(){
        addImg($('#bg-body').attr('src'),function(){
            $('#loading').remove();
            $('#bg-body').height($(window).height()+'px').fadeIn(500,function(){
                $('#bg').fadeIn(500,function(){
                    $('#fu').fadeIn(1000,function(){
                        setTimeout(function(){
                            location.href='userAction!toIndexHead.action';
                        },1000);
                    });

                })
            });
        });
    });
    function addImg(isrc,callback)
    {
        var Img = new Image();
        Img.src = isrc;
        Img.onload = function ()
        {
            if(callback)callback();
        }
    }
</script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
    /*
    wx.config({
        debug: false,
        appId: '<?php echo $signPackage["appId"];?>',
        timestamp: <?php echo $signPackage["timestamp"];?>,
        nonceStr: '<?php echo $signPackage["nonceStr"];?>',
        signature: '<?php echo $signPackage["signature"];?>',
        jsApiList: [
            'hideOptionMenu'
        ]
    });
    */
    wx.ready(function () {
        wx.hideOptionMenu();
    })
</script>
</body>
</html>