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
	<script type="text/javascript" src="js/rechart/echarts-all.js"></script>
	
	<!-- 引入JQuery -->
	<script type="text/javascript" src="js/rechart/jquery-2.2.0.min.js"></script>
</head>
<body onload="fetchData()">
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="myEchartsDiv" style="height: 400px; border: 1px dotted black"></div>
	
	<!-- ECharts单文件引入 -->
	<script type="text/javascript">				
		//最近一周的学习日期
		var dates = new Array();
		//最近一周的学习记录
		var counts = new Array();
		
		//请求服务器并获取数据		
		function fetchData() {
			alert("dd");
			$.ajax({
				url:"rechart/WChart.html",
				success:function(result){
					alert(111);
					datas = $.parseJSON(result);													
					//获取到最近一周的学习日期
					dates = datas[0].diaryDates;
					//获取到最近一周的学习记录
					counts = datas[0].wordCounts;
					showData(dates,counts);
				}
			});		
		}
		
		
		function showData(dates,counts){
			
		    // 基于准备好的dom，初始化echarts图表
		    var myChart = echarts.init(document.getElementById('myEchartsDiv'),'macarons');

		    var option = {
		        title : {
		            text: '最近七日单词学习数量',
		        },
		        tooltip : {
		            trigger: 'axis'
		        },
		        legend: {
		            data:['单词数量']
		        },
		        toolbox: {
		            show : true,
		            feature : {
		                mark : {show: true},
		                dataView : {show: true, readOnly: false},
		                magicType : {show: true, type: ['line', 'bar']},
		                restore : {show: true},
		                saveAsImage : {show: true}
		            }
		        },
		        calculable : true,
		        xAxis : [
		            {
		                type : 'category',
		                boundaryGap : false,		                
		                data :dates
			        }
		        ],
		        yAxis : [
		            {
		                type : 'value',
		                axisLabel : {
		                    formatter: '{value} 个'
		                }
		            }
		        ],
		        series : [
		            {
		                name:'单词数量',
		                type:'line',
		                data:counts,
		                markPoint : {
		                    data : [
		                        {type : 'max', name: '最大值'},
		                        {type : 'min', name: '最小值'}
		                    ]
		                },

		            },

		        ] 
		    };

		    // 为echarts对象加载数据
		    myChart.setOption(option);
		    window.onresize = myChart.resize;
		}	
	</script>
</body>
</html>