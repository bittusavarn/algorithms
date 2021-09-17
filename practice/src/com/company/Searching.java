package com.company;

import java.util.ArrayList;
import java.util.List;

public class Searching {


    public Integer getIndexUsingBS(List<Integer> list,Integer n){
        return  getIndexUsingBS(list,n,0,list.size()-1);
    }
    public Integer getIndexUsingBS(List<Integer> list,Integer n ,int left,int right){
        if(right<left)
            return -1;
        int midElement = left + (right-left)/2;
        if(list.get(midElement) == n)
            return midElement;
        else if(list.get(midElement)<n){
            return  getIndexUsingBS(list,n,midElement+1,right);
        }
        else{
            return  getIndexUsingBS(list,n,left,right-1);
        }
    }

    public static void main(String[] arga){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(new Searching().getIndexUsingBS(list,0,0,list.size()-1));
    }
}
