import java.util.ArrayList;
import java.util.List;

public class Criterion {
    String criterionName;
    int criterionNum;
    List<String> criterionValues = new ArrayList<>();




    @Override
    public String toString() {
        return "Критерій: " + criterionName +
                ", Критеріальні значення: " + criterionValues +
                '}';
    }
}


