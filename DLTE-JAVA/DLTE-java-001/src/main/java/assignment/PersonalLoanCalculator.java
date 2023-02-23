package assignment;
//import the classes from other package
import java.util.*;


public class  PersonalLoanCalculator {
    public static void main(String[] args) {
        Integer amount=0, tenure=0;
        Double interest=0.0, emi=0.0;
  //receive the Customer Inputs
        Scanner scannerobject=new Scanner(System.in);
        System.out.println("Enter the loan amount:");
        amount=scannerobject.nextInt();
        System.out.println("Enter the interest rate");
        interest=scannerobject.nextDouble();
        interest=interest/(12*100);
        System.out.println("Enter the duration");
        tenure=scannerobject.nextInt();
        tenure=tenure*12;
   //Calculate the EMI
        emi= (amount*interest*Math.pow(1+interest,tenure))/(Math.pow(1+interest,tenure)-1);

        System.out.println(" EMI is Per Month is  "+emi);
  //Calculation of total Amount to be paid for a loan
        double totalamount = emi*tenure;
        System.out.println("the total repayment: " +totalamount );
        System.out.println("Total interest Paid : "+(totalamount-amount));
    }
}




