<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include/_common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh_CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- 下述代码的意思是，默认情况下，UI布局的宽度和移动设备的宽度一致，缩放大小为原始大小。 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 下述代码，强制让文档的宽度与设备的宽度保持1∶1，文档最大的宽度比例是1，且不允许用户单击屏幕放大浏览。
尤其要注意的是，content里多个属性的设置一定要用分号和空格来隔开，如果不规范将不会起作用 -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1, maximumscale=1, user-scalable=no"> -->

<title>Index 基础首页</title>

<!-- Bootstrap -->
<link href="<%=path%>/resource/bootstrap-3.3.6/css/bootstrap.css" rel="stylesheet">
<!-- 以下2个插件是用于在IE8支持HTML5元素和媒体查询的，如果不用可移除 -->
<!-- 注意:Respond.js不支持file:// 方式的访问 -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-xs-1">.col-xs-1</div>
			<div class="col-xs-1">.col-xs-1</div>
			<div class="col-xs-1">.col-xs-1</div>
			<div class="col-xs-1">.col-xs-1</div>
			<div class="col-xs-1">.col-xs-1</div>
			<div class="col-xs-1">.col-xs-1</div>
			<div class="col-xs-1">.col-xs-1</div>
			<div class="col-xs-1">.col-xs-1</div>
			<div class="col-xs-1">.col-xs-1</div>
			<div class="col-xs-1">.col-xs-1</div>
			<div class="col-xs-1">.col-xs-1</div>
			<div class="col-xs-1">.col-xs-1</div>
		</div>
		<div class="row">
			<div class="col-xs-8">.col-xs-8</div>
			<div class="col-xs-4">.col-xs-4</div>
		</div>
		<div class="row">
			<div class="col-xs-4">.col-xs-4</div>
			<div class="col-xs-4">.col-xs-4</div>
			<div class="col-xs-4">.col-xs-4</div>
		</div>
		<div class="row">
			<div class="col-xs-6">.col-xs-6</div>
			<div class="col-xs-6">.col-xs-6</div>
		</div>

		<div class="row">
			<a href="#" data-toggle="popover" title="Example popover"> 请悬停在我的上面 </a>
		</div>

		<div class="row">
			<button type="button" class="btn btn-xs">Primary</button>
			<button type="button" class="btn btn-lg">Success</button>
			<h1>Bootstrap权威指南</h1>
			<h2>Bootstrap权威指南</h2>
			<h3>Bootstrap权威指南</h3>
			<h4>Bootstrap权威指南</h4>
			<h5>Bootstrap权威指南</h5>
			<h6>Bootstrap权威指南</h6>
		</div>

		<div class="row">
			<span class="h1">Bootstrap权威指南</span><br /> <span class="h2">Bootstrap权威指南</span><br /> <span class="h3">Bootstrap权威指南</span><br />
			<span class="h4">Bootstrap权威指南</span><br /> <span class="h5">Bootstrap权威指南</span><br /> <span class="h6">Bootstrap权威指南</span><br />
		</div>

		<div class="row">
			<p class="lead">AAAAAAAAAAAAAAAAAAAAAAAAAAAA</p>
			<p>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb</p>
		</div>
		<div class="row">
			<address>
				<strong>Twitter, Inc.</strong><br> 795 Folsom Ave, Suite 600<br> San Francisco, CA 94107<br> <abbr
					title="Phone">P:</abbr> (123) 456-7890
			</address>
			<address>
				<a href="mailto:#">tomxu@outlook.com</a>
			</address>
		</div>

		<div class="row">
			<blockquote>
				<p>不愤不启,不悱不发。举一隅,不以三隅反,则吾不复也。</p>
				<small>出自 <cite title="论语•述而">论语</cite></small>
			</blockquote>
		</div>

		<div class="btn-toolbar">
			<div class="btn-group">
				<a class="btn btn-default" href="#"><span class="glyphicon glyphiconalign-left"> </span></a> <a
					class="btn btn-default" href="#"><span class="glyphicon glyphiconalign-center"> </span></a> <a
					class="btn btn-default" href="#"><span class="glyphicon glyphiconalign-right"> </span></a> <a
					class="btn btn-default" href="#"><span class="glyphicon glyphiconalign-justify"> </span></a>
			</div>
		</div>
	</div>


	<!-- 如果要使用Bootstrap的JS插件，则必须引入jQuery -->
	<script src="<%=path%>/resource/jquery/jquery-1.12.0.js"></script>
	<!-- Bootstrap的JS插件 -->
	<script src="<%=path%>/resource/bootstrap-3.3.6/js/bootstrap.js"></script>

	<script type="text/javascript">
		
	</script>

</body>
</html>