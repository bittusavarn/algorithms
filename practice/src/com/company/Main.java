package com.company;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(0);
        list.add(4);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            it.next();
            it.remove();
        }
        System.out.println(it);
        System.out.println(list);


    }

}
