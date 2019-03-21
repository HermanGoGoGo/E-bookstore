<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ page contentType="text/html;charset=utf-8"%>
<%
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html >
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<title>e书网-登录</title>
		<link rel="stylesheet" href="<%=path%>/css/normalize.css">
		<link rel="stylesheet" href="<%=path%>/css/login.css">
		<link rel="stylesheet" href="<%=path%>/css/sign-up-login.css">
		<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="<%=path%>/css/inputEffect.css" />
		<link rel="stylesheet" href="<%=path%>/css/tooltips.css" />
		<link rel="stylesheet" href="<%=path%>/css/spop.min.css" />
		<link rel="icon" href="<%=path%>/images/favicon.ico">

		<script src="<%=path%>/js/jquery.min.js"></script>
		<script src="<%=path%>/js/snow.js"></script>
		<script src="<%=path%>/js/jquery.pure.tooltips.js"></script>
		<script src="<%=path%>/js/spop.min.js"></script>
		<script>
			(function() {
				// trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
				if(!String.prototype.trim) {
					(function() {
						// Make sure we trim BOM and NBSP
						var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
						String.prototype.trim = function() {
							return this.replace(rtrim, '');
						};
					})();
				}

				[].slice.call(document.querySelectorAll('input.input__field')).forEach(function(inputEl) {
					// in case the input is already filled..
					if(inputEl.value.trim() !== '') {
						classie.add(inputEl.parentNode, 'input--filled');
					}

					// events:
					inputEl.addEventListener('focus', onInputFocus);
					inputEl.addEventListener('blur', onInputBlur);
				});

				function onInputFocus(ev) {
					classie.add(ev.target.parentNode, 'input--filled');
				}

				function onInputBlur(ev) {
					if(ev.target.value.trim() === '') {
						classie.remove(ev.target.parentNode, 'input--filled');
					}
				}
			})();

			$(function() {
				
				$('#login #login-password').focus(function() {
					$('.login-owl').addClass('password');
				}).blur(function() {
					$('.login-owl').removeClass('password');
				});
				$('#login #register-password').focus(function() {
					$('.register-owl').addClass('password');
				}).blur(function() {
					$('.register-owl').removeClass('password');
				});
				$('#login #register-repassword').focus(function() {
					$('.register-owl').addClass('password');
				}).blur(function() {
					$('.register-owl').removeClass('password');
				});
				$('#login #forget-password').focus(function() {
					$('.forget-owl').addClass('password');
				}).blur(function() {
					$('.forget-owl').removeClass('password');
				});
				$('#login #forget-repassword').focus(function() {
					$('.forget-owl').addClass('password');
				}).blur(function() {
					$('.forget-owl').removeClass('password');
				});
			});

			function goto_register() {
				$("#register-username").val("");
				$("#register-password").val("");
				$("#register-code").val("");
				$("#register-phone").val("");
				//$("#register-usercode").val(""); 
				$(".showUser").hide();
				$("#tab-2").prop("checked", true);
			}

			function goto_login() {
				//$("#login-usercode").val("");
				$("#login-password").val("");
				$("#tab-1").prop("checked", true);
			}

			function goto_forget() {
				//$("#forget-username").val("");
				$("#forget-password").val("");
				$("#forget-repassword").val("");
				$("#forget-phone").val("");
				$("#forget-phoneG").val("");
				$("#forget-phoneR").val("");
				$("#forget-code").val("");
				$(".showForget").hide();
				$("#tab-3").prop("checked", true);
			}
			
			function show_user(obj) {
				$("#register-campus").val(obj.campus);
				$("#register-degree").val(obj.degree+obj.yearStarted+"级");
				$(".showUser").show();
			}
			
			function hide_user() {
				$(".showUser").hide();
			}

			function show_forget(obj) {
				
				var phone = obj.phonenumber.substring(0,3)+"****"+obj.phonenumber.substring(8,11);				
				$("#forget-phoneR").val(phone);
				$("#forget-phoneG").val(obj.phonenumber);
				$(".showForget").show();
			}
			
			function hide_forget() {
				$(".showForget").hide();
			}
			function login() { //登录
				var username = $("#login-usercode").val(),
					password = $("#login-password").val(),
					validatecode = null,
					flag = false;
				//判断用户名密码是否为空
				if(username == "") {
					$.pt({
						target: $("#login-usercode"),
						position: 'r',
						autoClose: false,
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "一卡通账号不能为空"
					});
					flag = true;
				}
				if(password == "") {
					$.pt({
						target: $("#login-password"),
						position: 'r',
						autoClose: false,
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "密码不能为空"
					});
					flag = true;
				}
				//一卡通只能是10位数字
				var regExp = new RegExp("^[0-9_]{10,10}$");
				if(!regExp.test(username)) {
					$.pt({
						target: $("#login-usercode"),
						position: 'r',
						autoClose: false,
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "请输入10位一卡通账号"
					});
					flag = true;
				}
				if(flag) {
					return false;
				} else { //登录
					//调用后台登录验证的方法
					$("#login-btn").attr("disabled",true);
					$("#login-btn").val("正在登录");
					$.ajax({
						type: "post",
						url: "<%=path%>/verificationLogin.action",
						data: {
							"username": username,
							"password": password
						},
						dataType: 'json',
						success: function(data) {
							if(data.status == "200") {
								spop({
									template: '<h4 class="spop-title">登录成功</h4>即将3秒后前往首页',
									position: 'top-center',
									style: 'success',
									autoclose: 3000,
									onOpen: function() {
										var second = 2;
										var showPop = setInterval(function() {
											if(second == 0) {
												clearInterval(showPop);
											}
											$('.spop-body').html('<h4 class="spop-title">登录成功</h4>即将于' + second + '秒后前往首页');
											second--;
										}, 1000);
									},
									onClose: function() {
										window.location.href = "<%=path%>/home/toHomePage.action";
										return false;
									}
								});
							} else if(data.status == "445") {
								$("#login-btn").attr("disabled",false);
								$("#login-btn").val("登录");
								$.pt({
									target: $("#login-password"),
									position: 'r',
									align: 't',
									width: 'auto',
									height: 'auto',
									content: "密码不正确请重新输入"
								});
								goto_login();
								return false;
							} else if(data.status == "400") {
								$("#login-btn").attr("disabled",false);
								$("#login-btn").val("登录");
								$.pt({
									target: $("#login-usercode"),
									position: 'r',
									autoClose: false,
									align: 't',
									width: 'auto',
									height: 'auto',
									content: "一卡通账号不存在或者未激活请先注册"
								});
								goto_login();
								return false;
							} else{
								$("#login-btn").attr("disabled",false);
								$("#login-btn").val("登录");
								$.pt({
									target: $("#login-usercode"),
									position: 'r',
									align: 't',
									autoClose: false,
									width: 'auto',
									height: 'auto',
									content: data.message
								});
								goto_login();
								return false;
							}

						},
						error: function() {
							$.pt({
								target: $("#login-usercode"),
								position: 'r',
								align: 't',
								width: 'auto',
								autoClose: false,
								height: 'auto',
								content: "一卡通账号和密码不符请从新输入"
							});
							goto_login();
							return false;
						}
					});
				}
			}

			//注册

			function register() {
					var username = $("#register-username").val(),
					usercode = $("#register-usercode").val(),
					password = $("#register-password").val(),
					phonenumber = $("#register-phone").val(),
					code = $("#register-code").val(),
					flag = false,
					validatecode = null;
				var regUsercode = new RegExp("^[0-9_]{10,10}$");
				var regPassword = new RegExp("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$");
				var regPhone = new RegExp("^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$");
				//判断用户名密码是否为空
	
				if(usercode == "") {
					$.pt({
						target: $("#register-usercode"),
						position: 'r',
						autoClose: false,
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "一卡通账号不能为空"
					});
					flag = true;
				}else if(!regUsercode.test(usercode)) {
					$.pt({
						target: $("#register-usercode"),
						position: 'r',
						autoClose: false,
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "请输入正确的10位一卡通账号"
					});
					flag = true;
				}  else if(username == "") {
					$.pt({
						target: $("#register-username"),
						position: 'r',
						autoClose: false,
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "用户名不能为空"
					});
					flag = true;
				}  else if(phonenumber == "") {
					$.pt({
						target: $("#register-phone"),
						position: 'r',
						autoClose: false,
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "手机号码不能为空"
					});
					flag = true;
				}else if(!regPhone.test(phonenumber)) {
					$.pt({
						target: $("#register-phone"),
						position: 'r',
						autoClose: false,
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "请输入正确的手机号码"
					});
					flag = true;
				} else if(code == "") {
					$.pt({
						target: $("#register-code"),
						position: 'r',
						autoClose: false,
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "验证码不能为空"
					});
					flag = true;
				}else if(password == "") {
					$.pt({
						target: $("#register-password"),
						position: 'r',
						autoClose: false,
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "密码不能为空"
					});
					flag = true;
				} else if(!regPassword.test(password)) {
					$.pt({
						target: $("#register-password"),
						position: 'r',
						autoClose: false,
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "请输入6-16位由数字及字母组成的密码"
					});
					flag = true;
				}
				if(flag) {
					return false;
				} else { //注册
					$.ajax({
						type: "post",
						url: "<%=path%>/register/register.action",
						data: {
							"username": username,
							"password": password,
							"usercode": usercode,
							"phonenumber": phonenumber,
							"code": code
						},
						dataType: 'json',
						success: function(data) {
							console.log(data);
							if(data.status == "200") {
								spop({
									template: '<h4 class="spop-title">注册成功</h4>即将3秒后前往登录界面',
									position: 'top-center',
									style: 'success',
									autoclose: 3000,
									onOpen: function() {
										var second = 2;
										var showPop = setInterval(function() {
											if(second == 0) {
												clearInterval(showPop);
											}
											$('.spop-body').html('<h4 class="spop-title">注册成功</h4>即将于' + second + '秒后登录界面');
											second--;
										}, 1000);
									},
									onClose: function() {
										goto_login();
										return false;
									}
								});
							} else if(data.status == "10003") {
								$.pt({
									target: $("#register-usercode"),
									position: 'r',
									autoClose: false,
									align: 't',
									width: 'auto',
									height: 'auto',
									content: "该一卡通账号已被注册，请重新输入或者直接登录"
								});
								goto_register();
								return false;
							} else if(data.status == "400") {
								$.pt({
									target: $("#register-code"),
									position: 'r',
									align: 't',
									autoClose: false,
									width: 'auto',
									height: 'auto',
									content: "验证码输入错误请重新输入"
								});
								$("#register-code").val("");
								return false;
							}else if(data.status == "10008") {
								$.pt({
									target: $("#register-code"),
									position: 'r',
									align: 't',
									autoClose: false,
									width: 'auto',
									height: 'auto',
									content: "验证码已失效请重新获取"
								});
								$("#register-code").val("");
								return false;
							}else{
								$.pt({
									target: $("#register-code"),
									position: 'r',
									autoClose: false,
									align: 't',
									width: 'auto',
									height: 'auto',
									content: data.message
								});
								goto_register();
								return false;
							}
						},
						error: function() {
							$.pt({
								target: $("#register-usercode"),
								position: 'r',
								align: 't',
								autoClose: false,
								width: 'auto',
								height: 'auto',
								content: "注册失败"
							});
							goto_register();
							return false;
						}
					});
				}
			}

			
			
			//重置密码
			function forget() {
				var usercode = $("#forget-usercode").val(),
					phonenumber = $("#forget-phone").val(),
					phonenumberG = $("#forget-phoneG").val(),
					code = $("#forget-code").val(),
					password = $("#forget-password").val(),
					repassword = $("#forget-repassword").val(),
					flag = false,
					validatecode = null;
				var regUsercode = new RegExp("^[0-9_]{10,10}$");
				var regPassword = new RegExp("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$");
				//判断用户名密码是否为空
				if(usercode == "") {
					$.pt({
						target: $("#forget-usercode"),
						position: 'r',
						autoClose: false,
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "一卡通账号不能为空"
					});
					flag = true;
				}else if(!regUsercode.test(usercode)) {
					$.pt({
						target: $("#forget-usercode"),
						position: 'r',
						align: 't',
						autoClose: false,
						width: 'auto',
						height: 'auto',
						content: "请输入正确的10位一卡通账号"
					});
					flag = true;
				}else if(phonenumber == "") {
					$.pt({
						target: $("#forget-phone"),
						position: 'r',
						autoClose: false,
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "手机号码不能为空"
					});
					flag = true;
				}else if(phonenumber != phonenumberG) {
					$.pt({
						target: $("#forget-phone"),
						position: 'r',
						autoClose: false,
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "请输入正确手机号"
					});
					flag = true;
				}else if(code == "") {
					$.pt({
						target: $("#forget-code"),
						position: 'r',
						align: 't',
						autoClose: false,
						width: 'auto',
						height: 'auto',
						content: "验证码不能为空"
					});
					flag = true;
				}else if(password == "") {
					$.pt({
						target: $("#forget-password"),
						position: 'r',
						autoClose: false,
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "密码不能为空"
					});
					flag = true;
				}else if(!regPassword.test(password)) {
					$.pt({
						target: $("#forget-password"),
						position: 'r',
						autoClose: false,
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "请输入6-16位由数字及字母组成的密码"
					});
					flag = true;
				}else if(password != repassword) {
					$.pt({
						target: $("#forget-repassword"),
						position: 'r',
						autoClose: false,
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "两次输入的密码不一致"
					});
					flag = true;
				} 
				
				//检查一卡通是否存在
				//调后台方法

				//检查注册码是否正确
				/* if(code != '11111111') {
					$.pt({
						target: $("#forget-code"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "注册码不正确"
					});
					flag = true;
				} */

				if(flag) {
					return false;
				} else { //重置密码
					$.ajax({
						type: "post",
						url: "<%=path%>/forget/forget.action",
						data: {
							"usercode": usercode,
							"phonenumber": phonenumber,
							"code": code,
							"password": password							
						},
						dataType: 'json',
						success: function(data) {
							console.log(data);
							if(data.status == "200") { 
								spop({
									template: '<h4 class="spop-title">重置密码成功</h4>即将于3秒后返回登录',
									position: 'top-center',
									style: 'success',
									autoclose: 3000,
									onOpen: function() {
										var second = 2;
										var showPop = setInterval(function() {
											if(second == 0) {
												clearInterval(showPop);
											}
											$('.spop-body').html('<h4 class="spop-title">重置密码成功</h4>即将于' + second + '秒后返回登录');
											second--;
										}, 1000);
									},
									onClose: function() {
										goto_login();
									}
								});
								return false;
							}else if(data.status == "400") {
								$.pt({
									target: $("#forget-code"),
									position: 'r',
									align: 't',
									autoClose: false,
									width: 'auto',
									height: 'auto',
									content: "验证码输入错误请重新输入"
								});
								$("#forget-code").val("");
								return false;
							}else if(data.status == "10008") {
								$.pt({
									target: $("#forget-code"),
									position: 'r',
									align: 't',
									autoClose: false,
									width: 'auto',
									height: 'auto',
									content: "验证码已失效请重新获取"
								});
								$("#forget-code").val("");
								return false;
							} else {
								$.pt({
									target: $("#forget-usercode"),
									position: 'r',
									autoClose: false,
									align: 't',
									width: 'auto',
									height: 'auto',
									content: data.message
								});
								goto_forget();
								return false;
							} 

						},
						error: function() {
							$.pt({
								target: $("#forget-usercode"),
								position: 'r',
								autoClose: false,
								align: 't',
								width: 'auto',
								height: 'auto',
								content: "修改密码失败"
							});
							goto_forget();
							return false;
						}
					});
				}
				
						
			}
		</script>
		<style type="text/css">
			html {
				width: 100%;
				height: 100%;
			}
			
			body {
				background-repeat: no-repeat;
				background-position: center center #2D0F0F;
				background-color: #00BDDC;
				background-image: url(<%=path%>/images/snow.jpg);
				background-size: 100% 100%;
			}
			
			.snow-container {
				position: fixed;
				top: 0;
				left: 0;
				width: 100%;
				height: 100%;
				pointer-events: none;
				z-index: 100001;
			}
		</style>
	</head>

	<body>
		<!-- 雪花背景 -->
		<div class="snow-container"></div>
		<!-- 登录控件 -->
		<div id="login">
			<input id="tab-1" type="radio" name="tab" class="sign-in hidden" checked />
			<input id="tab-2" type="radio" name="tab" class="sign-up hidden" />
			<input id="tab-3" type="radio" name="tab" class="sign-out hidden" />
			<div class="wrapper">
			
			
			
				<!-- 登录页面 -->
				<div class="login sign-in-htm">
					<form class="container offset1 loginform">
						<!-- 猫头鹰控件 -->
						<div id="owl-login" class="login-owl">
							<div class="hand"></div>
							<div class="hand hand-r"></div>
							<div class="arms">
								<div class="arm"></div>
								<div class="arm arm-r"></div>
							</div>
						</div>
						<div class="pad input-container">
							<section class="content">
								<span class="input input--hideo"> 
									<input class="input__field input__field--hideo" type="text" id="login-usercode" autocomplete="off" placeholder="请输入一卡通账号" tabindex="1" maxlength="10" onkeyup="show_ykt1(this.value)"/> 
									<script type="text/javascript">								
									    var reg = new RegExp("^[0-9_]{10}$");
										function show_ykt1(str){
											if(str == ""){
												$.pt({
													target: $("#login-usercode"),
													position: 'r',
													autoClose: false,
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "一卡通账号不能为空" 
												});
												return;
											}else if(!reg.test(str)){
												$.pt({
													target: $("#login-usercode"),
													position: 'r',
													autoClose: false,
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "请输入正确的10位一卡通账号" 
												});
												return;
											}else{
												var usercode = $("#login-usercode").val()
												$.ajax({
													type: "post",
													url: "<%=path%>/forget/getUser.action",
													data: {
														"usercode": usercode,
													},
													dataType: 'json',
													success: function(data) {
														console.log(data);
														if(data.status == "200") {
															$.pt({
																target: $("#login-usercode"),
																position: 'r',
																align: 't',
																width: 'auto',
																height: 'auto',
																content: '获取数据成功，可以登录'
															});
															return false;
														} else if(data.status == "10007"){
															$.pt({
																target: $("#login-usercode"),
																position: 'r',
																align: 't',
																autoClose: false,
																width: 'auto',
																height: 'auto',
																content: data.message
															});
															return false;
														}else if(data.status == "10005"){
															$.pt({
																target: $("#login-usercode"),
																position: 'r',
																align: 't',
																width: 'auto',
																autoClose: false,
																height: 'auto',
																content: data.message
															});
															return false;
														}else {
																$.pt({
																	target: $("#login-usercode"),
																	position: 'r',
																	align: 't',
																	width: 'auto',
																	autoClose: false,
																	height: 'auto',
																	content: data.message
																});
																return false;
															}
													},
													error: function() {
														$.pt({
															target: $("#login-usercode"),
															position: 'r',
															align: 't',
															width: 'auto',
															autoClose: false,
															height: 'auto',
															content: "查询失败"
														});
														return false;
													}
												});
											}												
										}
									</script>
									<label class="input__label input__label--hideo" for="login-usercode">
										<i class="fa fa-fw fa-user icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
								</label>
								</span>
								<span class="input input--hideo"> 
									<input class="input__field input__field--hideo" type="password" id="login-password" placeholder="请输入密码" tabindex="2" maxlength="32" /> 
									<label class="input__label input__label--hideo" for="login-password">
										<i class="fa fa-fw fa-lock icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
								</label>
								</span>
							</section>
						</div>
						<div class="form-actions">
							<a tabindex="4" class="btn pull-left btn-link text-muted" onClick="goto_forget()">忘记密码?</a>
							<a tabindex="5" class="btn btn-link text-muted" onClick="goto_register()">注册</a>
							<input class="btn btn-primary" id="login-btn" type="button" tabindex="3" onClick="login()" value="登录" style="color: white;" />
						</div>
					</form>
				</div>
				
				
				
				<!-- 忘记密码页面 -->
				<div class="login sign-out-htm">
					<form action="#" method="post" class="container offset1 loginform">
						<!-- 猫头鹰控件 -->
						<div id="owl-login" class="forget-owl">
							<div class="hand"></div>
							<div class="hand hand-r"></div>
							<div class="arms">
								<div class="arm"></div>
								<div class="arm arm-r"></div>
							</div>
						</div>
						<div class="pad input-container">
							<section class="content">
								<span class="input input--hideo"> 
									<input class="input__field input__field--hideo" type="text" id="forget-usercode" autocomplete="off" placeholder="请输入一卡通账号" onkeyup="show_yhm2(this.value)"/>
									<script type="text/javascript">
									    var reg = new RegExp("^[0-9_]{10}$");
										function show_yhm2(str){
											if(str == ""){
												$.pt({
													target: $("#forget-usercode"),
													position: 'r',
													align: 't',
													autoClose: false,
													width: 'auto',
													height: 'auto',
													content: "一卡通账号不能为空" 
												});
												return;
											}else if(!reg.test(str)){
												$.pt({
													target: $("#forget-usercode"),
													position: 'r',
													align: 't',
													autoClose: false,
													width: 'auto',
													height: 'auto',
													content: "请输入正确的10位一卡通账号" 
												});
												return;
											}else{
												var usercode = $("#forget-usercode").val();
												$.ajax({
													type: "post",
													url: "<%=path%>/forget/getUser.action",
													data: {
														"usercode": usercode,
													},
													dataType: 'json',
													success: function(data) {
														console.log(data);
														if(data.status == "200") {
															show_forget(data.obj);
															$.pt({
																target: $("#forget-usercode"),
																position: 'r',
																align: 't',
																width: 'auto',
																height: 'auto',
																content: '获取数据成功，可以修改密码'
															});
															return false;
														} else if(data.status == "10007"){
															hide_forget();
															$.pt({
																target: $("#register-usercode"),
																position: 'r',
																autoClose: false,
																align: 't',
																width: 'auto',
																height: 'auto',
																content: data.message
															});
															return false;
														}else if(data.status == "10005"){
															hide_forget();
															$.pt({
																target: $("#register-usercode"),
																position: 'r',
																autoClose: false,
																align: 't',
																width: 'auto',
																height: 'auto',
																content: data.message
															});
								
															return false;
														}else {
															hide_forget();
																$.pt({
																	target: $("#register-usercode"),
																	position: 'r',
																	autoClose: false,
																	align: 't',
																	width: 'auto',
																	height: 'auto',
																	content: data.message
																});
																return false;
															}
													},
													error: function() {														
														hide_Forget();
														$.pt({
															target: $("#register-usercode"),
															position: 'r',
															align: 't',
															autoClose: false,
															width: 'auto',
															height: 'auto',
															content: "查询失败"
														});
														return false;
													}
												});
											}												
										}
									</script>
									<label class="input__label input__label--hideo" for="forget-usercode"> 
										<i class="fa fa-fw fa-user icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
									</label>
								</span>
								<span class="showForget input input--hideo" style="display: none;"> 
									<input class="input__field input__field--hideo" type="text" id="forget-phoneR" disabled="disabled"/> 
									<label class="input__label input__label--hideo" for="forget-phoneR"> 
										<i class="fa fa-fw fa-mobile-phone icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
								 	</label>
								</span> 
								<span class="input input--hideo" style="display: none;"> 
									<input class="input__field input__field--hideo" type="text" id="forget-phoneG" disabled="disabled"/> 
									<label class="input__label input__label--hideo" for="forget-phoneG"> 
										<i class="fa fa-fw fa-mobile-phone icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
								 	</label>
								</span> 
								<span class="input input--hideo"> 
									<input class="input__field input__field--hideo" type="text" id="forget-phone" autocomplete="off" placeholder="请输入完整手机号" maxlength="15" onkeyup="show_sjh2(this.value)" /> 
									<script type="text/javascript">
										function show_sjh2(str){
											var reg = new RegExp("^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$");
											if(str == ""){
												$.pt({
													target: $("#forget-phone"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "手机号码不能为空" 
												});
												return;
											}else if(!reg.test(str)){
												$.pt({
													target: $("#forget-phone"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "请输入正确的手机号码" 
												});
												return;
											}									
										}
									</script> 
									<label class="input__label input__label--hideo" for="forget-phone">
										<i class="fa fa-fw fa-mobile-phone icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
									</label>
									
								</span>
								<span class="input input--hideo"> 
									<input class="input__field input__field--hideo" type="text" id="forget-code" autocomplete="off" placeholder="请输入验证码" maxlength="6" onkeyup="show_yzm4(this.value)"/> 
									<script type="text/javascript">
										function show_yzm4(str){
											var reg = new RegExp("^[0-9_]{6}$");
											if(str == ""){
												$.pt({
													target: $("#forget-code"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "验证码不能为空" 
												});
												return;
											}else if(!reg.test(str)){
												$.pt({
													target: $("#forget-code"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "请输入6位验证码" 
												});
												return;
											}									
										}
									</script> 
									<label class="input__label input__label--hideo" for="forget-code">
										<i class="fa fa-fw fa-send-o icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
								   	</label>
								   	<input type="button" id="btn1" class="input__field input__field--madoka hqyzm" style="position: absolute; right: 0px; top: 0px; width: 30%; height: 97%; border: 2px solid #B0E0E6; text-align: center;" value="短信验证码" />
									<script type="text/javascript">
										//发送验证码
										var wait = 60;
		
										function time(o) {
											if(wait == 0) {
												o.removeAttribute("disabled");
												o.value = "短信验证码";
												wait = 60;
											} else {
												o.setAttribute("disabled", true);
												o.value = wait + "秒";
												wait--;
												setTimeout(function() {
													time(o)
												}, 1000)
											}
										}
										$("#btn1").click(function() {
											var usercode = $("#forget-usercode").val(),
												phonenumber = $("#forget-phone").val(),
												phonenumberR = $("#forget-phoneG").val(),
												flag = false,
												validatecode = null;
											var regUsercode = new RegExp("^[0-9_]{10,10}$");
											var regPassword = new RegExp("^[a-zA-Z0-9_]{6,15}$");
											var regExp = new RegExp("^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$");
											//判断用户名密码是否为空

											if(usercode == "") {
												$.pt({
													target: $("#forget-usercode"),
													position: 'r',
													autoClose: false,
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "一卡通账号不能为空"
												});
												flag = true;
											} else if(!regUsercode.test(usercode)) {
												$.pt({
													target: $("#forget-usercode"),
													position: 'r',
													autoClose: false,
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "请输入正确的10位一卡通账号"
												});
												flag = true;
											} else if(phonenumber == "") {
												$.pt({
													target: $("#forget-phone"),
													position: 'r',
													autoClose: false,
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "电话号码不能为空"
												});
												flag = true;
											} else if(!regExp.test(phonenumber) || ( phonenumber != phonenumberR)) {
												$.pt({
													target: $("#forget-phone"),
													position: 'r',
													autoClose: false,
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "请输入正确的手机号码"
												});
												flag = true;
											}
											if(flag) {
												return false;
											} else {
												time(this);
												$.ajax({
													type: "post",
													url: "<%=path%>/base/getVerificationCode.action",
													data: {
														"usercode" : usercode,
														"phonenumber": phonenumber
													},
													dataType: 'json',
													success: function(data) {
														console.log(data);
														if(data.status == "10006") {
															$.pt({
																target: $("#forget-code"),
																position: 'r',
																align: 't',
																width: 'auto',
																height: 'auto',
																content: '验证码发送成功'
															});
														} else if(data.status == "10005"){
															$.pt({
																target: $("#forget-code"),
																position: 'r',
																autoClose: false,
																align: 't',
																width: 'auto',
																height: 'auto',
																content: '验证码发送失败,该账号不存在系统中'
															});
														}else{
															$.pt({
																target: $("#forget-code"),
																position: 'r',
																autoClose: false,
																align: 't',
																width: 'auto',
																height: 'auto',
																content: '验证码发送失败'
															});
														}
	
													},
													error: function() {
														$.pt({
															target: $("#forget-code"),
															position: 'r',
															autoClose: false,
															align: 't',
															width: 'auto',
															height: 'auto',
															content: '服务器异常'
														});
														return false;
													}
												});
											}
										})
									</script> 
								</span>
								<span class="input input--hideo">
									<input class="input__field input__field--hideo" type="password" id="forget-password" placeholder="请输入密码" /> 
									<label class="input__label input__label--hideo" for="forget-password">
										<i class="fa fa-fw fa-lock icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
									</label>
								</span>
								<span class="input input--hideo"> 
									<input class="input__field input__field--hideo" type="password" id="forget-repassword" placeholder="请确认密码" maxlength="16" />
									<label class="input__label input__label--hideo" for="register-repassword"> 
										<i class="fa fa-fw fa-lock icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
									</label>
								</span>
							</section>
						</div>
						<div class="form-actions">
							<a class="btn pull-left btn-link text-muted" onClick="goto_login()">返回登录</a>
							<input class="btn btn-primary" type="button" onClick="forget()" value="重置密码" style="color: white;" />
						</div>
					</form>
				</div>
				
				
				
				<!-- 注册页面 -->
				<div class="login sign-up-htm">
					<form action="#" method="post" class="container offset1 loginform">
						<!-- 猫头鹰控件 -->
						<div id="owl-login" class="register-owl">
							<div class="hand"></div>
							<div class="hand hand-r"></div>
							<div class="arms">
								<div class="arm"></div>
								<div class="arm arm-r"></div>
							</div>
						</div>
						<div class="pad input-container">
							<section class="content">
							    <span class="input input--hideo"> 
									<input class="input__field input__field--hideo" type="text" id="register-usercode" autocomplete="off" placeholder="请输入一卡通账号" maxlength="10" onkeyup="show_ykt(this.value)"/> 
									<script type="text/javascript">
										function show_ykt(str){
											var reg = new RegExp("^[0-9_]{10}$");
											if(str == ""){
												$.pt({
													target: $("#register-usercode"),
													position: 'r',
													autoClose: false,
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "一卡通账号不能为空" 
												});
												return;
											}else if(!reg.test(str)){
												$.pt({
													target: $("#register-usercode"),
													position: 'r',
													autoClose: false,
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "请输入正确的10位一卡通账号" 
												});
												return;
											}else{
												var usercode = $("#register-usercode").val()
												$.ajax({
													type: "post",
													url: "<%=path%>/register/getUser.action",
													data: {
														"usercode": usercode,
													},
													dataType: 'json',
													success: function(data) {
														console.log(data);
														if(data.status == "200") {
															show_user(data.obj);
															$.pt({
																target: $("#register-usercode"),
																position: 'r',
																align: 't',
																width: 'auto',
																height: 'auto',
																content: '获取数据成功，可以注册'
															});
															return false;
														} else if(data.status == "10003"){
															hide_user();
															$.pt({
																target: $("#register-usercode"),
																position: 'r',
																autoClose: false,
																align: 't',
																width: 'auto',
																height: 'auto',
																content: data.message
															});
															return false;
														}else if(data.status == "10005"){
															hide_user();
															$.pt({
																target: $("#register-usercode"),
																position: 'r',
																autoClose: false,
																align: 't',
																width: 'auto',
																height: 'auto',
																content: data.message
															});
															return false;
														}else {
															hide_user();
																$.pt({
																	target: $("#register-usercode"),
																	position: 'r',
																	autoClose: false,
																	align: 't',
																	width: 'auto',
																	height: 'auto',
																	content: data.message
																});
																return false;
															}
													},
													error: function() {
														hide_user();
														$.pt({
															target: $("#register-usercode"),
															position: 'r',
															autoClose: false,
															align: 't',
															width: 'auto',
															height: 'auto',
															content: "查询失败"
														});
														return false;
													}
												});
											}									
										}
									</script> 
									<label class="input__label input__label--hideo" for="register-usercode">
										<i class="fa fa-fw fa-user icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
									</label>
								</span>
								<span class="showUser input input--hideo" style="display: none;" > 
									<input class="input__field input__field--hideo" type="text" id="register-campus" disabled="disabled"/> 
									<label class="input__label input__label--hideo" for="register-campus"> 
										<i class="fa fa-fw fa-university icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
								 	</label>
								</span> 
								<span class="showUser input input--hideo" style="display: none;"> 
									<input class="input__field input__field--hideo" type="text" id="register-degree" disabled="disabled"/> 
									<label class="input__label input__label--hideo" for="register-degree"> 
										<i class="fa fa-fw fa-credit-card icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
								 	</label>
								</span> 
								<span class="input input--hideo"> 
									<input class="input__field input__field--hideo" type="text" id="register-username" autocomplete="off" placeholder="请输入用户名" maxlength="15" onkeyup="show_yhm(this.value)" /> 
									<script type="text/javascript">
										function show_yhm(str){
											//var reg = /^[0-9]{10}$/;
											if(str ==""){
												$.pt({
													target: $("#register-username"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "用户名不能为空" 
												});
												return;
											}									
										}
									</script> 
									<label class="input__label input__label--hideo" for="register-username"> 
										<i class="fa fa-fw fa-github-alt icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
								 	</label>
								</span>
							    	<!-- <span class="input input--hideo "> 
									<select class="input__label input__field--hideo input" style="border: 0; background: transparent;">
											<option value="" selected>Basic select</option>
													<optgroup label="Alaskan/Hawaiian Time Zone">
															<option value="AK">Alaska</option>
															<option value="HI">Hawaii</option>
													</optgroup>
													<optgroup label="Pacific Time Zone">
															<option value="CA">California</option>
															<option value="NV">Nevada</option>
															<option value="WA">Washington</option>
													</optgroup>
													<optgroup label="Mountain Time Zone">
															<option value="AZ">Arizona</option>
															<option value="CO">Colorado</option>
															<option value="WY">Wyoming</option>
													</optgroup>
									</select>
									<label class="input__label input__label--hideo" for="register-username"> 
										<i class="fa fa-fw fa-user icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
								 	</label>
								</span>   -->
<!-- 								<span class="input input--hideo"> 
									<input class="input__field input__field--hideo" type="password" id="register-repassword" placeholder="请确认密码" maxlength="16" value="123456"/>
									<label class="input__label input__label--hideo" for="register-repassword"> 
										<i class="fa fa-fw fa-lock icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
									</label>
								</span>  -->
								<span class="input input--hideo"> 
									<input class="input__field input__field--hideo" type="text" id="register-phone" autocomplete="off" placeholder="请输入手机号" maxlength="15" onkeyup="show_sjh(this.value)" /> 
									<script type="text/javascript">
										function show_sjh(str){
											var reg = new RegExp("^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$");
											if(str == ""){
												$.pt({
													target: $("#register-phone"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "手机号码不能为空" 
												});
												return;
											}else if(!reg.test(str)){
												$.pt({
													target: $("#register-phone"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "请输入正确的手机号码" 
												});
												return;
											}									
										}
									</script> 
									<label class="input__label input__label--hideo" for="register-phone">
										<i class="fa fa-fw fa-mobile-phone icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
									</label>
								</span> 
								<span class="input input--hideo"> 
									<input class="input__field input__field--hideo" type="text" id="register-code" autocomplete="off" placeholder="请输入验证码" maxlength="6" onkeyup="show_yzm3(this.value)"/> 
									<script type="text/javascript">
										function show_yzm3(str){
											var reg = new RegExp("^[0-9_]{6}$");
											if(str == ""){
												$.pt({
													target: $("#register-code"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "验证码不能为空" 
												});
												return;
											}else if(!reg.test(str)){
												$.pt({
													target: $("#register-code"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "请输入6位验证码" 
												});
												return;
											}							
										}
									</script> 
									<label class="input__label input__label--hideo" for="register-code">
										<i class="fa fa-fw fa-send-o icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
								   	</label> 
									<input type="button" id="btn" class="input__field input__field--madoka hqyzm" style="position: absolute; right: 0px; top: 0px; width: 30%; height: 97%; border: 2px solid #B0E0E6; text-align: center;" value="短信验证码" />
									<script type="text/javascript">
										//发送验证码
										var wait = 60;
		
										function time(o) {
											if(wait == 0) {
												o.removeAttribute("disabled");
												o.value = "短信验证码";
												wait = 60;
											} else {
												o.setAttribute("disabled", true);
												o.value = wait + "秒";
												wait--;
												setTimeout(function() {
													time(o)
												}, 1000)
											}
										}
										$("#btn").click(function() {
											var username = $("#register-username").val(),
												usercode = $("#register-usercode").val(),
												//password = $("#register-password").val(),
												//repassword = $("#register-repassword").val(),
												phonenumber = $("#register-phone").val(),
												code = $("#register-code").val(),
												flag = false,
												validatecode = null;
											var regUsercode = new RegExp("^[0-9_]{10,10}$");
											var regPassword = new RegExp("^[a-zA-Z0-9_]{6,15}$");
											var regExp = new RegExp("^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$");
											//判断用户名密码是否为空

											if(usercode == "") {
												$.pt({
													target: $("#register-usercode"),
													position: 'r',
													autoClose: false,
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "一卡通账号不能为空"
												});
												flag = true;
											}else if(username == "") {
												$.pt({
													target: $("#register-username"),
													position: 'r',
													align: 't',
													autoClose: false,
													width: 'auto',
													height: 'auto',
													content: "用户名不能为空"
												});
												flag = true;
											} else if(!regUsercode.test(usercode)) {
												$.pt({
													target: $("#register-usercode"),
													position: 'r',
													align: 't',
													autoClose: false,
													width: 'auto',
													height: 'auto',
													content: "请输入正确的10位一卡通账号"
												});
												flag = true;
											} /*else if(!regPassword.test(password)) {
												$.pt({
													target: $("#register-password"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "请输入6-15位账户密码"
													});
												flag = true;
											}  else if(password != repassword) {
												$.pt({
													target: $("#register-repassword"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "两次输入的密码不一致"
												});
												flag = true;
											}  else if(password == "") {
												$.pt({
													target: $("#register-password"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "密码不能为空"
												});
												flag = true;
											}*/ else if(phonenumber == "") {
												$.pt({
													target: $("#register-phone"),
													position: 'r',
													autoClose: false,
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "电话号码不能为空"
												});
												flag = true;
											} else if(!regExp.test(phonenumber)) {
												$.pt({
													target: $("#register-phone"),
													position: 'r',
													autoClose: false,
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "请输入正确的手机号码"
												});
												flag = true;
											}
											if(flag) {
												return false;
											} else {
												time(this);
												$.ajax({
													type: "post",
													url: "<%=path%>/base/getVerificationCode.action",
													data: {
														"usercode" : usercode,
														"phonenumber": phonenumber
													},
													dataType: 'json',
													success: function(data) {
														console.log(data);
														if(data.status == "10006") {
															$.pt({
																target: $("#register-code"),
																position: 'r',
																align: 't',
																width: 'auto',
																height: 'auto',
																content: '验证码获取成功'
															});
														}else if(data.status == "10005"){
															$.pt({
																target: $("#register-code"),
																position: 'r',
																align: 't',
																width: 'auto',
																height: 'auto',
																content: '验证码发送失败,该账号不存在系统中'
															});
														}else{
															$.pt({
																target: $("#register-code"),
																position: 'r',
																align: 't',
																autoClose: false,
																width: 'auto',
																height: 'auto',
																content: data.message
															});
														}											
	
													},
													error: function() {
														$.pt({
															target: $("#register-code"),
															position: 'r',
															autoClose: false,
															align: 't',
															width: 'auto',
															height: 'auto',
															content: '服务器异常'
														});
														return false;
													}
												});
											}
										})
									</script>
								</span>
								<span class="input input--hideo"> 
									<input class="input__field input__field--hideo" type="password" id="register-password" placeholder="请输入密码" maxlength="16" onkeyup="show_mm(this.value)" /> 
									<script type="text/javascript">
										function show_mm(str){
											var reg = new RegExp("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$");
											if(str == ""){
												$.pt({
													target: $("#register-password"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "密码不能为空" 
												});
												return;
											}else if(!reg.test(str)){
												$.pt({
													target: $("#register-password"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "请输入6-16位由数字及字母组成的密码" 
												});
												return;
											}									
										}
									</script> 
									<label class="input__label input__label--hideo" for="register-password">
										<i class="fa fa-fw fa-lock icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
									</label>
								</span> 
							</section>
						</div>
						<div class="form-actions">
							<a class="btn pull-left btn-link text-muted" onClick="goto_login()">返回登录</a> 
							<input class="btn btn-primary" type="button" onClick="register()" value="注册" style="color: white;" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>