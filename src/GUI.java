
import java.io.PrintStream;

public class GUI extends javax.swing.JFrame {

    public GUI() {
        initComponents();
        PrintStream printStream = new PrintStream(new GUIOutput(output));
        System.setOut(printStream);
        System.setErr(printStream);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        resEnzButs = new javax.swing.ButtonGroup();
        seqPanel = new javax.swing.JPanel();
        seqInput = new javax.swing.JTextField();
        promptLab = new javax.swing.JLabel();
        butPanel = new javax.swing.JPanel();
        clearOutputBut = new javax.swing.JButton();
        runBut = new javax.swing.JButton();
        clearInputBut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        quitBut = new javax.swing.JMenuItem();
        functionMenu = new javax.swing.JMenu();
        strandBut = new javax.swing.JCheckBoxMenuItem();
        codBut = new javax.swing.JCheckBoxMenuItem();
        resEnzMenu = new javax.swing.JMenu();
        noneBut = new javax.swing.JRadioButtonMenuItem();
        aluiBut = new javax.swing.JRadioButtonMenuItem();
        BamHIBut = new javax.swing.JRadioButtonMenuItem();
        EcoRIBut = new javax.swing.JRadioButtonMenuItem();
        HaeIIIBut = new javax.swing.JRadioButtonMenuItem();
        HindIIIBut = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        seqInput.setText(" gagttttatc gcttccatga cgcagaagtt aacactttcg gatatttctg atgagtcgaa aaattatctt gataaagcag gaattactac tgcttgttta cgaattaaat cgaagtggac tgctggcgga aaatgagaaa attcgaccta tccttgcgca gctcgagaag ctcttacttt");

        promptLab.setText("Input a DNA sequence:");

        clearOutputBut.setText("Clear Output");
        clearOutputBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearOutputButActionPerformed(evt);
            }
        });

        runBut.setText("Run");
        runBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout butPanelLayout = new javax.swing.GroupLayout(butPanel);
        butPanel.setLayout(butPanelLayout);
        butPanelLayout.setHorizontalGroup(
            butPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(butPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(runBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clearOutputBut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        butPanelLayout.setVerticalGroup(
            butPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(butPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(clearOutputBut)
                .addComponent(runBut))
        );

        clearInputBut.setText("Clear Input");
        clearInputBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearInputButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout seqPanelLayout = new javax.swing.GroupLayout(seqPanel);
        seqPanel.setLayout(seqPanelLayout);
        seqPanelLayout.setHorizontalGroup(
            seqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seqPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(promptLab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seqInput, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clearInputBut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seqPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(393, 393, 393))
        );
        seqPanelLayout.setVerticalGroup(
            seqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seqPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(seqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(promptLab, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seqInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearInputBut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        output.setColumns(20);
        output.setRows(5);
        jScrollPane1.setViewportView(output);

        fileMenu.setText("Menu");

        quitBut.setText("Quit");
        quitBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButActionPerformed(evt);
            }
        });
        fileMenu.add(quitBut);

        jMenuBar1.add(fileMenu);

        functionMenu.setText("Functions");

        strandBut.setText("Show Complementary Strand");
        functionMenu.add(strandBut);

        codBut.setText("Show Codons / Amino Acid Sequence");
        functionMenu.add(codBut);

        resEnzMenu.setText("Restriction Enzymes");

        resEnzButs.add(noneBut);
        noneBut.setSelected(true);
        noneBut.setText("None");
        resEnzMenu.add(noneBut);

        resEnzButs.add(aluiBut);
        aluiBut.setText("Alui");
        resEnzMenu.add(aluiBut);

        resEnzButs.add(BamHIBut);
        BamHIBut.setText("BamHI");
        resEnzMenu.add(BamHIBut);

        resEnzButs.add(EcoRIBut);
        EcoRIBut.setText("EcoRI");
        resEnzMenu.add(EcoRIBut);

        resEnzButs.add(HaeIIIBut);
        HaeIIIBut.setText("HaeIII");
        resEnzMenu.add(HaeIIIBut);

        resEnzButs.add(HindIIIBut);
        HindIIIBut.setText("HindIII");
        resEnzMenu.add(HindIIIBut);

        functionMenu.add(resEnzMenu);

        jMenuBar1.add(functionMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(seqPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seqPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitButActionPerformed

    private void clearOutputButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearOutputButActionPerformed
        output.setText("");
    }//GEN-LAST:event_clearOutputButActionPerformed

    private void runButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButActionPerformed
        Driver.driver();
    }//GEN-LAST:event_runButActionPerformed

    private void clearInputButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearInputButActionPerformed
        seqInput.setText("");
    }//GEN-LAST:event_clearInputButActionPerformed

    public static boolean isStrandButChecked() {
        return strandBut.isSelected();
    }
    
    public static boolean isCodButChecked() {
        return codBut.isSelected();
    }
    
    public static String getSequence() {
        return seqInput.getText();
    }
    
    public static RestrictionSequence getCleavage() {
        if(BamHIBut.isSelected()) {
            return new RestrictionSequence("GGATCC", 1, 5);
        } else if(EcoRIBut.isSelected()) {
            return new RestrictionSequence("GAATTC", 1, 5);
        } else if(HaeIIIBut.isSelected()) {
            return new RestrictionSequence("GGCC", 2, 2);
        } else if(HindIIIBut.isSelected()) {
            return new RestrictionSequence("AAGCTT", 1, 5);
        } else if(aluiBut.isSelected()) {
            return new RestrictionSequence("AGCT", 2, 2);
        } else {
            return null;
        }
    }
    
    public static boolean isResEnzChecked() {
        return !noneBut.isSelected();  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JRadioButtonMenuItem BamHIBut;
    private static javax.swing.JRadioButtonMenuItem EcoRIBut;
    private static javax.swing.JRadioButtonMenuItem HaeIIIBut;
    private static javax.swing.JRadioButtonMenuItem HindIIIBut;
    private static javax.swing.JRadioButtonMenuItem aluiBut;
    private javax.swing.JPanel butPanel;
    private javax.swing.JButton clearInputBut;
    private javax.swing.JButton clearOutputBut;
    private static javax.swing.JCheckBoxMenuItem codBut;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu functionMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JRadioButtonMenuItem noneBut;
    private javax.swing.JTextArea output;
    private javax.swing.JLabel promptLab;
    private javax.swing.JMenuItem quitBut;
    private javax.swing.ButtonGroup resEnzButs;
    private javax.swing.JMenu resEnzMenu;
    private javax.swing.JButton runBut;
    private static javax.swing.JTextField seqInput;
    private javax.swing.JPanel seqPanel;
    private static javax.swing.JCheckBoxMenuItem strandBut;
    // End of variables declaration//GEN-END:variables
}
