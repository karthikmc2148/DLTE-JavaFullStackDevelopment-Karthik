package assignment;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionInLoanReport {
    static Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ExceptionInLoanReport exceptionInLoanReport = new ExceptionInLoanReport();
        Double[] loanAmount = {987892.32, 89786.432,988642.492, 9886432.34, 867599.324};
        exceptionInLoanReport.loanArray(loanAmount);
    }
    public void loanArray(Double[] array) {
        System.out.println("Enter the Start , end Index values :");

        try {
            int startValue = scanner.nextInt();
            int endValue = scanner.nextInt();//4
            //assert startValue >= 0 && endValue <array.length: "Wrong Input index";
            System.out.print((endValue-startValue)>0);
            assert endValue<=startValue: "Wrong Input index";
            Double[] slicedArray = new Double[endValue + 1 - startValue];
            System.out.println("The values of Loan Report from Position" + startValue + ":" + endValue + " are ");
            for (int index = 0; startValue <= endValue&&index<slicedArray.length; index++,startValue++) {
                slicedArray[index] = array[startValue];
            }
            System.out.print(Arrays.toString(slicedArray));
        }
        catch (ArrayIndexOutOfBoundsException | AssertionError|NegativeArraySizeException|InputMismatchException indexoutassertion) {
            System.out.print(indexoutassertion);
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the numbers of , start and end index values between[0:4] and start<=end value only");
                int startValue = scanner.nextInt();//2
                int endValue = scanner.nextInt();//3
                Double[] slicedArray = new Double[endValue + 1 - startValue];
                for (int index = 0; startValue <= endValue && index < slicedArray.length; index++, startValue++) {
                    slicedArray[index] = array[startValue];
                }
                System.out.println("The values of Loan Report from Position:" + startValue + ":" + endValue + " are:");
                System.out.print(Arrays.toString(slicedArray));
            } catch (ArrayIndexOutOfBoundsException | NegativeArraySizeException e) {
                System.out.println("Maximum attempts made , try some other time"+e);
            }
        }
        catch(Exception ex){
            System.out.println("Invalid input "+ex);
        }
        finally{
            System.out.println("The Program executed Sucessfully!!");
        }
    }
}
