package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,6,2,6,2,18,34,3};
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] mergeSort(int[] arr) {
        int middle = arr.length/2;
        int[] arr1 = new int[middle];
        int[] arr2 = new int[arr.length - middle];
        for(int i = 0; i < middle; i++) {
            arr1[i] = arr[i];
        }
        for(int i = middle, j = 0; i < arr.length; i++, j++) {
            arr2[j] = arr[i];
        }
        if(arr1.length > 1) {
            arr1 = mergeSort(arr1);
        }
        if(arr2.length > 1) {
            arr2 = mergeSort(arr2);
        }
        return merge(arr1, arr2);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int a = 0;
        int b = 0;
        for(int i = 0; i < merged.length; i++) {
            if(a == arr1.length) {
                merged[i] = arr2[b];
                b++;
            } else if (b == arr2.length) {
                merged[i] = arr1[a];
                a++;
            } else if(arr1[a] < arr2[b]) {
                merged[i] = arr1[a];
                a++;
            } else {
                merged[i] = arr2[b];
                b++;
            }
        }
        return merged;
    }
}
