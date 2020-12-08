package dev.chu.myapplication;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
    @org.junit.Test
    public void test() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("Notion", "Free1");
        hashMap.put("Medium", "Free2");
        hashMap.put("Tstory", "Free3");
        for(Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println("key : value = "+entry.getKey()+" : "+entry.getValue());
            System.out.println(entry.getKey().hashCode());
            System.out.println(entry.getValue().hashCode());
        }

        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Notion", "Free1");
        linkedHashMap.put("Medium", "Free2");
        for(Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            System.out.println("key : value = "+entry.getKey()+" : "+entry.getValue());
            System.out.println(entry.getKey().hashCode());
            System.out.println(entry.getValue().hashCode());
        }
    }
}
