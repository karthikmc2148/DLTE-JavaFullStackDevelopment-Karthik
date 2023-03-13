 //array in whi
let details=[{
    "ID":"1221",
    "password":"2148",
    "customername":"Ganesh",
    "customerstatus":"active",
    "accno":"908734567",
    "accbal":"2345678",
   },
{
    "ID":"1222",
    "password":"1001",
    "customername":"karthik",
    "customerstatus":"inactive",
    "accno":"14256775",
    "accbal":"99432",
},{
    "ID":"1223",
    "password":"1004",
    "customername":"Razak",
    "customerstatus":"active",
    "accno":"86256775",
    "accbal":"10432",
},
{
    "ID":"1224",
    "password":"1005",
    "customername":"Apoorva V C",
    "customerstatus":"inactive",
    "accno":"63256775",
    "accbal":"130432",
}]
//method to verify the customer ID, Password
function verify(){
    let customerId = document.forms['login'].ID.value
    let  customerPassword= document.forms['login'].password.value

    details.forEach((item)=>{
        if(item.ID == customerId && item.password == customerPassword){
            window.location.href = "review.html"
        }
    })
}