let accBalance = 50000.0;
alert("available Balance : is ₹ "+ accBalance)
function transfer(){
const sender=document.forms['send'].senderName.value
const reciver=document.forms['send'].reciverName.value
var cash=document.forms['send'].amount.value

if(cash<=accBalance){
    accBalance-= cash
    alert(sender+ " will Transfer an amount of ₹ "+cash+ " confirm by clicking on OK")
    document.forms['send'].result.value = sender+ " has Transfered an amount of ₹ "+cash+" to "+reciver+ ", available Balance is ₹ "+accBalance
}
    else
    document.forms['send'].result.value = sender+" couldn't Transfer the fund, Since the available Balance is low!!" 


}

function deposit(){
   const sender=document.forms['send'].senderName.value
  const reciver=document.forms['send'].reciverName.value
   var cash=document.forms['send'].amount.value
  accBalance+= +cash
 
    document.forms['send'].result.value = sender+ " has Deposited an amount of ₹ "+cash+" to "+reciver+" available Balance  is ₹ "+accBalance

}
