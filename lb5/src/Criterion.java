import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Criterion {
    String criterionName;
    BigDecimal criterionMark;
    int criterionNum;

    List<String> criterionValues = new ArrayList<>();




    @Override
    public String toString() {
        return "Критерій: " + criterionName +
                ", Критеріальні значення: " + criterionValues +
                '}';
    }
}


