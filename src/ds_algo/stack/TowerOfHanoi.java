package ds_algo.stack;

import java.util.Stack;

/**
 * Author: nitinkumar
 * Created Date: 21/01/21
 * Info: Given a stack of N tiles in increasing order of size from top to bottom on tower 1.
 * Move this to tower 3 such that tiles piled on tower 3 is also in ascending order of size from top to bottom. Also there is an auxiliary tower (tower 2) in between tower 1 and tower 2
 * |1|             |               |
 * | 2 |            |               |
 * |  3  |           |               |
 * |   4   |          |               |
 * -------------------------------------------
 * tower 1         tower 2         tower 3
 * (start)        (auxiliary)     (destination)
 * <p>
 * Approach 1: Recursion : Printing the tile movement
 * Each problem can be broken into three parts: Moving top N-1 tiles from start to auxiliary tower and then moving Nth tile from start to destination and finally Moving N-1 tiles (previously moved in auxiliary) to destination.
 * <p>
 * Approach2: Recursion : Maintaining stack for each tower. Object Oriented way. Logic is same as Approach 1.
 **/

public class TowerOfHanoi {
    public static void main(String[] args) {

        //Approach 1
        System.out.println("***** Approach 1 *****");
        towerOfHanoi(3, 1, 3, 2);

        //Approach2
        System.out.println("***** Approach 2 *****");
        Tower src = new Tower("source");
        Tower dest = new Tower("destination");
        Tower aux = new Tower("auxiliary");
        src.addTileOnTop(3);
        src.addTileOnTop(2);
        src.addTileOnTop(1);
        //System.out.println("Apply tower of hanoi " + src.getName() + " to " + dest.getName() + " via " + aux.getName());
        src.towerOfHanoi(src.sizeOfTower(), dest, aux);
        //dest.printStackTopToBottom(); Print destination tower
    }

    // Approach 1: O(n) time & space complexity
    private static void towerOfHanoi(int n, int startTower, int destinationTower, int auxiliaryTower) {
        if (n <= 0) {
            return;
        }
        towerOfHanoi(n - 1, startTower, auxiliaryTower, destinationTower); //Moving the top N-1 tiles from start to auxiliary
        System.out.println("Moving " + n + " no. tile from tower " + startTower + " to tower " + destinationTower); //Moving Only (biggest) tile from source to destination
        towerOfHanoi(n - 1, auxiliaryTower, destinationTower, startTower); //Moving the N-1 tiles of auxiliary to destination
    }

    //Approach2
    private static class Tower {
        String name;
        Stack<Integer> stack;

        Tower(String name) {
            this.name = name;
            this.stack = new Stack<>();
        }

        String getName() {
            return name;
        }

        void addTileOnTop(int x) {
            stack.add(x); //can put check if x is < stack peek.
        }

        int sizeOfTower() {
            return stack.size();
        }

        void moveTopTileToAnotherTowerTop(Tower dest) {
            int topTile = this.stack.pop();
            System.out.println("Moving " + topTile + " no. tile from " + getName() + " to " + dest.getName());
            dest.addTileOnTop(topTile);
        }

        void towerOfHanoi(int n, Tower dest, Tower aux) {
            if (n <= 0) {
                return;
            }
            towerOfHanoi(n - 1, aux, dest); //for n-1
//            System.out.println("Before size: " + this.getName() + " is " + this.sizeOfTower() + " and " + dest.getName() + "   is " + dest.sizeOfTower());
//            System.out.println("n is " + n);
            moveTopTileToAnotherTowerTop(dest);
            // System.out.println("After size: " + this.getName() + " is " + this.sizeOfTower() + " and " + dest.getName() + "   is " + dest.sizeOfTower() + " \n");
            aux.towerOfHanoi(n - 1, dest, this);
        }

        void printStackTopToBottom() {
            if (stack.isEmpty()) {
                return;
            }
            int topVal = stack.pop();
            System.out.println(topVal);
            printStackTopToBottom();
            stack.push(topVal);
        }

    }
}
/*
O/P:
***** Approach 1 *****
Moving 1 no. tile from tower 1 to tower 3
Moving 2 no. tile from tower 1 to tower 2
Moving 1 no. tile from tower 3 to tower 2
Moving 3 no. tile from tower 1 to tower 3
Moving 1 no. tile from tower 2 to tower 1
Moving 2 no. tile from tower 2 to tower 3
Moving 1 no. tile from tower 1 to tower 3
***** Approach 2 *****
Moving 1 no. tile from source to destination
Moving 2 no. tile from source to auxiliary
Moving 1 no. tile from destination to auxiliary
Moving 3 no. tile from source to destination
Moving 1 no. tile from auxiliary to source
Moving 2 no. tile from auxiliary to destination
Moving 1 no. tile from source to destination
 */