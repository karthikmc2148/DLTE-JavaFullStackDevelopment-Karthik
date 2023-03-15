package card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credit_card {
    private int  card_number,card_pin;
    private String card_holder;
    private Date card_expiry;
    private Double card_limit;
}
