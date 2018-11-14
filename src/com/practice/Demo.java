package com.practice;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class Demo {
    public static void main(String[] args) {
        SuperClassLoader superClassLoader = new SuperClassLoader();
        superClassLoader.init();
    }
}
