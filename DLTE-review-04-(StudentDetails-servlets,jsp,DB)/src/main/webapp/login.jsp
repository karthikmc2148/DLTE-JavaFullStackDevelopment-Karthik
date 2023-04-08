<%--
  Created by IntelliJ IDEA.
  User: xxmcccck
  Date: 24-03-2023
  Time: 05:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<body>
     <div class="container">
         <div class="row justify-content-center  ">
             <form action="login" method="post" class="bg-info rounded-4 mt-5 p-4 col-lg-5 col-md-8 col-sm-12">
                 <div class="form group">
                     <label>Admin ID</label>
                     <input type="text" name="adminId" class="form-control" />
                 </div>
                 <div class="form group">
                     <label>Password</label>
                     <input type="password" name="passCode" class="form-control" />
                 </div>
                 <div class="mt-2 row justify-content-around">
                     <input type="submit" value="submit" class="col-2 btn btn-success"/>
                     <input type="reset"  class="col-2 btn btn-primary" />
                 </div>
             </form>
         </div>
     </div>
</body>
</html>
