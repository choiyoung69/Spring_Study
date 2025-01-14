<%--
  Created by IntelliJ IDEA.
  User: seoyeong
  Date: 2025. 1. 14.
  Time: PM 2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="hello.servletReview.domain.member.Member" %>
<%@ page import="hello.servletReview.domain.member.MemberRepository" %>

<%
  MemberRepository memberRepository = MemberRepository.getInstance();
  List<Member> members = memberRepository.findAll();
%>

<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
  <thead>
  <th>id</th>
  <th>username</th>
  <th>age</th>
  </thead>
  <tbody>
  <%
    for (Member member : members) {
      out.write(" <tr>");
      out.write("   <td>" + member.getId() + "</td>");
      out.write("   <td>" + member.getUsername() + "</td>");
      out.write("   <td>" + member.getAge() + "</td>");
    }
  %>
  </tbody>
</table>
</body>
</html>