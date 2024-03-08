package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

/*

 */

public class App {
    public static int isArrayPalindrome(ArrayList<Integer> array, ArrayList<String> words1, ArrayList<String> words2,boolean process) {
            HashMap<Integer,Integer> map1 = new HashMap<>();
            HashMap<Integer,Integer> map2 = new HashMap<>();

        for (int i = 0; i < array.size(); i++) {
            map1.put(array.get(i), 0);
            map2.put(array.get(i), 0);
        }
            int count1 = 0;int count2 = 0;
        if(process){

            for(int i = 0;i<array.size();i++){
                count1 = 0;
                count2 = 0;
                for(int j = 0;j< words1.size();j++){
                    if(words1.get(j).length() == array.get(i)){
                        if(isPalindrome(words1.get(j))){
                            count1++;
                            if(map1.containsKey(array.get(i)))
                                map1.put(array.get(i),map1.get(array.get(i))+1);
                            else
                                map1.put(array.get(i),1);
                        }
                    }
                }
                for(int k = 0;k< words2.size();k++){
                    if(words2.get(k).length() == array.get(i)){
                        if(isPalindrome(words2.get(k))){
                            count2++;
                            if(map2.containsKey(array.get(i)))
                            map2.put(array.get(i),map2.get(array.get(i))+1);
                            else
                                map2.put(array.get(i),1);
                        }
                    }
                }


            }
            System.out.println(map1);
            System.out.println(map2);
            int max1 =0;
            int max2 = 0;
            for(Integer i : map1.keySet()){
                if(map1.get(i)>max1)
                    max1 = map2.get(i);

            }
            for(Integer i : map2.keySet()){
                if(map2.get(i)>max2)
                    max2 = map2.get(i);

            }
            return Math.max(max1,max2);

        }
        else return -1;

    }

    public static boolean isPalindrome(String str){
        String cleanStr = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int length = cleanStr.length();
        for (int i = 0; i < length / 2; i++) {
            if (cleanStr.charAt(i) != cleanStr.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }


}



