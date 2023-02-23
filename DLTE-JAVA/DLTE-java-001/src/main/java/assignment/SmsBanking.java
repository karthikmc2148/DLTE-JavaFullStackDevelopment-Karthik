package assignment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SmsBanking {
    public static void main(String[] args) {

    }
}

@Data
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
class Transation extends Kyc{
    Scanner scanner = new Scanner(System.in);
    public void balanceEnqiry(){
        System.out.println("Enter the account Holder name, account Number  :");
            String name= scanner.nextLine();
            Long accnum = scanner.nextLong();
            setName(scanner.nextLine());
            setAccNum(scanner.nextLong());
            System.out.println("Enter the UPI ID:");
            Integer upi=scanner.nextInt();
            if(upi.equals(getUpi()))
              System.out.println(name+" with "+accnum+"has the account balance Rs "+ getBalance()) ;
            else
                System.out.println("Wrong UPI Entered!!")
    }

    public void recharge(){
        System.out.println(" this ");


    }
}
class banking{

}