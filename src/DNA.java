
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
        //Removing all white space and putting DNA sequence into uppercase.
        sequence = sequence.toUpperCase().replaceAll("\\s+","");
        //Checking the sequence is valid.
        checkValidStrand(sequence);
        if(validFlag) {
            strandLength = sequence.length();
            //Putting the sequence into an array.
            nucleotideSequence1 = new char[strandLength];
            nucleotideSequence1 = sequence.toCharArray();
            //Generating the sequence's complementary sequence.
            generateComplementaryStrand();
            //Creating a new protein map and decoding the DNA sequence.
            protein = new Protein();
            decodeCodons();
        }
    }
    
    //Method to check if the input sequence is a valid DNA sequence.
    private static void checkValidStrand(String sequence) {
        //Checking to see if only A, C, G and T have been input.
        if (!sequence.matches("[ATGC]+")) {
            System.err.println("  Invalid input detected. DNA can only contain A, T, C or G nucleotides.");
            validFlag = false;
        //Checking to see if the sequence has a length that is a multiple of 3.
        } else if (sequence.length() % 3 != 0) {
            System.err.println("  Invalid input detected. The DNA strand length must be divisible by 3.");
            validFlag = false;
        } else {
            validFlag = true;
        }
    }
    
    //Getter for sequence validity.
    public boolean getStrandValidity() {
        return validFlag;
    }
    
    //Method to generate a complemetary sequence.
    private static void generateComplementaryStrand() {
        //Instantiating a new array to hold the complementary sequence.
        nucleotideSequence2 = new char[strandLength];
        //Iterating over the whole sequence:
        for(int i = 0; i < strandLength; i++) {
            //Checking the current letter and putting in the corresponding letter.
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
    
    //Method to print the complementary strand.
    public void printDNA() {
        if(validFlag) {
            System.out.println("\n       Input strand: ");
            System.out.print("       ");
            //Iterating over the first sequence.
            for(int i = 0; i < nucleotideSequence1.length; i++) {
                //When the sequence gets too long for the screen, a new line is printed.
                if(i % 80 == 0 && i != 0) {
                    System.out.print("\n       ");
                }
                System.out.print(nucleotideSequence1[i] + " ");
            }
            System.out.println();
            System.out.println("\n       Complementary strand:");
            System.out.print("       ");
            //Iterating over the first sequence.
            for(int i = 0; i < nucleotideSequence2.length; i++) {
                //When the sequence gets too long for the screen, a new line is printed.
                if(i % 80 == 0 && i != 0) {
                    System.out.print("\n       ");
                }
                System.out.print(nucleotideSequence2[i] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }
    
    //Method to decode the codons into amino acids.
    private void decodeCodons() {
        int count = 0;
        int index = 0;
        String codon = "";
        
        //Creating arrays to hold the codons.
        codonSequence1 = new String[nucleotideSequence1.length / 3];
        codonSequence2 = new String[nucleotideSequence2.length / 3];
        
        //For each nucleotide in the sequence:
        for(char nucleotide : nucleotideSequence1) {
            
            //If the counter reache three and is not the first codon:
            if(count % 3 == 0 && count != 0) {
                //The codon is put into the array.
                codonSequence1[index] = codon;
                //The codon is reset and index is incremented.
                codon = "";
                index++;
            }
            //The codon has the nucleotide added to it and count incremented.
            codon += nucleotide;
            count++;
        }
        
        codonSequence1[index] = codon;
        codon = "";
        index = 0;
        count = 0;
        
        //The same is repeated for the second nucleotide sequence.
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
        
        //A new protein map is called.
        Map acids = protein.getProteins();
        
        //New arrays to hold the amino acids are created.
        acidSequence1 = new String[codonSequence1.length];
        acidSequence2 = new String[codonSequence2.length];
        
        //Using the map to decode the codons into amino acids.
        for(int i = 0; i < acidSequence1.length; i++) {
            acidSequence1[i] = acids.get(codonSequence1[i]).toString();
        }
        for(int i = 0; i < acidSequence2.length; i++) {
            acidSequence2[i] = acids.get(codonSequence2[i]).toString();
        }
    }
    
    //Method to print the codons to the user.
    public void printCodons() { 
        if(validFlag) {
            System.out.println("\n       Primary Strand codons: ");
            System.out.print("       ");
            //Iterating over the codons:
            for(int i = 0; i < codonSequence1.length; i++) {
                //If the length becomes too big for the screen, a new line is printed.
                if(i % 25 == 0 && i != 0) {
                    System.out.print("\n       ");
                }
                //Printing -'s between each codon, except if it is the final one.
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
            //Iterating over the amino acids.
            for(int i = 0; i < acidSequence1.length; i++) {
                //If the length becomes too big for the screen, a new line is printed.
                if(i % 27 == 0 && i != 0) {
                    System.out.print("\n       ");
                }
                //Printing -'s between each amino acid, except if it is the final one.
                if(i == (acidSequence1.length - 1)) {
                    System.out.print(acidSequence1[i]);
                } else {
                System.out.print(acidSequence1[i] + " - ");
                }
            }
            System.out.print("       ");
            System.out.println();
            System.out.println();

            //Repeated for the second sequence of codons/amino acids.
            
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
    
    //Method to get the fragments from a restriction enzyme.
    public void getFragments(RestrictionSequence resSeq) {        
        primaryFragments.clear();
        secondaryFragments.clear();
        
        //Appending the nucleotides into a StringBuilder
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
        
        //Getting an array that holds the indexes of the cut occurances
        Object[] occArr1 = getCuts(resSeq, nucSeq1Str, true);
        Object[] occArr2 = getCuts(resSeq, nucSeq2Str, false);
       
        int numFrags = occArr1.length + 1;
        //If the number of fragments is one, then no cuts have occurred.
        if (numFrags == 1) {
            System.out.println("\n       " + GUI.getResEnzBut() + " will have no effect on this DNA sequence. The recognition site is not present.");
        } else {   
            //Otherwise, iterate over each fragment and add them to the arrays in sequence.
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
        
    //Method to print the fragments to the user.
    public void printFragments() {
        if(primaryFragments.isEmpty())
            return;
        System.out.println("\n       Primary strand fragments (" + GUI.getResEnzBut() + "):");
        for (int i = 0; i < primaryFragments.size(); i++) {
            System.out.println("\n       Fragment " + (i + 1));
            //Converting the fragment strings into characters.
            char[] fragChars = primaryFragments.get(i).toString().toCharArray();
            System.out.print("       ");
            //Iterating over the fragment:
            for (int j = 0; j < fragChars.length; j++) {
                //When the lenght becomes too long, print a new line.
                if(j % 80 == 0 && j != 0) {
                    System.out.print("\n       ");
                }
                System.out.print(fragChars[j] + " ");
            }
            System.out.println();
        }
        
        //Repeate for the secondary strand.
        
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
    
    //Method to get an array with the indexes of restriction enzyme cuts.
    private Object[] getCuts(RestrictionSequence resSeq, String strand, boolean primary) {
        ArrayList cutArr = new ArrayList();
        //If it is the primary strand:
        if (primary) {
            //Finding the first occurence of the restriction enzyme cut.
            int occIndex = strand.indexOf(resSeq.getPriResSeq());
            //If there is one, add it to the array.
            while (occIndex >= 0) {
                cutArr.add(occIndex + resSeq.getPrimaryCutIndex());
                //Look for more cuts following the current index.
                occIndex = strand.indexOf(resSeq.getPriResSeq(), (occIndex + 1));
            }
        //If it is the secondary strand.
        } else {
            //Process is repeated, but cut indexes are slightly different.
            int occIndex = strand.indexOf(resSeq.getSecResSeq());
            while (occIndex >= 0) {
                cutArr.add(occIndex + resSeq.getSecondaryCutIndex());
                occIndex = strand.indexOf(resSeq.getSecResSeq(), (occIndex + 1));
            }   
        }        
        return cutArr.toArray();
    }
            
    
}
