package ds.linkedList;

/**
 * Author: nitinkumar
 * Created Date: 17/12/20
 * Info: Single Linked List Class
 **/

public class LinkedList {
    Node head;

    public void push(int val) { //insert in the front of LL
        Node newNode = new Node(val, head);
        head = newNode;
    }

    public void search(int toSearch) {
        Node current = head;
        while (current != null) {
            if (current.data == toSearch) {
                System.out.println(toSearch + " Found");
                return;
            }
            current = current.next;
        }
        System.out.println(toSearch + " Not found");
    }

    public void print(){
        Node current = head;
        while (current != null) {
            System.out.print(" "+current.data);
            current = current.next;
        }
        System.out.println();
    }
}

