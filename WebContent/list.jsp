<%@page import="java.util.HashMap"%>
<%@page import="com.cloth.entities.Client"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View List</title>
</head>
<body>
<%--
Key<Album>  album= Key.create(Album.class, "default");

List<MyImage> users = null;
users = ObjectifyService.ofy()
    .load()
    .type(MyImage.class) // We want only Greetings
    .ancestor(album)    // Anyone in this book
    .order("-date")       // Most recent first - date is indexed.
    .limit(5)             // Only show 5 of them.
    .list();
	//List<MyImage> users = (List<MyImage>)request.getAttribute("users");
	for(MyImage user : users){
--%>
	<%-- <%=user.getName()%> - <%=user.getUserId() %><br/> --%>
<%--
	}
--%>
<table>
<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Customer ID</th>
	<th>Blob Key</th>
</tr>

<%
List<Client> clients = (List<Client>)request.getAttribute("clients");
for(Client client : clients){
%>
	<tr>
	<td><%=client.getFirstName() %></td>
	<td><%=client.getLastName() %></td>
	<td><%=client.getCount() %></td>
	<td><%=client.getBlobkey() %></td>
	</tr>
<%
	}
%>

</table>

<% 
List<String> urls = (List<String>)request.getAttribute("urls");

for(String url:urls){
%>

<img alt="" src="<%=url%>"/>

<%
}
%>
<br>
<hr>
<% 
HashMap<String,String> allurls = (HashMap<String,String>)request.getAttribute("allurls");

for(String name:allurls.keySet()){
	
%>
<%=name%>
<img alt="" src="<%=allurls.get(name)%>"/>
<br/>
<%
}
%>
</body>
</html>