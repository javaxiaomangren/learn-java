package com.windy.learn.guava;

import com.google.common.collect.Maps;
import java.util.*;

/**
 * Created by yang.hua on 14-2-8.
 */
public class Test {
    public static void main(String[] args) {
        Map m = Maps.newHashMap();
        m.put("a", 1);
        m.put("d", 4);
        m.put("b", 3);
        m.put("c", 2);
        me(m);
        System.out.println(m.toString());
    }

    public static void me(Map m) {
        m.remove("a");
    }
}
