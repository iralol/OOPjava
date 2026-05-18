package lab14;

import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


    //  SimpleTextEditor  –  main GUI class

public class SimpleTextEditor extends JFrame implements ActionListener {

    // Shared file path used by fileedit
    public static String currentFilePath = "";

    //  UI components 
    private final JTextArea textArea;
    private final JScrollPane scrollPane;
    private final JButton btnClear;
    private final JButton btnSave;
    private final JButton btnOpen;

    //  Business logic helper 
    private final filedit fileHelper = new filedit();

    //  Constructor 
    public SimpleTextEditor() {
        setTitle("Simple Text Editor");
        setSize(590, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        //  Text area 
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        textArea.setLineWrap(false);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 6));
        btnClear = new JButton("Clear");
        btnSave  = new JButton("Save");
        btnOpen  = new JButton("Open");

        // Make buttons the same width as in the reference screenshot
        Dimension btnSize = new Dimension(80, 28);
        btnClear.setPreferredSize(btnSize);
        btnSave .setPreferredSize(btnSize);
        btnOpen .setPreferredSize(btnSize);

        btnClear.addActionListener(this);
        btnSave .addActionListener(this);
        btnOpen .addActionListener(this);

        buttonPanel.add(btnClear);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnOpen);

        add(buttonPanel, BorderLayout.SOUTH);

        //Center on screen 
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //ActionListener 
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnClear) {
            handleClear();
        } else if (src == btnSave) {
            handleSave();
        } else if (src == btnOpen) {
            handleOpen();
        }
    }

    // Clear 
    private void handleClear() {
        textArea.setText("");
        currentFilePath = "";
        setTitle("Simple Text Editor");
    }

    //  Save 
    private void handleSave() {
        // Let user choose where to save
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save File");
        chooser.setFileFilter(new FileNameExtensionFilter("Text Files (*.txt)", "txt"));

        int result = chooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            // Append .txt extension if missing
            if (!file.getName().toLowerCase().endsWith(".txt")) {
                file = new File(file.getAbsolutePath() + ".txt");
            }

            currentFilePath = file.getAbsolutePath();

            try {
                String content = textArea.getText();

                //  Validate: do not save empty file 
                if (content == null || content.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "Cannot save an empty file.\nPlease enter some text first.",
                            "Input Error",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                fileHelper.printfile(content);
                setTitle("Simple Text Editor  –  " + file.getName());
                JOptionPane.showMessageDialog(this,
                        "File saved successfully:\n" + currentFilePath,
                        "Save Successful",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                // Exception handling: show error via JOptionPane 
                JOptionPane.showMessageDialog(this,
                        "Error saving file:\n" + ex.getMessage(),
                        "Save Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    } 
    private void handleOpen() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Open File");
        chooser.setFileFilter(new FileNameExtensionFilter("Text Files (*.txt)", "txt"));

        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            //  Validate: file must exist 
            if (!file.exists()) {
                JOptionPane.showMessageDialog(this,
                        "The selected file does not exist:\n" + file.getAbsolutePath(),
                        "File Not Found",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            //  Validate: must be a regular file 
            if (!file.isFile()) {
                JOptionPane.showMessageDialog(this,
                        "The selected path is not a valid file.",
                        "Invalid Selection",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            currentFilePath = file.getAbsolutePath();

            try {
                String content = fileHelper.readfile(currentFilePath);
                textArea.setText(content);
                textArea.setCaretPosition(0);           // scroll to top
                setTitle("Simple Text Editor  –  " + file.getName());

            } catch (IOException ex) {
                // ── Exception handling: show error via JOptionPane ──
                JOptionPane.showMessageDialog(this,
                        "Error reading file:\n" + ex.getMessage(),
                        "Open Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
