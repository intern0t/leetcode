package hashmap;

import java.util.*;

public class FavoriteGenres {

    public static Map<String, List<String>> getFavoriteGenres(
        Map<String, List<String>> userMap,
        Map<String, List<String>> genreMap
    ) {
        Map<String, List<String>> favorites = new HashMap<>();
        Map<String, Integer> genres = new HashMap<>();

        for (String user : userMap.keySet()) {
            favorites.put(user, new ArrayList<>());

            // Set up genre count map.
            for (String genreKey : genreMap.keySet()) {
                genres.put(genreKey, 0);
            }

            // Do the actual counting.
            for (String genreKey : genreMap.keySet()) {
                for (String song : userMap.get(user)) {
                    if (genreMap.get(genreKey).contains(song)) {
                        // ~O(n^4) = because of contains.
                        genres.put(genreKey, genres.get(genreKey) + 1);
                    }
                }
            }

            // Add to the favorites.
            int max = (int) genres.values().toArray()[0];
            for (String key : genres.keySet()) {
                if (max < genres.get(key)) {
                    max = genres.get(key);
                    favorites.get(user).set(0, key);
                } else if (max == genres.get(key)) {
                    favorites.get(user).add(key);
                }
            }
        }

        // Complexity flew right out the flippin' window!
        return favorites;
    }

    public static void main(String[] args) {
        Map<String, List<String>> userMap = new HashMap<>();
        Map<String, List<String>> genreMap = new HashMap<>();
        userMap.put("David", new ArrayList<>());
        userMap.put("Emma", new ArrayList<>());
        userMap
            .get("David")
            .addAll(Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userMap.get("Emma").addAll(Arrays.asList("song5", "song6", "song7"));

        genreMap.put("Rock", new ArrayList<>());
        genreMap.put("Dubstep", new ArrayList<>());
        genreMap.put("Techno", new ArrayList<>());
        genreMap.put("Pop", new ArrayList<>());
        genreMap.put("Jazz", new ArrayList<>());
        genreMap.get("Rock").addAll(Arrays.asList("song1", "song3"));
        genreMap.get("Dubstep").addAll(Arrays.asList("song7"));
        genreMap.get("Techno").addAll(Arrays.asList("song2", "song4"));
        genreMap.get("Pop").addAll(Arrays.asList("song5", "song6"));
        genreMap.get("Jazz").addAll(Arrays.asList("song8", "song9"));

        // Output.
        System.out.println(getFavoriteGenres(userMap, genreMap));
    }
}
/**
    Given a map Map<String, List<String>> userMap, where the key is a username and the value is a list of user's songs. Also given a map Map<String, List<String>> genreMap, where the key is a genre and the value is a list of songs belonging to this genre. The task is to return a map Map<String, List<String>>, where the key is a username and the value is a list of the user's favorite genres. Favorite genre is a genre with the most song.

    Example :
    Input:

    userMap = {
        "David": ["song1", "song2", "song3", "song4", "song8"],
        "Emma":  ["song5", "song6", "song7"]
    },
    genreMap = {
        "Rock":    ["song1", "song3"],
        "Dubstep": ["song7"],
        "Techno":  ["song2", "song4"],
        "Pop":     ["song5", "song6"],
        "Jazz":    ["song8", "song9"]
    }

    Output:

    {
        "David": ["Rock", "Techno"],
        "Emma":  ["Pop"]
    }

    Explanation:
    David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
    Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
 */
