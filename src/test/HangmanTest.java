package test;

import main.Hangman;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {
    @Test
    void test_alphabetCountInAWord(){
        String word = "pizza";
        char alphabet = 'a';

        Hangman hangman = new Hangman();

        int count = hangman.countAlphabet(word, alphabet);
        assertEquals(1, count);
    }

    @Test
    void test_lengthOfFetchedWord() {
        Hangman hangman = new Hangman();
        String word = hangman.fetchWord();

        assertTrue(word.length() == 5);
    }

    @Test
    void test_lengthOfFetchedWordRandom() {
        Random random = new Random();
        int requestedLength = random.nextInt(6) + 5;
        Hangman hangman = new Hangman();
        String word = hangman.fetchWord(requestedLength);

        assertEquals(requestedLength, word.length());
    }
}