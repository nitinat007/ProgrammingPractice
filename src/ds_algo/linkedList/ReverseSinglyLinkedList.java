package ds_algo.linkedList;

/**
 * Author: nitinkumar
 * Created Date: 03/01/21
 * Info: Reverse a linked List
 **/

public class ReverseSinglyLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(10);
        linkedList.add(11);
        linkedList.add(12);
        linkedList.add(13);
        linkedList.add(14);
        System.out.print("Original LL: ");
        linkedList.print();
        LinkedList linkedListReversed = reverseLL(linkedList);
        System.out.print("Reversed LL: ");
        linkedListReversed.print();
    }

    private static LinkedList reverseLL(LinkedList linkedList) {
        LinkedList linkedListReversed = new LinkedList();
        while (linkedList != null) {
            int dataAtFront = linkedList.remove();
            if (dataAtFront == -1)
                break;
            linkedListReversed.add(dataAtFront);
        }
        return linkedListReversed;
    }
}
/*
O/P:
Original LL:  14 13 12 11 10
Reversed LL:  10 11 12 13 14
 */