package com.huoli.Index.LabelOther;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabelOther extends JLabel implements ActionListener {

    private int width;
    private int height;

    public LabelOther(int width, int height) {
        super();
        this.width = width;
        this.height = height;
        create();
    }

    private void create() {
        this.setLocation(0 , 0);
        this.setSize(width, height);
        this.setBackground(Color.lightGray);
        this.setOpaque(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
