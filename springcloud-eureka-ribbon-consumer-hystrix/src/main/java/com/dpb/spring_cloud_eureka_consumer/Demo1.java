package com.dpb.spring_cloud_eureka_consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: springcloud-eureka-ribbon-consumer
 * @description: 案例
 * @author: 波波烤鸭
 * @create: 2019-06-04 22:50
 */
public class Demo1 {

    public static void main(String[] args) {
        String[] s1 = {"and","for","you","us"};
        String msg = "On Friendship and a youth said, \"Speak to us of Friendship.\"  and you us ...";
        // 替换掉 "
        String s2 = msg.replaceAll("\"","");
        // 替换掉 ,
        String s3 = s2.replaceAll(","," ");
        // 替换掉 .
        String s4 = s3.replaceAll("\\."," ");
        // 根据空格切割
        String[] words = s4.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for (String s:s1) {
            // 遍历 s1 获取需要统计的单词
            for (String word:words) {
                if(word.equals(s)){
                    boolean flag = map.containsKey(s);
                    if(flag){
                        map.put(s,map.get(s)+1);
                    }else{
                        map.put(s,1);
                    }
                }
            }
        }
        Set<String> keys = map.keySet();
        for (String key:keys) {
            System.out.println(key+"("+map.get(key)+")");
        }
    }
}
