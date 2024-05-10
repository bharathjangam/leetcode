package leetcode.easy;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class AddTwoNumber {
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test1() {
        int[] l1 = new int[]{2, 4, 3};
        int[] l2 = new int[]{5, 6, 4};
        ListNode listNode1 = new AddTwoNumber().populateListNode(l1);
        ListNode listNode2 = new AddTwoNumber().populateListNode(l2);
        new AddTwoNumber().addTwoNumbers(listNode1, listNode2);

    }

    private static void test2() {
        int[] l1 = new int[]{0};
        int[] l2 = new int[]{0};
        ListNode listNode1 = new AddTwoNumber().populateListNode(l1);
        ListNode listNode2 = new AddTwoNumber().populateListNode(l2);
        new AddTwoNumber().addTwoNumbers(listNode1, listNode2);

    }

    private static void test3(){
        int[] l1 = new int[]{9,9,9,9,9,9,9};
        int[] l2 = new int[]{9,9,9,9};
        ListNode listNode1 = new AddTwoNumber().populateListNode(l1);
        ListNode listNode2 = new AddTwoNumber().populateListNode(l2);
        new AddTwoNumber().addTwoNumbers(listNode1, listNode2);

    }
    //todo: not implemented below testcase
private static void test4(){
        int[] l1 = new int[]{2,4,9};
        int[] l2 = new int[]{5,6,4,9};
        ListNode listNode1 = new AddTwoNumber().populateListNode(l1);
        ListNode listNode2 = new AddTwoNumber().populateListNode(l2);
        new AddTwoNumber().addTwoNumbers(listNode1, listNode2);
        // expected: [7,0,4,0,1]
        //actual : [7,0,4,1]
    }

    private ListNode populateListNode(int[] l) {
        AtomicReference<ListNode> listNode1LastNode = new AtomicReference<>();
        ListNode listNode1 = new ListNode();
        ;

        AtomicReference<ListNode> ln1 = new AtomicReference<>();

        for (int i = 0; i < l.length; i++) {
            ListNode listNode = new ListNode();
            if (null == listNode1.next) {
                listNode1.val = l[i];
                if (i < l.length - 1) {
                    listNode1.next = listNode;
                }
                listNode1LastNode.set(listNode);
            } else {
                listNode1LastNode.get().val = l[i];
                if (i < l.length - 1)
                    listNode1LastNode.get().next = listNode;
                listNode1LastNode.set(listNode);
            }


        }


        /*IntStream.of(l).forEach(i -> {
            ListNode lnNext = null;
            ln1.get()val = i;
                });
        IntStream.of(l).forEach(i -> {
            ListNode listNode = new ListNode();
            if (null == listNode1.next) {
                listNode1.val = i;
                listNode1.next = listNode;
                listNode1LastNode.set(listNode);
            } else {
                listNode1LastNode.get().val = i;
                listNode1LastNode.get().next = listNode;
                listNode1LastNode.set(listNode);
            }

        });
*/
        return listNode1;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tensDigit = 0;
        int sum = 0;
        ListNode currentNodeOfL1 = l1;
        ListNode currentNodeOfL2 = l2;
        StringBuilder builder = new StringBuilder();
        int i = 0, j = 0;
        boolean exitFromWhileLoop = false;
        boolean exitFromWhileLoop2 = false;
        int loop2Val = 0;
        while (true) {
            if (exitFromWhileLoop) {
                if(tensDigit > 0) builder.append(tensDigit);
                break;
            }
            if (currentNodeOfL1.next == null) {
                exitFromWhileLoop = true;
            }
            System.out.println(currentNodeOfL1.val);
            while (true) {
                if (exitFromWhileLoop2) {
                    exitFromWhileLoop2 = false;
                    break;
                }
                if (currentNodeOfL2.next == null) {
                    exitFromWhileLoop2 = true;
                }
                if (i == j) {
                    loop2Val = currentNodeOfL2.val;
                    break;
                    /*int s = currentNodeOfL1.val + currentNodeOfL2.val + tensDigit;
                    tensDigit = 0;
                    if (s >= 10) {
                        tensDigit = s / 10;
                        s = s % 10;
                    }
                    builder.append(s);*/
                }
                currentNodeOfL2 = currentNodeOfL2.next;
                j++;
            }

            int s = currentNodeOfL1.val + loop2Val + tensDigit;
            loop2Val = 0;
            tensDigit = 0;
            if (s >= 10) {
                tensDigit = s / 10;
                s = s % 10;
            }
            builder.append(s);

            currentNodeOfL1 = currentNodeOfL1.next;
            currentNodeOfL2 = l2;
            i++;
            j = 0;

        }
        System.out.println("Result-->" + builder);
        return populateListNode(builder.toString().split(""));
    }

    private ListNode populateListNode(String[] l) {
        AtomicReference<ListNode> listNode1LastNode = new AtomicReference<>();
        ListNode listNode1 = new ListNode();
        int i;
        if (l.length == 1 && "".equals(l[0])) return listNode1;
        for (int r = 0; r < l.length; r++) {
            i = Integer.parseInt(l[r]);
            ListNode listNode = new ListNode();
            if (null == listNode1.next) {
                listNode1.val = i;
                if (r < l.length - 1)
                listNode1.next = listNode;
                listNode1LastNode.set(listNode);
            } else {
                listNode1LastNode.get().val = i;
                if (r < l.length - 1)
                    listNode1LastNode.get().next = listNode;
                listNode1LastNode.set(listNode);
            }

        }
        return listNode1;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}