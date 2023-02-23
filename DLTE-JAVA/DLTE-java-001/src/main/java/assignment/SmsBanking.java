package assignment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;
import java.util.SortedMap;

@Data


public class SmsBanking {
    public static void main(String[] args) {
    Sms sms = new Sms();
    sms.balanceEnqiry();
    sms.recharge();
    sms.bookTickets();
    sms.services();
    }
}


class Kyc{
    private Long accNum;
    private String name;
    private Double balance=5000.0;
    private Integer upi= 1234;

    public Long getAccNum() {
        return accNum;
    }

    public void setAccNum(Long accNum) {
        this.accNum = accNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getUpi() {
        return upi;
    }

    public void setUpi(Integer upi) {
        this.upi = upi;
    }
}
class Transaction extends Kyc {
    Scanner scanner = new Scanner(System.in);

    public void balanceEnqiry() {
        System.out.println("Enter the account Holder name, account Number  :");
        String name = scanner.nextLine();
        Long accnum = scanner.nextLong();
        setName(name);
        setAccNum(accnum);
        System.out.println("Enter the UPI ID:");
        Integer upi = scanner.nextInt();
        if (upi.equals(getUpi()))
            System.out.println(name + " with Account Number  " + accnum + " has the account balance Rs " + getBalance());
        else
            System.out.println("Wrong UPI Entered!!");
    }

    public void recharge() {
        System.out.println("Enter the Phone Number and amount to be recharged:");
        Long phoneNo = scanner.nextLong();
        Float amount = scanner.nextFloat();
        System.out.println("Enter the UPI ID");
        Integer upi = scanner.nextInt();
        if (upi.equals(getUpi())) {

            if (amount <= getBalance()) {
                setBalance(getBalance() - amount);
                System.out.println("Rs " + amount + " Recharge Successfull to mobile No: " + phoneNo);
                System.out.println("Avaliable balance " + getBalance());
            }
            else
                System.out.println("Insufficient fund in your Account!!");
        }
        else System.out.println("wrong UPI ID entered!!");
    }

    public void bookTickets(){
        System.out.println("Enter the Number of tickets:");
                Integer tickets= scanner.nextInt();
        Float amount = (float)(tickets * 100) ;//each ticket costs of Rs 100/-
        System.out.println("Enter the UPI ID");
        Integer upi = scanner.nextInt();
        if (upi.equals(getUpi())) {
            if (amount <= getBalance()) {
                setBalance(getBalance() - amount);
                System.out.println(tickets+" Tickets booked of Total amount "+amount);
                System.out.println("Avaliable balance " + getBalance());
            }
            else System.out.println("Insufficient fund in your Account!!");
        }
       else System.out.println("wrong UPI ID entered!!");
    }
}
class Sms extends Transaction{

    public void services() {
        System.out.println("Enter 1901- for Balance Enqiry \n 2245- for Recharge");
        Integer input =scanner.nextInt();
        if(input==1901)
            this.balanceEnqiry();
        else if(input==2245)
            this.recharge();
        else System.out.println("Invalid Input!!");
    }
}

