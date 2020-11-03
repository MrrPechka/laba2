package bsu.rfect.java.lab2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.*;
import static java.lang.Math.*;

@SuppressWarnings("serial")

public class MainFrame extends JFrame {
    private int memoryId = 1;
    private JTextField memoryTextField;
    private ButtonGroup radioMemoryButtons = new ButtonGroup();
    private Box hBoxMemoryType = Box.createHorizontalBox();

    private Double mem1 = new Double(0);
    private Double mem2 = new Double(0);
    private Double mem3 = new Double(0);

    public Double equation_1(Double x, Double y, Double z){
        if(y <= 0){
            JOptionPane.showMessageDialog(MainFrame.this, "Мы не можем взять логарифм от отрицательного чила или 0 ", "" + "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }

        if((pow(x,2) + sin(z) + exp(cos(z))) < 0) {
            JOptionPane.showMessageDialog(MainFrame.this, "Выражение под корнем не может быть отрицательным ", "" + "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }

        return sin(log(y) + sin(PI * pow(y, 2))) * pow(pow(x, 2) + sin(z) + exp(cos(z)), 1/4);
    }

    public Double equation_2 (Double x, Double y, Double z){
        if(y == -1){
            JOptionPane.showMessageDialog(MainFrame.this, "Мы не можем взять логарифм от 0 ", "" + "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }
        if(x <= 0){
            JOptionPane.showMessageDialog(MainFrame.this, "x должен быть положительным ", "" + "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }
        if((exp(cos(x)) + pow(sin(PI * z), 2)) < 0){
            JOptionPane.showMessageDialog(MainFrame.this, "Выражение под корнем не может быть отрицательным ", "" + "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }

        return pow(cos(exp(x)) + log(pow(1 + y, 2)) + pow(exp(cos(x)) + pow(sin(PI * z),2), 1/2) + pow(1/x, 1/2) + cos(pow(y, 2)), sin(z));
    }

    private void addMemoryRadioButton (String buttonName, final int memoryId){
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.memoryId = memoryId;
                if(memoryId == 1)
                    memoryTextField.setText(mem1.toString());
                if(memoryId == 2)
                    memoryTextField.setText(mem2.toString());
                if(memoryId == 3)
                    memoryTextField.setText(mem3.toString());
            }
        });
        radioMemoryButtons.add(button);
        hBoxMemoryType.add(button);
    }
    public static void main(String[] args) {

    }
}
