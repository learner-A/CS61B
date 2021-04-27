import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testOffByOne() {
        Palindrome test = new Palindrome();

        assertTrue(test.isPalindrome("", offByOne));
        assertTrue(test.isPalindrome(" ", offByOne));
        assertTrue(test.isPalindrome("&%", offByOne));
        assertTrue(test.isPalindrome("%&", offByOne));
        assertTrue(test.isPalindrome("flake", offByOne));
        assertTrue(test.isPalindrome("ab", offByOne));
        assertTrue(test.isPalindrome("12", offByOne));
        assertTrue(test.isPalindrome("122", offByOne));


        assertFalse(test.isPalindrome("%!", offByOne));
        assertFalse(test.isPalindrome("racecar", offByOne));
        assertFalse(test.isPalindrome("za", offByOne));
        assertFalse(test.isPalindrome("zb", offByOne));
        assertFalse(test.isPalindrome("aB", offByOne));
        assertFalse(test.isPalindrome("KEEK", offByOne));
        assertFalse(test.isPalindrome("horse", offByOne));
        assertFalse(test.isPalindrome("aaaaaab", offByOne));
        assertFalse(test.isPalindrome("11", offByOne));
    }
}

