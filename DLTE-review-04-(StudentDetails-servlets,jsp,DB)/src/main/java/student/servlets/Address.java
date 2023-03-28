package student.servlets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
 public class Address{
    private int doorNumber;
    private String street;
    private String city;
    private Integer pinCode;
    private String type;
}