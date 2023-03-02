let accountBalance = 50000.00
alert("Account Balance is ₹ "+accountBalance)
function transfer(){
    const sender = document.forms['send'].senderName.value
    const reciver = document.forms['send'].reciverName.value
    var cash = document.forms['send'].amount.value
    if(cash<=accountBalance){
        alert("confirm the transfer of amount ₹ "+cash +" to "+reciver)
        accountBalance -= cash 
        document.forms['send'].result.value = sender+ " has transferred an Amount of ₹ "+cash+" to "+reciver +", available balance "+accountBalance
    }
    else
      document.forms['send'].result.value = "Insufficient Fund !!"
 }
 function deposit(){
    const sender = document.forms['send'].senderName.value
    const reciver = document.forms['send'].reciverName.value
    var cash = document.forms['send'].amount.value
    accountBalance += +cash
    document.forms['send'].result.value = reciver+ " has Deposited  an Amount of ₹ "+cash+" to "+sender+", available balance "+accountBalance
 }