<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page language="java" import="com.sc.mj.pojo.*"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="keywords"  content="设置关键词..." />
<meta name="description" content="设置描述..." />
<meta name="author" content="DeathGhost" />
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<link rel="icon" href="images/icon/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="javascript/jquery.js"></script>
<script src="javascript/plug-ins/customScrollbar.min.js"></script>
<script src="javascript/plug-ins/echarts.min.js"></script>
<script src="javascript/plug-ins/layerUi/layer.js"></script>
<script src="editor/ueditor.config.js"></script>
<script src="editor/ueditor.all.js"></script>
<script src="javascript/plug-ins/pagination.js"></script>
<script src="javascript/public.js"></script>
</head>
<body>
<%
	MobileCard mc=(MobileCard)session.getAttribute("user");
%>
<div class="main-wrap">
	<div class="side-nav">
		<div class="side-logo">
			<div class="logo">
				<span class="logo-ico">
					<i class="i-l-1"></i>
					<i class="i-l-2"></i>
					<i class="i-l-3"></i>
				</span>
				<strong>兜兜5G通信系统</strong>
			</div>
		</div>
		
		<nav class="side-menu content mCustomScrollbar" data-mcs-theme="minimal-dark">
			<h2>
				<a href="info?sel=a" class="InitialPage"><i class="icon-columns"></i>本月账单查询</a>
			</h2>
			<h2>
				<a href="show" class="InitialPage"><i class="icon-dashboard"></i>套餐余量查询</a>
			</h2>
			<h2>
				<a href="vcost.jsp" class="InitialPage"><i class="icon-dashboard"></i>模拟消费</a>
			</h2>
			<h2>
				<a href="info?sel=b" class="InitialPage"><i class="icon-dashboard"></i>打印消费详单</a>
			</h2>
			<h2>
				<a href="change.jsp" class="InitialPage"><i class="icon-dashboard"></i>变更套餐</a>
			</h2>
			<h2>
				<a href="charge.jsp" class="InitialPage"><i class="icon-dashboard"></i>充值</a>
			</h2>
			<h2>
				<a href="quit.jsp" class="InitialPage"><i class="icon-dashboard"></i>办理退网</a>
			</h2>
			
		</nav>
		<footer class="side-footer">© sc.majian版权所有</footer>
	</div>
	<div class="content-wrap">
		<header class="top-hd">
			<div class="hd-lt">
				<a class="icon-reorder"></a>
			</div>
			<div class="hd-rt">
				<ul>
					<li>
						<a href="#" target="_blank"><i class="icon-home"></i>首页</a>
					</li>

					<li>
						<a><i class="icon-user"></i>用户:<em><%=mc.getUserName() %></em></a>
					</li>

					<li>
						<a href="javascript:void(0)" id="JsSignOut"><i class="icon-signout"></i>安全退出</a>
					</li>
				</ul>
			</div>
		</header>
		<main class="main-cont content mCustomScrollbar">
			
			<div class="page-wrap">
			
			
				<section class="page-hd">
					<header>
						<h2 class="title">办理退网</h2>
						<p class="title-description">
							您将注销您的账号，并且清空消费记录
						</p>
					</header>
					<hr>
				</section>	
				
				
					<table class="table table-bordered  mb-15">
						<thead>
							<tr>
								<th>手机号</th>
								<th>剩余金额</th>

							</tr>
						</thead>
						<tbody>
							<tr class="cen">
								<td><%=mc.getCardNumber() %></td>
								<td id="money"><%=mc.getMoney() %></td>
								
							</tr>
						</tbody>
					</table>
					
					
					<div class="form-group-col-2">
						<div class="form-label">退款方式：</div>
						<div class="form-cont">
							<label class="radio">
								<input type="radio" name="package"  checked="checked" />
								<span>支付宝</span>
							</label>
							<label class="radio">
								<input type="radio" name="package" />
								<span>微信</span>
							</label>
							<label class="radio">
								<input type="radio" name="package"/>
								<span>银行卡</span>
							</label>
						</div>
					</div>								
					
					
				<div class="form-group-col-2">
									<div class="form-label">退款账户：</div>
									<div class="form-cont">
										<input id="acc" name="money" type="tel" placeholder="这个账户将收到您折扣后话费" class="form-control form-boxed" style="width:300px;">
									</div>
								</div>
								
								
								<div class="form-group-col-2">
									<div class="form-label"></div>
									<div class="form-cont">
										<input id="submits" type="submit" class="btn btn-danger  radius-rounded" value="退网"  />
									</div>
								</div>										
					
				
				
						
			</div>
			
			
			
			
			
		</main>
		<footer class="btm-ft">
			<p class="clear">
				<span class="fl">©Copyright 2019 <a href="#" title="DeathGhost" target="_blank">majian.club</a></span>
				<span class="fr text-info">
					<em class="uppercase">
						<i class="icon-user"></i>
						author:majian
					</em> | 
					<a onclick="reciprocate()" class="text-primary"><i class="icon-qrcode"></i>捐赠</a>
				</span>
			</p>
		</footer>
	</div>
</div>
</body>
<script type="text/javascript">	
	$("#submits").click(function(){
		var money=$("#money").html();
		var acc=$("#acc").val();
		alert(acc+"账户将收到"+money+"元，预计15个工作日内到账");
		$.post("quit");
		alert("退出系统");
		location.href = 'login.jsp';
	})
</script>
</html>