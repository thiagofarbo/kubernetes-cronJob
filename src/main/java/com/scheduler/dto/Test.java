package com.scheduler.dto;

//Suppose if all the alphabets are assigned values 1 to 26, like a=1, b=2, c=3, …………. z= 26,
//Input an alphanumeric string and calculate the sum of that string?
//
//Example:
//Input: Hello123
//Output: 58
//
//Explanation:
//        (Where h=8, e=5, l=12, l=12, o=15)


import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().sum("Hello123"));
    }

    public Integer sum(String word){

        Integer result = 0;

        final char[] charArray = word.toCharArray();

        for(int i = 0; i< charArray.length; i++){

            final String lowerCaseValue = String.valueOf(charArray[i]).toLowerCase();

            final String character = getMapValues().get(lowerCaseValue);

            if(character != null){
                result += Integer.valueOf(character);
            }else {
                result += Integer.valueOf(lowerCaseValue);
            }
        }
        return result;
    }

    public  Map<String, String>  getMapValues(){

        Map<String, String> values = new HashMap<>();
        values.put("a", "1");
        values.put("b", "2");
        values.put("c", "3");
        values.put("d", "4");
        values.put("e", "5");
        values.put("f", "6");
        values.put("g", "7");
        values.put("h", "8");
        values.put("i", "9");
        values.put("j", "10");
        values.put("k", "11");
        values.put("l", "12");
        values.put("m", "13");
        values.put("n", "14");
        values.put("o", "15");
        values.put("p", "16");
        values.put("q", "17");
        values.put("r", "18");
        values.put("s", "19");
        values.put("t", "20");
        values.put("u", "21");
        values.put("v", "22");
        values.put("x", "23");
        values.put("y", "24");
        values.put("z", "25");

        return values;

    }
}
