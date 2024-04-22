import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


public class Main {
    final static String FIRST_QUESTION = "First question   Choose more important criterion (1 or 2). 2111 (1), 1211 (2))";
    final static String SECOND_QUESTION = "Second question   Choose more important criterion (1 or 2). 3111 (1), 1311 (2))";
    final static String THIRD_QUESTION = "Third question   Choose more important criterion (1 or 2). 4111 (1), 1411 (2))";


    final static String FORTH_QUESTION = "Forth question   Choose more important criterion (1 or 2). 2111 (1), 1121 (2))";
    final static String FIFTH_QUESTION = "Fifth question   Choose more important criterion (1 or 2). 3111 (1), 1131 (2))";
    final static String SIXTH_QUESTION = "Sixth question   Choose more important criterion (1 or 2). 4111 (1), 1141 (2))";


    final static String SEVENTH_QUESTION = "Seventh question   Choose more important criterion (1 or 2). 2111 (1), 1112 (2))";
    final static String EIGHT_QUESTION = "Eighth question   Choose more important criterion (1 or 2). 3111 (1), 1113 (2))";
    final static String NINTH_QUESTION = "Ninth question   Choose more important criterion (1 or 2). 4111 (1), 1114 (2))";


    final static String TENTH_QUESTION = "Tenth question   Choose more important criterion (1 or 2). 1211 (1), 1121 (2))";
    final static String ELEVENTH_QUESTION = "Eleventh question   Choose more important criterion (1 or 2). 1311 (1), 1131 (2))";
    final static String TWELFTH_QUESTION = "Twelfth question   choose more important criterion (1 or 2). 1411 (1), 1141 (2))";

    final static String THIRTEENTH_QUESTION = "Thirteenth question   Choose more important criterion (1 or 2). 1211 (1), 1112 (2))";
    final static String FOURTEENTH_QUESTION = "Fourteenth question   Choose more important criterion (1 or 2). 1311 (1), 1113 (2))";
    final static String FIFTEENTH_QUESTION = "Fifteenth question   choose more important criterion (1 or 2). 1411 (1), 1114 (2))";

    final static String SIXTEENTH_QUESTION = "Sixteenth question   Choose more important criterion (1 or 2). 1121 (1), 1112 (2))";
    final static String SEVENTEEN_QUESTION = "Seventeen question   Choose more important criterion (1 or 2). 1131 (1), 1113 (2))";
    final static String EIGHTEEN_QUESTION = "Eighteen question   Choose more important criterion (1 or 2). 1141 (1), 1114 (2))";

    public static void main(String[] args) {

        List<Criterion> all = CriterionInit.initialize();
        List<Criterion> toAnalyze = new ArrayList<>();
        toAnalyze.add(all.get(0));
        toAnalyze.add(all.get(1));
        toAnalyze.add(all.get(2));
        toAnalyze.add(all.get(3));


        System.out.println("Задані критерії: ");
        printAnalyzeCriterion(toAnalyze);
        System.out.println();
        List<List<ValueIndex>> allCombinations = getAllCombinations(toAnalyze);
        System.out.println("Завдання 2");
        int n = 4;
        int N = n * (n - 1) / 2;
        System.out.println("N = " + N + ", Кількість попарних порівнянь дорінює " + N);
        System.out.println();

        System.out.println("Завдання 3:");
        System.out.println("Множина альтернатив першої опорної ситуації");
        System.out.println("  " + "К1\tК2\t\tК3\t\tK4");

        List<Alternative> column1 = new ArrayList<>();
        List<Alternative> column2 = new ArrayList<>();
        List<Alternative> column3 = new ArrayList<>();
        List<Alternative> column4 = new ArrayList<>();


        for (int i = 1; i <= 4; i++) {
            column1.add(new Alternative(i, 1, 1, 1));
            column2.add(new Alternative(1, i, 1, 1));
            column3.add(new Alternative(1, 1, i, 1));
            column4.add(new Alternative(1, 1, 1, i));
        }

        for (int i = 0; i < 4; i++) {
            System.out.print(column1.get(i) + " ");
            System.out.print(column2.get(i) + " ");
            System.out.print(column3.get(i) + " ");
            System.out.print(column4.get(i) + " ");
            System.out.println();
        }

        System.out.println();
        System.out.println("Завдання 4:");
        System.out.println("Пари критеріїв, що будуть надалі порівнюватися:");
        System.out.println("К1+K2\tК1+K3\tK1+K4\tK2+К3\tK2+K4\tK3+K4");
        System.out.println();

        System.out.println("Завдання 5:");
        System.out.println("Пара К1+K2:");
        List<Alternative> k1k2Path = findPathForK1K2(column1, column2);
        System.out.println(k1k2Path);
        System.out.println();

        System.out.println("Пара К1+K3:");
        List<Alternative> k1k3Path = findPathForK1K3(column1, column3);
        System.out.println(k1k3Path);
        System.out.println();

        System.out.println("Пара K1+K4:");
        List<Alternative> k1k4Path = findPathForK1K4(column1, column4);
        System.out.println(k1k4Path);
        System.out.println();

        System.out.println("Пара K2+К3:");
        List<Alternative> k2k3Path = findPathForK2K3(column2, column3);
        System.out.println(k2k3Path);
        System.out.println();

        System.out.println("Пара K2+K4");
        List<Alternative> k2k4Path = findPathForK2K4(column2, column4);
        System.out.println(k2k4Path);
        System.out.println();

        System.out.println("Пара K3+K4:");
        List<Alternative> k3k4Path = findPathForK3K4(column3, column4);
        System.out.println(k3k4Path);
        System.out.println();
        System.out.println();

        System.out.println("Ланцюжки:");
        System.out.println(k1k2Path);
        System.out.println(k1k3Path);
        System.out.println(k1k4Path);
        System.out.println(k2k3Path);
        System.out.println(k2k4Path);
        System.out.println(k3k4Path);

        List<List<Alternative>> allPath = new ArrayList<>();
        allPath.add(k1k2Path);
        allPath.add(k1k3Path);
        allPath.add(k1k4Path);
        allPath.add(k2k3Path);
        allPath.add(k2k4Path);
        allPath.add(k3k4Path);

        System.out.println();
        System.out.println("Єдина порядкова шкала: " + finalPath(allPath));
    }

    public static List<Alternative> finalPath(List<List<Alternative>> allPath) {
        List<Alternative> finalPath = new ArrayList<>();
        for (int i = 0; i < allPath.get(0).size(); i++) {
            for (int j = 0; j < allPath.size(); j++) {
                if (!finalPath.contains(allPath.get(j).get(i))) {
                    finalPath.add(allPath.get(j).get(i));
                }
            }
        }
        return finalPath;
    }

    public static List<Alternative> findPathForK3K4(List<Alternative> columnThree, List<Alternative> columnForth) {
        List<Alternative> k3k4Path = new ArrayList<>();
        k3k4Path.add(columnThree.get(0));
        if (questionToOPR(SIXTEENTH_QUESTION) == true) {
            k3k4Path.add(columnThree.get(1));
            k3k4Path.add(columnForth.get(1));
        } else {

            k3k4Path.add(columnForth.get(1));
            k3k4Path.add(columnThree.get(1));
        }
        if (questionToOPR(SEVENTEEN_QUESTION) == true) {
            k3k4Path.add(columnThree.get(2));
            k3k4Path.add(columnForth.get(2));
        } else {
            k3k4Path.add(columnForth.get(2));
            k3k4Path.add(columnThree.get(2));
        }
        if (questionToOPR(EIGHTEEN_QUESTION) == true) {
            k3k4Path.add(columnThree.get(3));
            k3k4Path.add(columnForth.get(3));
        } else {
            k3k4Path.add(columnForth.get(3));
            k3k4Path.add(columnThree.get(3));
        }
        return k3k4Path;
    }

    public static List<Alternative> findPathForK2K4(List<Alternative> columnTwo, List<Alternative> columnForth) {
        List<Alternative> k2k4Path = new ArrayList<>();
        k2k4Path.add(columnTwo.get(0));
        if (questionToOPR(THIRTEENTH_QUESTION) == true) {
            k2k4Path.add(columnTwo.get(1));
            k2k4Path.add(columnForth.get(1));
        } else {

            k2k4Path.add(columnForth.get(1));
            k2k4Path.add(columnTwo.get(1));
        }
        if (questionToOPR(FOURTEENTH_QUESTION) == true) {
            k2k4Path.add(columnTwo.get(2));
            k2k4Path.add(columnForth.get(2));
        } else {
            k2k4Path.add(columnForth.get(2));
            k2k4Path.add(columnTwo.get(2));
        }
        if (questionToOPR(FIFTEENTH_QUESTION) == true) {
            k2k4Path.add(columnTwo.get(3));
            k2k4Path.add(columnForth.get(3));
        } else {
            k2k4Path.add(columnForth.get(3));
            k2k4Path.add(columnTwo.get(3));
        }
        return k2k4Path;
    }

    public static List<Alternative> findPathForK2K3(List<Alternative> columnTwo, List<Alternative> columnThree) {
        List<Alternative> k2k3Path = new ArrayList<>();
        k2k3Path.add(columnTwo.get(0));
        if (questionToOPR(TENTH_QUESTION) == true) {
            k2k3Path.add(columnTwo.get(1));
            k2k3Path.add(columnThree.get(1));
        } else {

            k2k3Path.add(columnThree.get(1));
            k2k3Path.add(columnTwo.get(1));
        }
        if (questionToOPR(ELEVENTH_QUESTION) == true) {
            k2k3Path.add(columnTwo.get(2));
            k2k3Path.add(columnThree.get(2));
        } else {
            k2k3Path.add(columnThree.get(2));
            k2k3Path.add(columnTwo.get(2));
        }
        if (questionToOPR(TWELFTH_QUESTION) == true) {
            k2k3Path.add(columnTwo.get(3));
            k2k3Path.add(columnThree.get(3));
        } else {
            k2k3Path.add(columnThree.get(3));
            k2k3Path.add(columnTwo.get(3));
        }
        return k2k3Path;
    }

    public static List<Alternative> findPathForK1K4(List<Alternative> columnOne, List<Alternative> columnForth) {
        List<Alternative> k1k4Path = new ArrayList<>();
        k1k4Path.add(columnOne.get(0));
        if (questionToOPR(SEVENTH_QUESTION) == true) {
            k1k4Path.add(columnOne.get(1));
            k1k4Path.add(columnForth.get(1));
        } else {
            k1k4Path.add(columnForth.get(1));
            k1k4Path.add(columnOne.get(1));
        }
        if (questionToOPR(EIGHT_QUESTION) == true) {
            k1k4Path.add(columnOne.get(2));
            k1k4Path.add(columnForth.get(2));
        } else {
            k1k4Path.add(columnForth.get(2));
            k1k4Path.add(columnOne.get(2));
        }
        if (questionToOPR(NINTH_QUESTION) == true) {
            k1k4Path.add(columnOne.get(3));
            k1k4Path.add(columnForth.get(3));
        } else {
            k1k4Path.add(columnForth.get(3));
            k1k4Path.add(columnOne.get(3));
        }
        return k1k4Path;
    }


    public static List<Alternative> findPathForK1K3(List<Alternative> columnOne, List<Alternative> columnThree) {
        List<Alternative> k1k3Path = new ArrayList<>();
        k1k3Path.add(columnOne.get(0));
        if (questionToOPR(FORTH_QUESTION) == true) {
            k1k3Path.add(columnOne.get(1));
            k1k3Path.add(columnThree.get(1));
        } else {
            k1k3Path.add(columnThree.get(1));
            k1k3Path.add(columnOne.get(1));
        }
        if (questionToOPR(FIFTH_QUESTION) == true) {
            k1k3Path.add(columnOne.get(2));
            k1k3Path.add(columnThree.get(2));
        } else {
            k1k3Path.add(columnThree.get(2));
            k1k3Path.add(columnOne.get(2));
        }
        if (questionToOPR(SIXTH_QUESTION) == true) {
            k1k3Path.add(columnOne.get(3));
            k1k3Path.add(columnThree.get(3));
        } else {
            k1k3Path.add(columnThree.get(3));
            k1k3Path.add(columnOne.get(3));
        }
        return k1k3Path;
    }


    public static List<Alternative> findPathForK1K2(List<Alternative> columnOne, List<Alternative> columnTwo) {
        List<Alternative> k1k2Path = new ArrayList<>();
        k1k2Path.add(columnOne.get(0));
        if (questionToOPR(FIRST_QUESTION) == true) {
            k1k2Path.add(columnOne.get(1));
            k1k2Path.add(columnTwo.get(1));
        } else {
            k1k2Path.add(columnTwo.get(1));
            k1k2Path.add(columnOne.get(1));
        }
        if (questionToOPR(SECOND_QUESTION) == true) {
            k1k2Path.add(columnOne.get(2));
            k1k2Path.add(columnTwo.get(2));
        } else {
            k1k2Path.add(columnTwo.get(2));
            k1k2Path.add(columnOne.get(2));
        }
        if (questionToOPR(THIRD_QUESTION) == true) {
            k1k2Path.add(columnOne.get(3));
            k1k2Path.add(columnTwo.get(3));
        } else {
            k1k2Path.add(columnTwo.get(3));
            k1k2Path.add(columnOne.get(3));
        }
        return k1k2Path;
    }

    public static boolean questionToOPR(String question) {
        Scanner OPR_answer = new Scanner(System.in);
        System.out.println(question);
        String answer;
        boolean wrongInput;
        do {
            answer = OPR_answer.nextLine();
            wrongInput = !(answer.equals("2") || answer.equals("1"));
            if (wrongInput) {
                System.out.println("Wrong input, try again");
            }
        }
        while (wrongInput);
        return answer.equals("1");
    }

    public static void printAnalyzeCriterion(List<Criterion> toAnalyze) {
        for (Criterion criterion : toAnalyze) {
            System.out.println(criterion);
        }
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