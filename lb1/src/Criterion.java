import java.util.ArrayList;
import java.util.List;

public class Criterion {
    String criterionName;
    double rate;
    List<String> criterionValue = new ArrayList<>();

    @Override
    public String toString() {
        return "Критерій: " + criterionName +
                " (Оцінка: " + rate + ")" +
                ", Критеріальні значення: " + criterionValue +
                '}';
    }
}
