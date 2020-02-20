<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>User Update Page</h1>
<form action = "uupdateimpl.mc" method="post">
ID<input type="text" name="id" value="${uuser.id }" readonly="readonly"> <br>
PWD<input type="text" name="pwd" value="${uuser.pwd }"> <br>
NAME<input type="text" name="name" value="${uuser.name }"> <br>
<input type="submit" value="UPDATE"> <br>
</form>