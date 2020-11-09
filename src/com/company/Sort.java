package com.company;

public class Sort {
    public static int[] bubbleSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 1; j < list.length - i; j++) {
                if (list[j - 1] > list[j]) {
                    int tempint = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = tempint;
                }
            }
        }
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        return list;
    }

}
