package ru.mail.polis.sort;

import java.util.Comparator;

public class InsertSort<T> extends AbstractSortOnComparisons<T>{


    public InsertSort(Comparator<? super T> c ){
        super();
        this.comparator = c;
    }

    public InsertSort(){

    }

    public  void sort(T[] arr){
        T curr;
        int j;
        for (int i = 1; i < arr.length; i++) {
            curr = arr[i];
            for ( j = i; j > 0 && lesser(curr,arr[j - 1]); j--) {
                arr[j] = arr[j - 1];
            }
            if (j != i) {
                arr[j] = curr;
            }
        }
    }

}
