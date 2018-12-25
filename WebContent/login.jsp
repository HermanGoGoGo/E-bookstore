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
		<title>登录66666</title>
		<link rel="stylesheet" href="<%=path%>/css/normalize.css">
		<link rel="stylesheet" href="<%=path%>/css/login.css">
		<link rel="stylesheet" href="<%=path%>/css/sign-up-login.css">
		<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="<%=path%>/css/inputEffect.css" />
		<link rel="stylesheet" href="<%=path%>/css/tooltips.css" />
		<link rel="stylesheet" href="<%=path%>/css/spop.min.css" />

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
			});

			function goto_register() {
				$("#register-username").val("");
				$("#register-password").val("");
				$("#register-repassword").val("");
				$("#register-code").val("");
				$("#register-phone").val("");
				$("#register-usercode").val("");
				$("#tab-2").prop("checked", true);
			}

			function goto_login() {
				//$("#login-username").val("");
				$("#login-password").val("");
				$("#tab-1").prop("checked", true);
			}

			function goto_forget() {
				$("#forget-username").val("");
				$("#forget-password").val("");
				$("#forget-code").val("");
				$("#tab-3").prop("checked", true);
			}

			function login() { //登录
				var username = $("#login-username").val(),
					password = $("#login-password").val(),
					validatecode = null,
					flag = false;
				//判断用户名密码是否为空
				if(username == "") {
					$.pt({
						target: $("#login-username"),
						position: 'r',
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
						target: $("#login-username"),
						position: 'r',
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
					$.ajax({
						type: "post",
						url: "<%=path%>/toHome.action",
						data: {
							"username": username,
							"password": password
						},
						dataType: 'json',
						success: function(data) {
							if(data.value == "1") {
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
										window.location.href = "<%=path%>/toHomePage.action";
										return false;
									}
								});
							} else if(data.value == "3") {
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
							} else if(data.value == "2") {
								$.pt({
									target: $("#login-username"),
									position: 'r',
									align: 't',
									width: 'auto',
									height: 'auto',
									content: "一卡通账号不存在请重新输入"
								});
								goto_login();
								return false;
							}

						},
						error: function() {
							$.pt({
								target: $("#login-username"),
								position: 'r',
								align: 't',
								width: 'auto',
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
			function verification() {
				var username = $("#register-username").val(),
					usercode = $("#register-usercode").val(),
					password = $("#register-password").val(),
					repassword = $("#register-repassword").val(),
					phonenumber = $("#register-phone").val(),
					code = $("#register-code").val(),
					flag = false,
					validatecode = null;
				var regUsercode = new RegExp("^[0-9_]{10,10}$");
				var regPassword = new RegExp("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$");
				//判断用户名密码是否为空

				if(username == "") {
					$.pt({
						target: $("#register-username"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "用户名不能为空"
					});
					flag = true;
				} else if(usercode == "") {
					$.pt({
						target: $("#register-usercode"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "一卡通账号不能为空"
					});
					flag = true;
				} else if(!regUsercode.test(usercode)) {
					$.pt({
						target: $("#register-usercode"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "请输入正确的10位一卡通账号"
					});
					flag = true;
				} else if(password == "") {
					$.pt({
						target: $("#register-password"),
						position: 'r',
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
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "请输入6-16位由数字及字母组成的密码"
					});
					flag = true;
				} else if(password != repassword) {
					$.pt({
						target: $("#register-repassword"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "两次输入的密码不一致"
					});
					flag = true;
				} else if(password == "") {
					$.pt({
						target: $("#register-password"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "密码不能为空"
					});
					flag = true;
				} else if(phonenumber == "") {
					$.pt({
						target: $("#register-phone"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "电话号码不能为空"
					});
					flag = true;
				} else if(code == "") {
					$.pt({
						target: $("#register-code"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "验证码不能为空"
					});
					flag = true;
				}

				return flag;

			}

			function register() {
					var username = $("#register-username").val(),
					usercode = $("#register-usercode").val(),
					password = $("#register-password").val(),
					repassword = $("#register-repassword").val(),
					phonenumber = $("#register-phone").val(),
					code = $("#register-code").val(),
					flag = false,
					validatecode = null;
				var regUsercode = new RegExp("^[0-9_]{10,10}$");
				var regPassword = new RegExp("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$");
				//判断用户名密码是否为空
	
				if(username == "") {
					$.pt({
						target: $("#register-username"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "用户名不能为空"
					});
					flag = true;
				} else if(usercode == "") {
					$.pt({
						target: $("#register-usercode"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "一卡通账号不能为空"
					});
					flag = true;
				} else if(!regUsercode.test(usercode)) {
					$.pt({
						target: $("#register-usercode"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "请输入正确的10位一卡通账号"
					});
					flag = true;
				} else if(password == "") {
					$.pt({
						target: $("#register-password"),
						position: 'r',
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
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "请输入6-16位由数字及字母组成的密码"
					});
					flag = true;
				} else if(password != repassword) {
					$.pt({
						target: $("#register-repassword"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "两次输入的密码不一致"
					});
					flag = true;
				} else if(password == "") {
					$.pt({
						target: $("#register-password"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "密码不能为空"
					});
					flag = true;
				} else if(phonenumber == "") {
					$.pt({
						target: $("#register-phone"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "电话号码不能为空"
					});
					flag = true;
				} else if(code == "") {
					$.pt({
						target: $("#register-code"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "验证码不能为空"
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
							console.log(data.value);
							if(data.value == "1") {
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
							} else if(data.value == "2") {
								$.pt({
									target: $("#register-usercode"),
									position: 'r',
									align: 't',
									width: 'auto',
									height: 'auto',
									content: "该一卡通账号已被注册，请重新输入或者直接登录"
								});
								//goto_register();
								return false;
							} else if(data.value == "3") {
								$.pt({
									target: $("#register-usercode"),
									position: 'r',
									align: 't',
									width: 'auto',
									height: 'auto',
									content: "注册失败"
								});
								goto_register();
								return false;
							}else if(data.value == "4") {
								$.pt({
									target: $("#register-code"),
									position: 'r',
									align: 't',
									width: 'auto',
									height: 'auto',
									content: "验证码输入错误请重新输入"
								});
								//goto_register();
								return false;
							}

						},
						error: function() {
							$.pt({
								target: $("#register-usercode"),
								position: 'r',
								align: 't',
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
				var username = $("#forget-username").val(),
					password = $("#forget-password").val(),
					code = $("#forget-code").val(),
					flag = false,
					validatecode = null;
				//判断用户名密码是否为空
				if(username == "") {
					$.pt({
						target: $("#forget-username"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "用户名不能为空"
					});
					flag = true;
				}
				if(password == "") {
					$.pt({
						target: $("#forget-password"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "密码不能为空"
					});
					flag = true;
				}
				//用户名只能是15位以下的字母或数字
				var regExp = new RegExp("^[a-zA-Z0-9_]{1,15}$");
				if(!regExp.test(username)) {
					$.pt({
						target: $("#forget-username"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "用户名必须为15位以下的字母或数字"
					});
					flag = true;
				}
				//检查用户名是否存在
				//调后台方法

				//检查注册码是否正确
				if(code != '11111111') {
					$.pt({
						target: $("#forget-code"),
						position: 'r',
						align: 't',
						width: 'auto',
						height: 'auto',
						content: "注册码不正确"
					});
					flag = true;
				}

				if(flag) {
					return false;
				} else { //重置密码
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
				background-image: url(images/snow.jpg);
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
									<input class="input__field input__field--hideo" type="text" id="login-username" autocomplete="off" placeholder="请输入用户名" tabindex="1" maxlength="15" /> 
									<label class="input__label input__label--hideo" for="login-username">
										<i class="fa fa-fw fa-user icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
								</label>
								</span>
								<span class="input input--hideo"> 
									<input class="input__field input__field--hideo" type="password" id="login-password" placeholder="请输入密码" tabindex="2" maxlength="15" /> 
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
							<input class="btn btn-primary" type="button" tabindex="3" onClick="login()" value="登录" style="color: white;" />
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
									<input class="input__field input__field--hideo" type="text" id="forget-username" autocomplete="off" placeholder="请输入用户名" />
									<label class="input__label input__label--hideo" for="forget-username"> 
										<i class="fa fa-fw fa-user icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
								</label>
								</span>
								<span class="input input--hideo"> 
									<input class="input__field input__field--hideo" type="text" id="forget-code" autocomplete="off" placeholder="请输入注册码" /> 
									<label class="input__label input__label--hideo" for="forget-code">
									<i class="fa fa-fw fa-wifi icon icon--hideo"></i> 
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
								</span>
								<span class="input input--hideo">
									<input class="input__field input__field--hideo" type="password" id="forget-password" placeholder="请重置密码" /> 
									<label class="input__label input__label--hideo" for="forget-password">
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
									<input class="input__field input__field--hideo" type="text" id="register-username" utocomplete="off" placeholder="请输入用户名" maxlength="15" onkeyup="show_yhm(this.value)" /> 
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
										<i class="fa fa-fw fa-user icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
								 	</label>
								</span> 
								<span class="input input--hideo"> 
									<input class="input__field input__field--hideo" type="text" id="register-usercode" autocomplete="off" placeholder="请输入一卡通账号" maxlength="10" onkeyup="show_ykt(this.value)" /> 
									<script type="text/javascript">
										function show_ykt(str){
											var reg = new RegExp("^[0-9_]{10}$");
											if(str == ""){
												$.pt({
													target: $("#register-usercode"),
													position: 'r',
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
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "请输入正确的10位一卡通账号" 
												});
												return;
											}									
										}
									</script> 
									<label class="input__label input__label--hideo" for="register-usercode">
										<i class="fa fa-fw fa-user icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
									</label>
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
								<span class="input input--hideo"> 
									<input class="input__field input__field--hideo" type="password" id="register-repassword" placeholder="请确认密码" maxlength="16" />
									<label class="input__label input__label--hideo" for="register-repassword"> 
										<i class="fa fa-fw fa-lock icon icon--hideo"></i> 
										<span class="input__label-content input__label-content--hideo"></span>
									</label>
								</span> 
								<span class="input input--hideo"> 
									<input class="input__field input__field--hideo" type="text" id="register-phone" autocomplete="off" placeholder="请输入手机号" maxlength="15" onkeyup="show_sjh(this.value)"/> 
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
													content: "手机号不能为空" 
												});
												return;
											}else if(!reg.test(str)){
												$.pt({
													target: $("#register-phone"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "请输入正确的手机号" 
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
									<input class="input__field input__field--hideo" type="text" id="register-code" autocomplete="off" placeholder="请输入验证码" maxlength="6" /> 
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
												password = $("#register-password").val(),
												repassword = $("#register-repassword").val(),
												phonenumber = $("#register-phone").val(),
												code = $("#register-code").val(),
												flag = false,
												validatecode = null;
											var regUsercode = new RegExp("^[0-9_]{10,10}$");
											var regPassword = new RegExp("^[a-zA-Z0-9_]{6,15}$");
											var regExp = new RegExp("^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$");
											//判断用户名密码是否为空

											if(username == "") {
												$.pt({
													target: $("#register-username"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "用户名不能为空"
												});
												flag = true;
											} else if(usercode == "") {
												$.pt({
													target: $("#register-usercode"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "一卡通账号不能为空"
												});
												flag = true;
											} else if(!regUsercode.test(usercode)) {
												$.pt({
													target: $("#register-usercode"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "请输入正确的10位一卡通账号"
												});
												flag = true;
											} else if(password == "") {
												$.pt({
													target: $("#register-password"),
													position: 'r',
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
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "请输入6-15位账户密码"
													});
												flag = true;
											} else if(password != repassword) {
												$.pt({
													target: $("#register-repassword"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "两次输入的密码不一致"
												});
												flag = true;
											} else if(password == "") {
												$.pt({
													target: $("#register-password"),
													position: 'r',
													align: 't',
													width: 'auto',
													height: 'auto',
													content: "密码不能为空"
												});
												flag = true;
											} else if(phonenumber == "") {
												$.pt({
													target: $("#register-phone"),
													position: 'r',
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
													url: "<%=path%>/register/getVerificationCode.action",
													data: {
														"usercode" : usercode,
														"phonenumber": phonenumber
													},
													dataType: 'json',
													success: function(data) {
														//console.log(data);
														if(data.code == "000000") {
															$.pt({
																target: $("#register-code"),
																position: 'r',
																align: 't',
																width: 'auto',
																height: 'auto',
																content: "验证码发送成功"
															});
														} else {
															$.pt({
																target: $("#register-code"),
																position: 'r',
																align: 't',
																width: 'auto',
																height: 'auto',
																content: "验证码发送失败，请重新尝试"
															});
														}
	
													},
													error: function() {
														alert('登录失败');
														return false;
													}
												});
											}
										})
									</script>
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