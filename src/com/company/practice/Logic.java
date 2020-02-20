package com.company.practice;

import com.company.practice.models.InputData;
import com.company.practice.models.OutputData;

import java.util.Arrays;

public class Logic {

    InputData data;
    OutputData res, clearClone;
    int countDifference;
    boolean wasSolutionFound = false;

    public Logic(InputData data) {
        this.data = data;
    }

    public OutputData compute() {
        res = new OutputData(data);
        Arrays.sort(data.getPizzas());
        int max = 0;
        for (int i = 0; i < data.getPizzaCount(); i++) {
            if (data.getPizzas()[i] <= data.getMaxSlices()) {
                max = i;
            }
        }
        int lastAdded = -1;
        boolean wasGap = false;
        for (int i = max; i >= 0; i--) {
            if (res.getTotal() + data.getPizzas()[i] <= data.getMaxSlices()) {
                res.addPizza(i);
                if (!wasGap) {
                    lastAdded = res.getPizzaCount();
                }
            } else {
                wasGap = true;
            }
        }

        clearClone = res.clone();
        clearClone.clearLastData(res.getPizzaCount() - lastAdded + 1);

        int subSize;
        if (clearClone.getPizzaCount() > 0) {
            subSize = clearClone.getPizzas()[clearClone.getPizzaCount() - 1] - 3;// -2 because need to skip last large value
        } else {
            subSize = data.getPizzaCount() - 1;
        }

        countDifference = res.getPizzaCount() - clearClone.getPizzaCount();

        for (int i = subSize; i > 0; i++) {
            tryToFill(subSize - 1, clearClone, 1);
                System.out.println(wasSolutionFound);
                if (wasSolutionFound) break;
        }

        return res;
    }

    public void tryToFill(int size, OutputData input, int deep) {
        int max = Math.max(size - 200, 0);
        for (int i = size; i >= max; i--) {
//            if (deep == 1) {
//                System.out.println(i);
//            }
            OutputData temp = input.clone();
            if (temp.getTotal() + data.getPizzas()[i] <= data.getMaxSlices()) {
                temp.addPizza(i);
                if (i > 0 && deep < countDifference * 2) {
                    tryToFill(i - 1, temp, deep+1);
                } else if (temp.getTotal() > res.getTotal()) {
                    res = temp.clone();
                    wasSolutionFound = true;
                }
            }
        }
    }

    public OutputData computeOptimized() {
        OutputData res = new OutputData(data);
        Arrays.sort(data.getPizzas());
        int last = 0;
        for (int i = 0; i < data.getPizzaCount(); i++) {
            if (res.getTotal() + data.getPizzas()[i] < data.getMaxSlices()) {
                res.addPizza(i);
                last = i;
            }
        }
        int check = needReplace(20, last, res);
        if (check > 0) {
            res.replace(check, data.getPizzas()[last + 1]);
        }
        return res;
    }

    public int needReplace(int count, int last, OutputData res) {
        int record = -1;
        if (last + 1 > data.getPizzas().length) {
            return -1;
        }
        for (int i = last - 1; i > Math.max(last - count, 0); i--) {
            int assumption = res.getTotal() - res.getSum(i, last) + data.getPizzas()[last + 1];
            if (assumption > data.getMaxSlices()) {
                break;
            }
            if (assumption > res.getTotal()) {
                record = i;
            }
        }
        return record;
    }

}
