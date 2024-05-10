package leetcode.easy;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TODO: Time Limit Exceeded
public class LongestSubstring {
    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        longestSubstring.test1();
        longestSubstring.test2();
        longestSubstring.test3();
        longestSubstring.test4();
        longestSubstring.test5();
        longestSubstring.test6();
        longestSubstring.test7();
    }


    public void test1(){
        String s = "abcabcbb";
        int result = longestSubstring(s);
        assert  3 == result;

    }
    public void test2(){
        String s = "bbbbbb";
        int result = longestSubstring(s);
        assert  1 == result;

    }
    public void test3(){
        String s = "pwwkew";
        int result = longestSubstring(s);
        assert  3 == result;

    }
    public void test4(){
        String s = "au";
        int result = longestSubstring(s);
        assert  2 == result;

    }
    public void test5(){
        String s = "dvdf";
        int result = longestSubstring(s);
        assert  3 == result;

    }
    public void test6(){
        String s = "biidygcc";
        int result = longestSubstring(s);
        assert  5 == result;

    }    public void test7(){
        String s = "raaaecthnvggteiysvcpwdausevrqrsjstjwxffkaltvrbulyyaudcqvglowdggxbpvzwalxogufhotioteryvoeicbn";
        int result = longestSubstring(s);
        assert  13 == result;

    }

    public int longestSubstring(String s){
        if(s.length() == 1 || s.length() == 0) return s.length();
        String[] chars = s.split("");
        Set<String> list = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            String s1 = s.substring(i,chars.length);
            int noDuplicate = (int) Stream.of(s1.split("")).distinct().count();
            if (s1.length() == noDuplicate ) {
//                System.out.println("S1-->" + s1);
                list.add(s1);
            }
            if(i<= chars.length-i) {
                String s2 = s.substring(i, chars.length - i);
                int noDuplicate2 = (int) Stream.of(s2.split("")).distinct().count();
                if (s2.length() == noDuplicate2 ) {
//                    System.out.println("S2-->" + s2);
                    list.add(s2);
                }
            }
            for (int j = 0; j <chars.length ; j++) {
                if(i<chars.length-j) {
                    String s3 = s.substring(i,chars.length-j);
                    int noDuplicate3 = (int) Stream.of(s3.split("")).distinct().count();
                    if (s3.length() == noDuplicate3 ) {
//                        System.out.println("S3-->" + s3);
                        list.add(s3);
                    }
                }
            }
        }
        AtomicReference<Integer> longest = new AtomicReference<>();
        longest.set(0);
        list.stream().forEach(i->
        {
            int noDuplicate = (int) Stream.of(i.split("")).distinct().count();
            if (i.length() == noDuplicate && noDuplicate > longest.get()) {
                longest.set(noDuplicate);
            }
        } );
        return longest.get();
    }

    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 1 || s.length() == 0) return s.length();
        StringBuilder  longest = new StringBuilder();
        Set<String> words = new HashSet<>();
        StringBuilder appender = new StringBuilder();
        longest.append(s.charAt(0));
        for(int i = 1; i<s.length();i++){
            if(! longest.toString().contains(String.valueOf(s.charAt(i)))){
                longest.append(s.charAt(i));
                if(i == s.length() -1){
                    words.add(longest.toString());
                }
            }
            else {
                words.add(longest.toString());
                longest = new StringBuilder();
                longest.append(s.charAt(i));}
        }
        return words.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList()).get(words.size()-1).length();

    }
}
