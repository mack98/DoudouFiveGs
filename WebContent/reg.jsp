<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page language="java" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/css.css"/>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>

<style type="text/css">
	table{
		margin:0 auto;
	}
	.tt{
		
		float:left;
		width:200px;
		height:300px;
	}

</style>

</head>
	<body id="bbb" style="background:('images/bg.jpg')">
		<div class="kk">
			<div class="head">
				<h1>用户注册</h1>
			</div>
			<div id="regMain">
				<form action="reg" method="post">
				<input type="hidden" name="oper" value="regsucc" />
					<table border="0" width="800px">
					
						<tr >
							<td width="20%">用户名：</td>
							<td ><input type="text" name="user" id="name" value="" /></td>
						</tr>
						<tr >
							<td></td>
							<td></td>

						</tr>						
						<tr>
							<td>密码：</td>
							<td><input type="text" name="pwd" id="pwd" value="" /></td>
						</tr>
						<tr>
							<td><h3>请选择号码</h3></td>
							<td></td>
						</tr>
						<tr>
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
							//System.out.println(phone);
							
						}
						
						%>
							<td></td>
							<td  height="100px" >
								<p><input type="radio" name="num" checked value=<%= phones[0] %> ><span class="numr"> <%= phones[0] %></span>
									<input type="radio"  name="num" value=<%= phones[0] %> ><span  class="numr"><%= phones[1] %> </span>
									<input type="radio"  name="num" value=<%= phones[0] %>><span  class="numr"><%= phones[2] %></span>
								</p>
								<p>
									<input type="radio" name="num" value=<%= phones[0] %>><span  class="numr"><%= phones[3] %></span>
									<input type="radio" name="num" value=<%= phones[0] %>><span class="numr"><%= phones[4] %></span>
									<input type="radio"  name="num" value=<%= phones[0] %>><span class="numr"><%= phones[5] %></span>
								<p>
									<input type="radio"  name="num" value=<%= phones[0] %>><span class="numr"><%= phones[6] %></span>
									<input type="radio"  name="num" value=<%= phones[0] %>><span class="numr"><%= phones[7] %></span>
									<input type="radio"  name="num" value=<%= phones[0] %>><span class="numr"><%= phones[8] %></span>
								</p>
							</td>
						</tr>
						<tr>
							<td><h3>请选择套餐</h3></td>
							<td></td>
						</tr>
						<tr>
							<td colspan="2">
							<div>
								<div class="tt">
								
										<h3 >话痨套餐</h3>
											
												<p>通话时间：500分钟</p>
												<p>短信：30条</p>
												<p>流量:0GB</p>
												<p>月费:58元/月</p>												
											
								
								
								</div>
								<div class="tt">
								
										<h3 >超人套餐</h3>
											
												<p>通话时间：200分钟</p>
												<p>短信：50条</p>
												<p>流量:1GB</p>
												<p>月费:78元/月</p>												
											
								
								
								</div>
								<div class="tt">
								
										<h3 >网虫套餐</h3>
											
												<p>通话时间：0分钟</p>
												<p>短信：0条</p>
												<p>流量:3GB</p>
												<p>月费:68元/月</p>												
											
										
								
								</div>

							
							</div>
							<td>
						
						</tr>
						<tr>
							<td colspan="2" height="100px" ><p><input class="package" type="radio" name="package"  checked value="talk" >话痨套餐<input class="package" type="radio" name="package"  value="super" >超人套餐<input class="package" type="radio"  name="package" value="net" >网虫套餐</p></td>
						</tr>
						<tr height="100px">
							<td>预充金额：</td>
							<td><select name="money"  onchange="dd()">
								<option value="10"><span class="je">10</span></option>
								<option value="20"><span class="je">20</span></option>
								<option value="30"><span class="je">30</span></option>
								<option value="50"><span class="je">50</span></option>
								<option value="100"><span class="je">100</span></option>
								<option value="200"><span class="je">200</span></option>
								<option value="500"><span id="jj" class="je">500</span></option>
							</select>元</td>
						</tr>
						<tr>
							<td height="100px" align="center" colspan="2">
								<input type="checkbox" name="" id="dd1" value="" checked />请阅读《兜兜5G网站服务协议》  <br>
								<input type="checkbox" name="" id="dd2" value="" checked />请阅读《个人信息保护政策》&nbsp; &nbsp; &nbsp;      
							</td>
						</tr>
						<tr>
							<td height="100px" align="center" colspan="2"><input type="submit" name="" id="" value="注册" disabled /></td>
						</tr>
					</table>
					
					
					
					
					
					

					
				</form>
			</div>
		</div>
		
		
		

		
		
		
		
		
		
		
		
		
		
	</body>
<script type="text/javascript">
	 	
	 	//alert("aaaa")
	 	
	 	function dd(){
	 		var b=false;
	 		var select=$("select option:selected");
	 		var money=select.val();
	 		var pg=$(".package:radio:checked");
	 		if(pg.val()=='talk'){
	 			var tp=58;
	 			if(money<tp){
	 				alert("该金额小于该套餐消费金额"+tp);
	 				b=false;
	 			}else{
	 				b=true;
	 			}
	 		}
	 		if(pg.val()=='net'){
	 			var tp=68;
	 			if(money<tp){
	 				alert("该金额小于该套餐消费金额"+tp);
	 				b=false;
	 			}else{
	 				b=true;
	 			}
	 		}
	 		if(pg.val()=='super'){
	 			var tp=78;
	 			if(money<tp){
	 				alert("该金额小于该套餐消费金额"+tp);
	 				b=false;
	 			}else{
	 				b=true;
	 			}
	 		}
	 		
		 var name=$("#name").val();
		 var pwd=$("#pwd").val();
		 if(name!=""&&pwd!=""){
			 var dd1=$("#dd1").is(':checked');
			 var dd2=$("#dd2").is(':checked');
				if(dd1&&dd2){
				 	if(b){
				 		$(":submit").removeAttr("disabled");
				 	}
				}
		 }else{
			 
				alert("用户名或密码不能为空");
		 }
		

		 	
	 	}
	 	
		</script>
</html>