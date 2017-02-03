import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by SRIN on 2/2/2017.
 */
public class BinaryMazeBfs {
    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private class Node {
        Point point;
        int dist;
        Node next;

        public Node(Point point, int dist) {
            this.point = point;
            this.dist = dist;
        }
    }

    private Node head;
    private Node tail;
    private static int size;

    private void enqueue(Point point, int dist) {
        Node tmpNode = new Node(point, dist);
        if (isEmpty()) {
            head = tmpNode;
        } else {
            tail.next = tmpNode;
        }
        tail = tmpNode;
        size++;
    }

    private Node dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node data = head;
        if (tail == head) {
            tail = null;
        }
        head = head.next;
        size--;
        return data;
    }

    private boolean isEmpty() {
        return head == null;
    }

    private boolean isValid(int x, int y){
        if(x < width && x >=0 && y < height && y >=0){
            return true;
        }
        return false;
    }

    private boolean isSafe(int x, int y){
        if(map[x][y] != 0 && !visited[x][y]){
            return true;
        }
        return false;
    }

    private static int width;
    private static int height;
    private static int map[][];
    private static boolean visited[][];

    private static int startX;
    private static int startY;
    private static int finishX;
    private static int finishY;

    private static int minDistance = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryMazeBfs bm = new BinaryMazeBfs();
        height = sc.nextInt();
        width = sc.nextInt();
        map = new int[width][height];
        visited = new boolean[width][height];

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 2){
                    startX = i;
                    startY = j;
                }else if(map[i][j] == 3){
                    finishX = i;
                    finishY = j;
                }
            }
        }

        Point start = new Point(startX, startY);

        System.out.print(bm.doBfs(start));
    }

    private static int yNum[] = {-1, 1, 0 ,0 };
    private static int xNum[] = {0, 0, -1, 1};

    public int doBfs(Point start){
        BinaryMazeBfs q = new BinaryMazeBfs();

        visited[start.x][start.y] = true;
        int dist =0;
        q.enqueue(start, dist);

        while(!q.isEmpty()){
            Node currNode = q.dequeue();
            Point pt = currNode.point;
            dist = currNode.dist;

            if(pt.x == finishX && pt.y == finishY){
                if(currNode.dist < minDistance){
                    minDistance = currNode.dist;
                    continue;
                }
            }

            if(dist > minDistance){
                continue;
            }

            for(int i =0; i < 4; i++){
                if( isValid(pt.x + xNum[i], pt.y+ yNum[i]) && isSafe(pt.x + xNum[i], pt.y+ yNum[i])){
                    Point newPt = new Point(pt.x + xNum[i],pt.y+ yNum[i] );
                    q.enqueue(newPt, dist+1 );
                    visited[newPt.x][newPt.y] = true;
                }
            }
        }


        return minDistance;
    }
}
