package review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentData studentData = new StudentData();
      System.out.println("1.Add Student details \n 2.display Student Details");
      Integer input;
      input = scanner.nextInt();
        switch (input){
            case 1 : studentData.studentDetails();
            case 2 : studentData.displayStudentData();
            default : System.out.println("invalid Input");
        }
    }
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class StudentData implements StudentEntry{
    Scanner scanner = new Scanner(System.in);
    private String studentName, address;
    private Integer age, RegistrationNumber;
File file = new File("C:\\DLTE-Java-full-Stack-Development\\review.doc");
//  FileInputStream fileInputStream = new FileInputStream(file);
//  FileOutputStream fileOutputStream = new
//          StudentData() throws FileNotFoundException {
//    }



    @Override
    public void studentDetails() {
        try {
            System.out.println("Enter the Student Name, Registration Number, age, ");
            setStudentName(scanner.next());
            setRegistrationNumber(scanner.nextInt());
            setAge(scanner.nextInt());
            System.out.println("enter the address(including pin code):");
            setAddress(scanner.nextLine());
        }
        catch (InputMismatchException e){
            System.out.println(e);
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Enter the details in the specific format only!");
                    try{
                        System.out.println("Enter the Student Name, Registration Number, age, ");
                        setStudentName(scanner1.next());
                        setRegistrationNumber(scanner1.nextInt());
                        setAge(scanner.nextInt());
                        System.out.println("enter the address(including pin code):");
                        setAddress(scanner.nextLine());
                    }
                     catch (InputMismatchException ie){
                        System.out.println("Invalid input");
                     }
        }

    }

    @Override
    public void displayStudentData() {
    System.out.println("Student Name :" +getStudentName()+" \n  Regestration Number:"+getRegistrationNumber()+" \n  age:"+getAge()+"\n address:"+getAddress());
    }
}
interface StudentEntry{
    void studentDetails();//abstract methods
    void displayStudentData();
}