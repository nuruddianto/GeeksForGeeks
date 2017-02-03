/**
 * Created by SRIN on 1/31/2017.
 */

import java.util.*;

public class BinaryMaze {
    private static int width;
    private static int height;

    private static int minDistance = 10000;
    private static int map[][];
    private static boolean visited[][];
    private static int yNum[] = {-1, 1, 0, 0};
    private static int xNum[] = {0, 0, -1, 1};

    private static int startX;
    private static int startY;
    private static int finishX;
    private static int finishY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();

        map = new int[width + 1][height + 1];
        visited = new boolean[width + 1][height + 1];
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                } else if (map[i][j] == 3) {
                    finishX = i;
                    finishY = j;
                }
            }
        }

        markUnsafeMap();
        findShortestPath(startX, startY, 0);
        for(int j=0; j < height; j++){
            for(int i =0; i < width; i++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(minDistance);

    }

    private static boolean isValid(int x, int y) {
        if (x < width && x >= 0 && y < height && y >= 0) {
            return true;
        }
        return false;
    }

    private static boolean isSafe(int x, int y) {
        if ((map[x][y] == 1 || map[x][y] == 3 || map[x][y] == 2) && !visited[x][y] && map[x][y] != 4) {
            return true;
        }
        return false;
    }


    private static void markUnsafeMap() {
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                if (map[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        if (isValid(i + xNum[k], j + yNum[k]) && isSafe(i + xNum[k], j + yNum[k]) && map[i + xNum[k]][j + yNum[k]] != 3) {
                            map[i + xNum[k]][j + yNum[k]] = 4;
                        }
                    }
                }
            }
        }
    }

    private static void findShortestPath(int x, int y, int distance) {
        if (x == finishX && y == finishY) {
            if(distance < minDistance){
                minDistance = distance;
            }
            return;
        }

        if (distance > minDistance) {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            if (isValid(x + xNum[i], y + yNum[i]) && isSafe(x + xNum[i], y + yNum[i])) {
                findShortestPath(x + xNum[i], y + yNum[i], distance+1);
            }
        }

        visited[x][y] = false;
    }
}

/*Data
12 10
1  1  1  1  2  1  1  1  1  1
1  0  1  1  1  1  1  1  1  1
1  1  1  0  1  1  1  1  1  1
1  1  1  1  0  1  1  1  1  1
1  1  1  1  1  1  1  1  1  1
1  1  1  1  1  0  1  1  1  1
1  0  1  1  1  1  1  1  1  1
1  1  1  1  1  1  1  1  1  1
1  1  1  1  1  1  1  1  1  1
0  1  1  1  1  0  1  1  1  1
1  1  1  1  1  1  1  1  1  1
1  1  1  0  1  1  1  1  1  3
 */