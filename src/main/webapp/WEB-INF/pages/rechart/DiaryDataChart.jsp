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
	<style type="text/css">
	   #backImg{
	   	background: url("<%=basePath%>/images/background.jpg");
	   }
	</style>
</head>
<body onload="fetchData()">
	<div id="backImg">
     
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="myEchartsDiv" style="height: 700px;border: 1px dotted black"></div>
	</div>
	<!-- ECharts单文件引入 -->
	<script type="text/javascript">				
		//最近一周的学习日期
		var dates = new Array();
		//最近一周的学习记录
		var counts = new Array();
		
		//请求服务器并获取数据		
		function fetchData() {
			$.ajax({
				url:"rechart/DiaryData.html?userId="+'${userId}',
				success:function(result){
					datas = $.parseJSON(result);													
					//获取单词学习数量
					wordCount = datas[0].wordCounts;
					//获取作品上传数量
					workCount = datas[0].workCounts;
					//获取金币数
					goldCount = datas[0].goldCounts;
					showData(wordCount,workCount,goldCount);
				}
			});		
		}
		
		
		function showData(wordCount,workCount,goldCount){
			//alert(wordCount);
		    // 基于准备好的dom，初始化echarts图表
		    var myChart = echarts.init(document.getElementById('myEchartsDiv'),'macarons');

		    var option = {
		    	    title: {
		    	        x: 225,	
		    	        y:55,
		    	        text: '学习日记',
		    	        textStyle:{
		    	        	fontSize: 28,
			                fontWeight: 'bolder',
		    	        	color: '#ffffff'
		    	        	},
		    	    },
		    	    tooltip: {
		    	        trigger: 'item'
		    	    },
		    	    toolbox: {
		    	        show: true,
		    	        
		    	    },
		    	    calculable: true,
		    	    grid: {
		    	        borderWidth: 0,
		    	        y: 80,
		    	        y2: 60
		    	    },
		    	    xAxis: [
		    	        {
		    	            type: 'category',
		    	            show: false,
		    	            data: ['word', 'work', 'gold']
		    	        }
		    	    ],
		    	    yAxis: [
		    	        {
		    	            type: 'value',
		    	            show: false
		    	        }
		    	    ],
		    	    series: [
		    	        {
		    	            name: '学习日记',
		    	            type: 'bar',
		    	            itemStyle: {
		    	                normal: {
		    	                    color: function(params) {
		    	                        // build a color map as your need.
		    	                        var colorList = [
		    	                         '#FCCE10',
		    	                           '#9BCA63','#60C0DD',
		    	                          
		    	                        ];
		    	                        return colorList[params.dataIndex]
		    	                    },
		    	                    label: {
		    	                        show: true,
		    	                        position: 'top',
		    	                        formatter: '{b}\n{c}'
		    	                    }
		    	                }
		    	            },
		    	            data: [wordCount[0],workCount[0],goldCount[0]],
		    	            markPoint: {
		    	                tooltip: {
		    	                    trigger: 'item',
		    	                    backgroundColor: 'rgba(0,0,0,0)',
		    	                    formatter: function(params){
		    	                        return '<img src="' 
		    	                                + params.data.symbol.replace('images://', '')
		    	                                + '"/>';
		    	                    }
		    	                },
		    	                data: [
		    	                    {xAxis:0, y: 350, name:'word', symbolSize:20, symbol: 'images/word.png'},
		    	                    {xAxis:1, y: 350, name:'work', symbolSize:20, symbol: 'images/work.png'},
		    	                    {xAxis:2, y: 350, name:'gold', symbolSize:20, symbol: 'images/gold.png'},
		    	                         ]
		    	            }
		    	        }
		    	    ]
		    	};
		 	// 为echarts对象加载数据
		    myChart.setOption(option);
		    window.onresize = myChart.resize;
		}  	                    
	</script>
</body>
</html>