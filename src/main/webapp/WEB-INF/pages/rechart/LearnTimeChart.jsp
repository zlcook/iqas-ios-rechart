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
	<script type="text/javascript" src="js/rechart/echarts.js"></script>
	<script type="text/javascript" src="js/rechart/default.js"></script>
	<!-- 引入JQuery -->
	<script type="text/javascript" src="js/rechart/jquery-2.2.0.min.js"></script>
	<style type="text/css">
	   #backImg{
	   	background: url("<%=basePath%>/images/background.png");
	   }
	</style>
</head>
<body onload="fetchData()">
	<div id="backImg" style="width:700px;height:500px;">
     
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="myEchartsDiv" style="height: 500px;width:500px; border: 1px dotted black"></div>
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
				url:"rechart/LearnTime.html?userId="+'${userId}',
				success:function(result){
					datas = $.parseJSON(result);													
					//获取到上周学习的总时长
					lastWeekDatas = datas[0].lastWeekDatas;
					//获取到本周学习的总时长
					thisWeekDatas = datas[0].thisWeekDatas;
					showData(lastWeekDatas, thisWeekDatas);
				}
			});		
		}
		
		
		function showData(lastWeekDatas, thisWeekDatas){
			
		    // 基于准备好的dom，初始化echarts图表
		    var myChart = echarts.init(document.getElementById('myEchartsDiv'),'macarons');

		    var option = {
		    		title : {
			            text: '学习时长（min）',
			            textStyle: {
			                fontSize: 28,
			                fontWeight: 'bolder',
			                color: '#ffffff'          // 主标题文字颜色
			            },
			        },
			        tooltip : {
			            trigger: 'axis'
			        },
			        toolbox: {
			            show : true,
			            
			        },			       
			        grid :{ borderWidth :'0px' },
			        calculable : false,
			        xAxis :  {
			                type : 'category',
			                data : ['学习时长'],
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
			            },
			             
			        
			        yAxis :  [
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
			                      type : 'value'
			                  }
			              ],
			        series : [
			            {
			                name:'上周',
			                type:'bar',
			                data:[lastWeekDatas],

			            },
			            {
			                name:'本周',
			                type:'bar',
			                data:[thisWeekDatas],

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