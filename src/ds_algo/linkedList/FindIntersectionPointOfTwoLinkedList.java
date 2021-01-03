package ds_algo.linkedList;

/**
 * Author: nitinkumar
 * Created Date: 03/01/21
 * Info: Find Intersection Point Of Two singly LinkedList
 **/

public class FindIntersectionPointOfTwoLinkedList {
    public static void main(String[] args) {

        SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList(null);
        Node nd1 = new Node(7, null);
        singlyLinkedList1.addNode(nd1);
        Node nd2 = new Node(10, null);
        singlyLinkedList1.addNode(nd2);
        singlyLinkedList1.addNode(new Node(12, null));
        singlyLinkedList1.addNode(new Node(15, null));

        SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList(null);
        singlyLinkedList2.addNode(nd1);
        singlyLinkedList2.addNode(nd2);
        singlyLinkedList2.addNode(new Node(11, null));
        singlyLinkedList2.addNode(new Node(16, null));
        singlyLinkedList2.addNode(new Node(18, null));
        singlyLinkedList2.addNode(new Node(19, null));
        System.out.print("List 1: ");
        singlyLinkedList1.printLL();
        System.out.print("List 2: ");
        singlyLinkedList2.printLL();
        Node intersectionNode = findIntersection(singlyLinkedList1, singlyLinkedList2);
        if(intersectionNode!=null)
        System.out.println("Intersection is at : " + intersectionNode.data);
        else
            System.out.println("No intersection found");
    }

    private static Node findIntersection(SinglyLinkedList singlyLinkedList1, SinglyLinkedList singlyLinkedList2) {
        int sizeOfLL1 = singlyLinkedList1.size();
        int sizeOfLL2 = singlyLinkedList2.size();
        Node tempPointerForLL1 = singlyLinkedList1.head;
        Node tempPointerForLL2 = singlyLinkedList2.head;
        if (sizeOfLL1 > sizeOfLL2) {
            for (int i = 0; i < sizeOfLL1 - sizeOfLL2; i++) {
                tempPointerForLL1 = tempPointerForLL1.next;
            }
        } else if (sizeOfLL2 > sizeOfLL1) {
            for (int i = 0; i < sizeOfLL2 - sizeOfLL1; i++) {
                tempPointerForLL2 = tempPointerForLL2.next;
            }
        }
        while (tempPointerForLL1 != null || tempPointerForLL2 != null) {
            if (tempPointerForLL1 == tempPointerForLL2) {
                return tempPointerForLL1;
            }
            tempPointerForLL1 = tempPointerForLL1.next;
            tempPointerForLL2 = tempPointerForLL2.next;
        }

        return null;
    }
}

class SinglyLinkedList {

    Node head;
    Node next;

    public SinglyLinkedList(Node head) {
        this.head = head;
        this.next = null;
    }

    void addNode(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    int size() {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

}

/*
O/P:
List 1: 15 12 10 7
List 2: 19 18 16 11 10 7
Intersection is at : 10
 */