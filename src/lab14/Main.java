package lab14;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Run on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(SimpleTextEditor::new);
    }

}
