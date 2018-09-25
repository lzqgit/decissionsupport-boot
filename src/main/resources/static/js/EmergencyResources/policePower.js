/**
 * 公安力量统计
 */
var query_url = "PublicSecurityForce/list?timestamp=" + Math.random();
var columns = {
	"pubsecorg_name" : "机构名称",	
	"pubsecorg_no" : "机构代码",	
	"principal_name" : "负责人姓名",
	"principal_link_mode" : "负责人联系方式",	
	"emer_psn_num" : "应急人员数",
	"rescue_car_num" : "救援车辆数",
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
	$(".menusonFrist li").eq(3).addClass("active");
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
		url : "PublicSecurityForce/getStatistics?timestamp=" + Math.random(),
		type : 'get',
		data : {			
				},
		dataType : 'json',
		success : function(responseText, textStatus) {
			if (responseText.stateCode == "200") {
				var datas = responseText.data;
				picData = responseText.data;
				if(datas != undefined && datas != null){
					//根据医疗机构级别对医疗机构的组成进行统计
					if(datas != null){
						setPic(datas, 'rescuerNumBar', 'rescuerNumPie', '应急救援人员数量统计', '应急救援人员数量比例图', '数量/人','人');
					}
				}else{
					//显示图片正在加载的页面
					loadPic('rescuerNumBar', 'rescuerNumPie');					
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
		if(columns[i] == "机构名称"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "250px"
			});
		}else if(columns[i] == "机构代码"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "120px"
			});
		}else if(columns[i] == "负责人姓名"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "120px"
			});
		}else if(columns[i] == "负责人联系方式"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "160px"
			});
		}else if(columns[i] == "应急人员数"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "120px"
			});
		}else if(columns[i] == "救援车辆数"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "120px"
			});
		}else{
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "120px"
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
							+ pageObj.list[i]["pubsecorg_id"]
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
 * @params: 1. id
 */
function rescueLookFunction(id) {
	$('#indexModalForm').modal('show');
	$('#rescueSeeForm').off();
	$('.modal-dialog').draggable();		//设置详情窗口可拖拽
	var flag = 0;
	//查找与id相同的数据
	if (pageObj.list != undefined && pageObj.list != null) {
		for (var i in pageObj.list) {
			if (id == pageObj.list[i]["pubsecorg_id"]) {
				flag = 1;
				break;
			}
		}
	}
	if(flag == 1){
		var data = pageObj.list[i];
		//设置每个表单的值
		//机构名称
		$("#institutionName_check").val(data["pubsecorg_name"]);	
		//机构代码
		$("#institutionNum_check").val(data["pubsecorg_no"]);	
		//负责人姓名
		$("#responsibleName_check").val(data["principal_name"]); 
		//负责人联系方式
		$("#responsiblePhone_check").val(data["principal_link_mode"]);	
		//联系人姓名
		$("#telName_check").val(data["linkman_name"]);		
		//联系人联系方式
		$("#telPhone_check").val(data["link_mode"]);		 
		//应急人员数
		$("#emergencyCount_check").val(data["emer_psn_num"]);	
		//急救车辆数
		$("#ambulanceCount_check").val(data["rescue_car_num"]);	 
		//经度
		$("#longitude_check").val(data["longitude"]);		
		//纬度
		$("#latitude_check").val(data["latitude"]);		
		//机构详细地址
		$("#institutionAddress_check").text(data["pubsecorg_addr"]);
		//机构详细介绍
		$("#institutionInfo_check").text(data["pubsecorg_desc"]);		
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
				url : "PublicSecurityForce/getStatistics?timestamp=" + Math.random(),
				type : 'get',
				data : {			
						},
				dataType : 'json',
				success : function(responseText, textStatus) {
					if (responseText.stateCode == "200") {
						var datas = responseText.data;
						picData = responseText.data;
						if(datas != undefined && datas != null){
							//根据医疗机构级别对医疗机构的组成进行统计
							if(datas != null){
								setPic(datas, 'rescuerNumBar', 'rescuerNumPie', '应急救援人员数量统计', '应急救援人员数量比例图', '数量/人','人');
							}
						}else{
							//显示图片正在加载的页面
							loadPic('rescuerNumBar', 'rescuerNumPie');					
						}
										
					} else {
						alert("图表信息获取失败");
						return false;
					}
				}
			});					
		}else{
			if(picData != undefined && picData != null){
				//根据医疗机构级别对医疗机构的组成进行统计
				if(picData != null){
					setPic(picData, 'rescuerNumBar', 'rescuerNumPie', '应急救援人员数量统计', '应急救援人员数量比例图', '数量/人','人');
				}
			}else{
				//显示图片正在加载的页面
				loadPic('rescuerNumBar', 'rescuerNumPie');	
			}
		}
	}
}