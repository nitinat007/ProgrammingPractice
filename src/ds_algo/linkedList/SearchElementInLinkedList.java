package ds_algo.linkedList;

/**
 * Author: nitinkumar
 * Created Date: 17/12/20
 * Info: Search an Element In a LinkedList
 **/

public class SearchElementInLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        linkedList.add(10);
        linkedList.add(11);
        linkedList.add(12);
        linkedList.add(13);
        linkedList.add(14);
        linkedList.print();
        linkedList.search(12);
        linkedList.search(13);
        linkedList.search(15);
    }
}

/*
O/P:
 14 13 12 11 10
12 Found
13 Found
15 Not found
 */

