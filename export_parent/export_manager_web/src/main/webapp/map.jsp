<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html {width: 100%;height: 100%; margin:0;font-family:"微软雅黑";}
		#allmap{height:500px;width:100%;}
		#r-result,#r-result table{width:100%;}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=pFs6bnG1DhU9fBMfwWLWhUo1D5NjKUH9"></script>
	<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
	<title>根据起终点名称驾车导航</title>
</head>
<body>
<div id="allmap"></div>
<div id="driving_way">
	装运港:
	<table>
			<tr>
				<td>
					${start}
				</td>
			</tr>
	</table>
	</br>
	目的港:
	<table>
			<tr>
				<td>
					${end}
				</td>
			</tr>
	</table>
	</br>
	<table id="time"></table></br>
</div>
<div id="r-result"></div>
</body>
</html>
<script>
	map.enableScrollWheelZoom(true);   //启用滚轮放大缩小，默认禁用
</script>


<%--驾车线路规划,计算驾车时间和距离--%>
<script type="text/javascript">
    // 百度地图API功能
    let map = new BMap.Map("allmap");
	map.enableScrollWheelZoom(true);   //启用滚轮放大缩小，默认禁用
	map.centerAndZoom(new BMap.Point(116.404, 39.915), 12);
    let output = "从${start}到${end}驾车需要";
    let searchComplete = function (results){
        if (transit.getStatus() != BMAP_STATUS_SUCCESS){
            return ;
        }
        let plan = results.getPlan(0);
        output += plan.getDuration(true) + "\n";                //获取时间
        output += "总路程为：" ;
        output += plan.getDistance(true) + "\n";             //获取距离
    }
    let transit = new BMap.DrivingRoute(map, {renderOptions: {map: map},
        onSearchComplete: searchComplete,
        onPolylinesSet: function(){
            setTimeout(function(){$("#time").html(output)},"1000");
        }});
    transit.search("${start}", "${end}");
</script>

<%--定位实例,根据IP定位--%>
<script type="text/javascript">
    // 百度地图API功能
    let map = new BMap.Map("allmap");
    let point = new BMap.Point(116.331398,39.897445);
    map.centerAndZoom(point,12);

    function myFun(result){
        let cityName = result.name;
        map.setCenter(cityName);
        alert("当前定位城市:"+cityName);
    }
    let myCity = new BMap.LocalCity();
    myCity.get(myFun);

</script>
