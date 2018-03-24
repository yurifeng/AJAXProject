function checkUsername() {
	// AJAX标准变成流程
	// 1.获取AJAX异步请求对象(兼容性写法)
	var xmlhttp;
	if (window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {
		// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	// 2.监听异步请求对象状态改变(0->4),调用函数
	xmlhttp.onreadystatechange = function() {
		// 判断异步请求状态为4并且http请求状态码为200
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			// 核心业务逻辑
			// 通过异步请求对象获取后台发送过来的响应文本
			var rt = xmlhttp.responseText;
			if (rt == 1) {
				document.getElementById("unHint").innerHTML = "该用户名已经被注册了!";
				document.getElementById("unHint").className = "error";
			} else {
				document.getElementById("unHint").innerHTML = "OK";
				document.getElementById("unHint").className = "ok";
			}
		}
	};

	// 3.设置异步请求
	var username = document.getElementById("username").value;

	// 3-1,GET方式
	// xmlhttp.open("get", "/AjaxTeach/user/check?username=" + username, true);
	// 4.发送请求
	// xmlhttp.send();

	// 3-2,POST方式
	xmlhttp.open("post", "/AjaxTeach/user/check", true);
	// POST请求需要添加如下额外设置
	xmlhttp.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded;charset=UTF-8");
	// 4.发送请求
	xmlhttp.send("username=" + username);
}
