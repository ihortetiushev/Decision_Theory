import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Alternative {
    String alternativeName;
    List<Map.Entry<Criterion, Integer>> criterionValue = new ArrayList<>();

    @Override
    public String toString() {
        return "Альтернатива " + alternativeName + ":  " + criterionValue;
    }
}
