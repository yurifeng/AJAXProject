<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
<link rel="stylesheet" type="text/css" href="${base}/css/style.css">
<script type="text/javascript" src="${base }/js/register.js">
	
</script>
</head>
<body>
	<h1>注册页面(AJAX)</h1>
	<hr />
	<form action="" method="post">
		username : <input type="text" id="username" name="username"
			onchange="checkUsername()" /><span id="unHint"></span> <br /> <br />
		password : <input type="password" name="password" /> <br /> <br />
		<input type="submit" value="注册" />
	</form>
</body>
</html>
