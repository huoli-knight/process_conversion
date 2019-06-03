package com.huoli.Index.Back;

import javax.swing.*;
import java.awt.*;

public class Back extends JLabel{
    public Back() {
        super();
        super.setSize(800, 600);
        super.setLayout(null);
        super.setOpaque(true);
        super.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        super.setBackground(Color.BLUE);
    }

    public Back(int width, int height,ImageIcon imageBack) {
        super(imageBack);
        imageBack.setImage(imageBack.getImage().getScaledInstance(width, height * 2 / 3, Image.SCALE_DEFAULT));
        super.setSize(width, height * 2 / 3);
        super.setLayout(null);
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
    }

    @Override
    public Point getLocation() {
        return super.getLocation();
    }

    @Override
    public void setLocation(Point p) {
        super.setLocation(p);
    }

}
