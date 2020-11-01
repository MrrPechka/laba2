package bsu.rfect.java.lab2;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.*;
import static java.lang.Math.*;

@SuppressWarnings("serial")

public class MainFrame extends JFrame {
    final double Pi = 3.1415926536;
    public Double equation_1(Double x, Double y, Double z){
        if(y <= 0){
            JOptionPane.showMessageDialog(MainFrame.this, "У должен быть положительным ", "" + "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }

        if((pow(x,2) + sin(z) + exp(cos(z))) < 0) {
            JOptionPane.showMessageDialog(MainFrame.this, "Выражение под корнем не может быть отрицательным", "" + "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }

        return sin(log(y) + sin(Pi * pow(y, 2))) * pow(pow(x, 2) + sin(z) + exp(cos(z)), 1/4);
    }
    public static void main(String[] args) {

    }
}
