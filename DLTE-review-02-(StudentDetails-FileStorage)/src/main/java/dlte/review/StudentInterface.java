package dlte.review;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

interface StudentInterface {
    String writeRecords(Student student) throws IOException;
    ArrayList<Student> readRecords() throws IOException, ClassNotFoundException;
}