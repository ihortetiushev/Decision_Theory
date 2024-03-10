import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Criterion> all = CriterionInit.initialize();
        List<Criterion> toAnalyze = new ArrayList<>();
        toAnalyze.add(all.get(1));
        toAnalyze.add(all.get(5));
        toAnalyze.add(all.get(6));
        System.out.println("Завдання 4");

        // Печать всех комбинаций критериев

        System.out.println("Задані критерії: ");
        printAnalyzeCriterion(toAnalyze);
        System.out.println();
        List<List<ValueIndex>> allCombinations = getAllCombinations(toAnalyze);

        print(allCombinations, "Таблиця альтернатив");

        System.out.println();
        System.out.println("Завдання 5");
        System.out.println("Кількість гіпотетично можливих альтернатив: " + allCombinations.size());
        alternativesNum(toAnalyze);

        System.out.println();
        System.out.println("Завдання 6");
        System.out.println("Найкраща альтернатива: " + allCombinations.get(0));
        System.out.println("Найгірша альтернатива: " + allCombinations.get(allCombinations.size()-1));
        System.out.println();

        System.out.println("Завдання 7");
        List<ValueIndex> middle = findMiddle(allCombinations);
        System.out.println("Вибрана альтернатива: " + middle);

        System.out.println();
        List<List<ValueIndex>> betterOrSame = getBetter(allCombinations, middle);
        print(betterOrSame, "Кращі");

        System.out.println();
        List<List<ValueIndex>> worse = getWorse(allCombinations, middle);
        print(worse, "Гірші");


        System.out.println();
        List<List<ValueIndex>> others = getOthers(allCombinations, betterOrSame, worse, middle);
        print(others, "Не порівняні");

        int counterBetter = betterOrSame.size();
        int counterWorst = worse.size();
        int counterNotComparable = others.size();
        int totalNumberAlternatives = counterBetter + counterWorst + counterNotComparable + 1;
        System.out.println();
        System.out.println("Кількість кращих: " + counterBetter);
        System.out.println("Кількість гірших: " + counterWorst);
        System.out.println("Кількість не порівняних: " + counterNotComparable);
        System.out.println("Загальна кількість альтернатив: " + counterBetter + " + " + counterWorst +
                " + "+ counterNotComparable + " + 1 = " + totalNumberAlternatives);
        System.out.println("Кількість гіпотетично можливих альтернатив: " + allCombinations.size());
        System.out.println("Загальна кількість альтернатив дорівнює кількості гіпотетично можливих альтернатив");
    }

    public static void printAnalyzeCriterion(List<Criterion> toAnalyze){
        for (Criterion criterion : toAnalyze) {
            System.out.println(criterion);
        }
    }
    public static void alternativesNum(List<Criterion> toAnalyze){
        int size = toAnalyze.size();
        int alternativesNum = 1;
        for (int i = 0; i < size; i++) {
            Criterion criterion = toAnalyze.get(i);
            alternativesNum *= criterion.criterionValues.size();
            System.out.print(criterion.criterionValues.size());

            if (i < size - 1) {
                System.out.print(" * ");
            }
            if(i == size - 1) {
                System.out.println(" = " + alternativesNum);
            }
        }
    }

    private static void print(List<List<ValueIndex>> list, String header) {
        System.out.println(header);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + 1 + " ");
            List<ValueIndex> row = list.get(i);
            System.out.print("{");
            for(int n = 0; n < row.size(); n++) {
                ValueIndex obj = row.get(n);
                System.out.print("(k = " + obj.criterionNum + (obj.index + 1) + ")" + " \"" + obj.value + "\"; ");
            }
            System.out.println("}");
           // System.out.println(row);
        }
    }

    static List<ValueIndex> findMiddle(List<List<ValueIndex>> list) {
        int numberOfCriterion = list.get(0).size();//all supposed to be of the same size
        List<Integer> max = new ArrayList<>(numberOfCriterion);//all supposed to be of the same size
        //initialize max with all 0
        for (int i = 0; i < numberOfCriterion; i++) {
            max.add(i, 0);
        }
        for (List<ValueIndex> item : list) {
            //finding max for each criterion value
            for (int i = 0; i < numberOfCriterion; i++) {
                if (item.get(i).index >= max.get(i)) {
                    max.set(i, item.get(i).index);
                }
            }
        }
        List<Integer> middles = new ArrayList<>(numberOfCriterion);
        for (int i = 0; i < numberOfCriterion; i++) {
            middles.add(i, new BigDecimal(max.get(i)).divide(BigDecimal.TWO, RoundingMode.HALF_UP).intValue());
        }
        return list.stream().filter(item -> {
            boolean same = true;
            for (int i = 0; i < numberOfCriterion; i++) {
                same = middles.get(i) == item.get(i).index;
                if (!same) {
                    break;
                }
            }
            return same;
        }).findFirst().orElseThrow();
    }

    static List<List<ValueIndex>> getBetter(List<List<ValueIndex>> list, List<ValueIndex> toCompare) {
        List<List<ValueIndex>> betterOrSameList = new ArrayList<>();
        for (List<ValueIndex> current : list) {
            List<Integer> comparison = ValueIndex.compare(current, toCompare);
            if (ValueIndex.isBetterOrSame(comparison)) {
                betterOrSameList.add(current);
            }
        }
        betterOrSameList.remove(toCompare);
        return betterOrSameList;
    }

    static List<List<ValueIndex>> getWorse(List<List<ValueIndex>> list, List<ValueIndex> toCompare) {
        List<List<ValueIndex>> worseList = new ArrayList<>();
        for (List<ValueIndex> current : list) {
            List<Integer> comparison = ValueIndex.compare(current, toCompare);
            if (ValueIndex.isWorse(comparison)) {
                worseList.add(current);
            }
        }
        return worseList;
    }

    static List<List<ValueIndex>> getOthers(List<List<ValueIndex>> allList, List<List<ValueIndex>> betterList,
                             List<List<ValueIndex>> worstList, List<ValueIndex> middle) {
        List<List<ValueIndex>> others = new ArrayList<>(allList.size());
        others.addAll(allList);
        others.removeAll(betterList);
        others.removeAll(worstList);
        others.remove(middle);
        return others;
    }

    public static List<List<ValueIndex>> getAllCombinations(List<Criterion> criteria) {
        List<List<ValueIndex>> allCombinations = new ArrayList<>();
        generateCombinations(criteria, 0, new ArrayList<>(), allCombinations);
        return allCombinations;
    }

    private static void generateCombinations(List<Criterion> objects, int index, List<ValueIndex> currentCombination, List<List<ValueIndex>> allCombinations) {
        if (index == objects.size()) {
            allCombinations.add(new ArrayList<>(currentCombination));
            return;
        }

        List<String> criteria = objects.get(index).criterionValues;
        for (int i = 0; i < criteria.size(); i++) {
            currentCombination.add(new ValueIndex(objects.get(index).criterionNum, i, criteria.get(i)));
            generateCombinations(objects, index + 1, currentCombination, allCombinations);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}