package com.huoli.Index.LabelMenu;

import com.huoli.Index.Index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabelMenu extends JLabel implements ActionListener {

    private JButton newCreate;
    private JButton information;
    private JButton overtime;
    private JButton wait;
    private JButton finish;
    private JButton reset;
    private JButton example;
    private JButton style;
    private JButton end;
    private String listener = " ";
    private int width;
    private int height;

    public LabelMenu(int width, int height) {
        super();
        this.width = width;
        this.height = height;
        create();
    }

    private void create() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setOpaque(true);
        newCreate = new JButton("创建");
        information = new JButton("信息表");
        overtime = new JButton("调度");
        wait = new JButton("阻塞");
        finish = new JButton("释放");
        reset = new JButton("重置");
        example = new JButton("示例一");
        style = new JButton("样式转换");
        end = new JButton("退出");
        this.setSize(width, height);
        this.setLocation(0, 0);
        setMenuJButton();
        this.setVisible(true);
    }

    public void resetListener() {
        this.listener = " ";
    }

    private void setMenuJButton() {
        Color color = Color.blue;
        int x = 0;
        int y = 0;
        int xw = width / 2;
        int yh = height / 5;
        int w = xw - width / 8;
        int h = yh - height / 16;
        newCreate.setBackground(color);
        newCreate.setBounds(x, y, w, h);
        x = xw;
        this.add(newCreate);
        newCreate.addActionListener(this);
        information.setBounds(x, y, w, h);
        information.setBackground(color);
        x = 0;
        y += yh;
        this.add(information);
        information.addActionListener(this);
        overtime.setBackground(color);
        overtime.setBounds(x, y, w, h);
        x = xw;
        this.add(overtime);
        overtime.addActionListener(this);
        wait.setBackground(color);
        wait.setBounds(x, y, w, h);
        x = 0;
        y += yh;
        this.add(wait);
        wait.addActionListener(this);
        finish.setBackground(color);
        finish.setBounds(x, y, w, h);
        x = xw;
        this.add(finish);
        finish.addActionListener(this);
        reset.setBackground(color);
        reset.setBounds(x, y, w, h);
        x = 0;
        y += yh;
        this.add(reset);
        reset.addActionListener(this);
        example.setBackground(color);
        example.setBounds(x, y, w, h);
        x = xw;
        this.add(example);
        example.addActionListener(this);
        style.setBackground(color);
        style.setBounds(x, y, w, h);
        x = 0;
        y += yh;
        this.add(style);
        style.addActionListener(this);
        end.setBackground(color);
        end.setBounds(x, y, w, h);
        this.add(end);
        end.addActionListener(this);
    }

    public String getListener() {
        return this.listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.listener = e.getActionCommand();
    }
}
