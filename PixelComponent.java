package com.Adil;

import javax.swing.*;
import java.awt.*;

public class PixelComponent extends JComponent {
    private Color color;

    public PixelComponent(Color color)
    {
        super();
        this.color = color;
    }

    public void paintComponent(Graphics g, int i, int j)
    {
        super.paintComponent(g);

        g.setColor(color);
        g.fillRect(i * Constants.CELL_SIZE+10, j * Constants.CELL_SIZE+30, Constants.CELL_SIZE, Constants.CELL_SIZE);
    }
}
