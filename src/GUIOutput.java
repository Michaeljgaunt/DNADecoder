/*
 * The GUIOutput class reassigns System.out to swing text areas.
 */

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

public class GUIOutput extends OutputStream {
    private JTextArea textArea;
     
    public GUIOutput(JTextArea textArea) {
        this.textArea = textArea;
    }
     
    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        textArea.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
