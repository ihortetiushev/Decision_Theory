import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Завдання 2, Профіль голосування:");
        List<AlternativesVote> allAlternativesVote = AlternativesVoteInit.initializeAlternativesVote();

        for (int i = 0; i < allAlternativesVote.size(); i++) {
            System.out.print(allAlternativesVote.get(i).voteAmount + "      ");
        }
        System.out.println("Вага альтернативи");
        System.out.println();
        for (int j = 0; j < allAlternativesVote.size(); j++) {
            for (int k = 0; k < allAlternativesVote.size(); k++) {
                System.out.print(allAlternativesVote.get(k).alternatives.get(j).alternativeName + "       ");
            }
            System.out.print("       " + (allAlternativesVote.size() - j - 1));
            System.out.println();
        }

        System.out.println();
        System.out.println("Завдання 3, за правилом відносної більшості");
        relativeMajorityRule(allAlternativesVote);
        System.out.println();

        System.out.println("Завдання 4, за правилом абсолютної більшості");
        absoluteMajorityRule(allAlternativesVote);
        System.out.println();

        System.out.println("Завдання 5, за правилом Борда");
        boardRule(allAlternativesVote);
        System.out.println();

        System.out.println("Завдання 6, за правилом Кондорсе (дуелі)");
        condorceRule(allAlternativesVote);


    }


    public static void condorceRule(List<AlternativesVote> allAlternativesVote) {

        System.out.println("N = 6*5/2 = 15 попарних порівнянь:");
        System.out.println("AB, AC, AD, AE, AF, BC, BD, BE, BF, CD, CE, CF, DE, DF, EF");
        System.out.println();
        twoAlternative(allAlternativesVote, "A", "B");
        twoAlternative(allAlternativesVote, "A", "C");
        twoAlternative(allAlternativesVote, "A", "D");
        twoAlternative(allAlternativesVote, "A", "E");
        twoAlternative(allAlternativesVote, "A", "F");

        twoAlternative(allAlternativesVote, "B", "C");
        //не работает с BD
        twoAlternative(allAlternativesVote, "B", "D");
        twoAlternative(allAlternativesVote, "B", "E");
        twoAlternative(allAlternativesVote, "A", "F");

        twoAlternative(allAlternativesVote, "C", "D");
        twoAlternative(allAlternativesVote, "C", "E");
        twoAlternative(allAlternativesVote, "C", "F");

        twoAlternative(allAlternativesVote, "D", "E");
        twoAlternative(allAlternativesVote, "D", "F");

        twoAlternative(allAlternativesVote, "E", "F");

    }

    public static void twoAlternative(List<AlternativesVote> allAlternativesVote, String alternativeNameOne, String alternativeNameTwo) {
        List<AlternativesVote> listAlternativesWithCondition = findListAlternativesWithCondition(allAlternativesVote, Map.of(alternativeNameOne, 0, alternativeNameTwo, 0));
        Map.Entry<String, Integer> stringIntegerEntry = calculateMax(listAlternativesWithCondition);
        Map<String, Integer> alternativeWins = new HashMap<>();
        //alternativeWins.get(stringIntegerEntry.getKey());
        Integer count = alternativeWins.get(stringIntegerEntry.getKey());
        if(count == null) {
            alternativeWins.put(stringIntegerEntry.getKey(), 1);
        } else {
            alternativeWins.put(stringIntegerEntry.getKey(), count++);
        }
        System.out.println("Альтернатива-переможниця - " + stringIntegerEntry.getKey() + ", Кількість голосів - "+stringIntegerEntry.getValue() );
    }


    public static void boardRule(List<AlternativesVote> allAlternativesVote) {
        Map<String, Integer> alternativeVotes = new HashMap<>();
        for (AlternativesVote alternativesVote : allAlternativesVote) {
            List<Alternative> alternatives = alternativesVote.alternatives;
            for (int row = 0; row < alternatives.size(); row++) {
                String alternativeName = alternatives.get(row).alternativeName;
                Integer storedScore = alternativeVotes.get(alternativeName);
                int weight = alternatives.size() - 1 - row;
                int currentScore = alternativesVote.voteAmount * weight;
                int score;
                if (storedScore == null) {
                    score = currentScore;
                } else {
                    score = storedScore + currentScore;
                }
                alternativeVotes.put(alternativeName, score);
            }
        }

        Map.Entry<String, Integer> max = Map.entry("Unknown", 0);
        for (Map.Entry<String, Integer> entry : alternativeVotes.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value > max.getValue()) {
                max = entry;
            }
            System.out.println("Альтернатива - " + key + ", Кількість голосів - " + value);
        }

        System.out.println("Альтернатива-переможниця - " + max.getKey() + ", Кількість голосів - " + max.getValue());
    }


    public static void absoluteMajorityRule(List<AlternativesVote> allAlternativesVote) {
        Map<String, Integer> alternativeVotes = new HashMap<>();
        for (int i = 0; i < allAlternativesVote.size(); i++) {
            String alternativeName = allAlternativesVote.get(i).alternatives.get(0).alternativeName;
            Integer count = alternativeVotes.get(alternativeName);
            if (count == null) {
                alternativeVotes.put(alternativeName, allAlternativesVote.get(i).voteAmount);
            } else {
                alternativeVotes.put(alternativeName, count + allAlternativesVote.get(i).voteAmount);
            }
        }
        for (Map.Entry<String, Integer> entry : alternativeVotes.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Альтернатива - " + key + ", Кількість голосів - " + value);
        }

        List<Integer> voteAmountList = new ArrayList<>();
        voteAmountList.addAll(alternativeVotes.values());
        Collections.sort(voteAmountList);
        Integer maxVote1 = voteAmountList.get(voteAmountList.size() - 1);
        Integer maxVote2 = voteAmountList.get(voteAmountList.size() - 2);

        Map<String, Integer> maxx = new HashMap<>();
        for (Map.Entry<String, Integer> entry : alternativeVotes.entrySet()) {
            if (Objects.equals(maxVote1, entry.getValue()) || Objects.equals(maxVote2, entry.getValue())) {
                maxx.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println();
        System.out.println("Результат першого туру, альтернативи із максимальними голосами: " + maxx);
        List<AlternativesVote> maxOnly = findListAlternativesWithCondition(allAlternativesVote, maxx);
        Map.Entry<String, Integer> winner = calculateMax(maxOnly);
        System.out.println("Альтернатива-переможниця - " + winner.getKey() + ", Кількість голосів - " + winner.getValue());

    }

    private static Map.Entry<String, Integer> calculateMax(List<AlternativesVote> maxOnly) {
        Map<String, Integer> superMax = new HashMap<>();
        for (AlternativesVote vote : maxOnly) {
            String name = vote.alternatives.get(0).alternativeName;
            Integer total = superMax.get(name);
            int count;
            if (total == null) {
                count = vote.voteAmount;
            } else {
                count = total + vote.voteAmount;
            }
            superMax.put(name, count);
        }
        System.out.println(superMax);
        List<String> keys = superMax.keySet().stream().toList();
        String maxKey;
        if (superMax.get(keys.get(0)) >= superMax.get(keys.get(1))) {
            maxKey = keys.get(0);
        } else {
            maxKey = keys.get(1);
        }
        return Map.entry(maxKey, superMax.get(maxKey));
    }

    public static List<AlternativesVote> findListAlternativesWithCondition(List<AlternativesVote> allAlternativesVote,
                                                                           Map<String, Integer> maxx) {
        List<AlternativesVote> newAlternativeVoteList = new ArrayList<>();
        for (AlternativesVote alternativesVote : allAlternativesVote) {
            AlternativesVote copyMaxxOnly = new AlternativesVote();
            newAlternativeVoteList.add(copyMaxxOnly);
            copyMaxxOnly.voteAmount = alternativesVote.voteAmount;
            List<Alternative> alternatives = alternativesVote.alternatives;
            for (Alternative alternative : alternatives) {
                if (maxx.containsKey(alternative.alternativeName)) {
                    copyMaxxOnly.alternatives.add(alternative);
                }
            }
        }
        return newAlternativeVoteList;
    }


    public static void relativeMajorityRule(List<AlternativesVote> allAlternativesVote) {
        Map<String, Integer> alternativeVotes = new HashMap<>();
        for (int i = 0; i < allAlternativesVote.size(); i++) {
            String alternativeName = allAlternativesVote.get(i).alternatives.get(0).alternativeName;
            Integer count = alternativeVotes.get(alternativeName);
            if (count == null) {
                alternativeVotes.put(alternativeName, allAlternativesVote.get(i).voteAmount);
            } else {
                alternativeVotes.put(alternativeName, count + allAlternativesVote.get(i).voteAmount);
            }
        }

        for (Map.Entry<String, Integer> entry : alternativeVotes.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Альтернатива - " + key + ", Кількість голосів - " + value);
        }
        String alternaviveName = null;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : alternativeVotes.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                alternaviveName = entry.getKey();
            }
        }
        System.out.println("Альтернатива-переможниця -" +
                " " + alternaviveName + ", Кількість голосів - " + maxValue);
    }
}