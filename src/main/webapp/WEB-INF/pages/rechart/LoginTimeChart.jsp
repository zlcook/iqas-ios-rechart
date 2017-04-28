<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Word show</title>
	<!-- 引入echarts库 -->
	<script type="text/javascript" src="js/dist/echarts.js"></script>	
	<!-- 引入JQuery -->
	<script type="text/javascript" src="js/rechart/jquery-2.2.0.min.js"></script>
</head>
<body onload="fetchData()"> 
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="barMain" style="height:400px;width: 350px; float:left;"></div>
	<div id="lineMain" style="height:400px;width:350px;float:left;"></div>
	<!-- ECharts单文件引入 -->
	<script type="text/javascript">				
		//最近一周的学习日期
		var dates = new Array();
		//最近一周的学习记录
		var counts = new Array();
		
		//请求服务器并获取数据		
		function fetchData() {
			$.ajax({
				url:"rechart/LoginTime.html?userId="+'${userId}',
				success:function(result){
					alert(111);
					datas = $.parseJSON(result);													
					//获取到最近一周的学习日期
					dates = datas.date;
					//获取到最近一周的学习记录
					counts = datas.minuteCount;
					alert(dates);
					showData(dates,counts);
				}
			});	
			
			$.ajax({
				url:"rechart/LearnTime.html?userId="+'${userId}',
				success:function(result){
					datas = $.parseJSON(result);													
					//获取到上周学习的总时长
					lastWeekDatas = datas[0].lastWeekDatas;
					//获取到本周学习的总时长
					thisWeekDatas = datas[0].thisWeekDatas;
					alert(thisWeekDatas);
					showWeekData(lastWeekDatas, thisWeekDatas);
				}
			});	
		}
		function showData(dates,counts){ 
			// 路径配置
		    require.config({
		        paths: {
		            echarts: 'js/dist'
		        }
		    });
		    // 使用
		    require(
		            [
		                'echarts',
		                'echarts/chart/bar',
		                'echarts/chart/line'
		            ],
		            drawEcharts
		    );

		    function drawEcharts(ec){
		        drawBar(ec);
		        //drawLine(ec);
		    }
		  
		    function drawBar(ec){
		        var myBarChart = ec.init(document.getElementById('barMain'));
		        var option = {
		            title : {
		                text: '最近七日登录时长变化',
		            },
		            tooltip : {
		                trigger: 'axis'
		            },


		            calculable : true,
		            xAxis : [
		                {
		                    type : 'category',
		                    boundaryGap : false,
		                    data : dates
		                }
		            ],
		            yAxis : [
		                {
		                    type : 'value',
		                    axisLabel : {
		                        formatter: '{value} min'
		                    }
		                }
		            ],
		            series : [
		                {
		                    name:'登录时长',
		                    type:'line',
		                    smooth:true,
		                    data:counts,
		                    markPoint : {
		                        data : [
		                            {type : 'max', name: '最大值'},
		                            {type : 'min', name: '最小值'}
		                        ]
		                    },
		                    markLine : {
		                        data : [
		                            {type : 'average', name: '平均值'}
		                        ]
		                    }
		                },

		            ]
		        };
		        /* 给柱状图绑定click事件 */
		        var ecConfig = require('echarts/config');
		        function eConsole(param) {
		            alert(param.value);
		        }
		        myBarChart.on(ecConfig.EVENT.CLICK, eConsole);
		        myBarChart.setOption(option,true); //当setOption第二个参数为true时，会阻止数据合并
		    }
		}
		

		function showWeekData(lastWeekDatas, thisWeekDatas){
			// 路径配置
		    require.config({
		        paths: {
		            echarts: 'js/dist'
		        }
		    });
		    // 使用
		    require(
		            [
		                'echarts',
		                'echarts/chart/bar',
		                'echarts/chart/line'
		            ],
		            drawEcharts
		    );
			function drawEcharts(ec){
		        //drawBar(ec);
		        drawLine(ec);
		    }
		    function drawLine(ec){
		        var myLineChart = ec.init(document.getElementById('lineMain'));
		        var option2 = {
		            title : {
		                text: '登录时长对比',
		            },
		            tooltip : {
		                trigger: 'axis',
		                axisPointer : {
		                    type: 'shadow'
		                }
		            },
		            legend: {
		                data:['上周','本周']
		            },

		            calculable : true,
		            xAxis : [
		                {
		                    type : 'category',
		                    data : ['登录时长']
		                }
		            ],
		            yAxis : [
		                {
		                    type : 'value',
		                    splitArea : {show : true}
		                }
		            ],
		            grid: {
		                x2:40
		            },
		            series : [
		                {
		                    name:'上周',
		                    type:'bar',
		                    data:[lastWeekDatas]
		                },
		                {
		                    name:'本周',
		                    type:'bar',
		                    data:[thisWeekDatas]
		                },
		            ]
		        };

		        myLineChart.setOption(option2,true);
		    }
		}
		
	</script>
</body>
</html>