package com.company.main;

import com.company.main.models.InputData;
import com.company.main.models.OutputData;

import java.util.Arrays;

public class Logic {

    InputData data;
    OutputData res;

    public Logic(InputData data) {
        this.data = data;
    }

    public OutputData compute() {
        res = new OutputData(data);

        return res;
    }

}
