import java.util.ArrayList;
import java.util.List;

public class AlternativesVoteInit {
    public static List<AlternativesVote> initializeAlternativesVote() {
        List<Alternative> alternatives = AlternativeInit.initializeAlternative(CriterionInit.initialize());
        List<AlternativesVote> alternativesVoteList = new ArrayList<>();

        AlternativesVote column1 = new AlternativesVote();
        column1.voteAmount = 14;
        column1.alternatives = List.of(alternatives.get(0), alternatives.get(1),
                alternatives.get(2), alternatives.get(3), alternatives.get(5), alternatives.get(4));
        alternativesVoteList.add(column1);

        AlternativesVote column2 = new AlternativesVote();
        column2.voteAmount = 20;
        column2.alternatives = List.of(alternatives.get(5), alternatives.get(2),
                alternatives.get(1), alternatives.get(3), alternatives.get(0), alternatives.get(4));
        alternativesVoteList.add(column2);

        AlternativesVote column3 = new AlternativesVote();
        column3.voteAmount = 9;
        column3.alternatives = List.of(alternatives.get(4), alternatives.get(1),
                alternatives.get(5), alternatives.get(0), alternatives.get(3), alternatives.get(2));
        alternativesVoteList.add(column3);

        AlternativesVote column4 = new AlternativesVote();
        column4.voteAmount = 22;
        column4.alternatives = List.of(alternatives.get(0), alternatives.get(1),
                alternatives.get(2), alternatives.get(3), alternatives.get(5), alternatives.get(4));
        alternativesVoteList.add(column4);

        AlternativesVote column5 = new AlternativesVote();
        column5.voteAmount = 18;
        column5.alternatives = List.of(alternatives.get(2), alternatives.get(4),
                alternatives.get(3), alternatives.get(1), alternatives.get(0), alternatives.get(5));
        alternativesVoteList.add(column5);

        AlternativesVote column6 = new AlternativesVote();
        column6.voteAmount = 17;
        column6.alternatives = List.of(alternatives.get(4), alternatives.get(0),
                alternatives.get(5), alternatives.get(1), alternatives.get(2), alternatives.get(3));
        alternativesVoteList.add(column6);

        return alternativesVoteList;

    }


}
