package com.zhuiyi.demo.studyTest.mapGather;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/** Map集合
 * @author by niYongJian
 * @Date 2022-07-24 18:30
 */
public class Test {
    public static void main(String[] args) {
        /**
         * HashMap
         *  key要唯一,线程不安全，运行较快，
         */
        Map<String,String> map1=new HashMap<>();
        map1.put("张三","3");
        map1.put("李四","4");
        map1.put("王五","5");
        System.out.println("HashMap"+map1);
        map1.put("李四","44");
        map1.put(null,"55");
        System.out.println("HashMap"+map1);
        System.out.println("HashMap是否包含某个key"+map1.containsKey("李四"));
        //遍历1
        Set<String>setmap=map1.keySet();
        for (String key:setmap){
            System.out.println("HashMap遍历1 "+map1.get(key));
        }
        //遍历2
        Set<Map.Entry<String,String >> entrySet=map1.entrySet();
        for (Map.Entry<String,String > entryKey :entrySet){
            System.out.println("HashMap遍历2"+ " " + entryKey.getKey() + " " + entryKey.getValue());
        }


        /**
         * TreeMap
         *      key会自动排序，但是需要继承comparable接口
         */
        Map<String,String> map2=new TreeMap<>();
        map2.put("张三","3");
        map2.put("王五","5");
        map2.put("李四","4");
        System.out.println("TreeMap "+ map2);
        map2.put("张三1","3");
        map2.put("null",null);
        System.out.println("TreeMap "+ map2);
    }
}
