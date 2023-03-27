<%--
  Created by IntelliJ IDEA.
  User: xxmcccck
  Date: 23-03-2023
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if(session.getAttribute("student")!=null){
%>
<div class="container">
    <div class="d-flex justify-content-end mt-5">
        <a href="logout" class="btn btn-outline-danger"><i class="bi bi-box-arrow-left">Logout</i></a>
    </div>
    <div class="row justify-content-center">
        <h1 class="rounded-5 bg-info text-danger text-center mt-3 ">Student Details Form!!</h1>
        <form action="insert" method="post" name="studentForm" class="col-lg-5 col-md-8 col-sm-12 rounded-4 shadow-lg p-5 bg-danger text-info">
            <div class="form group">
                <label>Register Number</label>
                <input type="text" name="registerNumber" placeholder="register Number" class="form-control" />
            </div>
            <div class="form group">
                <label>Student Name</label>
                <input type="text" name="studentName" placeholder="student Name " class="form-control" />
            </div>
            <div class="form group">
                <label>age</label>
                <input type="text" name="studentAge" placeholder="age" class="form-control" />
            </div>
            <div class="form group">
                <label>Email</label>
                <input type="text" name="studentEmail" placeholder="Email" class="form-control" />
            </div>
            <div>
                <label>Current  Address</label>
                    <div class="form group">
                        <label>Door Number</label>
                <input type="text" name="doorNo1" placeholder="Door No" class="form-control" />
                    </div>
                    <div class="form group">
                        <label>Street</label>
                        <input type="text" name="street1" placeholder="Street" class="form-control" />
                    </div>
                <div class="form group">
                    <label>City</label>
                    <input type="text" name="city1" placeholder="City" class="form-control" />
                </div>
                <div class="form group">
                    <label>Pin Code</label>
                    <input type="text" name="pinCode1" placeholder="Pin Code" class="form-control" />
                </div>
            </div>
            <div>
                <label>Permanant address</label>
                <div class="form group">
                    <label>Door Number</label>
                    <input type="text" name="doorNo2" placeholder="Door No" class="form-control" />
                </div>
                <div class="form group">
                    <label>Street</label>
                    <input type="text" name="street2" placeholder="Street" class="form-control" />
                </div>
                <div class="form group">
                    <label>City</label>
                    <input type="text" name="city2" placeholder="City" class="form-control" />
                </div>
                <div class="form group">
                    <label>Pin Code</label>
                    <input type="text" name="pinCode2" placeholder="Pin Code" class="form-control" />
                </div>
            </div>
            <div class="mt-2 row justify-content-around">
                <input type="submit" value="submit" class="col-2 btn btn-success" />
                <input type="reset"  class="col-2 btn btn-primary" />
            </div>
        </form>
    </div>
 </div>
<%}
else{
    response.sendRedirect("login.jsp");
}%>
</body>
</html>
