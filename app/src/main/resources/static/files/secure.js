$(document).ready(()=>{
    if(sessionStorage.getItem("loggedIn")===null)
        window.location.assign("http://localhost:8082/mvn/login");
    // $("#logout").click(()=>{
    //     sessionStorage.removeItem("loggedIn");
    // })

})