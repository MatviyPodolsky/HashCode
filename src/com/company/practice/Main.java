package com.company.practice;


import com.company.practice.io.Reader;
import com.company.practice.io.Writer;
import com.company.practice.models.InputData;
import com.company.practice.models.OutputData;

public class Main {

    public static void main(String[] args) {
//        OutputData example_a = new Logic(new Reader("a_example.in").read()).compute();
//        new Writer("a_example.out").write(example_a);
//
//        OutputData small_b = new Logic(new Reader("b_small.in").read()).compute();
//        new Writer("b_small.out").write(small_b);

//        OutputData medium_c = new Logic(new Reader("c_medium.in").read()).compute();
//        new Writer("c_medium.out").write(medium_c);

//        OutputData quite_big_d = new Logic(new Reader("d_quite_big.in").read()).compute();
//        new Writer("d_quite_big.out").write(quite_big_d);

        OutputData also_big_e = new Logic(new Reader("e_also_big.in").read()).compute();
        new Writer("e_also_big.out").write(also_big_e);
    }

}
