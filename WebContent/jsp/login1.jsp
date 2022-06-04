<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <form action="http://localhost:8080/Login/jp.co.aforce/login"method="post">
    <p>${error }</p>
    <p>ログイン名:<input type="text" name="login" maxlength="30"></p>
    <p>パスワード:<input type="password" name="password" maxlength="30"></p>
    <p><input type="submit" value="ログイン"></p>
    </form>
