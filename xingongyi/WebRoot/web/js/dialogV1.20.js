/**
 * Created by Wing on 2015/9/15.
 */
$.extend({
    dialog: {
        started: function () {
            $("body").append(
/*弹窗html*/      '<div id="box" style="letter-spacing:2px; padding: 10px 5px; position: fixed; z-index: 99999; box-shadow: rgb(0, 0, 0) 0 0 5px 2px; color: rgb(255, 255, 255); font-size: 15px; width: 50%; left: 0; right: 0; margin: 0 auto; text-align: center; top: 50px; background: rgba(0, 0, 0, 0.701961); display: none; word-wrap: break-word; word-break: normal; "></div>'
/*提示框html*/   +'<div id="shade"><div id="alert-box"><div id="alert-desc"></div><div id="btn"><span id="yes">确定</span><span id="no">取消</span></div></div></div>'
            );
/*手机端confirm*/            $("head").append('<style>#shade{font-size:15px;position:fixed;z-index:999;left:0;right:0;top:0;bottom:0;background:transparent;font-family:"Microsoft YaHei","微软雅黑",SimSun,"宋体",serif;display:none}#alert-box{width:200px;background:#fff;border-radius:10px;margin:150px auto;text-align:center;box-shadow:0 0 1px 1px #ccc;border:2px solid #ccc}#alert-desc{padding:12px 10px}#btn{border-top:1px solid #ccc}#btn:after{content:"";display:block;clear:both}#btn>span{float:left;box-sizing:border-box;width:50%;color:#4578b8;padding:5px 0;cursor:pointer}#btn>span:first-child{border-right:1px solid #ccc}</style>')
        }(),
        //公用提示弹窗，只提供弹窗内容输出跟回调
        //屏蔽旧版本
       /* show_dialog: function (id,text,time,callback) {
            var box;
            if(id==false){
                box=$("#box");
            }else{
                box=$(id);
            }
            box.text(text).show();
            setTimeout(function(){
                box.fadeOut(callback);
            },time);
        }, */

        //实用版↓
        //通过$.dialog.show_dialog(内容,盒子ID,时间,回调)  方法直接调用弹窗，其中内容为必填，其他三个为可填
        show_dialog:function(txt,id,time,callback){
            var Id=$("#box"),Txt=txt,Time=2000,Callback;
            var len=this.show_dialog.arguments;
            check(len);
            function check(e){
                for(var i=1;i<e.length;i++){
                    if($.isFunction(e[i])){
                        Callback=e[i];
                    }else if(typeof e[i]=="string"){
                        Id=$(e[i]);
                    }else{
                        Time=e[i];
                    }
                }
            }
            Id.text(Txt).show(function(){
                setTimeout(function(){Id.fadeOut(Callback);},Time);
            });
        },
        //对象赋值版↓
        //通过$.dialog.show_dialog({})  方法直接调用弹窗，其中内容为必填，其他三个为可填
        sho_dialog:function(data){
            var id=$(data.id||"#box"),
                txt=data.txt||"",
                time=data.time||2000;
                callback=data.success||"";
            id.text(txt).show(function(){
                setTimeout(function(){
                    id.fadeOut(callback);
                },time);
            });
        },
        //提示弹窗后重新加载上一页
        back_dialog:function(id,text,time){
            var box;
            if(id==false){
                box=$("#box");
            }else{
                box=$(id);
            }
            box.text(text).show();
            setTimeout(function(){
                box.fadeOut(function(){
                    history.back(-1);
                });
            },time);
        },
        self_dialog:function(id,css){
            var css=css;
            var a =[];
            var b = 0;
            var c="";
            for (a[b++] in css)
            {c+=a[b-1]+":"+css[a[b-1]]+",";}
            var d=c.split(",");
            d.pop();
            var e=d.join(";");
            //对象转换成css样式,赋予变量e
            $("body").append('<div id="'+id+'" style="'+e+'"></div>');
        },
        confirm_dialog:function(text,callback,btn){
            var yes=$("#yes"),no=$("#no"),shade=$("#shade");
            if(btn){
                yes.html(btn.accept);
                no.html(btn.cancel);
            }
            $("#alert-desc").html(text).parents("#shade").show();
            yes.one("click",function(){
                shade.hide();
                if(callback.accept)callback.accept();
                no.off("click");
            });
            no.one("click",function(){
                shade.hide();
                if(callback.cancel)callback.cancel();
                yes.off("click");
            })
        },
        choice_dialog:function(text,callback,btn){
            var yes=$("#yes"),no=$("#no"),shade=$("#shade");
            if(btn){
                yes.html(btn.accept);
                no.html(btn.cancel);
            }
            $("#alert-desc").html(text).parents("#shade").show();
            yes.one("click",function(){
                shade.hide();
                if(callback&&callback.accept)callback.accept();
                no.off("click");
            });
            no.one("click",function(){
                shade.hide();
                if(callback&&callback.cancel)callback.cancel();
                yes.off("click");
            })
        }
    }
});