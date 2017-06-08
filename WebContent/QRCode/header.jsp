<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>QRCode</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<!--<link rel="stylesheet" href="style.css" type="text/css" charset="utf-8" />-->
</head>
<% 
	Integer idUser 	= (Integer)session.getAttribute("idUser");
	String user 	= (String)session.getAttribute("user");
	String message 	= (String)session.getAttribute("message");
	String action 	= (String)session.getAttribute("action");
%>

<body>
	<div id="page">
		<center><div id="header">
			<u>Projet Transversal QRCode</u>
		</div></center>
		<br/><br/>
		
		<% if((message != null && message != "" && message != " ") && (action != null && action != "")){ %>
		<div id="message">
			<font color="red"><u>Message :</u> '<%= message %>'</font>
		</div>
		<br/><br/>
		<% } %>
		
		<div id="content">