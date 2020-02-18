package com.company.io;

import java.io.File;

public class Writer {

    File file;

    public Writer(String filename) {
        file = new File("src/output/" + filename);
    }

    public void write() {

    }

}
