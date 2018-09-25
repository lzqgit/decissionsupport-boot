/**
 * 功能：应急救援预案统计界面js（前台首页）
 */
var query_url = "RescueCounterplan/list?timestamp=" + Math.random();
var columns = {		//此时的key值必须与后台返回的列名一致
	"plan_name" :"预案名称",	
	"plan_bak_number" : "预案备案编号",
	"plan_type" :"预案类别",	
	"plan_grade" : '预案级别',
	"apply_field" :"适用领域",	
	"pub_dept_name" : '主管单位',
	"operation": "操作"
};
var conditions = {
		"pageSize" : 10
};
var  tableDom=$('.creatRescuePlanTableDiv');
var loadTable = 0;
var pageObj = null;		//后台分页数据
var picData = null;

$(document).ready(function() {
	// tab默认选中 
	document.getElementById("tab1").style.backgroundImage = "url(images/index/summaryTabSelect.png)";
	document.getElementById("tab1").style.color = "#FFFFFF";
	document.getElementById("tab2").style.backgroundImage = "url(images/index/tableTab.png)";
	document.getElementById("tab2").style.color = "#2a84ca";
	//创建一个表格
	createTable(tableDom, query_url, columns, conditions);		
	$.ajax({
		url : "RescueCounterplan/getStatistics?timestamp=" + Math.random(),
		type : 'get',
		data : {			
				},
		dataType : 'json',
		success : function(responseText, textStatus) {
			if (responseText.stateCode == "200") {
				var datas = responseText.data;
				picData = responseText.data;
				if(datas != undefined && datas != null){
					//预案级别统计
					if(datas[0] != null){
						setPic(datas[0], 'indexLevelBar', 'indexLevelPie', '预案级别统计', '预案级别比例图', '数量/个','个');
					}
					//预案类别统计
					if(datas[1] != null){
						setPic(datas[1], 'indexClassesBar', 'indexClassesPie', '预案类别统计', '预案类别比例图', '数量/个','个');
					}
					//预案领域统计
					if(datas[2] != null){
						setPic(datas[2], 'indexFieldBar', 'indexFieldPie', '预案领域统计', '预案领域比例图', '数量/个','个');
					}
				}else{
					//显示图片正在加载的页面
					loadPic('indexLevelBar', 'indexLevelPie');
					loadPic('indexClassesBar', 'indexClassesPie');
					loadPic('indexFieldBar', 'indexFieldPie');
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
		if(columns[i] == "预案名称"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "119px"
			});
		}else if(columns[i] == "预案备案编号"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "118px"
			});
		}else if(columns[i] == "预案类别"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "118px"
			});
		}else if(columns[i] == "预案级别"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "118px"
			});
		}else if(columns[i] == "适用领域"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "118px"
			});
		}else if(columns[i] == "主管单位"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "118px"
			});
		}else{
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "118px"
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
		"bProcessing" : true,
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
 * @function: 过滤分页数据函数（即从返回的数据中选择所需要的列）
 * @description: 根据后台分页对象和列名过滤数据
 * @params: 1. pageObj - 后台分页返回对象 2. columns - 列名组
 */
function filterPageData(pageObj, columns) {
	//用来计算序号的值
	var tempData = [];
	if(pageObj.list != undefined && pageObj.list != null){
		for (var i in pageObj.list) {
			tempData[i] = [];
			for (var k in columns) {
				if(k == "operation"){
					pageObj.list[i][k] = '<a href="#" onclick=rescueLookFunction("'
						+ pageObj.list[i]["plan_id"]//该处的值为id
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
 * @params: 1. id - 表的唯一id
 */
function rescueLookFunction(id) {
	var flag = 0;
	$('#indexModalForm').modal('show');
	$('#rescueSeeForm').off();
	$('.modal-dialog').draggable();		//设置详情窗口可拖拽
	//查找与id相同的数据
	if(pageObj.list != undefined && pageObj.list != null){
		for(var i in pageObj.list){
			if(id == pageObj.list[i]["plan_id"]){
				flag = 1;
				break;
			}
		}
	}
	if(flag == 1){
		var data = pageObj.list[i];
		//设置每个表单的值
		//预案名称
		$("#rescueName_check").val(data["plan_name"]);
		//发布单位
		$("#rescuePublicUnit_check").val(data["pub_dept_name"]);
		//预案备案编号
		$("#rescueNum_check").val(data["plan_bak_number"]);	
		//预案类别
		$("#rescueClasses_check").val(data["plan_type"]);
		//预案级别
		$("#rescueLevel_check").val(data["plan_grade"]);	
		//签发人
		$("#rescuePeople_check").val(data["issuer_name"]);	
		//适用领域
		$("#rescueField_check").val(data["apply_field"]);
		//发布文号
		$("#rescueReleaseNum_check").val(data["publish_number"]);
		//主管单位
		$("#rescueOrganizer_check").val(data["safety_agencies_name"]);	
		//发布日期
		var pubDate = (data["publish_date"] == "" || data["publish_date"] == null)? data["publish_date"] : stringToDate(data["publish_date"]);
		$("#rescueReleaseDate_check").val(pubDate);	
		//修订日期
		var moDate = (data["revision_date"] == "" || data["revision_date"] == null)? data["revision_date"] : stringToDate(data["revision_date"]);
		$("#rescueRevisionDate_check").val(moDate);
		//危险目标
		$("#rescueDanTarget_check").val(data["danger_target"]);	
		//编制依据
		$("#rescueBasis_check").val(data["compilation_basis"]);		
		//关联事件
		$("#rescueEvent_check").val(data["link_event"]);	
		//预案摘要
		$("#rescueSummary_check").val(data["main_content"]);
		//备注
		$("#rescueMark_check").val(data["note"]);			
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
				url : "RescueCounterplan/getStatistics?timestamp=" + Math.random(),
				type : 'get',
				data : {			
						},
				dataType : 'json',
				success : function(responseText, textStatus) {
					if (responseText.stateCode == "200") {
						var datas = responseText.data;
						picData = responseText.data;
						if(datas != undefined && datas != null){
							//预案级别统计
							if(datas[0] != null){
								setPic(datas[0], 'indexLevelBar', 'indexLevelPie', '预案级别统计', '预案级别比例图', '数量/个','个');
							}
							//预案类别统计
							if(datas[1] != null){
								setPic(datas[1], 'indexClassesBar', 'indexClassesPie', '预案类别统计', '预案类别比例图', '数量/个','个');
							}
							//预案领域统计
							if(datas[2] != null){
								setPic(datas[2], 'indexFieldBar', 'indexFieldPie', '预案领域统计', '预案领域比例图', '数量/个','个');
							}
						}else{
							//显示图片正在加载的页面
							loadPic('indexLevelBar', 'indexLevelPie');
							loadPic('indexClassesBar', 'indexClassesPie');
							loadPic('indexFieldBar', 'indexFieldPie');
						}												
					} else {
						alert("图表信息获取失败");
						return false;
					}
				}
			});			
		}else{
			if(picData != undefined && picData != null){
				//预案级别统计
				if(picData[0] != null){
					setPic(picData[0], 'indexLevelBar', 'indexLevelPie', '预案级别统计', '预案级别比例图', '数量/个','个');
				}
				//预案类别统计
				if(picData[1] != null){
					setPic(picData[1], 'indexClassesBar', 'indexClassesPie', '预案类别统计', '预案类别比例图', '数量/个','个');
				}
				//预案领域统计
				if(picData[2] != null){
					setPic(picData[2], 'indexFieldBar', 'indexFieldPie', '预案领域统计', '预案领域比例图', '数量/个','个');
				}
			}else{
				//显示图片正在加载的页面
				loadPic('indexLevelBar', 'indexLevelPie');
				loadPic('indexClassesBar', 'indexClassesPie');
				loadPic('indexFieldBar', 'indexFieldPie');
			}
		}
	}
}