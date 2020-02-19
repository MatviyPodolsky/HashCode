package com.company.main.io;


import com.company.main.models.OutputData;

import java.io.File;
import java.io.FileWriter;

public class Writer {

    File file;

    public Writer(String filename) {
        file = new File("src/com/company/main/output/" + filename);
    }

    public void write(OutputData data) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(buildResult(data));
            writer.flush();
            writer.close();
        } catch (Exception exp) {
        }
    }

    public String buildResult(OutputData data) {
        StringBuilder sb = new StringBuilder();
        sb.append("test");
//        sb.append(data.getPizzaCount());
//        sb.append("\n");
//        for (int i = 0; i < data.getPizzaCount(); i++) {
//            sb.append(data.getPizzas()[i]);
//            sb.append(" ");
//        }
        return sb.toString();
    }

}
