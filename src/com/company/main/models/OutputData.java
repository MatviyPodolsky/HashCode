package com.company.main.models;

public class OutputData {

    InputData data;

    public OutputData(InputData data) {
        this.data = data;
    }


    public OutputData clone() {
        OutputData res = new OutputData(data);
        return res;
    }

}
