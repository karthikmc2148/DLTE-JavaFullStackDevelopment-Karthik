package dlte.review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Hello world!
 *
 */
public class App { 
    public static void main( String[] args ) throws IOException, ClassNotFoundException,CustomException {
        Scanner scanner  = new Scanner(System.in);
        Scanner scanner1  = new Scanner(System.in);
        StudentImplements studentImplements = new StudentImplements();
        boolean success = true;
        do {
            System.out.println("----------------------------------Student Details----------------------------------");
            System.out.println("Select the operation to be performed: \n 1.Add New Student Details\n 2.Display All students details\n 3.Exit");
            switch (scanner.nextInt()) {
                case 1:
                    Student student = new Student();
                    //Address address = new Address();

                    while(success){
                        try{
                            System.out.println("Enter the student Name");
                            student.setName(scanner1.nextLine());
                            success = false;
                        }
                        catch(Exception e){
                            System.out.println("Invalid input!!");
                        }
                    }

                    System.out.println("Enter the student Register Number");
                    student.setRegisterNumber(scanner.nextInt());
                    try {
                        System.out.println("Enter the student age");
                        student.setAge(scanner.nextInt());
                        CustomException.validate(student.getAge());
                    }
                     catch(CustomException e){
                        System.out.println(e);
                     }
                    System.out.println( "Enter the student EmailId");
                    student.setEmail(scanner1.nextLine());
                    System.out.println("Enter the Student addressDetails:");
                    System.out.println("Locality : ");
                    student.getAddress().setLocality(scanner1.nextLine());
                    System.out.println("Area : ");
                    student.getAddress().setArea(scanner1.nextLine());
                    System.out.println("City : ");
                    student.getAddress().setCity(scanner1.nextLine());
                    System.out.println("PIN Code : ");
                    student.getAddress().setPin(scanner.nextInt());
                    student.setAddress(student.getAddress());
                    studentImplements.studentList = studentImplements.readRecords();
                    studentImplements.studentList.add(student);
                    studentImplements.writeRecords(studentImplements.studentList);
                    break;
                case 2:
                    System.out.println("--------------------------------All Students Information-----------------------------------");
                    ArrayList<Student> studentArrayList = studentImplements.readRecords();
                    int count = 1;
                    for (Student record : studentArrayList) {
                        System.out.println("Student :"+count+" Register Number: "+record.getRegisterNumber()+" name :"+record.getName()+" age :"+record.getAge()+" Email :"+record.getEmail()+" address :"+ record.getAddress());
                        count++;
                    }
                    break;
                case 3:
                    exit(0);
                default:
                    System.out.println("Invalid Input");
            }
        }while(true);
    }
}
