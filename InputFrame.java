package com.Adil;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;



public class InputFrame extends JFrame
{
    // Текстовые поля
    private JFormattedTextField fillPercent, deathChance, lifeChance, delayMS;
    public JButton start;

    public InputFrame()
    {
        super("Setting params");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        NumberFormatter formPerc = new NumberFormatter();
        NumberFormatter formDelay = new NumberFormatter();
        NumberFormat percents = new DecimalFormat("00");
        NumberFormat delay = new DecimalFormat("00");
        formPerc.setFormat(percents);
        formDelay.setFormat(delay);

        fillPercent = new JFormattedTextField(formPerc);
        deathChance = new JFormattedTextField(formPerc);
        lifeChance = new JFormattedTextField(formPerc);
        delayMS = new JFormattedTextField(formDelay);
        start = new JButton();

        fillPercent.setColumns(5);
        deathChance.setColumns(5);
        lifeChance.setColumns(5);
        delayMS.setColumns(5);


        fillPercent.setToolTipText("Заполненность поля | filling of field: %");
        deathChance.setToolTipText("Шанс Смерти | chance of death: %");
        lifeChance.setToolTipText("Шанс Жизни | chance of alive: %");
        delayMS.setToolTipText("Задержка | delay: ms");

        fillPercent.setValue(25);
        deathChance.setValue(100);
        lifeChance.setValue(100);
        delayMS.setValue(500);

        // Создание панели с текстовыми полями
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contents.add(fillPercent);
        contents.add(deathChance);
        contents.add(lifeChance);
        contents.add(delayMS);
        contents.add(start);
        setContentPane(contents);

        // Определяем размер окна и выводим его на экран
        setSize(400, 130);
        setVisible(true);
    }

    public JFormattedTextField getFillPercent() { return fillPercent; }
    public JFormattedTextField getDeathChance() { return deathChance; }
    public JFormattedTextField getLifeChance() { return lifeChance; }
    public JFormattedTextField getDelayMS() { return delayMS; }
}
