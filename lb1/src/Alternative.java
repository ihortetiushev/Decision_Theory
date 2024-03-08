public class Alternative {
    String criterionValue1;
    String criterionValue2;
    final static int k1 = 1;
    int index_k1;
    final  static int k2 = 2;

    int index_k2;

    @Override
    public String toString() {
        return "{" + "\'" + criterionValue1+ "\'" + ", " + '\'' + criterionValue2 + '\'' +
                '}';
    }
}
