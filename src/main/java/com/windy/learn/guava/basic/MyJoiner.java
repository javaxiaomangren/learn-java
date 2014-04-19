package com.windy.learn.guava.basic;

/**
 * Created by yang.hua on 14-4-9.
 */
public class MyJoiner {

    public MyJoiner on(String separator) {
        return new MyJoiner(separator);
    }

    public MyJoiner on(char separator) {
        return new MyJoiner(String.valueOf(separator));
    }

    private final String separator;

    private MyJoiner(String separator) {
        this.separator = checkNotNull(separator);
    }

    private MyJoiner(MyJoiner prototype) {
        this.separator = prototype.separator;
    }

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }
}
