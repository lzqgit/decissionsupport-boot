/**
 * 车辆违章类型统计
 */
var query_url = "PeccantCar/list?timestamp=" + Math.random();
var columns = {
	"license_plate_no" : "车牌号",
	"enterprise_name" : "企业名称",
	"alarm_type" : "报警类型",	
	"alarm_time" : "报警时间",
	"legal_person_code" : "法人代码",	
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
	$(".menusonSecond li").eq(1).addClass("active");
	$(".titleSecond").next('ul').slideDown();
	$(".titleSecond").find("span").addClass("activeStair");
	// tab默认选中 
	document.getElementById("tab1").style.backgroundImage = "url(images/index/summaryTabSelect.png)";
	document.getElementById("tab1").style.color = "#FFFFFF";
	document.getElementById("tab2").style.backgroundImage = "url(images/index/tableTab.png)";
	document.getElementById("tab2").style.color = "#2a84ca";
	//创建一个表格
	createTable(tableDom, query_url, columns, conditions);
	$.ajax({
		url : "PeccantCar/getStatistics?timestamp=" + Math.random(),
		type : 'get',
		data : {			
				},
		dataType : 'json',
		success : function(response) {
				if(response != undefined && response != null){
					//以企业名称对物流车辆违章情况进行统计
					    picData = response;
						setPicture(response, 'vehiclesViolationBar', 'vehiclesViolationPie', '物流车辆违章情况统计', '物流车辆违章情况比例图', '数量/次','次');
				}else {
					//显示图片正在加载的页面
					loadPic('vehiclesViolationBar', 'vehiclesViolationPie');
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
		if(columns[i] == "车牌号"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "119px"
			});
		}else if(columns[i] == "企业名称"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "118px"
			});
		}else if(columns[i] == "报警时间"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "118px"
			});
		}else if(columns[i] == "报警类型"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "118px"
			});
		}else if(columns[i] == "法人代码"){
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
				pageObj = obj;
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
					parameter["iTotalRecords"] = parseInt((pageObj[0].count));
					parameter["iTotalDisplayRecords"] = parseInt((pageObj[0].count));	//显示一共多少条数据	该值需要设置，否则页码显示错误 
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
	if (pageObj!= undefined && pageObj!= null) {
		for (var i in pageObj) {
			tempData[i] = [];
			for (var k in columns) {
				if(k == "alarm_time"){
					(pageObj[i][k]==""||pageObj[i][k]==null||pageObj[i][k]==undefined)?pageObj[i][k]="":pageObj[i][k] = stringToSecondDate(pageObj[i][k]);
				}			
				if (k == "operation") {
					pageObj[i][k] = '<a href="#" onclick=rescueLookFunction("'
							+ pageObj[i]["license_plate_no"]
							+ '");><span class="glyphicon rescueSee department-btn" >查看详情</span></a>';
				}
				tempData[i].push(pageObj[i][k]);

			}
		}
	}
	return tempData;
}
/**
 * @function: 查看详情
 * @description: 查看详情信息
 * @params: 1. id——表的唯一id
 */
function rescueLookFunction(id) {
	$('#indexModalForm').modal('show');
	$('#rescueSeeForm').off();
	$('.modal-dialog').draggable();		//设置详情窗口可拖拽
	var flag = 0;
	//查找与id相同的数据
	if (pageObj!= undefined && pageObj!= null) {
		for (var i in pageObj) {
			if (id == pageObj[i]["license_plate_no"]) {
				flag = 1;
				break;
			}
		}
	}
	if(flag == 1){
		var data = pageObj[i];
		//设置每个表单的值
		//车牌号
		$("#vehicleID_check").val(data["license_plate_no"]);			
		//报警类型
		$("#enterpriseID_check").val(data["alarm_type"]);		
		//报警时间
		$("#violationDate_check").val(data["alarm_time"]);		
		//法人代码
		$("#violationType_check").val(data["legal_person_code"]);			
		//创建时间
		$("#createDate_check").val(data["foundation_date"] == "" ? data["foundation_date"] : stringToSecondDate(data["foundation_date"]));		
		//修改时间
		$("#reviseDate_check").val(data["modify_date"] == "" ? data["modify_date"] : stringToSecondDate(data["modify_date"]));	
		//企业名称
		$("#enterprise_name").val(data["enterprise_name"]);
		//逻辑删除
		$("#logisticsDelete_check").val(data["logically_deleted"]);			
	}
	
}
function setPicture(data, barId, pieId, picBarTitle, picPieTitle, verticalUnit, unit){
	//获取图所需要的数据
	var keyArray = [];
	var dataArray = [];
	var dataPieArray = [];
	var totalCount = 0;
	var length = data.length;
	for(var index = 0;index<length; index++){
		keyArray.push(data[index].enterprise_name);
		dataArray.push(data[index].count);
		dataPieArray.push({name: data[index].enterprise_name, value: data[index].count});
		totalCount += data[index].count;		
	}
	/*统计图*/
	require.config({
		// 配置路径
		paths : {
			echarts : 'js/plugin/source'
		}
	});
	// 使用
	require([ 'echarts', 'echarts/chart/bar',// 使用柱状图加载bar，按需加载
			'echarts/chart/pie'], function(ec) {
		// 基于准备好的dom，初始化echarts图表
		var	barChart = ec.init(document.getElementById(barId));
		var	pieChart = ec.init(document.getElementById(pieId));
	
		/*条形图*/
		var optionBar = {
				color:['#0699d0'],
			    title : {
			        text: picBarTitle,
			        textStyle:{
			        	fontSize: 18,
			        	fontWeight: 'bolder',
			            color: '#FFFFFF'
			        },
			        x:'center'
			    },
			    tooltip : {		//鼠标悬浮交互时的信息提示
			        trigger: 'item',
			        formatter: "{b} : {c}"	//显示横坐标和数值
			    },
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            data : keyArray,
			            scale : true,
						show : true,
						axisLabel:{
					    	 textStyle:{
					    		 color:'#8f8f8f'
					    	 }
					    },
						splitLine : {
							show : false
						}
			        }
			    ],
			    
			    grid : {
					borderWidth : 0
				},
			    yAxis : [
			        {
			        	name : verticalUnit,
			            type : 'value',
			            scale : true,
						min : 0, 	//指定y轴最小值
						show : true,
						nameTextStyle:{
							color:'#8f8f8f'
						},
						axisLabel:{
							textStyle:{
					    		 color:'#8f8f8f'
					    	 }
						},
			            splitLine : {
							show : false
						}
			        }
			    ],
			    series : [
			        {
			            name: picBarTitle,
			            type:'bar',
			            data: dataArray
			            
			        }
			    ],
				calculable : false
				// 折线图的各个点不允许拖拽
			};
		/*比例图*/
		var optionPie =  {
			    title : {
			        text: picPieTitle,
			        subtext: '总数' + totalCount + unit,
			        textStyle:{
			        	fontSize: 18,
			        	fontWeight: 'bolder',
			            color: '#FFFFFF'
			        },
			        subtextStyle:{
			        	fontSize: 16,
			        	color: '#2a84ca'
			        },
			        x:'center'
			    },
			    calculable : false,
			    tooltip : {				//鼠标悬浮交互时的信息提示
			        trigger: 'item',
			        formatter: "{b} : {c} ({d}%)" //显示"{a} <br/>{b} : {c} ({d}%)" 其中{a}——标题,{b}——横坐标,{c}——数值,{d}——百分比
			    },
			    series : [
			        {
			            name:picPieTitle,
			            type:'pie',
			            radius : '50%',
			            center: ['50%', '50%'],
			            itemStyle : {
			                normal : {
			                    label : {
		                    	    show: true,
		                    	    position:'outer',
		                    	    textStyle:{
							            color: '#FFFFFF'
		                    	    },
			                        formatter : function (params) {                         
			                          return params.percent + '%' + '\n' + params.name ;
			                        }
			                    },
			                    labelLine : {
			                        show : true,
			                        lineStyle: {
			                        	color:['#42608f']
			                        }
			                    }
			                },
			                emphasis : {
			                    label : {
			                        show : false,
			                        formatter : "{b}\n{d}%"
			                    }
			                }
			                
			            },
			            data: dataPieArray
			        }
			    ]
			};
		//为echarts对象加载数据
		barChart.setOption(optionBar);
		pieChart.setOption(optionPie);
	});
	
	//图片已加载
	var loadFlag = 1;
}
/*通过点击按钮加载图表数据*/
function liClick(id) {
	//设置列表和图形按钮以及对应内容的显示和隐藏。
	setRightContent(id);
	if(id=="tab1"){
		//如果从未加载过图形统计数据则发送ajax请求后台数据否则直接加载已经保存的数据。
		if(loadFlag==0){
			$.ajax({
				url : "PeccantCar/getStatistics?timestamp=" + Math.random(),
				type : 'get',
				data : {			
						},
				dataType : 'json',
				success : function(response) {
					    picData = response;
						if(response != undefined && response != null){
							//以企业名称对物流车辆违章情况进行统计
							setPicture(response, 'vehiclesViolationBar', 'vehiclesViolationPie', '物流车辆违章情况统计', '物流车辆违章情况比例图', '数量/次','次');
						}else {
							//显示图片正在加载的页面
							loadPic('vehiclesViolationBar', 'vehiclesViolationPie');
					}
				}
			});	
		}else{
			if(picData != undefined && picData != null){
				//以企业名称对物流车辆违章情况进行统计
				setPicture(picData, 'vehiclesViolationBar', 'vehiclesViolationPie', '物流车辆违章情况统计', '物流车辆违章情况比例图', '数量/次','次');			
			}else{
				//显示图片正在加载的页面
				loadPic('vehiclesViolationBar', 'vehiclesViolationPie');	
			}
		}
	}
}