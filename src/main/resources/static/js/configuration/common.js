$(document).ready(function() {
    $.ajaxSetup({
        global:true,
        beforeSend:function (request) {
            var token =  localStorage.getItem("token");
            if(token==null||token=="null"){
                token = getQueryString("token");
            }
            if(token!=null&&token!=""){
                localStorage.setItem("token",token);
            }
            request.setRequestHeader("token", token);
        },
        complete : function(xhr, status) {
            //拦截器实现超时跳转到登录页面
            // 通过xhr取得响应头
            var REDIRECT = xhr.getResponseHeader("REDIRECT");
            //如果响应头中包含 REDIRECT 则说明是拦截器返回的
            if (REDIRECT == "REDIRECT")
            {
                localStorage.removeItem("token");
                var win = window;
                while (win != win.top)
                {
                    win = win.top;
                }
                //重新跳转到 单点登录
				var url =xhr.getResponseHeader("CONTENTPATH");
				//保存导航大厅的地址
				console.log("地址："+url);
                win.location.href = url;
            }
        }
    });
					/*检测分辨率*/
					if(screen.width == 1280){
						$(".leftmenu").css("width","256px");
						$(".indexMenuBg").css("width","256px");
						$(".contentRight").css("width","78%").css("marginLeft","21%");
					}else if(screen.width == 1920){
						$(".leftmenu").css("width","265px");
						$(".indexMenuBg").css("width","265px");
						$(".contentRight").css("width","84%").css("marginLeft","15%");
					};
					/*end*/
					
					$(function() {
						// 默认选中 
						$(".menusonFrist li").eq(0).addClass("active");
						$(".titleFrist").next('ul').slideDown();
						$(".titleFrist").find("span").addClass("activeStair");

						//导航栏切换
						$(".menuson li").click(function() {
							$(".menuson li.active").removeClass("active");
							$(this).addClass("active");
						});
						
						$('.title').click(
								function() {
									var $ul = $(this).next('ul');
									$('dd').find('ul').slideUp();
									if ($ul.is(':visible')) {
										$(this).next('ul').slideUp();
										$(".title").find("span").removeClass("activeStair");
									} else {
										$(this).next('ul').slideDown();
										$(".title").find("span").removeClass("activeStair");
										$(this).find("span").addClass("activeStair");
									}
								});
						// end 
					});
					
				});

var myclick = function(v) {
	var llis = document.getElementById("tab_bar").getElementsByTagName("li");
	for ( var i = 0; i < llis.length; i++) {
		var lli = llis[i];
		var idNum = "tab" + v;
		if (lli == document.getElementById("tab" + v)) {
			if (idNum == "tab1") {
				lli.style.backgroundImage = "url(images/index/summaryTabSelect.png)";
			}
			if (idNum == "tab2") {
				lli.style.backgroundImage = "url(images/index/tableTabSelect.png)";
			}
			lli.style.color = "#FFFFFF";
		} else {
			if (idNum == "tab2") {
				lli.style.backgroundImage = "url(images/index/summaryTab.png)";
			}
			if (idNum == "tab1") {
				lli.style.backgroundImage = "url(images/index/tableTab.png)";
			}
			lli.style.color = "#2a84ca";
		}
	}
	var divs = $(".tab_css");
	for ( var i = 0; i < divs.length; i++) {
		var divv = divs[i];
		if (divv == document.getElementById("tab" + v + "_content")) {
			divv.style.display = "block";
		} else {
			divv.style.display = "none";
		}
	}
};
function setRightContent(id){
	if(id=="tab1"){
		$("#tab1").css("backgroundImage","url(images/index/summaryTabSelect.png)");
		$("#tab2").css("backgroundImage","url(images/index/tableTab.png)");
		$("#tab1").css("color","#FFFFFF");
		$("#tab2").css("color","#2a84ca");
		$("#tab1_content").css("display","block");
		$("#tab2_content").css("display","none");		
	}
	if(id=="tab2"){
		$("#tab1").css("backgroundImage","url(images/index/summaryTab.png)");
		$("#tab2").css("backgroundImage","url(images/index/tableTabSelect.png)");
		$("#tab2").css("color","#FFFFFF");
		$("#tab1").css("color","#2a84ca");
		$("#tab2_content").css("display","block");
		$("#tab1_content").css("display","none");		
	}
};

function sAlert(note){
	if($("#sAlertModal").length == 0){
		var dom  =  '<div class="modal fade"  tabindex="-1" role="dialog" aria-labelledby="sAlertModal" aria-hidden="true" style="display:none;">' + 
	    '<div class="modal-dialog">' +
	      '<div class="modal-content modal-content-userStyle">' + 
	        '<div class="modal-header">' +
	          '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>' + 
	        '</div>' +
	        '<div class="modal-body">' +
				'<form class="form-inline" role="form">' +
					'<div>' +
						'<fieldset>' +
							'<legend><span class="title">提示信息</span></legend>' +
								'<span class="removeInfo">' +
									note +
								'</span>' +
								'<div class="modal-footer">' +
								    '<button type="button" class="btn btn-default" id="removeLayer-btn" data-dismiss="modal">' + 
								    	'<span class="glyphicon glyphicon-ok"></span>确定' +
								    '</button>' +
								'</div>' +																					
						'</fieldset>' +					
					'</div>' +
				'</form>' +
	        '</div>' +               
	      '</div>' + 
	    '</div>' +
	  '</div>';	
	 $("body").append(dom);		
	}
	$(dom).modal('show');
}

/*
 * 描述：将后台返回的String类型的毫秒数转换成日期
 * 参数：msec 毫秒数  数据类型String
 * 格式：2017-03-09
 * */
function getBirthDate(msec){
	var date = new Date(parseInt(msec));
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	month = month < 10 ? ('0'+month) : month;
	return year + '-' + month;
}
/*
 * 描述：将后台返回的String类型的毫秒数转换成日期
 * 参数：msec 毫秒数  数据类型String
 * 格式：2017-03-09
 * */
function stringToDate(msec){
	var date = new Date(parseInt(msec));
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	month = month < 10 ? ('0'+month) : month;
	var day = date.getDate();
	day = day < 10 ? ('0'+day) : day;
	return year + '-' + month + '-' + day;
}
/*
 * 描述：将后台返回的String类型的毫秒数转换成日期
 * 参数：msec 毫秒数  数据类型String
 * 格式：2017-03-09 17
 * */
function stringToHourlyDate(msec){
	var date = new Date(parseInt(msec));
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	month = month < 10 ? ('0'+month) : month;
	var day = date.getDate();
	day = day < 10 ? ('0'+day) : day;
	var hour = date.getHours();
	hour = hour < 10 ? ('0'+hour) : hour;
	return year + '-' + month + '-' + day + ' ' + hour;	
}
/*
 * 描述：将后台返回的String类型的毫秒数转换成日期
 * 参数：msec 毫秒数  数据类型String
 * 格式：2017-03-09 17:18
 * */
function stringToMinuteDate(msec){
	var date = new Date(parseInt(msec));
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	month = month < 10 ? ('0'+month) : month;
	var day = date.getDate();
	day = day < 10 ? ('0'+day) : day;
	var hour = date.getHours();
	hour = hour < 10 ? ('0'+hour) : hour;
	var minute = date.getMinutes();
	minute = minute < 10 ? ('0'+minute) : minute;
	return year + '-' + month + '-' + day + ' ' + hour + ':' + minute;	
}
/*
 * 描述：将后台返回的String类型的毫秒数转换成日期
 * 参数：msec 毫秒数  数据类型String
 * 格式：2017-03-09 17:18:07
 * */
function stringToSecondDate(msec){
		var date = new Date(parseInt(msec));
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		month = month < 10 ? ('0'+month) : month;
		var day = date.getDate();
		day = day < 10 ? ('0'+day) : day;
		var hour = date.getHours();
		hour = hour < 10 ? ('0'+hour) : hour;
		var minute = date.getMinutes();
		minute = minute < 10 ? ('0'+minute) : minute;
		var second = date.getSeconds();
		second = second < 10 ? ('0'+second) : second;
		return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' +second;		
	
}
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);  //获取url中"?"符后的字符串并正则匹配
    var context = "";
    if (r != null)
        context = r[2];
    reg = null;
    r = null;
    return context == null || context == "" || context == "undefined" ? "" : context;
}