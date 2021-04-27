import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
     */
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        Palindrome test = new Palindrome();
        String[] inputTrue = new String[]{"", " ", "k", "racecar", "KEK", "&&", "12321", "noon"};
        String[] inputFalse = new String[]{"CAT", "cat", "Cac", "#@", "123", "horse", "aaaaaaaaab", "rancor"};

        Deque<Character> testD;

        for (String i : inputTrue) {
            //testD = palindrome.wordToDeque(i);
            assertTrue(test.isPalindrome(i));
            //assertTrue(test.isPalindromeDeque(testD));
        }

        for (String i : inputFalse) {
            //testD = palindrome.wordToDeque(i);
            assertFalse(test.isPalindrome(i));
            //assertFalse(test.isPalindromeDeque(testD));
        }

        OffByN offBy1 = new OffByN(1);
        OffByOne offByone = new OffByOne();
        assertTrue(test.isPalindrome("", offBy1));
        assertTrue(test.isPalindrome("k", offBy1));
        assertTrue(test.isPalindrome("flake", offBy1));
        assertTrue(test.isPalindrome("abcb", offBy1));
        assertFalse(test.isPalindrome("aaaa", offBy1));
        assertFalse(test.isPalindrome("frake", offBy1));

        OffByN offBy5 = new OffByN(5);
        assertTrue(test.isPalindrome("achf", offBy5));
        assertFalse(test.isPalindrome("frake", offBy5));
    }
}

