package com.company.main.models;

import java.util.Scanner;

public class InputData {

    int maxSlices;
    int pizzaCount;
    int[] pizzas;

    public InputData(int maxSlices, int pizzaCount) {
        this.maxSlices = maxSlices;
        this.pizzaCount = pizzaCount;
        this.pizzas = new int[pizzaCount];
    }

    public void fillPizzas(Scanner sc) {
        for (int i = 0; i < pizzaCount; i++) {
            pizzas[i] = sc.nextInt();
        }
    }

    public int getPizzaCount() {
        return pizzaCount;
    }

    public int[] getPizzas() {
        return pizzas;
    }

    public int getMaxSlices() {
        return maxSlices;
    }
}
