
public class RestrictionSequence {
    private static String resSeq = null;
    private static int primaryCutIndex = 0;
    private static int secondaryCutIndex = 0;
    
    public RestrictionSequence(String resSeq, int primaryCutIndex, int secondaryCutIndex) {
       RestrictionSequence.resSeq = resSeq;
       RestrictionSequence.primaryCutIndex = primaryCutIndex;
       RestrictionSequence.secondaryCutIndex = secondaryCutIndex;
    }
    
    public String getResSeq() {
        return resSeq;
    }
    
    public int getPrimaryCutIndex() {
        return primaryCutIndex;
    }
    
    public int getSecondaryCutIndex() {
        return secondaryCutIndex;
    }
}
