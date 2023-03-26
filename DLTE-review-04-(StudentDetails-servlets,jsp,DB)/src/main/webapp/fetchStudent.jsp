<%@ page import="student.servlets.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xxmcccck
  Date: 23-03-2023
  Time: 12:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<% List<Student> studentList = (List<Student>)request.getAttribute("studentDB");
pageContext.setAttribute("list",studentList, pageContext.APPLICATION_SCOPE);%>
<div class="container">
    <div class="d-flex justify-content-end mt-5">
        <a href="login.jsp" class="btn btn-outline-danger"><i class="bi bi-box-arrow-left">Logout</i></a>
    </div>
    <div class=" row justify-content-center mt-3">
    <table class="table table-bordered table-hover table-sm">
        <thead>
        <tr class="bg-info">
            <th>register_number</th><th>Student Name</th><th>Student age</th><th>Student email</th><th>Address Type</th>
        </tr>
        </thead>
        <tbody>
        <% for(Student student:studentList){  %>
          <tr class=" bg-light">
              <td><%=student.getRegister_number() %></td>
              <td><%=student.getName() %></td>
              <td><%=student.getAge() %></td>
              <td><%=student.getEmail() %></td>
              <td><a href="address.jsp" class="btn btn-outline-warning"><i class="bi bi-geo-alt-fill">Current</i></a> <a href="address.jsp" class="btn btn-outline-success"><i class="bi bi-geo-alt-fill">Permanent</i></a> </td>
              <td> <a class="btn btn-outline-danger">
                  <i class="bi bi-person-x"></i>
              </a>
              </td>
          </tr>
        <%}%>
        </tbody>
    </table>
        <a href="index.jsp">move to main page</a>
</div>
    <div class="d-flex justify-content-end p-5 mt-4">
        <a href="insertStudent.jsp" class="btn btn-outline-success"><i class="bi bi-database-fill-add">Add new Student</i></a>
    </div>
</div>
</body>
</html>
