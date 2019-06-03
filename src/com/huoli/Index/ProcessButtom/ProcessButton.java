package com.huoli.Index.ProcessButtom;

import javax.swing.JButton;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProcessButton extends JButton {

    private int size;
    private int priority;
    private String name;
    private Date date;
    private String time;
    private Calendar calendar;
    private SimpleDateFormat sdf;

    public ProcessButton(String name, int size, int priority) {
        super();
        this.name = name;
        this.size = size;
        this.priority = priority;
        calendar = Calendar.getInstance();
        date = calendar.getTime();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SS毫秒");
        time = sdf.format(date);
        create();
    }

    private void create() {
        this.setText(name);
        this.setVisible(true);
    }

    @Override
    public void setVisible(boolean bool){
        super.setVisible(bool);
    }

    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.priority;
    }

    public void reducePriority() {
        if (priority != 0) {
            this.priority -= 1;
        }
    }

    public int getProcessSize() {
        return this.size;
    }

    public String getTime() {
        return this.time;
    }
}
