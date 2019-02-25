package com.mitrais.training;

import java.util.*;

public class CollectionDemo {
    public static Set hashSetDemo(){
        Set<String> data=new HashSet<>();
        data.add("Denny Kristianto");
        data.add("Kadek Winda Dwiastini");
        data.add("Robertus Lantip Wicaksono");
        return data;
    }
    public static Map hashMapDemo(){
        Map<String, String> data=new HashMap<>();
        data.put("Denny Kristianto","biasa dipanggil Denny");
        data.put("Kadek Winda Dwiastini","biasa dipanggil Winda");
        data.put("Robertus Lantip Wicaksono","biasa dipanggil robert");
        return data;
    }
    public static List arrayListDemo(){
        List<String> data=new ArrayList<>();
        data.add("ini data pertama");
        data.add("ini data kedua");
        data.add("ini data ketiga");
        return data;
    }
}
