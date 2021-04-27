public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> ans = new ArrayDeque<>();

        for (int i = 0; i < word.length(); i += 1) {
            ans.addLast(word.charAt(i));
        }

        return ans;
    }

    public boolean isPalindrome(String word) {
        for (int i = 0; i < (word.length() / 2); i += 1) {
            int j = word.length() - i - 1;
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(Deque<Character> word) {
        for (int i = 0; i < (word.size() / 2); i += 1) {
            if (word.removeFirst() != word.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        for (int i = 0; i < (word.length() / 2); i += 1) {
            int j = word.length() - i - 1;
            if (!cc.equalChars(word.charAt(i), word.charAt(j)) && (i - j != 0)) {
                return false;
            }
        }
        return true;
    }
}

