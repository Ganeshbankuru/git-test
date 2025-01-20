import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class simplecalculator {
    // Create a frame
    private JFrame frame;
    // Create a textfield
    private JTextField textField;
    // Store operator and operands
    private String operator, operand1, operand2;

    // Constructor
    public simplecalculator() {
        operator = operand1 = operand2 = "";
        frame = new JFrame("Calculator");
        textField = new JTextField(16);
        textField.setEditable(false);

        // Create number buttons and some operators
        JButton[] numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }
        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton divButton = new JButton("/");
        JButton mulButton = new JButton("*");
        JButton dotButton = new JButton(".");
        JButton equalButton = new JButton("=");
        JButton clearButton = new JButton("C");

        // Create a panel
        JPanel panel = new JPanel();

        // Add action listeners
        for (int i = 0; i < 10; i++) {
            numberButtons[i].addActionListener(new ButtonClickListener());
        }
        addButton.addActionListener(new ButtonClickListener());
        subButton.addActionListener(new ButtonClickListener());
        divButton.addActionListener(new ButtonClickListener());
        mulButton.addActionListener(new ButtonClickListener());
        dotButton.addActionListener(new ButtonClickListener());
        equalButton.addActionListener(new ButtonClickListener());
        clearButton.addActionListener(new ButtonClickListener());

        // Add elements to panel
        panel.add(textField);
        panel.add(addButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);
        panel.add(dotButton);
        panel.add(numberButtons[0]);
        panel.add(clearButton);
        panel.add(equalButton);

        // Set background of panel
        panel.setBackground(Color.blue);

        // Add panel to frame
        frame.add(panel);
        frame.setSize(200, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            // If the value is a number
            if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.charAt(0) == '.') {
                if (!operator.equals("")) {
                    operand2 = operand2 + command;
                } else {
                    operand1 = operand1 + command;
                }
                textField.setText(operand1 + operator + operand2);
            } else if (command.charAt(0) == 'C') {
                operand1 = operator = operand2 = "";
                textField.setText("");
            } else if (command.charAt(0) == '=') {
                double result;
                if (operator.equals("+"))
                    result = (Double.parseDouble(operand1) + Double.parseDouble(operand2));
                else if (operator.equals("-"))
                    result = (Double.parseDouble(operand1) - Double.parseDouble(operand2));
                else if (operator.equals("/"))
                    result = (Double.parseDouble(operand1) / Double.parseDouble(operand2));
                else
                    result = (Double.parseDouble(operand1) * Double.parseDouble(operand2));

                textField.setText(operand1 + operator + operand2 + "=" + result);
                operand1 = Double.toString(result);
                operator = operand2 = "";
            } else {
                if (operator.equals("") || operand2.equals(""))
                    operator = command;
                else {
                    double result;
                    if (operator.equals("+"))
                        result = (Double.parseDouble(operand1) + Double.parseDouble(operand2));
                    else if (operator.equals("-"))
                        result = (Double.parseDouble(operand1) - Double.parseDouble(operand2));
                    else if (operator.equals("/"))
                        result = (Double.parseDouble(operand1) / Double.parseDouble(operand2));
                    else
                        result = (Double.parseDouble(operand1) * Double.parseDouble(operand2));

                    operand1 = Double.toString(result);
                    operator = command;
                    operand2 = "";
                }
                textField.setText(operand1 + operator + operand2);
            }
        }
    }

    public static void main(String[] args) {
        new simplecalculator();
    }
}
