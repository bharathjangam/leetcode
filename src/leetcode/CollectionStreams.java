
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class CollectionStreams {
    public static void main(String[] ar) {

        //Stream.of()
        //List.of().stream()
        //IntStream.of()
        //mapToInt

        oddEvenNumbers();
        frequencyOfEachCharInString();
        sortTheListInReverseOrder();
        printMultipleOfFive();
        mergeTwoArrays();
        printTopThreeAndBottomThree();
        sortListOfStringInOrderByLength();
        sumOfAllElementsOfArray();
        removeDuplicateString();
        findMaxAndMinInList();
        findIfStringIsAnagram();
        findSecondLargestNumber();
        reverseEachStringOfList();
        reverseEachWordOfString();
    }

    private static void frequencyOfEachCharInString(){
        List charList = List.of("abcdcaffxeyzqwes".split(""));
        Map<String, Integer> frequencyMap = (Map<String, Integer>) charList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency of chars " +frequencyMap);
    }
    private static void oddEvenNumbers(){
        List<Integer> list = List.of(1,3,2,6,5,8,6,4,12,13,0,-4,-3);
        List evenNumbers = list.stream().filter(i->i%2==0).collect(Collectors.toList());
        List oddNumbers = list.stream().filter(i->i%2==1).collect(Collectors.toList());
        System.out.println("evenNumbers "+evenNumbers);
        System.out.println("oddNumbers "+oddNumbers);
    }

    private static void sortTheListInReverseOrder(){
        List elements = List.of(3,4,2,6,1,8,6,9);
        System.out.println("sortTheListInReverseOrder");
        System.out.println(elements.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }
    private static void printMultipleOfFive() {
        List<Integer> l = List.of(2,3,4,5,6,7);
        System.out.println(l.stream().map(i->i*5).collect(Collectors.toList()));
    }

    private static void mergeTwoArrays(){
        IntStream l1= IntStream.of(1,3,5,7,8);
        IntStream l2= IntStream.of(1,3,5,7,8);
        System.out.println("mergeTwoArrays-->");
        System.out.println(IntStream.concat(l1,l2).distinct().toArray());
    }

    private static void printTopThreeAndBottomThree(){
        List l = List.of(8,4,5,7,2,1,19,21,34,43);
        System.out.println(l.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList()));
        System.out.println(l.stream().sorted().limit(3).collect(Collectors.toList()));
    }
    private static void sortListOfStringInOrderByLength(){
        List l = List.of("abc", "dcef", "bc", "edfrgv");
        System.out.println(l.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList()));
    }
    private static void sumOfAllElementsOfArray(){
        IntStream l1= IntStream.of(3,5,6,7,2,9);
        IntStream l2= IntStream.of(3,5,6,7,2,9);
        System.out.println(l1.sum());
        System.out.println(l2.average());
    }

    private static void removeDuplicateString(){
        List l = List.of("ab","bc","cd","bc", "ef");
        System.out.println(l.stream().distinct().collect(Collectors.toList()));
    }

    private static void findMaxAndMinInList(){
        List l = List.of(3,4,6,8,7,9);
        System.out.println(l.stream().max(Comparator.naturalOrder()));
        System.out.println(l.stream().min(Comparator.naturalOrder()));
    }

    private static void findIfStringIsAnagram(){
        String s1 = "abcde";
        String s2 = "ecdab";
        String l3 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        String l4 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        System.out.println(l3);
        System.out.println(l4);
        System.out.println("Is Anagram " + l3.equals(l4));
    }

    private static void sumOfAllDigitsOfNumber(){
        String s = "3456732";
        Stream.of(s.split("")).collect(Collectors.summingInt(Integer::parseInt));
    }

    private static void findSecondLargestNumber(){
        List l = List.of(3,6,7,11,34,21,39,51);
        System.out.println(l.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());

    }
    private static void reverseEachStringOfList() {
        List<String> l = List.of("abc", "bca", "cbd", "efg", "xyzh");
        System.out.println(l.stream().map(s-> reverseString(s)).collect(Collectors.toList()));
    }
    private static void reverseEachWordOfString() {
        String s = "how to download file from linux server to local computer and vice versa on windows";
        System.out.println(Arrays.stream(s.split(" ")).map(t->new StringBuffer(t).reverse()).collect(Collectors.joining(" ")));
    }

    private static String reverseString(String str){
        StringBuilder nstr = new StringBuilder();
        for (int i=0; i<str.length(); i++)
        {
            char ch= str.charAt(i); //extracts each character
            nstr.insert(0, ch); //adds each character in front of the existing string
        }
        return nstr.toString();
    }
}
