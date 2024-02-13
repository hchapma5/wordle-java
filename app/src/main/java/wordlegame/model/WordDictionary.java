package wordlegame.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class WordDictionary {
    private List<String> words;

    public WordDictionary() {
        loadWordsIntoDictionary();
    }

    private void loadWordsIntoDictionary() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("game-words.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            words = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error reading word dictionary: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("Word dictionary file not found: " + e.getMessage());
        }
    }

    public String getRandomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    public boolean isValid(String word) {
        return words.contains(word.toLowerCase());
    }
}
