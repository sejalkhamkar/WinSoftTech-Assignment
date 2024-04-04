import java.util.HashMap;
import java.util.Map;

public class WordCount {
    
    public static Map<String, Integer> countWords(String str) {
        // Remove leading and trailing spaces and split the string into words
        String[] words = str.trim().split("\\s+");
        
        // Create a HashMap to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();
        
        // Iterate through the words array and update word counts in the map
        for (String word : words) {
            // Convert word to lowercase to handle case-insensitivity
            word = word.toLowerCase();
            
            // If the word is already present in the map, increment its count
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                // Otherwise, add the word to the map with count 1
                wordCountMap.put(word, 1);
            }
        }
        
        return wordCountMap;
    }

    public static void main(String[] args) {
        String str = "Java is a programming language. Java is used for web development and mobile applications.";
        
        // Count words in the string
        Map<String, Integer> wordCountMap = countWords(str);
        
        // Print the word count map
        System.out.println("Word Count:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
