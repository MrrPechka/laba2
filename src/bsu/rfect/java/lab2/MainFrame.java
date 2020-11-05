package bsu.rfect.java.lab2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.image.ImageObserver;
import static java.lang.Math.*;

@SuppressWarnings("serial")

public class MainFrame extends JFrame {
    private int memoryId = 1;

    private JTextField memoryTextField;
    private JTextField resultFieldText;

    private ButtonGroup radioMemoryButtons = new ButtonGroup();
    private ButtonGroup radioButtons = new ButtonGroup();

    private Box hBoxMemoryType = Box.createHorizontalBox();
    private Box hboxEquationType = Box.createHorizontalBox();

    int equation_numb = 1;
    private  JLabel image;

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    private JTextField text_Field_X;
    private JTextField text_Field_Y;
    private JTextField text_Field_Z;

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

    private void addRadioButton(String name, final int equation_numb){
        JRadioButton button = new JRadioButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.equation_numb = equation_numb;
                if(equation_numb == 1)
                    image.setIcon(new ImageIcon(MainFrame.class.getResource("equation_1.png")));
                if(equation_numb == 2)
                    image.setIcon(new ImageIcon(MainFrame.class.getResource("equation_2.png")));
            }
        });
        radioButtons.add(button);
        hboxEquationType.add(button);
    }

    public MainFrame(){
        super("Вычисление уравнения");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT) / 2);

        hboxEquationType.add(Box.createHorizontalGlue());
        addRadioButton("Уравнение 1", 1);
        addRadioButton("Уравнение 2", 2);
        radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);
        hboxEquationType.add(Box.createHorizontalGlue());
        hboxEquationType.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        Box hBoxEquationImage = Box.createHorizontalBox();
        hBoxEquationImage.add(Box.createHorizontalGlue());
        image = new JLabel(new ImageIcon(MainFrame.class.getResource("equation_1bmp")));
        hBoxEquationImage.add(image);
        hBoxEquationImage.add(Box.createHorizontalGlue());

        JLabel label_for_X = new JLabel("x:");
        text_Field_X = new JTextField("0.0", 10);
        text_Field_X.setMaximumSize(text_Field_X.getPreferredSize());

        JLabel label_for_Y = new JLabel("y:");
        text_Field_Y = new JTextField("0.0", 10);
        text_Field_Y.setMaximumSize(text_Field_Y.getPreferredSize());

        JLabel label_for_Z = new JLabel("z:");
        text_Field_Z = new JTextField("0.0", 10);
        text_Field_Z.setMaximumSize(text_Field_Z.getPreferredSize());

        Box hBoxVariables = Box.createHorizontalBox();
        hBoxVariables.add(Box.createHorizontalGlue());

        hBoxVariables.add(Box.createHorizontalStrut(50));
        hBoxVariables.add(label_for_X);
        hBoxVariables.add(Box.createHorizontalStrut(10));
        hBoxVariables.add(text_Field_X);

        hBoxVariables.add(Box.createHorizontalStrut(50));
        hBoxVariables.add(label_for_Y);
        hBoxVariables.add(Box.createHorizontalStrut(10));
        hBoxVariables.add(text_Field_Y);

        hBoxVariables.add(Box.createHorizontalStrut(50));
        hBoxVariables.add(label_for_Z);
        hBoxVariables.add(Box.createHorizontalStrut(10));
        hBoxVariables.add(text_Field_Z);

        hBoxVariables.add(Box.createHorizontalGlue());

        JLabel label_for_result = new JLabel("Результат:");
        resultFieldText = new JTextField("0", 15);
        resultFieldText.setMaximumSize(resultFieldText.getPreferredSize());

        Box hBoxResult = Box.createHorizontalBox();
        hBoxResult.add(Box.createHorizontalGlue());
        hBoxResult.add(label_for_result);
        hBoxResult.add(Box.createHorizontalStrut(10));
        hBoxResult.add(resultFieldText);
        hBoxResult.add(Box.createHorizontalGlue());
        hBoxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        JButton button_calc = new JButton("Вычислить");
        button_calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Double x = Double.parseDouble(text_Field_X.getText());
                    Double y = Double.parseDouble(text_Field_Y.getText());
                    Double z = Double.parseDouble(text_Field_Z.getText());
                    Double result;
                    if(equation_numb == 1)
                        result = equation_1(x, y, z);
                    else
                        result = equation_2(x, y, z);

                    resultFieldText.setText(result.toString());
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(MainFrame.this, "Ошибка в формате записи вещественного числа", "Ошибочный формат числа", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }

    public static void main(String[] args) {

    }
}
