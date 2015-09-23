
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
        }
    }
    
    public void printFragments(RestrictionSequence resSeq) {        
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
        
        int firstOcc = nucSeq1Str.indexOf(resSeq.getResSeq());
        int firstCutPoint = firstOcc + resSeq.getPrimaryCutIndex();
        System.out.println("cut point: " + firstCutPoint);
        int secondCutPoint = firstOcc + resSeq.getSecondaryCutIndex();
        
        String[] fragments1 = new String[nucSeq1Str.length()];
        String[] fragments2 = new String[nucSeq1Str.length()];
    }
    
}
