package Loan;

import java.sql.Date;
import java.util.ArrayList;

public class Customer{
    private int customerId;
    private String customerName;
    private String email;
    private String pan;
    private long contact;
    private int pin;
    ArrayList<Loan> loanArrayList = new ArrayList<>();
}
class Loan {
    private int loanNumber;
    private String borrowerName;
    private String loanType;
    private int loanAmount;
    private Date loanIssueDate;
}
