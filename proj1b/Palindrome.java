public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> d = new LinkedListDeque<>();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deq = new LinkedListDeque<>();
        deq = wordToDeque(word);
        int size = deq.size();
        while (!deq.isEmpty()) {
            if (deq.size() == 1) {
                break;
            }
            char pre = deq.removeFirst();
            char post = deq.removeLast();
            if (pre != post) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deq = new LinkedListDeque<>();
        deq = wordToDeque(word);
        while (!deq.isEmpty()) {
            if (deq.size() == 1) {
                break;
            }
            char pre = deq.removeFirst();
            char post = deq.removeLast();
            if (!cc.equalChars(pre, post)) {
                return false;
            }
        }
        return true;
    }
}