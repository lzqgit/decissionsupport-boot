
var loadFlag = 0;	//判断图片是否加载
/**
 * @function: 设置显示图
 * @description: 设置显示图
 * @params: 1. data —— 后台返回的map对象   2. barId——存放条形图的id
 * @params: 3. pieId —— 存放比例图的id     4. picBarTitle——条形图标题名称  
 * @params: 5. picPieTitle——比例图标题名称 5. pieId —— 存放比例图的id 
 * @params: 6. verticalUnit——条形图纵坐标的单位名称
 */
function setPic(data, barId, pieId, picBarTitle, picPieTitle, verticalUnit,unit){
	//获取图所需要的数据
	var keyArray = [];
	var dataArray = [];
	var dataPieArray = [];
	var totalCount = 0;
	for(var key in data){
		keyArray.push(key);
		dataArray.push(data[key]);
		dataPieArray.push({name: key, value: data[key]});
		totalCount += data[key];
		
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
	
	//图片已加载
	loadFlag = 1;
}

/**
 * @function: 设置正在加载图片
 * @description: 设置正在加载图片
 * @params: 1. barId——存放条形图的id
 * @params: 2. pieId —— 存放比例图的id
 */
function loadPic(barId, pieId) {
	/* 统计图 */
	require.config({
		// 配置路径
		paths : {
			echarts : 'js/plugin/source'
		}
	});
	// 使用
	require([ 'echarts', 'echarts/chart/bar',// 使用柱状图加载bar，按需加载
	'echarts/chart/pie' ], function(ec) {
		if (loadFlag == 0) {
			// 基于准备好的dom，初始化echarts图表
			var barChart = ec.init(document.getElementById(barId));
			var pieChart = ec.init(document.getElementById(pieId));

			barChart.showLoading({
				effectOption : {
					backgroundColor : '#0e1c49'
				},
				text : '请稍等，数据正在加载...'
			});

			pieChart.showLoading({
				effectOption : {
					backgroundColor : '#0e1c49'
				},
				text : '请稍等，数据正在加载...'
			});
		}
	});
}