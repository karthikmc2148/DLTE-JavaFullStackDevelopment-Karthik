<%--
  Created by IntelliJ IDEA.
  User: xxmcccck
  Date: 26-03-2023
  Time: 06:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"  language="java" %>
<html>
<head>
    <title>student table</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">


</head>
<body>
<%@ taglib prefix="db" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<db:setDataSource var="connection" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe" user="karthik" password="Passward@4444" />
<db:query var="qry" dataSource="${connection}" sql="select * from student" />
<div class="table-responsive">
    <table class="table text-info table-striped p-2 shadow-lg text-nowrap" cellspacing="1px" cellpadding="1px">
        <thead>
        <tr class="bg-info">
            <th>register_number</th><th>Student Name</th><th>Student age</th><th>Student email</th><th>address</th>
        </tr>
        </thead>
        <tbody>
           <core:forEach var="record" items="${record.rows}">
           <tr>
               <td>${record.register_number}</td>
               <td>${record.student_name}</td>
               <td>${record.student_age}</td>
               <td>${record.student_email}</td>
               <td><a href="address.jsp?id=${student.register_number}" class="btn btn-outline-warning">
                   <i class="bi bi-pencil-square"></i>
               </a>
               <a class="btn btn-outline-danger">
                   <i class="bi bi-person-x"></i>
               </a>
               </td>
           </tr>
           </core:forEach>
        </tbody>
    </table>
</div>
           <a class="btn btn-outline-success float-end" href="insertStudent.jsp">
               <i class="bi bi-newspaper"></i>new Student
           </a>

</body>
</html>
