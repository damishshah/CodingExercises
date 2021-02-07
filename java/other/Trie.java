public class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode currentLevel = root;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            int index = current - 'a';
            if (currentLevel.childArray[index] == null) {
                currentLevel.childArray[index] = new TrieNode(current);
            }
            currentLevel = currentLevel.childArray[index];
        }

        currentLevel.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode currentLevel = root;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            int index = current - 'a';
            if (currentLevel.childArray[index] == null) {
                return false;
            }
            currentLevel = currentLevel.childArray[index];
        }

        return currentLevel.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode currentLevel = root;
        for (int i = 0; i < prefix.length(); i++) {
            char current = prefix.charAt(i);
            int index = current - 'a';
            if (currentLevel.childArray[index] == null) {
                return false;
            }
            currentLevel = currentLevel.childArray[index];
        }

        return true;
    }

    private class TrieNode {
        char val;
        boolean isEnd;
        TrieNode[] childArray;

        TrieNode() {
        }

        TrieNode(char x) {
            this.val = x;
            this.isEnd = false;
            childArray = new TrieNode[26];
        }
    }
}