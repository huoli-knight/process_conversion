package com.huoli.Index.LabelState;


import javax.swing.JLabel;
import java.awt.Color;

public class LabelState extends JLabel {

    private int width;
    private int height;

    public LabelState(int width, int height) {
        super();
        this.width = width;
        this.height = height;
        create();
    }

    private void create() {
        this.setLocation(0, 0);
        this.setSize(width, height);
        this.setBackground(null);
        this.setOpaque(false);
        this.setVisible(true);
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
    }

    @Override
    public void setSize(int x, int y) {
        super.setSize(x, y);
    }

    @Override
    public void setBackground(Color color) {
        super.setBackground(color);
    }

    @Override
    public void setOpaque(boolean bool) {
        super.setOpaque(bool);
    }
}
