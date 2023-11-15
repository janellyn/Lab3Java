
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        
        int sentencesWithCommonWords = countSentencesWithDuplicates();
        System.out.println("Sentences with the common words: " + sentencesWithCommonWords);
    }

    private static int countSentencesWithDuplicates() {
        
        StringBuilder text = new StringBuilder("Text input here. It can can contain multiple sentences.");
        String[] sentences = text.toString().split("\\.");

        int count = 0;

        for (String sentence : sentences) {
            if (hasDuplicates(sentence.trim())) {
                count++;
            }
        }

        return count;
    }

    private static boolean hasDuplicates(String sentence) {
        String[] words = sentence.split("\\s+");

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        for (int count : wordCountMap.values()) {
            if (count > 1) {
                return true;
            }
        }

        return false;
    }
}
