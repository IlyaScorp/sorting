package ru.mail.polis.sort;

import ru.mail.polis.structures.Numerical;


/**
 * Created by Nechaev Mikhail
 * Since 27/11/2017.
 */
public class LSDSort<T extends Numerical> implements Sort<T> {

    public LSDSort() {
        /* empty */

    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort(T[] array) {
        T[] res = null;
        final int r = array[0].getDigitMaxValue();
        int d = array[0].getDigitCount();
        for (int k = 0; k <= d; k++) {
            int[] count = new int[r];
            for (T x : array)
                count[x.getDigit(k)]++;
            for (int i = 1; i < r; i++) {
                count[i] += count[i - 1];
            }
            res = (T[])new Numerical[array.length];
            for (int i = array.length - 1; i >= 0; i--) {
                res[--count[array[i].getDigit(k)]] = array[i];
            }
            System.arraycopy(res, 0, array, 0, array.length);}
            array = res;

    }

}
