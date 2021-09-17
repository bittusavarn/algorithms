package com.company;

import java.util.*;

/**
 * This class is for sorting Technique and problem based on sorting
 *
 */
public class Sorting {
    public void quickSort(List<Integer> list){
        quickSort(list,0,list.size()-1);
    }

    public void quickSort(List<Integer> list,int leftIndex, int rightIndex){
        if(leftIndex >= rightIndex)
            return ;

         int  pivot = partition(list,leftIndex,rightIndex);
         int lftNo= list.get(pivot);
         list.set(pivot,list.get(rightIndex));
         list.set(rightIndex,lftNo);
         quickSort(list,leftIndex,pivot-1);
         quickSort(list,pivot+1,rightIndex);
    }


    public int findKthElement(List<Integer> list, int leftIndex, int rightIndex, int k) {
        int pivot = partition(list, leftIndex, rightIndex);
        int lftNo = list.get(pivot);
        list.set(pivot, list.get(rightIndex));
        list.set(rightIndex, lftNo);

        if (pivot == list.size() - k) {
            return list.get(pivot);
        } else if (pivot > list.size() - k) {
            return findKthElement(list, leftIndex, pivot - 1, k);
        } else {
            return findKthElement(list, pivot + 1, rightIndex, k);
        }
    }


    private int partition(List<Integer> list ,int leftIndex,int rightIndex){
        if(rightIndex-leftIndex<=0)
            return  leftIndex;
        int pivot = list.get(rightIndex);
        int i = leftIndex;
        int j = rightIndex -1;
        int count =0;
        while (i<=j){
            count++;
            if(list.get(i)>list.get(j)){
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j,temp);
            }
            if(list.get(i)<=pivot)
                i++;
            else if(list.get(j)>=pivot)
                j--;
           }

        return i;
    }

    public List<Integer> countingSort(List<Integer> list){
        Integer sortedArr[] = new Integer[list.size()];
        Integer max = getMax(list);
        final int arr[] = new int[max+1];
        list.forEach(a->{
            arr[a]=arr[a]+1;
        });
        for(int i=1;i<arr.length;i++){
            arr[i] = arr[i-1]+arr[i];
        }
        list.forEach(a->{
            sortedArr[arr[a]-1]=a;
            arr[a]=arr[a]-1;
        });
        List<Integer> integers = (List<Integer>) Arrays.asList(sortedArr);
        return integers;

    }

    public Integer getMax(List<Integer> list){
        return list.stream().max(Integer::compare).get();
    }

    public static void main(String[] s){
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(0);


        Sorting sorting = new Sorting();
        System.out.println(sorting.findKthElement(list,0,list.size()-1,6));

    }
}
