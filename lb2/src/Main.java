import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    static int D = -1;

    public static void main(String[] args) {

        List<Criterion> all = CriterionInit.initialize();
        List<Criterion> toAnalyze = new ArrayList<>();
        toAnalyze.add(all.get(0));
        toAnalyze.add(all.get(1));
        toAnalyze.add(all.get(2));
        toAnalyze.add(all.get(3));
        toAnalyze.add(all.get(4));

        // Печать всех комбинаций критериев
        System.out.println("Задані критерії: ");
        printAnalyzeCriterion(toAnalyze);
        System.out.println();
        List<List<ValueIndex>> allCombinations = getAllCombinations(toAnalyze);

        List<ClassificationAlternatives> allClassification = new ArrayList<>();
        List<ValueIndex> firstCombination = allCombinations.get(0);
        List<ValueIndex> lastCombination = allCombinations.get(allCombinations.size() - 1);
        //перша ітерація
        for (int i = 0; i < allCombinations.size(); i++) {
            ClassificationAlternatives classification = new ClassificationAlternatives();
            List<ValueIndex> valueIndex = allCombinations.get(i);
            classification.valueIndex = valueIndex;

            //знаходження G
            if (i == 0) {
                classification.G.add(1);
            }
            if (i == allCombinations.size() - 1) {
                classification.G.add(2);
            }
            if (!(i == 0) && !(i == allCombinations.size() - 1)) {
                classification.G.add(1);
                classification.G.add(2);
            }

            for (int j = 0; j < valueIndex.size(); j++) {
                int d1 = find_d(valueIndex, firstCombination);
                int d2 = find_d(valueIndex, lastCombination);
                if (j == 0 && D == -1) {
                    D = d2;
                }

                classification.d1 = d1;
                classification.d2 = d2;
                //double p2 = find_p2(valueIndex, firstCombination, lastCombination);
                classification.p1 = find_p1(d1, d2);
                classification.p2 = find_p2(d1, d2);
                //classification.g1 = chooseMidP(valueIndex, classification.p1);

            }
            allClassification.add(classification);
        }
        //allCombinations.add(chooseMidP(allClassification));
        chooseMidP(allClassification);
        middleOfList(allCombinations, allClassification);
        find_g1(allCombinations, allClassification, chooseMidP(allClassification));
        find_g2(allCombinations, allClassification, chooseMidP(allClassification));
        findF1(allClassification);
        findF2(allClassification);
        findF(allClassification);

        System.out.println("Перша ітерація");
        //виводимо першу ітерацію allClassification
        for (int i = 0; i < allClassification.size(); i++) {
            System.out.println(fixedLengthString((i + 1) + "", 2) + allClassification.get(i));
        }
        System.out.println();

        System.out.println("Друга ітерація");

        find_G_secondIteration(allClassification);
        find_d1_secondIteration(allClassification);
        find_d2_secondIteration(allClassification, lastCombination);
        find_p1_secondIteration(allClassification);
        find_p2_secondIteration(allClassification);
        find_g1_secondIteration(allClassification);
        find_g2_secondIteration(allClassification);
        findF1(allClassification);
        findF2(allClassification);
        findF(allClassification);

        //виводимо другу ітерацію allClassification
        for (int i = 0; i < allClassification.size(); i++) {
            System.out.println(fixedLengthString((i + 1) + "", 2) + allClassification.get(i));
        }

        System.out.println();
        System.out.println("Третя ітерація");
        find_G_ThirdIteration(allClassification);
        find_d1_secondIteration(allClassification);
        find_d2_secondIteration(allClassification, lastCombination);
        find_p1_secondIteration(allClassification);
        find_p2_secondIteration(allClassification);
        find_g1_secondIteration(allClassification);
        find_g2_secondIteration(allClassification);
        findF1(allClassification);
        findF2(allClassification);
        findF(allClassification);

        for (int i = 0; i < allClassification.size(); i++) {
            System.out.println(fixedLengthString((i + 1) + "", 2) + allClassification.get(i));
        }


        System.out.println();
        System.out.println("Четверта ітерація");
        find_G_ForthIteration(allClassification);
        find_d1_secondIteration(allClassification);
        find_d2_forthIteration(allClassification, lastCombination);
        find_p1_secondIteration(allClassification);
        find_p2_secondIteration(allClassification);
        find_g1_secondIteration(allClassification);
        find_g2_secondIteration(allClassification);
        findF1(allClassification);
        findF2(allClassification);
        findF(allClassification);

        for (int i = 0; i < allClassification.size(); i++) {
            System.out.println(fixedLengthString((i + 1) + "", 2) + allClassification.get(i));
        }

        System.out.println();
        System.out.println("П'ята ітерація");
        find_G_FifthIteration(allClassification);
        find_d1_secondIteration(allClassification);
        find_d2_forthIteration(allClassification, lastCombination);
        find_p1_secondIteration(allClassification);
        find_p2_secondIteration(allClassification);
        find_g1_secondIteration(allClassification);
        find_g2_secondIteration(allClassification);
        findF1(allClassification);
        findF2(allClassification);
        findF(allClassification);

        for (int i = 0; i < allClassification.size(); i++) {
            System.out.println(fixedLengthString((i + 1) + "", 2) + allClassification.get(i));
        }
    }
   /* public static void find_g2_secondIteration(List<ClassificationAlternatives> allClassification) {

        for(int i = 0; i < allClassification.size(); i++) {
            if(allClassification.get(i).G.equals(List.of(1,2))){
                if(allClassification.get(i).p2.compareTo(BigDecimal.valueOf(0.5)) >= 0) {
                    allClassification.get(i).g2 = 1;
                }
                else{
                    allClassification.get(i).g2 = 0;
                }
            }
            else{
                allClassification.get(i).g2 = 0;
            }

        }
    }*/
    public static void find_g2_secondIteration(List<ClassificationAlternatives> allClassification) {

        for(int i = 0; i < allClassification.size(); i++) {
            if(i != 0 && i < allClassification.size() -1) {
                if (allClassification.get(i).G.equals(List.of(1, 2))) {
                    if (allClassification.get(i).g1 == 0) {
                        allClassification.get(i).g2 = 1;
                    } else {
                        allClassification.get(i).g2 = 0;
                    }
                }
                else {
                    allClassification.get(i).g2 = 0;
                }
            }
        }
    }
    public static void find_g1_secondIteration(List<ClassificationAlternatives> allClassification) {

        for(int i = 0; i < allClassification.size(); i++) {
            if(i != 0 && i < allClassification.size() -1) {

                if (allClassification.get(i).G.equals(List.of(1, 2))) {
                    if (allClassification.get(i).p1.compareTo(BigDecimal.valueOf(0.5)) >= 0) {
                        allClassification.get(i).g1 = 0;
                    } else {
                        allClassification.get(i).g1 = 1;
                    }
                } else {
                    allClassification.get(i).g1 = 0;
                }
            }
        }
    }
    public static void find_d2_forthIteration(List<ClassificationAlternatives> allClassification, List<ValueIndex> lastCombination) {
        int sumFirstIndex = 0;
        int sumSecondIndex = 0;
        int sumThirdIndex = 0;
        int sumFourthIndex = 0;
        int sumFifthIndex = 0;

        int countTimes = 0;
        for(int i = 0; i < allClassification.size(); i++) {
            if(allClassification.get(i).G.equals(List.of(2))) {
                countTimes ++;
                sumFirstIndex += allClassification.get(i).valueIndex.get(0).index + 1;
                sumSecondIndex += allClassification.get(i).valueIndex.get(1).index + 1;
                sumThirdIndex += allClassification.get(i).valueIndex.get(2).index + 1;
                sumFourthIndex += allClassification.get(i).valueIndex.get(3).index + 1;
                sumFifthIndex += allClassification.get(i).valueIndex.get(4).index + 1;
            }
        }
        double middleFirst = (double) sumFirstIndex / countTimes;
        double middleSecond = (double) sumSecondIndex / countTimes;
        double middleThird = (double) sumThirdIndex / countTimes;
        double middleFourth = (double) sumFourthIndex / countTimes;
        double middleFifth = (double) sumFifthIndex / countTimes;

        for (int i = 0; i < allClassification.size(); i++) {
            allClassification.get(i).d2 = Math.abs((allClassification.get(i).valueIndex.get(0).index + 1) - middleFirst) +
                    Math.abs((allClassification.get(i).valueIndex.get(1).index + 1) - middleSecond) +
                    Math.abs((allClassification.get(i).valueIndex.get(2).index + 1) - middleThird) +
                    Math.abs((allClassification.get(i).valueIndex.get(3).index + 1) - middleFourth) +
                    Math.abs((allClassification.get(i).valueIndex.get(4).index + 1) - middleFifth);
        }
        System.out.println("Y2 = {" + middleFirst + ", " + middleSecond + ", " + middleThird + ", " + middleFourth + ", " + middleFifth + "}");
    }
    public static void find_d2_secondIteration(List<ClassificationAlternatives> allClassification, List<ValueIndex> lastCombination) {
        for (int i = 0; i < allClassification.size(); i++) {
            //for (int j = 0; j < lastCombination.size(); j++) {
            int lastIndex = allClassification.get(i).valueIndex.size() - 1;
                allClassification.get(i).d2 = Math.abs((allClassification.get(i).valueIndex.get(0).index + 1) - (allClassification.get(i).valueIndex.get(lastIndex).index + 1)) +
                        Math.abs((allClassification.get(i).valueIndex.get(1).index + 1) - (allClassification.get(i).valueIndex.get(lastIndex).index + 1)) +
                        Math.abs((allClassification.get(i).valueIndex.get(2).index + 1) - (allClassification.get(i).valueIndex.get(lastIndex).index + 1)) +
                        Math.abs((allClassification.get(i).valueIndex.get(3).index + 1) - (allClassification.get(i).valueIndex.get(lastIndex).index + 1)) +
                        Math.abs((allClassification.get(i).valueIndex.get(4).index + 1) - (allClassification.get(i).valueIndex.get(lastIndex).index + 1));
            //}
        }
    }
    public static void find_d1_secondIteration(List<ClassificationAlternatives> allClassification) {
        int sumFirstIndex = 0;
        int sumSecondIndex = 0;
        int sumThirdIndex = 0;
        int sumFourthIndex = 0;
        int sumFifthIndex = 0;

        int countTimes = 0;
        for(int i = 0; i < allClassification.size(); i++) {
            if(allClassification.get(i).G.equals(List.of(1))) {
                countTimes ++;
                sumFirstIndex += allClassification.get(i).valueIndex.get(0).index + 1;
                sumSecondIndex += allClassification.get(i).valueIndex.get(1).index + 1;
                sumThirdIndex += allClassification.get(i).valueIndex.get(2).index + 1;
                sumFourthIndex += allClassification.get(i).valueIndex.get(3).index + 1;
                sumFifthIndex += allClassification.get(i).valueIndex.get(4).index + 1;
            }
        }
        double middleFirst = (double) sumFirstIndex / countTimes;
        double middleSecond = (double) sumSecondIndex / countTimes;
        double middleThird = (double) sumThirdIndex / countTimes;
        double middleFourth = (double) sumFourthIndex / countTimes;
        double middleFifth = (double) sumFifthIndex / countTimes;

        for (int i = 0; i < allClassification.size(); i++) {
            allClassification.get(i).d1 = Math.abs((allClassification.get(i).valueIndex.get(0).index + 1) - middleFirst) +
                    Math.abs((allClassification.get(i).valueIndex.get(1).index + 1) - middleSecond) +
                    Math.abs((allClassification.get(i).valueIndex.get(2).index + 1) - middleThird) +
                    Math.abs((allClassification.get(i).valueIndex.get(3).index + 1) - middleFourth) +
                    Math.abs((allClassification.get(i).valueIndex.get(4).index + 1) - middleFifth);
        }
        System.out.println("Y1 = {" + middleFirst + ", " + middleSecond + ", " + middleThird + ", " + middleFourth + ", " + middleFifth + "}");
    }

    public static void find_p2_secondIteration(List<ClassificationAlternatives> allClassification) {
        for (int i = 0; i < allClassification.size(); i++) {
            allClassification.get(i).p2 = find_p2(allClassification.get(i).d1, allClassification.get(i).d2);
            if(allClassification.get(i).G.equals(List.of(1))) {
                allClassification.get(i).p2 = BigDecimal.valueOf(0.0);//BigDecimal.ZERO;
            }
            if(allClassification.get(i).G.equals(List.of(2))) {
                allClassification.get(i).p2 = BigDecimal.valueOf(1.0); //BigDecimal.ONE;
            }
        }
    }

    public static void find_p1_secondIteration(List<ClassificationAlternatives> allClassification) {
        System.out.println("D = " + D);
        for (int i = 0; i < allClassification.size(); i++) {
            allClassification.get(i).p1 = find_p1(allClassification.get(i).d1, allClassification.get(i).d2);
            if(allClassification.get(i).G.equals(List.of(1))) {
                allClassification.get(i).p1 = BigDecimal.valueOf(1.0); //BigDecimal.ONE;
            }
            if(allClassification.get(i).G.equals(List.of(2))) {
                allClassification.get(i).p1 = BigDecimal.valueOf(0.0); //BigDecimal.ZERO;
            }
        }
    }
    public static void find_G_FifthIteration(List<ClassificationAlternatives> allClassification) {
        int countMaxF = 0;
        BigDecimal valueMaxF = maxF(allClassification);

        for(int i = allClassification.size() - 2 ; i > allClassification.size() - 5; i--) {
            allClassification.get(i).G.clear();
            allClassification.get(i).G.add(1);
        }
    }
    public static void find_G_ForthIteration(List<ClassificationAlternatives> allClassification) {
        int countMaxF = 0;
        BigDecimal valueMaxF = maxF(allClassification);
        for(int i = 0; i < allClassification.size(); i++) {
            if (allClassification.get(i).F.compareTo(valueMaxF) == 0) {
                if(countMaxF == 0){
                    allClassification.get(i).G.clear();
                    allClassification.get(i).G.add(1);
                }
                if(countMaxF == 1){
                    allClassification.get(i).G.clear();
                    allClassification.get(i).G.add(2);
                }
                countMaxF++;
            }
            else if(countMaxF < 2){
                allClassification.get(i).G.clear();
                allClassification.get(i).G.add(1);
            }
            else if(countMaxF < 3){
                allClassification.get(i).G.clear();
                allClassification.get(i).G.add(2);
            }
        }
    }
    public static void find_G_ThirdIteration(List<ClassificationAlternatives> allClassification) {
        int countMaxF = 0;
        BigDecimal valueMaxF = maxF(allClassification);
        for(int i = 0; i < allClassification.size(); i++) {
            if (allClassification.get(i).F.compareTo(valueMaxF) == 0) {
                if(countMaxF == 0){
                    allClassification.get(i).G.clear();
                    allClassification.get(i).G.add(1);
                }
                countMaxF++;
            }
            else if(countMaxF < 2){
                allClassification.get(i).G.clear();
                allClassification.get(i).G.add(1);
            }
        }
    }
    public static void find_G_secondIteration(List<ClassificationAlternatives> allClassification) {
        for (int i = 0; i < allClassification.size(); i++) {
            if (allClassification.get(i).F.equals(maxF(allClassification))) {
                allClassification.get(i).G.clear();
                allClassification.get(i).G.add(1);
            }
            if(allClassification.get(i).p1.compareTo(chooseMidP(allClassification)) > 0) {
                allClassification.get(i).G.clear();
                allClassification.get(i).G.add(1);
            }
        }
    }
    public static BigDecimal maxF(List<ClassificationAlternatives> allClassification) {
        BigDecimal maxF = allClassification.get(0).F;
        for(int i = 1; i < allClassification.size(); i++) {
            BigDecimal currentF = allClassification.get(i).F;
            if (currentF.compareTo(maxF) > 0) {
                maxF = currentF;
            }
        }
        return maxF;
    }
    public static void findF(List<ClassificationAlternatives> allClassification) {
        for (int i = 0; i < allClassification.size(); i++) {
            //BigDecimal f = allClassification.get(i).F1.multiply(allClassification.get(i).F2);
            BigDecimal f = allClassification.get(i).F1.add(allClassification.get(i).F2);
            allClassification.get(i).F = f.setScale(1, RoundingMode.HALF_UP);
        }
    }
    public static void findF2(List<ClassificationAlternatives> allClassification) {
        for (int i = 0; i < allClassification.size(); i++) {
            BigDecimal g2BigDecimal = BigDecimal.valueOf(allClassification.get(i).g2);
            allClassification.get(i).F2 = allClassification.get(i).p2.multiply(g2BigDecimal);
        }
    }
    public static void findF1(List<ClassificationAlternatives> allClassification) {
        for (int i = 0; i < allClassification.size(); i++) {
            BigDecimal g1BigDecimal = BigDecimal.valueOf(allClassification.get(i).g1);
            allClassification.get(i).F1 = allClassification.get(i).p1.multiply(g1BigDecimal);
        }
    }
    public static void find_g2(List<List<ValueIndex>> allCombinations, List<ClassificationAlternatives> allClassification, BigDecimal mid_p) {
        int count_Better = 0;
        int count_as_mid = 0;
        int middle_index = 21;
        ClassificationAlternatives middleList = middleOfList(allCombinations, allClassification);
        for (int i = 0; i < allClassification.size(); i++) {
            if (i == 0 || i == allClassification.size() - 1) {
                allClassification.get(i).g2 = 0;
            }
            if(allClassification.get(i).p2.compareTo(mid_p) > 0 && allClassification.get(i).p2.compareTo(BigDecimal.ONE) != 0) {
                allClassification.get(i).g2 = 0;
            }
            if(allClassification.get(i).p2.compareTo(mid_p) == 0) {
                allClassification.get(i).g2 = 1;
                count_as_mid++;
            }

            if(i > middle_index && allClassification.get(i).p2.compareTo(mid_p) > 0) {
                if(i != allClassification.size() - 1) {
                    count_Better++;
                }
            }
        }

        for (int i = 0; i < allClassification.size(); i++) {
            if(allClassification.get(i).p2.compareTo(mid_p) < 0 ) {
                if(i != allClassification.size() - 1 && i!= 0) {
                    allClassification.get(i).g2 = count_as_mid + count_Better;
                }
            }
        }
        middleList.g2 = count_Better;
    }


    public static void find_g1(List<List<ValueIndex>> allCombinations, List<ClassificationAlternatives> allClassification, BigDecimal mid_p) {
        int count_Better = 0;
        int count_as_mid = 0;
        BigDecimal middleIndex = BigDecimal.valueOf(21);
        int middle_index = 21;
        ClassificationAlternatives middleList = middleOfList(allCombinations, allClassification);
        for (int i = 0; i < allClassification.size(); i++) {
            if (i == 0 || i == allClassification.size() - 1) {
                allClassification.get(i).g1 = 0;
            }
            if(allClassification.get(i).p1.compareTo(mid_p) > 0 && allClassification.get(i).p1.compareTo(BigDecimal.ONE) != 0) {
                if(i < middle_index){
                    count_Better++;
                }
                allClassification.get(i).g1 = 0;
            }
            if(allClassification.get(i).p1.compareTo(mid_p) == 0) {
                allClassification.get(i).g1 = 1;
                count_as_mid++;
            }
        }

        for (int i = 0; i < allClassification.size(); i++) {
            if(allClassification.get(i).p1.compareTo(mid_p) < 0 ) {
                if(i != allClassification.size() - 1 && i!= 0) {
                    allClassification.get(i).g1 = count_as_mid + count_Better;
                }
            }
        }

        middleList.g1 = count_Better;
    }

    public static ClassificationAlternatives middleOfList(List<List<ValueIndex>> allCombinations, List<ClassificationAlternatives> allClassification) {
        BigDecimal midP = chooseMidP(allClassification);
        int middleRow = allCombinations.size() / 2;
        for (int i = middleRow; i > 0; i--) {
            if(allClassification.get(i).p1.compareTo(midP) == 0) {
                return allClassification.get(i);
            }
        }
        throw new IllegalStateException("Exception");
    }

    public static BigDecimal chooseMidP(List<ClassificationAlternatives> allClassification) {
        BigDecimal middle = allClassification.get(0).p1;
        BigDecimal middleReference = BigDecimal.valueOf(0.5);

        for (ClassificationAlternatives classification : allClassification) {
            if (classification.p1.subtract(middleReference).abs().compareTo(middle.subtract(middleReference).abs()) <= 0 && classification.p1.compareTo(middleReference) >= 0) {
                middle = classification.p1;
            }
        }

        return middle;
    }
    public static BigDecimal find_p1(double d1, double d2) {
        double p1 = (D - d1) / (D - d1 + D - d2);
        return BigDecimal.valueOf(p1).setScale(1, RoundingMode.HALF_UP);
    }
    public static BigDecimal find_p1(int d1, int d2) {
        double p1 = (double) (D - d1) / (D - d1 + D - d2);
        return BigDecimal.valueOf(p1).setScale(1, RoundingMode.HALF_UP);
    }
    public static BigDecimal find_p2(double d1, double d2) {
        double p2 = (D - d2) / (D - d1 + D - d2);
        return BigDecimal.valueOf(p2).setScale(1, RoundingMode.HALF_UP);
    }
    public static BigDecimal find_p2(int d1, int d2) {
        double p2 = (double) (D - d2) / (D - d1 + D - d2);
        return BigDecimal.valueOf(p2).setScale(1, RoundingMode.HALF_UP);
    }

    public static int find_d(List<ValueIndex> valueIndex, List<ValueIndex> firstOrLastCombination) {
        int d = 0;
        for (int i = 0; i < valueIndex.size(); i++) {
            d += Math.abs((valueIndex.get(i).index) - firstOrLastCombination.get(i).index);
        }
        return d;
    }

    public static void printAllClassification(List<ClassificationAlternatives> allClassification) {
        for (int i = 0; i < allClassification.size(); i++) {
            System.out.println(fixedLengthString((i + 1) + "", 2) +
                    fixedLengthString(allClassification.get(i).valueIndex.get(0).criterionNum + "", 5) +
                    fixedLengthString(allClassification.get(i).valueIndex.get(1).criterionNum + "", 5));
        }
    }

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