package com.company.practice;

import com.company.practice.models.InputData;
import com.company.practice.models.OutputData;

import java.util.Arrays;

public class Logic {

    InputData data;
    OutputData res, clearClone;

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
        clearClone.clearLastData(res.getPizzaCount() - lastAdded);

        int subSize = res.getPizzas()[res.getPizzaCount() - 1];

        tryToFill(subSize, clearClone);

//        for (int i = subSize; i > 0; i--) {
//            tempClone = clearClone.clone();
//            if (tempClone.getTotal() + data.getPizzas()[i] <= data.getMaxSlices()) {
//                tempClone.addPizza(i);
//            }
//            for (int j = i - 1; j > 0; j--) {
//                if (tempClone.getTotal() + data.getPizzas()[i] <= data.getMaxSlices()) {
//                    tempClone.addPizza(i);
//                }
//            }
//            if (tempClone.getTotal() > res.getTotal()) {
//                res = tempClone;
//            }
//        }

        return res;
    }

    public void tryToFill(int size, OutputData input) {
        for (int i = size; i >= 0; i--) {
            OutputData temp = input.clone();
            if (temp.getTotal() + data.getPizzas()[i] <= data.getMaxSlices()) {
                temp.addPizza(i);
            }
            if (i > 0) {
                tryToFill(i - 1, temp);
            } else if (temp.getTotal() > res.getTotal()) {
                res = temp.clone();
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
