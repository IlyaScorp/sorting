package ru.mail.polis.sort;


import java.util.Comparator;

public class QuickSort1<T> extends AbstractSortOnComparisons<T>{

    InsertSort instance = null;

    public QuickSort1(Comparator<? super T> c){
        this.comparator = c;
        this.instance = new InsertSort();
    }

    public QuickSort1(){
        this.instance = new InsertSort();
    }

    private void quickSort(T[] a, int left, int right){
        if (right - left < 6){
            instance.sort(a);
        }else {
            if (left >= right) return;
            int idx = partition(a, left, right);
            quickSort(a, left, idx);
            quickSort(a, idx + 1, right);
        }
    }

    private int partition(T[] a, int left, int right) {
        T p = a[(int)Math.ceil(Math.random()* (right - left) + left)];
        int i = left, j = right;
        while (i <= j) {
            while (lesser(a[i],p)) {i++; }
            while (greater(a[j],p)) {j--; }
            if    (i <= j)   swap(a, i++, j--);
        }
        return j;
    }


    @Override
    public void sort(T[] array) {
        quickSort(array,0, array.length - 1);
    }

    }
