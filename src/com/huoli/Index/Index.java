package com.huoli.Index;

import com.huoli.Index.Back.Back;
import com.huoli.Index.JScrollPaneState.JScrollPaneState;
import com.huoli.Index.LabelMenu.LabelMenu;
import com.huoli.Index.LabelOther.LabelOther;
import com.huoli.Index.LabelState.LabelState;
import com.huoli.Index.ProcessButtom.ProcessButton;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Index extends JFrame implements Runnable {
    // 5层容器
    private List<ProcessButton> processName = new ArrayList<>();
    private HashMap<String, String> thingName = new HashMap<>();
    private boolean style = true;
    private JLayeredPane lay;
    private JPanel panelProgress;
    private JPanel panelBack;
    private Back labelBack;
    private ImageIcon imageBack;
    private LabelMenu labelMenu;
    private LabelState labelCreate;
    private LabelState labelReady;
    private LabelState labelRun;
    private LabelState labelFinish;
    private LabelState labelBlock;
    private LabelState labelNoThing;
    private LabelOther labelOther;
    private LabelState labelThing;
    //位置布局
    private JScrollPaneState labelCreate1;
    private JScrollPaneState labelReady1;
    private JScrollPaneState labelRun1;
    private JScrollPaneState labelBlock1;
    private JScrollPaneState labelThing1;
    private int width = 1200;
    private int height = 900;
    private int rows = 3;
    private int cols = 3;
    // 总共100
    private int memory = 0;
    private static final int bigMemory = 100;
    private boolean buttonShow = false;

    public Index() {
        super();
        this.setSize(width, height);
        lay = new JLayeredPane();
        imageBack = new ImageIcon("./static/五状态进程转换图.png");
        panelProgress = new JPanel();
        panelBack = new JPanel();
        labelBack = new Back(width, height, imageBack);
        labelBack.setLocation(0, height / 3);
        labelMenu = new LabelMenu(width / rows, height / cols);
        labelThing = new LabelState(width / rows, height / cols);
        labelOther = new LabelOther(width / rows, height / cols);
        labelCreate = new LabelState(width / rows, height / cols);
        labelReady = new LabelState(width / rows, height / cols);
        labelRun = new LabelState(width / rows, height / cols);
        labelFinish = new LabelState(width / rows, height / cols);
        labelBlock = new LabelState(width / rows, height / cols);
        labelNoThing = new LabelState(width / rows, height / cols);
        labelCreate1 = new JScrollPaneState(20, 150);
        labelReady1 = new JScrollPaneState(100, 210);
        labelRun1 = new JScrollPaneState(0, 210);
        labelBlock1 = new JScrollPaneState(70, 130);
        labelThing1 = new JScrollPaneState(0, 0);
        create();
    }

    public void create() {
        drawing();
        labelFinish.setBackground(Color.black);
        labelFinish.setOpaque(true);
        labelFinish.setVisible(false);
        labelNoThing.setLayout(new GridLayout(2, 3));
        setLabelNoThing("创建");
        setLabelNoThing("阻塞");
        setLabelNoThing("说明");
        setLabelNoThing("就绪");
        labelNoThing.add(new JLabel());
        setLabelNoThing("运行");
        labelNoThing.setBackground(Color.PINK);
        labelNoThing.setOpaque(true);
        labelNoThing.setVisible(false);
        labelNoThing.setSize(width / 3, height / 3 - height / 32);
        labelNoThing.setLocation(0, 0);
        labelThing1.setSize(width / 3, height / 3);
        labelThing1.setJPBackground(Color.GRAY);
        // 添加到底层
        lay.add(panelBack, JLayeredPane.DEFAULT_LAYER);
        //添加到中间层
        lay.add(panelProgress, JLayeredPane.MODAL_LAYER);
        this.setLayeredPane(lay);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 100);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void setLabelNoThing(String str) {
        JLabel jb = new JLabel(str);
        jb.setFont(new Font("楷体", Font.BOLD, 48));
        jb.setBorder(BorderFactory.createLineBorder(new Color(188, 143, 143)));
        labelNoThing.add(jb);
    }

    private void setStyle1() {
        labelCreate1.setLocation(20, 150);
        labelReady1.setLocation(100, 210);
        labelRun1.setLocation(0, 210);
        labelBlock1.setLocation(70, 130);
        labelCreate1.setSize(300, 60);
        labelReady1.setSize(300, 60);
        labelRun1.setSize(300, 60);
        labelBlock1.setSize(300, 60);
        labelFinish.setVisible(false);
        labelNoThing.setVisible(false);
    }

    private void setStyle2() {
        labelCreate1.setLocation(0, 0);
        labelReady1.setLocation(0, 0);
        labelRun1.setLocation(0, 0);
        labelBlock1.setLocation(0, 0);
        labelCreate1.setSize(width / 3, height / 3);
        labelReady1.setSize(width / 3, height / 3 - height / 32);
        labelRun1.setSize(width / 3, height / 3 - height / 32);
        labelBlock1.setSize(width / 3, height / 3);
        labelFinish.setVisible(true);
        labelNoThing.setVisible(true);
    }

    private void drawing() {
        //背景
        panelBack.setSize(width, height);
        panelBack.setLayout(null);
        panelBack.add(labelBack);
        panelProgress.setSize(width, height);
        panelProgress.setLocation(0, 0);
        panelProgress.setBackground(null);
        panelProgress.setOpaque(false);
        panelProgress.setLayout(new GridLayout(rows, cols));
        panelProgress.add(labelMenu);
        panelProgress.add(labelThing);
        panelProgress.add(labelOther);
        panelProgress.add(labelCreate);
        panelProgress.add(labelBlock);
        panelProgress.add(labelFinish);
        panelProgress.add(labelReady);
        panelProgress.add(labelNoThing);
        panelProgress.add(labelRun);
        setLabelCreate();
    }

    private void setLabelCreate() {
        labelCreate.add(labelCreate1, BorderLayout.CENTER);
        labelReady.add(labelReady1, BorderLayout.CENTER);
        labelRun.add(labelRun1, BorderLayout.CENTER);
        labelBlock.add(labelBlock1, BorderLayout.CENTER);
        labelThing.add(labelThing1, BorderLayout.CENTER);
    }

    private void setButtonShow() {
        labelBlock1.setShow();
        labelRun1.setShow();
        labelReady1.setShow();
        labelCreate1.setShow();
    }

    @Override
    public void run() {
        String state;
        for (; true; ) {
            if (labelRun1.getNumber() == 0) {
                if (labelReady1.getNumber() == 0 && labelCreate1.getNumber() != 0) {
                    //TODO 将阻塞的挂起
                }
                if (labelReady1.getNumber() != 0) {
                    ProcessButton pb = labelReady1.getButton();
                    labelReady1.deleteButton();
                    labelRun1.addButton(pb.getName(), pb.getProcessSize(), pb.getPriority());
                }
            }
            //线程同步
            if (buttonShow) {
                setButtonShow();
                buttonShow = false;
            }
            state = labelMenu.getListener();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (state.equals("退出")) {
                System.exit(0);
            }
            if (state.equals("创建")) {
                buttonShow = true;
                JDialog dialog = new JDialog();
                dialog.setTitle("创建框");
                dialog.setModal(true);
                dialog.setSize(300, 200);
                dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                dialog.setLocationRelativeTo(null);
                //输入框
                JTextField jtf1 = new JTextField(10);
                JTextField jtf2 = new JTextField(2);
                JTextField jtf3 = new JTextField(2);
                JLabel jl1 = new JLabel("进程名(0-10字符):");
                JLabel jl2 = new JLabel("大小(0-99):");
                JLabel jl3 = new JLabel("优先级(0-99):");
                JPanel jp = new JPanel(new GridLayout(3, 2));
                jp.add(jl1);
                jp.add(jtf1);
                jp.add(jl2);
                jp.add(jtf2);
                jp.add(jl3);
                jp.add(jtf3);
                JButton jb = new JButton("确定");
                JLabel jl4 = new JLabel("进程名不超过10个字符，大小与优先级为0-99:", JLabel.CENTER);
                jb.addActionListener(new ActionListener() {
                    int size = 0;
                    int priority = 0;
                    boolean boolJudge = false;

                    public void actionPerformed(ActionEvent e) {
                        if (jtf1.getText().length() > 10) {
                            String info = "请正确输入进程名！进程名不超过10个字符！";
                            jl4.setText(info);
                            return;
                        }
                        for (int i = 0; i < processName.size(); i++) {
                            if (jtf1.getText().equals(processName.get(i).getName())) {
                                String info = "进程名已被占用！";
                                jl4.setText(info);
                                return;
                            }
                        }
                        if (jtf1.getText().length() == 0) {
                            String info = "请输入进程名！";
                            jl4.setText(info);
                            return;
                        }
                        size = judge(jtf2.getText());
                        if (boolJudge) {
                            return;
                        }
                        priority = judge(jtf3.getText());
                        if (boolJudge) {
                            return;
                        }
                        String sss = jtf1.getText();
                        memory += size;
                        if (memory + size > bigMemory || labelCreate1.getNumber() != 0) {
                            labelCreate1.addButton(jtf1.getText(), size, priority);
                            processName.add(labelCreate1.getButton(sss));
                            dialog.setVisible(false);
                            return;
                        }
                        labelReady1.addButton(jtf1.getText(), size, priority);
                        processName.add(labelReady1.getButton(sss));
                        dialog.setVisible(false);
                    }

                    private int judge(String str) {
                        int num = 0;
                        if (str.length() > 2 || str.length() == 0) {
                            String info = "请正确输入数字！";
                            jl4.setText(info);
                            boolJudge = true;
                            return 0;
                        }
                        for (int i = 0; i < str.length(); i++) {
                            if (str.charAt(i) < 48 || str.charAt(i) > 57) {
                                String info = "请正确输入数字！";
                                jl4.setText(info);
                                boolJudge = true;
                                return 0;
                            }
                            num = num * 10 + str.charAt(i) - 48;
                        }
                        boolJudge = false;
                        return num;
                    }
                });
                dialog.add(jp);
                dialog.add(jl4, BorderLayout.NORTH);
                dialog.add(jb, BorderLayout.SOUTH);
                dialog.setVisible(true);
            }
            if (state.equals("重置")) {
                buttonShow = true;
                reset();
            }
            if (state.equals("调度")) {
                buttonShow = true;
                if (labelRun1.getNumber() == 0) {
                    labelMenu.resetListener();
                    continue;
                }
                labelRun1.getButton().reducePriority();
                for (int i = 0; i < processName.size(); i++) {
                    if (labelRun1.getButton().getName().equals(processName.get(i).getName())) {
                        processName.get(i).reducePriority();
                        break;
                    }
                }
                labelReady1.addButton(labelRun1.getButton());
                labelRun1.deleteButton();
            }
            if (state.equals("阻塞")) {
                buttonShow = true;
                if (labelRun1.getNumber() == 0) {
                    labelMenu.resetListener();
                    continue;
                }
                String inputValue = JOptionPane.showInputDialog(null, "请输入事件代号：\n", "事件", JOptionPane.PLAIN_MESSAGE);
                for (; true; ) {
                    if (thingName.containsKey(inputValue) == false) {
                        break;
                    }
                    inputValue = JOptionPane.showInputDialog(null, "代号已被占用：\n", "事件", JOptionPane.PLAIN_MESSAGE);
                }
                if (inputValue != null && inputValue.length() != 0) {
                    if (labelRun1.getNumber() == 0) {
                        JOptionPane.showMessageDialog(null, "没有正在运行的进程！", "错误提示！", JOptionPane.ERROR_MESSAGE);
                    } else {
                        //事件其它变量不用，置为0，priority同大小放在后面
                        labelThing1.addButton(inputValue, 0, 0);
                        thingName.put(inputValue, labelRun1.getButton().getName());
                        labelBlock1.addButton(labelRun1.getButton());
                        labelRun1.deleteButton();
                    }
                }
            }
            if (state.equals("释放")) {
                buttonShow = true;
                if (labelRun1.getNumber() == 0) {
                    labelMenu.resetListener();
                    continue;
                }
                memory -= labelRun1.getButton().getProcessSize();
                processName.remove(labelRun1.getButton());
                labelRun1.deleteButton();
                if (labelCreate1.getNumber() != 0 && labelCreate1.getButton().getProcessSize() + memory <= bigMemory) {
                    labelReady1.addButton(labelCreate1.getButton());
                    labelCreate1.deleteButton();
                }
            }
            if (state.equals("样式转换")) {
                buttonShow = true;
                if (style) {
                    setStyle2();
                    style = false;
                } else {
                    setStyle1();
                    style = true;
                }
            }
            if (state.equals("信息表")) {
                labelOther.setText("<html><body>" +
                        "总内存：<br>" +
                        this.bigMemory +
                        "。<br>" +
                        "当前已用：<br>" +
                        this.memory +
                        "。<br>" +
                        "</body></html>");
                labelOther.setFont(new Font("宋体", Font.BOLD, 20));
                labelOther.setForeground(Color.RED);
            }
            if (state.equals("示例一")) {
                memory = 0;
                buttonShow = true;
                reset();
                labelRun1.addButton("20", 20, 20);
                processName.add(labelRun1.getButton());
                labelReady1.addButton("1", 1, 1);
                processName.add(labelReady1.getButton());
                labelReady1.addButton("2", 2, 2);
                processName.add(labelReady1.getButton());
                labelReady1.addButton("4", 4, 4);
                processName.add(labelReady1.getButton());
                labelReady1.addButton("7", 7, 7);
                processName.add(labelReady1.getButton());
                labelReady1.addButton("12", 12, 12);
                processName.add(labelReady1.getButton());
                labelReady1.addButton("17", 17, 17);
                this.memory += (20 + 1 + 2 + 4 + 7 + 12 + 17);
                processName.add(labelReady1.getButton());

            }
            labelThingListener();
            processListener();
            if (state.equals(" ")) {
                continue;
            }
            labelMenu.resetListener();
        }
    }

    private void reset() {
        labelCreate1.deleteAllButton();
        labelBlock1.deleteAllButton();
        labelReady1.deleteAllButton();
        labelRun1.deleteAllButton();
        processName.clear();
    }

    // TODO 暂不考虑没有的情况
    private void labelThingListener() {
        String state = labelThing1.getListener();
        if (thingName.containsKey(state)) {
            buttonShow = true;
            String name = thingName.get(state);
            thingName.remove(state);
            labelThing1.deleteButton(state);
            labelReady1.addButton(labelBlock1.getButton(name));
            labelBlock1.deleteButton(name);
        }
        labelThing1.resetListener();
    }

    private void processListener() {
        String state1 = labelRun1.getListener();
        String state2 = labelReady1.getListener();
        String state3 = labelBlock1.getListener();
        String state4 = labelCreate1.getListener();
        boolean bool1, bool2, bool3, bool4;
        for (int i = 0; i < processName.size(); i++) {
            bool1 = state1 == processName.get(i).getName();
            bool2 = state2 == processName.get(i).getName();
            bool3 = state3 == processName.get(i).getName();
            bool4 = state4 == processName.get(i).getName();
            if (bool1 || bool2 || bool3 || bool4) {
                labelOther.setText("<html><body>" +
                        "进程名：<br>" +
                        processName.get(i).getName() +
                        "。<br>" +
                        "大小：<br>" +
                        processName.get(i).getProcessSize() +
                        "。<br>" +
                        "优先级：<br>" +
                        processName.get(i).getPriority() +
                        "。<br>" +
                        "创建时间：<br>" +
                        processName.get(i).getTime() +
                        "。<br>" +
                        "</body></html>");
                labelOther.setFont(new Font("宋体", Font.BOLD, 20));
                labelOther.setForeground(Color.RED);
                break;
            }
        }
        labelRun1.resetListener();
        labelReady1.resetListener();
        labelBlock1.resetListener();
        labelCreate1.resetListener();
    }

}
