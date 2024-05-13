import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AlternativeResultInit {
    public static AlternativeResult[][] initializeAlternativeForCriterion1() {
        AlternativeResult[][] alternativeCriterion1Result = new AlternativeResult[7][7];

        alternativeRatingAssigning(alternativeCriterion1Result,0,0,BigDecimal.ONE,"1.0");
        alternativeRatingAssigning(alternativeCriterion1Result,0,1,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion1Result,0,2,BigDecimal.valueOf(7.0),"7.0");
        alternativeRatingAssigning(alternativeCriterion1Result,0,3,BigDecimal.valueOf(1.0/7.0),"1/7");
        alternativeRatingAssigning(alternativeCriterion1Result,0,4,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion1Result,0,5,BigDecimal.ONE,"1.0");
        alternativeRatingAssigning(alternativeCriterion1Result,0,6,BigDecimal.valueOf(1.0/5.0),"1/5");


        //до этого момента всё правильно
        alternativeRatingAssigning(alternativeCriterion1Result,1,2,BigDecimal.valueOf(1.0/7.0),"1/7");
        alternativeRatingAssigning(alternativeCriterion1Result,1,3,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion1Result,1,4,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion1Result,1,5,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion1Result,1,6,BigDecimal.valueOf(1.0/5.0),"1/5");


/*
        alternativeCriterion1Result2.criterionValue1 = alternatives.get(0).criterionValue.get(0);
        alternativeCriterion1Result2.criterionValue2 = alternatives.get(1).criterionValue.get(0);
        alternativeCriterion1Result2.alternativeMarkValue = BigDecimal.valueOf(1.0/5.0);
        alternativeCriterion1Result2.alternativeStringMark = "1/5";
        compareForCriterion1Result.add(alternativeCriterion1Result2);

        alternativeCriterion1Result3.criterionValue1 = alternatives.get(0).criterionValue.get(0);
        alternativeCriterion1Result3.criterionValue2 = alternatives.get(0).criterionValue.get(0);
        alternativeCriterion1Result3.alternativeMarkValue = BigDecimal.ONE;
        alternativeCriterion1Result3.alternativeStringMark = "1.0";
        compareForCriterion1Result.add(alternativeCriterion1Result3);

        alternativeCriterion1Result2.criterionValue1 = alternatives.get(0).criterionValue.get(0);
        alternativeCriterion1Result2.criterionValue2 = alternatives.get(0).criterionValue.get(0);
        alternativeCriterion1Result2.alternativeMarkValue = BigDecimal.ONE;
        alternativeCriterion1Result2.alternativeStringMark = "1.0";
        compareForCriterion1Result.add(alternativeCriterion1Result2);
*/


        return alternativeCriterion1Result;
    }

    private static void alternativeRatingAssigning (AlternativeResult[][] alternativeResult, int criterionIndex1, int criterionIndex2,
                                                                  BigDecimal alternativeMarkValue, String alternativeStringMark) {
        AlternativeResult alternativeCriterionResult = new AlternativeResult();
        alternativeResult[criterionIndex1][criterionIndex2] = alternativeCriterionResult;

        alternativeCriterionResult.alternativeMarkValue = alternativeMarkValue;
        alternativeCriterionResult.alternativeStringMark = alternativeStringMark;
    }
}
