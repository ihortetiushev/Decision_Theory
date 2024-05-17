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

        alternative1.alternativeName = "A";
        alternative1.criterionValue.add(Map.entry(criteria.get(0), 1));
        alternative1.criterionValue.add(Map.entry(criteria.get(1), 2));
        alternative1.criterionValue.add(Map.entry(criteria.get(2), 0));
        alternative1.criterionValue.add(Map.entry(criteria.get(3), 1));
        alternative1.criterionValue.add(Map.entry(criteria.get(4), 2));
        alternatives.add(alternative1);

        alternative2.alternativeName = "B";
        alternative2.criterionValue.add(Map.entry(criteria.get(0), 2));
        alternative2.criterionValue.add(Map.entry(criteria.get(1), 0));
        alternative2.criterionValue.add(Map.entry(criteria.get(2), 3));
        alternative2.criterionValue.add(Map.entry(criteria.get(3), 0));
        alternative2.criterionValue.add(Map.entry(criteria.get(4), 1));
        alternatives.add(alternative2);

        alternative3.alternativeName = "C";
        alternative3.criterionValue.add(Map.entry(criteria.get(0), 0));
        alternative3.criterionValue.add(Map.entry(criteria.get(1), 3));
        alternative3.criterionValue.add(Map.entry(criteria.get(2), 2));
        alternative3.criterionValue.add(Map.entry(criteria.get(3), 3));
        alternative3.criterionValue.add(Map.entry(criteria.get(4), 2));
        alternatives.add(alternative3);

        alternative4.alternativeName = "D";
        alternative4.criterionValue.add(Map.entry(criteria.get(0), 3));
        alternative4.criterionValue.add(Map.entry(criteria.get(1), 2));
        alternative4.criterionValue.add(Map.entry(criteria.get(2), 0));
        alternative4.criterionValue.add(Map.entry(criteria.get(3), 0));
        alternative4.criterionValue.add(Map.entry(criteria.get(4), 0));
        alternatives.add(alternative4);

        alternative5.alternativeName = "E";
        alternative5.criterionValue.add(Map.entry(criteria.get(0), 1));
        alternative5.criterionValue.add(Map.entry(criteria.get(1), 1));
        alternative5.criterionValue.add(Map.entry(criteria.get(2), 0));
        alternative5.criterionValue.add(Map.entry(criteria.get(3), 2));
        alternative5.criterionValue.add(Map.entry(criteria.get(4), 1));
        alternatives.add(alternative5);

        alternative6.alternativeName = "F";
        alternative6.criterionValue.add(Map.entry(criteria.get(0), 2));
        alternative6.criterionValue.add(Map.entry(criteria.get(1), 0));
        alternative6.criterionValue.add(Map.entry(criteria.get(2), 0));
        alternative6.criterionValue.add(Map.entry(criteria.get(3), 1));
        alternative6.criterionValue.add(Map.entry(criteria.get(4), 2));
        alternatives.add(alternative6);

        return alternatives;
    }
}
