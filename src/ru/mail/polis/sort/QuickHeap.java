package ru.mail.polis.sort;

import java.util.Arrays;
import java.util.Comparator;

public class QuickHeap<T> {
    private T[] heap;
    int size = 0;

    Comparator<? super T> c;
    public QuickHeap( T[] arr, Comparator<? super T> c){
        heap = arr;
        size = heap.length;
        this.c = c;
        for (int i = size - 1; i >= 0; i--) {
            shiftDown(i);
        }
    }

    public QuickHeap(){

    }

    public void  set( Comparator<? super T> c){
        this.c = c;
    }

    public  T extract(){
        T tmp = heap[0];
        heap[0] = heap[--size];
        shiftDown(0);
        if (heap.length > 4*size && size != 0){
            shrink();
        }
        return tmp;
    }

    public void insert(T add){
        if (heap.length <= size) {
            grow();
        }
        heap[size] = add;
        shiftUp(size++);
    }

    private  void shiftUp(int Idx){
        if (Idx == 0){
            return;
        }
        if (Idx % 2 == 0){
//            if(heap[(Idx - 2)/2] < heap[Idx]){
            if (c.compare(heap[(Idx - 2)/2],heap[Idx]) > 0){
                swap(Idx,(Idx - 2)/2);
                shiftUp((Idx - 2)/2);
            }
        }else{
//            if(heap[(Idx - 1)/2] < heap[Idx]){
            if (c.compare(heap[(Idx - 1)/2],heap[Idx]) > 0){
                swap(Idx,(Idx - 1)/2);
                shiftUp((Idx - 1)/2);
            }
        }
    }

    private  void shiftDown(int Idx){
//        if (Idx >= heap.size()) { return; }
        int parentOne  = Idx*2 + 2;
        int parentTwo  = Idx*2 + 1;
//        if (parentOne < size && heap[parentOne] > heap[parentTwo]) {
        if (parentOne < size && c.compare(heap[parentOne], heap[parentTwo]) < 0) {
//            if (heap[Idx] < heap[parentOne]){
            if (c.compare(heap[Idx], heap[parentOne]) > 0){
                swap(Idx,parentOne);
                shiftDown(parentOne);
            }

//        }else if (parentTwo < size && heap[Idx] < heap[parentTwo]){
        }else if (parentTwo < size && c.compare(heap[Idx], heap[parentTwo]) > 0){
            swap(Idx,parentTwo);
            shiftDown(parentTwo);
        }

    }

    private void swap(int one, int two){
        T tmp = heap[one];
        heap[one] = heap[two];
        heap[two] = tmp;
    }

    private void grow() {

        changeCapacity(heap.length/2 + heap.length);

    }

    private void shrink() {

        changeCapacity(heap.length/2);
    }

    private void changeCapacity(int newCapacity) {

        heap = Arrays.copyOf(heap,newCapacity);
    }


}




