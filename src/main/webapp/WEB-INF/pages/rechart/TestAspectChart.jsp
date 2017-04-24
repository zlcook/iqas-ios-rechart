<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Word show</title>
	<!-- 引入JQuery -->
	<script type="text/javascript" src="../js/rechart/jquery-2.2.0.min.js"></script>
	<!-- 引入Highcharts库 -->
	<script type="text/javascript" src="../js/rechart/highcharts.js"></script>
	<!-- 引入图表导出功能 -->
	<script type="text/javascript" src="../js/rechart/exporting.js"></script>

</head>
<body onload="fetchData()">
	<!-- 为Highcharts准备一个具备大小（宽高）的Dom -->
	<br />
	<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	
	<!-- Highcharts单文件引入 -->
	<script type="text/javascript">	
		//最近一周的学习日期
		var datas = new Array();
		//最近一周的学习日期
		var aspectDatas = new Array();
		//最近一周的学习记录
		var aspectScores = new Array();
		//请求服务器并获取数据
		function fetchData() {
			$.ajax({
				url:"TestAspect.html",
				success:function(result){
					datas = $.parseJSON(result);													
					//获取到考察方面的数据
					aspectDatas = datas[0].testAspectCount;	
					aspectScores = datas[0].testScoreDatas;
					showData(aspectDatas,aspectScores);
					}
				})
		}	
		
		function showData(aspectDatas,aspectScores){
			
			Highcharts.setOptions({
		        colors: ['#FF9655', '#24CBE5',  '#FFF263', '#6AF9C4']
		    });
			
			$('#container').highcharts({
                chart: {
                    plotBackgroundColor: null,
                    plotBorderWidth: null,
                    plotShadow: false                   
                },
                title: {
                    text: '闯关类型对比(考察方面)'
                },
                
                credits: {
		            /* text: '首都师范大学',
		            href: 'http://www.cnu.edu.cn/',
		             */
		        	style: {                            // 样式设置
		        		cursor: 'pointer',
		        		
		        		fontSize: '18px'
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
                            color: '#000000',
                            connectorColor: '#000000',
                            format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                            style: {fontSize:"13px"} 
                        }
                    }
                },
                series: [{
                    type: 'pie',
                    name: '比例',
                    data: [
                        {
                        	name:'听力',  
                        	y:aspectDatas[0],
                        	z:aspectScores[0],
                        	sliced: true,
	                        selected: true
                        },
                        {
                        	name:'词义',       
                        	y:aspectDatas[1],
                        	z:aspectScores[1]	                        
                        },
                        {
                            name: '拼写',
                            y: aspectDatas[2],
                            z:aspectScores[2]                            
                        },
                        {
                        	name:'用法',   
                         	y:aspectDatas[3],
                         	z:aspectScores[3]
                        }
                    ]
                }]
            });
	}
	</script>
</body>
</html>