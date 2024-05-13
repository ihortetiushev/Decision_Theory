import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Criterion> all = CriterionInit.initialize();
        List<Alternative> alternatives = AlternativeInit.initializeAlternative(all);
        AlternativeResult[][] alternativesForCriterion1 = AlternativeResultInit.initializeAlternativeForCriterion1();

        List<CriterionComparison> comparisons = new ArrayList<>();
        System.out.println("Завдання 2");
        System.out.println("Визначте оцінку від гіршого до кращого для критеріїв: " + all.get(0).criterionName + ", " + all.get(1).criterionName +
                ", " + all.get(2).criterionName + ", " + all.get(3).criterionName + ", "
                + all.get(4).criterionName);
        System.out.println();


        System.out.println(all.get(0).criterionMark);
        System.out.println(all.get(1).criterionMark);
        System.out.println(all.get(2).criterionMark);
        System.out.println(all.get(3).criterionMark);
        System.out.println(all.get(4).criterionMark);

        System.out.println();
        System.out.println("Завдання 2");
        System.out.println("Матриця порівнянь для критеріїв");

        /*askOPRforCompareCriterion(comparisons, all.get(0), all.get(1));
        askOPRforCompareCriterion(comparisons, all.get(0), all.get(2));
        askOPRforCompareCriterion(comparisons, all.get(0), all.get(3));
        askOPRforCompareCriterion(comparisons, all.get(0), all.get(4));

        askOPRforCompareCriterion(comparisons, all.get(1), all.get(2));
        askOPRforCompareCriterion(comparisons, all.get(1), all.get(3));
        askOPRforCompareCriterion(comparisons, all.get(1), all.get(4));

        askOPRforCompareCriterion(comparisons, all.get(2), all.get(3));
        askOPRforCompareCriterion(comparisons, all.get(2), all.get(4));

        askOPRforCompareCriterion(comparisons, all.get(3), all.get(4));

        relativeImportanceCriteriaScale(comparisons, all);*/

        System.out.println();
        System.out.println("Завдання 3");
        System.out.println("Важливость альтернатив за кожним із критеріїв");
        System.out.println();
        System.out.println("                                 За критерієм Вартість");
        compareAlternativesToCriteria1(alternativesForCriterion1);
    }


    public static void compareAlternativesToCriteria1(AlternativeResult[][] alternativesForCriterion) {
        System.out.println("Альтернатива      А1      А2      А3      А4      А5      А6      А7     Власний вектор");
        for (int i = 0; i < alternativesForCriterion.length; i++) {
            System.out.print("A" + (i + 1) + "          ");
            BigDecimal eigenvector = BigDecimal.ZERO;
            BigDecimal multiplicationAlternatives = BigDecimal.ONE;
            for (int j = 0; j < alternativesForCriterion.length; j++) {
                System.out.print("     " + alternativesForCriterion[i][j]);
                multiplicationAlternatives = multiplicationAlternatives.multiply(alternativesForCriterion[i][j].alternativeMarkValue);
                eigenvector = BigDecimal.valueOf(Math.pow(multiplicationAlternatives.doubleValue(), 1.0 / 7.0 )).setScale(1, RoundingMode.HALF_UP);
            }
            System.out.println("     multiplication = " + multiplicationAlternatives + "                        eigenvector" + eigenvector);
        }
    }

    public static void relativeImportanceCriteriaScale(List<CriterionComparison> comparisons,
                                                       List<Criterion> all) {
        System.out.println("Критерії     С1      С2      С3      C4      C5     Власний вектор");
        BigDecimal sumEigenvector = BigDecimal.ZERO;
        List<BigDecimal> eigenvectorList = new ArrayList<>();
        BigDecimal criterionWeight;

        for (int i = 0; i < all.size(); i++) {
            System.out.print("C" + (i + 1) + "          ");
            BigDecimal multiplicationCriterion = new BigDecimal("1");
            BigDecimal eigenvector;



            for (int j = 0; j < all.size(); j++) {

                if (i != j) {
                    CriterionComparison criterionComparison = comparisonsTwoIndex(i, j, comparisons);
                    System.out.print(criterionComparison.criterionStringMark);
                    multiplicationCriterion = multiplicationCriterion.multiply(criterionComparison.criterionMarkValue);
                } else {
                    System.out.print("1.0");
                }
                System.out.print("     ");
            }

            eigenvector = BigDecimal.valueOf(Math.pow(multiplicationCriterion.doubleValue(), 1.0 / all.size())).setScale(1, RoundingMode.HALF_UP);
            eigenvectorList.add(eigenvector);
            sumEigenvector = sumEigenvector.add(eigenvector);


            System.out.print("     " + eigenvector);
            System.out.println();
        }
        System.out.println();
        System.out.println("Вага критерію:");
        System.out.println("Сума власних векторів: " + sumEigenvector);
        for (int j = 0; j < all.size(); j++) {
            criterionWeight = eigenvectorList.get(j).setScale(2, RoundingMode.HALF_UP).divide(sumEigenvector, RoundingMode.HALF_UP);
            System.out.println("w" + j + " = " + criterionWeight);
        }

    }

    public static CriterionComparison comparisonsTwoIndex(int index1, int index2,
                                                          List<CriterionComparison> comparisons) throws NoSuchElementException {
        for (int i = 0; i < comparisons.size(); i++) {
            if (comparisons.get(i).criterion1.criterionNum - 1 == index1 && comparisons.get(i).criterion2.criterionNum - 1 == index2) {
                return comparisons.get(i);
            }
        }
        throw new NoSuchElementException("Comparison not found for indices: " + index1 + ", " + index2);
    }


    public static void askOPRforCompareCriterion(List<CriterionComparison> comparisons, Criterion one,
                                                 Criterion two) {
        CriterionComparison compareTwoCriteria = new CriterionComparison();
        CriterionComparison compareReverseTwoCriteria = new CriterionComparison();
        comparisons.add(compareTwoCriteria);
        comparisons.add(compareReverseTwoCriteria);
        Scanner OPR_answer = new Scanner(System.in);

        System.out.println("Порівняйте критерії \"" + one.criterionName + " та \"" + two.criterionName + "\"");

        System.out.println("Напишіть цифру, якщо 1 - значно-значно гірше, 2 - значно гірше, " +
                "3 - гірше, 4 - трішки гірше, 5 - дорівнює, 6 - трішки краще, 7 - краще, 8 - значно краще, " +
                "9 - значно-значно краще");
        compareTwoCriteria.criterion1 = one;
        compareTwoCriteria.criterion2 = two;
        compareReverseTwoCriteria.criterion1 = two;
        compareReverseTwoCriteria.criterion2 = one;

        String answer;
        boolean wrongInput;
        do {
            answer = OPR_answer.nextLine();
            wrongInput = !(answer.equals("1") || answer.equals("2") || answer.equals("3") ||
                    answer.equals("4") || answer.equals("5") || answer.equals("6") || answer.equals("7")
                    || answer.equals("8") || answer.equals("9"));
            if (wrongInput) {
                System.out.println("Wrong input, try again");
            }
        }
        while (wrongInput);
        compareTwoCriteria.criterionMarkValue = new BigDecimal(answer);
        compareTwoCriteria.criterionStringMark = answer;

        switch (answer) {
            case "1" -> {
                compareTwoCriteria.criterionMarkValue = BigDecimal.valueOf(1.0 / 9.0);
                compareTwoCriteria.criterionStringMark = "1/9";
                compareReverseTwoCriteria.criterionMarkValue = BigDecimal.valueOf(9.0);
                compareReverseTwoCriteria.criterionStringMark = "9.0";
            }

            case "2" -> {
                compareTwoCriteria.criterionMarkValue = BigDecimal.valueOf(1.0 / 7.0);
                compareTwoCriteria.criterionStringMark = "1/7";
                compareReverseTwoCriteria.criterionMarkValue = BigDecimal.valueOf(7.0);
                compareReverseTwoCriteria.criterionStringMark = "7.0";
            }

            case "3" -> {
                compareTwoCriteria.criterionMarkValue = BigDecimal.valueOf(1.0 / 5.0);
                compareTwoCriteria.criterionStringMark = "1/5";
                compareReverseTwoCriteria.criterionMarkValue = BigDecimal.valueOf(5.0);
                compareReverseTwoCriteria.criterionStringMark = "5.0";
            }

            case "4" -> {
                compareTwoCriteria.criterionMarkValue = BigDecimal.valueOf(1.0 / 3.0);
                compareTwoCriteria.criterionStringMark = "1/3";
                compareReverseTwoCriteria.criterionMarkValue = BigDecimal.valueOf(3.0);
                compareReverseTwoCriteria.criterionStringMark = "3.0";
            }

            case "5" -> {
                compareTwoCriteria.criterionMarkValue = BigDecimal.ONE;
                compareTwoCriteria.criterionStringMark = "1.0";
                compareReverseTwoCriteria.criterionMarkValue = BigDecimal.ONE;
                compareReverseTwoCriteria.criterionStringMark = "1.0";
            }

            case "6" -> {
                compareTwoCriteria.criterionMarkValue = BigDecimal.valueOf(3.0);
                compareTwoCriteria.criterionStringMark = "3.0";
                compareReverseTwoCriteria.criterionMarkValue = BigDecimal.valueOf(1.0 / 3.0);
                compareReverseTwoCriteria.criterionStringMark = "1/3";
            }

            case "7" -> {
                compareTwoCriteria.criterionMarkValue = BigDecimal.valueOf(5.0);
                compareTwoCriteria.criterionStringMark = "5.0";
                compareReverseTwoCriteria.criterionMarkValue = BigDecimal.valueOf(1.0 / 5.0);
                compareReverseTwoCriteria.criterionStringMark = "1/5";
            }

            case "8" -> {
                compareTwoCriteria.criterionMarkValue = BigDecimal.valueOf(7.0);
                compareTwoCriteria.criterionStringMark = "7.0";
                compareReverseTwoCriteria.criterionMarkValue = BigDecimal.valueOf(1.0 / 7.0);
                compareReverseTwoCriteria.criterionStringMark = "1/7";
            }

            case "9" -> {
                compareTwoCriteria.criterionMarkValue = BigDecimal.valueOf(9.0);
                compareTwoCriteria.criterionStringMark = "9.0";
                compareReverseTwoCriteria.criterionMarkValue = BigDecimal.valueOf(1.0 / 9.0);
                compareReverseTwoCriteria.criterionStringMark = "1/9";
            }

            default -> System.out.println("Wrong input");
        }
    }


}
