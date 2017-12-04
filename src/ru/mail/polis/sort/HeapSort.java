package ru.mail.polis.sort;

import java.util.Arrays;
import java.util.Comparator;

public class HeapSort<T> extends AbstractSortOnComparisons<T>{

    public HeapSort(Comparator<? super T> c){
        this.comparator = c;
    }

    public HeapSort(){

    }

    @Override
    public void sort(T[] array) {
        heapSort(array);
    }


    private static<T> void heapSort(T[] arr){

        HeapSort<T> heap = new HeapSort<>(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - 1 - i] = heap.extract();
        }
    }

    // heap сделал здесь, потому что нужен greater и lesser
    private T[] heap;

        int size = 0;

//        Comparator<? super T> c;

        public HeapSort( T[] arr){
            heap = arr;
            size = heap.length;
            for (int i = size - 1; i >= 0; i--) {
                shiftDown(i);
            }
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

       /* public void insert(T add){
            if (heap.length <= size) {
                grow();
            }
            heap[size] = add;
            shiftUp(size++);
        }*/

       /* private  void shiftUp(int Idx){
            if (Idx == 0){
                return;
            }
            if (Idx % 2 == 0){
//            if(heap[(Idx - 2)/2] < heap[Idx]){
                if (greater(heap[(Idx - 2)/2],heap[Idx])){
                    swap(Idx,(Idx - 2)/2);
                    shiftUp((Idx - 2)/2);
                }
            }else{
//            if(heap[(Idx - 1)/2] < heap[Idx]){
                if (greater(heap[(Idx - 1)/2],heap[Idx])){
                    swap(Idx,(Idx - 1)/2);
                    shiftUp((Idx - 1)/2);
                }
            }
        }*/

        private  void shiftDown(int Idx){
//        if (Idx >= heap.size()) { return; }
            int parentOne  = Idx*2 + 2;
            int parentTwo  = Idx*2 + 1;
//        if (parentOne < size && heap[parentOne] > heap[parentTwo]) {
            if (parentOne < size && lesser(heap[parentOne], heap[parentTwo])) {
//            if (heap[Idx] < heap[parentOne]){
                if (greater(heap[Idx], heap[parentOne])){
                    swap(Idx,parentOne);
                    shiftDown(parentOne);
                }

//        }else if (parentTwo < size && heap[Idx] < heap[parentTwo]){
            }else if (parentTwo < size && greater(heap[Idx], heap[parentTwo])){
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
