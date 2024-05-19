import java.util.ArrayList;
import java.util.List;

public class AlternativesVote {
    int voteAmount;
    List<Alternative> alternatives = new ArrayList<>();

    @Override
    public String toString() {
        return voteAmount + "" + alternatives;
    }
}
