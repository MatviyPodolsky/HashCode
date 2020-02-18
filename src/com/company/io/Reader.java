package com.company.io;

import java.io.File;
import java.util.Scanner;

public class Reader {

    File file;

    public Reader() {
        file = new File("src/input/in.txt");
    }

    public void read() {
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
        } catch (Exception e) {
            System.out.println("error");
        }

    }

}
