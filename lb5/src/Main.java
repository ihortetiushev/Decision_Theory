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
        System.out.println(all.get(0).criterionMark);
        System.out.println(all.get(1).criterionMark);

    }


    public static void askOPRforTheWorstMark(List<Criterion> allCriterion) {
        Scanner OPR_answer = new Scanner(System.in);

        System.out.println("Визначте критерій на оцінку \"гірший\"");

        System.out.println( "Напишіть цифру 1 - " + allCriterion.get(0).criterionName
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
            case "1" -> allCriterion.get(0).criterionMark = 1 / 5d;
            case "2" -> allCriterion.get(1).criterionMark = 1 / 5d;
            case "3" -> allCriterion.get(2).criterionMark = 1 / 5d;
            case "4" -> allCriterion.get(3).criterionMark = 1 / 5d;
            case "5" -> allCriterion.get(4).criterionMark = 1 / 5d;
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
            case "1" -> allCriterion.get(0).criterionMark = 1 / 3d;
            case "2" -> allCriterion.get(1).criterionMark = 1 / 3d;
            case "3" -> allCriterion.get(2).criterionMark = 1 / 3d;
            case "4" -> allCriterion.get(3).criterionMark = 1 / 3d;
            case "5" -> allCriterion.get(4).criterionMark = 1 / 3d;
            default -> System.out.println("Wrong input");
        }
    }

}
