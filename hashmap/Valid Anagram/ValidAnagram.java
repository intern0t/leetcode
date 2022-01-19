import java.util.*;

class ValidAnagram {
    
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> mapped = new HashMap<>();
        
        for(char c : s.toCharArray()) {
            if(mapped.containsKey(c)) {
                mapped.put(c, mapped.get(c) + 1);
            }else {
                mapped.put(c, 1);
            }
        }
        
        for(char c : t.toCharArray()) {
            if(mapped.containsKey(c)) {
                mapped.put(c, mapped.get(c) - 1);
            }else {
                mapped.put(c, 1);
            }
        }
        
        for(char c : mapped.keySet()) {
            if(mapped.get(c) != 0) {
                // System.out.println(mapped.get(c) + " is not 0.");
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "anagram:nagaram",
            "rat:cat",
            "tat:att"
        };

        for(String s : testCases) {
            System.out.println(String.format("%s & %s is an anagram? => %s", s.split(":")[0], s.split(":")[1], isAnagram(s.split(":")[0], s.split(":")[1])));
        }
    }
}