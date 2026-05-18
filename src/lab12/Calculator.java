package lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    // Components
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultLabel;
    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;
    public Calculator() {
        // Frame settings
        setTitle("Calculator");
        setSize(360, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(220, 228, 236));
        // First operand label
        JLabel label1 = new JLabel("Negdugeer operator");
        label1.setBounds(20, 15, 180, 25);
        label1.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(label1);
        // Second operand label
        JLabel label2 = new JLabel("Hoyrdugar operator");
        label2.setBounds(190, 15, 180, 25);
        label2.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(label2);
        // First number field
        num1Field = new JTextField();
        num1Field.setBounds(20, 45, 140, 35);
        num1Field.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(num1Field);
        // Second number field
        num2Field = new JTextField();
        num2Field.setBounds(190, 45, 140, 35);
        num2Field.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(num2Field);
        // Buttons
        addButton = new JButton("+");
        addButton.setBounds(20, 95, 70, 35);
        subButton = new JButton("-");
        subButton.setBounds(100, 95, 70, 35);
        mulButton = new JButton("*");
        mulButton.setBounds(180, 95, 70, 35);
        divButton = new JButton("÷");
        divButton.setBounds(260, 95, 70, 35);
        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        addButton.setFont(buttonFont);
        subButton.setFont(buttonFont);
        mulButton.setFont(buttonFont);
        divButton.setFont(buttonFont);
        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);

        // resultLabel = new JLabel("Xariu:");
        // resultLabel.setBounds(20, 140, 300, 25);
        // resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        // panel.add(resultLabel); 

        // Result label with box
        resultLabel = new JLabel("Hariu: ");
        resultLabel.setBounds(20, 140, 310, 45);   // increased height a bit
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(60, 100, 160), 3),
        BorderFactory.createEmptyBorder(8, 10, 8, 10)  // padding inside
        ));
        resultLabel.setOpaque(true);
        resultLabel.setBackground(new Color(245, 245, 245)); // light background
        panel.add(resultLabel);
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        add(panel);
        setVisible(true);
    }
    // Pri methods (bituumjleh)
    private double add(double a, double b) {
        return a + b;
    }
    private double subtract(double a, double b) {
        return a - b;
    }
    private double multiply(double a, double b) {
        return a * b;
    }
    private double divide(double a, double b) {
        if (b == 0) {
            JOptionPane.showMessageDialog(this,
                    "0 d huwaagdahgv");
            return 0;
        }
        return a / b;
    }
    // Buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;
            if (e.getSource() == addButton) {
                result = add(num1, num2);
            }
            else if (e.getSource() == subButton) {
                result = subtract(num1, num2);
            }
            else if (e.getSource() == mulButton) {
                result = multiply(num1, num2);
            }
            else if (e.getSource() == divButton) {
                result = divide(num1, num2);
            }
            resultLabel.setText(
                    "Hariu: " + String.format("%.2f", result));
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "TOO ORUULNA UU!");
        }
    }
}