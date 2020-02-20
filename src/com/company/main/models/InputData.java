package com.company.main.models;

import java.util.Scanner;

public class InputData {

    int books, libCount, days;
    int[] bookWeights;
    Library[] libraries;

    public InputData(Scanner sc) {
        this.books = sc.nextInt();
        this.libCount = sc.nextInt();
        this.days = sc.nextInt();
        this.bookWeights = new int[books];
        this.libraries = new Library[libCount];
        fillBookWeights(sc);
        fillLibraries(sc);
    }

    public void fillBookWeights(Scanner sc) {
        for (int i = 0; i < books; i++) {
            bookWeights[i] = sc.nextInt();
        }
    }

    public void fillLibraries(Scanner sc) {
        for (int i = 0; i < libCount; i++) {
            Library l = new Library(sc.nextInt(), sc.nextInt(), sc.nextInt());
            l.fillBooks(sc);
            libraries[i] = l;
        }
    }

    public int getBooks() {
        return books;
    }

    public int getLibCount() {
        return libCount;
    }

    public int getDays() {
        return days;
    }

    public int[] getBookWeights() {
        return bookWeights;
    }

    public Library[] getLibraries() {
        return libraries;
    }
}
