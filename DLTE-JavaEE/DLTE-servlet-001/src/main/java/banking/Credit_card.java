package banking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credit_card {
    private Long card_number;
    private String card_holder;
    private Date card_expiry;
    private Double card_limit;
}
