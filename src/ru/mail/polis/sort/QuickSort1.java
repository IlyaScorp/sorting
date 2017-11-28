package ru.mail.polis.sort;


public class QuickSort1<T> extends AbstractSortOnComparisons<T>{

    InsertSort instance = null;

    QuickSort1(){
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

    class InsertSort{

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




}
