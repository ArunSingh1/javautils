package com.practice.exam;

import java.util.*;

public class DataStructureDemo {


    public static void main(String[] args) {
        //lists and arrays
        List<String> stringList = new LinkedList<>();
        stringList = new ArrayList<>();
        String[] array = new String[5];
        array = new String[] { "a", "b" };

        String[] newArray = new String[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = "c";

        stringList = new ArrayList<>(Arrays.asList("a", "b"));
        stringList.add("c");

        //maps, aka dictionary
        Map<String, List<String>> map = new LinkedHashMap<>();
        map.put("development", Arrays.asList("Java", "Python"));
        System.out.println(map);

    }
}


