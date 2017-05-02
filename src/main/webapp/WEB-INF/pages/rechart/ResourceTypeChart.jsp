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
		<div id="myEchartsDiv" style="height: 500px; border: 1px dotted black"></div>
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
				url:"rechart/ResourceType.html?userId="+'${userId}',
				success:function(result){
					datas = $.parseJSON(result);													
					//文本学习数量
					textCount = datas[0].textCounts;
					//图片学习数量
					pictureCount = datas[0].pictureCounts;
					//音频学习数量
					audioCount = datas[0].audioCounts;
					//视频学习数量
					videoCount = datas[0].videoCounts;
					
					showData(textCount,pictureCount,audioCount,videoCount);
				}
			});		
		}
		
		
		function showData(textCount,pictureCount,audioCount,videoCount){
			
		    // 基于准备好的dom，初始化echarts图表
		    var myChart = echarts.init(document.getElementById('myEchartsDiv'),'macarons');

		    var option = {
		            tooltip : {
		                trigger: 'item'
		            },
		            
		            calculable : true,

		            legend: {
		            	x: 125,                 // 水平安放位置，默认为左对齐，可选为： /'center' ¦ 'left' ¦ 'right'// ¦ {number}（x坐标，单位px）
						y: 35, 
		            	textStyle:{color: '#ffffff'},
		                data:['文本','图片','音频','视频']
		            },
		            xAxis : [
		                {
		                    type : 'category',
		                    splitLine : {show : false},
		                    data : ['资源点击数量'],
		                    splitLine:{show:false},
			                axisLine:{
			                	lineStyle:{
			                		color:'#ffffff',

			                	}
			                },
			                axisLabel: {
		                        textStyle: {
		                            color: '#ffffff',
		                            fontSize:'16'
		                        },
		                    },    
		                }
		            ],
		            yAxis : [
                       {
                            //  隐藏y轴
                            axisLine: {show: true},
                            // 去除y轴上的刻度线
						    axisTick: {
						        show: true
						    },                    
						    // 控制网格线是否显示
						    splitLine: {
						        show: false,			                                                         
						    },
						    axisLine:{
						      	lineStyle:{
						      		color:'#ffffff',
						      	}
						      },
						    //  改变y轴字体颜色和大小
						    axisLabel: {
						        textStyle: {
						            color: '#ffffff',
						            fontSize:'16'
						        },
						    },                    
						    type : 'value',
						    position: 'right'
						}
		              
		            ],
		            series : [
		                {
		                    name:'文本',
		                    type:'bar',
		                    barWidth : 100,
		                    data:[textCount[0]]
		                },
		                {
		                    name:'图片',
		                    type:'bar',
		                    barWidth : 100,
		                    tooltip : {trigger: 'item'},
		                    stack: '资源',
		                    data:[pictureCount[0]]
		                },
		                {
		                    name:'音频',
		                    type:'bar',
		                    barWidth : 100,
		                    tooltip : {trigger: 'item'},
		                    stack: '资源',
		                    data:[audioCount[0]]
		                },
		                {
		                    name:'视频',
		                    type:'bar',
		                    barWidth : 100,
		                    tooltip : {trigger: 'item'},
		                    stack: '资源',
		                    data:[videoCount[0]]
		                },

		                {
		                    name:'资源偏好',
		                    type:'pie',
		                    tooltip : {
		                        trigger: 'item',
		                        formatter: '{a} <br/>{b} : {c} ({d}%)'
		                    },
		                    center: [190,150],
		                    radius : [0, 40],		                    
		                    data:[
		                        {value:textCount[0], name:'文本'},
		                        {value:pictureCount[0], name:'图片'},
		                        {value:audioCount[0], name:'音频'},
		                        {value:videoCount[0], name:'视频'}
		                    ]
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