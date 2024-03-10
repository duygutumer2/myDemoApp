package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.*;

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

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            java.util.ArrayList<String> wordsList1 = new java.util.ArrayList<>(); // Bu liste kullanıcıdan alınacak.
            java.util.ArrayList<String> wordsList2 = new java.util.ArrayList<>(); // Bu liste kullanıcıdan alınacak.

            while (sc1.hasNext()) {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s", ""));
                inputList.add(value);
            }

            String input2 = req.queryParams("input2");
            java.util.Scanner sc2 = new java.util.Scanner(input2);
            sc2.useDelimiter("[;\r\n]+");
            while (sc2.hasNext()) {
                String value = sc2.next().replaceAll("\\s","");
                wordsList1.add(value);
            }
            String input3 = req.queryParams("input3");
            java.util.Scanner sc3 = new java.util.Scanner(input3);
            sc3.useDelimiter("[;\r\n]+");
            while (sc3.hasNext()) {
                String value = sc3.next().replaceAll("\\s","");
                wordsList2.add(value);
            }

            String input4 = req.queryParams("input4");
            java.util.Scanner sc4 = new java.util.Scanner(input4);

            boolean agree = "true".equals(input4);
            int result = isArrayPalindrome(inputList, wordsList1, wordsList2, agree);

            Map<String, Object> map = new HashMap<>();
            map.put("result", result);
            map.put("inputList", inputList);
            map.put("wordsList1",wordsList1);
            map.put("wordsList2",wordsList2);
            map.put("process",agree);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());

        get("/compute", (rq, rs) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("result", "not computed yet!");
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());
    }
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}



