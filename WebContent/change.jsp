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
			
				<div class="panel panel-default">
					<div class="panel-bd">
						<div class="panel panel-secondary">
							<div class="panel-hd">变更套餐</div>
							<div class="panel-bd">
								
								
								<ul class="flex flex-nowrap">
									<li class="box-child">
										<div class="panel panel-primary mr-10">
											<div class="panel-hd">话痨套餐</div>
											<div class="panel-bd">
												<p>通话时间：500分钟</p>
												<p>短信：30条</p>
												<p>流量:（不带流量）</p>
												<p>月费:58元/月</p>
											</div>
										</div>
									</li>
									<li class="box-child">
										<div class="panel panel-secondary mr-10">
											<div class="panel-hd">超人套餐</div>
											<div class="panel-bd">
												<p>通话时间：200分钟</p>
												<p>短信：50条</p>
												<p>流量:1GB</p>
												<p>月费:78元/月</p>												
											</div>
										</div>
									</li>
									<li class="box-child">
										<div class="panel panel-primary">
											<div class="panel-hd">网虫套餐</div>
											<div class="panel-bd">
												<p>通话时间：（套餐不自带）</p>
												<p>短信：（套餐不自带）</p>
												<p>流量:3G</p>
												<p>月费:68元/月</p>												
											</div>
										</div>
									</li>
								</ul>							
								
				
						<div class="btn-drop-group form-group-col-2">
							<div class="form-label" style="width:140px">选择套餐：</div>						
									<button class="btn btn-secondary dropdown-toggle" id="tc">话痨套餐</button>
									<div class="drop-list">
										<ul>
											<li class="xtc" style="text-align: center">话痨套餐</li>
											<li class="xtc" style="text-align: center">网虫套餐</li>
											<li class="xtc" style="text-align: center">超人套餐</li>
										</ul>
									</div>
								</div>						
						</div>
						
						
						<div class="form-group-col-2">
							<div class="form-label" style="width:150px">确认号码：</div>
							<div class="form-cont">
								<input type="tel" placeholder="手机号码..." id="num" class="form-control form-boxed" style="width:300px;">
							</div>
						</div>	
											
						<div class="form-group-col-2">
							<div class="form-label" style="width:190px">你当前的套餐是：</div>
							<div class="form-label">
								<%=
									mc.getSerPackage().getName()
							
								%>
							</div>
						</div>	
						<div class="form-group-col-2">
							<div class="form-label" style="width:150px;margin-left:10px">	
								<button class="btn btn-danger radius-rounded" id="submits">确认更改</button>					
							</div>
						</div>	
						<input type="hidden" name="tn"  id="tn" value=<%=mc.getSerPackage().getName()%>>
						<input type="hidden" name="tm" id="tm" vlaue=<%=mc.getMoney() %>>
						
							
							</div>
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
	$(".xtc").click(function(){
		//alert($(this).html());
		//alert($("#tc").html());
		$("#tc").html($(this).html());
	});
	
	$("#submits").click(function(){
		//alert("cc")
		var taoc=$("#tc").html();
		var num=$("#num").val();
		
		var b=true;
		var tn=$("#tn").val();
		//alert(tn);
		if(num!=""){
		if(tn==taoc){
			b=false;
		}
		if(b){
			$.post("change",{taoc:taoc,num:num});	
		}else{
			alert("变更失败，您变更的就是您当前的套餐");
		}
			
		}else{
			alert("号码不能为空");
		}
	})
	
</script>
</html>