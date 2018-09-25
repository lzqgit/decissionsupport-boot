/**
 * 应急专家库统计js
 */
var query_url = "EmergencyExpert/list?timestamp=" + Math.random();
var columns = {
	"expert_name" : "姓名",	
	"expert_sex" : "性别",	
	"expert_type" : "专家类别",	
	"duty" : "现任职务",
	"diploma_code" : "学历",
	"major" : "专业",
	"mobile_no" : "手机号码",
	"operation": "操作"
};
var conditions = {
		"pageSize" : 10
};
var  tableDom=$('.creatRescuePlanTableDiv');

var pageObj = null;		//后台分页数据
var picData = null;
$(document).ready(function() {
	//导航默认选中
	$(".menusonFrist li").eq(5).addClass("active");
	$(".titleFrist").next('ul').slideDown();
	$(".titleFrist").find("span").addClass("activeStair");
	// tab默认选中 
	document.getElementById("tab1").style.backgroundImage = "url(images/index/summaryTabSelect.png)";
	document.getElementById("tab1").style.color = "#FFFFFF";
	document.getElementById("tab2").style.backgroundImage = "url(images/index/tableTab.png)";
	document.getElementById("tab2").style.color = "#2a84ca";
	
	//创建一个表格
	createTable(tableDom, query_url, columns, conditions);		
	
	$.ajax({
		url : "EmergencyExpert/getStatistics?timestamp=" + Math.random(),
		type : 'get',
		data : {			
				},
		dataType : 'json',
		success : function(responseText, textStatus) {
			if (responseText.stateCode == "200") {
				var datas = responseText.data;
				picData = responseText.data;
				if(datas != undefined && datas != null){
					//根据专家类别对专家数量进行统计
					if(datas[0] != null){
						setPic(datas[0], 'expertTypeBar', 'expertTypePie', '专家类别统计', '专家类别比例图', '数量/人','人');
					}
					//根据专家学历对专家数量进行统计
					if(datas[1] != null){
						setPic(datas[1], 'expertEducationBar', 'expertEducationPie', '专家学历统计', '专家学历比例图', '数量/人','人');
					}
				}else{
					//显示图片正在加载的页面
					loadPic('expertTypeBar', 'expertTypePie');
					loadPic('expertEducationBar', 'expertEducationPie');					
				}								
			} else {
				alert("图表信息获取失败");
				return false;
			}
		}
	});		
});			
/**
 * @function: 创建bootstrap-datatables风格的表格
 * @description: 根据相关参数创建一个默认的表格
 * @params: 1. tableDom - 已创建的表格DOM节点 2. query_url - 查询数据的Url 3. columns - 传入的列名
 *          4. conditions - 发给后台的参数
 */
function createTable(tableDom, query_url, columns, conditions) {
	var aoColumns = [];
	for ( var i in columns) {
		if(columns[i] == "姓名"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "105px"
			});
		}else if(columns[i] == "性别"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "100px"
			});
		}else if(columns[i] == "专家类别"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "100px"
			});
		}else if(columns[i] == "现任职务"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "100px"
			});
		}else if(columns[i] == "学历"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "100px"
			});
		}else if(columns[i] == "专业"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "100px"
			});
		}else if(columns[i] == "手机号码"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "100px"
			});
		}else{
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "100px"
			});
		}
		
		
	}
	tableDom.html('<table class="cell-border hover dataTables"></table>');
	var tableResultDom = $(".dataTables");
	tableResultDom.dataTable({
		"oLanguage" : {
			"sProcessing" : "正在加载中......",
			"sLengthMenu" : "每页显示 _MENU_ 条记录",
			"sZeroRecords" : "对不起，查询不到相关数据！",
			"sEmptyTable" : "表中无数据存在！",
			"sInfo" : "",			//|  总共 _TOTAL_ 条
			"sInfoEmpty" : " ",		//|  总共 0 条
			"sInfoFiltered" : " ",	//数据表中共为 _MAX_ 条记录
			"oPaginate" : {
				"sPrevious" : " ",
				"sNext" : " "
			}
		},
		"iDisplayLength" : conditions.pageSize,
		"bProcessing" : true,		//加载数据时候是否显示进度条
		"searching" : false,
		"bLengthChange" : false,	//改变每页显示数据数量
		"bFilter" : false,			//过滤功能
		"bSort" : false,			//排序功能
		"bPaginate" : true,			//分页按钮
		"aoColumns" : aoColumns,
		"sPaginationType" : "simple_numbers",	//仅仅显示"Previous" and "Next" 和页数
		"bServerSide" : true,		//页面在加载以及每次对dataTable进行操作时请求后台
		"sAjaxSource" : query_url,
		"fnServerData" : function(sSource, aoData, fnCallback, oSettings) {
			//发送到后台的页码参数,其中pageNum为页码
			var con = {};
			con["pageNum"] = aoData[3].value / aoData[4].value + 1;
			for ( var i in conditions) {
				con[i] = conditions[i];
			}
			oSettings.jqXHR = $.post(sSource, con, function(obj) {
				//过滤整理分页数据
				pageObj = obj.data;
				if(pageObj != undefined && pageObj != null){
					var data = filterPageData(pageObj, columns);
					var finalData = [];
					for (var i in data) {
						finalData[i] = [];
						for (var j in data[i]) {
							finalData[i].push(data[i][j]);
						}
					}
					var parameter = [];
					parameter["iTotalRecords"] = pageObj.totalItems;
					parameter["iTotalDisplayRecords"] = pageObj.totalItems;	//显示一共多少条数据	该值需要设置，否则页码显示错误 
					parameter["aaData"] = finalData;
					fnCallback(parameter);
				}else{
					//后台返回null值时设置aaData为空并不显示分页
					var parameter = []; 
					parameter["aaData"] = [];
					$(".dataTables_paginate").css("display","none");
					fnCallback(parameter);
				}
			}, "json");
		}
	});
}
/**
 * @function: 过滤分页数据函数
 * @description: 根据后台分页对象和列名过滤数据
 * @params: 1. pageObj - 后台分页返回对象 2. cilumns - 列名组
 */
function filterPageData(pageObj, columns) {
	//用来计算序号的值
	var tempData = [];
	if (pageObj.list != undefined && pageObj.list != null) {
		for (var i in pageObj.list) {
			tempData[i] = [];
			for (var k in columns) {
				if (k == "operation") {
					pageObj.list[i][k] = '<a href="#" onclick=rescueLookFunction("'
							+ pageObj.list[i]["expert_id"]
							+ '");><span class="glyphicon rescueSee department-btn" >查看详情</span></a>';
				}
				tempData[i].push(pageObj.list[i][k]);
			}
		}
	}
	return tempData;
}
/**
 * @function: 查看详情
 * @description: 查看详情信息
 * @params: 1. departmentId
 */
function rescueLookFunction(id) {
	$('#indexModalForm').modal('show');
	$('#rescueSeeForm').off();
	//设置详情窗口可拖拽
	$('.modal-dialog').draggable();		
	var flag = 0;
	//查找与id相同的数据
	if (pageObj.list != undefined && pageObj.list != null) {
		for (var i in pageObj.list) {
			if (id == pageObj.list[i]["expert_id"]) {
				flag = 1;
				break;
			}
		}
	}
	if(flag == 1){
		var data = pageObj.list[i];
		//设置每个表单的值
		//姓名
		$("#expertName_check").val(data["expert_name"]);
		//性别
		$("#expertSex_check").val(data["expert_sex"]);		 	
		//负责人姓名
		$("#expertType_check").val(data["expert_type"]);		
		//健康状况
		$("#health_check").val(data["health"]);	
		//出生年月
		var birthDay = (data["birth_month"] == "" || data["birth_month"] == null)? data["birth_month"] : getBirthDate(data["birth_month"]);
		$("#birthDate_check").val(birthDay);		 				
		//现任职务
		$("#presentDuty_check").val(data["duty"]);			
		//学历
		$("#education_check").val(data["diploma_code"]);	 		
		//专业
		$("#major_check").val(data["major"]);	 		
		//身份证号
		$("#IDNumber_check").val(data["id_card"]);			 		
		//手机号码
		$("#phone_check").val(data["mobile_no"]);		 				
		//办公电话
		$("#telNumber_check").val(data["tel_no"]);
		//电子邮箱
		$("#email_check").val(data["email"]);		
		//单位地址
		$("#unitAddress_check").text(data["work_address"]);
		//家庭地址
		$("#homeAddress_check").text(data["home_address"]);
		//专家简介
		$("#expertInfo_check").text(data["expert_resume"]);
	}
}
/*通过点击按钮加载图表数据*/
function liClick(id) {
	//设置列表和图形按钮以及对应内容的显示和隐藏。
	setRightContent(id);
	if(id=="tab1"){
		//如果从未加载过图形统计数据则发送ajax请求后台数据否则直接加载已经保存的数据。
		if(loadFlag==0){
			$.ajax({
				url : "EmergencyExpert/getStatistics?timestamp=" + Math.random(),
				type : 'get',
				data : {			
						},
				dataType : 'json',
				success : function(responseText, textStatus) {
					if (responseText.stateCode == "200") {
						var datas = responseText.data;
						picData = responseText.data;
						if(datas != undefined && datas != null){
							//根据专家类别对专家数量进行统计
							if(datas[0] != null){
								setPic(datas[0], 'expertTypeBar', 'expertTypePie', '专家类别统计', '专家类别比例图', '数量/人','人');
							}
							//根据专家学历对专家数量进行统计
							if(datas[1] != null){
								setPic(datas[1], 'expertEducationBar', 'expertEducationPie', '专家学历统计', '专家学历比例图', '数量/人','人');
							}
						}else{
							//显示图片正在加载的页面
							loadPic('expertTypeBar', 'expertTypePie');
							loadPic('expertEducationBar', 'expertEducationPie');					
						}								
					} else {
						alert("图表信息获取失败");
						return false;
					}
				}
			});			
		}else{
			if(picData != undefined && picData != null){
				//根据专家类别对专家数量进行统计
				if(picData[0] != null){
					setPic(picData[0], 'expertTypeBar', 'expertTypePie', '专家类别统计', '专家类别比例图', '数量/人','人');
				}
				//根据专家学历对专家数量进行统计
				if(picData[1] != null){
					setPic(picData[1], 'expertEducationBar', 'expertEducationPie', '专家学历统计', '专家学历比例图', '数量/人','人');
				}
			}else{
				//显示图片正在加载的页面
				loadPic('expertTypeBar', 'expertTypePie');
				loadPic('expertEducationBar', 'expertEducationPie');
			}
		}
	}
}