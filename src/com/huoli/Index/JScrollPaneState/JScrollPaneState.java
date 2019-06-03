package com.huoli.Index.JScrollPaneState;

import com.huoli.Index.ProcessButtom.ProcessButton;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JScrollPaneState extends JScrollPane implements ActionListener {

    private  List<ProcessButton> button = new ArrayList<>();
    private JPanel jpanel;
    private FlowLayout lay;
    private int x;
    private int y;
    private String listener = " ";

    public JScrollPaneState(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        jpanel = new JPanel();
        lay = new FlowLayout(FlowLayout.LEFT);
        create();
    }

    private void create() {
        jpanel.setLayout(lay);
        jpanel.setBackground(Color.black);
        jpanel.setOpaque(true);
        this.setViewportView(jpanel);
        this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.setSize(300, 60);
        this.setLocation(x, y);
        this.setVisible(true);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
    }

    public void setJPBackground(Color color) {
        this.jpanel.setBackground(color);
    }

    public int getNumber() {
        return this.button.size();
    }

    public ProcessButton getButton() {
        return this.button.get(this.button.size() - 1);
    }

    // TODO 暂不考虑没有的情况,只用于事件
    public ProcessButton getButton(String name) {
        int i = 0;
        for (; i < button.size() - 1; i++) {
            if (button.get(i).getName().equals(name)) {
                break;
            }
        }
        return this.button.get(i);
    }

    // TODO button没有值的时候应该抛出异常
    public void deleteButton() {
        button.remove(button.size() - 1);
        setShow();
    }

    // TODO 暂不考虑没有的情况,只用于事件
    public void deleteButton(String name) {
        int i = 0;
        for (; i < button.size() - 1; i++) {
            if (button.get(i).getName().equals(name)) {
                break;
            }
        }
        button.remove(i);
        setShow();
    }

    public void addButton(ProcessButton pb) {
        String name = pb.getName();
        int size = pb.getProcessSize();
        int priority = pb.getPriority();
        addButton(name, size, priority);
    }

    public void addButton(String name, int size, int priority) {
        ProcessButton p = new ProcessButton(name, size, priority);
        int big = button.size() - 1;
        int small = 0;
        if (big == -1 || button.get(big).getPriority() <= priority) {
            button.add(p);
            setShow();
            return;
        }
        if (button.get(small).getPriority() >= priority) {
            button.add(0, p);
            setShow();
            return;
        }
        for (; true; ) {
            if (button.get((big + small) / 2).getPriority() >= priority) {
                big = (big + small) / 2;
            } else {
                small = (big + small) / 2;
            }
            if (small + 1 == big || small == big) {
                break;
            }
        }
        button.add(big, p);
        setShow();
    }

    public void setShow() {
        int len = button.size();
        jpanel.removeAll();
        this.setViewportView(jpanel);
        for (int i = len - 1; i >= 0; i--) {
            jpanel.add(button.get(i));
            button.get(i).setVisible(true);
            button.get(i).addActionListener(this);
        }
    }

    public void deleteAllButton() {
        this.button.clear();
    }

    public String getListener() {
        return this.listener;
    }

    public void resetListener() {
        this.listener = " ";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.listener = e.getActionCommand();
    }
}
