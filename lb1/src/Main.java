import javax.sound.sampled.Line;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public void dominanceGraph(Criterion one, Criterion two) {

        Alternative[][] oneAlternative= new Alternative[one.criterionValue.size()][two.criterionValue.size()];
        System.out.println(one);
        System.out.println(two);
        System.out.println();
        for(int i = 0; i < one.criterionValue.size(); i++) {

            for(int j = 0; j < two.criterionValue.size(); j++) {
                Alternative field = new Alternative();
                oneAlternative[i][j] = field;
                field.index_k1 = i+1;
                field.index_k2 = j+1;
                field.criterionValue1 = one.criterionValue.get(i);
                field.criterionValue2 = two.criterionValue.get(j);
            }
        }
        for(int i = 0; i < one.criterionValue.size(); i++) {
            for(int j = 0; j < two.criterionValue.size(); j++) {

                Alternative alternative = oneAlternative[i][j];
                String formattedString = String.format("%-50s","(k" + Alternative.k1 + "" + alternative.index_k1
                        +", k" +Alternative.k2 + alternative.index_k2 +") " + alternative + ";  ");


                System.out.print(formattedString);
            }
            System.out.println();
        }

        //Завдання 5
        System.out.println();
        int multiplication;
        multiplication = two.criterionValue.size() * one.criterionValue.size();
        System.out.println("Завдання 5:");
        System.out.println("Кількість гіпотетично можливих альтернатив: "
                + one.criterionValue.size() + "*" +two.criterionValue.size() + "=" + multiplication);
        System.out.println();

//Завдання 6
        System.out.println("Завдання 6:");
        System.out.println("Найкраща альтернатива: " + "(k" + Alternative.k1 + ""
                + oneAlternative[0][0].index_k1 + ", k" +Alternative.k2
                + oneAlternative[0][0].index_k2 +") "+ oneAlternative[0][0]);

        Alternative worstObject = oneAlternative[one.criterionValue.size()-1] [two.criterionValue.size()-1];
        System.out.println("Найгірша альтернатива: "+ "(k" + Alternative.k1 + ""
                + worstObject.index_k1 + ", k" +Alternative.k2
                + worstObject.index_k2 +") " + oneAlternative[one.criterionValue.size()-1]
                [two.criterionValue.size()-1]);


        System.out.println();

        //Завдання 7
        System.out.println("Завдання 7:");
        BigDecimal average_k1 = new BigDecimal(one.criterionValue.size()).divide(BigDecimal.TWO, RoundingMode.HALF_UP);
        BigDecimal average_k2 = new BigDecimal(two.criterionValue.size()).divide(BigDecimal.TWO, RoundingMode.HALF_UP);
        int average_index_k1 = average_k1.intValue();
        int average_index_k2 = average_k2.intValue();

        Alternative midAlternative = null;

        for (int i = 0; i < one.criterionValue.size(); i++) {
            for (int j = 0; j < two.criterionValue.size(); j++) {
                //alternative = oneAlternative[i][j];
                Alternative alternative = oneAlternative[i][j];
                boolean found = alternative.index_k1 == average_index_k1 && alternative.index_k2 == average_index_k2;

                if (found) {
                    midAlternative = alternative;
                    System.out.println("----------------------------------------");
                }

                System.out.println("(k" + Alternative.k1 + "" + alternative.index_k1
                        +", k" +Alternative.k2 + alternative.index_k2 +") " + alternative);

                if (found) {
                    System.out.println("----------------------------------------");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Множина альтернатив, краще ніж: " + "(k" + Alternative.k1 + "" + midAlternative.index_k1
                +", k" + Alternative.k2 + midAlternative.index_k2 +") {'" + midAlternative.criterionValue1 +" "
                + midAlternative.criterionValue2 + "'}");


        //Налагодити автоматичне визначення, які альтернативи КРАЩІ, ГІРШІ
        boolean output = false;
        int counterBetter = 0;
        int counterWorst = 0;
        for (int i = 0; i < one.criterionValue.size(); i++) {
            for (int j = 0; j < two.criterionValue.size(); j++) {
                Alternative alternative = oneAlternative[i][j];
                if(alternative == midAlternative) {
                    continue;
                }
                if (alternative.index_k1 <= average_index_k1 && alternative.index_k2 <= average_index_k2) {
                    counterBetter++;
                    System.out.println("(k" + Alternative.k1 + "" + alternative.index_k1
                            +", k" +Alternative.k2 + alternative.index_k2 +") " + alternative + ";  ");
                }

                if (alternative.index_k1 >= average_index_k1 && alternative.index_k2 >= average_index_k2) {
                    if(!output) {
                        System.out.println();
                        System.out.println("Множина альтернатив, гірше ніж: " + "(k" + Alternative.k1 + "" + midAlternative.index_k1
                                +", k" + Alternative.k2 + midAlternative.index_k2 +") {'" + midAlternative.criterionValue1 +" "
                                + midAlternative.criterionValue2 + "'}");
                        output = true;
                    }
                    counterWorst++;
                    System.out.println("(k" + Alternative.k1 + "" + alternative.index_k1
                            +", k" +Alternative.k2 + alternative.index_k2 +") " + alternative + ";  ");

                }
            }
        }
        //Налагодити автоматичне визначення, НЕ ПОРІВНЯНІ
        int counterNotComparable = 0;
        System.out.println();
        System.out.println("Множина альтернатив, не порівняних з: " + "(k" + Alternative.k1 + "" + midAlternative.index_k1
                +", k" + Alternative.k2 + midAlternative.index_k2 +") {'" + midAlternative.criterionValue1 +" "
                + midAlternative.criterionValue2 + "'}");

        for (int i = 0; i < one.criterionValue.size(); i++) {
            for (int j = 0; j < two.criterionValue.size(); j++) {
                Alternative alternative = oneAlternative[i][j];

                if((alternative.index_k1 < average_index_k1 && alternative.index_k2 > average_index_k2)) {
                    counterNotComparable++;
                    System.out.println("(k" + Alternative.k1 + "" + alternative.index_k1
                            +", k" +Alternative.k2 + alternative.index_k2 +") " + alternative + ";  ");
                }
                if((alternative.index_k1 > average_index_k1 && alternative.index_k2 < average_index_k2)) {
                    counterNotComparable++;
                    System.out.println("(k" + Alternative.k1 + "" + alternative.index_k1
                            +", k" +Alternative.k2 + alternative.index_k2 +") " + alternative + ";  ");
                }
            }
        }

        //Автоматичний підрахунок
        System.out.println();
        System.out.println("Кількість кращих: " + counterBetter);
        System.out.println("Кількість гірших: " + counterWorst);
        System.out.println("Кількість не порівняних: " + counterNotComparable);

        int totalNumberAlternatives;
        totalNumberAlternatives = counterBetter + counterWorst + counterNotComparable + 1;
        System.out.println();
        System.out.println("Загальна кількість альтернатив: " + counterBetter +
                "+" + counterWorst + "+" + counterNotComparable + "+" +"1" + "=" + totalNumberAlternatives);
        System.out.println("Кількість гіпотетично можливих альтернатив: " + multiplication);
    }

    public static void main(String[] args) {

        Main program = new Main();
        CriterionInit criterion = new CriterionInit();
        criterion.setCriterion();
        System.out.println("Завдання 4:");
        System.out.println();
        program.dominanceGraph(criterion.alternative.get(0), criterion.alternative.get(1));

    }
}