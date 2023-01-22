package test;

import main.Hangman;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

        assertEquals(requestedLength, word.length());
    }

    void testUniquenessOfFetchedWord() {
        Random random = new Random();
        int requestedLength;
        String word;
        Set<String> usedWords = new HashSet<>();
        Hangman hangman = new Hangman();

        for (int round = 0; round < 100; round++) {
            requestedLength = random.nextInt(6) + 5;
            word = hangman.fetchWord(requestedLength);
            assertTrue(usedWords.add(word));
        }
    }
}