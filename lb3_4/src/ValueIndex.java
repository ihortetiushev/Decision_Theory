import java.util.ArrayList;
import java.util.List;

public class ValueIndex {
    String value;
    int index;
    int criterionNum;

    ValueIndex(int criterionNum, int index, String value) {
        this.criterionNum = criterionNum;
        this.index = index;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(k = " + criterionNum + (index + 1) + ")" + " \"" + value + "\"";
    }
    public static String fixedLengthString(String string, int length) {
        return String.format("%1$-"+length+ "s", string);
    }
    static boolean isBetterOrSame(List<Integer> result) {
        //better means all <=0
        boolean better = true;
        for (Integer res : result) {
            if (res > 0) {
                //if at least single value is worse, then it make no sense to continue
                better = false;
                break;
            }
        }
        return better;
    }

    static boolean isWorse(List<Integer> result) {
        //worse means all >0
        boolean worse = true;
        for (Integer res : result) {
            if (res <= 0) {
                //if at least single value is better or same, then it make no sense to continue
                worse = false;
                break;
            }
        }
        return worse;
    }

    static List<Integer> compare(List<ValueIndex> first, List<ValueIndex> second) {

        if (first.size() != second.size()) {
            throw new IllegalArgumentException("Can't compare two lists with different size");
        }
        List<Integer> result = new ArrayList<>(first.size());
        for (int i = 0; i < first.size(); i++) {
            result.add(Integer.compare(first.get(i).index, second.get(i).index));
        }
        return result;
    }
}
