
import java.util.HashMap;
import java.util.Map;



public class Protein {
    
    public static Map aminoAcid;
    
    public Protein() {
        aminoAcid = new HashMap();
        buildProteinMap();
    }
    
    private static void buildProteinMap() {
        aminoAcid.put("AAA", "Lys"); aminoAcid.put("AAT", "Asn"); aminoAcid.put("AAC", "Asn"); aminoAcid.put("AAG", "Lys");
        aminoAcid.put("ATA", "Ile"); aminoAcid.put("ATT", "Ile"); aminoAcid.put("ATC", "Ile"); aminoAcid.put("ATG", "Met");
        aminoAcid.put("ACA", "Thr"); aminoAcid.put("ACT", "Thr"); aminoAcid.put("ACC", "Thr"); aminoAcid.put("ACG", "Thr");
        aminoAcid.put("AGA", "Arg"); aminoAcid.put("AGT", "Ser"); aminoAcid.put("AGC", "Ser"); aminoAcid.put("AGG", "Arg");  
        
        aminoAcid.put("TAA", "STOP"); aminoAcid.put("TAT", "Tyr"); aminoAcid.put("TAC", "Tyr"); aminoAcid.put("TAG", "STOP");     
        aminoAcid.put("TTA", "Leu"); aminoAcid.put("TTT", "Phe"); aminoAcid.put("TTC", "Phe"); aminoAcid.put("TTG", "Phe");
        aminoAcid.put("TCA", "Ser"); aminoAcid.put("TCT", "Ser"); aminoAcid.put("TCC", "Ser"); aminoAcid.put("TCG", "Ser");
        aminoAcid.put("TGA", "STOP"); aminoAcid.put("TGT", "Cys"); aminoAcid.put("TGC", "Cys"); aminoAcid.put("TGG", "Trp");
             
        aminoAcid.put("CAA", "Gln"); aminoAcid.put("CAT", "His"); aminoAcid.put("CAC", "His"); aminoAcid.put("CAG", "Gln");           
        aminoAcid.put("CTA", "Leu"); aminoAcid.put("CTT", "Leu"); aminoAcid.put("CTC", "Leu"); aminoAcid.put("CTG", "Leu");
        aminoAcid.put("CCA", "Pro"); aminoAcid.put("CCT", "Pro"); aminoAcid.put("CCC", "Pro"); aminoAcid.put("CCG", "Pro");
        aminoAcid.put("CGA", "Arg"); aminoAcid.put("CGT", "Arg"); aminoAcid.put("CGC", "Arg"); aminoAcid.put("CGG", "Arg");
        
        aminoAcid.put("GAA", "Glu"); aminoAcid.put("GAT", "Asp"); aminoAcid.put("GAC", "Asp"); aminoAcid.put("GAG", "Glu");
        aminoAcid.put("GTA", "Val"); aminoAcid.put("GTT", "Val"); aminoAcid.put("GTC", "Val"); aminoAcid.put("GTG", "Val");
        aminoAcid.put("GCA", "Ala"); aminoAcid.put("GCT", "Ala"); aminoAcid.put("GCC", "Ala"); aminoAcid.put("GCG", "Ala");
        aminoAcid.put("GGA", "Gly"); aminoAcid.put("GGT", "Gly"); aminoAcid.put("GGC", "Gly"); aminoAcid.put("GGG", "Gly"); 
    }
    
    public Map getProteins() {
        return aminoAcid;
    }
}
