package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testIsArrayPalindrome() {
       ArrayList<Integer> array = new ArrayList<>(Arrays.asList(3,4,5));
       ArrayList<String> words1 = new ArrayList<>(Arrays.asList("aba","hello","level","hanna"));
        ArrayList<String> words2 = new ArrayList<>(Arrays.asList("radar","world","stats"));
        boolean process = true;
        assertEquals(2,App.isArrayPalindrome(array,words1,words2,process));

    }
    public void testIsArrayNotPalindrome() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(3, 4, 5));
        ArrayList<String> words1 = new ArrayList<>(Arrays.asList("apple", "hello", "leve"));
        ArrayList<String> words2 = new ArrayList<>(Arrays.asList("banana", "world", "stat"));
        boolean process = true;

        int result = App.isArrayPalindrome(array, words1, words2, process);

        assertEquals(0, result);
    }
    public void testEmptyArrayList() {
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<String> words1 = new ArrayList<>();
        ArrayList<String> words2 = new ArrayList<>();
        boolean process = true;

        int result = App.isArrayPalindrome(array, words1, words2, process);

        assertEquals(0, result);
    }
    public void testProcessFalse() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(3, 4, 5));
        ArrayList<String> words1 = new ArrayList<>(Arrays.asList("aba", "hello", "level"));
        ArrayList<String> words2 = new ArrayList<>(Arrays.asList("radar", "world", "stats"));
        boolean process = false;

        int result = App.isArrayPalindrome(array, words1, words2, process);

        assertEquals(-1, result);
    }
    public void testIsCaseSensitive(){
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(3, 4, 5));
        ArrayList<String> words1 = new ArrayList<>(Arrays.asList("Aba", "ece", "level"));
        ArrayList<String> words2 = new ArrayList<>(Arrays.asList("radar", "world", "stats"));
        boolean process = true;

        int result = App.isArrayPalindrome(array, words1, words2, process);

        assertEquals(2, result);
    }
}
