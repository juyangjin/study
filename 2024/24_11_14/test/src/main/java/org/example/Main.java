package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "banana";
        int[] answer = new int[s.length()];
        char[] arr_s = s.toCharArray();
        int len = 0;

        for (int i = 1; i < s.length(); i++) {
            for (int j = i-1; j >= 0; j--) {
                int tmp = 0;
                int on = 0;
                System.out.println(arr_s[i] + ": i");
                System.out.println(arr_s[j] + ": j");
                if (arr_s[i] != arr_s[j]) {
                    tmp++;
                    System.out.println(tmp);
                } else {
                    answer[len++] = tmp;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
