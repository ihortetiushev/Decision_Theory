import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClassificationAlternatives {

    List<ValueIndex> valueIndex;
    List<Integer> G = new ArrayList<>();
    int d1;
    int d2;
    BigDecimal p1;
    BigDecimal p2;
    int g1 = 99;
    int g2 = 99;
    int F1;
    int F2;
    int F;

    @Override
    public String toString() {
        return  fixedLengthString(valueIndex + "",120) + fixedLengthString(
                " G = " + G,15 )+
                fixedLengthString("d1 = " + d1 + "",10) +
                fixedLengthString("d2 = " + d2 + "",10) +
                fixedLengthString("p1 = " + p1 + "",12) +
                fixedLengthString("p2 = " + p2 + "",12) +
                fixedLengthString("g1 = " + g1 + "",12) +
                fixedLengthString("g2 = " + g2 + "",12) +
                /*", F1=" + F1 +
                ", F2=" + F2 +
                ", F=" + F +*/
                '}';
    }

    public static String fixedLengthString(String string, int length) {
        return String.format("%1$-"+length+ "s", string);
    }
}
