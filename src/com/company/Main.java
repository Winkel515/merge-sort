package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{96,5,255,6,39,66,256,18,34,3};
        mergeSort(arr,0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int begin, int end) {
        int middle = (end+begin)/2;
        if(middle - begin > 1) {
            mergeSort(arr, begin, middle);
        }
        if(end - middle > 1) {
            mergeSort(arr, middle, end);
        }
        merge(arr, begin, middle, end);
    }

    public static void merge(int[]arr, int begin, int middle, int end) {
        int[] arr1 = new int[middle-begin];
        int[] arr2 = new int[end-middle];
        for(int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[begin+i];
        }
        for(int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[middle+i];
        }
        int a = 0;
        int b = 0;
        for(int i = begin; i < end; i++) {
            if(a == arr1.length) {
                arr[i] = arr2[b];
                b++;
            } else if(b == arr2.length) {
                arr[i] = arr1[a];
                a++;
            } else if (arr1[a] < arr2[b]) {
                arr[i] = arr1[a];
                a++;
            } else {
                arr[i] = arr2[b];
                b++;
            }
        }
    }

//    public static int[] merge(int[] arr1, int[] arr2) {
//        int[] merged = new int[arr1.length + arr2.length];
//        int a = 0;
//        int b = 0;
//        for(int i = 0; i < merged.length; i++) {
//            if(a == arr1.length) {
//                merged[i] = arr2[b];
//                b++;
//            } else if (b == arr2.length) {
//                merged[i] = arr1[a];
//                a++;
//            } else if(arr1[a] < arr2[b]) {
//                merged[i] = arr1[a];
//                a++;
//            } else {
//                merged[i] = arr2[b];
//                b++;
//            }
//        }
//        return merged;
//    }
}
