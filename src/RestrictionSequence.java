
public class RestrictionSequence {
    private static String priResSeq = null;
    private static String secResSeq = null;
    private static int primaryCutIndex = 0;
    private static int secondaryCutIndex = 0;
    
    public RestrictionSequence(String resSeq, int primaryCutIndex, int secondaryCutIndex) {
       RestrictionSequence.priResSeq = resSeq;
       StringBuilder reverse = new StringBuilder(resSeq).reverse();
       RestrictionSequence.secResSeq = reverse.toString();
       RestrictionSequence.primaryCutIndex = primaryCutIndex;
       RestrictionSequence.secondaryCutIndex = secondaryCutIndex;
    }
    
    public String getPriResSeq() {
        return priResSeq;
    }
    
    public String getSecResSeq() {
        return secResSeq;
    }
    
    public int getPrimaryCutIndex() {
        return primaryCutIndex;
    }
    
    public int getSecondaryCutIndex() {
        return secondaryCutIndex;
    }
}
