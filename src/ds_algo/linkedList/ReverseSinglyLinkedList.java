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
        linkedList.print();
        LinkedList linkedListReversed = reverseLL(linkedList);
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
