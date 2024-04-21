import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


public class Main {
    final static String FIRST_QUESTION = "FIRST_QUESTION   Choose more important criterion (1 or 2). 2111 (1), 1211 (2))";
    final static String SECOND_QUESTION = "SECOND_QUESTION   Choose more important criterion (1 or 2). 3111 (1), 1311 (2))";
    final static String THIRD_QUESTION = "THIRD_QUESTION   Choose more important criterion (1 or 2). 4111 (1), 1411 (2))";


    final static String FORTH_QUESTION = "FORTH_QUESTION   Choose more important criterion (1 or 2). 2111 (1), 1121 (2))";
    final static String FIFTH_QUESTION = "FIFTH_QUESTION   Choose more important criterion (1 or 2). 3111 (1), 1131 (2))";
    final static String SIXTH_QUESTION = "SIXTH_QUESTION   Choose more important criterion (1 or 2). 4111 (1), 1141 (2))";


    final static String SEVENTH_QUESTION = "SEVENTH_QUESTION   Choose more important criterion (1 or 2). 2111 (1), 1112 (2))";
    final static String EIGHT_QUESTION = "EIGHT_QUESTION   Choose more important criterion (1 or 2). 3111 (1), 1113 (2))";
    final static String NINTH_QUESTION = "NINTH_QUESTION   Choose more important criterion (1 or 2). 4111 (1), 1114 (2))";


    final static String TENTH_QUESTION = "TENTH_QUESTION   Choose more important criterion (1 or 2). 2111 (1), 1112 (2))";
    final static String ELEVENTH_QUESTION = "ELEVENTH_QUESTION   Choose more important criterion (1 or 2). 3111 (1), 1113 (2))";
    final static String TWELFTH_QUESTION = "TWELFTH_QUESTION   Choose more important criterion (1 or 2). 4111 (1), 1114 (2))";

    final static String THIRTEENTH_QUESTION = "THIRTEENTH_QUESTION   Choose more important criterion (1 or 2). 2111 (1), 1112 (2))";
    final static String FOURTEENTH_QUESTION = "FOURTEENTH_QUESTION   Choose more important criterion (1 or 2). 3111 (1), 1113 (2))";
    final static String FIFTEENTH_QUESTION = "FIFTEENTH_QUESTION   Choose more important criterion (1 or 2). 4111 (1), 1114 (2))";
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        List<Criterion> all = CriterionInit.initialize();
        List<Criterion> toAnalyze = new ArrayList<>();
        toAnalyze.add(all.get(0));
        toAnalyze.add(all.get(1));
        toAnalyze.add(all.get(2));
        toAnalyze.add(all.get(3));

        // Печать всех комбинаций критериев

        System.out.println("Задані критерії: ");
        printAnalyzeCriterion(toAnalyze);
        System.out.println();
        List<List<ValueIndex>> allCombinations = getAllCombinations(toAnalyze);
        System.out.println("Завдання 2");
        int n = 4;
        int  N = n*(n-1)/2;
        System.out.println("N = " + N+ ", Кількість попарних порівнянь дорінює " + N);
        System.out.println();

        System.out.println("Завдання 3:");
        System.out.println("Множина альтернатив першої опорної ситуації");
        System.out.println("  " + "К1\tК2\t\tК3\t\tK4");

        List<Alternative> column1 = new ArrayList<>();
        List<Alternative> column2 = new ArrayList<>();
        List<Alternative> column3 = new ArrayList<>();
        List<Alternative> column4 = new ArrayList<>();


        for(int i = 1; i <= 4; i++) {
            column1.add(new Alternative(i,1,1,1));
            column2.add(new Alternative(1,i,1,1));
            column3.add(new Alternative(1,1,i,1));
            column4.add(new Alternative(1,1,1,i));
        }

        for(int i = 0; i < 4; i++) {
            System.out.print(column1.get(i) + " " );
            System.out.print(column2.get(i) + " " );
            System.out.print(column3.get(i) + " " );
            System.out.print(column4.get(i) + " " );
            System.out.println();
        }

        System.out.println();
        System.out.println("Завдання 4:");
        System.out.println("Пари критеріїв, що будуть надалі порівнюватися:");
        System.out.println("К1+K2\tК1+K3\tK1+K4\tK2+К3\tK2+K4\tK3+K4");
        System.out.println();

        List<Alternative> k1k2Path = findPathForK1K2(column1, column2);
        System.out.println(k1k2Path);
        System.out.println();

        List<Alternative> k1k3Path = findPathForK1K3(column1, column3);
        System.out.println(k1k3Path);
        System.out.println();

        List<Alternative> k1k4Path = findPathForK1K4(column1, column4);
        System.out.println(k1k4Path);
        System.out.println();

        List<Alternative> k2k3Path = findPathForK2K3(column2, column3);
        System.out.println(k2k3Path);
        System.out.println();

        List<Alternative> k2k4Path = findPathForK2K3(column2, column4);
        System.out.println(k2k4Path);
        System.out.println();
    }

    public static List<Alternative> findPathForK2K4(List<Alternative> columnTwo, List<Alternative> columnForth) {
        List<Alternative> k2k4Path = new ArrayList<>();
        k2k4Path.add(columnTwo.get(0));
        if(questionToOPR(THIRTEENTH_QUESTION) == true){
            k2k4Path.add(columnTwo.get(1));
            k2k4Path.add(columnForth.get(1));
        }
        else {

            k2k4Path.add(columnForth.get(1));
            k2k4Path.add(columnTwo.get(1));
        }
        if(questionToOPR(FOURTEENTH_QUESTION) == true){
            k2k4Path.add(columnTwo.get(2));
            k2k4Path.add(columnForth.get(2));
        }
        else {
            k2k4Path.add(columnForth.get(2));
            k2k4Path.add(columnTwo.get(2));
        }
        if(questionToOPR(FIFTEENTH_QUESTION) == true){
            k2k4Path.add(columnTwo.get(3));
            k2k4Path.add(columnForth.get(3));
        }
        else {
            k2k4Path.add(columnForth.get(3));
            k2k4Path.add(columnTwo.get(3));
        }
        return k2k4Path;
    }

    public static List<Alternative> findPathForK2K3(List<Alternative> columnTwo, List<Alternative> columnThree) {
        List<Alternative> k2k3Path = new ArrayList<>();
        k2k3Path.add(columnTwo.get(0));
        if(questionToOPR(TENTH_QUESTION) == true){
            k2k3Path.add(columnTwo.get(1));
            k2k3Path.add(columnThree.get(1));
        }
        else {

            k2k3Path.add(columnThree.get(1));
            k2k3Path.add(columnTwo.get(1));
        }
        if(questionToOPR(ELEVENTH_QUESTION) == true){
            k2k3Path.add(columnTwo.get(2));
            k2k3Path.add(columnThree.get(2));
        }
        else {
            k2k3Path.add(columnThree.get(2));
            k2k3Path.add(columnTwo.get(2));
        }
        if(questionToOPR(TWELFTH_QUESTION) == true){
            k2k3Path.add(columnTwo.get(3));
            k2k3Path.add(columnThree.get(3));
        }
        else {
            k2k3Path.add(columnThree.get(3));
            k2k3Path.add(columnTwo.get(3));
        }
        return k2k3Path;
    }

    public static List<Alternative> findPathForK1K4(List<Alternative> columnOne, List<Alternative> columnForth) {
        List<Alternative> k1k4Path = new ArrayList<>();
        k1k4Path.add(columnOne.get(0));
        if(questionToOPR(SEVENTH_QUESTION) == true){
            k1k4Path.add(columnOne.get(1));
            k1k4Path.add(columnForth.get(1));
        }
        else {
            k1k4Path.add(columnForth.get(1));
            k1k4Path.add(columnOne.get(1));
        }
        if(questionToOPR(EIGHT_QUESTION) == true){
            k1k4Path.add(columnOne.get(2));
            k1k4Path.add(columnForth.get(2));
        }
        else {
            k1k4Path.add(columnForth.get(2));
            k1k4Path.add(columnOne.get(2));
        }
        if(questionToOPR(NINTH_QUESTION) == true){
            k1k4Path.add(columnOne.get(3));
            k1k4Path.add(columnForth.get(3));
        }
        else {
            k1k4Path.add(columnForth.get(3));
            k1k4Path.add(columnOne.get(3));
        }
        return k1k4Path;
    }


    public static List<Alternative> findPathForK1K3(List<Alternative> columnOne, List<Alternative> columnThree) {
        List<Alternative> k1k3Path = new ArrayList<>();
        k1k3Path.add(columnOne.get(0));
        if(questionToOPR(FORTH_QUESTION) == true){
            k1k3Path.add(columnOne.get(1));
            k1k3Path.add(columnThree.get(1));
        }
        else {
            k1k3Path.add(columnThree.get(1));
            k1k3Path.add(columnOne.get(1));
        }
        if(questionToOPR(FIFTH_QUESTION) == true){
            k1k3Path.add(columnOne.get(2));
            k1k3Path.add(columnThree.get(2));
        }
        else {
            k1k3Path.add(columnThree.get(2));
            k1k3Path.add(columnOne.get(2));
        }
        if(questionToOPR(SIXTH_QUESTION) == true){
            k1k3Path.add(columnOne.get(3));
            k1k3Path.add(columnThree.get(3));
        }
        else {
            k1k3Path.add(columnThree.get(3));
            k1k3Path.add(columnOne.get(3));
        }
        return k1k3Path;
    }


    public static List<Alternative> findPathForK1K2(List<Alternative> columnOne, List<Alternative> columnTwo) {
        List<Alternative> k1k2Path = new ArrayList<>();
        k1k2Path.add(columnOne.get(0));
        if(questionToOPR(FIRST_QUESTION) == true){
            k1k2Path.add(columnOne.get(1));
            k1k2Path.add(columnTwo.get(1));
        }
        else {
            k1k2Path.add(columnTwo.get(1));
            k1k2Path.add(columnOne.get(1));
        }
        if(questionToOPR(SECOND_QUESTION) == true){
            k1k2Path.add(columnOne.get(2));
            k1k2Path.add(columnTwo.get(2));
        }
        else {
            k1k2Path.add(columnTwo.get(2));
            k1k2Path.add(columnOne.get(2));
        }
        if(questionToOPR(THIRD_QUESTION) == true){
            k1k2Path.add(columnOne.get(3));
            k1k2Path.add(columnTwo.get(3));
        }
        else {
            k1k2Path.add(columnTwo.get(3));
            k1k2Path.add(columnOne.get(3));
        }
        return k1k2Path;
    }
    public static boolean questionToOPR (String question) {
        Scanner OPR_answer = new Scanner(System.in);
        System.out.println(question);
        String answer;
        boolean wrongInput;
        do {
            answer = OPR_answer.nextLine();
            wrongInput = !(answer.equals("2") || answer.equals("1"));
            if(wrongInput) {
                System.out.println("Wrong input, try again");
            }
        }
        while(wrongInput);
        return answer.equals("1");
    }
    /*public static List<Alternative> findPath(List<Alternative> criterion1, List<Alternative> criterion2,
                                             String method1, String method2) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Scanner OPRanswer = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter yes if ");

        String userName = myObj.nextLine();  // Read user input
        System.out.println("Username is: " + userName);  // Output user input



        Method getK = criterion1.get(0).getClass().getMethod(method1);
        Integer k = (Integer) getK.invoke(criterion1.get(0));
        Method getK2 = criterion2.get(0).getClass().getMethod(method2);
        Integer k2 = (Integer) getK.invoke(criterion2.get(0));
        return null;
    }*/


    public static String fixedLengthString(String string, int length) {
        return String.format("%1$" + length + "s", string);
    }

    public static void printAnalyzeCriterion(List<Criterion> toAnalyze) {
        for (Criterion criterion : toAnalyze) {
            System.out.println(criterion);
        }
    }

    public static void alternativesNum(List<Criterion> toAnalyze) {
        int size = toAnalyze.size();
        int alternativesNum = 1;
        for (int i = 0; i < size; i++) {
            Criterion criterion = toAnalyze.get(i);
            alternativesNum *= criterion.criterionValues.size();
            System.out.print(criterion.criterionValues.size());

            if (i < size - 1) {
                System.out.print(" * ");
            }
            if (i == size - 1) {
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
            for (int n = 0; n < row.size(); n++) {
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