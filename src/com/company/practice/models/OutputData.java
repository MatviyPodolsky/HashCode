package com.company.practice.models;

import java.util.Scanner;

public class OutputData {

    int pizzaCount;
    int total;
    int[] pizzas;
    InputData data;

    public OutputData(InputData data) {
        this.total = 0;
        this.pizzaCount = 0;
        this.pizzas = new int[data.getPizzaCount()];
        this.data = data;
    }

    public void addPizza(int pos) {
        pizzas[pizzaCount] = pos;
        pizzaCount++;
        total += data.getPizzas()[pos];
    }

    public int getPizzaCount() {
        return pizzaCount;
    }

    public int getTotal() {
        return total;
    }

    public int[] getPizzas() {
        return pizzas;
    }

    public void clearLastData(int count) {
        for (int i = 0; i < count; i++) {
            pizzaCount--;
            total -= data.getPizzas()[pizzas[pizzaCount]];
        }
    }

    public void replace(int pos, int value) {
        pizzas[pos] = value;
        pizzaCount = pos + 1;
    }

    public void setPizzaCount(int pizzaCount) {
        this.pizzaCount = pizzaCount;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPizzas(int[] pizzas) {
        this.pizzas = pizzas;
    }

    public int getSum(int from, int to) {
        int res = 0;
        for (int i = from; i <= to; i++) {
            res += data.getPizzas()[i];
        }
        return res;
    }

    public OutputData clone() {
        OutputData res = new OutputData(data);
        res.setPizzaCount(getPizzaCount());
        res.setPizzas(getPizzas().clone());
        res.setTotal(getTotal());
        return res;
    }

}
