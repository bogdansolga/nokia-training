package com.nokia.training.d01.s01;

import java.util.ArrayList;
import java.util.List;

public class Tuple<T1, T2 extends Product> {
    private T1 first;

    private T2 second;

    public T1 getFirst() {
        return first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }

    public static List<?> returnedPair() {
        return new ArrayList<>();
    }
}
