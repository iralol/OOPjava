package lab15;

import lab15.gui.LoginFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginFrame::new);
    }
}
