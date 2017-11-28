package ru.mail.polis.sort;

import java.util.Comparator;

public class HeapSort<T> extends AbstractSortOnComparisons<T>{

    @Override
    public void sort(T[] array) {

    }

    public static<T> void heapSort(T[] arr, Comparator<? super T> c){
     // Мне нужно передать компаратор в хип! Нужен метод getCompare в абстрактсортонкомпарейшн
        // но, как я понимаю, мы должны обойтись без него. Как?

        QuickHeap<T> heap = new QuickHeap<>(arr,c);
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - 1 - i] = heap.extract();
        }
    }


}
