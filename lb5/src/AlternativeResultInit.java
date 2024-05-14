import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AlternativeResultInit {

    public static AlternativeResult[][] initializeAlternativeForCriterion2() {
        AlternativeResult[][] alternativeCriterion2Result = new AlternativeResult[7][7];

        alternativeRatingAssigning(alternativeCriterion2Result,0,0,BigDecimal.ONE,"1.0");
        alternativeRatingAssigning(alternativeCriterion2Result,0,1,BigDecimal.valueOf(1.0/7.0),"1/7");
        alternativeRatingAssigning(alternativeCriterion2Result,0,2,BigDecimal.valueOf(5.0),"5.0");
        alternativeRatingAssigning(alternativeCriterion2Result,0,3,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion2Result,0,4,BigDecimal.valueOf(1.0/7.0),"1/7");
        alternativeRatingAssigning(alternativeCriterion2Result,0,5,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion2Result,0,6,BigDecimal.valueOf(1.7),"1/7");

        alternativeRatingAssigning(alternativeCriterion2Result,1,0,BigDecimal.valueOf(7.0),"7.0");
        alternativeRatingAssigning(alternativeCriterion2Result,1,1,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion2Result,1,2,BigDecimal.valueOf(9.0),"9.0");
        alternativeRatingAssigning(alternativeCriterion2Result,1,3,BigDecimal.valueOf(7.0),"7.0");
        alternativeRatingAssigning(alternativeCriterion2Result,1,4,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion2Result,1,5,BigDecimal.valueOf(5.0),"5.0");
        alternativeRatingAssigning(alternativeCriterion2Result,1,6,BigDecimal.valueOf(1.0),"1.0");

        alternativeRatingAssigning(alternativeCriterion2Result,2,0,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion2Result,2,1,BigDecimal.valueOf(1.0/9.0),"1/9");
        alternativeRatingAssigning(alternativeCriterion2Result,2,2,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion2Result,2,3,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion2Result,2,4,BigDecimal.valueOf(1.0/9.0),"1/9");
        alternativeRatingAssigning(alternativeCriterion2Result,2,5,BigDecimal.valueOf(1.0/7.0),"1/7");
        alternativeRatingAssigning(alternativeCriterion2Result,2,6,BigDecimal.valueOf(1.0/9.0),"1/9");

        alternativeRatingAssigning(alternativeCriterion2Result,3,0,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion2Result,3,1,BigDecimal.valueOf(1.0/7.0),"1/7");
        alternativeRatingAssigning(alternativeCriterion2Result,3,2,BigDecimal.valueOf(5.0),"5.0");
        alternativeRatingAssigning(alternativeCriterion2Result,3,3,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion2Result,3,4,BigDecimal.valueOf(1.0/7.0),"1/7");
        alternativeRatingAssigning(alternativeCriterion2Result,3,5,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion2Result,3,6,BigDecimal.valueOf(1.0/7.0),"1/7");

        alternativeRatingAssigning(alternativeCriterion2Result,4,0,BigDecimal.valueOf(7.0),"7.0");
        alternativeRatingAssigning(alternativeCriterion2Result,4,1,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion2Result,4,2,BigDecimal.valueOf(9.0),"9.0");
        alternativeRatingAssigning(alternativeCriterion2Result,4,3,BigDecimal.valueOf(7.0),"7.0");
        alternativeRatingAssigning(alternativeCriterion2Result,4,4,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion2Result,4,5,BigDecimal.valueOf(5.0),"5.0");
        alternativeRatingAssigning(alternativeCriterion2Result,4,6,BigDecimal.valueOf(1.0),"1.0");

        alternativeRatingAssigning(alternativeCriterion2Result,5,0,BigDecimal.valueOf(5.0),"5.0");
        alternativeRatingAssigning(alternativeCriterion2Result,5,1,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion2Result,5,2,BigDecimal.valueOf(7.0),"7.0");
        alternativeRatingAssigning(alternativeCriterion2Result,5,3,BigDecimal.valueOf(5.0),"5.0");
        alternativeRatingAssigning(alternativeCriterion2Result,5,4,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion2Result,5,5,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion2Result,5,6,BigDecimal.valueOf(1.0/5.0),"1/5");

        alternativeRatingAssigning(alternativeCriterion2Result,6,0,BigDecimal.valueOf(7.0),"7.0");
        alternativeRatingAssigning(alternativeCriterion2Result,6,1,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion2Result,6,2,BigDecimal.valueOf(9.0),"9.0");
        alternativeRatingAssigning(alternativeCriterion2Result,6,3,BigDecimal.valueOf(7.0),"7.0");
        alternativeRatingAssigning(alternativeCriterion2Result,6,4,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion2Result,6,5,BigDecimal.valueOf(5.0),"5.0");
        alternativeRatingAssigning(alternativeCriterion2Result,6,6,BigDecimal.valueOf(1.0),"1.0");

        return alternativeCriterion2Result;
    }

    public static AlternativeResult[][] initializeAlternativeForCriterion1() {
        AlternativeResult[][] alternativeCriterion1Result = new AlternativeResult[7][7];

        alternativeRatingAssigning(alternativeCriterion1Result,0,0,BigDecimal.ONE,"1.0");
        alternativeRatingAssigning(alternativeCriterion1Result,0,1,BigDecimal.valueOf(5.0),"5.0");
        alternativeRatingAssigning(alternativeCriterion1Result,0,2,BigDecimal.valueOf(1.0/7.0),"1/7");
        alternativeRatingAssigning(alternativeCriterion1Result,0,3,BigDecimal.valueOf(7.0),"7.0");
        alternativeRatingAssigning(alternativeCriterion1Result,0,4,BigDecimal.valueOf(5.0),"5.0");
        alternativeRatingAssigning(alternativeCriterion1Result,0,5,BigDecimal.ONE,"1.0");
        alternativeRatingAssigning(alternativeCriterion1Result,0,6,BigDecimal.valueOf(5.0),"5.0");

        alternativeRatingAssigning(alternativeCriterion1Result,1,0,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion1Result,1,1,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion1Result,1,2,BigDecimal.valueOf(1.0/7.0),"1/7");
        alternativeRatingAssigning(alternativeCriterion1Result,1,3,BigDecimal.valueOf(5.0),"5.0");
        alternativeRatingAssigning(alternativeCriterion1Result,1,4,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion1Result,1,5,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion1Result,1,6,BigDecimal.valueOf(1.0),"1.0");

        alternativeRatingAssigning(alternativeCriterion1Result,2,0,BigDecimal.valueOf(7.0),"7.0");
        alternativeRatingAssigning(alternativeCriterion1Result,2,1,BigDecimal.valueOf(9.0),"9.0");
        alternativeRatingAssigning(alternativeCriterion1Result,2,2,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion1Result,2,3,BigDecimal.valueOf(9.0),"9.0");
        alternativeRatingAssigning(alternativeCriterion1Result,2,4,BigDecimal.valueOf(9.0),"9.0");
        alternativeRatingAssigning(alternativeCriterion1Result,2,5,BigDecimal.valueOf(7.0),"7.0");
        alternativeRatingAssigning(alternativeCriterion1Result,2,6,BigDecimal.valueOf(7.0),"7.0");

        alternativeRatingAssigning(alternativeCriterion1Result,3,0,BigDecimal.valueOf(1.0/7.0),"1/7");
        alternativeRatingAssigning(alternativeCriterion1Result,3,1,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion1Result,3,2,BigDecimal.valueOf(1.0/9.0),"1/9");
        alternativeRatingAssigning(alternativeCriterion1Result,3,3,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion1Result,3,4,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion1Result,3,5,BigDecimal.valueOf(1.0/7.0),"1/7");
        alternativeRatingAssigning(alternativeCriterion1Result,3,6,BigDecimal.valueOf(1.0/5.0),"1/5");

        alternativeRatingAssigning(alternativeCriterion1Result,4,0,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion1Result,4,1,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion1Result,4,2,BigDecimal.valueOf(1.0/7.0),"1/7");
        alternativeRatingAssigning(alternativeCriterion1Result,4,3,BigDecimal.valueOf(5.0),"5.0");
        alternativeRatingAssigning(alternativeCriterion1Result,4,4,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion1Result,4,5,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion1Result,4,6,BigDecimal.valueOf(1.0),"1.0");

        alternativeRatingAssigning(alternativeCriterion1Result,5,0,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion1Result,5,1,BigDecimal.valueOf(5.0),"5.0");
        alternativeRatingAssigning(alternativeCriterion1Result,5,2,BigDecimal.valueOf(1.0/7.0),"1/7");
        alternativeRatingAssigning(alternativeCriterion1Result,5,3,BigDecimal.valueOf(7.0),"7.0");
        alternativeRatingAssigning(alternativeCriterion1Result,5,4,BigDecimal.valueOf(5.0),"5.0");
        alternativeRatingAssigning(alternativeCriterion1Result,5,5,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion1Result,5,6,BigDecimal.valueOf(5.0),"5.0");

        alternativeRatingAssigning(alternativeCriterion1Result,6,0,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion1Result,6,1,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion1Result,6,2,BigDecimal.valueOf(1.0/7.0),"1/7");
        alternativeRatingAssigning(alternativeCriterion1Result,6,3,BigDecimal.valueOf(5.0),"5.0");
        alternativeRatingAssigning(alternativeCriterion1Result,6,4,BigDecimal.valueOf(1.0),"1.0");
        alternativeRatingAssigning(alternativeCriterion1Result,6,5,BigDecimal.valueOf(1.0/5.0),"1/5");
        alternativeRatingAssigning(alternativeCriterion1Result,6,6,BigDecimal.valueOf(1.0),"1.0");

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
