package bsu.rfect.java.lab2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.*;

public class MainFrame extends JFrame {

    private static final int WIDTH = 1000,
                             HEIGHT = 500;

    private JTextField textFieldResult,
                       textFieldX,
                       textFieldY,
                       textFieldZ,
                       textFieldMem1,
                       textFieldMem2,
                       textFieldMem3;

    private ButtonGroup radioFormulaButtons = new ButtonGroup(),
                        radioMemoryButtons = new ButtonGroup();

    private Box hboxFormulaType = Box.createHorizontalBox(),
                hboxMemoryType = Box.createHorizontalBox();

    private int formulaId = 1,
                memoryId = 1;

    private BufferedImage image;
    private JLabel labelImage = new JLabel();

    public Double calculate1(Double x, Double y, Double z){
        if(y <= 0){
            JOptionPane.showMessageDialog(MainFrame.this, "Мы не можем взять логарифм от отрицательного числа или 0 ", "" + "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }

        if((pow(x,2) + sin(z) + exp(cos(z))) < 0) {
            JOptionPane.showMessageDialog(MainFrame.this, "Выражение под корнем не может быть отрицательным ", "" + "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }

        return sin(log(y) + sin(PI * pow(y, 2))) * pow(pow(x, 2) + sin(z) + exp(cos(z)), 1/4);
    }

    public Double calculate2 (Double x, Double y, Double z){
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

    private void addRadioFormulaButton(String buttonName, final int formulaId){
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.formulaId = formulaId;
                try {
                    if (formulaId == 1) {
                        image = ImageIO.read(new File("src/bsu/rfect/java/lab2/equation_1.png"));
                    } else {
                        image = ImageIO.read(new File("src/bsu/rfect/java/lab2/equation_2.png"));
                    }
                    labelImage.setIcon(new ImageIcon(image));
                }   catch (IOException ex){
                    System.out.println("!!!Image not found!!!");
                }
            }
        });
        radioFormulaButtons.add(button);
        hboxFormulaType.add(button);
    }

    private void addRadioMemoryButton(String buttonName, final int memoryId){
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.memoryId = memoryId;
            }
        });
        radioMemoryButtons.add(button);
        hboxMemoryType.add(button);
    }

    public MainFrame() {
        super("Вычисление...");

        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation( (kit.getScreenSize().width - WIDTH)/2,
                (kit.getScreenSize().height - HEIGHT)/2);

        hboxFormulaType.add(Box.createHorizontalGlue());
        addRadioFormulaButton("Уравнение 1", 1);
        addRadioFormulaButton("Уравнение 2", 2);
        try{
            image = ImageIO.read(new File("src/bsu/rfect/java/lab2/equation_1.png"));
            labelImage.setIcon(new ImageIcon(image));
        }    catch(IOException ex){
            System.out.println("Картинка не добавлена");
        }
        hboxFormulaType.add(Box.createHorizontalGlue());
        radioFormulaButtons.setSelected(radioFormulaButtons.getElements().nextElement().getModel(), true);
        hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.ORANGE));


        Box hboxFormulaImage = Box.createHorizontalBox();
        hboxFormulaImage.add(Box.createHorizontalGlue());
        hboxFormulaImage.add(labelImage);
        hboxFormulaImage.add(Box.createHorizontalGlue());
        hboxFormulaImage.setBorder(BorderFactory.createLineBorder(Color.ORANGE));


        Box hboxVariables = Box.createHorizontalBox();
        JLabel labelForX = new JLabel("x =");
        textFieldX = new JTextField("0", 10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel labelForY = new JLabel("y =");
        textFieldY = new JTextField("0", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        JLabel labelForZ = new JLabel("z =");
        textFieldZ = new JTextField("0", 10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());

        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);
        hboxVariables.setBorder(BorderFactory.createLineBorder(Color.ORANGE));


        Box hboxResult = Box.createHorizontalBox();
        JLabel labelForResult = new JLabel("Результат =");
        textFieldResult = new JTextField("0", 50);
        textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.RED));


        Box hboxButtons = Box.createHorizontalBox();
        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Double result = Double.parseDouble(textFieldResult.getText());
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    if (formulaId == 1){
                        result = calculate1(x, y, z);
                    }   else{
                        result = calculate2(x, y, z);
                    }
                    textFieldResult.setText(result.toString());
                }   catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Ошибка в формате записи вещественного числа", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldResult.setText("0");
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
            }
        });
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonCalc);
        hboxButtons.add(Box.createHorizontalStrut(50));
        hboxButtons.add(buttonReset);
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.setBorder(BorderFactory.createLineBorder(Color.ORANGE));


        hboxMemoryType.add(Box.createHorizontalGlue());
        addRadioMemoryButton("Mem1", 1);
        addRadioMemoryButton("Mem2", 2);
        addRadioMemoryButton("Mem3", 3);
        hboxMemoryType.add(Box.createHorizontalGlue());
        radioMemoryButtons.setSelected(radioMemoryButtons.getElements().nextElement().getModel(), true);
        hboxMemoryType.setBorder(BorderFactory.createLineBorder(Color.ORANGE));


        Box hboxMemoryResult = Box.createHorizontalBox();
        JLabel labelForMem1 = new JLabel("Mem1 =");
        textFieldMem1 = new JTextField("0", 30);
        textFieldMem1.setMaximumSize(textFieldMem1.getPreferredSize());
        hboxMemoryResult.add(Box.createHorizontalGlue());
        hboxMemoryResult.add(labelForMem1);
        hboxMemoryResult.add(Box.createHorizontalStrut(10));
        hboxMemoryResult.add(textFieldMem1);
        hboxMemoryResult.add(Box.createHorizontalStrut(100));
        JLabel labelForMem2 = new JLabel("Mem2 =");
        textFieldMem2 = new JTextField("0", 30);
        textFieldMem2.setMaximumSize(textFieldMem2.getPreferredSize());
        hboxMemoryResult.add(labelForMem2);
        hboxMemoryResult.add(Box.createHorizontalStrut(10));
        hboxMemoryResult.add(textFieldMem2);
        hboxMemoryResult.add(Box.createHorizontalStrut(100));
        JLabel labelForMem3 = new JLabel("Mem3 =");
        textFieldMem3 = new JTextField("0", 30);
        textFieldMem3.setMaximumSize(textFieldMem3.getPreferredSize());
        hboxMemoryResult.add(labelForMem3);
        hboxMemoryResult.add(Box.createHorizontalStrut(10));
        hboxMemoryResult.add(textFieldMem3);
        hboxMemoryResult.add(Box.createHorizontalGlue());
        hboxMemoryResult.setBorder(BorderFactory.createLineBorder(Color.RED));


        Box hboxMemoryButtons = Box.createHorizontalBox();
        JButton Mplus = new JButton("M+");
        Mplus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double result = Double.parseDouble(textFieldResult.getText()),
                            mem1 = Double.parseDouble(textFieldMem1.getText()),
                            mem2 = Double.parseDouble(textFieldMem2.getText()),
                            mem3 = Double.parseDouble(textFieldMem3.getText());
                    if (memoryId == 1) {
                        mem1 += result;
                        textFieldMem1.setText(mem1.toString());
                    }
                    if (memoryId == 2) {
                        mem2 += result;
                        textFieldMem2.setText(mem2.toString());
                    }
                    if (memoryId == 3) {
                        mem3 += result;
                        textFieldMem3.setText(mem3.toString());
                    }
                }   catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Ошибка в формате записи вещественного числа", "Неправильное число в 'Результате'",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton MC = new JButton("MC");
        MC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (memoryId == 1){
                    textFieldMem1.setText("0");
                }
                if (memoryId == 2){
                    textFieldMem2.setText("0");
                }
                if (memoryId == 3){
                    textFieldMem3.setText("0");
                }
            }
        });
        hboxMemoryButtons.add(Box.createHorizontalGlue());
        hboxMemoryButtons.add(Mplus);
        hboxMemoryButtons.add(Box.createHorizontalStrut(50));
        hboxMemoryButtons.add(MC);
        hboxMemoryButtons.add(Box.createHorizontalGlue());
        hboxMemoryButtons.setBorder(BorderFactory.createLineBorder(Color.ORANGE));


        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(hboxFormulaType);
        contentBox.add(hboxFormulaImage);
        contentBox.add(hboxVariables);
        contentBox.add(hboxResult);
        contentBox.add(hboxButtons);
        contentBox.add(hboxMemoryType);
        contentBox.add(hboxMemoryResult);
        contentBox.add(hboxMemoryButtons);
        contentBox.add(Box.createVerticalGlue());
        contentBox.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }


    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
