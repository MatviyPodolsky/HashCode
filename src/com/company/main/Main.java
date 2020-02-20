package com.company.main;


import com.company.main.io.Reader;
import com.company.main.io.Writer;
import com.company.main.models.OutputData;

public class Main {

    public static void main(String[] args) {
        OutputData a_example = new Logic(new Reader("a_example.txt").read()).compute();
        new Writer("a_example.out").write(a_example);

//        OutputData b_read_on = new Logic(new Reader("b_read_on.txt").read()).compute();
//        new Writer("b_read_on.out").write(b_read_on);

//        OutputData c_incunabula = new Logic(new Reader("c_incunabula.txt").read()).compute();
//        new Writer("c_incunabula.out").write(c_incunabula);
//
//        OutputData d_tough_choises = new Logic(new Reader("d_tough_choises.txt").read()).compute();
//        new Writer("d_tough_choises.out").write(d_tough_choises);
//
//        OutputData e_so_many_books = new Logic(new Reader("e_so_many_books.txt").read()).compute();
//        new Writer("e_so_many_books.out").write(e_so_many_books);
//
//        OutputData f_libraries_of_the_world = new Logic(new Reader("f_libraries_of_the_world.txt").read()).compute();
//        new Writer("f_libraries_of_the_world.out").write(f_libraries_of_the_world);
    }

}
