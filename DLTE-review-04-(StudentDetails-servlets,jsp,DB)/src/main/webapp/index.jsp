<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>studentData</title>
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
 <div class = "container">
     <div class="d-flex justify-content-end mt-5">
         <a href="logout" class="btn btn-outline-danger"><i class="bi bi-box-arrow-left">Logout</i></a>
     </div>
     <div class="row justify-content-end ">
         <a href="logout"><i class="bi bi-box-arrow-left"></i></a>
     </div>
    <div class = "row text-light text-bg-primary rounded-4 mt-5 justify-content-center">
        <h2 class="col-3">Student Details!!</h2>
    </div>
     <% out.println(request.getAttribute("LoginAccessed")); %>
   <div class=" row justify-content-center">
     <div class = " card bg-danger mt-2 rounded-4 p-2  col-lg-5 col-md-8 col-sm-12">
         <a href ="studentDetails" ><h4 class="mt-2 text-light p-2">
             <marquee width="100%" behavior="right" bgcolor="red">
                 1.Click here to view student the Details!!
             </marquee>
         </h4></a>
         <a href ="insertStudent.jsp" >
             <h4 class = " mt-2 text-light ">
             <marquee width="100%" behavior="right" bgcolor="red">
                 2.click here to add new Student Details!!
             </marquee>
         </h4></a>
     </div>

   </div>

 </div>
<%}
else{
    response.sendRedirect("login.jsp");
}%>
</body>
</html>