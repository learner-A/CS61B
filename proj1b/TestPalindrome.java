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
        String[] inputTrue = new String[]{"", " ", "k", "racecar", "KEK", "&&", "12321"};
        String[] inputFalse = new String[]{"CAT", "cat", "Cac", "#@", "123", "horse", "aaaaaaaaab"};

        Deque<Character> testD;

        for (String i : inputTrue) {
            testD = palindrome.wordToDeque(i);
            assertTrue(test.isPalindrome(i));
            //assertTrue(test.isPalindrome(testD));
        }

        for (String i : inputFalse) {
            testD = palindrome.wordToDeque(i);
            assertFalse(test.isPalindrome(i));
            //assertFalse(test.isPalindrome(testD));
        }

        OffByN offBy2 = new OffByN(2);
        assertTrue(test.isPalindrome("acec", offBy2));
        assertFalse(test.isPalindrome("achf", offBy2));

        OffByN offBy5 = new OffByN(5);
        assertTrue(test.isPalindrome("achf", offBy5));
        assertFalse(test.isPalindrome("acec", offBy5));
    }
}

