/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.example.springboot.problemsolving;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ekata
 */
public class ProblemSolving {

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 2, 8, 4, 9, 2, 7};
        System.out.println("Input array" + Arrays.toString(arr));
        System.out.println("****************find duplicate element***********************");
        findDuplicate(arr);
        System.out.println("\n****************find Frequency of each element***********************");
        findfrequency(arr);
        System.out.println("****************find first non-repeating element***********************");
        findFirstNonRepetingElement(arr);
        System.out.println("****************find second largest element***********************");
        findsecondLargestdistinctNumber(arr);
        System.out.println("****************remove duplicate element***********************");
        removeDuplicate(arr);
    }

    static void findDuplicate(int[] array) {
        Set<Integer> set = new HashSet<>();
        if (array.length <= 1) {
            System.out.println("No duplicate");
        }
        for (int num : array) {
            if (!set.add(num)) {
                System.out.print(num + " ");
            }
        }

        /*   Arrays.stream(array)
                .filter(num -> !set.add(num))
                .forEach(System.out::println);
         */
    }

    static void findfrequency(int[] array) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : array) {
            /* if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            } else {
                freq.put(num, 1);
                
            }*/

            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        System.out.println(freq);

    }

    static void findFirstNonRepetingElement(int[] array) {
        Map<Integer, Integer> nums = new HashMap<>();
        if (array.length == 0) {
            System.out.println("No non-repeating Element");
            return;
        }

        for (int num : array) {
            nums.put(num, nums.getOrDefault(num, 0) + 1);
        }
        for (int num : array) {
            if (nums.get(num) == 1) {
                System.out.println(num);
                return;
            }
        }
    }

    static void findsecondLargestdistinctNumber(int[] array) {
        if (array.length <= 1) {
            System.out.println("No second Largest");
            return;
        }
        int secondLargest = Arrays.stream(array).boxed().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().orElse(-1);
        System.out.println(secondLargest);
    }

    static void removeDuplicate(int[] array) {
        Map<Integer, Boolean> map = new LinkedHashMap<>();

        for (int num : array) {
            map.put(num, true);
        }
        System.out.println("unique elements ");
        map.keySet().stream().forEach(System.out::println);
    }
}
