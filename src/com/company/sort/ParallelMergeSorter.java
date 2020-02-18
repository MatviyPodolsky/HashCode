package com.company.sort;

import java.util.Comparator;
import java.util.Random;

public class ParallelMergeSorter extends Thread {

    int TRESHHOLD = 1000;
    /**
     * Sorts an array, using the merge sort algorithm.
     *
     * @param a the array to sort
     * @param comp the comparator to compare array elements
     */
    public static <E> void sort(E[] a, Comparator<? super E> comp, int threads) {
//        parallelQuickSort(a, 0, a.length-1, comp, threads);
    }

//    static void swap(int[] data, int i, int j){
//        int tmp=data[i];
//        data[i]=data[j];
//        data[j]=tmp;
//    }

    static <E> void swap(E[] data, int i, int j){
        E tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;
    }

//    static int partition(int[] data, int start, int end) {
//        if(start==end)
//            return start;
//        int pivot=data[end];
//        int s=start-1;
//        for(int i=start;i<end;i++)
//            if(data[i]<=pivot)
//                swap(data,++s,i);
//        swap(data,++s,end);
//        return s;
//    }

    static <E> int partition(E[] data, int start, int end, Comparator<? super E> comp) {
        if(start == end) return start;
        E pivot = data[end];
        int s = start-1;
        for(int i = start; i < end; i++) {
            if (comp.compare(data[i], pivot) <= 0) {
                swap(data, ++s, i);
            }
        }
        swap(data, ++s, end);
        return s;
    }

//    private static <E> int divide(E[] arr, int left, int right, Comparator<? super E> comp) {
////        Random rnd = new Random();
////        E pivot = arr[rnd.nextInt(right - left) + left];
//        E pivot = arr[right];
//        left--;
//        right++;
//
//        while (true)
//        {
//            while (comp.compare(arr[left], pivot)<0) left++;
//            while (comp.compare(arr[right], pivot)>0) right--;
//
//            if (left < right) {
//                if (comp.compare(arr[left], arr[right])==0) {
////                    return right;
//                    left--;
//                    right--;
//                }
//                swap(arr, left, right);
//            } else {
//                return right;
//            }
//        }
//    }

    private static <E> int divide(E[] arr, int left, int right, Comparator<? super E> comp) {
        int i = left, j = right;
        E opora = arr[right];
        while (i <= j) {
            while (comp.compare(arr[i], opora) < 0) {
                i++;
            }

            while (comp.compare(arr[j], opora) > 0) {
                j--;
            }

            if (i <= j) {//меняем местами
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return j;
    }

//    static <E> void quickSort(E[] a, int from, int to,
//                          Comparator<? super E> comp) {
//        if (to<=from) return;
//
//        int s=partition(a,from,to, comp);
//        quickSort(a,from,s-1, comp);
//        quickSort(a,s+1,to, comp);
//    }

//    static <E> void quickSort(E[] data, int start, int end, Comparator<? super E> comp) {
//        if (end<=start)
//            return;
//        int s=divide(data,start,end, comp);
//        quickSort(data,start,s-1, comp);
//        quickSort(data,s+1,end, comp);
//    }

//    private static <E> void parallelQuickSort(E[] a, int from, int to, Comparator<? super E> comp, int availableThreads){
//        if (to - from > 0){
//            if (availableThreads <=1) {
//                quickSort(a, from, to, comp);
//            }
//            else {
////                int middle = to/2;
//                int middle=divide(a,from,to, comp);
//
//                Thread firstHalf = new Thread(){
//                    public void run(){
//                        parallelQuickSort(a, from, middle, comp, availableThreads - 1);
//                    }
//                };
//                Thread secondHalf = new Thread(){
//                    public void run(){
//                        parallelQuickSort(a, middle + 1, to, comp, availableThreads - 1);
//                    }
//                };
//
//                firstHalf.start();
//                secondHalf.start();
//
//                try {
//                    firstHalf.join();
//                    secondHalf.join();
//                } catch (InterruptedException ie) {
//                    ie.printStackTrace();
//                }
//            }
//        }
//    }

    //---------------------------------------
    public static <E> void quickSort(E[] array, int low, int high, Comparator<? super E> comp, int availableThreads) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        E opora = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (comp.compare(array[i], opora) < 0) {
                i++;
            }

            while (comp.compare(array[j], opora) > 0) {
                j--;
            }

            if (i <= j) {
                E temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

//        if (availableThreads <= 1) {
            if (low < j) {
                if (j - low < 1000) {
                    quickSort(array, low, j, comp, 1);
                } else {
                    int finalJ = j;
                    Thread firstHalf = new Thread(() -> quickSort(array, low, finalJ, comp, availableThreads - 2));
                    firstHalf.start();
                    try {
                        firstHalf.join();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }

            if (high > i) {
                if (high - i < 1000) {
                    quickSort(array, i, high, comp, 1);
                } else {
                    int finalI = i;
                    Thread secondHalf = new Thread(() -> quickSort(array, finalI, high, comp, availableThreads - 2));
                    secondHalf.start();
                    try {
                        secondHalf.join();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
//        } else {
//            if (low < j) {
//                int finalJ = j;
//                Thread firstHalf = new Thread(() -> quickSort(array, low, finalJ, comp, availableThreads - 2));
//                firstHalf.start();
//                try {
//                    firstHalf.join();
//                } catch (InterruptedException ie) {
//                    ie.printStackTrace();
//                }
//            }
//
//            if (high > i) {
//                int finalI = i;
//                Thread secondHalf = new Thread(() -> quickSort(array, finalI, high, comp, availableThreads - 2));
//                secondHalf.start();
//                try {
//                    secondHalf.join();
//                } catch (InterruptedException ie) {
//                    ie.printStackTrace();
//                }
//            }
//        }
    }

}
