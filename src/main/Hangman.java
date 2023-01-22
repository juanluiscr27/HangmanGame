package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Hangman {
    Set<String> usedWords = new HashSet<>();

    /**
     * @param word given word
     * @param alphabet given alphabet
     * @return the count of an alphabet in the word
     */
    public int countAlphabet(String word, char alphabet) {
        int result = 0;

        for (char c : word.toCharArray()) {
            if (c == alphabet) result++;
        }
        return result;
    }

    public String fetchWord() {
        return fetchWord(5);
    }

    public String fetchWord(int requestedLength) {
        String result = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("WordSource.txt"))) {
            while ((result = bufferedReader.readLine()) != null) {
                if (result.length() == requestedLength && usedWords.add(result)){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
