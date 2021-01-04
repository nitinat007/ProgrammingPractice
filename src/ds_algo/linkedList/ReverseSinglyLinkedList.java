package ds_algo.linkedList;

/**
 * Author: nitinkumar
 * Created Date: 03/01/21
 * Info: Reverse a linked List
 **/

public class ReverseSinglyLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(10);
        linkedList.push(11);
        linkedList.push(12);
        linkedList.push(13);
        linkedList.push(14);
        System.out.print("Original LL: ");
        linkedList.print();
        LinkedList linkedListReversed = reverseLL(linkedList);
        System.out.print("Reversed LL: ");
        linkedListReversed.print();
    }

    private static LinkedList reverseLL(LinkedList linkedList) {
        LinkedList linkedListReversed = new LinkedList();
        while (linkedList != null) {
            int dataAtFront = linkedList.pop();
            if (dataAtFront == -1)
                break;
            linkedListReversed.push(dataAtFront);
        }
        return linkedListReversed;
    }
}
/*
O/P:
Original LL:  14 13 12 11 10
Reversed LL:  10 11 12 13 14
 */