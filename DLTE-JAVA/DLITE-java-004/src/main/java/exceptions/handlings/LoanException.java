package exceptions.handlings;


public class LoanException extends Exception {
    public LoanException(){
        // base class constructor
        super("Invalid Loan Name");
    }
}
