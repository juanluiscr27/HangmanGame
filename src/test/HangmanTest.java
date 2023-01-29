package test;

import main.Hangman;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {
    @Test
     void testAlphabetCountInAWord(){
        String word = "pizza";
        char alphabet = 'a';

        Hangman hangman = new Hangman();

        int count = hangman.countAlphabet(word, alphabet);
        assertEquals(1, count);
    }
    @Test
    void testLengthOfFetchedWord() {
        Hangman hangman = new Hangman();
        String word = hangman.fetchWord();

        assertTrue(word.length() == 5);
    }
    @Test
    void testLengthOfFetchedWordRandom() {
        Random random = new Random();
        int requestedLength = random.nextInt(6) + 5;
        Hangman hangman = new Hangman();
        String word = hangman.fetchWord(requestedLength);

        System.out.println(word);
        assertEquals(requestedLength, word.length());
    }
    @Test
    void testUniquenessOfFetchedWord() {
        Random random = new Random();
        int requestedLength = 0;
        Set<String> usedWordsSet = new HashSet<>();
        int round = 0;
        String word;
        Hangman hangman = new Hangman();

        while (round < 100) {
            requestedLength = random.nextInt(6) + 5;
            word = hangman.fetchWord(requestedLength);
            round++;
            assertTrue(usedWordsSet.add(word));
        }
    }
}