import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AlternativeInit {
    public static List<Alternative> initializeAlternative(List<Criterion> criteria) {
        List<Alternative> alternatives = new ArrayList<>();
        Alternative alternative1 = new Alternative();
        Alternative alternative2 = new Alternative();
        Alternative alternative3 = new Alternative();
        Alternative alternative4 = new Alternative();
        Alternative alternative5 = new Alternative();
        Alternative alternative6 = new Alternative();
        Alternative alternative7 = new Alternative();

        alternative1.alternativeNum = 1;
        alternative1.criterionValue.add(Map.entry(criteria.get(0), 1));
        alternative1.criterionValue.add(Map.entry(criteria.get(1), 2));
        alternative1.criterionValue.add(Map.entry(criteria.get(2), 0));
        alternative1.criterionValue.add(Map.entry(criteria.get(3), 1));
        alternative1.criterionValue.add(Map.entry(criteria.get(4), 2));
        alternatives.add(alternative1);

        alternative2.alternativeNum = 2;
        alternative2.criterionValue.add(Map.entry(criteria.get(0), 2));
        alternative2.criterionValue.add(Map.entry(criteria.get(1), 0));
        alternative2.criterionValue.add(Map.entry(criteria.get(2), 3));
        alternative2.criterionValue.add(Map.entry(criteria.get(3), 0));
        alternative2.criterionValue.add(Map.entry(criteria.get(4), 1));
        alternatives.add(alternative2);

        alternative3.alternativeNum = 3;
        alternative3.criterionValue.add(Map.entry(criteria.get(0), 0));
        alternative3.criterionValue.add(Map.entry(criteria.get(1), 3));
        alternative3.criterionValue.add(Map.entry(criteria.get(2), 2));
        alternative3.criterionValue.add(Map.entry(criteria.get(3), 3));
        alternative3.criterionValue.add(Map.entry(criteria.get(4), 2));
        alternatives.add(alternative3);

        alternative4.alternativeNum = 4;
        alternative4.criterionValue.add(Map.entry(criteria.get(0), 3));
        alternative4.criterionValue.add(Map.entry(criteria.get(1), 2));
        alternative4.criterionValue.add(Map.entry(criteria.get(2), 0));
        alternative4.criterionValue.add(Map.entry(criteria.get(3), 0));
        alternative4.criterionValue.add(Map.entry(criteria.get(4), 0));
        alternatives.add(alternative4);

        alternative5.alternativeNum = 5;
        alternative5.criterionValue.add(Map.entry(criteria.get(0), 2));
        alternative5.criterionValue.add(Map.entry(criteria.get(1), 0));
        alternative5.criterionValue.add(Map.entry(criteria.get(2), 2));
        alternative5.criterionValue.add(Map.entry(criteria.get(3), 1));
        alternative5.criterionValue.add(Map.entry(criteria.get(4), 0));
        alternatives.add(alternative5);

        alternative6.alternativeNum = 6;
        alternative6.criterionValue.add(Map.entry(criteria.get(0), 1));
        alternative6.criterionValue.add(Map.entry(criteria.get(1), 1));
        alternative6.criterionValue.add(Map.entry(criteria.get(2), 0));
        alternative6.criterionValue.add(Map.entry(criteria.get(3), 2));
        alternative6.criterionValue.add(Map.entry(criteria.get(4), 1));
        alternatives.add(alternative6);

        alternative7.alternativeNum = 7;
        alternative7.criterionValue.add(Map.entry(criteria.get(0), 2));
        alternative7.criterionValue.add(Map.entry(criteria.get(1), 0));
        alternative7.criterionValue.add(Map.entry(criteria.get(2), 0));
        alternative7.criterionValue.add(Map.entry(criteria.get(3), 1));
        alternative7.criterionValue.add(Map.entry(criteria.get(4), 2));
        alternatives.add(alternative7);

        return alternatives;

    }
}
