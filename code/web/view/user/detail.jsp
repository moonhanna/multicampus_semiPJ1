<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>User Detail Page</h1>
ID: ${duser.id }<br>
PWD: ${duser.pwd }<br>
NAME: ${duser.name }<br>
<a href="udel.mc?id=${duser.id }">DELETE</a>
<a href="uupdate.mc?id=${duser.id }">UPDATE</a>