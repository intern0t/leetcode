import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreasureIslandII {

    static class Point {

        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return String.format("(%d, %d)", x, y);
        }
    }

    public static int getShortestTreasurePath(char map[][]) {
        HashMap<Point, List<Point>> path = new HashMap<>();
        HashMap<Point, Boolean> visited = new HashMap<>();
        Queue<Point> queue = new ArrayDeque<>();
        int directions[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } }; // Right, Down, Up, Left
        int steps = 1;

        // Add all available safe islands into our queue.
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == 'S') {
                    Point toAddPoint = new Point(row, col);
                    queue.add(toAddPoint);
                    visited.put(toAddPoint, true);
                    path.put(toAddPoint, new ArrayList<>());
                }
            }
        }

        // BFS Traversal through our matrix.
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Point current = queue.poll();

                for (int direction[] : directions) {
                    Point newPoint = new Point(
                        current.x + direction[0],
                        current.y + direction[1]
                    );

                    if (
                        newPoint.x >= 0 &&
                        newPoint.x < map.length &&
                        newPoint.y >= 0 &&
                        newPoint.y < map[0].length &&
                        map[newPoint.x][newPoint.y] != 'D' &&
                        map[newPoint.x][newPoint.y] != 'S' &&
                        (
                            !visited.containsKey(newPoint) ||
                            visited.get(newPoint) != true
                        )
                    ) {
                        // If the current is the treasure, return the cumulative steps.
                        if (map[newPoint.x][newPoint.y] == 'X') {
                            if (path.containsKey(current)) {
                                path.get(current).add(newPoint);
                            } else {
                                path.put(current, new ArrayList<>());
                                path.get(current).add(newPoint);
                            }
                            System.out.println(path);
                            return steps;
                        }
                        queue.add(newPoint);
                        visited.put(newPoint, true);
                        if (path.containsKey(current)) {
                            path.get(current).add(newPoint);
                        } else {
                            path.put(current, new ArrayList<>());
                            path.get(current).add(newPoint);
                        }
                    }
                }
            }
            ++steps;
        }
        return -1;
    }

    public static void main(String[] args) {
        char map[][] = {
            { 'S', 'O', 'O', 'S', 'S' },
            { 'D', 'O', 'D', 'O', 'D' },
            { 'O', 'O', 'O', 'O', 'X' },
            { 'X', 'D', 'D', 'O', 'O' },
            { 'X', 'D', 'D', 'D', 'O' },
        };

        System.out.println(
            String.format(
                "Expected = %d, Calculated = %d.",
                0,
                getShortestTreasurePath(map)
            )
        );
    }
}
/**
    You have a map that marks the locations of treasure islands. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in.
    There are other explorers trying to find the treasure. So you must figure out a shortest route to one of the treasure island.
    Assume the map area is a two dimensional grid, represented by a matrix of characters.
    You must start from one of the starting point(marked as 'S') of the map and can move one block up, down, left or right at a time.
    The treasure island is marked as ‘X’ in a block of the matrix.
    Any block with dangerous rocks or reefs will be marked as ‘D’. You must not enter dangerous blocks. You cannot leave the map area.
    Other areas ‘O’ are safe to sail in.
    Output the minimum number of steps to get to any of the treasure.

    e.g.
    Input
    [
    [‘S’, ‘O’, ‘O’, 'S', ‘S’],
    [‘D’, ‘O’, ‘D’, ‘O’, ‘D’],
    [‘O’, ‘O’, ‘O’, ‘O’, ‘X’],
    [‘X’, ‘D’, ‘D’, ‘O’, ‘O’],
    [‘X', ‘D’, ‘D’, ‘D’, ‘O’],
    ]

    Output
    3
    Explanation
You can start from (0,0), (0, 3) or (0, 4). The treasure locations are (2, 4) (3, 0) and (4, 0). Here the shortest route is (0, 3), (1, 3), (2, 3), (2, 4). 
 */
