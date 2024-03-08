import java.util.ArrayList;
import java.util.List;

public class CriterionInit {
    List<Criterion> alternative = new ArrayList<>();
    public void setCriterion() {


        Criterion criterion1 = new Criterion();
        Criterion criterion2 = new Criterion();
        Criterion criterion3 = new Criterion();
        Criterion criterion4 = new Criterion();
        Criterion criterion5 = new Criterion();
        Criterion criterion6 = new Criterion();
        Criterion criterion7 = new Criterion();
        Criterion criterion8 = new Criterion();
        Criterion criterion9 = new Criterion();
        Criterion criterion10 = new Criterion();

        criterion1.criterionName = "Підтримка";
        criterion1.rate = 0.14;
        criterion1.criterionValue.addAll(List.of("цілодобова", "у робочий час", "відсутня"));
        alternative.add(criterion1);


        criterion2.criterionName = "Вартість";
        criterion2.rate = 0.13;
        criterion2.criterionValue.addAll(List.of("5000 у.о", "10000 у.о", "15000 у.о",  "20000 у.о"));
        alternative.add(criterion2);


        criterion3.criterionName = "Використання хмарних сервісів";
        criterion3.rate = 0.13;
        criterion3.criterionValue.addAll(List.of("повне використання", "часткове використання",
                "не використовуються"));
        alternative.add(criterion3);



        criterion4.criterionName = "Ступінь автоматизації масштабування";
        criterion4.rate = 0.13;
        criterion4.criterionValue.addAll(List.of("повна", "часткова", "відсутня"));
        alternative.add(criterion4);


        criterion5.criterionName = "Відмовостійкість";
        criterion5.rate = 0.12;
        criterion5.criterionValue.addAll(List.of("99.9%", "95%", "N/A"));
        alternative.add(criterion5);


        criterion6.criterionName = "Кібербезпека";
        criterion6.rate = 0.1;
        criterion6.criterionValue.addAll(List.of("максимальний захист"
                , "основний захист", "мінімальний захист"));
        alternative.add(criterion6);


        criterion7.criterionName = "Максимальний час відгуку системи";
        criterion7.rate = 0.08;
        criterion7.criterionValue.addAll(List.of("0.1 с", "0.3с", "0.5 с", "0.8с", "1.2 с"));
        alternative.add(criterion7);


        criterion8.criterionName = "Максимальна кількість користувачів одночасно";
        criterion8.rate = 0.07;
        criterion8.criterionValue.addAll(List.of("150 000", "70000", "25 000", "1000"));
        alternative.add(criterion9);


        criterion9.criterionName = "Аналітика";
        criterion9.rate = 0.06;
        criterion9.criterionValue.addAll(List.of("аналітика за будь-яким параметром системи масштабування"
                , "аналітика за основними параметрами системи масштабування", "відсутня"));
        alternative.add(criterion9);


        criterion10.criterionName = "Моніторинг";
        criterion10.rate = 0.04;
        criterion10.criterionValue.addAll(List.of("постійний"
                , "нотифікація перевищення порогових значень", "відсутній"));
        alternative.add(criterion10);
    }
}
