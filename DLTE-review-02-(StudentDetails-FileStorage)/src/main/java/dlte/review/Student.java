package dlte.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//POJO class/model class /business class
public class Student {
    private int registerNumber;
    private String name;
    private int age;
    private String email;
    private  Address address;
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Address{
    private String locality;
    private String area;
    private String city;
    private Integer pin;
}