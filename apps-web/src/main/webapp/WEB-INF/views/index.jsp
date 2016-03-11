<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include/_common.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@include file="include/common_css.jsp"%>

<title>Bootstrap 101 Template</title>


</head>
<body>
	<h1>你好，世界！</h1>

	<script type="text/javascript" src="<%=path%>/resource/jquery/jquery-1.12.0.js"></script>
	<script type="text/javascript" src="<%=path%>/resource/jquery/lazyload/jquery.lazyload.js"></script>

	<div>
		<img alt="暂无图片" src="">
	</div>

	<div class="container">
		<div class="jumbotron">
			<h1>我的第一个 Bootstrap 页面</h1>
			<p>重置窗口大小，查看响应式效果！</p>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<h3>Column 1</h3>
				<p>学的不仅是技术，更是梦想！</p>
				<p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>
			</div>
			<div class="col-sm-4">
				<h3>Column 2</h3>
				<p>学的不仅是技术，更是梦想！</p>
				<p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>
			</div>
			<div class="col-sm-4">
				<h3>Column 3</h3>
				<p>学的不仅是技术，更是梦想！</p>
				<p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>
			</div>
		</div>
	</div>

</body>
</html>