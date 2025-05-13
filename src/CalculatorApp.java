import javax.swing.*;
import java.awt.event.*;

public class CalculatorApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        JTextField num1 = new JTextField();
        JTextField num2 = new JTextField();
        JComboBox<String> operator = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        JButton calculate = new JButton("Calculate");
        JLabel result = new JLabel("Result: ");

        frame.setLayout(null);
        num1.setBounds(50, 30, 100, 30);
        operator.setBounds(160, 30, 50, 30);
        num2.setBounds(220, 30, 100, 30);
        calculate.setBounds(100, 80, 120, 30);
        result.setBounds(50, 130, 200, 30);

        frame.add(num1);
        frame.add(operator);
        frame.add(num2);
        frame.add(calculate);
        frame.add(result);

        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(num1.getText());
                    double b = Double.parseDouble(num2.getText());
                    String op = (String) operator.getSelectedItem();
                    Calculator calc = new Calculator();
                    double res = switch (op) {
                        case "+" -> calc.add(a, b);
                        case "-" -> calc.subtract(a, b);
                        case "*" -> calc.multiply(a, b);
                        case "/" -> calc.divide(a, b);
                        default -> 0;
                    };
                    result.setText("Result: " + res);
                } catch (Exception ex) {
                    result.setText("Error: " + ex.getMessage());
                }
            }
        });

        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
