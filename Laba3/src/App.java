
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        
        int sentencesWithCommonWords = countSentencesWithDuplicates();
        System.out.println("Sentences with the common words: " + sentencesWithCommonWords);
    }

    private static int countSentencesWithDuplicates() {
        
        StringBuilder text = new StringBuilder("Text input input here. It can can contain multiple sentences.");
        List<StringBuilder> sentences = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
          char currentChar = text.charAt(i);
          if (currentChar == '.' || currentChar == '?' || currentChar == '!') {
                StringBuilder sentence = new StringBuilder(text.substring(start, i + 1));
                sentences.add(sentence);
                start = i + 1;
            }
        }

        int count = 0;

        for (StringBuilder sentence : sentences) {
            if (hasDuplicates(removeTrailingSpaces(sentence))) {
                count++;
            }
        }

        return count;
    }

    private static StringBuilder removeTrailingSpaces(StringBuilder input) {
        
        while (input.length() > 0 && Character.isWhitespace(input.charAt(input.length() - 1))) {
            input.deleteCharAt(input.length() - 1);
        }
        return input;
    }

    private static boolean hasDuplicates(StringBuilder sentence) {
        
        List<StringBuilder> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < sentence.length(); i++) {
          char currentChar = sentence.charAt(i);
          if (currentChar == ' ') {
                StringBuilder word = new StringBuilder(sentence.substring(start, i + 1));
                words.add(word);
                start = i + 1;
            }
        }

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (StringBuilder word : words) {
            String wordString = word.toString(); 
            wordCountMap.put(wordString, wordCountMap.getOrDefault(wordString, 0) + 1);
        }

        for (int count : wordCountMap.values()) {
            if (count > 1) {
                return true;
            }
        }

        return false;
    }
}
