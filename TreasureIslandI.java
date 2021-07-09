import java.util.*;

public class TreasureIslandI {

    static class Point {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean isValidCoordinate(char map[][], Point p) {
        return (
                p.x >= 0 &&
                p.x < map.length &&
                p.y >= 0 &&
                p.y < map[0].length &&
                map[p.x][p.y] != 'D'
            )
            ? true
            : false;
    }

    public static int getPathToTreasure(char map[][]) {
        HashMap<String, Boolean> paths = new HashMap<>();
        Queue<Point> queue = new ArrayDeque<>();
        int totalSteps = 0;
        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        List<Point> route = new ArrayList<>();
        // Adds the start coordinate to the stack.
        queue.add(new Point(0, 0));
        paths.put("0|0", true);
        route.add(new Point(0, 0));
        totalSteps++;

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Point current = queue.poll();

                if (map[current.x][current.y] == 'X') {
                    return totalSteps;
                }

                for (int direction[] : directions) {
                    /**
                            0   1   2
                        0   O   O   O
                        1   O  [O]  O
                        2   O   O   O
                        -------------------
                        (0,0) = map[currentCoordinate[0] - 1][currentCoordinate[1] - 1]
                        (0,1) = map[currentCoordinate[0] - 1][currentCoordinate[1]]
                        (0,2) = map[currentCoordinate[0] - 1][currentCoordinate[1] + 1]
                        (1,0) = map[currentCoordinate[0]][currentCoordinate[1] - 1]
                        (1,1) = map[currentCoordinate[0]][currentCoordinate[1]] <-- Current
                        (1,2) = map[currentCoordinate[0]][currentCoordinate[1] + 1]
                        (2,0) = map[currentCoordinate[0] + 1][currentCoordinate[1] - 1]
                        (2,1) = map[currentCoordinate[0] + 1][currentCoordinate[1]]
                        (2,2) = map[currentCoordinate[0] + 1][currentCoordinate[1] + 1]
                    */
                    Point new_current = new Point(
                        current.x + direction[0],
                        current.y + direction[1]
                    );
                    String mapKey = new_current.x + "|" + new_current.y;
                    if (
                        isValidCoordinate(map, new_current) &&
                        (
                            !paths.containsKey(mapKey) ||
                            paths.get(mapKey) != true
                        )
                    ) {
                        queue.add(new_current);
                        paths.put(mapKey, true);
                        route.add(current);
                    }
                }
            }
            totalSteps++;
        }

        return 0;
    }

    public static void main(String[] args) {
        char map[][] = {
            { 'O', 'O', 'O', 'O' },
            { 'D', 'O', 'D', 'O' },
            { 'O', 'O', 'O', 'O' },
            { 'X', 'D', 'D', 'O' },
        };

        /**
         * D = Rocks, O = safe to sail, X = treasure
         */
        System.out.println(
            "Shortest path to treasure takes " +
            getPathToTreasure(map) +
            " steps."
        );
    }
}
/**
    You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in.
    There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.
    Assume the map area is a two dimensional grid, represented by a matrix of characters.
    You must start from the top-left corner of the map and can move one block up, down, left or right at a time.
    The treasure island is marked as ‘X’ in a block of the matrix. ‘X’ will not be at the top-left corner.
    Any block with dangerous rocks or reefs will be marked as ‘D’. You must not enter dangerous blocks. You cannot leave the map area.
    Other areas ‘O’ are safe to sail in. The top-left corner is always safe.
    Output the minimum number of steps to get to the treasure.

    e.g.
    Input
    [
    [‘O’, ‘O’, ‘O’, ‘O’],
    [‘D’, ‘O’, ‘D’, ‘O’],
    [‘O’, ‘O’, ‘O’, ‘O’],
    [‘X’, ‘D’, ‘D’, ‘O’],
    ]

    Output from aonecode.com
    Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps. 
 */
