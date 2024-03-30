import java.util.ArrayList;
import java.util.List;

public class CriterionInit {
    public static List<Criterion> initialize() {

        List<Criterion> alternative = new ArrayList<>();
        Criterion criterion1 = new Criterion();
        Criterion criterion2 = new Criterion();
        Criterion criterion3 = new Criterion();
        Criterion criterion4 = new Criterion();
        Criterion criterion5 = new Criterion();

        criterion1.criterionName = "Підтримка";
        criterion1.rate = 0.14;
        criterion1.criterionNum = 1;
        criterion1.criterionValues.addAll(List.of("цілодобова", "у робочий час"));
        alternative.add(criterion1);

        criterion2.criterionName = "Використання хмарних сервісів";
        criterion2.rate = 0.13;
        criterion2.criterionNum = 2;
        criterion2.criterionValues.addAll(List.of("повне використання", "часткове використання"));
        alternative.add(criterion2);

        criterion3.criterionName = "Максимальний час відгуку системи";
        criterion3.rate = 0.08;
        criterion3.criterionNum = 3;
        criterion3.criterionValues.addAll(List.of("0.1с", "0.3с", "0.5с"));
        alternative.add(criterion3);

        criterion4.criterionName = "Вартість";
        criterion4.rate = 0.13;
        criterion4.criterionNum = 4;
        criterion4.criterionValues.addAll(List.of("5000 у.о", "10000 у.о", "15000 у.о", "20000 у.о"));
        alternative.add(criterion4);

        criterion5.criterionName = "Відмовостійкість";
        criterion5.rate = 0.12;
        criterion5.criterionNum = 5;
        criterion5.criterionValues.addAll(List.of("99.9%"));
        alternative.add(criterion5);

        return alternative;
    }
}