package dlte.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends Exception {

    public CustomException(String invalid_student_age) {

    }

    static void validate(int age) throws CustomException {
        if (age <= 0 && age >= 26)
         throw new  CustomException("Invalid Student Age");
    }
}
