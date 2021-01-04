package ds_algo.linkedList;

/**
 * Author: nitinkumar
 * Created Date: 17/12/20
 * Info: Single Linked List Class
 **/

public class LinkedList {
    Node head;

    public void add(int val) { //insert in the front of LL
        Node newNode = new Node(val, head);
        head = newNode;
    }

    public int remove() {
        int data = -1;
        if (head != null) {
            data = head.data;
            head = head.next;
        }
        return data;
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

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(" " + current.data);
            current = current.next;
        }
        System.out.println();
    }

    boolean isEmpty() {
        return head == null;
    }

    int getHeadNodeValue() {
        if (head == null) {
            return -1;
        } else {
            return head.data;
        }
    }

    void reverse() {
        if (head == null) {
            return;
        }
        Node head2 = null;
        while (head != null) {
            Node temp = new Node(head.data, null);
            if (head2 == null) {
                head2 = temp;
            } else {
                temp.next = head2;
                head2 = temp;
            }
            head = head.next;
        }
        head = head2;
    }
}

