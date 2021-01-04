package ds_algo.linkedList;

/**
 * Author: nitinkumar
 * Created Date: 04/01/21
 * Info: Merge two sorted linked list into one
 **/

public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {

        LinkedList ll1 = new LinkedList();
        ll1.add(10);
        ll1.add(8);
        ll1.add(6);
        ll1.add(4);
        ll1.add(2);

        LinkedList ll2 = new LinkedList();
        ll2.add(9);
        ll2.add(7);
        ll2.add(5);
        ll2.add(3);
        ll2.add(1);

        ll1.print();
        ll2.print();

        LinkedList ll3 = mergeLL(ll1, ll2);
        ll3.print();

    }

    public static LinkedList mergeLL(LinkedList ll1, LinkedList ll2) {
        LinkedList ll3 = new LinkedList();
        while (!ll1.isEmpty() && !ll2.isEmpty()) {
            int ll1Top = ll1.getHeadNodeValue();
            int ll2Top = ll2.getHeadNodeValue();
            if (ll1Top < ll2Top) {
                ll3.add(ll1Top);
                ll1.remove();
            } else {
                ll3.add(ll2Top);
                ll2.remove();
            }
        }
        if (!ll1.isEmpty()) {
            ll3.add(ll1.remove());
        } else if (!ll2.isEmpty()) {
            ll3.add(ll2.remove());
        }
        ll3.reverse(); //as it is in reverse order
        return ll3;
    }
}
/*
O/P:
 2 4 6 8 10
 1 3 5 7 9
 1 2 3 4 5 6 7 8 9 10
 */
