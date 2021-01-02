package ds_algo.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: nitinkumar
 * Created Date: 03/01/21
 * Info: Find minimum time required to rot all oranges. Oranges are in Matrix form. 0 means no orange, 1 means a fresh orange,
 * 2 means a rotten orange. It takes 1 unit of time to rot a fresh orange next to a rotten orange (in x or y direction but not diagonally)
 **/

public class TimeToRotOranges {
    public static void main(String[] args) {

        int[][] caret1OfOrange = {
                {0, 1, 1},
                {2, 1, 2},
                {1, 0, 1}
        };

        int[][] caret2OfOrange = {
                {0, 1, 0},
                {2, 0, 2},
                {1, 1, 1},
                {1, 1, 1},
        };

        int[][] caret3OfOrange = {
                {2, 1, 1},
                {0, 0, 1},
                {1, 1, 1},
                {1, 1, 1},
        };
        System.out.println(timeToRot(caret1OfOrange));
        System.out.println(timeToRot(caret2OfOrange));
        System.out.println(timeToRot(caret3OfOrange));

    }

    //Using BFS
    private static int timeToRot(int[][] caret) {
        Queue<Coordinate> queue = (Queue) new LinkedList<Integer>();
        int time = 0;
        //adding all rotten orange to queue
        for (int i = 0; i < caret.length; i++) {
            for (int j = 0; j < caret[0].length; j++) {
                if (caret[i][j] == 2) {
                    queue.add(new Coordinate(i, j));
                }
            }
        }
        queue.add(null); //added marker indicating end of a time interval
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            if (coordinate == null) {
                if (!queue.isEmpty()) {
                    time++;
                    queue.add(null);
                }
            } else {
                //System.out.println("\nChecking for rotting around: " + coordinate);

                //checking rotting of left coordinate
                int x = coordinate.x;
                int y = coordinate.y - 1;
                if (y >= 0 && caret[x][y] == 1) { //left wala fresh, make it rotten
                    caret[x][y] = 2;
                    queue.add(new Coordinate(x, y));
                }

                //checking rotting of right coordinate
                int x1 = coordinate.x;
                int y1 = coordinate.y + 1;
                if (y1 < caret[0].length && caret[x1][y1] == 1) { //right wala fresh, make it rotten
                    caret[x1][y1] = 2;
                    queue.add(new Coordinate(x1, y1));
                }
                //checking rotting of upper coordinate
                int x2 = coordinate.x - 1;
                int y2 = coordinate.y;
                if (x2 >= 0 && caret[x2][y2] == 1) { //right wala fresh, make it rotten
                    caret[x2][y2] = 2;
                    queue.add(new Coordinate(x2, y2));
                }
                //checking rotting of bottom coordinate
                int x3 = coordinate.x + 1;
                int y3 = coordinate.y;
                if (x3 < caret.length && caret[x3][y3] == 1) { //right wala fresh, make it rotten
                    caret[x3][y3] = 2;
                    queue.add(new Coordinate(x3, y3));
                }

            }
        }
        for (int i = 0; i < caret.length; i++) {
            for (int j = 0; j < caret[0].length; j++) {
                if (caret[i][j] == 1) {
                    //  System.out.println("Still alteast a fresh orange is left at " + i + " , " + j + " position");
                    return -1;
                }
            }
        }
        return time;
    }

}

class Coordinate {
    int x;

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/*
O/P:
2
-1
7
 */