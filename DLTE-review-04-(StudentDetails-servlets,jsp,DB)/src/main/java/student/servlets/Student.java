package student.servlets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int register_number;
    private String name;
    private int age;
    private String email;
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Address{
    private int doorNumber;
    private String street;
    private String city;
    private Integer pinCode;
    private String type;
}