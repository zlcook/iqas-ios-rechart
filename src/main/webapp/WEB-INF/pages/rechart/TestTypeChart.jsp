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
	<!-- 引入JQuery -->
	<script type="text/javascript" src="js/rechart/jquery-2.2.0.min.js"></script>
	<!-- 引入Highcharts库 -->
	<script type="text/javascript" src="js/rechart/highcharts.js"></script>
	<!-- 引入图表导出功能 -->
	<script type="text/javascript" src="js/rechart/exporting.js"></script>
</head>
<body onload="fetchData()">
	<!-- 为Highcharts准备一个具备大小（宽高）的Dom -->
	<br />
	<div id="container" style="..."></div>
	
	<!-- Highcharts单文件引入 -->
	<script type="text/javascript">
	
		//考察题型的数据
		var datas = new Array();
		//考察题型的的总个数
		var typeDatas = new Array();
		//考察题型占有的正确率
		var typeScores = new Array();
		//请求服务器并获取数据
		function fetchData() {
			$.ajax({
				url:"rechart/TestType.html?userId="+'${userId}',
				success:function(result){
					//alert(result);
					datas = $.parseJSON(result);													
					//获取到考察方面的数据
					typeDatas = datas[0].testTypeCount;	
					typeScores = datas[0].testScoreDatas;
					showData(typeDatas,typeScores);
					}
				})
		}		
		
		function showData(typeDatas,typeScores){
			
			Highcharts.setOptions({
		        colors: ['#FF9655', '#24CBE5',  '#FFF263', '#6AF9C4']
		    });
			
			$('#container').highcharts({
                chart: {
                	type:'pie',
                    plotBackgroundColor: null,
                    plotBorderWidth: null,
                    plotShadow: true,
                    plotBackgroundImage: 'images/background.png'
                },
                title: {
                    text: '闯关类型对比(题型方面)'
                },
                
                credits: {
		            text: '首都师范大学',
		            href: 'http://www.cnu.edu.cn/',
		            
		        	style: {                            // 样式设置
		        		cursor: 'pointer',
		        		
		        		fontSize: '10px'
		        	}
		        },
                tooltip: {
                    pointFormat: '<b>{series.name}: {point.percentage:.1f}%</b><br><b>正确率：</b><b>{point.z}%</b>'
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',                       
                        dataLabels: {
                            enabled: true,
                            color: '#ffffff',
                            connectorColor: '#ffffff',
                            format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                        }
                    }
                },
                series: [{
                    type: 'pie',
                    name: '比例',
                    data: [
                        {
                        	name:'填空',  
                        	y:typeDatas[0],
                        	z:typeScores[0]
                        },
                        {
                        	name:'选择',       
                        	y:typeDatas[1],
                        	z:typeScores[1]
                        },
                        {
                            name: '匹配',
                            y: typeDatas[2],
                            z:typeScores[2],
                            sliced: true,
                            selected: true
                        },
                        {
                        	name:'口语',   
                         	y:typeDatas[3],
                         	z:typeScores[3]
                        }
                    ]
                }]
            });
	}
	</script>
</body>
</html>