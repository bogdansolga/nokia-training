package com.nokia.training.d01.s01;

public class GenericDisplayerUsage {

    public static void main(String[] args) {
        Displayer<Integer> integerDisplayer = new Displayer<>();

        integerDisplayer.display(6);
        //integerDisplayer.display("6"); --> won't compile, as we tried to use a String
        //                                   instead of an Integer
    }
}
