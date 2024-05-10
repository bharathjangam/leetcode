package au.com.ing.microservice.creditaggregator;

import java.util.*;
import java.util.stream.Collectors;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 */
public class ValidParentheses {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }

    private static void test1() {
        String s = "()";
        assert isValid(s);
    }

    private static void test2() {
        String s = "()[]{}";
        assert isValid(s);
    }

    private static void test3() {
        String s = "(]";
        assert !isValid(s);
    }

    private static void test4() {
        String s = "([)]";
        assert !isValid(s);
    }
    private static void test5() {
        String s = "{[]}";
        assert isValid(s);
    }
    private static void test6() {
        String s = "[";
        assert !isValid(s);
    }
    private static void test7() {
        String s = ")(){}";
        assert !isValid(s);
    }

    public static boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '[' || c=='{'){
                deque.addFirst(c);
            }
            else {
                if(!deque.isEmpty() && (
                                (deque.peekFirst() == '(' && c == ')') ||
                                (deque.peekFirst() == '[' && c == ']' )||
                                 (deque.peekFirst() == '{' && c == '}' )
                        )){
                    deque.removeFirst();
                }else {
                    return false;
                }
            }
        }
        return deque.isEmpty();
        /*List<String> givenStringList = List.of(s.split(""));
        List<String> openBrackets = List.of("(", "[", "{");
        List<String> closeBrackets = List.of(")", "]", "}");

        List<String> orderOfOpenBrackets = new ArrayList<>();
        List<String> orderOfClosedBrackets = new ArrayList<>();
        for(String givenString: givenStringList){
            int indexOfLastOpenBracket = openBrackets.
        }*/
       /* for(String givenOpenBracket:givenStringList){
            if(openBrackets.indexOf(givenOpenBracket) != -1){
                orderOfOpenBrackets.add(givenOpenBracket);
            }
        }
        for(String givenClosedBracket:givenStringList){
            if(closeBrackets.indexOf(givenClosedBracket) != -1){
                orderOfClosedBrackets.add(givenClosedBracket);
            }
        }
        System.out.println("Given Open Bracket"+ orderOfOpenBrackets);
        System.out.println("Given Closed Bracket"+ orderOfClosedBrackets);
        Collections.reverse(orderOfOpenBrackets);
        System.out.println("Given Open Bracket After reverse"+ orderOfOpenBrackets);
        if(orderOfOpenBrackets.size() != orderOfClosedBrackets.size()) {
            return false;
        }
//        for(int i=0; i <orderOfOpenBrackets.size(); i++){
//
//        }
        for(int i=0; i< orderOfOpenBrackets.size(); i++){
            int x = openBrackets.indexOf(orderOfOpenBrackets.get(i));
            int y = closeBrackets.indexOf(orderOfClosedBrackets.get(i));
            if( x!=y ){
                return false;
            }
        }*/
        /*for(String givenOpenBracket: orderOfOpenBrackets){
            int i = openBrackets.indexOf(givenOpenBracket);
            int j = closeBrackets.indexOf(orderOfClosedBrackets.get(i));
            if( i!=j ){
                return false;
            }
        }*/
//        Queue<String> queue = new LinkedList(orderOfOpenBrackets);
/*        List<String> reversedOrderOfOpenBrackets =  queue.stream().collect(Collectors.toList());*/
/*        if(orderOfOpenBrackets.size() != orderOfClosedBrackets.size()){
            return  false;
        }*/

        /*for (int i = 0; i < openBrackets.size(); i++) {
            boolean isOpenBracketContains = givenStringList.contains(openBrackets.get(i));
            boolean isClosedBracketContains = givenStringList.contains(closeBrackets.get(i));
            int closedIndex = givenStringList.indexOf(closeBrackets.get(i));
            int openIndex = givenStringList.indexOf(openBrackets.get(i));
            if (isOpenBracketContains) {
                if (!isClosedBracketContains || closedIndex < 1) {
                    return false;
                }
                if (!((openIndex + 1) == closedIndex)) {
                    return false;
                }

            }
        }*/
//        return true;

    }
    private static void reverseList(List<String> source){
        Queue queue = new LinkedList(source);
        queue.stream().collect(Collectors.toList());
        System.out.println();
    }
}
