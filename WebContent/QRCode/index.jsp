<%@include file="header.jsp" %>

<form action ="/JEEQRCode/QRCode" method="post">
	Nom d'utilisateur :<br/>
	<input type="text" name="user" value='<%= user %>' /><br/><br/>
	
	Mot de passe :<br/>
	<input type="password" name="pass" value="" /><br/><br/>
	
	<input type="submit" value="Connexion" name="conn">
</form>

<%@include file="footer.jsp" %>