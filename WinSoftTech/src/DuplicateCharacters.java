import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacters {
    
    public static void findDuplicateCharacters(String str) {
        // Create a HashMap to store character frequencies
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        
        // Convert the string to lowercase to handle case-insensitivity
        str = str.toLowerCase();
        
        // Iterate through the string and update character frequencies in the map
        for (char ch : str.toCharArray()) {
            // Skip non-alphabetic characters
            if (Character.isLetter(ch)) {
                if (charFrequencyMap.containsKey(ch)) {
                    // If the character is already present in the map, increment its count
                    charFrequencyMap.put(ch, charFrequencyMap.get(ch) + 1);
                } else {
                    // Otherwise, add the character to the map with count 1
                    charFrequencyMap.put(ch, 1);
                }
            }
        }
        
        // Print duplicate characters
        System.out.println("Duplicate characters in the string:");
        for (Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
            }
        }
    }

    public static void main(String[] args) {
        String str = "Hello World, welcome to my code..";
        
        findDuplicateCharacters(str);
    }
}
