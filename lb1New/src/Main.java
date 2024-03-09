import javax.script.Bindings;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Criterion> all = CriterionInit.initialize();
        List<Criterion> toAnalyze = new ArrayList<>();
        toAnalyze.add(all.get(2));
        toAnalyze.add(all.get(4));
        toAnalyze.add(all.get(6));

        // Печать всех комбинаций критериев
        List<List<ValueIndex>> allCombinations = getAllCombinations(toAnalyze);

        print(allCombinations, "All combinations");

        System.out.println("Total: " + allCombinations.size());


        List<ValueIndex> middle = findMiddle(allCombinations);

        System.out.println("middle: " + middle);

        List<List<ValueIndex>> betterOrSame = getBetterOrSame(allCombinations, middle);
        print(betterOrSame, "Better or Same");

        List<List<ValueIndex>> worse = getWorse(allCombinations, middle);
        print(worse, "Worse");


        List<List<ValueIndex>> others = getOthers(allCombinations, betterOrSame, worse);
        print(others, "Others");

    }

    private static void print(List<List<ValueIndex>> list, String header) {
        System.out.println(header);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + 1 + " ");
            System.out.println(list.get(i));
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

    static List<List<ValueIndex>> getBetterOrSame(List<List<ValueIndex>> list, List<ValueIndex> toCompare) {
        List<List<ValueIndex>> betterOrSameList = new ArrayList<>();
        for (List<ValueIndex> current : list) {
            List<Integer> comparison = ValueIndex.compare(current, toCompare);
            if (ValueIndex.isBetterOrSame(comparison)) {
                betterOrSameList.add(current);
            }
        }
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

    static List<List<ValueIndex>> getOthers(List<List<ValueIndex>> allList, List<List<ValueIndex>> betterList, List<List<ValueIndex>> worstList) {
        List<List<ValueIndex>> others = new ArrayList<>(allList.size());
        others.addAll(allList);
        others.removeAll(betterList);
        others.removeAll(worstList);
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
            currentCombination.add(new ValueIndex(i, criteria.get(i)));
            generateCombinations(objects, index + 1, currentCombination, allCombinations);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}