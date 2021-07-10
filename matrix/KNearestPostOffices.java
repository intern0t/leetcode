package matrix;
import java.util.*;

public class KNearestPostOffices {

    static class Coordinate {

        int x, y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return String.format("(%d, %d)", x, y);
        }
    }

    public static Double euclideanDistance(Coordinate one, Coordinate two) {
        return Math.sqrt(
            Math.pow(two.x - one.x, 2) + Math.pow(two.y - one.y, 2)
        );
    }

    public static void kNearestPostOffices(
        int postOffices[][],
        int person[],
        int k
    ) {
        HashMap<Double, Coordinate> distance = new HashMap<>();
        List<Coordinate> kNearestPostOffices = new ArrayList<>();
        Coordinate person_coord = new Coordinate(person[0], person[1]);

        // Calculates and adds the distance from person to post-office coordinate to the hash map.
        for (int postOffice[] : postOffices) {
            Coordinate postOffice_coord = new Coordinate(
                postOffice[0],
                postOffice[1]
            );
            distance.put(
                euclideanDistance(person_coord, postOffice_coord),
                postOffice_coord
            );
        }

        // Grab the keys and sort.
        Object keySet[] = distance.keySet().toArray();
        Arrays.sort(keySet);

        // Get the k nearest.
        for (int i = 0; i < k; i++) {
            if (distance.containsKey(keySet[i])) {
                kNearestPostOffices.add(distance.get(keySet[i]));
            }
        }
        System.out.println(
            String.format(
                "%d nearest Post offices from %s are => %s.",
                k,
                person_coord,
                kNearestPostOffices
            )
        );
    }

    public static void main(String[] args) {
        int postOfficeCoordinates[][] = {
            { -16, 5 },
            { -1, 2 },
            { 4, 3 },
            { 10, -2 },
            { 0, 3 },
            { -5, -9 },
        };
        int personCoordinate[] = { 0, 0 };
        int k = 3;

        // Print k nearest post offices.
        kNearestPostOffices(postOfficeCoordinates, personCoordinate, k);
    }
}
/**
    Find the k post offices located closest to you, given your location and a list of locations of all post offices available.
    Locations are given in 2D coordinates in [X, Y], where X and Y are integers.
    Euclidean distance is applied to find the distance between you and a post office.
    Assume your location is [m, n] and the location of a post office is [p, q], the Euclidean distance between the office and you is SquareRoot((m - p) * (m - p) + (n - q) * (n - q)).
    K is a positive integer much smaller than the given number of post offices. from aonecode.com

    e.g.
    Input
    you: [0, 0]
    post_offices: [[-16, 5], [-1, 2], [4, 3], [10, -2], [0, 3], [-5, -9]]
    k = 3

    Output from aonecode.com
    [[-1, 2], [0, 3], [4, 3]] 
 */
