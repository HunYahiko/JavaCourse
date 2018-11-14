package com.practice;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Enumeration;

public class SuperClassLoader extends ClassLoader {
    void init() {
        try {
            Enumeration<URL> resources = ClassLoader.getSystemClassLoader().getResources("");
            while(resources.hasMoreElements()) {
                URL url = resources.nextElement();
                File file = new File(url.getPath());
                System.out.println(file);
                traverse(file);
            }
        } catch(IOException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
    
    void traverse(File root) throws IOException, IllegalAccessException, InstantiationException {
        if(root.isDirectory()) {
            File[] rootFiles = root.listFiles();
            for (File rootFile : rootFiles) {
                traverse(rootFile);
            }
        } else {
            if (root.getName().endsWith(".class")) {
                byte[] classBytes = Files.readAllBytes(root.toPath());
                Class<?> loadedClass = defineClass(classBytes, 0, classBytes.length);
                Object object = loadedClass.newInstance();
            }
        }
    }
}
