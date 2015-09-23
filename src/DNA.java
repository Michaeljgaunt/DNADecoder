
import java.util.ArrayList;
import java.util.Map;


public class DNA {
    
    private static int strandLength;
    private static char[] nucleotideSequence1;
    private static char[] nucleotideSequence2;
    private static String[] codonSequence1;
    private static String[] codonSequence2;
    private static String[] acidSequence1;
    private static String[] acidSequence2;
    public static boolean validFlag;    
    private static ArrayList primaryFragments = new ArrayList();
    private static ArrayList secondaryFragments = new ArrayList();
    private static ArrayList primaryFragmentCodons = new ArrayList();
    private static ArrayList secondaryFragmentCodons = new ArrayList();
    Protein protein;
    
    public DNA(String sequence) {
        sequence = sequence.toUpperCase().replaceAll("\\s+","");
        checkValidStrand(sequence);
        if(validFlag) {
            strandLength = sequence.length();
            nucleotideSequence1 = new char[strandLength];
            nucleotideSequence1 = sequence.toCharArray();
            generateComplementaryStrand();
            protein = new Protein();
            decodeCodons();
        }
    }
    
    private static void checkValidStrand(String sequence) {
        if (!sequence.matches("[ATGC]+")) {
            System.err.println("  Invalid input detected. DNA can only contain A, T, C or G nucleotides.");
            validFlag = false;
        } else if (sequence.length() % 3 != 0) {
            System.err.println("  Invalid input detected. The DNA strand length must be divisible by 3.");
            validFlag = false;
        } else {
            validFlag = true;
        }
    }
    
    public boolean getStrandValidity() {
        return validFlag;
    }
    
    private static void generateComplementaryStrand() {
        nucleotideSequence2 = new char[strandLength];
        for(int i = 0; i < strandLength; i++) {
            switch (nucleotideSequence1[i]) {
                case 'A':
                    nucleotideSequence2[i] = 'T';
                    break;
                case 'T':
                    nucleotideSequence2[i] = 'A';
                    break;
                case 'C':
                    nucleotideSequence2[i] = 'G';
                    break;
                case 'G':
                    nucleotideSequence2[i] = 'C';
                    break;
            }
        }
    }
    
    public void printDNA() {
        if(validFlag) {
            System.out.println("\n       Input strand: ");
            System.out.print("       ");
            for(int i = 0; i < nucleotideSequence1.length; i++) {
                if(i % 80 == 0 && i != 0) {
                    System.out.print("\n       ");
                }
                System.out.print(nucleotideSequence1[i] + " ");
            }
            System.out.println();
            System.out.println("\n       Complementary strand:");
            System.out.print("       ");
            for(int i = 0; i < nucleotideSequence2.length; i++) {
                if(i % 80 == 0 && i != 0) {
                    System.out.print("\n       ");
                }
                System.out.print(nucleotideSequence2[i] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }
    
    private void decodeCodons() {
        int count = 0;
        int index = 0;
        String codon = "";
        codonSequence1 = new String[nucleotideSequence1.length / 3];
        codonSequence2 = new String[nucleotideSequence2.length / 3];
        
        for(char nucleotide : nucleotideSequence1) {

            if(count % 3 == 0 && count != 0) {
                codonSequence1[index] = codon;
                codon = "";
                index++;
            }
            codon += nucleotide;
            count++;
        }
        
        codonSequence1[index] = codon;
        codon = "";
        index = 0;
        count = 0;
        
        for(char nucleotide : nucleotideSequence2) {
            if(count % 3 == 0 && count != 0) {
                codonSequence2[index] = codon;
                codon = "";
                index++;
            }
            codon += nucleotide;
            count++;
        }
        
        codonSequence2[index] = codon;
        
        Map acids = protein.getProteins();
        
        acidSequence1 = new String[codonSequence1.length];
        acidSequence2 = new String[codonSequence2.length];
        
        for(int i = 0; i < acidSequence1.length; i++) {
            acidSequence1[i] = acids.get(codonSequence1[i]).toString();
        }
        for(int i = 0; i < acidSequence2.length; i++) {
            acidSequence2[i] = acids.get(codonSequence2[i]).toString();
        }
    }
    
    public void printCodons() { 
        if(validFlag) {
            System.out.println("\n       Primary Strand codons: ");
            System.out.print("       ");
            for(int i = 0; i < codonSequence1.length; i++) {
                if(i % 25 == 0 && i != 0) {
                    System.out.print("\n       ");
                }
                if(i == (codonSequence1.length - 1)) {
                    System.out.print(codonSequence1[i]);
                } else {
                System.out.print(codonSequence1[i] + " - ");
                }
            }
            System.out.print("       ");
            System.out.println();
            System.out.println("\n       Primary strand amino acid sequence: ");
            System.out.print("       ");
            for(int i = 0; i < acidSequence1.length; i++) {
                if(i % 27 == 0 && i != 0) {
                    System.out.print("\n       ");
                }
                if(i == (acidSequence1.length - 1)) {
                    System.out.print(acidSequence1[i]);
                } else {
                System.out.print(acidSequence1[i] + " - ");
                }
            }
            System.out.print("       ");
            System.out.println();
            System.out.println();

            System.out.println("\n       Secondary Strand codons: ");
            System.out.print("       ");
            for(int i = 0; i < codonSequence2.length; i++) {
                if(i % 25 == 0 && i != 0) {
                    System.out.print("\n       ");
                }
                if(i == (codonSequence2.length - 1)) {
                    System.out.print(codonSequence2[i]);
                } else {
                System.out.print(codonSequence2[i] + " - ");
                }
            }
            System.out.print("       ");
            System.out.println();
            System.out.println("\n       Secondary strand amino acid sequence: ");
            System.out.print("       ");
            for(int i = 0; i < acidSequence2.length; i++) {
                if(i % 27 == 0 && i != 0) {
                    System.out.print("\n       ");
                }
                if(i == (acidSequence2.length - 1)) {
                    System.out.print(acidSequence2[i]);
                } else {
                System.out.print(acidSequence2[i] + " - ");
                }
            }
            System.out.print("       ");
            System.out.println();
            System.out.println();
        }
    }
    
    public void getFragments(RestrictionSequence resSeq) {        
        primaryFragments.clear();
        secondaryFragments.clear();
        
        StringBuilder nucSeq1StrB = new StringBuilder();
        for(char nucleotide : nucleotideSequence1) {
            nucSeq1StrB.append(nucleotide);
        }
        
        StringBuilder nucSeq2StrB = new StringBuilder();
        for(char nucleotide : nucleotideSequence2) {
            nucSeq2StrB.append(nucleotide);
        }
        
        String nucSeq1Str = nucSeq1StrB.toString();
        String nucSeq2Str = nucSeq2StrB.toString();
        
        Object[] occArr1 = getCuts(resSeq, nucSeq1Str, true);
        Object[] occArr2 = getCuts(resSeq, nucSeq2Str, false);
       
        int numFrags = occArr1.length + 1;
        if (numFrags == 1) {
            System.out.println("\n       " + GUI.getResEnzBut() + " will have no effect on this DNA sequence. The recognition site is not present.");
        } else {   
            for (int i = 0; i < numFrags; i++) {
                if (i == 0) {
                    primaryFragments.add(nucSeq1Str.substring(0, (int)occArr1[i]));
                    secondaryFragments.add(nucSeq2Str.substring(0, (int)occArr2[i]));
                } else if (i == (numFrags - 1)) {
                    primaryFragments.add(nucSeq1Str.substring((int)occArr1[i - 1], nucSeq1Str.length()));
                    secondaryFragments.add(nucSeq2Str.substring((int)occArr2[i - 1], nucSeq1Str.length()));
                } else {
                    primaryFragments.add(nucSeq1Str.substring((int)occArr1[i - 1], (int)occArr1[i]));
                    secondaryFragments.add(nucSeq2Str.substring((int)occArr2[i - 1], (int)occArr2[i]));
                }
            }
        }
    }
        
    public void printFragments() {
        if(primaryFragments.isEmpty())
            return;
        System.out.println("\n       Primary strand fragments (" + GUI.getResEnzBut() + "):");
        for (int i = 0; i < primaryFragments.size(); i++) {
            System.out.println("\n       Fragment " + (i + 1));
            char[] fragChars = primaryFragments.get(i).toString().toCharArray();
            System.out.print("       ");
            for (int j = 0; j < fragChars.length; j++) {
                if(j % 80 == 0 && j != 0) {
                    System.out.print("\n       ");
                }
                System.out.print(fragChars[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("\n       Secondary strand fragments (" + GUI.getResEnzBut() + "):");
        for (int i = 0; i < secondaryFragments.size(); i++) {
            System.out.println("\n       Fragment " + (i + 1));
            char[] fragChars = secondaryFragments.get(i).toString().toCharArray();
            System.out.print("       ");
            for (int j = 0; j < fragChars.length; j++) {
                if(j % 80 == 0 && j != 0) {
                    System.out.print("\n       ");
                }
                System.out.print(fragChars[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
    
    private Object[] getCuts(RestrictionSequence resSeq, String strand, boolean primary) {
        ArrayList cutArr = new ArrayList();
        if (primary) {
            int occIndex = strand.indexOf(resSeq.getPriResSeq());
            while (occIndex >= 0) {
                cutArr.add(occIndex + resSeq.getPrimaryCutIndex());
                occIndex = strand.indexOf(resSeq.getPriResSeq(), (occIndex + 1));
            }
        } else {
            int occIndex = strand.indexOf(resSeq.getSecResSeq());
            while (occIndex >= 0) {
                cutArr.add(occIndex + resSeq.getSecondaryCutIndex());
                occIndex = strand.indexOf(resSeq.getSecResSeq(), (occIndex + 1));
            }   
        }        
        return cutArr.toArray();
    }
            
    
}
