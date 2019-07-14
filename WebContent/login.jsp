<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="keywords"  content="设置关键词..." />
<meta name="description" content="设置描述..." />
<meta name="author" content="DeathGhost" />
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name='apple-touch-fullscreen' content='yes'>
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta name="format-detection" content="address=no">
<link rel="icon" href="images/icon/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="javascript/jquery.js"></script>
<script src="javascript/public.js"></script>
<script src="javascript/plug-ins/customScrollbar.min.js"></script>
<script src="javascript/pages/login.js"></script>
<title>Insert title here</title>
</head>
<body class="login-page">
	<section class="login-contain">
		<header>
			<h1>兜兜5G通信系统</h1>
			<p>Doudou 5G system</p>
		</header>
	<form action="login" method="post">
		<input type="hidden" name="oper" value="login" />
		<div class="form-content">
			<ul>
				<li>
					<div class="form-group">
						<label class="control-label">账号名：</label>
						<input name="uname" type="text" placeholder="用户名/手机号..." class="form-control form-underlined" id="adminName"/>
					</div>
				</li>
				<li>
					<div class="form-group">
						<label class="control-label">密码：</label>
						<input name="password" type="password"  placeholder="密码.." class="form-control form-underlined" id="adminPwd"/>
					</div>
				</li>
				<li>
					<label class="check-box">
						<input type="checkbox" name="remember"/>
						<span>记住账号密码</span>
						
					</label>
					<label style="float:right">
						<span><a href="reg.jsp">注册</a></span>
					</label>
					
				</li>
				<li>
					<button class="btn btn-lg btn-block" id="entry">立即登录</button>
				</li>
				<li>
					<p class="btm-info">©Copyright 2019-2020 <a href="#" target="_blank" title="DeathGhost">majian.club</a></p>
					<address class="btm-info">江西省南昌市青山湖区</address>
				</li>
			</ul>
		</div>
	
	</form>
	</section>
<div class="mask"></div>
<div class="dialog">
	<div class="dialog-hd">
		<strong class="lt-title">标题</strong>
		<a class="rt-operate icon-remove JclosePanel" title="关闭"></a>
	</div>
	<div class="dialog-bd">
		<!--start::-->
		<p>这里是基础弹窗,可以定义文本信息，HTML信息这里是基础弹窗,可以定义文本信息，HTML信息。</p>
		<!--end::-->
	</div>
	<div class="dialog-ft">
		<button class="btn btn-info JyesBtn">确认</button>
		<button class="btn btn-secondary JnoBtn">关闭</button>
	</div>
</div>
</body>
</html>