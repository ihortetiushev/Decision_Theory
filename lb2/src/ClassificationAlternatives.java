import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ClassificationAlternatives {
    static final String PATTERN = "#.0";
    List<ValueIndex> valueIndex;

    List<Integer> G = new ArrayList<>();
    double d1;
    double d2;
    BigDecimal p1;
    BigDecimal p2;
    int g1;
    int g2;
    BigDecimal F1;
    BigDecimal F2;
    BigDecimal F;

    DecimalFormat decimalFormat = new DecimalFormat(PATTERN);

    @Override
    public String toString() {
        return  fixedLengthString(valueIndex + "",120) + fixedLengthString(
                " G = " + G,15 )+
                fixedLengthString("d1 = " + decimalFormat.format(d1) + "",13) +
                fixedLengthString("d2 = " + decimalFormat.format(d2) + "",13) +
                fixedLengthString("p1 = " + p1 + "",13) +
                fixedLengthString("p2 = " + p2 + "",13) +
                fixedLengthString("g1 = " + g1 + "",11) +
                fixedLengthString("g2 = " + g2 + "",11) +
                fixedLengthString("F1 = " + F1 + "",13) +
                fixedLengthString("F2 = " + F2 + "",13) +
                fixedLengthString("F = " + F + "",11) +
                '}';
    }
    public static String fixedLengthString(String string, int length) {
        return String.format("%1$-"+length+ "s", string);
    }
}
