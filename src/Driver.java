
public class Driver {
    
    public static void main(String args[]) {
        
        GUI gui = new GUI();
        gui.setVisible(true);
    }
    
    public static void driver() {
        
        boolean strandFlag = GUI.isStrandButChecked();
        boolean codFlag = GUI.isCodButChecked();
        
        DNA strand = new DNA(GUI.getSequence());
        
        if(strandFlag) {
            strand.printDNA();
        }
        
        if(codFlag) {
            strand.printCodons();
        }
        
        if(!strandFlag && !codFlag) {
            System.err.print("\n  No functions have been selected. Select a funciton using the menu at the top of the window.");
        }
        
    } 
}
