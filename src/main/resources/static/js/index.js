/**
 * 功能：应急救援预案统计界面js（前台首页）
 */
$(document).ready(function() {

     //10分钟检测一下是否过期
    window.setInterval(checkToen(),10*60*1000);
});
function checkToen(){
    $.ajax({
        type:'post',
        url:"user/checkToken",
        async:false,
        success:function (data) {
            if(data==""){
                return;
            }
            $("#loginUserName").html(data.data.username);
        }
    });
};
function loginOut(){
    $('#yourModal').modal('hide');
            $.ajax({
                type:'post',
                url:"user/logout",
                data:{},
                async:false,
                success:function (data) {
                    if(data==""){
                        return;
                    }
                    if(data.code=="0"||data.code==0){
                        //退出成功,删除
                        localStorage.removeItem("token");
                        window.location.href=data.data.authUrl;
                    }
                    else{
                        alert(data.message);
                    }
                }
            })
}


function goNav() {
    $.ajax({
        type:'post',
        url:"user/nav",
        data:{},
        async:false,
        success:function (data) {
            if(data!=undefined && data!=null && data!=""){
                window.location.href=data;
            }
        }
    })
}
