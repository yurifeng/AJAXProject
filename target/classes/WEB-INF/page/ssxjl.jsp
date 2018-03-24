<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>省市县级联</title>
<meta charset="UTF-8">
</head>
<body onload="initProvince()">
	<h1 style="margin:auto">用AJAX实现的省市县级联功能</h1>
	<hr>
	<select id="province" onchange="initCity()">
		<option>##请选择省份##</option>
	</select>
	<select id="city" onchange="initArea()">
		<option>##请选择城市##</option>
	</select>
	<select id="area">
		<option>##请选择地区##</option>
	</select>
	<script type="text/javascript">
		function initProvince() {
			var xmlhttp;
			if (window.XMLHttpRequest) {
				xmlhttp = new XMLHttpRequest();
			} else {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					//获取后台传递过来的json字符串
					var jsonStr = xmlhttp.responseText;
					//把json字符串转换成JS对象(JS数组)
					var provinces = JSON.parse(jsonStr);
					//遍历
					for (var i = 0; i < provinces.length; i++) {
						//创建选项
						var option = document.createElement("option");
						//设置选项
						option.value = provinces[i].code;
						option.text = provinces[i].name;
						//把处理好的选项绑定到下拉菜单上
						province.appendChild(option);
					}
				}
			};
			xmlhttp.open("get", "${base}/ssxjl/getProvince", true);
			xmlhttp.send();
		}

		function initCity() {
			city.length = 1;
			area.length = 1;
			
			var xmlhttp;
			if (window.XMLHttpRequest) {
				xmlhttp = new XMLHttpRequest();
			} else {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					var jsonStr = xmlhttp.responseText;
					var cities = JSON.parse(jsonStr);
					for (var i = 0; i < cities.length; i++) {
						var option = document.createElement("option");
						option.value = cities[i].code;
						option.text = cities[i].name;
						city.appendChild(option);
					}
				}
			};
			var provinceCode = document.getElementById("province").value;
			xmlhttp.open("get", "${base}/ssxjl/getCity?provinceCode="
					+ provinceCode, true);
			xmlhttp.send();
		}
		
		function initArea() {
			area.length = 1;
			
			var xmlhttp;
			if (window.XMLHttpRequest) {
				xmlhttp = new XMLHttpRequest();
			} else {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					var jsonStr = xmlhttp.responseText;
					var areas = JSON.parse(jsonStr);
					for (var i = 0; i < areas.length; i++) {
						var option = document.createElement("option");
						option.value = areas[i].code;
						option.text = areas[i].name;
						area.appendChild(option);
					}
				}
			};
			var cityCode = document.getElementById("city").value;
			xmlhttp.open("get", "${base}/ssxjl/getArea?cityCode="
					+ cityCode, true);
			xmlhttp.send();
		}
	</script>
</body>
</html>
