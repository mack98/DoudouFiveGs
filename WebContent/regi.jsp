<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page language="java" import="com.sc.mj.pojo.*,java.util.*"%>
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

<div class="main-wrap">

		
		
		<footer class="side-footer">© sc.majian版权所有</footer>
	</div>
	<div class="content-wrap">
	
		<main class=" content mCustomScrollbar">
			
				<div class="panel panel-default">
					<div class="panel-bd">
						<div class="panel panel-default">
							<div class="panel-hd"></div>
							<div class="panel-bd">
								
								<div class="panel panel-default">
									<div class="panel-bd" >
										<fieldset class="field-title dotted center">
										  <legend>用户注册</legend>
										</fieldset>
									</div>
									
																
											<ul class="flex flex-nowrap main-cont">
												<li class="box-child">
													<div class="panel panel-default mr-10">
													<div class="panel-hd">
														
														<div class="panel-bd">
														
														</div>
														
														
															<div class="form-group-col-2">
																<div class="form-label">用户名：</div>
																<div class="form-cont">
																	<input type="uname" placeholder="用户名..." class="form-control form-boxed">
																</div>		
															</div>	
															<div class="form-group-col-2">
																<div class="form-label">密码：</div>
																<div class="form-cont">
																	<input type="uname" placeholder="密码..." class="form-control form-boxed">
																</div>		
															</div>	
															<div class="form-group-col-2">
																<div class="form-label">确认密码：</div>
																<div class="form-cont">
																	<input type="uname" placeholder="再次输入密码..." class="form-control form-boxed">
																</div>		
															</div>	
															
															<%
																String [] phones=new String [9];
																for(int i=0;i<9;i++) {
																	StringBuffer phone=new StringBuffer();
																	phone.append("139");
																	
																	Random r=new Random();
																	for(int j=0;j<8;j++) {
																		phone.append(r.nextInt(10));
																		
																	}
																	phones[i]=phone.toString();															
															
																}
															%>
															
															
															<div class="form-group-col-2">
																<div class="form-label">手机号：</div>
																<div class="form-cont">
																	<label class="radio">
																		<input type="radio" name="num" checked="checked"/>
																		<span><%=phones[0] %></span>
																	</label>
																	<label class="radio">
																		<input type="radio" name="num"  />
																		<span><%=phones[1] %></span>
																	</label>
																	<label class="radio">
																		<input type="radio" name="num"/>
																		<span><%=phones[2] %></span>
																	</label>
																</div>
							
																
																<div  class="form-cont">
																
																
																	<label class="radio">
																		<input type="radio" name="num" checked="checked"/>
																		<span><%=phones[3] %></span>
																	</label>
																	<label class="radio">
																		<input type="radio" name="num"  />
																		<span><%=phones[4] %></span>
																	</label>
																	<label class="radio">
																		<input type="radio" name="num"/>
																		<span><%=phones[5] %></span>
																	</label>
																
																
																	
																</div>
																
																<div  class="form-cont">
																
																
																	<label class="radio">
																		<input type="radio" name="num" checked="checked"/>
																		<span><%=phones[6] %></span>
																	</label>
																	<label class="radio">
																		<input type="radio" name="num"  />
																		<span><%=phones[7] %></span>
																	</label>
																	<label class="radio">
																		<input type="radio" name="num"/>
																		<span><%=phones[8] %></span>
																	</label>
																
																
																	
																</div>
																
																
																
																
															</div>															
															
															
															
															
																			<div style="width:1500px" class="center">
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
																				</div>
																	
													<div class="panel-bd">
														
														</div>																	
																	
													<div class="panel-bd">
														
														</div>																	
																	
													<div class="panel-bd">
														
														</div>																	
																	
																
																	
																	
																	
																			<div class="btn-drop-group form-group-col-2">
																				<div class="form-label" >选择套餐：</div>						
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
																			
																			
													<div class="panel-bd">
														
														</div>																			
													<div class="panel-bd">
														
														</div>																			
																			<div class="btn-drop-group form-group-col-2" >
																				<div class="form-label" style="width:300px" >充值金额：						
																						<select name="money"  onchange="dd()" style="width:100px">
																							<option value="10"><span class="je">10</span></option>
																							<option value="20"><span class="je">20</span></option>
																							<option value="30"><span class="je">30</span></option>
																							<option value="50"><span class="je">50</span></option>
																							<option value="100"><span class="je">100</span></option>
																							<option value="200"><span class="je">200</span></option>
																							<option value="500"><span id="jj" class="je">500</span></option>
																						</select>
																					元
																					</div>	
																					</div>					
																			</div>																				
																			
																			
																																	
													
														
													</div>
								<input type="checkbox" name="" id="dd1" value="" checked />请阅读《兜兜5G网站服务协议》  <br>
								<input type="checkbox" name="" id="dd2" value="" checked />请阅读《个人信息保护政策》&nbsp; &nbsp; &nbsp;   														
														
														

													</div>
												</li>

											</ul>			
									
									
									
								</div>			
							
							
										
								
								
								
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
		alert("cc")
		var taoc=$("#tc").html();
		var num=$("#num").val();
		$.post("change",{taoc:taoc,num:num});
	})
</script>
</html>