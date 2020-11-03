package bsu.rfect.java.lab2;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.*;
import static java.lang.Math.*;

@SuppressWarnings("serial")

public class MainFrame extends JFrame {
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
    public static void main(String[] args) {

    }
}
