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

        assertTrue(test.isPalindrome(""));
        assertTrue(test.isPalindrome(" "));
        assertTrue(test.isPalindrome("k"));
        assertTrue(test.isPalindrome("racecar"));
        assertTrue(test.isPalindrome("keek"));
        assertTrue(test.isPalindrome("KEEK"));
        assertTrue(test.isPalindrome("&&"));
        assertTrue(test.isPalindrome("12321"));
        assertTrue(test.isPalindrome("CaC"));

        assertFalse(test.isPalindrome("CAT"));
        assertFalse(test.isPalindrome("cat"));
        assertFalse(test.isPalindrome("Cac"));
        assertFalse(test.isPalindrome("ab"));
        assertFalse(test.isPalindrome("#@"));
        assertFalse(test.isPalindrome("az"));
        assertFalse(test.isPalindrome("123"));
        assertFalse(test.isPalindrome("horse"));
        assertFalse(test.isPalindrome("aaaaaaaaab"));
    }
}

