<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${list }
	</br>
	<h1>EL11个隐含对象</h1>
	<ul>
		<li>${pageContext}</li>
		<li>${initParam.list}</li>
		<li>${param.list}</li>
		<li>${paramValues.list}</li>
		<li>${header }</li>
		<li>${headerValues }</li>
		<li>${cookie }</li>
		<li>${pageScope.list }</li>
		<li>${requestScope.list }</li>
		<li>${sessionScope }</li>
		<li>${applicationScope.list }</li>
	</ul>
	<h1>EL运算符</h1>
	<ul>
		<li>${5+5 }${4-5 }</li>
		<li>${5*5 }${0/5 }</li>
		<li>${5%5 }</li>
		<li>${5==5 }</li>
		<li>${5<=5 }</li>
		<li>${5!=5 }</li>
		<li>${5>=5 }</li>
		<li>${5<5 }</li>
		<li>${(5>5) and (5<=5) }</li>
		<li>${(5>5) or (5<=5) }</li>
		<li>${not (5<=5) }</li>
		<li>${empty (5<=5) }</li>
		<li>${empty null }</li>
		<li>${ 4>5?true:false}</li>
	</ul>
	<h1>.(点运算符用于访问对象的特性，当访问对象时，属性需要getter)和[]运算符(用于检索数组和集合的元素)</h1>
	<ul>
		<li>${requestScope.list }</li>
		<li>${requestScope["list"] }</li>
	</ul>
	<h1>查看pageContext的隐含对象</h1>
	<ul>
		<li>${pageContext.out }</li>
		<li>${pageContext.request }</li>
		<li>${pageContext.response }</li>
		<li>${pageContext.exception }</li>
		<li>${pageContext.page }</li>
		<li>${pageContext.session }</li>
		<li>${pageContext.servletContext }</li>
		<li>${pageContext.servletConfig }</li>
	</ul>
</body>
</html>