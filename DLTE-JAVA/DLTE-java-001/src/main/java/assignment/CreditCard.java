package assignment;


import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.sort;
//creditcard class implements the interface class(creditMEthods
public class CreditCard implements CreditMethods{


        Scanner scanner = new Scanner(System.in);
        Double[] creditbills = new Double[5];

        public static void main (String[]args){


        CreditCard creditCard = new CreditCard();
        //Read the Inputs from i/p stream
        System.out.println(" enter the bills of  New card : ");

            for (int index = 0; index < creditCard.creditbills.length; index++) {
                creditCard.creditbills[index] = creditCard.scanner.nextDouble();

            }
            System.out.println("Credit card bills are Registered : "+Arrays.toString(creditCard.creditbills));
        System.out.println("Select the Paricular Operation to be performed :\n 1 - new credit card entry \n 2 - Update the bill of particular index\n 3 - Add GST of 18% on all the Credit card bills\n 4 - Add 3% Gst on the bills more than 30000 \n 5 - list the credit card bills  ");
        Integer input = creditCard.scanner.nextInt();
        switch (input) {
            case 1 : creditCard.newCardEntry();
                break;
            case 2:
                creditCard.updateBillOfIndex();
                break;
            case 3:
                creditCard.addGst();
                break;
            case 4:
                creditCard.searchAndadd();
                break;
            case 5:
                creditCard.sortAndList();
                break;
            default:
                System.out.println("Invalid input");
        }

    }
       // all the interface class abstract methods are implemented here
        @Override
        public void newCardEntry () {
            System.out.println("Enter the new credit card  bill");
          Double newbill= scanner.nextDouble();
           creditbills= Arrays.copyOf( creditbills,creditbills.length +1);
           creditbills[creditbills.length-1] = newbill;
           System.out.println("Added the new Credit card bill");
           System.out.println("Credit card bills : "+Arrays.toString(creditbills));
    }

        @Override
        public void updateBillOfIndex () {
        System.out.println("Enter the position bill in credit bills array: ");
        creditbills[scanner.nextInt()-1] = 0.0;
        System.out.println("Updated the credit card bill Successfully!!");
            System.out.println("Credit card bills : "+Arrays.toString(creditbills));
    }

        @Override
        public void addGst () {
        for (int index = 0; index < creditbills.length; index++) {
            creditbills[index] += creditbills[index] * 0.18;

        }
            System.out.println("Credit card bills(included GST for each bill): " + Arrays.toString(creditbills));
    }

        @Override
        public void searchAndadd () {
        for (int index = 0; index < creditbills.length; index++) {
            if (creditbills[index] >= 30000)
                creditbills[index] += creditbills[index] * 0.03;
        }
        System.out.println("Added 3% GST for all the bills greater than 30000");
            System.out.println("Credit card bills : "+Arrays.toString(creditbills));
    }

        @Override
        public void sortAndList () {
        sort(creditbills);
        System.out.println("the Sorted Credit Card bills: " + Arrays.toString(creditbills));
    }
}
   //interface class(CreditMethods)
    interface CreditMethods {
        void newCardEntry();

        void updateBillOfIndex();

        void addGst();

        void searchAndadd();

        void sortAndList();
    }
