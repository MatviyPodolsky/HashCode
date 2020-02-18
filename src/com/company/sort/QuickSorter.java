package com.company.sort;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.io.Console;
import java.util.Random;

class QuickSorter implements Runnable {
    int[] data;
    int start,end;
    Callback callback;

    interface Callback {
        void onFinish();
    }

    QuickSorter(int[] data, int start, int end, Callback callback) {
        this.data=data;
        this.start=start;
        this.end=end;
        this.callback = callback;
    }
    public void run(){
        quickSort(this.data,this.start,this.end);
        if (callback != null) {
            callback.onFinish();
        }
//        System.out.println("finish");
    }
    static void swap(int[] data, int i, int j){
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;
    }
    static int partition(int[] data, int start, int end) {
        if(start==end)
            return start;
        int pivot=data[end];
        int s=start-1;
        for(int i=start;i<end;i++)
            if(data[i]<=pivot)
                swap(data,++s,i);
        swap(data,++s,end);
        return s;
    }
    static void quickSort(int[] data, int start, int end) {
        if (end<=start)
            return;
        int s=partition(data,start,end);
        quickSort(data,start,s-1);
        quickSort(data,s+1,end);
    }

    public static void main(String[] args) {
//        int[] data={3,1,2,8,5,6};
//        quickSort(data,0,data.length-1);
//        for(int i:data)
//            System.out.format("%d ",i);
//        System.out.format("\n");
//        int n=10000000;
//        data=randomList(n,1000000);
//        int s=partition(data,0,n-1);
//        Thread t1=new Thread(new QuickSorter(data,0,s-1));
//        Thread t2=new Thread(new QuickSorter(data,s+1,data.length-1));
//        t1.start();
//        t2.start();
//        try {
//            t1.join();
//            t2.join();
//        }catch(InterruptedException e){
//            System.out.println(e);
//        }
    }
}
