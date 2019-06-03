package com.huoli.Main;

import com.huoli.Index.Index;

public class Main {

    public static void main(String[] args) {
        Index start = new Index();
        Thread th = new Thread(start);
        th.start();
    }
}
