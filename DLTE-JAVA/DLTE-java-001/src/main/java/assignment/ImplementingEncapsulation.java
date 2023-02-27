package assignment;

import java.util.Arrays;
import java.util.Scanner;

public class ImplementingEncapsulation {
    public static void main(String[] args) {
        Encapsulatedclass encapsulatedclass = new Encapsulatedclass("Karthik","pkqv08939za",687979799l,"doctor",557,636333806l);
        System.out.println(encapsulatedclass.toString());
        encapsulatedclass.loanSanction();
    }
}
//Encapsulated class contains private data members and public methods
class Encapsulatedclass {
    Scanner scanner = new Scanner(System.in);
    private String CustomerName;
private String PAN;
private Long  Aadhaar;
private String Profession;
private Integer cibil;
private Long Contact;
//getter and setter methods to private members of class



        public String getCustomerName () {
            return CustomerName;
        }

        public void setCustomerName (String customerName){
            CustomerName = customerName;
        }

        public String getPAN () {
            return PAN;
        }

        public void setPAN (String PAN){
            this.PAN = PAN;
        }

        public Long getAadhaar () {
            return Aadhaar;
        }

        public void setAadhaar (Long aadhaar){
            Aadhaar = aadhaar;
        }

        public String getProfession () {
            return Profession;
        }

        public void setProfession (String profession){
            Profession = profession;
        }

        public Integer getCibil () {
            return cibil;
        }

        public void setCibil (Integer cibil){
            this.cibil = cibil;
        }

        public Long getContact () {
            return Contact;
        }

        public void setContact (Long contact){
            Contact = contact;
        }

  //using the parametrized constructors
    public Encapsulatedclass(String customerName, String PAN, Long aadhaar, String profession, Integer cibil, Long contact) {
        CustomerName = customerName;
        this.PAN = PAN;
        Aadhaar = aadhaar;
        Profession = profession;
        this.cibil = cibil;
        Contact = contact;
    }

    @Override
    public String toString() {
        return "Encapsulatedclass{" +
                "scanner=" + scanner +
                ", CustomerName='" + CustomerName + '\'' +
                ", PAN='" + PAN + '\'' +
                ", Aadhaar=" + Aadhaar +
                ", Profession='" + Profession + '\'' +
                ", cibil=" + cibil +
                ", Contact=" + Contact +
                '}';
    }

    //this method defines , weather to provide a loan(how much) to a customer based on his/her cibil score
        public void loanSanction(){
            System.out.println("Enter the Customer name ,PAN No , Aadhar No, His /Her Proffession ,contact ");
            setCustomerName(scanner.nextLine());
            setPAN(scanner.next());
            setAadhaar(scanner.nextLong());
            setProfession(scanner.next());
            setContact(scanner.nextLong());
            System.out.println("enter the Cibil Score: ");
            setCibil(scanner.nextInt());
            if(getCibil()>=550 && getCibil()<=600)
                System.out.println(getCustomerName()+" is Eligible to get a Loan amount of  Rs 500000 at SBI,ICICI for profession  "+getProfession());
            else if(getCibil()>=661 && getCibil()<=700)
                System.out.println(getCustomerName()+" is Eligible to get a Loan amount of  Rs 1000000 at CANERA BANK,AXIS BANK, MUTHOOT fINANCE for profession "+getProfession());
            else if(getCibil()>=701)
                System.out.println(getCustomerName()+" is Eligible to get a Loan amount of  Rs 2300000 at UNION BANK, KARNATAKA BANK for profession "+getProfession());
            else System.out.println(getCustomerName()+" is not Enigible to get the loan from any of the banks");
        }

}
