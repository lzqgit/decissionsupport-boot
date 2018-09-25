/**
 * 医疗机构
 */
var query_url = "MedicalInstitution/list?timestamp=" + Math.random();
var columns = {
	"mediorg_name" : "机构名称",	
	"org_level" : "单位级别",	
	"sickbed_num" : "病床数",	
	"doctor_num" : "医生数",
	"nurse_num" : "护士数",
	"other_tec_num" : "其他技术人数",
	"ambulance_num" : "急救车辆数",
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
	$(".menusonFrist li").eq(2).addClass("active");
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
		url : "MedicalInstitution/getStatistics?timestamp=" + Math.random(),
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
					if(datas[0] != null){
						setPic(datas[0], 'mediacalConstituteBar', 'mediacalConstitutePie', '医疗机构组成统计', '医疗机构组成比例图', '数量/个','个');
					}
					//根据医疗机构名称对医疗机构床位进行统计
					if(datas[1] != null){
						setPic(datas[1], 'mediacalBedBar', 'mediacalBedPie', '医疗机构床位统计', '医疗机构床位比例图', '数量/个','个');
					}
				}else{
					//显示图片正在加载的页面
					loadPic('mediacalConstituteBar', 'mediacalConstitutePie');
					loadPic('mediacalBedBar', 'mediacalBedPie');					
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
				"sWidth" : "135px"
			});
		}else if(columns[i] == "单位级别"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "130px"
			});
		}else if(columns[i] == "病床数"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "70px"
			});
		}else if(columns[i] == "医生数"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "70px"
			});
		}else if(columns[i] == "护士数"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "70px"
			});
		}else if(columns[i] == "其他技术人数"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "120px"
			});
		}else if(columns[i] == "急救车辆数"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "110px"
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
							+ pageObj.list[i]["mediorg_id"]
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
			if (id == pageObj.list[i]["mediorg_id"]) {
				flag = 1;
				break;
			}
		}
	}
	if(flag == 1){
		var data = pageObj.list[i];
		//设置每个表单的值
		//机构名称
		$("#institutionName_check").val(data["mediorg_name"]);
		//单位级别
		$("#unitLevel_check").val(data["org_level"]);		
		//所属单位
		$("#institutionPublicUnit_check").val(data["belong_org_name"]);	
		//病床数
		$("#bedCount_check").val(data["sickbed_num"]);			
		//医生数
		$("#doctorCount_check").val(data["doctor_num"]);	
		//护士数
		$("#nurseCount_check").val(data["nurse_num"]);
		//其他技术人数
		$("#otherCount_check").val(data["other_tec_num"]);	
		//急救车辆数
		$("#ambulanceCount_check").val(data["ambulance_num"]);	
		//联系人姓名
		$("#telName_check").val(data["linkman_name"]);	
		//联系人电话
		$("#telNumber_check").val(data["linkman_mobile"]);	
		//联系人手机
		$("#telPhone_check").val(data["linkman_tel"]);	
		//传真
		$("#fax_check").val(data["fax_no"]);			
		//经度
		$("#longitude_check").val(data["longitude"]);	
		//纬度
		$("#latitude_check").val(data["latitude"]);			
		//主要医疗设备
		$("#medicalEquip_check").text(data["medi_equip"]);
		//地址
		$("#address_check").text(data["addr"]);		 		
		//基本情况
		$("#basisInfo_check").text(data["base_info"]);	
		//主要特色
		$("#feature_check").text(data["feature"]);	 		
		//应急能力描述
		$("#emergencyDescribe_check").text(data["ability"]);	
		//备注
		$("#remark_check").text(data["remark"]);				 		
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
				url : "MedicalInstitution/getStatistics?timestamp=" + Math.random(),
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
							if(datas[0] != null){
								setPic(datas[0], 'mediacalConstituteBar', 'mediacalConstitutePie', '医疗机构组成统计', '医疗机构组成比例图', '数量/个','个');
							}
							//根据医疗机构名称对医疗机构床位进行统计
							if(datas[1] != null){
								setPic(datas[1], 'mediacalBedBar', 'mediacalBedPie', '医疗机构床位统计', '医疗机构床位比例图', '数量/个','个');
							}
						}else{
							//显示图片正在加载的页面
							loadPic('mediacalConstituteBar', 'mediacalConstitutePie');
							loadPic('mediacalBedBar', 'mediacalBedPie');					
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
				if(picData[0] != null){
					setPic(picData[0], 'mediacalConstituteBar', 'mediacalConstitutePie', '医疗机构组成统计', '医疗机构组成比例图', '数量/个','个');
				}
				//根据医疗机构名称对医疗机构床位进行统计
				if(picData[1] != null){
					setPic(picData[1], 'mediacalBedBar', 'mediacalBedPie', '医疗机构床位统计', '医疗机构床位比例图', '数量/个','个');
				}
			}else{
				//显示图片正在加载的页面
				loadPic('mediacalConstituteBar', 'mediacalConstitutePie');
				loadPic('mediacalBedBar', 'mediacalBedPie');
			}
		}
	}
}