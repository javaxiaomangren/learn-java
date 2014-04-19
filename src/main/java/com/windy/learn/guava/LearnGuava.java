package com.windy.learn.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;

import java.util.ArrayList;

import static com.google.common.base.Preconditions.checkNotNull;
/**
 * Created by yang.hua on 14-1-20.
 */
public class LearnGuava {
    public static void main(String[] args) {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("a", "b");
        multimap.put("a", "bc");
        multimap.put("c", "dbc");
        System.out.println(multimap.entries());
        for (String s : multimap.keySet()) {
            System.out.println(multimap.get(s).getClass());
            System.out.println("aaa");
        }

    }
}
