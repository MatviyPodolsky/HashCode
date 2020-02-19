package com.company.main.io;

import com.company.main.models.InputData;

import java.io.File;
import java.util.Scanner;

public class Reader {

    File file;

    public Reader(String filename) {
        file = new File("src/com/company/main/input/" + filename);
    }

    public InputData read() {
        try {
            Scanner sc = new Scanner(file);
            InputData data = new InputData(sc.nextInt(), sc.nextInt());
            data.fillPizzas(sc);
            return data;
        } catch (Exception e) {
            System.out.println("error");
        }
        return null;
    }

}
