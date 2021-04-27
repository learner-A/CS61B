import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testOffByOne() {
        Palindrome test = new Palindrome();
        assertTrue(test.isPalindrome("flake", offByOne));
        assertTrue(test.isPalindrome("ab", offByOne));
        assertFalse(test.isPalindrome("racecar", offByOne));
        assertFalse(test.isPalindrome("za", offByOne));
        assertFalse(test.isPalindrome("az", offByOne));
        assertTrue(test.isPalindrome("", offByOne));
        assertFalse(test.isPalindrome("keek", offByOne));
        assertFalse(test.isPalindrome("horse", offByOne));
        assertFalse(test.isPalindrome("aaaaaab", offByOne));
    }
}
