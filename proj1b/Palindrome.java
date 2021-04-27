public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> ans = new ArrayDeque<>();

        for (int i = 0; i < word.length(); i += 1) {
            ans.addLast(word.charAt(i));
        }

        return ans;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> input = wordToDeque(word);
        return isPalindromeDeque(input);
//        for (int i = 0; i < (word.length() / 2); i += 1) {
//            int j = word.length() - i - 1;
//            if (word.charAt(i) != word.charAt(j)) {
//                return false;
//            }
//        }
//        return true;
    }

    private boolean isPalindromeDeque(Deque<Character> dc) {
        for (int i = 0; i < (dc.size() / 2); i += 1) {
            if (dc.removeFirst() != dc.removeLast()) {
                return false;
            }
        }
        return true;
    }

//    public boolean isPalindromeDeque(Deque<Character> word) {
//        return isPalindrome(word);
//    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> input = wordToDeque(word);
        return isPalindromeDeque(input, cc);
    }

    private boolean isPalindromeDeque(Deque<Character> word, CharacterComparator cc) {
        for (int i = 0; i < (word.size() / 2); i += 1) {
            int j = word.size() - i - 1;
            if (!cc.equalChars(word.removeFirst(), word.removeLast()) && (i - j != 0)) {
                return false;
            }
        }
        return true;
    }
}

