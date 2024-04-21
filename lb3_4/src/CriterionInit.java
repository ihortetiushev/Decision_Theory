import java.util.ArrayList;
import java.util.List;

public class CriterionInit {
    public static List<Criterion> initialize() {

        List<Criterion> alternative = new ArrayList<>();
        Criterion criterion1 = new Criterion();
        Criterion criterion2 = new Criterion();
        Criterion criterion3 = new Criterion();
        Criterion criterion4 = new Criterion();

        criterion1.criterionName = "Вартість";
        criterion1.criterionNum = 1;
        criterion1.criterionValues.addAll(List.of("5000 у.о", "10000 у.о", "15000 у.о", "20000 у.о"));
        alternative.add(criterion1);

        criterion2.criterionName = "Відмовостійкість";
        criterion2.criterionNum = 2;
        criterion2.criterionValues.addAll(List.of("99.9%","до 97%", "до 93%", "N/A"));
        alternative.add(criterion2);

        criterion3.criterionName = "Максимальний час відгуку системи";
        criterion3.criterionNum = 3;
        criterion3.criterionValues.addAll(List.of("0.1с", "0.3с", "0.5с", "0.8с"));
        alternative.add(criterion3);

        criterion4.criterionName = "Максимальна кількість користувачів одночасно";
        criterion4.criterionNum = 4;
        criterion4.criterionValues.addAll(List.of("150.000", "70.000", "25.000", "1.000"));
        alternative.add(criterion4);

        return alternative;
    }
}