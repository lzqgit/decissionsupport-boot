/**
 * 订单数量统计
 */
var query_url = "Order/list?timestamp=" + Math.random();
var columns = {
//	"id" : "ID",
//	"enterprise_id" : "企业ID",	
	"order_no" : "订单号",	
	"invoice_no" : "货单号",
	"order_creation_date" : "订单生产日期",	
	"transaction_status" : "订单状态",
	"enterprise_name" : "物流企业",
	"operation": "操作"
};
var conditions = {
		"pageSize" : 10
};
var  tableDom=$('.creatRescuePlanTableDiv');
var loadFlag = 0;
var pageObj = null;		//后台分页数据
var picData = null;
$(document).ready(function() {
	//导航默认选中
	$(".menusonSecond li").eq(2).addClass("active");
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
		url : "Order/getStatistics?timestamp=" + Math.random(),
		type : 'get',
		data : {			
				},
		dataType : 'json',
		success : function(responseText, textStatus) {
			if (responseText.stateCode == "200") {
				var datas = responseText.data;
				picData = responseText.data;
				if(datas != undefined && datas != null){
					//按月对园区总体订单数量进行统计——由于js中取TreeMap的值不是顺序的，所以改用以下方法
					//判断是否需要显示图
					drawPicture(datas);	
					//根据按月对各家物流企业订单数量进行统计
					if(datas[1] != null){
						setPic(datas[1], 'enterpriseOrderCountBar', 'enterpriseOrderCountPie', '每月物流企业订单数量统计', '每月物流企业订单数量比例图', '数量/个','个');
					}
				}else{
					//显示图片正在加载的页面
					loadPic('totalOrderCountBar', 'totalOrderCountPie');
					loadPic('enterpriseOrderCountBar', 'enterpriseOrderCountPie');					
				}
				loadFlag = 1;				
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
	/*	if(columns[i] == "ID"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "115px"
			});
		}else if(columns[i] == "企业ID"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "115px"
			});
		}else*/ 
		if(columns[i] == "订单号"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "90px"
			});
		}else if(columns[i] == "货单号"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "90px"
			});
		}else if(columns[i] == "订单生产日期"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "115px"
			});
		}else if(columns[i] == "订单状态"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "90px"
			});
		}else if(columns[i] == "物流企业"){
			aoColumns.push({
				"sTitle" : columns[i],
				"sWidth" : "90px"
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
							+ pageObj.list[i]["order_no"]
							+ '");><span class="glyphicon rescueSee department-btn" >查看详情</span></a>';
				}
				if(k=="order_creation_date"){					
					var date = (pageObj.list[i][k] == "" || pageObj.list[i][k] == null)? pageObj.list[i][k] : stringToSecondDate(pageObj.list[i][k]);					
					pageObj.list[i][k] = date;
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
 * @params: 1. order_no——表的唯一order_no  订单号
 */
function rescueLookFunction(id) {
	$('#indexModalForm').modal('show');
	$('#rescueSeeForm').off();
	$('.modal-dialog').draggable();		//设置详情窗口可拖拽
	var flag = 0;
	//查找与id相同的数据
	if (pageObj.list != undefined && pageObj.list != null) {
		for (var i in pageObj.list) {
			if (id == pageObj.list[i]["order_no"]) {
				flag = 1;
				break;
			}
		}
	}
	if(flag == 1){
		var data = pageObj.list[i];
		//设置每个表单的值		
		//订单号
		$("#orderNumber_check").val(data["order_no"]);		
		//货单号
		$("#cargoNumber_check").val(data["invoice_no"]);		
		//订单生产日期
		$("#orderDate_check").val(data["order_creation_date"]);			
		//订单状态
		$("#orderStatus_check").val(data["transaction_status"]);			
		//物流企业
		$("#logisticsEnterprise_check").val(data["enterprise_name"]);		
		//创建人
		$("#creator_check").val(data["founder"]);			 	
		//创建时间
		var founDate = (data["foundation_date"] == "" || data["foundation_date"] == null)? data["foundation_date"] : stringToSecondDate(data["foundation_date"]);
		$("#createDate_check").val(founDate);	
		//修改人
		$("#reviser_check").val(data["modifier"]);			
		//修改时间
		var modfDate = (data["modify_date"] == "" || data["modify_date"] == "")? data["modify_date"] : stringToSecondDate(data["modify_date"]);
		$("#reviseDate_check").val(modfDate);		
		//逻辑删除
		$("#logisticsDelete_check").val(data["logically_deleted"]);					
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
				url : "Order/getStatistics?timestamp=" + Math.random(),
				type : 'get',
				data : {			
						},
				dataType : 'json',
				success : function(responseText, textStatus) {
					if (responseText.stateCode == "200") {
						var datas = responseText.data;
						picData = responseText.data;
						if(datas != undefined && datas != null){
							//按月对园区总体订单数量进行统计——由于js中取TreeMap的值不是顺序的，所以改用以下方法
							//判断是否需要显示图
							drawPicture(datas);	
							//根据按月对各家物流企业订单数量进行统计
							if(datas[1] != null){
								setPic(datas[1], 'enterpriseOrderCountBar', 'enterpriseOrderCountPie', '每月物流企业订单数量统计', '每月物流企业订单数量比例图', '数量/个','个');
							}
						}else{
							//显示图片正在加载的页面
							loadPic('totalOrderCountBar', 'totalOrderCountPie');
							loadPic('enterpriseOrderCountBar', 'enterpriseOrderCountPie');					
						}
						loadFlag = 1;				
					} else {
						alert("图表信息获取失败");
						return false;
					}
				}
			});		
		}else{
			if(picData != undefined && picData != null){
				//按月对园区总体订单数量进行统计——由于js中取TreeMap的值不是顺序的，所以改用以下方法
				//判断是否需要显示图
				drawPicture(picData);	
				//根据按月对各家物流企业订单数量进行统计
				if(picData[1] != null){
					setPic(picData[1], 'enterpriseOrderCountBar', 'enterpriseOrderCountPie', '每月物流企业订单数量统计', '每月物流企业订单数量比例图', '数量/个','个');
				}				
			}else{
				//显示图片正在加载的页面
				loadPic('totalOrderCountBar', 'totalOrderCountPie');
				loadPic('enterpriseOrderCountBar', 'enterpriseOrderCountPie');	
			}
		}
	}
}
function drawPicture(datas){
	var flag = 0;
	for(var i = 0; i < datas[0].length; i++){
		if(datas[0][i] != null){
			flag = 1;
			break;
		}
	}
	var dataPieArray = [];
	var keyArray = [];
	var totalCount = 0;
	if(flag == 1){
		dataPieArray = [];
		keyArray = ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'];
		for(var i = 0; i < datas[0].length; i++){
			datas[0][i] = datas[0][i]== null ? 0 : datas[0][i];
			dataPieArray.push({name: keyArray[i], value: datas[0][i]});
			totalCount += datas[0][i];
		}
	}else{
		datas[0] = [];
	}
		//统计图
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
			var	barChart = ec.init(document.getElementById('totalOrderCountBar'));
			var	pieChart = ec.init(document.getElementById('totalOrderCountPie'));
			
			//条形图
			var optionBar = {
					color:['#0699d0'],
				    title : {
				        text: '每月园区总体订单数量统计',
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
								interval: 0, //横坐标显示所有
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
				        	name : '数量/个',
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
				            name: '每月园区总体订单数量统计',
				            type:'bar',
				            data: datas[0]
				            
				        }
				    ],
					calculable : false
					// 折线图的各个点不允许拖拽
				};
			//比例图
			var optionPie =  {
				    title : {
				        text: '每月园区总体订单数量比例图',
				        subtext: '                                                 总数' + totalCount +'个',
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
				            name:'每月园区总体订单数量比例图',
				            type:'pie',
				            radius : '52%',
				            center: ['50%', '60%'],
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
}