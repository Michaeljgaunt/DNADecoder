
public class Driver {
    
    public static void main(String args[]) {
        
        GUI gui = new GUI();
        gui.setVisible(true);
    }
    
    public static void driver() {
        
        boolean strandFlag = GUI.isStrandButChecked();
        boolean codFlag = GUI.isCodButChecked();
        boolean enzFlag = GUI.isResEnzChecked();
        
        DNA DNAStrand = new DNA(GUI.getSequence());
        
        if(strandFlag) {
            DNAStrand.printDNA();
        }
        
        if(codFlag) {
            DNAStrand.printCodons();
        }
        
        if(enzFlag) {
            DNAStrand.printFragments(GUI.getCleavage());
        }
        
        if((!strandFlag && !codFlag && !enzFlag) && (DNAStrand.getStrandValidity())) {
            System.err.print("\n  No functions have been selected. Select a funciton using the menu at the top of the window.");
        }
        
    } 
}
