package dlte.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudentImplements implements StudentInterface {
    List<Student> studentList = new ArrayList<>();
    File file = new File("C:\\DLTE-Java-full-Stack-Development\\DLTE-review-02-(StudentDetails-FileStorage)\\studentDetails.doc");

    public StudentImplements() throws IOException {
    }
    @Override
    public String writeRecords(Student student) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
          objectOutputStream.writeObject(student);
          objectOutputStream.close();
          fileOutputStream.close();
          return student.getName()+" Details has been successfully added into the file:"+file.getName() ;
    }
    public ArrayList<Student> readRecords() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
         return (ArrayList<Student>) objectInputStream.readObject();
    }
}
