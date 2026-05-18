package lab13;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class DensityCalculator extends JFrame {

    // Input fields
    private JTextField massField;
    private JTextField volumeField;
    private JTextField densityField;

    // Unit combo boxeS
    private JComboBox<String> massUnitCombo;
    private JComboBox<String> volumeUnitCombo;
    private JComboBox<String> densityUnitCombo;
    private JComboBox<String> sigFigCombo;
    private JButton calculateButton;
    private JButton clearButton;
    private JLabel answerLabel;
    
    // Unit conversion factors to SI (kg and m³)
    private static final double[] MASS_FACTORS = { 1.0, 0.001, 0.453592 }; // g, mg, lb → g
    private static final double[] VOLUME_FACTORS = { 1.0, 1.0, 1000.0, 0.0283168e6 }; // cm³, mL, L, ft³ → cm³

    public DensityCalculator() {
        setTitle("Density Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        initComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        // Outer panel 
        JPanel outer = new JPanel(new BorderLayout(10, 10));
        outer.setBackground(new Color(210, 225, 240));
        outer.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Title 
        JLabel title = new JLabel("Density Calculator", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        title.setForeground(new Color(30, 60, 100));
        title.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(180, 195, 215), 1, true),
                BorderFactory.createEmptyBorder(6, 0, 6, 0)));
        title.setBackground(new Color(220, 232, 245));
        title.setOpaque(true);
        outer.add(title, BorderLayout.NORTH);

        // Centre panel 
        JPanel centre = new JPanel();
        centre.setLayout(new BoxLayout(centre, BoxLayout.Y_AXIS));
        centre.setBackground(new Color(210, 225, 240));

        // Formula label (p = m / V)
        JLabel formula = new JLabel("<html><i style='font-size:18px'>p</i> = <i style='font-size:18px'>m</i> / <i style='font-size:18px'>V</i></html>", SwingConstants.CENTER);
        formula.setFont(new Font("Serif", Font.ITALIC, 24));
        formula.setForeground(new Color(30, 60, 100));
        formula.setAlignmentX(Component.CENTER_ALIGNMENT);
        formula.setBorder(BorderFactory.createEmptyBorder(10, 0, 14, 0));
        centre.add(formula);

        // Grid for rows
        JPanel grid = new JPanel(new GridBagLayout());
        grid.setBackground(new Color(210, 225, 240));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 8, 6, 8);
        c.fill = GridBagConstraints.HORIZONTAL;

        //Density row 
        addRowLabel(grid, c, 0, "density  p =");
        densityField = makeTextField("calculated density");
        densityField.setEditable(false);
        densityField.setBackground(new Color(230, 238, 248));

        JLabel lockIcon = new JLabel("lock");
        JPanel densityFieldPanel = new JPanel(new BorderLayout(4, 0));
        densityFieldPanel.setBackground(new Color(210, 225, 240));
        densityFieldPanel.add(densityField, BorderLayout.CENTER);
        densityFieldPanel.add(lockIcon, BorderLayout.EAST);

        c.gridx = 1; c.gridy = 0; c.weightx = 1.0;
        grid.add(densityFieldPanel, c);

        c.gridx = 2; c.weightx = 0;
        JLabel densityUnitsLabel = new JLabel("units");
        densityUnitsLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        densityUnitsLabel.setForeground(new Color(60, 80, 110));
        grid.add(densityUnitsLabel, c);

        String[] densityUnits = {"g/cm³", "g/mL", "kg/m³", "lb/ft³", "kg/cm³"};
        densityUnitCombo = new JComboBox<>(densityUnits);
        styleCombo(densityUnitCombo);
        c.gridx = 3;
        grid.add(densityUnitCombo, c);

        //Mass mor 
        addRowLabel(grid, c, 1, "mass  m =");
        massField = makeTextField("mass");
        c.gridx = 1; c.gridy = 1; c.weightx = 1.0;
        grid.add(massField, c);

        String[] massUnits = {"g", "mg", "lb"};
        massUnitCombo = new JComboBox<>(massUnits);
        styleCombo(massUnitCombo);
        c.gridx = 2; c.weightx = 0; c.gridwidth = 2;
        grid.add(massUnitCombo, c);
        c.gridwidth = 1;

        //Volume row
        addRowLabel(grid, c, 2, "volume  V =");
        volumeField = makeTextField("volume");
        c.gridx = 1; c.gridy = 2; c.weightx = 1.0;
        grid.add(volumeField, c);

        String[] volumeUnits = {"cm³", "mL", "L", "ft³"};
        volumeUnitCombo = new JComboBox<>(volumeUnits);
        styleCombo(volumeUnitCombo);
        c.gridx = 2; c.weightx = 0; c.gridwidth = 2;
        grid.add(volumeUnitCombo, c);
        c.gridwidth = 1;

        //Significant figures row 
        JLabel sigLabel = new JLabel("Significant Figures");
        sigLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        sigLabel.setForeground(new Color(60, 80, 110));
        sigLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2; c.weightx = 1.0;
        grid.add(sigLabel, c);

        String[] sigFigs = {"auto", "1", "2", "3", "4", "5", "6"};
        sigFigCombo = new JComboBox<>(sigFigs);
        styleCombo(sigFigCombo);
        c.gridx = 2; c.gridwidth = 2; c.weightx = 0;
        grid.add(sigFigCombo, c);
        c.gridwidth = 1;

        centre.add(grid);
        centre.add(Box.createVerticalStrut(12));

        //Button  
        JPanel btnPanel = new JPanel(new BorderLayout(10, 0));
        btnPanel.setBackground(new Color(210, 225, 240));

        clearButton = makeButton("Clear", new Color(180, 195, 215), Color.DARK_GRAY);
        calculateButton = makeButton("Calculate", new Color(100, 140, 190), Color.WHITE);

        btnPanel.add(clearButton, BorderLayout.WEST);
        btnPanel.add(calculateButton, BorderLayout.EAST);
        centre.add(btnPanel);
        centre.add(Box.createVerticalStrut(10));

        //Answer panel
        JPanel answerPanel = new JPanel(new BorderLayout());
        answerPanel.setBackground(Color.WHITE);
        answerPanel.setBorder(new LineBorder(new Color(160, 180, 205), 1));
        answerLabel = new JLabel("Answer:");
        answerLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
        answerLabel.setForeground(new Color(30, 60, 100));
        answerLabel.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
        answerPanel.add(answerLabel, BorderLayout.CENTER);
        answerPanel.setPreferredSize(new Dimension(500, 50));
        centre.add(answerPanel);

        outer.add(centre, BorderLayout.CENTER);
        setContentPane(outer);

        //Action listeners 
        calculateButton.addActionListener(e -> calculate());
        clearButton.addActionListener(e -> clearFields());

        // Allow Enter key to trigger calculation
        KeyAdapter enterKey = new KeyAdapter() {
            @Override public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) calculate();
            }
        };
        massField.addKeyListener(enterKey);
        volumeField.addKeyListener(enterKey);
    }

    //Core calculation with full exception handling 
    private void calculate() {
        String massText   = massField.getText().trim();
        String volumeText = volumeField.getText().trim();

        // 1. Empty field check
        if (massText.isEmpty() || volumeText.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter values for both mass and volume.",
                    "Missing Input", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double mass, volume;

        // 2. Non-numeric mass
        try {
            mass = Double.parseDouble(massText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid mass value: \"" + massText + "\"\nPlease enter a numeric value (e.g. 150.5).",
                    "Input Error – Mass", JOptionPane.ERROR_MESSAGE);
            massField.requestFocus();
            massField.selectAll();
            return;
        }

        // 3. Non-numeric volume
        try {
            volume = Double.parseDouble(volumeText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid volume value: \"" + volumeText + "\"\nPlease enter a numeric value (e.g. 75.0).",
                    "Input Error – Volume", JOptionPane.ERROR_MESSAGE);
            volumeField.requestFocus();
            volumeField.selectAll();
            return;
        }

        // 4. Negative values
        if (mass < 0) {
            JOptionPane.showMessageDialog(this,
                    "Mass cannot be negative. Please enter a positive value.",
                    "Input Error – Mass", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (volume < 0) {
            JOptionPane.showMessageDialog(this,
                    "Volume cannot be negative. Please enter a positive value.",
                    "Input Error – Volume", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 5. Division by zero
        if (volume == 0) {
            JOptionPane.showMessageDialog(this,
                    "Volume cannot be zero.\nDensity = mass ÷ volume — division by zero is undefined.",
                    "Math Error – Division by Zero", JOptionPane.ERROR_MESSAGE);
            volumeField.requestFocus();
            volumeField.selectAll();
            return;
        }

        // Convert to base units (g and cm³) 
        double massInGrams  = mass   * MASS_FACTORS[massUnitCombo.getSelectedIndex()];
        double volInCm3     = volume * VOLUME_FACTORS[volumeUnitCombo.getSelectedIndex()];

        // density in g/cm³
        double densityGcm3 = massInGrams / volInCm3;

        // Convert to selected output unit 
        String dUnit = (String) densityUnitCombo.getSelectedItem();
        double result;
        switch (dUnit) {
            case "g/mL":   result = densityGcm3;          break;  // 1 g/cm³ = 1 g/mL
            case "kg/m³":  result = densityGcm3 * 1000.0; break;
            case "lb/ft³": result = densityGcm3 * 62.4280; break;
            case "kg/cm³": result = densityGcm3 / 1000.0; break;
            default:       result = densityGcm3;           break;  // g/cm³
        }

        // Apply significant figures 
        String sigFig = (String) sigFigCombo.getSelectedItem();
        String formatted;
        if ("auto".equals(sigFig)) {
            formatted = String.format("%.6g", result);
            // trim trailing zeros after decimal
            if (formatted.contains(".") && !formatted.contains("e")) {
                formatted = formatted.replaceAll("0+$", "").replaceAll("\\.$", "");
            }
        } else {
            int sf = Integer.parseInt(sigFig);
            formatted = String.format("%." + sf + "g", result);
        }

        densityField.setText(formatted + " " + dUnit);
        answerLabel.setText("Answer:  p = " + formatted + " " + dUnit);
    }

    private void clearFields() {
        massField.setText("");
        volumeField.setText("");
        densityField.setText("");
        answerLabel.setText("Answer:");
        massUnitCombo.setSelectedIndex(0);
        volumeUnitCombo.setSelectedIndex(0);
        densityUnitCombo.setSelectedIndex(0);
        sigFigCombo.setSelectedIndex(0);
    }

    // Helpers
    private void addRowLabel(JPanel grid, GridBagConstraints c, int row, String text) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(new Font("SansSerif", Font.PLAIN, 15));
        lbl.setForeground(new Color(60, 80, 110));
        lbl.setHorizontalAlignment(SwingConstants.RIGHT);
        c.gridx = 0; c.gridy = row; c.weightx = 0;
        grid.add(lbl, c);
    }

    private JTextField makeTextField(String placeholder) {
        JTextField tf = new JTextField(14);
        tf.setFont(new Font("SansSerif", Font.PLAIN, 14));
        tf.setForeground(Color.GRAY);
        tf.setText(placeholder);
        tf.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(180, 200, 220), 1, true),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        tf.setBackground(new Color(245, 248, 252));

        // Placeholder behaviour
        tf.addFocusListener(new FocusAdapter() {
            @Override public void focusGained(FocusEvent e) {
                if (tf.getText().equals(placeholder)) {
                    tf.setText(""); tf.setForeground(Color.DARK_GRAY);
                }
            }
            @Override public void focusLost(FocusEvent e) {
                if (tf.getText().isEmpty()) {
                    tf.setText(placeholder); tf.setForeground(Color.GRAY);
                }
            }
        });
        return tf;
    }

    private void styleCombo(JComboBox<String> combo) {
        combo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        combo.setBackground(new Color(235, 242, 250));
        combo.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 220), 1));
    }

    private JButton makeButton(String text, Color bg, Color fg) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("SansSerif", Font.BOLD, 15));
        btn.setBackground(bg);
        btn.setForeground(fg);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(bg.darker(), 1, true),
                BorderFactory.createEmptyBorder(8, 28, 8, 28)));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setOpaque(true);
        return btn;
    }
}