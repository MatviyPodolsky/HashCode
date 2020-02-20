package com.company.main.models;

import java.util.Scanner;

public class Library {

    int booksCount;
    int sign;
    int speed;
    int[] books;

    public Library(int booksCount, int sign, int speed) {
        this.booksCount = booksCount;
        this.sign = sign;
        this.speed = speed;
        books = new int[booksCount];
    }

    public void fillBooks(Scanner sc) {
        for (int i = 0; i < booksCount; i++) {
            books[i] = sc.nextInt();
        }
    }
}
