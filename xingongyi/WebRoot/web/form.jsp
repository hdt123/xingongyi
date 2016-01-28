<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" type="text/css" href="css/weui.css">
    <title>成为益客</title>
    <style>
        body{
            font-family: "Microsoft YaHei", "微软雅黑", "黑体", serif;
        }
        header img{
            width: 100%;
        }
        .vercode{
            width: 30%;
            margin: 5px;
        }
        .vercode .sendMsg{
            width: 100%;
        }
    </style>
</head>
<body>
<header>
    <img src="img/form_logo.png">
</header>
<form class="weui_cells weui_cells_form" action="FormAction!register.action" method="post">
    <div class="weui_cell">
        <div class="weui_cell_hd">
            <label class="weui_label">姓名</label>
        </div>
        <div class="weui_cell_bd weui_cell_primary">
            <input name="realName" value="${realName}" class="weui_input" placeholder="请输入姓名">
        </div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_hd">
            <label class="weui_label">身份证</label>
        </div>
        <div class="weui_cell_bd weui_cell_primary">
            <input name="idcard" value="${idcard}" class="weui_input" placeholder="请输入身份证号码">
        </div>
    </div>
    <div class="weui_cell">
        <div class="weui_cell_hd">
            <label class="weui_label">手机</label>
        </div>
        <div class="weui_cell_bd weui_cell_primary">
            <input name="cellphone" value="${cellphone}" id="tel" class="weui_input" placeholder="请输入手机号码">
        </div>
    </div>
    <div class="weui_cell weui_vcode">
        <div class="weui_cell_hd">
            <label class="weui_label">验证码</label>
        </div>
        <div class="weui_cell_bd weui_cell_primary">
            <input name="verCode" class="weui_input" placeholder="请输入验证码" maxlength="18">
        </div>
        <div class="weui_cell_ft vercode">
            <a class="sendMsg weui_btn weui_btn_mini weui_btn_default" onclick="getMsg()">发送</a>
        </div>
        <script type="text/javascript">
        	function getMsg(){
        		var cp = $('#tel').val();
        		$.post('FormAction!getCode.action',{cellphone:cp},function(data){
        			
        		});
        	}
        </script>
    </div>
    <div class="weui_cell">
        <button id="form-btn" class="weui_btn weui_btn_primary">提交</button>
    </div>
</form>
<script src="js/jquery-1.8.3.min.js"></script>
<script src="js/dialogV1.20.js"></script>
<script>
    (function($){
        $.fn.count_time=function(time){
            var $this = $(this),
                times = time;
            ifs();
            function ifs(){
                $this.one('click',function(){
                    $this.html(times+'秒').addClass('weui_btn_disabled');
                    var CT = setInterval(countTime,1000);
                    function countTime(){
                        if(times>0){
                            times--;
                            $this.html(times+'秒');
                        }else{
                            clearInterval(CT);
                            $this.html('发送').removeClass('weui_btn_disabled');
                            times = time;
                            ifs();
                        }
                    }
                });
            }
        };
    })($);
</script>
<script>
    $(function(){
        $('.sendMsg').count_time(5);
        $('form').submit(function(){
            return check_form();
        })
    });
    function check_form(){
        var nickname = $('input[name="realName"]'),
            idcard   = $('input[name="idcard"]'),
            telnum   = $('input[name="cellphone"]'),
            vercode  = $('input[name="verCode"]');
        if(nickname.val()==''){
            $.dialog.show_dialog('请输入真实姓名');
            return false;
        }else if(idcard.val()==''){
            $.dialog.show_dialog('请输入身份证号码');
            return false;
        }else if(telnum.val()==''){
            $.dialog.show_dialog('请输入手机号码');
            return false;
        }else if(!(/^1[3|5|8][0-9]\d{8}$/.test(telnum.val()))){
            $.dialog.show_dialog('请输入正确的手机号码');
            return false;
        }else if(vercode.val()==''){
            $.dialog.show_dialog('请输入验证码');
            return false;
        }
    }

</script>
</body>
</html>
