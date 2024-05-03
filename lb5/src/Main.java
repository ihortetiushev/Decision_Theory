import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Criterion> all = CriterionInit.initialize();
        System.out.println("Завдання 2");
        // CriterionInit.initialize().get(0);
        //
        System.out.println("Визначте оцінку від гіршого до кращого для критеріїв: " + all.get(0).criterionName + ", " + all.get(1).criterionName +
                ", " + all.get(2).criterionName + ", " + all.get(3).criterionName + ", " + all.get(4).criterionName);
        System.out.println();

        askOPRforTheWorstMark(all);
        askOPRforWorseMark(all);
        askOPRforEqualsMark(all);
        askOPRforBetterMark(all);
        askOPRforBestMark(all);
        System.out.println(all.get(0).criterionMark);
        System.out.println(all.get(1).criterionMark);
        System.out.println(all.get(2).criterionMark);
        System.out.println(all.get(3).criterionMark);
        System.out.println(all.get(4).criterionMark);
        System.out.println();
        System.out.println("Матриця порівнянь для критеріїв");
        relativeImportanceCriteriaScale(all);
    }

    public static void relativeImportanceCriteriaScale(List<Criterion> all) {


        System.out.println("Критерії     С1     С2     С3     C4     C5     Власний вектор");
        for (int i = 0; i < all.size(); i++) {
            BigDecimal multiplicationCriterion = new BigDecimal("0");
            System.out.print("C" + (i + 1) + "        ");
            for (int j = 0; j < all.size(); j++) {
                BigDecimal criterionComparison = all.get(i).criterionMark.divide(all.get(j).criterionMark,
                        RoundingMode.HALF_UP);
                multiplicationCriterion = multiplicationCriterion.add(criterionComparison);
                System.out.print("  " + criterionComparison + "  ");

            }

            BigDecimal squareRoot = BigDecimal.valueOf(Math.pow(multiplicationCriterion.doubleValue(), 1.0 / all.size()));

            System.out.println(squareRoot);
            System.out.println();
        }
    }

    public static void askOPRforTheWorstMark(List<Criterion> allCriterion) {
        Scanner OPR_answer = new Scanner(System.in);

        System.out.println("Визначте критерій на оцінку \"гірший\"");

        System.out.println("Напишіть цифру 1 - " + allCriterion.get(0).criterionName
                + ", 2 - " + allCriterion.get(1).criterionName + ", 3 - " + allCriterion.get(2).criterionName +
                ", 4 - " + allCriterion.get(3).criterionName + ", 5 - " + allCriterion.get(4).criterionName);
        String answer;
        boolean wrongInput;
        do {
            answer = OPR_answer.nextLine();
            wrongInput = !(answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4") || answer.equals("5"));
            if (wrongInput) {
                System.out.println("Wrong input, try again");
            }
        }
        while (wrongInput);

        switch (answer) {
            case "1" -> allCriterion.get(0).criterionMark = BigDecimal.valueOf(1.5);
            case "2" -> allCriterion.get(1).criterionMark = BigDecimal.valueOf(1.5);
            case "3" -> allCriterion.get(2).criterionMark = BigDecimal.valueOf(1.5);
            case "4" -> allCriterion.get(3).criterionMark = BigDecimal.valueOf(1.5);
            case "5" -> allCriterion.get(4).criterionMark = BigDecimal.valueOf(1.5);
            default -> System.out.println("Wrong input");
        }
    }

    public static void askOPRforWorseMark(List<Criterion> allCriterion) {
        Scanner OPR_answer = new Scanner(System.in);

        System.out.println("Визначте критерій на оцінку \"трішки гірший\"");

        System.out.println("Напишіть цифру 1 - " + allCriterion.get(0).criterionName
                + ", 2 - " + allCriterion.get(1).criterionName + ", 3 - " + allCriterion.get(2).criterionName +
                ", 4 - " + allCriterion.get(3).criterionName + ", 5 - " + allCriterion.get(4).criterionName);
        String answer;
        boolean wrongInput;
        do {
            answer = OPR_answer.nextLine();
            wrongInput = !(answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4") || answer.equals("5"));
            if (wrongInput) {
                System.out.println("Wrong input, try again");
            }
        }
        while (wrongInput);

        switch (answer) {
            case "1" -> allCriterion.get(0).criterionMark = BigDecimal.valueOf(1.3);
            case "2" -> allCriterion.get(1).criterionMark = BigDecimal.valueOf(1.3);
            case "3" -> allCriterion.get(2).criterionMark = BigDecimal.valueOf(1.3);
            case "4" -> allCriterion.get(3).criterionMark = BigDecimal.valueOf(1.3);
            case "5" -> allCriterion.get(4).criterionMark = BigDecimal.valueOf(1.3);
            default -> System.out.println("Wrong input");
        }
    }

    public static void askOPRforEqualsMark(List<Criterion> allCriterion) {
        Scanner OPR_answer = new Scanner(System.in);

        System.out.println("Визначте критерій на оцінку \"дорівнює\"");

        System.out.println("Напишіть цифру 1 - " + allCriterion.get(0).criterionName
                + ", 2 - " + allCriterion.get(1).criterionName + ", 3 - " + allCriterion.get(2).criterionName +
                ", 4 - " + allCriterion.get(3).criterionName + ", 5 - " + allCriterion.get(4).criterionName);
        String answer;
        boolean wrongInput;
        do {
            answer = OPR_answer.nextLine();
            wrongInput = !(answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4") || answer.equals("5"));
            if (wrongInput) {
                System.out.println("Wrong input, try again");
            }
        }
        while (wrongInput);

        switch (answer) {
            case "1" -> allCriterion.get(0).criterionMark = BigDecimal.valueOf(1.0);
            case "2" -> allCriterion.get(1).criterionMark = BigDecimal.valueOf(1.0);
            case "3" -> allCriterion.get(2).criterionMark = BigDecimal.valueOf(1.0);
            case "4" -> allCriterion.get(3).criterionMark = BigDecimal.valueOf(1.0);
            case "5" -> allCriterion.get(4).criterionMark = BigDecimal.valueOf(1.0);
            default -> System.out.println("Wrong input");
        }
    }

    public static void askOPRforBetterMark(List<Criterion> allCriterion) {
        Scanner OPR_answer = new Scanner(System.in);

        System.out.println("Визначте критерій на оцінку \"трішки кращий\"");

        System.out.println("Напишіть цифру 1 - " + allCriterion.get(0).criterionName
                + ", 2 - " + allCriterion.get(1).criterionName + ", 3 - " + allCriterion.get(2).criterionName +
                ", 4 - " + allCriterion.get(3).criterionName + ", 5 - " + allCriterion.get(4).criterionName);
        String answer;
        boolean wrongInput;
        do {
            answer = OPR_answer.nextLine();
            wrongInput = !(answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4") || answer.equals("5"));
            if (wrongInput) {
                System.out.println("Wrong input, try again");
            }
        }
        while (wrongInput);

        switch (answer) {
            case "1" -> allCriterion.get(0).criterionMark = BigDecimal.valueOf(3.0);
            case "2" -> allCriterion.get(1).criterionMark = BigDecimal.valueOf(3.0);
            case "3" -> allCriterion.get(2).criterionMark = BigDecimal.valueOf(3.0);
            case "4" -> allCriterion.get(3).criterionMark = BigDecimal.valueOf(3.0);
            case "5" -> allCriterion.get(4).criterionMark = BigDecimal.valueOf(3.0);
            default -> System.out.println("Wrong input");
        }
    }

    public static void askOPRforBestMark(List<Criterion> allCriterion) {
        Scanner OPR_answer = new Scanner(System.in);

        System.out.println("Визначте критерій на оцінку \"кращий\"");

        System.out.println("Напишіть цифру 1 - " + allCriterion.get(0).criterionName
                + ", 2 - " + allCriterion.get(1).criterionName + ", 3 - " + allCriterion.get(2).criterionName +
                ", 4 - " + allCriterion.get(3).criterionName + ", 5 - " + allCriterion.get(4).criterionName);
        String answer;
        boolean wrongInput;
        do {
            answer = OPR_answer.nextLine();
            wrongInput = !(answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4") || answer.equals("5"));
            if (wrongInput) {
                System.out.println("Wrong input, try again");
            }
        }
        while (wrongInput);

        switch (answer) {
            case "1" -> allCriterion.get(0).criterionMark = BigDecimal.valueOf(5.0);
            case "2" -> allCriterion.get(1).criterionMark = BigDecimal.valueOf(5.0);
            case "3" -> allCriterion.get(2).criterionMark = BigDecimal.valueOf(5.0);
            case "4" -> allCriterion.get(3).criterionMark = BigDecimal.valueOf(5.0);
            case "5" -> allCriterion.get(4).criterionMark = BigDecimal.valueOf(5.0);
            default -> System.out.println("Wrong input");
        }
    }
}
